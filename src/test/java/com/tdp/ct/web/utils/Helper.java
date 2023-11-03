package com.tdp.ct.web.utils;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Helper {

    public static String extraerNumeroSolicitud(String texto) {
        int longitud = texto.length();
        //if (longitud >= 30) {
        //String ultimos30Caracteres = texto.substring(longitud - 30, longitud);
        int indiceFE = texto.indexOf("FE-");
        if (indiceFE != -1) {
            int strpos = texto.substring(indiceFE).indexOf(".");
            if(strpos > 0){
                return texto.substring(indiceFE).substring(0,strpos-1).replace("-","");
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
}
