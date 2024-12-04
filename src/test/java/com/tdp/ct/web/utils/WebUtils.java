package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.tdp.ct.web.lib.WebDriverManager.getDriver;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class WebUtils extends WebBase {

    public static String extractRequestNumber(String text) {
        int indexFE = text.indexOf("FE-");
        if (indexFE != -1) {
            String request = text.substring(indexFE).split("\\.")[0].trim();
            return request.replace("-", "");
        }
        return null;
    }

    public static void seleccionarValueComboShadow(WebDriver driver, String sFormControlName, String sCodigoValue) {
        UtilWeb.waitForSeconds(1);
        logInfo("seleccionarValueComboShadow(sFormControlName=" + sFormControlName + ", sCodigoValue=" + sCodigoValue + ")");
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

    public static WebElement getVisibleAndClickableElement(List<WebElement> elements) {
        int numberElements = elements.size();
        logInfo(String.format("Number of web elements: %d", numberElements));
        for (WebElement element : elements) {
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            } catch (NoSuchElementException e) {
                logSevere(String.format("Web element not found %s - %s", element, e.getMessage()));
            } catch (StaleElementReferenceException e) {
                logSevere(String.format("Element is no longer attached to the DOM: %s", e.getMessage()));
            } catch (Exception e) {
                logSevere(String.format("An error occurred: %s", e.getMessage()));
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
        String message = String.format("Expected text: %s, Current text: %s, Are equals: %b", expectedText, currentText, isEquals);
        logInfo(message);
        return isEquals;
    }

    public static void validateText(String currentText, String expectedText) {
        boolean isEquals = currentText.contains(expectedText);
        String message = String.format("Expected text: %s, Current text: %s, Are equals: %b", expectedText, currentText, isEquals);
        logInfo(message);
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

    public static void validateAndType(String nameElement, WebElement webElement, String value) {
        if (validateInputAndLocator(nameElement, webElement, value)) {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, value);
            logInfo(String.format("Type %s: %s", nameElement, value));
        }
    }

    public static boolean validateInputAndLocator(String nameElement, WebElement webElement, String value) {
        if (value == null || value.isEmpty()) {
            logInfo("Value is null");
            return false;
        }
        logInfo(String.format("Element %s - value: %s", nameElement, value));
        return validateElement(webElement, nameElement, 10);
    }

    public static boolean validateElement(WebElement webElement, String nameElement, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            logInfo(String.format("Element %s is Displayed: %b - Element is Enabled: %b", nameElement, webElement.isDisplayed(), webElement.isEnabled()));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (TimeoutException | StaleElementReferenceException e) {
            logSevere(String.format("Element validation failed: %s", e.getMessage()));
            return false;
        }
    }

    public static void typeInShadowRoot(WebElement webElement, String nameElement, String text) {
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, text);
        logInfo(String.format("Type in element %s = %s", nameElement, text));
    }

    public static void typeInShadowRootCssSelector(String text, WebElement webElement, String shadowSelector) {
        webElement.getShadowRoot()
                .findElement(By.cssSelector(shadowSelector))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, text);
    }

    public static void validateInput(String nameElement, WebElement element, String value) {
        boolean exist = validateInputAndLocator(nameElement, element, value);
        if (exist) {
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, value);
            logInfo(String.format("Type %s: %s", nameElement, value));
        } else {
            logInfo(String.format("No %s", nameElement));
        }
    }

    public static void validateSelectShadow(String nameElement, String text, WebElement element, String shadowElement) {
        boolean existe = validateInputAndLocator(nameElement, element, text);
        if (existe) {
            selectElementShadowRootCSS(text, element, shadowElement);
        } else {
            logInfo(String.format("No %s", nameElement));
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
                logInfo(String.format("Select element: %s", element.getText()));
                element.click();
                break;
            }
        }
    }

    public static void validateCompletedInputForm(String text, WebElement webElement, String shadowElement) {
        final int MAX_RETRIES = 5;
        int counter = 0;
        while (counter < MAX_RETRIES) {
            logInfo(String.format("Retry shadow N° %d", (counter + 1)));
            try {
                typeInShadowRootCssSelector(text, webElement, shadowElement);
                UtilWeb.waitForSeconds(3);
                if (webElement.isDisplayed()) {
                    logInfo("Element is Displayed: true");
                    return;
                }
            } catch (Exception e) {
                logSevere(String.format("No found element - %s", e.getMessage()));
            }
            counter++;
        }
        logInfo("Element is Displayed: false");
    }

    public static boolean isNumber(String str) {
        boolean result;
        try {
            Long.parseLong(str);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        logInfo(String.format("%s is number: %b", str, result));
        return result;
    }
    public static WebElement explicitWaitName(WebDriver driver, int wait, String elements){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(wait));
        return  wait1.until(ExpectedConditions.presenceOfElementLocated(By.name(elements)));
    }
    public static WebElement explicitWaitId(WebDriver driver, int wait, String elements){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(wait));
        return  wait1.until(ExpectedConditions.presenceOfElementLocated(By.id(elements)));
    }
    public static WebElement explicitWaitXpath(WebDriver driver, int wait, String elements){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(wait));
        return  wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elements)));
    }
    public static WebElement explicitWaitCss(WebDriver driver, int wait, String elements){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(wait));
        return  wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elements)));
    }
    public static WebElement waitUntilPresenceOfElementLocated(WebDriver driver, int timeOutOnSeconds, By webElement){
        return (WebElement)(new WebDriverWait(driver, Duration.ofSeconds((long)timeOutOnSeconds))).until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    public static void selectElementCSS(String text, WebElement webElement, String webElementList) {
        scrollTo(webElement);
        webElement.click();
        UtilWeb.waitForSeconds(2);
        List<WebElement> elementsList = getDriver().findElements(By.cssSelector(webElementList));
        logInfo("List size", elementsList.size());
        for (WebElement element : elementsList) {
            scrollTo(element);
            boolean isEquals = returnValueCompareWebElementTextAndString(element, text);
            if (isEquals) {
                logInfo(String.format("Select element: %s", element.getText()));
                element.click();
                break;
            }
        }
    }

    public static void selectElementXpath(String text, WebElement webElement, String webElementList) {
        webElement.click();
        UtilWeb.waitForSeconds(2);
        List<WebElement> elementsList = getDriver().findElements(By.xpath(webElementList));
        logInfo("List size", elementsList.size());
        for (WebElement element : elementsList) {
            scrollTo(element);
            boolean isEquals = returnValueCompareWebElementTextAndString(element, text);
            if (isEquals) {
                logInfo(String.format("Select element: %s", element.getText()));
                element.click();
                break;
            }
        }
    }

    public static void scrollTo(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        logInfo("Scroll to", webElement.toString());
    }


}





