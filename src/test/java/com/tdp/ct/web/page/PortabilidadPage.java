package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class PortabilidadPage extends WebBase {


    @FindBy(xpath = "//*[@class='buttonG' and contains(text(),'Consultar')]")
    protected WebElement btnConsultar;

    @FindBy(xpath = "//div[contains(text(),'Portabilidad')]")
    protected WebElement btnPortabilidad;

    @FindBy(xpath = "//button[contains(text(),'Portabilidad móvil')]")
    protected WebElement btnPortaMovil;




    public void clickBotonPortabilidad() {
        waitUntilElementIsVisible(btnPortabilidad,10);
        js().scrollElementTop(btnPortabilidad);
        esperaProgresiva(driver(),5,5,btnPortabilidad);
        click(btnPortabilidad);
        UtilWeb.waitForSeconds(5);
    }

    public void ingresarNumeroPortar(String numero) {
        UtilWeb.waitForSeconds(5);
        WebElement document= find().getElementByCss(".tdp-col-sm-9:nth-child(1) .ng-pristine");
        click(document);
        type(document, numero);

    }

    public void escogerTipoLinea(String plan) {
        UtilWeb.waitForSeconds(4);//
        WebElement listElementPLan = find().getElementByCss(".tdp-col-sm-9:nth-child(2) .ng-pristine");
        click(listElementPLan);
        UtilWeb.waitForSeconds(4);//es 1
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.className("mdc-list-item"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(plan)) {
                UtilWeb.waitForSeconds(1);
                click(elements, 30);
            }
        }

    }

    public void esogerTipoOperador(String operador) {
        UtilWeb.waitForSeconds(4);//
        WebElement listElementPLan = find().getElementByCss(".tdp-col-sm-9:nth-child(5) .ng-pristine");
        js().scrollElementTop(listElementPLan);
        click(listElementPLan);
        UtilWeb.waitForSeconds(4);//es 1
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.className("mdc-list-item"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(operador)) {
                UtilWeb.waitForSeconds(1);
                click(elements, 30);
            }
        }

    }

    public void clickBotonConsultar() {
        waitUntilElementIsVisible(btnConsultar,10);
        js().scrollElementTop(btnConsultar);
        btnConsultar.click();
        //click(btnConsultar);
        //waitUntilElementIsVisible(boton01,20);
        UtilWeb.waitForSeconds(5);

    }

    public void clickPortaMovil() {
        waitUntilElementIsVisible(btnPortaMovil,20);
        js().scrollElementTop(btnPortaMovil);
        btnPortaMovil.click();
        //click(btnConsultar);
        //waitUntilElementIsVisible(boton01,20);
        UtilWeb.waitForSeconds(5);

    }
}
