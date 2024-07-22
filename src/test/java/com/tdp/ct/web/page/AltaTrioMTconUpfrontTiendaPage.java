package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class AltaTrioMTconUpfrontTiendaPage extends WebBase {
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;

    @FindBy(xpath = "//button[contains(text(),'Línea nueva') or contains(text(),'Línea Nueva')]")
    protected WebElement btnLineaNueva;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmar;

    @FindBy(xpath = "//div[6]/div/div/button/span")
    protected WebElement btnValidarIdentidad;

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div/div[2]/div[2]/button")
    protected WebElement btnHuellaDes;

    @FindBy(xpath = "//div[3]/app-footer-item/div/div[2]/div[3]/div/button")
    protected WebElement btnMovistarTotal;

    public void clickBotonLineaNueva() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnLineaNueva);
        waitUntilElementIsVisible(btnLineaNueva, 15);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBotonIrMovistarTotal() {
        esperaProgresiva(driver(),4,5,botoneraIrA.get(1));
        revisarModalError(driver());
        click(botoneraIrA.get(1));
        UtilWeb.waitForSeconds(1);
    }

    public void ingresoTelefonoContacto(String numContacto) {
        UtilWeb.waitForSeconds(10);
        WebElement numeroContac = find().getElementByCss("div:nth-child(1) > div:nth-child(1) > tdp-st-input-text");
        click(numeroContac);
        type(numeroContac, numContacto);

    }

    public void clickBotonConfirmar() {

        js().scrollElementTop(btnConfirmar);
        UtilWeb.waitForSeconds(5);
        esperaProgresiva(driver(), 3,5,btnConfirmar);
        waitUntilElementIsClickable(btnConfirmar, 10);
        click(btnConfirmar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a confirmar agendamiento");
        UtilWeb.waitForSeconds(10);
        esperaProgresiva(driver(),3,3,buttonValidarContrato);
    }

    public void ingresoCorreoElectronico(String correoElectronico) {
        WebElement ingresoCorreo = find().getElementByCss("div:nth-child(02) > div > div > div > tdp-st-input-text");
        click(ingresoCorreo);
        type(ingresoCorreo, correoElectronico);
    }

    public void vuelveIngresarCorreoElectronico(String vuelveIngresarCorreo) {
        WebElement vuelveIngresarC = find().getElementByCss("div:nth-child(3) > div > div > div > tdp-st-input-text");
        click(vuelveIngresarC);
        type(vuelveIngresarC, vuelveIngresarCorreo);
    }

    public void clickBotonValidarIdentidad() {
        click(btnValidarIdentidad);
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

    public void seleccionoElNombreDePlanMovistarTotal() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnMovistarTotal);
        waitUntilElementIsClickable(btnMovistarTotal, 10);
        click(btnMovistarTotal);
    }

    public void scrollFinalPagina() {
        Addons.scrollFinalPagina(driver());
        UtilWeb.waitForSeconds(2);
    }
}