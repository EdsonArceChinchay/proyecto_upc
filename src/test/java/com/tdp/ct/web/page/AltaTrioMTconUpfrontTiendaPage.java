package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.WebUtils.typeInShadowRoot;

public class AltaTrioMTconUpfrontTiendaPage extends WebBase {

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div/div[2]/div[2]/button")
    protected WebElement btnHuellaDes;

    @FindBy(xpath = "//div[3]/app-footer-item/div/div[2]/div[3]/div/button")
    protected WebElement btnMovistarTotal;

    public void seleccionoElNombreDePlanMovistarTotal() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnMovistarTotal);
        waitUntilElementIsClickable(btnMovistarTotal, 10);
        click(btnMovistarTotal);
    }

    public void clickDiscapacitadoHuellaDesgastado() {
        click(btnHuellaDes);
    }

    public void selectSupervisorDocumentType(String type) {
        WebElement documentList = find().getElementByXPath(" //*[@id=\"modal\"]/div[2]/div/div[3]/app-modal-discapacitado//div[3]//mat-form-field");
        click(documentList);
        SearchContext context = sh().getContext(documentList);
        context.findElement(By.cssSelector("[id='" + type + "']")).click();
    }

    public void typeSupervisorDocumentNumber(String document) {
        WebElement inputDocumentNumber = find().getElementByCss("#doc");
        typeInShadowRoot(inputDocumentNumber, "Number document", document);
    }

    public void typeSupervisorUser(String user) {
        WebElement inputUser = find().getElementByCss("#usuarioCitrixSupervisor");
        typeInShadowRoot(inputUser, "User", user);
    }

    public void typeSupervisorPassword(String password) {
        WebElement inputPassword = find().getElementByCss("#passwordCitrixSupervisor");
        typeInShadowRoot(inputPassword, "Password", password);
    }

}