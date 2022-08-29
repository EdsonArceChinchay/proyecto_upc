package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MigracionDuoATrioTiendaPage extends WebBase {

    @FindBy(css = "div:nth-child(1) > app-card-line")
    protected WebElement cartillaHogar;
    @FindBy(css = "div:nth-child(2) > app-card-plan > div.card.ng-star-inserted > div > div.tdp-row.tdp-mt-3.tdp-mb-3 > div.tdp-col-2.mt-10.ng-star-inserted > img")
    protected WebElement btnOpcionPlanNuevo;

    @FindBy(xpath = "//div[@class='tdp-col-md-2 ng-star-inserted']")
    protected List<WebElement> listPlanesNuevos;

    @FindBy(xpath = "//button[@class='btnSky btnsForms']")
    protected WebElement lblSeleccionarOferta;

    @FindBy(css = "div.footer_servicio > div > div > div:nth-child(2) > app-footer-item > div > div.tdp-container.background_container > div.tdp-row.buttonW.tdp-mt-1.ng-star-inserted > div > button")
    protected WebElement lblCartillaCambiar ;

    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;



    public void selecciono_la_cartilla_del_plan_Activo() {
        
        js().scrollElementTop(cartillaHogar);
        waitUntilElementIsVisible(cartillaHogar, 5);
        click(cartillaHogar, 5);
        UtilWeb.waitForSeconds(10);

    }

    public void seleccionPlanNuevoParaVerLasOfertas() {

        UtilWeb.waitForSeconds(4);
        click(btnOpcionPlanNuevo);
        UtilWeb.waitForSeconds(4);
    }


    public void seleccionoElTipoDePlanHogar(String planHogar) {
        UtilWeb.waitForSeconds(4);
        clickElementInAList(listaPlanFija,planHogar);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(String planTrio) {
        UtilWeb.waitForSeconds(5);
        String elemento = "//div[contains(text(),'" + planTrio + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", planTrio);
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsVisible(lblSeleccionarOferta, 10);
        click(lblSeleccionarOferta, 10);
    }

    public void luegoDoyClickEnLaCartillaCambiarPlanHogar() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(lblCartillaCambiar);
        waitUntilElementIsVisible(lblCartillaCambiar, 10);
        click(lblCartillaCambiar, 10);




    }

    public void scrollUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

}
