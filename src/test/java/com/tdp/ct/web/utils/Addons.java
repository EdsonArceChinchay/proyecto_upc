package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;

public class Addons {


public static void esperaProgresiva(int reintentosMax, int segundosEspera, WebElement elemento){
        int contador = 1;
        //int reintentos = 6;
        boolean bOK = false;
        //int wait = 5;
        do{
        System.out.println("Reintento # " + contador);
        UtilWeb.waitForSeconds(segundosEspera*contador);
        try{
        String s = elemento.getText();
        bOK = true;
        System.out.println(s);
        }catch(Exception e){
        System.out.println("error Message: " + e.getMessage());
        System.out.println("error StackTrace: " + e.getStackTrace());
        }
        contador++;
        }
        while(bOK == false && contador < reintentosMax);
        }
}
