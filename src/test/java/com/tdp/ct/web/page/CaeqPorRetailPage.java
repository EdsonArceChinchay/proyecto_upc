package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.Helper.compareStringAndString;
import static com.tdp.ct.web.utils.Helper.compareWebElementTextAndString;

public class CaeqPorRetailPage extends WebBase {

    @FindBy(xpath = "//div/button[@class=\"btnCard\"]")
    protected WebElement botonMantenerPlan;

    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement BtnCambiarPlan;

    public void btnAnadirEquipo(int num) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(2);
        WebElement btnAñadirEquipo = find().getElementByXPath("(//div[contains(text(),'Añadir equipo')])[" + num + "]");
        esperaProgresiva(driver(), 5, 5, btnAñadirEquipo);
        js().scrollElementTop(btnAñadirEquipo);
        click(btnAñadirEquipo);
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

    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement lblSeleccionarOferta;

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsClickable(lblSeleccionarOferta, 40);//10
        click(lblSeleccionarOferta, 10);
    }

    @FindBy(xpath = "(//*[contains(@class,'add_Product') or contains(text(),'Añadir equipo') or  contains(text(),'Agregar Equipo')])[1]")
    protected WebElement LblEquipos;
    public void seleccionarEquipo() {
        UtilWeb.waitForSeconds(3);
        esperaProgresiva(driver(),3,5,LblEquipos);
        js().scrollElementTop(LblEquipos);
        click(LblEquipos, 5);
        UtilWeb.waitForSeconds(5);
    }


}
