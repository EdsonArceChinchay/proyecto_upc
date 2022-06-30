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
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", nombrePlan);
    }



    public void doyClickEnElBotonSeleccionarLaOferta() {
        js().scrollElementTop(btnOferta);
        waitUntilElementIsVisible(btnOferta, 5);
        click(btnOferta, 5);
        UtilWeb.waitForSeconds(10);
    }

    public void seleccionoEnIniciarRegistro() {

        waitUntilElementIsVisible(btnIniciar, 5);
        click(btnIniciar, 5);
        UtilWeb.waitForSeconds(10);
    }

    public void scrollUp() {
        UtilWeb.waitForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,400)");


    }
}

