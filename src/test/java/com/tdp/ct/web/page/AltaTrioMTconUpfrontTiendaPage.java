package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

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

    public void seleccionoTipoDocumentoSupervisor(String tipoDoc) {
        WebElement distritoList = find().getElementByXPath(" //*[@id=\"modal\"]/div[2]/div/div[3]/app-modal-discapacitado//div[3]//mat-form-field");
        click(distritoList);
        SearchContext context = sh().getContext(distritoList);
        context.findElement(By.cssSelector("[id='" + tipoDoc + "']")).click();
    }

    public void ingresoNumeroDocumentoSuper(String documentoSuper) {
        WebElement numeroDocument = find().getElementByCss("#doc");
        click(numeroDocument);
        type(numeroDocument, documentoSuper);
    }

    public void ingresoUsuarioSupervisor(String user) {
        WebElement usuario = find().getElementByCss("#usuarioCitrixSupervisor");
        click(usuario);
        type(usuario, user);
    }

    public void ingresoContraseñaSupervisor(String passw) {
        WebElement contraseña = find().getElementByCss("#passwordCitrixSupervisor");
        click(contraseña);
        type(contraseña, passw);
    }




}