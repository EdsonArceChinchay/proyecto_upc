package com.tdp.ct.web.healing;

import com.tdp.ct.web.healing.ai.DomAnalyzer;
import com.tdp.ct.web.healing.metrics.HealingMetrics;
import com.tdp.ct.web.healing.model.CandidateElement;
import com.tdp.ct.web.healing.ranking.CandidateRanker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manager principal del sistema de Auto-Healing
 * Detecta y recupera automáticamente de fallos de localización de elementos
 */
public class AutoHealingManager {
    private static final Logger logger = Logger.getLogger(AutoHealingManager.class.getName());
    private static final Map<String, List<String>> locatorAlternatives = new ConcurrentHashMap<>();
    private static final Map<String, HealingResult> healingHistory = new ConcurrentHashMap<>();
    private static final int DEFAULT_TIMEOUT = 10;

    static {
        // Inicializa alternativas de localizadores comunes
        initializeDefaultAlternatives();
    }

    /**
     * Intenta encontrar un elemento con múltiples estrategias de recuperación
     * @param driver WebDriver actual
     * @param primaryLocator Localizador principal
     * @param elementName Nombre del elemento para identificación
     * @return WebElement encontrado
     */
    public static WebElement findElementWithHealing(WebDriver driver, By primaryLocator, String elementName) {
        try {
            // Intenta primero con el localizador principal
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
            return wait.until(ExpectedConditions.presenceOfElementLocated(primaryLocator));
        } catch (TimeoutException e) {
            logger.log(Level.WARNING, "Localizador principal falló para: " + elementName);
            return findElementWithAlternatives(driver, elementName, primaryLocator);
        }
    }


    /**
     * Busca usando localizadores alternativos registrados y, si no hay o fallan,
     * activa el motor de AI-Healing automático.
     */
    private static WebElement findElementWithAlternatives(WebDriver driver, String elementName, By primaryLocator) {
        List<String> alternatives = locatorAlternatives.getOrDefault(elementName, new ArrayList<>());

        // 1. Alternativas registradas manualmente (retrocompatibilidad)
        for (String alternativeXpath : alternatives) {
            try {
                By altLocator = By.xpath(alternativeXpath);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(altLocator));
                logHealing(elementName, alternativeXpath, true, primaryLocator.toString());
                logger.log(Level.INFO, "✓ Elemento recuperado con alternativa registrada: " + elementName);
                return element;
            } catch (TimeoutException e) {
                logger.log(Level.FINE, "Alternativa manual falló: " + alternativeXpath);
            }
        }

        // 2. Motor AI-Healing automático (sin necesidad de registrar candidatos a mano)
        logger.log(Level.INFO, "🤖 Activando AI-Healing automático para: " + elementName);
        WebElement aiElement = aiHealing(driver, elementName, primaryLocator);
        if (aiElement != null) {
            return aiElement;
        }

        // 3. Estrategias dinámicas de fallback
        return applyDynamicHealing(driver, elementName, primaryLocator);
    }


    /**
     * Applica estrategias dinámicas de recuperación
     */
    private static WebElement applyDynamicHealing(WebDriver driver, String elementName, By primaryLocator) {
        logger.log(Level.INFO, "Aplicando estrategias dinámicas de healing para: " + elementName);

        // Estrategia 1: Intenta hacer scroll
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);
            WebElement element = driver.findElement(primaryLocator);
            logHealing(elementName, "After Scroll", true, primaryLocator.toString());
            logger.log(Level.INFO, "✓ Elemento recuperado después de scroll: " + elementName);
            return element;
        } catch (Exception e) {
            logger.log(Level.FINE, "Healing por scroll falló");
        }

        // Estrategia 2: Intenta esperar a que sea clickeable
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(primaryLocator));
            logHealing(elementName, "Element Clickable", true, primaryLocator.toString());
            logger.log(Level.INFO, "✓ Elemento recuperado esperando clickeable: " + elementName);
            return element;
        } catch (TimeoutException e) {
            logger.log(Level.FINE, "Healing por clickeable falló");
        }

        // Estrategia 3: Intenta con atributo parcial
        try {
            String idPart = extractIdPart(elementName);
            List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@id, '" + idPart + "')]"));
            if (!elements.isEmpty()) {
                logHealing(elementName, "Partial ID Match", true, primaryLocator.toString());
                logger.log(Level.INFO, "✓ Elemento recuperado con coincidencia parcial: " + elementName);
                return elements.get(0);
            }
        } catch (Exception e) {
            logger.log(Level.FINE, "Healing por partial ID falló");
        }

        // Estrategia 4: Intenta esperar a visibilidad
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(primaryLocator));
            logHealing(elementName, "Visibility Wait", true, primaryLocator.toString());
            logger.log(Level.INFO, "✓ Elemento recuperado esperando visibilidad: " + elementName);
            return element;
        } catch (TimeoutException e) {
            logger.log(Level.FINE, "Healing por visibilidad falló");
        }

        logHealing(elementName, "FAILED", false, primaryLocator.toString());
        String errorMsg = "No se pudo recuperar elemento: " + elementName + " | Localizador: " + primaryLocator;
        logger.log(Level.SEVERE, "✗ " + errorMsg);
        throw new NoSuchElementException(errorMsg);
    }

    /**
     * Registra un resultado de healing en el histórico
     */
    private static void logHealing(String elementName, String strategy, boolean success, String originalLocator) {
        HealingResult result = new HealingResult(elementName, strategy, success, originalLocator, System.currentTimeMillis());
        healingHistory.put(elementName + "_" + System.nanoTime(), result);

        String message = String.format("HEALING [%s] - Element: %s, Strategy: %s",
            success ? "✓ SUCCESS" : "✗ FAILED", elementName, strategy);
        logger.log(success ? Level.INFO : Level.SEVERE, message);
    }

    /**
     * Registra alternativas para un elemento
     */
    public static void registerAlternative(String elementName, String xpathAlternative) {
        locatorAlternatives.computeIfAbsent(elementName, k -> new CopyOnWriteArrayList<>()).add(xpathAlternative);
        logger.log(Level.FINE, "Alternativa registrada para " + elementName + ": " + xpathAlternative);
    }

    /**
     * Obtiene el histórico de healing
     */
    public static Map<String, HealingResult> getHealingHistory() {
        return new HashMap<>(healingHistory);
    }

    /**
     * Obtiene estadísticas de healing
     */
    public static HealingStatistics getStatistics() {
        HealingMetrics metrics = new HealingMetrics();
        healingHistory.values().forEach(result -> metrics.add(result.isSuccess()));
        return new HealingStatistics(metrics.getDetected(), metrics.getRepaired(),
                metrics.getDetected() - metrics.getRepaired());
    }

    /**
     * Limpia el histórico de healing (útil entre tests)
     */
    public static void clearHistory() {
        healingHistory.clear();
        logger.log(Level.INFO, "Histórico de healing limpiado");
    }


    /**
     * Motor AI: analiza el DOM automáticamente, genera candidatos, los rankea
     * y los intenta en orden de mayor a menor score hasta encontrar uno accesible.
     */
    private static WebElement aiHealing(WebDriver driver, String elementName, By primaryLocator) {
        return aiHealing(driver, elementName, primaryLocator, false);
    }

    private static WebElement aiHealing(WebDriver driver, String elementName, By primaryLocator, boolean useXGBoost) {
        List<CandidateElement> candidates =
                new DomAnalyzer().generateCandidates(driver, elementName, primaryLocator);

        if (candidates.isEmpty()) {
            logger.info("🤖 AI-Healing: No se encontraron candidatos en el DOM para '" + elementName + "'");
            return null;
        }

        List<CandidateElement> ranked =
                 new CandidateRanker().rankAll(candidates);

        int topCandidatesToLog = Math.min(3, ranked.size());
        StringBuilder topCandidatesLog = new StringBuilder("🤖 AI-Healing: Top ")
                .append(topCandidatesToLog)
                .append(" candidatos para '")
                .append(elementName)
                .append("': ");
        for (int i = 0; i < topCandidatesToLog; i++) {
            CandidateElement candidate = ranked.get(i);
            topCandidatesLog.append("#")
                    .append(i + 1)
                    .append(" [")
                    .append(candidate.getStrategy())
                    .append("] ")
                    .append(candidate.getLocator())
                    .append(" (score=")
                    .append(String.format("%.3f", candidate.getScore()))
                    .append(")");
            if (i < topCandidatesToLog - 1) {
                topCandidatesLog.append(" | ");
            }
        }
        logger.info(topCandidatesLog.toString());

        for (int i = 0; i < ranked.size(); i++) {
            CandidateElement candidate = ranked.get(i);
            int position = i + 1;

            // Umbral mínimo de confianza (score normalizado 0-1)
            if (candidate.getScore() < 0.35) {
                logger.warning("🤖 AI-Healing: Candidato #" + position +
                        " [" + candidate.getStrategy() + "] descartado por score bajo (" +
                        String.format("%.3f", candidate.getScore()) + "). Probando el siguiente candidato.");
                continue;
            }

            logger.info("🤖 AI-Healing: Intentando candidato #" + position + "/" + ranked.size() +
                    " → [" + candidate.getStrategy() + "] " + candidate.getLocator() +
                    " (score=" + String.format("%.3f", candidate.getScore()) + ")");

            try {
                WebElement element = driver.findElement(candidate.getLocator());
                logHealing(elementName,
                        "AI-Healing #" + position + " [" + candidate.getStrategy() + "] score=" +
                        String.format("%.3f", candidate.getScore()),
                        true, primaryLocator.toString());
                logger.info("✅ AI-Healing: Elemento '" + elementName +
                        "' recuperado con candidato #" + position +
                        " → [" + candidate.getStrategy() + "]");
                return element;
            } catch (Exception e) {
                logger.warning("🤖 AI-Healing: Candidato #" + position +
                        " [" + candidate.getStrategy() + "] falló → " + e.getMessage() +
                        ". Probando siguiente candidato...");
            }
        }

        logger.severe("🤖 AI-Healing: Todos los candidatos agotados para '" + elementName + "'.");
        return null;
    }

    private static void initializeDefaultAlternatives() {
        // Alternativas predefinidas para elementos comunes
        registerAlternative("loginButton", "//*[contains(@class, 'btn-login')]");
        registerAlternative("loginButton", "//button[@type='submit']");
        registerAlternative("loginButton", "//*[@role='button' and contains(text(), 'Iniciar')]");
    }

    private static String extractIdPart(String elementName) {
        return elementName.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Clase para almacenar resultados de healing
     */
    public static class HealingResult {
        private final String elementName;
        private final String strategy;
        private final boolean success;
        private final String originalLocator;
        private final long timestamp;

        public HealingResult(String elementName, String strategy, boolean success, String originalLocator, long timestamp) {
            this.elementName = elementName;
            this.strategy = strategy;
            this.success = success;
            this.originalLocator = originalLocator;
            this.timestamp = timestamp;
        }

        public String getElementName() { return elementName; }
        public String getStrategy() { return strategy; }
        public boolean isSuccess() { return success; }
        public String getOriginalLocator() { return originalLocator; }
        public long getTimestamp() { return timestamp; }

        @Override
        public String toString() {
            return String.format("HealingResult{element='%s', strategy='%s', success=%b, timestamp=%d}",
                elementName, strategy, success, timestamp);
        }
    }

    /**
     * Clase para almacenar estadísticas de healing
     */
    public static class HealingStatistics {
        private final int total;
        private final int successful;
        private final int failed;

        public HealingStatistics(int total, int successful, int failed) {
            this.total = total;
            this.successful = successful;
            this.failed = failed;
        }

        public int getTotal() { return total; }
        public int getSuccessful() { return successful; }
        public int getFailed() { return failed; }
        public double getSuccessRate() {
            return total == 0 ? 0 : (double) successful / total * 100;
        }
        public double getAHSR() { return getSuccessRate(); }

        @Override
        public String toString() {
            return String.format(
                "=== HEALING STATISTICS ===\nTotal: %d | Successful: %d | Failed: %d | Success Rate: %.2f%%",
                total, successful, failed, getSuccessRate()
            );
        }
    }
}
