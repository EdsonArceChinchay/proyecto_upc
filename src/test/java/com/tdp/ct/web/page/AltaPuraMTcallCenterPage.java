package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AltaPuraMTcallCenterPage extends WebBase {

    public Object clicBotonAceptar;
    @FindBy(xpath = "//button[@class = 'button_step']")
    protected WebElement btnConfirmaUbicacion;

    private String tipoPago;

    @FindBy(xpath = "//span[contains(text(),'Continuar')]/..")
    protected WebElement buttonContinuar;

    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUoError;

    @FindBy(xpath = "//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    public void btnConfirmarUbicacion() {
        click(btnConfirmaUbicacion, 10);
        UtilWeb.waitForSeconds(5);
    }

    public void selectTipoHorario(String horario) {
        WebElement elegirHorario1 = find().getElementByXPath("//span[text()='" + horario + "']/..");
        click(elegirHorario1);
    }

    public void completarIdCall(String idCall) {

        WebElement rootInputConfirmarCorreo = find().getElementByCss("tdp-st-input-text[formcontrolname=\"callID\"]");
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
        correoElement.sendKeys(Keys.CONTROL + "a");
        correoElement.sendKeys(Keys.DELETE);
        type(correoElement, verifCorreo);

        UtilWeb.waitForSeconds(5);
    }

    public void clicBotonContinuar() {
        modalError(5, btnReintentar, "Click al elemento Reintentar");
        modalError(5, btnReintentar, "Click al elemento Reintentar");
        modalError(5, btnReintentar, "Click al elemento Reintentar");
        waitUntilElementIsVisible(buttonContinuar, 100);
        js().scrollElementTop(buttonContinuar);
        waitUntilElementIsClickable(buttonContinuar, 100);
        click(buttonContinuar,20);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
        UtilWeb.waitForSeconds(5);
    }

    public void clickCierrePopup(){
        UtilWeb.waitForSeconds(8);//inhabilitado
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistente;
        //elementoExistente = driver().findElements(By.xpath("(//div[@class='icon-content'])[2]")).size() !=0;
        elementoExistente = driver().findElements(By.xpath("//div[@class='dialog-container']")).size() !=0;
        if (elementoExistente){
            System.out.println("Se cierra Popup de error");
            UtilWeb.waitForSeconds(3);
            click(cierrePopUoError);
            UtilWeb.waitForSeconds(2);
        }else {
            System.out.println("no se encontró mensaje de error");
            UtilWeb.waitForSeconds(2);
        }
    }

    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        } else {
            System.out.println("No se encontro el modal error");
        }
    }

    public void ingresarTelefono(String telefono) {
        WebElement direccionElement = find().getElementByXPath("//*[@formcontrolname='contactNumber']");
        js().scrollElementTop(direccionElement);
        click(direccionElement,5);
        type(direccionElement, telefono);
    }
}
