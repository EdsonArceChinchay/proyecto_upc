package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage extends WebBase {

    @FindBy(css = ".detailHogar img")
    protected WebElement btnCardPlanActual;

    @FindBy(css = ".div-botton div:nth-child(1) .btn-renovate-plan")
    protected WebElement btnRenovarPlan;

    @FindBy(xpath = "//*[@label='Seleccionar Oferta']")
    protected WebElement btnSelectOferta;

    @FindBy(xpath = "//app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[1]/div[2]/div[2]/span")
    protected WebElement lblNewPlanName;

    @FindBy(css = ".tdp-col-md-6:nth-child(1) .add_Product")
    protected WebElement btnAddEquipoInCard;

    @FindBy(css = ".col-2 ._info")
    protected WebElement caracteristicasContent;

    @FindBy(xpath = "//*[@label='Iniciar Registro']")
    protected WebElement btnConShadowIniciarRegistro;

    public void esperarBtnCardPlanActual(){
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(find().getElementByCss("h1.titleForm"));
    }

    public void clickBtnCardPlanActual(){
        click(btnCardPlanActual);
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnRenovarPlan(){
        click(btnRenovarPlan);
    }

    public void clickSelectOferta() {
        btnSelectOferta.click();
        UtilWeb.waitForSeconds(1);
    }

    public void validarPlanSelected(String plan){
        waitUntilElementIsVisible(lblNewPlanName, 7);
        String getPlanName = lblNewPlanName.getText().toLowerCase();
        Assertions.assertTrue(getPlanName.contains(plan.toLowerCase()), "El plan obtenido: "+ getPlanName +" no coincide con lo esperado "+plan.toLowerCase());
    }

    public void esperarBtnAddEquipoInCard(){
        js().scrollElementTop(find().getElementByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)"));
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnAddEquipoInCard(){
        click(btnAddEquipoInCard);
        UtilWeb.waitForSeconds(5);
    }

    public void scrollToVerBtnDetalles(){
        js().scrollElementTop(find().getElementByCss(".button-offer:nth-child(1)"));
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnVerDetalle(){
        String btnVerOfertas = ".btn-detail tdp-st-button;button";
        WebElement element = js().getWebElement(btnVerOfertas);
        element.click();
    }

    public void validarFeatures(){
        Assertions.assertFalse(caracteristicasContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnSelectEquipo(){
        String btnSelect = ".cont-btn tdp-st-button;button";
        WebElement element = js().getWebElement(btnSelect);
        element.click();
    }

    public void clickBtnConShadowIniciarRegistro(){
        click(btnConShadowIniciarRegistro);
    }

    public void writeEmail(String email){
        UtilWeb.waitForSeconds(4);
        String element1 = "form div:nth-child(2) tdp-st-input-text;input";
        WebElement ele1 = js().getWebElement(element1);
        clear(ele1);
        type(ele1, email);

        UtilWeb.waitForSeconds(1);
        String element2 = "form div:nth-child(3) tdp-st-input-text;input";
        WebElement ele2 = js().getWebElement(element2);
        clear(ele2);
        type(ele2, email);
        UtilWeb.waitForSeconds(1);
    }
}
