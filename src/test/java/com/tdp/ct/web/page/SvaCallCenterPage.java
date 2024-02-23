package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
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

public class SvaCallCenterPage extends WebBase{

    @FindBy(xpath = "//div[@class='detailHogar']")
    protected WebElement detalle;

    @FindBy (xpath = "(//div/div/tdp-st-button)[2]")
    protected WebElement agregarsva;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/tdp-st-icon-button[1]")
    protected WebElement sva_repetidor;

    @FindBy(xpath = "//button[contains(text(),' Guardar cambios ')]")
    protected WebElement guardar;

    @FindBy(xpath = "//div[text()='MOVISTAR TV APP']/parent::div/../descendant-or-self::tdp-st-checkbox")
    protected WebElement movistarTvApp;

    public void ver_detalle(){
        waitUntilElementIsClickable(detalle,50);
        js().scrollElementTop(detalle);
        click(detalle);
        UtilWeb.waitForSeconds(5);

    }

    public void agregar_sva_fija(){
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(agregarsva);
        waitUntilElementIsClickable(agregarsva,30);
        click(agregarsva);
        UtilWeb.waitForSeconds(8);
    }

    public void elegir_sva(){
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsClickable(sva_repetidor,30);
        click(sva_repetidor);
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(guardar);
        click(guardar);

    }

    public void clickSvaMovistarTvApp() {
        UtilWeb.waitForSeconds(10);
       //WebElement btnbloque = find().getElementByCss("div.container-actions > div.actions-content > div > tdp-st-checkbox");
        //waitUntilElementIsVisible(btnbloque, 10);
        js().scrollElementTop(movistarTvApp);
        click(movistarTvApp);
    }
}
