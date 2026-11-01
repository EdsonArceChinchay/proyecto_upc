package com.tdp.ct.web.healing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilidades auxiliares para facilitar la integración de Auto-Healing
 * en PageObjects existentes y acelerar la migración
 */
public class HealingUtils {
    private static final Logger logger = Logger.getLogger(HealingUtils.class.getName());

    /**
     * Busca un elemento con healing habilitado y lo hace click
     */
    public static void clickWithHealing(HealablePageObject page, String elementKey) {
        try {
            page.findWithHealing(elementKey).click();
            logger.log(Level.FINE, "✓ Click exitoso en: " + elementKey);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al hacer click en: " + elementKey);
            throw e;
        }
    }

    /**
     * Busca un elemento con healing y escribe texto
     */
    public static void sendKeysWithHealing(HealablePageObject page, String elementKey, String text) {
        try {
            page.findWithHealing(elementKey).sendKeys(text);
            logger.log(Level.FINE, "✓ Texto ingresado en: " + elementKey);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al ingresar texto en: " + elementKey);
            throw e;
        }
    }

    /**
     * Busca un elemento con healing y obtiene su texto
     */
    public static String getTextWithHealing(HealablePageObject page, String elementKey) {
        try {
            String text = page.findWithHealing(elementKey).getText();
            logger.log(Level.FINE, "✓ Texto obtenido de: " + elementKey);
            return text;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al obtener texto de: " + elementKey);
            throw e;
        }
    }

    /**
     * Busca un elemento con healing y obtiene su atributo
     */
    public static String getAttributeWithHealing(HealablePageObject page, String elementKey, String attributeName) {
        try {
            String attribute = page.findWithHealing(elementKey).getAttribute(attributeName);
            logger.log(Level.FINE, "✓ Atributo '" + attributeName + "' obtenido de: " + elementKey);
            return attribute;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al obtener atributo de: " + elementKey);
            throw e;
        }
    }

    /**
     * Valida que un elemento es visible con healing
     */
    public static boolean isElementVisibleWithHealing(HealablePageObject page, String elementKey) {
        try {
            WebElement element = page.findWithHealing(elementKey);
            boolean isVisible = element.isDisplayed();
            logger.log(Level.FINE, "Elemento " + elementKey + " visible: " + isVisible);
            return isVisible;
        } catch (Exception e) {
            logger.log(Level.FINE, "Elemento " + elementKey + " no está visible");
            return false;
        }
    }

    /**
     * Valida que un elemento está habilitado con healing
     */
    public static boolean isElementEnabledWithHealing(HealablePageObject page, String elementKey) {
        try {
            WebElement element = page.findWithHealing(elementKey);
            boolean isEnabled = element.isEnabled();
            logger.log(Level.FINE, "Elemento " + elementKey + " habilitado: " + isEnabled);
            return isEnabled;
        } catch (Exception e) {
            logger.log(Level.FINE, "Elemento " + elementKey + " no está habilitado");
            return false;
        }
    }

    /**
     * Limpia y vuelve a escribir en un campo con healing
     */
    public static void clearAndSendKeysWithHealing(HealablePageObject page, String elementKey, String text) {
        try {
            WebElement element = page.findWithHealing(elementKey);
            element.clear();
            element.sendKeys(text);
            logger.log(Level.FINE, "✓ Campo limpiado y texto ingresado en: " + elementKey);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al limpiar/escribir en: " + elementKey);
            throw e;
        }
    }

    /**
     * Espera a que un elemento sea visible con healing
     */
    public static WebElement waitUntilVisibleWithHealing(HealablePageObject page,
                                                         String elementKey,
                                                         int timeoutSeconds) {
        try {
            WebDriver driver = page.getDriver();
            WebElement element = page.findWithHealing(elementKey);
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
            logger.log(Level.FINE, "✓ Elemento " + elementKey + " es visible");
            return element;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Timeout esperando visibilidad de: " + elementKey);
            throw e;
        }
    }

    /**
     * Espera a que un elemento sea clickeable con healing
     */
    public static WebElement waitUntilClickableWithHealing(HealablePageObject page,
                                                          String elementKey,
                                                          int timeoutSeconds) {
        try {
            WebDriver driver = page.getDriver();
            WebElement element = page.findWithHealing(elementKey);
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
            logger.log(Level.FINE, "✓ Elemento " + elementKey + " es clickeable");
            return element;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Timeout esperando que sea clickeable: " + elementKey);
            throw e;
        }
    }

    /**
     * Ejecuta JavaScript en un elemento con healing
     */
    public static Object executeJavaScriptOnElement(HealablePageObject page,
                                                     String elementKey,
                                                     String script) {
        try {
            WebDriver driver = page.getDriver();
            WebElement element = page.findWithHealing(elementKey);
            Object result = ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(script, element);
            logger.log(Level.FINE, "✓ Script ejecutado en: " + elementKey);
            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo al ejecutar script en: " + elementKey);
            throw e;
        }
    }

    /**
     * Valida que un elemento contiene un texto específico con healing
     */
    public static boolean elementContainsText(HealablePageObject page, String elementKey, String expectedText) {
        try {
            String actualText = page.findWithHealing(elementKey).getText();
            boolean contains = actualText.contains(expectedText);
            logger.log(Level.FINE, "Elemento '" + elementKey + "' contiene '" + expectedText + "': " + contains);
            return contains;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo validando texto en: " + elementKey);
            return false;
        }
    }

    /**
     * Scroll hasta elemento con healing
     */
    public static void scrollToElementWithHealing(HealablePageObject page, String elementKey) {
        try {
            WebDriver driver = page.getDriver();
            WebElement element = page.findWithHealing(elementKey);
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(Level.FINE, "✓ Scroll hasta: " + elementKey);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo scrolling a: " + elementKey);
            throw e;
        }
    }

    /**
     * Obtiene todos los datos de un elemento con healing
     */
    public static WebElementData getElementDataWithHealing(HealablePageObject page, String elementKey) {
        try {
            WebElement element = page.findWithHealing(elementKey);
            WebElementData data = new WebElementData();
            data.text = element.getText();
            data.tagName = element.getTagName();
            data.isDisplayed = element.isDisplayed();
            data.isEnabled = element.isEnabled();
            data.class_name = element.getAttribute("class");
            data.id = element.getAttribute("id");

            logger.log(Level.FINE, "✓ Datos recolectados de: " + elementKey);
            return data;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "✗ Fallo recolectando datos de: " + elementKey);
            throw e;
        }
    }

    /**
     * Clase auxiliar para almacenar datos de elementos
     */
    public static class WebElementData {
        public String text;
        public String tagName;
        public boolean isDisplayed;
        public boolean isEnabled;
        public String class_name;
        public String id;

        @Override
        public String toString() {
            return String.format(
                "WebElementData{tag='%s', text='%s', displayed=%b, enabled=%b, class='%s', id='%s'}",
                tagName, text, isDisplayed, isEnabled, class_name, id
            );
        }
    }

    /**
     * Imprime información disponible de elementos registrados
     */
    public static void printRegisteredLocators(HealablePageObject page) {
        logger.log(Level.INFO, "\n=== LOCALIZADORES REGISTRADOS ===");
        page.getRegisteredLocators().forEach((key, locator) -> {
            logger.log(Level.INFO, "  " + key + " -> " + locator);
        });
        logger.log(Level.INFO, "================================\n");
    }
}

