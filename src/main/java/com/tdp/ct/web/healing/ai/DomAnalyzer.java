package com.tdp.ct.web.healing.ai;

import com.tdp.ct.web.healing.model.CandidateElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analizador de DOM con IA.
 * Genera candidatos alternativos automáticamente inspeccionando el DOM
 * a partir del localizador original y la semántica del nombre del elemento.
 */
public class DomAnalyzer {

    private static final Logger logger = Logger.getLogger(DomAnalyzer.class.getName());

    // -------------------------------------------------------------------------
    // API principal
    // -------------------------------------------------------------------------

    /**
     * Genera candidatos automáticamente analizando el DOM.
     *
     * @param driver          WebDriver activo
     * @param elementName     Nombre lógico del elemento (ej. "inputNameUser")
     * @param originalLocator Localizador original que falló
     * @return Lista de candidatos encontrados en el DOM
     */
    public List<CandidateElement> generateCandidates(WebDriver driver,
                                                      String elementName,
                                                      By originalLocator) {
        List<CandidateElement> candidates = new ArrayList<>();
        String locStr = originalLocator.toString();

        logger.info("╔══════════════════════════════════════════════════════════════");
        logger.info("║ 🤖 AI-Healing: Análisis automático del DOM");
        logger.info("║    Elemento     : " + elementName);
        logger.info("║    Localizador  : " + locStr);
        logger.info("╚══════════════════════════════════════════════════════════════");

        // Extraer información del localizador original
        String idValue          = extractById(locStr);
        String nameValue        = extractByName(locStr);
        String tagGuess         = inferTag(locStr, elementName);
        String xpathType        = extractXpathAttr(locStr, "type");
        String xpathClass       = extractXpathAttr(locStr, "class");
        String xpathPlaceholder = extractXpathAttr(locStr, "placeholder");

        // ── Estrategia 1: ID parcial ──────────────────────────────────────────
        if (idValue != null) {
            String partial = prefix(idValue, 5);
            tryAdd(driver, candidates,
                    By.xpath("//*[contains(@id, '" + partial + "')]"),
                    "partial-id[" + partial + "]", 2.0);
        }

        // ── Estrategia 2: Name parcial ────────────────────────────────────────
        if (nameValue != null) {
            String partial = prefix(nameValue, 5);
            tryAdd(driver, candidates,
                    By.xpath("//*[contains(@name, '" + partial + "')]"),
                    "partial-name[" + partial + "]", 1.8);
        }

        // ── Estrategia 3: Type + Tag ──────────────────────────────────────────
        if (xpathType != null) {
            String tag = tagGuess != null ? tagGuess : "*";
            tryAdd(driver, candidates,
                    By.xpath("//" + tag + "[@type='" + xpathType + "']"),
                    "tag-type[" + tag + "@type=" + xpathType + "]", 1.5);
        }

        // ── Estrategia 4: Placeholder ─────────────────────────────────────────
        if (xpathPlaceholder != null) {
            tryAdd(driver, candidates,
                    By.xpath("//*[contains(@placeholder, '" + xpathPlaceholder + "')]"),
                    "placeholder[" + xpathPlaceholder + "]", 1.6);
        }

        // ── Estrategia 5: CSS class ───────────────────────────────────────────
        if (xpathClass != null) {
            String firstCls = xpathClass.split("\\s+")[0];
            tryAdd(driver, candidates, By.cssSelector("." + firstCls),
                    "css-class[" + firstCls + "]", 1.2);
        }

        // ── Estrategia 6: Semántica del nombre del elemento ───────────────────
        for (String part : splitCamel(elementName)) {
            if (part.length() < 4) continue;
            String lp = part.toLowerCase();
            tryAdd(driver, candidates,
                    By.xpath("//*[" +
                        "contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + lp + "') or " +
                        "contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + lp + "') or " +
                        "contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + lp + "')]"),
                    "semantic[" + lp + "]", 1.4);
        }

        // ── Estrategia 7: Patrones semánticos conocidos ───────────────────────
        String lower = elementName.toLowerCase();

        if (lower.contains("user") || lower.contains("nombre") || lower.contains("name")) {
            tryAdd(driver, candidates,
                    By.xpath("//input[@type='text' or @type='email']"),
                    "input-text-or-email", 0.8);
            tryAdd(driver, candidates,
                    By.xpath("//input[contains(@placeholder,'user') or contains(@placeholder,'User') or " +
                             "contains(@placeholder,'nombre') or contains(@placeholder,'Nombre')]"),
                    "placeholder-username", 1.3);
        }
        if (lower.contains("password") || lower.contains("pass") || lower.contains("contra")) {
            tryAdd(driver, candidates,
                    By.xpath("//input[@type='password']"),
                    "password-input", 1.8);
        }
        if (lower.contains("btn") || lower.contains("button") || lower.contains("continue") || lower.contains("continuar")) {
            tryAdd(driver, candidates,
                    By.xpath("//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'continuar') or " +
                             "contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'continue')]"),
                    "btn-continuar", 1.4);
            tryAdd(driver, candidates,
                    By.xpath("//button[@type='submit']"),
                    "btn-submit", 0.9);
        }
        if (lower.contains("select") || lower.contains("tipo") || lower.contains("procedencia")) {
            tryAdd(driver, candidates,
                    By.xpath("//select"),
                    "select-element", 0.7);
        }
        if (lower.contains("error") || lower.contains("msg") || lower.contains("message") || lower.contains("captcha")) {
            tryAdd(driver, candidates,
                    By.xpath("//*[contains(@class,'error') or contains(@class,'alert') or contains(@class,'message')]"),
                    "error-message", 0.9);
        }

        logger.info("🤖 AI-Healing: Total de candidatos generados → " + candidates.size());
        return candidates;
    }

    // ── Método de compatibilidad hacia atrás ─────────────────────────────────
    public List<CandidateElement> generateCandidates(WebDriver driver, String text) {
        List<CandidateElement> result = new ArrayList<>();
        String safe = text.replace("'", "");
        for (WebElement e : driver.findElements(By.xpath("//*[contains(text(),'" + safe + "')]"))) {
            String id = e.getAttribute("id");
            if (id != null && !id.isEmpty())
                result.add(new CandidateElement(By.id(id)));
            result.add(new CandidateElement(
                    By.xpath("//" + e.getTagName() + "[contains(text(),'" + safe + "')]")));
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // Helpers internos
    // -------------------------------------------------------------------------

    private void tryAdd(WebDriver driver, List<CandidateElement> candidates,
                        By locator, String strategy, double basePriority) {
        try {
            List<WebElement> found = driver.findElements(locator);
            long visible = found.stream().filter(e -> {
                try { return e.isDisplayed(); } catch (Exception ex) { return false; }
            }).count();
            if (visible > 0) {
                logger.info("   ✔ [" + strategy + "] → " + visible + " visible(s) | " + locator);
                candidates.add(new CandidateElement(locator, strategy, (int) visible, basePriority));
            }
        } catch (Exception ignored) {}
    }

    private String extractById(String locStr) {
        Matcher m = Pattern.compile("By\\.id:\\s*(.+)", Pattern.CASE_INSENSITIVE).matcher(locStr);
        return m.find() ? m.group(1).trim() : null;
    }

    private String extractByName(String locStr) {
        Matcher m = Pattern.compile("By\\.name:\\s*(.+)", Pattern.CASE_INSENSITIVE).matcher(locStr);
        return m.find() ? m.group(1).trim() : null;
    }

    private String extractXpathAttr(String locStr, String attr) {
        Matcher m = Pattern.compile("@" + attr + "\\s*[=,]\\s*['\"]([^'\"]+)['\"]").matcher(locStr);
        return m.find() ? m.group(1) : null;
    }

    private String inferTag(String locStr, String elementName) {
        if (locStr.contains("//input"))  return "input";
        if (locStr.contains("//button")) return "button";
        if (locStr.contains("//select")) return "select";
        if (locStr.contains("//span"))   return "span";
        if (locStr.contains("//div"))    return "div";
        if (locStr.contains("//a["))     return "a";
        String ln = elementName.toLowerCase();
        if (ln.contains("input") || ln.contains("user") || ln.contains("pass")) return "input";
        if (ln.contains("btn") || ln.contains("button"))                         return "button";
        if (ln.contains("select") || ln.contains("dropdown"))                    return "select";
        return null;
    }

    private String[] splitCamel(String name) {
        return name.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");
    }

    private String prefix(String value, int len) {
        return value.length() <= len ? value : value.substring(0, len);
    }
}
