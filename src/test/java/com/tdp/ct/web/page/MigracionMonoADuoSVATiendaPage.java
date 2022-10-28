package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MigracionMonoADuoSVATiendaPage extends WebBase {

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "//div[@class='container-btns']/button[contains(text(),'SVA')]")
    protected WebElement buttonAgregarSVA;
    @FindBy(css ="div:nth-child(2) > div > div:nth-child(1) > div.content-section > div > div.container-actions > div.actions-content > div > tdp-st-icon-button:nth-child(1)")
    protected WebElement CheckHBO;
    @FindBy(xpath = "//div/button[contains(text(),'Guardar cambios')]")
    protected WebElement buttonGuardarCambios;
    public void seleccionarboton(){
        System.out.println(1);
        UtilWeb.waitForSeconds(10);
        System.out.println(1);
        for(WebElement element:listaBotones){
            if (element.getText().contains("Cambiar plan hogar")){
                UtilWeb.waitForSeconds(2);
                click(element,30);
            }
        }
        UtilWeb.waitForSeconds(4);
    }

    public void clicEnAgregarSVA() {
        js().scrollElementTop(buttonAgregarSVA);
        waitUntilElementIsVisible(buttonAgregarSVA, 10);
        click(buttonAgregarSVA);
        UtilWeb.waitForSeconds(5);

    }

    public void SeleccionoBloques(String Bloques) {
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        click(CheckHBO);

    }

    public void clickGuardarCambios() {
        js().scrollElementTop(buttonGuardarCambios);
        waitUntilElementIsVisible(buttonGuardarCambios, 10);
        click(buttonGuardarCambios);
        UtilWeb.waitForSeconds(5);

    }
}
