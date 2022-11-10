package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage extends WebBase {

    @FindBy(xpath = "(//*[@class=\"detailHogar\"])")
    protected WebElement btnCardPlanActual;

    //@FindBy(css = ".div-botton div:nth-child(1) .btn-renovate-plan")
//@FindBy( xpath = "//*[@class='btn-renovate-plan btn-text btn-hover' and contains(text(),'Renovar')]")
    @FindBy(xpath = "(//tdp-st-button)[1]")
    protected WebElement btnRenovarPlan;


    @FindBy(xpath = "//*[@label='Seleccionar Oferta']")
    protected WebElement btnSelectOferta;

    @FindBy(xpath = "//app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[1]/div[2]/div[2]/span")
    protected WebElement lblNewPlanName;

    @FindBy(css = ".tdp-col-md-6:nth-child(1) .add_Product")
    protected WebElement btnAddEquipoInCard;

    @FindBy(css = ".col-2 ._info")
    protected WebElement caracteristicasContent;

    @FindBy(xpath = "//*[@class='btn-start']//tdp-st-button[@label='Iniciar Registro']")
    protected WebElement btnConShadowIniciarRegistro;

    public void esperarBtnCardPlanActual() {
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(find().getElementByCss("h1.titleForm"));
    }

    public void clickBtnCardPlanActual() {
        click(btnCardPlanActual);
        UtilWeb.waitForSeconds(10);
    }

    public void clickBtnRenovarPlan() {
        waitUntilElementIsVisible(btnRenovarPlan, 10);
        click(btnRenovarPlan);
        UtilWeb.waitForSeconds(10);
    }

    public void clickSelectOferta() {
        waitUntilElementIsVisible(btnSelectOferta, 10);
        btnSelectOferta.click();
        UtilWeb.waitForSeconds(1);
    }

    public void validarPlanSelected(String plan) {
        waitUntilElementIsVisible(lblNewPlanName, 10);
        String getPlanName = lblNewPlanName.getText().toLowerCase();
        Assertions.assertTrue(getPlanName.contains(plan.toLowerCase()), "El plan obtenido: " + getPlanName + " no coincide con lo esperado " + plan.toLowerCase());
    }

    public void esperarBtnAddEquipoInCard() {
        js().scrollElementTop(find().getElementByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)"));
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnAddEquipoInCard() {
        click(btnAddEquipoInCard);
        UtilWeb.waitForSeconds(5);
    }

    public void scrollToVerBtnDetalles() {
        js().scrollElementTop(find().getElementByCss(".button-offer:nth-child(1)"));
        UtilWeb.waitForSeconds(5);
    }

    public void clickBtnVerDetalle() {
        String btnVerOfertas = ".btn-detail tdp-st-button;button";
        WebElement element = js().getWebElement(btnVerOfertas);
        element.click();
    }

    public void clickBtnVerDetalle(String nroServicio) {
        WebElement btnVerDetalle = find().getElementByXPath("//div[@class='card']//*[contains(text(),'" + nroServicio + "')]//following::div[@class='detailHogar'][1]");
        waitUntilElementIsVisible(btnVerDetalle, 10);
        js().scrollElementTop(btnVerDetalle);
        btnVerDetalle.click();
    }

    public void validarFeatures() {
        Assertions.assertFalse(caracteristicasContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnSelectEquipo() {
        String btnSelect = ".cont-btn tdp-st-button;button";
        WebElement element = js().getWebElement(btnSelect);
        element.click();
    }

    public void clickBtnConShadowIniciarRegistro() {
        System.out.println("Paso por aqui");
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(btnConShadowIniciarRegistro, 20);
        click(btnConShadowIniciarRegistro);
        System.out.println("dio cliick");
    }

    public void writeEmail(String email) {
        UtilWeb.waitForSeconds(4);
        WebElement element1 = find().getElementByXPath("//*[@formcontrolname='mail']");
        WebElement ele1 = sh().getWebElement(element1, "input");
        clear(ele1);
        type(ele1, email);

        UtilWeb.waitForSeconds(1);
        WebElement element2 = find().getElementByXPath("//*[@formcontrolname='confirmEmail']");
        WebElement ele2 = sh().getWebElement(element2, "input");
        clear(ele2);
        type(ele2, email);
        UtilWeb.waitForSeconds(1);
    }
}
