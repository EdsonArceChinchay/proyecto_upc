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


public class AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage extends WebBase {

    @FindBy(xpath = "//app-card-line/div/div[2]/img")
    protected WebElement lblVerDetalle;

    @FindBy(xpath = "//tdp-st-modal/div[3]/form/div/div[2]/tdp-st-button")
    protected WebElement btnAgregarSva;
    @FindBy(xpath = "//button[@class='button-light-green']")
    protected WebElement btnGuardarCambios;
//    @FindBy(css = ".services-section:nth-child(1) .section-container .row-content:nth-child(1) .actions-content .tdp-st-icon-button:nth-child(1)")
//    protected WebElement iconPlus;

  //  public void clickBTnIconPlus(){
      //  WebElement element = sh().getWebElement(iconPlus, "button");
    //}




    public void selecciono_agregar_sva_fija() {
        UtilWeb.waitForSeconds(5);
        click(lblVerDetalle,5);
        UtilWeb.waitForSeconds(5);
        click(btnAgregarSva,5);

    }

    public void scrollUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,500)");
    }

    public void seleccionamosGuardarCambios() {
        UtilWeb.waitForSeconds(5);
        click(btnGuardarCambios,5);

    }
}