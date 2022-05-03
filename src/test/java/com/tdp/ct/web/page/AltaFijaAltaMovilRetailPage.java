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
    @FindBy(xpath = "/html/body/app-root/app-address-mt/div[2]/app-address-form/div[1]/tdp-st-card[1]/div/div[2]/form/div[6]/div/button")
    protected WebElement btnConsulta;
    @FindBy(xpath = "/html/body/app-root/app-address-mt/div[2]/app-address-form/div[1]/tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement cobertura;

    public void altaHogar(){
        js().scrollElementTop(btnHogar);
        click(btnHogar);
        waitUntilElementIsVisible(btnMovil,5);
        UtilWeb.waitForSeconds(2);
    }

    public void altaMovil(){
        click(btnMovil);
        UtilWeb.waitForSeconds(5);
    }

    public void mostrarOfertas(){
        click(btnMostrar);
        UtilWeb.waitForSeconds(2);
    }

    public void seleccionarDepa(String tipoDepa){
        WebElement depaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
        click(depaList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(depaList);
        context.findElement(By.cssSelector("[data-value='"+tipoDepa+"']")).click();
    }

    public void seleccionarProvincia(String tipoProvincia){
        WebElement provinciaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        click(provinciaList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(provinciaList);
        context.findElement(By.cssSelector("[data-value='"+tipoProvincia+"']")).click();
    }

    public void seleccionarDistrito(String tipoDistrito){
        WebElement distritoList= find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        click(distritoList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(distritoList);
        context.findElement(By.cssSelector("[data-value='"+tipoDistrito+"']")).click();
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
        click(btnConsulta);
        UtilWeb.waitForSeconds(3);
    }

    public void writeManzana(String manzana){
        WebElement Mz= find().getElementByCss(" tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(1) > tdp-st-input-text");
        click(Mz);
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
        UtilWeb.waitForSeconds(2);
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

}
