package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AltaFijaAltaMovilRetailPage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[1]/div[3]/div[1]")
    protected WebElement btnHogar;

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div/div[3]/div[2]")
    protected WebElement btnMovil;

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[2]/div[3]/button")
    protected WebElement btnMostrar;

    @FindBy(xpath = "//div[1]/tdp-st-card[1]/div/div[2]/form/div[6]/div/button")
    protected WebElement btnConsulta;

    @FindBy(xpath = "/html/body/app-root/app-address-mt/div[2]/app-address-form/div[1]/tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement cobertura;

    private String inputCorreo;

    public void altaHogar(){
        js().scrollElementTop(btnHogar);
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsClickable(btnHogar,30);
        click(btnHogar);
        waitUntilElementIsVisible(btnMovil,5);
        UtilWeb.waitForSeconds(2);
    }

    public void altaMovil(){
        waitUntilElementIsClickable(btnMovil,10);
        click(btnMovil);
        UtilWeb.waitForSeconds(5);
    }

    public void mostrarOfertas(){
        click(btnMostrar);
        //UtilWeb.waitForSeconds(2);
    }

    public void seleccionarDepa(String tipoDepa){
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
        //waitUntilElementIsVisible(btnConsulta,8);
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnConsulta);
        click(btnConsulta);
    }

    public void writeManzana(String manzana){
        UtilWeb.waitForSeconds(1);
        WebElement Mz= find().getElementByCss(" tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(1) > tdp-st-input-text");
        click(Mz);
        UtilWeb.waitForSeconds(1);
        type(Mz, manzana);

        /*String inputMz = "div:nth-child(6) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement inputMzElement = js().getWebElement(inputMz);
        System.out.println(inputMzElement + "reconocio input");
        click(inputMzElement);
        type(inputMzElement, manzana);*/
    }

    public void writeLote(String lote){
        WebElement Lte= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(2) > tdp-st-input-text");
        click(Lte);
        type(Lte, lote);

        /*String inputLote = "div:nth-child(6) div:nth-child(2) tdp-st-input-text";
        WebElement inputLoteElement = js().getWebElement(inputLote);
        click(inputLoteElement);
        type(inputLoteElement, lote);*/
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

}
