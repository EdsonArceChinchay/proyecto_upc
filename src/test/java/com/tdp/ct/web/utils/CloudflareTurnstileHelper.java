package com.tdp.ct.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interacción con Cloudflare Turnstile (shadow-root cerrado + iframe).
 * Compatible Java 11.
 */
public final class CloudflareTurnstileHelper {

    private static final int[] CHECKBOX_OFFSETS_X = {16, 20, 24};

    private CloudflareTurnstileHelper() {
    }

    public static boolean waitUntilWidgetReady(WebDriver driver, int timeoutSeconds) {
        WebDriver realDriver = WebDriverErrorDecorator.unwrap(driver);
        if (!(realDriver instanceof HasCdp)) {
            LogUtils.logSevere("CDP no disponible; no se puede esperar Turnstile por DOM pierced");
            return false;
        }

        HasCdp cdpDriver = (HasCdp) realDriver;
        long deadline = System.currentTimeMillis() + (timeoutSeconds * 1000L);
        while (System.currentTimeMillis() < deadline) {
            try {
                if (isTurnstileWidgetReady(cdpDriver)) {
                    LogUtils.logInfo("Cloudflare Turnstile listo (checkbox detectado en iframe)");
                    return true;
                }
            } catch (Exception e) {
                LogUtils.logInfo("Turnstile aún inicializando: " + e.getMessage());
            }
            pause(500);
        }

        LogUtils.logSevere("Cloudflare Turnstile no alcanzó estado listo en " + timeoutSeconds + "s");
        return false;
    }

    @SuppressWarnings("unchecked")
    private static boolean isTurnstileWidgetReady(HasCdp cdpDriver) {
        Map<String, Object> docParams = new HashMap<String, Object>();
        docParams.put("depth", -1);
        docParams.put("pierce", true);

        Map<String, Object> document = cdpDriver.executeCdpCommand("DOM.getDocument", docParams);
        Map<String, Object> root = (Map<String, Object>) document.get("root");

        Integer iframeNodeId = findCloudflareIframeNodeId(root);
        if (iframeNodeId == null) {
            return false;
        }

        List<Number> quad = readContentQuad(cdpDriver, iframeNodeId);
        if (quad == null || quad.size() < 8) {
            return false;
        }

        double width = Math.abs(quad.get(2).doubleValue() - quad.get(0).doubleValue());
        double height = Math.abs(quad.get(7).doubleValue() - quad.get(1).doubleValue());
        if (width < 200 || height < 40) {
            return false;
        }

        return containsTurnstileCheckbox(root);
    }

    @SuppressWarnings("unchecked")
    private static boolean containsTurnstileCheckbox(Map<String, Object> node) {
        if (node == null) {
            return false;
        }

        String nodeName = String.valueOf(node.get("nodeName"));
        if ("INPUT".equalsIgnoreCase(nodeName)) {
            List<String> attributes = (List<String>) node.get("attributes");
            if (attributes != null) {
                for (int i = 0; i < attributes.size() - 1; i += 2) {
                    if ("type".equalsIgnoreCase(attributes.get(i))
                            && "checkbox".equalsIgnoreCase(attributes.get(i + 1))) {
                        return true;
                    }
                }
            }
        }

        List<Map<String, Object>> children = (List<Map<String, Object>>) node.get("children");
        if (children != null) {
            for (Map<String, Object> child : children) {
                if (containsTurnstileCheckbox(child)) {
                    return true;
                }
            }
        }

        List<Map<String, Object>> shadowRoots = (List<Map<String, Object>>) node.get("shadowRoots");
        if (shadowRoots != null) {
            for (Map<String, Object> shadowRoot : shadowRoots) {
                if (containsTurnstileCheckbox(shadowRoot)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean tryClickCheckbox(WebDriver driver, int attempt) {
        WebDriver realDriver = WebDriverErrorDecorator.unwrap(driver);
        int offsetIndex = Math.min(Math.max(attempt, 1), CHECKBOX_OFFSETS_X.length) - 1;
        int offsetX = CHECKBOX_OFFSETS_X[offsetIndex];

        LogUtils.logInfo("Intentando click en checkbox Turnstile (shadow-root cerrado), offset X=" + offsetX);

        if (realDriver instanceof HasCdp) {
            HasCdp cdpDriver = (HasCdp) realDriver;
            double[] coords = resolveIframeCheckboxCoordinates(cdpDriver, offsetX);
            if (coords != null) {
                double clickX = coords[0];
                double clickY = coords[1];
                LogUtils.logInfo("Turnstile iframe en viewport (" + clickX + ", " + clickY + ")");

                dispatchMouseClick(cdpDriver, clickX, clickY);
                pause(400);
                clickViaRobotAtViewport(realDriver, clickX, clickY);
                return true;
            }
        }

        return clickOnTurnstileHost(realDriver, offsetX);
    }

    @SuppressWarnings("unchecked")
    private static double[] resolveIframeCheckboxCoordinates(HasCdp cdpDriver, int offsetX) {
        try {
            Map<String, Object> docParams = new HashMap<String, Object>();
            docParams.put("depth", -1);
            docParams.put("pierce", true);

            Map<String, Object> document = cdpDriver.executeCdpCommand("DOM.getDocument", docParams);
            Map<String, Object> root = (Map<String, Object>) document.get("root");

            Integer iframeNodeId = findCloudflareIframeNodeId(root);
            if (iframeNodeId == null) {
                LogUtils.logSevere("CDP pierced DOM: iframe de Cloudflare no encontrado");
                return null;
            }

            List<Number> quad = readContentQuad(cdpDriver, iframeNodeId);
            if (quad == null || quad.size() < 8) {
                LogUtils.logSevere("CDP pierced DOM: no se pudo leer posición del iframe Turnstile");
                return null;
            }

            double left = quad.get(0).doubleValue();
            double top = quad.get(1).doubleValue();
            double bottom = quad.get(7).doubleValue();

            return new double[]{left + offsetX, (top + bottom) / 2};
        } catch (Exception e) {
            LogUtils.logSevere("CDP pierced DOM: error resolviendo coordenadas (" + e.getMessage() + ")");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Number> readContentQuad(HasCdp cdpDriver, int nodeId) {
        Map<String, Object> boxParams = new HashMap<String, Object>();
        boxParams.put("nodeId", nodeId);
        Map<String, Object> boxModel = cdpDriver.executeCdpCommand("DOM.getBoxModel", boxParams);

        List<Number> fromModel = extractContentFromBoxModel(boxModel);
        if (fromModel != null) {
            return fromModel;
        }

        Map<String, Object> quadsParams = new HashMap<String, Object>();
        quadsParams.put("nodeId", nodeId);
        Map<String, Object> quadsResponse = cdpDriver.executeCdpCommand("DOM.getContentQuads", quadsParams);

        List<List<Number>> quads = (List<List<Number>>) quadsResponse.get("quads");
        if (quads != null && !quads.isEmpty()) {
            List<Number> first = quads.get(0);
            if (first != null && first.size() >= 8) {
                return first;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private static List<Number> extractContentFromBoxModel(Map<String, Object> boxModel) {
        Object model = boxModel.get("model");
        if (model instanceof Map) {
            Map<?, ?> modelMap = (Map<?, ?>) model;
            Object content = modelMap.get("content");
            if (content instanceof List) {
                List<?> list = (List<?>) content;
                if (list.size() >= 8) {
                    return (List<Number>) content;
                }
            }
        }

        Object content = boxModel.get("content");
        if (content instanceof List) {
            List<?> list = (List<?>) content;
            if (list.size() >= 8) {
                return (List<Number>) content;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private static Integer findCloudflareIframeNodeId(Map<String, Object> node) {
        if (node == null) {
            return null;
        }

        String nodeName = String.valueOf(node.get("nodeName"));
        if ("IFRAME".equalsIgnoreCase(nodeName)) {
            List<String> attributes = (List<String>) node.get("attributes");
            if (attributes != null) {
                boolean cloudflareSrc = false;
                boolean turnstileId = false;

                for (int i = 0; i < attributes.size() - 1; i += 2) {
                    String name = attributes.get(i);
                    String value = attributes.get(i + 1);

                    if ("src".equalsIgnoreCase(name) && value.contains("challenges.cloudflare.com")) {
                        cloudflareSrc = true;
                    }
                    if ("id".equalsIgnoreCase(name) && value.startsWith("cf-chl-widget")) {
                        turnstileId = true;
                    }
                }

                if (cloudflareSrc || turnstileId) {
                    return ((Number) node.get("nodeId")).intValue();
                }
            }
        }

        List<Map<String, Object>> children = (List<Map<String, Object>>) node.get("children");
        if (children != null) {
            for (Map<String, Object> child : children) {
                Integer found = findCloudflareIframeNodeId(child);
                if (found != null) {
                    return found;
                }
            }
        }

        List<Map<String, Object>> shadowRoots = (List<Map<String, Object>>) node.get("shadowRoots");
        if (shadowRoots != null) {
            for (Map<String, Object> shadowRoot : shadowRoots) {
                Integer found = findCloudflareIframeNodeId(shadowRoot);
                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }

    private static boolean clickOnTurnstileHost(WebDriver driver, int offsetX) {
        WebElement widget = findTurnstileHost(driver);
        if (widget == null) {
            LogUtils.logSevere("No se encontró contenedor Turnstile en DOM");
            return false;
        }

        scrollIntoView(driver, widget);
        pause(500);

        LogUtils.logInfo("Fallback Turnstile: offset X=" + offsetX + " en host #cf-turnstile");
        return clickViaCdp(driver, widget, offsetX)
                || clickViaW3cPointer(driver, widget, offsetX)
                || clickViaRobot(driver, widget, offsetX);
    }

    private static WebElement findTurnstileHost(WebDriver driver) {
        List<By> locators = Arrays.asList(
                By.id("cf-turnstile"),
                By.cssSelector(".turnstile-wrapper"),
                By.cssSelector("div[id='cf-turnstile']")
        );

        for (By locator : locators) {
            for (WebElement element : driver.findElements(locator)) {
                if (element.isDisplayed()) {
                    return element;
                }
            }
        }
        return null;
    }

    private static void dispatchMouseClick(HasCdp cdpDriver, double x, double y) {
        Map<String, Object> move = mouseEvent(x, y);
        move.put("type", "mouseMoved");
        cdpDriver.executeCdpCommand("Input.dispatchMouseEvent", move);

        Map<String, Object> press = mouseEvent(x, y);
        press.put("type", "mousePressed");
        press.put("button", "left");
        press.put("buttons", 1);
        press.put("clickCount", 1);
        cdpDriver.executeCdpCommand("Input.dispatchMouseEvent", press);

        Map<String, Object> release = mouseEvent(x, y);
        release.put("type", "mouseReleased");
        release.put("button", "left");
        release.put("buttons", 0);
        release.put("clickCount", 1);
        cdpDriver.executeCdpCommand("Input.dispatchMouseEvent", release);
    }

    private static Map<String, Object> mouseEvent(double x, double y) {
        Map<String, Object> event = new HashMap<String, Object>();
        event.put("x", x);
        event.put("y", y);
        event.put("pointerType", "mouse");
        return event;
    }

    @SuppressWarnings("unchecked")
    private static void clickViaRobotAtViewport(WebDriver driver, double viewportX, double viewportY) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Map<String, Number> screen = (Map<String, Number>) js.executeScript(
                    "var chromeTop = window.outerHeight - window.innerHeight;"
                            + "var chromeLeft = window.outerWidth - window.innerWidth;"
                            + "return {"
                            + "  x: Math.round(window.screenX + chromeLeft + arguments[0]),"
                            + "  y: Math.round(window.screenY + chromeTop + arguments[1])"
                            + "};",
                    viewportX,
                    viewportY
            );

            Robot robot = new Robot();
            robot.mouseMove(screen.get("x").intValue(), screen.get("y").intValue());
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            LogUtils.logInfo("Robot click Turnstile omitido (entorno sin mouse virtual): " + e.getMessage());
        } catch (Exception e) {
            LogUtils.logInfo("Robot click Turnstile omitido: " + e.getMessage());
        }
    }

    private static boolean clickViaCdp(WebDriver driver, WebElement widget, int offsetX) {
        WebDriver realDriver = WebDriverErrorDecorator.unwrap(driver);
        if (!(realDriver instanceof HasCdp)) {
            return false;
        }

        try {
            HasCdp cdpDriver = (HasCdp) realDriver;
            Map<String, Number> viewport = getViewportCoordinates(driver, widget, offsetX);
            dispatchMouseClick(cdpDriver, viewport.get("x").doubleValue(), viewport.get("y").doubleValue());
            return true;
        } catch (Exception e) {
            LogUtils.logSevere("CDP click Turnstile falló: " + e.getMessage());
            return false;
        }
    }

    private static boolean clickViaRobot(WebDriver driver, WebElement widget, int offsetX) {
        try {
            Map<String, Number> viewport = getViewportCoordinates(driver, widget, offsetX);
            clickViaRobotAtViewport(driver, viewport.get("x").doubleValue(), viewport.get("y").doubleValue());
            return true;
        } catch (Exception e) {
            LogUtils.logSevere("Robot click Turnstile falló: " + e.getMessage());
            return false;
        }
    }

    private static boolean clickViaW3cPointer(WebDriver driver, WebElement widget, int offsetX) {
        try {
            Map<String, Number> viewport = getViewportCoordinates(driver, widget, offsetX);
            int x = viewport.get("x").intValue();
            int y = viewport.get("y").intValue();

            PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "mouse");
            Sequence sequence = new Sequence(mouse, 1);
            sequence.addAction(mouse.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            sequence.addAction(mouse.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(mouse.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            ((Interactive) driver).perform(Collections.singletonList(sequence));
            return true;
        } catch (Exception e) {
            LogUtils.logSevere("W3C pointer click Turnstile falló: " + e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Number> getViewportCoordinates(WebDriver driver, WebElement widget, int offsetX) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Map<String, Number>) js.executeScript(
                "var rect = arguments[0].getBoundingClientRect();"
                        + "var offset = arguments[1];"
                        + "return { x: rect.left + offset, y: rect.top + (rect.height / 2) };",
                widget,
                offsetX
        );
    }

    private static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                element
        );
    }

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
