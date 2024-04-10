package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;

public class Helper extends WebBase {

    public static String extraerNumeroSolicitud(String texto) {
        int longitud = texto.length();
        //if (longitud >= 30) {
        //String ultimos30Caracteres = texto.substring(longitud - 30, longitud);
        int indiceFE = texto.indexOf("FE-");
        if (indiceFE != -1) {
            int strpos = texto.substring(indiceFE).indexOf(".");
            if(strpos > 0){
//                return texto.substring(indiceFE).substring(0,strpos-1).replace("-","");
                return texto.substring(indiceFE).substring(0,strpos).trim();
            }
            return texto.substring(indiceFE).replace("-","");
        }
        //}
        return null;
    }
    public static String obtenerRutaAbsoluta(String sRuta) {
        File archivo = new File(sRuta);
        if (archivo != null) {
            return archivo.getAbsolutePath().toString();
        } else {
            return null;
        }
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

    public static LocalStorage getLocalStorage(WebDriver driver) {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        LocalStorage localStorage = webStorage.getLocalStorage();
        return localStorage;

    }

    public static String getItemLocalStorage(LocalStorage localStorage, String item){
        String  itemLocalStorage = localStorage.getItem(item);
        return itemLocalStorage;
    }

    public static String getValueItemLocalStorage(WebDriver driver, String item, String Key) throws JSONException {
        String itemLocalStorage= getItemLocalStorage(getLocalStorage(driver),item);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        String value = jsonObject.getString(Key);

        return value;
    }




}
