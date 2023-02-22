package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

public class AltaFijaAltaMovilRetailPage extends WebBase {

    @FindBy(css = ".tdp-col-sm-4:nth-child(1) .stl-line_new")
    protected WebElement btnHogar;

    @FindBy(css = ".tdp-col-sm-2:nth-child(2) .stl-movil")
    protected WebElement btnMovil;

    @FindBy(xpath = "//*[contains(text(),'Mostrar')]")
    protected WebElement btnMostrar;

    @FindBy(xpath = "//div[1]/tdp-st-card[1]/div/div[2]/form/div[6]/div/button")
    protected WebElement btnConsulta;

    @FindBy(xpath = "/html/body/app-root/app-address-mt/div[2]/app-address-form/div[1]/tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement cobertura;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;
    private String inputCorreo;


    @FindBy(xpath = "/html/body/app-root/app-alta-movil/app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[4]/div")
    protected WebElement AnadirEquipos;


    public void altaHogar(){
        js().scrollElementTop(btnHogar);
        UtilWeb.waitForSeconds(15);
        waitUntilElementIsClickable(btnHogar,30);
        click(btnHogar);
        waitUntilElementIsVisible(btnMovil,5);
        UtilWeb.waitForSeconds(2);
    }

    public void altaMovil(){
        js().scrollElementTop(btnMovil);
        waitUntilElementIsClickable(btnMovil,15);//30
        click(btnMovil);
        UtilWeb.waitForSeconds(2);//1
    }

    public void mostrarOfertas(){
        System.out.println("3");
        waitUntilElementIsVisible(btnMostrar,90);//50
        click(btnMostrar);
        UtilWeb.waitForSeconds(12);
        //UtilWeb.waitForSeconds(2);
    }
    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//*[contains(text(),'Reintentar')]")).size() !=0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        }
        else {
            System.out.println("No se encontro el modal error");
        }
    }

    public void seleccionarDepa(String tipoDepa){
        UtilWeb.waitForSeconds(4);//2
        WebElement depaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
        click(depaList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(depaList);
        context.findElement(By.cssSelector("[data-value='"+tipoDepa+"']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarProvincia(String tipoProvincia){
        WebElement provinciaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        click(provinciaList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(provinciaList);
        context.findElement(By.cssSelector("[data-value='"+tipoProvincia+"']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarDistrito(String tipoDistrito){
        WebElement distritoList= find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        click(distritoList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(distritoList);
        context.findElement(By.cssSelector("[data-value='"+tipoDistrito+"']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void writeDireccion(String direc){
        WebElement Input= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(4) > div > tdp-st-input-text");
        click(Input);
        type(Input, direc);
    }

    public void writeReferencia(String referencia){
        WebElement Refer= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(5) > div > tdp-st-input-text");
        click(Refer);
        type(Refer, referencia);
    }

    public void btnConsultar(){

        waitUntilElementIsVisible(btnConsulta,8);
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnConsulta);
        click(btnConsulta);
    }

    public void writeManzana(String manzana){
        UtilWeb.waitForSeconds(1);
        WebElement Mz= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(1) > tdp-st-input-text");
        click(Mz);
        UtilWeb.waitForSeconds(1);
        type(Mz, manzana);
    }

    public void writeLote(String lote){
        WebElement Lte= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(2) > tdp-st-input-text");
        click(Lte);
        type(Lte, lote);
    }

    public void writePiso(String piso){
        WebElement Npiso= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(1) > tdp-st-input-text");
        click(Npiso);
        type(Npiso, piso);
    }

    public void writeInterior(String inte){
        WebElement NInterior= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(2) > tdp-st-input-text");
        click(NInterior);
        type(NInterior, inte);
    }

    public void seleccionarConjuntoHabitacional(String tipoConjunto){
        WebElement conjuntoList= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(6) > div > tdp-st-select");
        click(conjuntoList);
        SearchContext context=sh().getContext(conjuntoList);
        context.findElement(By.cssSelector("[data-value='"+tipoConjunto+"']")).click();
    }

    public void writeConjHab(String hab){
        WebElement ConjHab= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(7) > div > tdp-st-input-text");
        click(ConjHab);
        type(ConjHab, hab);
    }

    public void consultaCobertura(){

        click(cobertura);
        UtilWeb.waitForSeconds(3);
    }

    public void tipearCorreo(String correo){
        inputCorreo = correo;
        String getCorreo = "div form div:nth-child(4) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement correoElement = js().getWebElement(getCorreo);
        click(correoElement);
        correoElement.sendKeys(inputCorreo);

        String inputCorreo2 = "div form div:nth-child(5) tdp-st-input-text;input";
        WebElement correoElement2 = js().getWebElement(inputCorreo2);
        click(correoElement2);
        type(correoElement2, correo);

        UtilWeb.waitForSeconds(3);
    }


    public void reintarPopPup(){
        boolean btnReintentarboolean;
        btnReintentarboolean = driver().findElements(By.xpath("//*[contains(text(),'Reintentar') or contains(@class,'button-light-green ng-star-inserted')]")).size() != 0;
        if (btnReintentarboolean) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Modal Reintentar");
            WebElement btnReintentar= find().getElementByXPath("//*[contains(text(),'Reintentar') or contains(@class,'button-light-green ng-star-inserted')]");
            js().scrollElementTop(btnReintentar);
            btnReintentar.click();
            UtilWeb.waitForSeconds(3);
        }

    }

}
