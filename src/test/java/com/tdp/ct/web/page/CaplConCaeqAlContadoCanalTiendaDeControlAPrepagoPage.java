package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage extends WebBase {

    @FindBy(xpath = "(//*[@class=\"detailHogar\"])[1]")
    protected WebElement btnCardPlanActual;
    @FindBy(xpath = "//button[contains(text(),' Renovar ')]")
    protected WebElement btnRenovarPlan;

    @FindBy(xpath = "//*[@label='Seleccionar Oferta']")
    protected WebElement btnSelectOferta;

    @FindBy(xpath = "//app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[1]/div[2]/div[2]/span")
    protected WebElement lblNewPlanName;

    @FindBy(css = ".tdp-col-md-6:nth-child(1) .add_Product")
    protected WebElement btnAddEquipoInCard;

    @FindBy(xpath = "//*[@class='btn-start']//tdp-st-button[@label='Iniciar Registro']")
    protected WebElement btnConShadowIniciarRegistro;


    public void esperarBtnCardPlanActual() {
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(find().getElementByCss("h1.titleForm"));
    }

    public void clickBtnCardPlanActual() {
        esperaProgresiva(driver(), 3, 5, btnCardPlanActual);
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnCardPlanActual);
        js().scrollElementTop(btnCardPlanActual);
        click(btnCardPlanActual);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnRenovarPlan() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnRenovarPlan);
        js().scrollElementTop(btnRenovarPlan);
        click(btnRenovarPlan);
        System.out.println("click renovar");
        UtilWeb.waitForSeconds(1);
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

    public void clickBtnConShadowIniciarRegistro() {
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(btnConShadowIniciarRegistro, 20);
        click(btnConShadowIniciarRegistro);
    }

    public void writeEmail(String email) {
        revisarModalError(driver());
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
