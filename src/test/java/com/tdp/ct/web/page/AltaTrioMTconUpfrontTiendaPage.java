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

    @FindBy(xpath = "//button[contains(text(),'Línea nueva') or contains(text(),'Línea Nueva')]")
    protected WebElement btnLineaNueva;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;

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

    @FindBy(xpath = "//*[@class='detalle_sub']")
    protected WebElement subDetalles;

    @FindBy(xpath = "//*[contains(text(),'aplica UPFRONT')]")
    protected WebElement lblAplicaUpFront;

    public void subDetalles(){
        UtilWeb.waitForSeconds(5);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        esperaProgresiva(driver(), 5, 10, subDetalles);
        click(subDetalles);
    }

    public void lblAplicaUpFrom(){
        UtilWeb.waitForSeconds(1);
        esperaProgresiva(driver(), 4, 10, lblAplicaUpFront);
        Assert.assertTrue("el elemento no existe",lblAplicaUpFront.isDisplayed());
        UtilWeb.waitForSeconds(1);
        click(subDetalles,5);
    }

    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUoError;

    public void clickCierrePopup() {
        UtilWeb.waitForSeconds(3);//inhabilitado
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='dialog-container']")).isEmpty();
        if (elementoExistente) {
            Addons.esperaProgresiva(driver(), 3, 5, cierrePopUoError);
            System.out.println("Se cierra Popup de error");
            try {
                click(cierrePopUoError);

            } catch (Exception e) {
                System.out.println("error al hacer click");
            }
        } else {
            System.out.println("no se encontró mensaje de error");
        }
    }
}