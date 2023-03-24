package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

public class AltaDuoSvaDecodificadorSvaRepetidorCallCenterPage extends WebBase {


    public void seleccionardecodificador(String string){
        System.out.println("aqui");
        //String elemento = "//div[contains(text(),'" + plan + "')]/../../../div";
        String decodificador = "//div[text()=' Cuota mensual : S/"+string+" " + "']/parent::div/../descendant-or-self::tdp-st-icon-button[1]";
        WebElement deco = find().getElementByXPath(decodificador);
        deco.click();
        UtilWeb.waitForSeconds(3);

    }
}
