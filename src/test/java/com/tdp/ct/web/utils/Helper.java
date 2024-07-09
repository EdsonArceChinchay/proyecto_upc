package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.net.URL;

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
        return archivo.getAbsolutePath().toString();
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
            Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Error in read values " + e.getMessage());
            return null;
        }
    }

    public static WebElement selectEnabledItemFromAListOfItems(List<WebElement> listElemet) {
        int numberElements = listElemet.size();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Number of web elements id " + numberElements);
        WebElement element = null;
        for (int i = 0; i < numberElements; i++) {
            element = listElemet.get(i);
            String nameElement = "";
            try {
                if (element.isEnabled() && element.isSelected()) {
                    nameElement = element.getText().trim();
                    Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Web element " + element + " - " + nameElement + " is enabled and selected");
                }
            } catch (Exception e) {
                Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Web element not found" + element + " - " + e.getMessage());
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

    public static boolean compareWebElementTextAndTextAndReturnValue(WebElement element, String text) {
        String expectedText = text.trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Expected text: " + expectedText);
        String currentText = element.getText().trim().toUpperCase();
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "Current text: " + currentText);
        boolean isEquals = currentText.contains(expectedText);
        Logger.getLogger(Helper.class.getName()).log(Level.INFO, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
        return isEquals;
    }

}





