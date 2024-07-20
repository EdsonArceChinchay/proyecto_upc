package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class CaeqPorRetailPage extends WebBase {
    //@FindBy(xpath = "/html/body/app-root/app-alta-movil/app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[4]/div")
    @FindBy(xpath = "(//div[contains(text(),\"Añadir equipo\")])[2]")
    protected WebElement btnAnadirE;

    @FindBy(css = "tdp-st-button[label=\"Seleccionar\"]")
    protected  WebElement botonSeleecionar;

    @FindBy(xpath = "//div/button[@class=\"btnCard\"]")
    protected  WebElement botonMantenerPlan;

    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement BtnCambiarPlan;

    public void btnAnadirEquipo(int num) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(2);
        WebElement btnAñadirEquipo = find().getElementByXPath("(//div[contains(text(),'Añadir equipo')])["+num+"]");
        esperaProgresiva(driver(), 3, 5, btnAñadirEquipo);
        js().scrollElementTop(btnAñadirEquipo);
        click(btnAñadirEquipo);
        //waitUntilElementIsClickable(btnAnadirE,20).click();
        UtilWeb.waitForSeconds(1);
    }


    public void btnSeleecionar() {
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(botonSeleecionar);
        //waitUntilElementIsVisible(botonSeleecionar,10);
        click(botonSeleecionar);
        UtilWeb.waitForSeconds(5);
    }

    public void btnMantenerPlan() {
        UtilWeb.waitForSeconds(5);
        click(botonMantenerPlan);
    }



    public void clickBotonCambiarPlan() {
        UtilWeb.waitForSeconds(10);
        click(BtnCambiarPlan);
    }


    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI, Map<String, String> valuesMovil) {
        String getValueCAEQ, getValueCAPL, getValueCASI;

        getValueCAEQ = valuesMovil.get("CAEQ").trim().toUpperCase();
        getValueCAPL = valuesMovil.get("CAPL").trim().toUpperCase();
        getValueCASI = valuesMovil.get("CASI").trim().toUpperCase();

        valueCAEQ = valueCAEQ.trim().toUpperCase();
        valueCAPL = valueCAPL.trim().toUpperCase();
        valueCASI = valueCASI.trim().toUpperCase();

        Assertions.assertEquals(valueCAEQ, getValueCAEQ, "El valor de CAEQ esperado: " + valueCAEQ + " es diferente al obtenido: " + getValueCAEQ);
        Assertions.assertEquals(valueCAPL, getValueCAPL, "El valor de CAPL esperado: " + valueCAPL + " es diferente al obtenido: " + getValueCAPL);
        Assertions.assertEquals(valueCASI, getValueCASI, "El valor de CASI esperado: " + valueCASI + " es diferente al obtenido: " + getValueCASI);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CAEQ esperado: " + valueCAEQ + " y el obtenido es:" + getValueCAEQ + ", los valores son iguales "+valueCAEQ.equals(getValueCAEQ));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CAPL esperado: " + valueCAPL + " y el obtenido es:" + getValueCAPL + ", los valores son iguales "+valueCAPL.equals(getValueCAPL));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CASI esperado: " + valueCASI + " y el obtenido es:" + getValueCASI + ", los valores son iguales "+valueCASI.equals(getValueCASI));

    }

}
