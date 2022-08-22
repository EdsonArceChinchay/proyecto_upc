package com.tdp.ct.web.page.Paquetizacion;


import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaquetizacionDuoMasMonoPorCallCenterPage extends WebBase {

    @FindBy(xpath = "//*[@class='card']//*[contains(text(),'TV+Internet')]")
    protected WebElement botonDuo;

    @FindBy(xpath = "//*[@class='card']//*[contains(text(),'Voice')]")
    protected WebElement botonMono;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    protected WebElement botonContinuar;


    public void clickMonoYDuo() {

        waitUntilElementIsVisible(botonDuo,30);
        js().scrollElementTop(botonDuo);
        click(botonDuo);
        System.out.println("click duo");
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(botonMono,30);
        click(botonMono);
        System.out.println("click mono");
        UtilWeb.waitForSeconds(5);
    }

    public void clickBotonContinuar() {
        waitUntilElementIsVisible(botonContinuar,30);
        botonContinuar.click();
    }
}
