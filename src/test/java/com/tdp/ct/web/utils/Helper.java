package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;
import java.net.URL;

import java.util.Properties;

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
            e.printStackTrace();
            return null;
        }
    }

}





