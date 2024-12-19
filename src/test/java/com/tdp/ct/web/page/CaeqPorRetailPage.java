package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.WebUtils.compareStringAndString;

public class CaeqPorRetailPage extends WebBase {

    @FindBy(xpath = "//div/button[@class=\"btnCard\"]")
    protected WebElement botonMantenerPlan;
    @FindBy(xpath = "(//*[contains(@class,'add_Product') or contains(text(),'Añadir equipo') or  contains(text(),'Agregar Equipo')])[1]")
    protected WebElement LblEquipos;
    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement lblSeleccionarOferta;
    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement BtnCambiarPlan;

    public void clickOnAddDevice() {
        UtilWeb.waitForSeconds(3);
        esperaProgresiva(driver(), 3, 5, LblEquipos);
        js().scrollElementTop(LblEquipos);
        click(LblEquipos, 5);
        UtilWeb.waitForSeconds(5);
    }

    public void clickOnAddDevice(int num) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(2);
        WebElement btnAddDevice = find().getElementByXPath("(//div[contains(text(),'Añadir equipo')])[" + num + "]");
        esperaProgresiva(driver(), 5, 5, btnAddDevice);
        js().scrollElementTop(btnAddDevice);
        click(btnAddDevice);
        UtilWeb.waitForSeconds(1);
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
        compareStringAndString(valueCAEQ, valuesMovil.get("CAEQ"));
        compareStringAndString(valueCAPL, valuesMovil.get("CAPL"));
        compareStringAndString(valueCASI, valuesMovil.get("CASI"));
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsClickable(lblSeleccionarOferta, 40);//10
        click(lblSeleccionarOferta, 10);
    }


}
