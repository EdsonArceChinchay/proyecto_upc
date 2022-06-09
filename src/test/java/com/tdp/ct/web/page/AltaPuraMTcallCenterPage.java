package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AltaPuraMTcallCenterPage extends WebBase {

    @FindBy(xpath = "//button[@class = 'button_step']")
    protected WebElement btnConfirmaUbicacion;

    private String tipoPago;

    @FindBy(xpath = "//span[contains(text(),'Continuar')]/..")
    protected WebElement buttonContinuar;

    //@FindBy(xpath = "(//div[@class='icon-content']/span[@class = 'stl-icon-cerrar']/img)[2]")
    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUoError;

    public void btnConfirmarUbicacion() {
        click(btnConfirmaUbicacion, 10);
        UtilWeb.waitForSeconds(5);
    }

    public void selectTipoHorario(String horario) {
        WebElement elegirHorario1 = find().getElementByXPath("//span[text()='" + horario + "']/..");
        click(elegirHorario1);
    }

    public void completarIdCall(String idCall) {

        WebElement rootInputConfirmarCorreo = find().getElementByXPath("(//div[contains(@class,'tdp-row')]//tdp-st-input-text)[2]");
        SearchContext context3 = sh().getContext(rootInputConfirmarCorreo);
        context3.findElement(By.cssSelector("div > div > div > input")).sendKeys(idCall);

        UtilWeb.waitForSeconds(1);
    }

    public void selectTipoDePago(String tipo) {
        tipoPago = tipo;

        String clickTipo = "div form div:nth-child(7) tdp-st-select;div:nth-child(1)";
        WebElement tipoElement = js().getWebElement(clickTipo);
        click(tipoElement);

        switch (tipo) {
            case "Boleta":
                String selectTipo = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(1)";
                WebElement selectElement = js().getWebElement(selectTipo);
                click(selectElement);
                break;
            case "Factura":
                String selectTipo2 = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(2)";
                WebElement selectElement2 = js().getWebElement(selectTipo2);
                click(selectElement2);
                break;
        }

        /*String inputMz = "div:nth-child(6) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement inputMzElement = js().getWebElement(inputMz);
        System.out.println(inputMzElement + "reconocio input");
        click(inputMzElement);
        type(inputMzElement, manzana);*/
    }

    public void ingresoDireccionTT(String direccion){
        String getDireccion = "form div:nth-child(3) div:nth-child(2) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(3);
        WebElement direccionElement = js().getWebElement(getDireccion);
        click(direccionElement);
        type(direccionElement, direccion);
    }

    public void ingresarReferencia(String referencia){
        String getReferencia = "form div:nth-child(4) div:nth-child(2) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(3);
        WebElement referenciaElement = js().getWebElement(getReferencia);
        click(referenciaElement);
        type(referenciaElement, referencia);
    }

    public void ingresarCorreoVerif(String verifCorreo){
        String getCorreo = "div form div:nth-child(3) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement correoElement = js().getWebElement(getCorreo);
        click(correoElement);
        type(correoElement, verifCorreo);

        String inputCorreo2 = "div form div:nth-child(4) tdp-st-input-text;input";
        WebElement correoElement2 = js().getWebElement(inputCorreo2);
        click(correoElement2);
        type(correoElement2, verifCorreo);

        UtilWeb.waitForSeconds(3);
    }

    public void clicBotonContinuar() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonContinuar, 10).click();
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");

        UtilWeb.waitForSeconds(60);
    }

    public void clickCierrePopup(){
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistente;
        //elementoExistente = driver().findElements(By.xpath("(//div[@class='icon-content'])[2]")).size() !=0;
        elementoExistente = driver().findElements(By.xpath("//div[@class='dialog-container']")).size() !=0;
        if (elementoExistente){
            System.out.println("Se cierra Popup de error");
            click(cierrePopUoError);
            UtilWeb.waitForSeconds(4);

        }else {
            System.out.println("no se encontró mensaje de error");
            UtilWeb.waitForSeconds(4);
        }
    }

}
