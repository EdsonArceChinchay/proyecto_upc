package com.tdp.ct.web.step;

import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Comun {

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

}
