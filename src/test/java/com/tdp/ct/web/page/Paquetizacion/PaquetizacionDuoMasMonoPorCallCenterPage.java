package com.tdp.ct.web.page.Paquetizacion;


import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaquetizacionDuoMasMonoPorCallCenterPage extends WebBase {

//    @FindBy(xpath = "//*[@class='card']//*[contains(text(),'TV+Internet')]")
//    protected WebElement botonDuo;
//
//    @FindBy(xpath = "//*[@class='card']//*[contains(text(),'Voice')]")
//    protected WebElement botonMono;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    protected WebElement botonContinuar;


    public void clickMonoYDuo(String mono , String duo) {
        UtilWeb.waitForSeconds(2);
        WebElement btnDuo = find().getElementByXPath("//*[@class='card']//*[contains(text(),'"+duo.trim()+"')]");
        waitUntilElementIsVisible(btnDuo,30);
        js().scrollElementTop(btnDuo);
        click(btnDuo);
        System.out.println("click duo");
        UtilWeb.waitForSeconds(2);
        WebElement btnMono = find().getElementByXPath("//*[@class='card']//*[contains(text(),'"+mono.trim()+"')]");
        waitUntilElementIsVisible(btnMono,30);
        click(btnMono);
        System.out.println("click mono");
        UtilWeb.waitForSeconds(5);
    }

    public void clickBotonContinuar() {
        waitUntilElementIsVisible(botonContinuar,30);
        botonContinuar.click();
    }



}
