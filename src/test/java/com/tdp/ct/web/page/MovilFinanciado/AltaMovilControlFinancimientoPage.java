package com.tdp.ct.web.page.MovilFinanciado;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class AltaMovilControlFinancimientoPage extends WebBase {

    @FindBy(xpath = "(//img[@class='margin-icon add_pointer'])[1]")
    protected WebElement planActual;
    @FindBy(xpath = "//div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement planMovil;
    @FindBy(xpath = "(//div[@class='offert-card-body'])[1]")
    protected WebElement selectCampaniaOferta;
    @FindBy(xpath = "//button[@class='btnCard' and contains(text(),'Línea nueva') or contains(text(),'Línea Nueva') or contains(text(),'Línea nueva') ]")
    protected WebElement btnLineaNueva;
    @FindBy(xpath = "//div[3]/app-summary-section/div/div/div[1]/div/tdp-st-button")
    protected WebElement btnAgregarEquipo;
    @FindBy(xpath = "//div[2]/div[1]/button[1]")
    protected WebElement btnPostpago;
    @FindBy(xpath = "//div[2]/div[1]/button[2]")
    protected WebElement btnControl;

    public void selectPlanActual() {
        click(planActual);
    }

    public void selectPlanMovil() {
        UtilWeb.waitForSeconds(8);
        js().scrollElementTop(planMovil);
        waitUntilElementIsVisible(planMovil, 20);
        click(planMovil);
    }

    public void selectCampania() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(selectCampaniaOferta, 5);
        click(selectCampaniaOferta);
    }

    public void selectBtnLineaNueva() {
        esperaProgresiva(driver(), 3, 10, btnLineaNueva);
        click(btnLineaNueva);
    }

    public void selectBtnPostpago() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(btnAgregarEquipo, 10);
        click(btnPostpago);
    }

    public void selectBtnControl() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(btnControl, 10);
        click(btnControl);
    }

}
