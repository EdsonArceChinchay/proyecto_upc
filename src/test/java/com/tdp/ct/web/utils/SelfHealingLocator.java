package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

/**
 * Motor heurístico de auto-reparación (self-healing) para localizadores de
 * campos críticos del login (usuario y contraseña).
 * <p>
 * Cuando el localizador original de un campo ya no encuentra el elemento
 * (por ejemplo, porque cambió un id/name en el HTML), este componente escanea
 * todos los {@code <input>} visibles de la página y les asigna un puntaje de
 * confianza (0-100) según qué tan bien coinciden sus atributos (id, name,
 * type, placeholder, aria-label, autocomplete) con el rol esperado del campo.
 * Se seleccionan los 3 mejores candidatos, se usa el de mayor puntaje, y todo
 * el resultado (si el localizador cambió o no, candidatos evaluados y sus
 * puntajes) se adjunta al reporte de Cucumber para que quede visible al
 * revisar la ejecución.
 */
public final class SelfHealingLocator {

    private SelfHealingLocator() {
    }

    /** Rol esperado del campo, usado para puntuar qué tan bien encaja cada candidato. */
    public enum FieldRole {
        USERNAME(
                List.of("user", "usuario", "login", "signin", "sign-in", "email", "correo", "documento", "dni"),
                List.of("text", "email", "tel")
        ),
        PASSWORD(
                List.of("pass", "password", "contrasen", "clave", "pwd"),
                List.of("password")
        );

        final List<String> keywords;
        final List<String> preferredTypes;

        FieldRole(List<String> keywords, List<String> preferredTypes) {
            this.keywords = keywords;
            this.preferredTypes = preferredTypes;
        }
    }

    /** Un localizador candidato propuesto por el heurístico, con su puntaje de confianza. */
    private static final class Candidate {
        final By locator;
        final String description;
        final int score;

        Candidate(By locator, String description, int score) {
            this.locator = locator;
            this.description = description;
            this.score = score;
        }
    }

    /**
     * Resuelve el {@link WebElement} de un campo. Intenta primero el
     * localizador original; si no lo encuentra o no es usable, ejecuta el
     * auto-healing heurístico y retorna el mejor candidato encontrado.
     * Siempre reporta el resultado (sano o reparado) en el reporte Cucumber.
     *
     * @param driver          WebDriver activo
     * @param originalLocator localizador original del campo
     * @param fieldLabel      nombre descriptivo del campo (para logs/reporte)
     * @param role            rol esperado del campo (USERNAME o PASSWORD)
     * @return el WebElement encontrado (original o reparado)
     */
    public static WebElement resolve(WebDriver driver, By originalLocator, String fieldLabel, FieldRole role) {
        WebElement original = safeFindFirst(driver, originalLocator);
        if (original != null && isUsable(original)) {
            report(fieldLabel, originalLocator, null, Collections.emptyList(), false);
            return original;
        }

        logInfo(String.format("[SELF-HEALING] Localizador original de '%s' no encontrado o no usable (%s). "
                + "Buscando reemplazo...", fieldLabel, originalLocator));

        List<Candidate> top3 = scoreCandidates(driver, role).stream()
                .sorted((a, b) -> Integer.compare(b.score, a.score))
                .limit(3)
                .collect(Collectors.toList());

        if (top3.isEmpty() || top3.get(0).score <= 0) {
            report(fieldLabel, originalLocator, null, top3, true);
            throw new NoSuchElementException(
                    "[SELF-HEALING] No se encontró ningún candidato viable para el campo '" + fieldLabel + "'");
        }

        Candidate best = top3.get(0);
        report(fieldLabel, originalLocator, best, top3, true);
        logInfo(String.format("[SELF-HEALING] Campo '%s' reparado -> nuevo localizador: %s (confianza %d%%)",
                fieldLabel, best.locator, best.score));

        return driver.findElement(best.locator);
    }

    private static WebElement safeFindFirst(WebDriver driver, By locator) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            return elements.isEmpty() ? null : elements.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isUsable(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    private static List<Candidate> scoreCandidates(WebDriver driver, FieldRole role) {
        List<WebElement> inputs;
        try {
            inputs = driver.findElements(By.cssSelector("input"));
        } catch (Exception e) {
            return Collections.emptyList();
        }

        List<Candidate> candidates = new ArrayList<>();
        for (WebElement input : inputs) {
            try {
                if (!input.isDisplayed()) {
                    continue;
                }
                By by = buildLocatorFor(input);
                if (by == null) {
                    continue;
                }
                int score = scoreElement(input, role);
                candidates.add(new Candidate(by, describeElement(input), score));
            } catch (Exception ignored) {
                // Elemento "stale" u otro problema puntual al leer atributos: se descarta ese candidato.
            }
        }
        return candidates;
    }

    private static int scoreElement(WebElement input, FieldRole role) {
        int score = 0;
        String type = safeAttr(input, "type").toLowerCase(Locale.ROOT);
        String id = safeAttr(input, "id").toLowerCase(Locale.ROOT);
        String name = safeAttr(input, "name").toLowerCase(Locale.ROOT);
        String placeholder = safeAttr(input, "placeholder").toLowerCase(Locale.ROOT);
        String ariaLabel = safeAttr(input, "aria-label").toLowerCase(Locale.ROOT);
        String autocomplete = safeAttr(input, "autocomplete").toLowerCase(Locale.ROOT);

        if (role.preferredTypes.contains(type)) {
            score += 40;
        }

        score += keywordScore(id, role.keywords) * 20;
        score += keywordScore(name, role.keywords) * 15;
        score += keywordScore(placeholder, role.keywords) * 10;
        score += keywordScore(ariaLabel, role.keywords) * 10;
        score += keywordScore(autocomplete, role.keywords) * 5;

        if (role == FieldRole.USERNAME && (autocomplete.contains("username") || autocomplete.contains("email"))) {
            score += 15;
        }
        if (role == FieldRole.PASSWORD && autocomplete.contains("password")) {
            score += 15;
        }

        // Penaliza fuertemente incompatibilidades claras de tipo con el rol esperado.
        if (role == FieldRole.PASSWORD && !type.isEmpty() && !type.equals("password") && !type.equals("text")) {
            score -= 30;
        }
        if (role == FieldRole.USERNAME && type.equals("password")) {
            score -= 60;
        }

        return Math.max(0, Math.min(100, score));
    }

    private static int keywordScore(String attributeValue, List<String> keywords) {
        if (attributeValue == null || attributeValue.isEmpty()) {
            return 0;
        }
        for (String keyword : keywords) {
            if (attributeValue.contains(keyword)) {
                return 1;
            }
        }
        return 0;
    }

    private static String safeAttr(WebElement element, String attr) {
        try {
            String value = element.getAttribute(attr);
            return value == null ? "" : value;
        } catch (Exception e) {
            return "";
        }
    }

    private static By buildLocatorFor(WebElement element) {
        String id = safeAttr(element, "id");
        if (!id.isEmpty()) {
            return By.id(id);
        }
        String name = safeAttr(element, "name");
        if (!name.isEmpty()) {
            return By.name(name);
        }
        String placeholder = safeAttr(element, "placeholder");
        if (!placeholder.isEmpty()) {
            return By.cssSelector(String.format("input[placeholder='%s']", placeholder));
        }
        String type = safeAttr(element, "type");
        if (!type.isEmpty()) {
            return By.cssSelector(String.format("input[type='%s']", type));
        }
        return null;
    }

    private static String describeElement(WebElement element) {
        return String.format("<input id='%s' name='%s' type='%s' placeholder='%s'>",
                safeAttr(element, "id"), safeAttr(element, "name"),
                safeAttr(element, "type"), safeAttr(element, "placeholder"));
    }

    private static void report(String fieldLabel, By originalLocator, Candidate chosen,
                                List<Candidate> evaluatedCandidates, boolean healingTriggered) {
        StringBuilder html = new StringBuilder();
        html.append("<div style='font-family:monospace; font-size:12px; border:1px solid #ccc; padding:8px; margin:4px 0;'>");
        html.append("<b>🔧 Self-Healing Locator — campo: ").append(escape(fieldLabel)).append("</b><br/>");
        html.append("Localizador original: <code>").append(escape(String.valueOf(originalLocator))).append("</code><br/>");

        if (!healingTriggered) {
            html.append("Estado: <span style='color:green;'>✅ Localizador original funcionó correctamente (sin cambios)</span>");
        } else if (chosen == null) {
            html.append("Estado: <span style='color:red;'>❌ No se encontró ningún reemplazo viable</span>");
        } else {
            html.append("Estado: <span style='color:#b8860b;'>⚠️ Localizador reparado automáticamente</span><br/>");
            html.append("Nuevo localizador usado: <code>").append(escape(String.valueOf(chosen.locator)))
                    .append("</code> (confianza ").append(chosen.score).append("%)");
        }

        if (!evaluatedCandidates.isEmpty()) {
            html.append("<br/><table style='border-collapse:collapse; margin-top:4px;'>");
            html.append("<tr><th style='border:1px solid #ccc; padding:2px 6px;'>#</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Candidato</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Localizador propuesto</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Puntaje</th></tr>");
            for (int i = 0; i < evaluatedCandidates.size(); i++) {
                Candidate c = evaluatedCandidates.get(i);
                html.append("<tr><td style='border:1px solid #ccc; padding:2px 6px;'>").append(i + 1).append("</td>")
                        .append("<td style='border:1px solid #ccc; padding:2px 6px;'>").append(escape(c.description)).append("</td>")
                        .append("<td style='border:1px solid #ccc; padding:2px 6px;'>").append(escape(String.valueOf(c.locator))).append("</td>")
                        .append("<td style='border:1px solid #ccc; padding:2px 6px;'>").append(c.score).append("%</td></tr>");
            }
            html.append("</table>");
        }
        html.append("</div>");

        try {
            Scenario scenario = new ManageScenario().getScenario();
            if (scenario != null) {
                scenario.attach(html.toString().getBytes(StandardCharsets.UTF_8),
                        "text/html", "Self-Healing: " + fieldLabel);
            }
        } catch (Exception e) {
            logInfo("[SELF-HEALING] No se pudo adjuntar el reporte al escenario: " + e.getMessage());
        }

        logInfo("[SELF-HEALING] " + fieldLabel + " -> healingTriggered=" + healingTriggered
                + (chosen != null ? (", nuevoLocalizador=" + chosen.locator + ", score=" + chosen.score) : ""));
    }

    private static String escape(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
