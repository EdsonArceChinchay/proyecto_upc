package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.URL;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper extends WebBase {

    public static String extraerNumeroSolicitud(String texto) {
        int longitud = texto.length();
        //if (longitud >= 30) {
        //String ultimos30Caracteres = texto.substring(longitud - 30, longitud);
        int indiceFE = texto.indexOf("FE-");
        if (indiceFE != -1) {
            int strpos = texto.substring(indiceFE).indexOf(".");
            if (strpos > 0) {
//                return texto.substring(indiceFE).substring(0,strpos-1).replace("-","");
                return texto.substring(indiceFE).substring(0, strpos).trim();
            }
            return texto.substring(indiceFE).replace("-", "");
        }
        //}
        return null;
    }

    public static String obtenerRutaAbsoluta(String sRuta) {
        File archivo = new File(sRuta);
        return archivo.getAbsolutePath();
    }

    public static void descargarPDFDesdeURL(String url, String carpetaDescarga) {
        try {
            URL pdfURL = new URL(url);
            PDDocument document = PDDocument.load(pdfURL.openStream());

            String nombreArchivo = url.substring(url.lastIndexOf("/") + 1);
            String rutaArchivo = carpetaDescarga + "/" + nombreArchivo;

            FileOutputStream archivoSalida = new FileOutputStream(rutaArchivo);
            document.save(archivoSalida);
            document.close();

            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("PDF descargado en: %s.", rutaArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readerJson(String path) {
        String jsonFile = System.getProperty("user.dir") + "/src/test/resources" + path;
        File file = new File(jsonFile);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            return new String(data, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void seleccionarValueComboShadow(WebDriver driver, String sFormControlName, String sCodigoValue){
        UtilWeb.waitForSeconds(1);
        System.out.println("seleccionarValueComboShadow(sFormControlName=" + sFormControlName + ", sCodigoValue="+sCodigoValue + ")");
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.executeScript("document.querySelector('[formcontrolname=\""+sFormControlName+"\"]') " +
                ".shadowRoot.querySelector('li.mdc-list-item[data-value=\""+sCodigoValue+"\"]').click();");
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

    public static WebElement selectEnabledItemFromAListOfItems(List<WebElement> listElemet) {
        int numberElements = listElemet.size();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Number of web elements: %d." ,numberElements));
        WebElement element = null;
        for (int i = 0; i < numberElements; i++) {
            element = listElemet.get(i);
            String nameElement;
            try {
                if (element.isEnabled() && element.isSelected()) {
                    nameElement = element.getText().trim();
                    Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Web element %s - %s is enabled and selected.", element ,nameElement));
                }
            } catch (Exception e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("Web element not found %s - %s.", element, e.getMessage()));
            }
        }
        return element;
    }

    public static void compareWebElementTextAndString(WebElement element, String value) {
        String expectedText = value.trim().toUpperCase();
        String currentText = element.getText().trim().toUpperCase();
        boolean isEquals = currentText.contains(expectedText);
        String message =String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO,message);
        Assertions.assertTrue(isEquals,message);
    }

    public static boolean returnValueCompareWebElementTextAndString(WebElement element, String value) {
        String expectedText = value.trim().toUpperCase();
        String currentText = element.getText().trim().toUpperCase();
        boolean isEquals = currentText.contains(expectedText);
        String message =String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO,message);
        return isEquals;
    }

    public static void compareStringAndString(String expectedValue, String currentValue) {
        String expectedText = expectedValue.trim().toUpperCase();
        String currentText = currentValue.trim().toUpperCase();
        boolean isEquals = currentText.contains(expectedText);
        String message =String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO,message);
        Assertions.assertTrue(isEquals,message);
    }

    public static boolean returnValueCompareStringAndString(String expectedValue, String currentValue) {
        String expectedText = expectedValue.trim().toUpperCase();
        String currentText = currentValue.trim().toUpperCase();
        boolean isEquals = currentText.contains(expectedText);
        String message =String.format("Expected text: %s, Current text: %s, Are equals: %b.", expectedText, currentText, isEquals);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO,message);
        return isEquals;
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

    public static boolean validateInputAndLocator(WebDriver driver, String nameElement,String input, WebElement element) {
        if (input == null || input.isEmpty()) {
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Value is null." );
            return false;
        }
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format(" Element %s - value: %s.", nameElement, input) );
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
    
    public static void typeInputShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        SearchContext context = webElement.getShadowRoot();
        WebElement inputElement = context.findElement(By.cssSelector(shadowElement));
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(text);
    }

    public static void validateInput(WebDriver driver, String nameElement, String text, WebElement element) {
        boolean exist = validateInputAndLocator(driver, nameElement,text, element);
        if (exist) {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("Type %s: %s.",nameElement, text));
        } else {
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, String.format("No %s.", nameElement));
        }
    }

    public static void validateSelectShadow(WebDriver driver,String nameElement, String text, WebElement element, String shadowElement){
        boolean existe = validateInputAndLocator(driver,nameElement, text, element);
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
                typeInputShadowRootCSS(text, webElement, shadowElement);
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

}





