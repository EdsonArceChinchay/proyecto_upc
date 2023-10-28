package com.tdp.ct.web.utils;

import java.io.File;

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
}
