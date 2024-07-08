package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
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

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(Helper.class.getName());

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
            LOGGER.log(Level.INFO, "Error in read values " + e.getMessage());
            return null;
        }
    }

    public static WebElement selectEnabledItemFromAListOfItems(List<WebElement> listElemet) {
        int numberElements = listElemet.size();
        LOGGER.log(Level.INFO, "Number of web elements id " + numberElements);
        WebElement element = null;
        for (int i = 0; i < numberElements; i++) {
            element = listElemet.get(i);
            String nameElement = "";
            try {
                if (element.isEnabled()) {
                    nameElement = element.getText().trim();
                    LOGGER.log(Level.INFO, "Web element " + element + " - " + nameElement + " is enabled");
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, "Web element not found" + element + " - " + e.getMessage());
            }
        }
        return element;
    }

    public static void compareWebElementTextAndText(WebElement element, String text) {
        String expectedText = text.trim().toUpperCase();
        LOGGER.log(Level.INFO, "Expected text: " + expectedText);
        String currentText = element.getText().trim().toUpperCase();
        LOGGER.log(Level.INFO, "Current text: " + currentText);
        boolean isEquals = currentText.contains(expectedText);
        LOGGER.log(Level.INFO, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
        Assertions.assertTrue(isEquals, "The expected text " + expectedText + "  and the current text " + currentText + " are equals: " + isEquals);
    }

}





