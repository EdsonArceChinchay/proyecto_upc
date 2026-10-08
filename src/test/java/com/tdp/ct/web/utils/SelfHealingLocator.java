package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
 * type, placeholder, aria-label, autocomplete) con el rol esperado del campo,
 * para así identificar cuál es el campo correcto en el DOM actual.
 * <p>
 * Una vez identificado ESE campo (y solo ese, no otros campos del formulario),
 * se generan hasta 3 <b>estrategias de localizador</b> distintas para
 * encontrarlo (por id, por name, por placeholder/aria-label/autocomplete, por
 * type), cada una con su propio puntaje de robustez. Se usa la más robusta, y
 * todo el resultado (si el localizador cambió o no, y las 3 estrategias
 * evaluadas para ese campo con sus puntajes) se adjunta al reporte de
 * Cucumber en el paso correspondiente para que quede visible al revisar la
 * ejecución.
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
        final String strategy;

        Candidate(By locator, String description, int score, String strategy) {
            this.locator = locator;
            this.description = description;
            this.score = score;
            this.strategy = strategy;
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

        // 1) Identifica, entre TODOS los inputs visibles, cuál es el que corresponde a este
        //    campo (rol) específico. No se mezclan candidatos de otros campos del formulario.
        WebElement target = findBestElementForRole(driver, role);

        if (target == null) {
            report(fieldLabel, originalLocator, null, Collections.emptyList(), true);
            throw new NoSuchElementException(
                    "[SELF-HEALING] No se encontró ningún candidato viable para el campo '" + fieldLabel + "'");
        }

        // 2) Para ESE único campo, genera hasta 3 estrategias distintas de localizarlo
        //    (por id, por name, por placeholder/aria-label/autocomplete, por type), ordenadas
        //    de la más robusta a la menos robusta.
        List<Candidate> strategies = buildLocatorStrategies(target);

        if (strategies.isEmpty()) {
            report(fieldLabel, originalLocator, null, Collections.emptyList(), true);
            throw new NoSuchElementException(
                    "[SELF-HEALING] No se pudo construir ningún localizador para el campo '" + fieldLabel + "'");
        }

        Candidate best = strategies.get(0);
        report(fieldLabel, originalLocator, best, strategies, true);
        logInfo(String.format("[SELF-HEALING] Campo '%s' reparado -> nuevo localizador: %s (%s, confianza %d%%)",
                fieldLabel, best.locator, best.strategy, best.score));

        return driver.findElement(best.locator);
    }

    /**
     * Igual que {@link #resolve} pero para botones: si el localizador original falla,
     * busca entre los botones visibles el que mejor coincida con las palabras clave
     * (texto, id, aria-label, clase) y genera estrategias de localizador alternativas.
     */
    public static WebElement resolveButton(WebDriver driver, By originalLocator, String fieldLabel) {
        List<String> keywords = Arrays.stream(fieldLabel.toLowerCase(Locale.ROOT).split("[^\\p{L}\\p{N}]+"))
                .filter(w -> w.length() >= 4)
                .collect(Collectors.toList());
        WebElement original = safeFindFirst(driver, originalLocator);
        if (original != null && isUsable(original)) {
            report(fieldLabel, originalLocator, null, Collections.emptyList(), false);
            return original;
        }

        logInfo(String.format("[SELF-HEALING] Localizador original de '%s' no encontrado o no usable (%s). "
                + "Buscando reemplazo...", fieldLabel, originalLocator));

        WebElement target = findBestButton(driver, keywords);
        List<Candidate> strategies = target == null
                ? Collections.emptyList() : buildButtonStrategies(target);

        if (strategies.isEmpty()) {
            report(fieldLabel, originalLocator, null, Collections.emptyList(), true);
            throw new NoSuchElementException(
                    "[SELF-HEALING] No se encontró ningún botón viable para '" + fieldLabel + "'");
        }

        Candidate best = strategies.get(0);
        report(fieldLabel, originalLocator, best, strategies, true);
        logInfo(String.format("[SELF-HEALING] Botón '%s' reparado -> nuevo localizador: %s (%s, confianza %d%%)",
                fieldLabel, best.locator, best.strategy, best.score));
        return driver.findElement(best.locator);
    }

    private static WebElement findBestButton(WebDriver driver, List<String> keywords) {
        List<WebElement> buttons;
        try {
            buttons = driver.findElements(By.cssSelector(
                    "button, app-simple-button, [role='button'], input[type='button'], input[type='submit']"));
        } catch (Exception e) {
            return null;
        }

        WebElement best = null;
        int bestScore = 0;
        for (WebElement button : buttons) {
            try {
                if (!button.isDisplayed()) {
                    continue;
                }
                int score = keywordScore(button.getText().trim().toLowerCase(Locale.ROOT), keywords) * 50
                        + keywordScore(safeAttr(button, "id").toLowerCase(Locale.ROOT), keywords) * 20
                        + keywordScore(safeAttr(button, "aria-label").toLowerCase(Locale.ROOT), keywords) * 20
                        + keywordScore(safeAttr(button, "label").toLowerCase(Locale.ROOT), keywords) * 20
                        + keywordScore(safeAttr(button, "class").toLowerCase(Locale.ROOT), keywords) * 10;
                if (score > bestScore) {
                    bestScore = score;
                    best = button;
                }
            } catch (Exception ignored) {
                // Elemento "stale" al leer atributos: se descarta.
            }
        }
        return best;
    }

    private static List<Candidate> buildButtonStrategies(WebElement element) {
        String tag = element.getTagName();
        String text = safeText(element);
        String description = String.format("<%s id='%s' text='%s'>", tag, safeAttr(element, "id"), text);
        List<Candidate> strategies = new ArrayList<>();

        String id = safeAttr(element, "id");
        if (!id.isEmpty()) {
            strategies.add(new Candidate(By.id(id), description, 95, "por id"));
        }
        if (!text.isEmpty() && !text.contains("'")) {
            strategies.add(new Candidate(By.xpath(String.format("//%s[normalize-space(.)='%s']", tag, text)),
                    description, 75, "por texto"));
        }
        String ariaLabel = safeAttr(element, "aria-label");
        if (!ariaLabel.isEmpty() && !ariaLabel.contains("'")) {
            strategies.add(new Candidate(By.cssSelector(String.format("%s[aria-label='%s']", tag, ariaLabel)),
                    description, 60, "por aria-label"));
        }
        String cssClass = safeAttr(element, "class").trim();
        if (!cssClass.isEmpty()) {
            strategies.add(new Candidate(By.cssSelector(tag + "." + cssClass.split("\\s+")[0]),
                    description, 30, "por clase"));
        }

        return strategies.stream()
                .sorted((a, b) -> Integer.compare(b.score, a.score))
                .limit(3)
                .collect(Collectors.toList());
    }

    private static String safeText(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Resuelve una opción dentro de una lista por su texto. Intenta primero los elementos
     * del localizador original cuyo texto coincida; si no hay, busca entre los elementos
     * visibles (li, button, a, label, option, div hoja) uno cuyo texto coincida y propone
     * localizadores alternativos (por texto exacto, por texto contenido).
     */
    public static WebElement resolveListOption(WebDriver driver, By originalListLocator, String optionText,
                                               String fieldLabel) {
        String wanted = normalize(optionText);
        try {
            for (WebElement e : driver.findElements(originalListLocator)) {
                if (isUsable(e) && normalize(e.getText()).contains(wanted)) {
                    report(fieldLabel, originalListLocator, null, Collections.emptyList(), false);
                    return e;
                }
            }
        } catch (Exception ignored) {
            // Se continúa con el self-healing.
        }

        logInfo(String.format("[SELF-HEALING] Opción '%s' no encontrada con %s. Buscando reemplazo...",
                optionText, originalListLocator));

        WebElement target = null;
        int bestLength = Integer.MAX_VALUE;
        try {
            for (WebElement e : driver.findElements(By.cssSelector("li, button, a, label, option, div, span, p"))) {
                try {
                    String text = normalize(e.getText());
                    // El más corto que contenga el texto es el elemento más específico.
                    if (e.isDisplayed() && text.contains(wanted) && text.length() < bestLength) {
                        bestLength = text.length();
                        target = e;
                    }
                } catch (Exception ignored) {
                    // Elemento "stale": se descarta.
                }
            }
        } catch (Exception ignored) {
            // Sin candidatos.
        }

        if (target == null || optionText.contains("'")) {
            report(fieldLabel, originalListLocator, null, Collections.emptyList(), true);
            throw new NoSuchElementException(
                    "[SELF-HEALING] No se encontró la opción '" + optionText + "' para '" + fieldLabel + "'");
        }

        String tag = target.getTagName();
        String description = String.format("<%s text='%s'>", tag, safeText(target));
        List<Candidate> strategies = new ArrayList<>();
        strategies.add(new Candidate(By.xpath(String.format("//%s[normalize-space(.)='%s']", tag, safeText(target).replace("'", ""))),
                description, 80, "por texto exacto"));
        strategies.add(new Candidate(By.xpath(String.format("//%s[contains(normalize-space(.),'%s')]", tag, optionText)),
                description, 60, "por texto contenido"));

        Candidate best = strategies.get(0);
        report(fieldLabel, originalListLocator, best, strategies, true);
        logInfo(String.format("[SELF-HEALING] Opción '%s' reparada -> %s", optionText, best.locator));
        return target;
    }

    private static String normalize(String s) {
        return s == null ? "" : s.replaceAll("\\s+", " ").trim().toLowerCase(Locale.ROOT);
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

    /**
     * Busca, entre todos los {@code <input>} visibles de la página, el único elemento
     * que mejor corresponde al rol solicitado (usuario o contraseña). No retorna una lista
     * de candidatos de distintos campos: identifica CUÁL es el campo correcto para poder
     * luego generar, solo para ese campo, las distintas estrategias de localizador.
     */
    private static WebElement findBestElementForRole(WebDriver driver, FieldRole role) {
        List<WebElement> inputs;
        try {
            inputs = driver.findElements(By.cssSelector("input"));
        } catch (Exception e) {
            return null;
        }

        WebElement best = null;
        int bestScore = 0;
        for (WebElement input : inputs) {
            try {
                if (!input.isDisplayed()) {
                    continue;
                }
                int score = scoreElement(input, role);
                if (score > bestScore) {
                    bestScore = score;
                    best = input;
                }
            } catch (Exception ignored) {
                // Elemento "stale" u otro problema puntual al leer atributos: se descarta ese candidato.
            }
        }
        return bestScore > 0 ? best : null;
    }

    /**
     * Genera hasta 3 estrategias distintas de localizador para UN MISMO elemento
     * (el campo ya identificado por {@link #findBestElementForRole}), ordenadas de la
     * más robusta a la menos robusta: por id, por name, por placeholder, por aria-label,
     * por autocomplete y, como último recurso, por type.
     */
    private static List<Candidate> buildLocatorStrategies(WebElement element) {
        String description = describeElement(element);
        List<Candidate> strategies = new ArrayList<>();

        String id = safeAttr(element, "id");
        if (!id.isEmpty()) {
            strategies.add(new Candidate(By.id(id), description, 95, "por id"));
        }
        String name = safeAttr(element, "name");
        if (!name.isEmpty()) {
            strategies.add(new Candidate(By.name(name), description, 80, "por name"));
        }
        String placeholder = safeAttr(element, "placeholder");
        if (!placeholder.isEmpty()) {
            strategies.add(new Candidate(By.cssSelector(String.format("input[placeholder='%s']", placeholder)),
                    description, 65, "por placeholder"));
        }
        String ariaLabel = safeAttr(element, "aria-label");
        if (!ariaLabel.isEmpty()) {
            strategies.add(new Candidate(By.cssSelector(String.format("input[aria-label='%s']", ariaLabel)),
                    description, 60, "por aria-label"));
        }
        String autocomplete = safeAttr(element, "autocomplete");
        if (!autocomplete.isEmpty()) {
            strategies.add(new Candidate(By.cssSelector(String.format("input[autocomplete='%s']", autocomplete)),
                    description, 55, "por autocomplete"));
        }
        String type = safeAttr(element, "type");
        if (!type.isEmpty()) {
            strategies.add(new Candidate(By.cssSelector(String.format("input[type='%s']", type)),
                    description, 30, "por type"));
        }

        return strategies.stream()
                .sorted((a, b) -> Integer.compare(b.score, a.score))
                .limit(3)
                .collect(Collectors.toList());
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
                    .append("</code> (").append(escape(chosen.strategy)).append(", confianza ").append(chosen.score).append("%)");
        }

        if (!evaluatedCandidates.isEmpty()) {
            html.append("<br/><table style='border-collapse:collapse; margin-top:4px;'>");
            html.append("<tr><th style='border:1px solid #ccc; padding:2px 6px;'>#</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Campo detectado</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Estrategia</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Localizador propuesto</th>")
                    .append("<th style='border:1px solid #ccc; padding:2px 6px;'>Puntaje</th></tr>");
            for (int i = 0; i < evaluatedCandidates.size(); i++) {
                Candidate c = evaluatedCandidates.get(i);
                html.append("<tr><td style='border:1px solid #ccc; padding:2px 6px;'>").append(i + 1).append("</td>")
                        .append("<td style='border:1px solid #ccc; padding:2px 6px;'>").append(escape(c.description)).append("</td>")
                        .append("<td style='border:1px solid #ccc; padding:2px 6px;'>").append(escape(c.strategy)).append("</td>")
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
