package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static java.awt.event.KeyEvent.*;

public class HomePage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[1]/div[3]/div[1]")
    protected WebElement boton01;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnconsultar;

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div")
    protected WebElement txtNombre;

    @FindBy(xpath = "//app-client-info")
    protected WebElement txtNombreRuc;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnConsultar;

    @FindBy(xpath = "//*[@class='validation']//tdp-st-input-text")
    protected WebElement txtDocumento;

    @FindBy(xpath = "//*[@class='validation']//app-simple-button")
    protected WebElement btnValidar;

    @FindBy(xpath = "//*[@class='validation']//tdp-st-select")
    protected WebElement listaDocumentos;



    public void seleccionoTipoDocumento(String tipoDocumento){
        UtilWeb.waitForSeconds(2);
        WebElement documentoList= find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
        js().scrollElementTop(documentoList);
        click(documentoList);
        String valueTipoDocumento="";
        SearchContext context=sh().getContext(documentoList);
        switch (tipoDocumento) {
            case "CE": case "C":
                valueTipoDocumento="C";
                break;
            case "DNI":
                valueTipoDocumento="DNI";
                break;
            case "Pasaporte": case "P":
                valueTipoDocumento="P";
                break;
            case "RUC":
                valueTipoDocumento="RUC";
                break;
            default:
                throw new IllegalArgumentException("Tipo de documento no existe " + tipoDocumento);
        }
        context.findElement(By.cssSelector("[data-value='"+valueTipoDocumento+"']")).click();

    }

    public void ingresoDocumento(String documento){
        WebElement document= find().getElementByCss("#doc");
        click(document);
        type(document, documento);

    }
    public void clickBotonConsultar(){
        waitUntilElementIsVisible(btnconsultar,10);
        click(btnconsultar);
        waitUntilElementIsVisible(boton01,20);
        UtilWeb.waitForSeconds(20);//10
    }

    public void validarDatosCliente(String nombre, String tipoDocumento, String nroDocumento) {
        UtilWeb.waitForSeconds(2);
        String Nombre="";
        String expectedNombre = nombre.trim().toUpperCase();
        String expectedTipoDocumento = tipoDocumento.trim().toUpperCase();
        String expectedNroDocumento = nroDocumento.trim().toUpperCase();
        boolean datosClienteNatural;
        datosClienteNatural = driver().findElements(By.xpath("//*[contains(@class,'info-user')]/div")).size() != 0;
        if(datosClienteNatural)  {Nombre=txtNombre.getText().trim().toUpperCase();
            System.out.println("Entro en Natural");}
        boolean datosClienteEmpresa;
        datosClienteEmpresa = driver().findElements(By.xpath("//app-client-info")).size() != 0;
        if(datosClienteEmpresa) {Nombre=txtNombreRuc.getText().trim().toUpperCase();
            System.out.println("Entro en Ruc");}
        Assertions.assertTrue(Nombre.contains(expectedNombre), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedNombre);
        Assertions.assertTrue(Nombre.contains(expectedTipoDocumento), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedTipoDocumento);
        Assertions.assertTrue(Nombre.contains(expectedNroDocumento), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedNroDocumento);
        UtilWeb.waitForSeconds(2);
    }

    public void seleccionoElIDDeClienteNro(String nro) {
        WebElement nroItem = find().getElementByXPath("(//*[@class='table']/tbody/tr/td[1])["+nro.trim()+"]");
        waitUntilElementIsVisible(nroItem, 10).click();
        UtilWeb.waitForSeconds(1);
        WebElement btnGuardar = find().getElementByXPath("//*[contains(text(),'Guardar')]");
        waitUntilElementIsVisible(btnGuardar, 10).click();
    }

    public void clickBtnConsultar() {
        waitUntilElementIsVisible(btnConsultar, 10);
        click(btnConsultar);
    }


    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        UtilWeb.waitForSeconds(5);
        boolean serviciosContratados;
        serviciosContratados = driver().findElements(By.xpath("//app-card-line")).size() != 0;
        if (serviciosContratados) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El cliente SI tiene servicios contratados");
            js().scrollElementTop(find().getElementByXPath("//app-card-line"));
            UtilWeb.waitForSeconds(1);
        }
        else {
            Assertions.assertTrue(serviciosContratados,"El Cliente NO tiene servicios contratados");

        }
    }

    public void seleccionoElTipoDeDocumentoDelRepresentanteLegal(String tipDoc) {
        Boolean existe = false;
        String tipoDocEsperado = tipDoc.trim().toLowerCase();
        click(listaDocumentos);
        SearchContext context = sh().getContext(listaDocumentos);
        List<WebElement> listaDoc = context.findElements(By.cssSelector("ul li"));
        UtilWeb.waitForSeconds(1);
        for (int i = 0; i < listaDoc.size(); i++) {
            String nombretipoDoc = listaDoc.get(i).getText().trim().toLowerCase();
            if (nombretipoDoc.contains(tipoDocEsperado)) {
                existe = true;
                listaDoc.get(i).click();
            }
        }
        Assertions.assertTrue(existe, "no se encontro: " + tipoDocEsperado);


    }

    public void ingresoElNumeroDelDocumentoDelRepresentanteLegal(String numDoc) {
        waitUntilElementIsVisible(txtDocumento,10).click();
        type(txtDocumento,numDoc);
    }

    public void doyClickEnValidarRepresentaLegal() {
        waitUntilElementIsVisible(btnValidar,10).click();
    }
}
