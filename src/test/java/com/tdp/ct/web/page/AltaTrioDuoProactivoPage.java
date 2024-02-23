package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

public class AltaTrioDuoProactivoPage extends WebBase {

    @FindBy(xpath = "//button[@class='btnSky btnsForms']")
    protected WebElement btnOferta;

    @FindBy(xpath = "//button[@type='button']")
    protected WebElement btnIniciar;

    public void seleccionoElNombreDelPlan(String nombrePlan) {
        UtilWeb.waitForSeconds(5);
        String elemento = "//div[contains(text(),'" + nombrePlan + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsClickable(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", nombrePlan);
    }

    public void doyClickEnElBotonSeleccionarLaOferta() {
        js().scrollElementTop(btnOferta);
        waitUntilElementIsClickable(btnOferta, 20).click();
        UtilWeb.waitForSeconds(10);
    }

    public void seleccionoEnIniciarRegistro() {
        waitUntilElementIsClickable(btnIniciar, 20).click();
        UtilWeb.waitForSeconds(10);
    }

}

