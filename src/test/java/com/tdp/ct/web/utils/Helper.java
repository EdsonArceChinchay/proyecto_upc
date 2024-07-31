package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
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

            System.out.println("PDF descargado en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getValueConfig(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
            return properties.getProperty(key);
        } catch (IOException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Error in read values " + e.getMessage());
            return null;
        }
    }

    public static WebElement selectEnabledItemFromAListOfItems(List<WebElement> listElemet) {
        int numberElements = listElemet.size();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Number of web elements id " + numberElements);
        WebElement element = null;
        for (int i = 0; i < numberElements; i++) {
            element = listElemet.get(i);
            String nameElement;
            try {
                if (element.isEnabled() && element.isSelected()) {
                    nameElement = element.getText().trim();
                    Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Web element " + element + " - " + nameElement + " is enabled and selected");
                }
            } catch (Exception e) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Web element not found" + element + " - " + e.getMessage());
            }
        }
        return element;
    }

    public static void compareWebElementTextAndText(WebElement element, String text) {
        String expectedText = text.trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Expected text: " + expectedText);
        String currentText = element.getText().trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Current text: " + currentText);
        boolean isEquals = currentText.contains(expectedText);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
        Assertions.assertTrue(isEquals, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
    }

    public static boolean returnCompareWebElementTextAndText(WebElement element, String text) {
        String expectedText = text.trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Expected text: " + expectedText);
        String currentText = element.getText().trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Current text: " + currentText);
        boolean isEquals = currentText.contains(expectedText);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
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

    public static boolean validateInputAndLocator(WebDriver driver, String input, WebElement element) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return validateElement(driver, element, 10);
    }

    public static boolean validateElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed() && element.isEnabled();
        } catch (TimeoutException | StaleElementReferenceException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Element validation failed: " + e.getMessage());
            return false;
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

    public static void typeInputShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        SearchContext context = webElement.getShadowRoot();
        WebElement inputElement = context.findElement(By.cssSelector(shadowElement));
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(text);
    }

    public static void selectElementShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        webElement.click();
        UtilWeb.waitForSeconds(2);
        SearchContext contextPlan = webElement.getShadowRoot();
        List<WebElement> elementsList = contextPlan.findElements(By.cssSelector(shadowElement));
        for (WebElement element : elementsList) {
            scrollElementTop(element);
            boolean isEquals = returnCompareWebElementTextAndText(element, text);
            if (isEquals) {
                scrollElementTop(element);
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "Select element: " + element.getText());
                element.click();
                break;
            }
        }
    }
    public static void scrollElementTop(WebElement webElement) {
      /*  ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView();", webElement);;
        System.out.println("Scroll to web element");*/
    }

}





