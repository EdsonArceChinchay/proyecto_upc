package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper extends WebBase {

    public static String extractRequestNumber(String text) {
        int indexFE = text.indexOf("FE-");
        if (indexFE != -1) {
            String request = text.substring(indexFE).split("\\.")[0].trim();
            return request.replace("-", "");
        }
        return null;
    }

    public static String getAbsolutePath(String relativePath) {
        return new File(relativePath).getAbsolutePath();
    }

    public static void downloadPDF(String url, String downloadDir) {
        try (PDDocument document = PDDocument.load(new URL(url).openStream());
             FileOutputStream outputFile = new FileOutputStream(new File(downloadDir, url.substring(url.lastIndexOf("/") + 1)))) {
            document.save(outputFile);
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, (String.format("PDF downloaded to: %s.", downloadDir)));
        } catch (IOException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Error downloading PDF", e);
        }
    }

    public static String readJson(String path) {
        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources" + path;
        try {
            return java.nio.file.Files.readString(java.nio.file.Paths.get(jsonFilePath));
        } catch (IOException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Error reading JSON file", e);
            return null;
        }
    }

    public static void seleccionarValueComboShadow(WebDriver driver, String sFormControlName, String sCodigoValue) {
        UtilWeb.waitForSeconds(1);
        System.out.println("seleccionarValueComboShadow(sFormControlName=" + sFormControlName + ", sCodigoValue=" + sCodigoValue + ")");
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.executeScript("document.querySelector('[formcontrolname=\"" + sFormControlName + "\"]') " +
                ".shadowRoot.querySelector('li.mdc-list-item[data-value=\"" + sCodigoValue + "\"]').click();");
    }

    public static String buscarValorOpcion(String sDescripcionOpcion, String[][] sOpciones) {
        for (String[] sOpcione : sOpciones) {
            if (sOpcione[1].equals(sDescripcionOpcion)) {
                return sOpcione[0];
            }
        }
        throw new IllegalArgumentException("buscarValorOpcion No válido: " + sDescripcionOpcion);
    }

    public static String getValueConfig(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
            return properties.getProperty(key);
        } catch (IOException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("Error in read values %s", e.getMessage()));
            return null;
        }
    }

    public static WebElement getVisibleAndClickableElement(List<WebElement> elements) {
        int numberElements = elements.size();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Number of web elements: %d.", numberElements));
        for (WebElement element : elements) {
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            } catch (NoSuchElementException e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("Web element not found %s - %s.", element, e.getMessage()));
            } catch (StaleElementReferenceException e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Element is no longer attached to the DOM: " + e.getMessage());
            } catch (Exception e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "An error occurred: " + e.getMessage());
            }
        }
        return null;
    }

    public static void compareWebElementTextAndString(WebElement currentElement, String expectedValue) {
        validateText(currentElement.getText().trim().toUpperCase(), expectedValue.trim().toUpperCase());
    }

    public static boolean returnValueCompareWebElementTextAndString(WebElement currentElement, String expectedValue) {
        return assertText(currentElement.getText().trim().toUpperCase(), expectedValue.trim().toUpperCase());
    }

    public static void compareStringAndString(String currentValue, String expectedValue) {
        validateText(currentValue.trim().toUpperCase(), expectedValue.trim().toUpperCase());
    }

    public static boolean returnValueCompareStringAndString(String currentValue, String expectedValue) {
        return assertText(currentValue.trim().toUpperCase(), expectedValue.trim().toUpperCase());
    }

    public static boolean assertText(String currentText, String expectedText) {
        boolean isEquals = currentText.contains(expectedText);
        String message = String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, message);
        return isEquals;
    }

    public static void validateText(String currentText, String expectedText) {
        boolean isEquals = currentText.contains(expectedText);
        String message = String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, message);
        Assertions.assertTrue(isEquals, message);
    }

    public static boolean isVisible(WebDriver driver, WebElement element) {
        WebDriverWait waitdefin = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean present;
        UtilWeb.waitForSeconds(1);
        if (element.isDisplayed() && element.isEnabled() && element.getSize().getWidth() > 0 && element.getSize().getHeight() > 0) {
            waitdefin.until(ExpectedConditions.visibilityOf(element));
            waitdefin.until(ExpectedConditions.elementToBeClickable(element));
            present = true;
        } else {
            present = false;
        }
        return present;
    }

    public static boolean validateInputAndLocator(WebDriver driver, String nameElement, String input, WebElement element) {
        if (input == null || input.isEmpty()) {
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Value is null.");
            return false;
        }
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format(" Element %s - value: %s.", nameElement, input));
        return validateElement(driver, element, 10);
    }

    public static boolean validateElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Element is Displayed: %b - Element is Enabled: %b.", element.isDisplayed(), element.isEnabled()));
            return element.isDisplayed() && element.isEnabled();
        } catch (TimeoutException | StaleElementReferenceException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("Element validation failed: %s.", e.getMessage()));
            return false;
        }
    }

    public static void typeInShadowRoot(WebElement webElement, String nameElement, String text) {
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, text);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Type in element %s = %s.", nameElement, text));
    }

    public static void typeInShadowRootCssSelector(String text, WebElement webElement, String shadowSelector) {
        webElement.getShadowRoot()
                .findElement(By.cssSelector(shadowSelector))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, text);
    }

    public static void validateInput(WebDriver driver, String nameElement, String text, WebElement element) {
        boolean exist = validateInputAndLocator(driver, nameElement, text, element);
        if (exist) {
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, text);
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Type %s: %s.", nameElement, text));
        } else {
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("No %s.", nameElement));
        }
    }

    public static void validateSelectShadow(WebDriver driver, String nameElement, String text, WebElement element, String shadowElement) {
        boolean existe = validateInputAndLocator(driver, nameElement, text, element);
        if (existe) {
            selectElementShadowRootCSS(text, element, shadowElement);
        } else {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("No %s.", nameElement));
        }
    }

    public static void selectElementShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        webElement.click();
        UtilWeb.waitForSeconds(2);
        SearchContext contextPlan = webElement.getShadowRoot();
        List<WebElement> elementsList = contextPlan.findElements(By.cssSelector(shadowElement));
        for (WebElement element : elementsList) {
            boolean isEquals = returnValueCompareWebElementTextAndString(element, text);
            if (isEquals) {
                Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Select element: %s.", element.getText()));
                element.click();
                break;
            }
        }
    }

    public static void validateCompletedInputForm(String text, WebElement webElement, String shadowElement) {
        final int MAX_RETRIES = 5;
        int counter = 0;
        while (counter < MAX_RETRIES) {
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Retry shadow N° %d", (counter + 1)));
            try {
                typeInShadowRootCssSelector(text, webElement, shadowElement);
                UtilWeb.waitForSeconds(3);
                if (webElement.isDisplayed()) {
                    Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Element is Displayed: true.");
                    return;
                }
            } catch (Exception e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("No found element - %s.", e.getMessage()));
            }
            counter++;
        }
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Element is Displayed: false.");
    }

    public static boolean isNumber(String tipoDoc) {
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Type document: " + tipoDoc + " is number: ");
        boolean result;
        try {
            Long.parseLong(tipoDoc);
            result = true;
        } catch (NumberFormatException excepcion) {
            result = false;
        }
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Type document: " + tipoDoc + " is number: " + result);
        return result;
    }
}





