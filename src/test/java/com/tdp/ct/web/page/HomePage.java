package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.awt.event.KeyEvent.*;

public class HomePage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[1]/div[3]/div[1]")
    protected WebElement boton01;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnconsultar;

    public void seleccionoTipoDocumento(String tipoDocumento){
        WebElement documentoList= find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
        click(documentoList);
        String valueTipoDocumento="";
        SearchContext context=sh().getContext(documentoList);
        switch (tipoDocumento) {
            case "CE":
                valueTipoDocumento="C";
                break;
            case "DNI":
                valueTipoDocumento="DNI";
                break;
            case "Pasaporte":
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
        UtilWeb.waitForSeconds(10);
    }

}
