package com.tdp.ct.web.CaptchaBase;

import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

public class Util {

    private Util() {
        //Nothing TODO
    }

    /**
     * Obtener la fecha actual a partir de un formato especifico
     *
     * @return la fecha formateada
     */
    public static String currentDateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Obteniene caracter por caracter de una cadena de caracteres
     *
     * @param value Cadena de caracteres
     * @return retorna un solo caracter de la cadena de caracteres
     */
    public static String getChartByChart(String value) {
        String chart = StringUtils.EMPTY;
        for (int i = 0; i < value.length(); i++) {
            chart = String.valueOf(value.charAt(i));
        }
        return chart;
    }

    public static String getIndiceSegunNumeroCuenta(String numeroCuenta) {
        List<String> indice = Arrays.asList(numeroCuenta.split("-"));

        return indice.get(2);

    }

//    public static void screenshot(WebDriver webDriver) {
//        UtilWeb.takeScreenShotWeb((Scenario) UtilWeb.getVariableOnSession(Constants.SCENARIO), webDriver);
//    }
//    /**
//     * Método de espera implicita
//     */
    public static void implicitWait(int timeOnSeconds) {
        try {
            Thread.sleep(timeOnSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String descifrarBase64(String texto)
    {    Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(texto);
        return new String(decodedByteArray);
    }
}
