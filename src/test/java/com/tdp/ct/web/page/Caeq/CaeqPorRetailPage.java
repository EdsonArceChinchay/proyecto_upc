package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class CaeqPorRetailPage extends WebBase {
    @FindBy(xpath = "/html/body/app-root/app-alta-movil/app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[4]/div")
    protected WebElement btnAnadirE;

    @FindBy(css = "tdp-st-button[label=\"Seleccionar\"]")
    protected  WebElement botonSeleecionar;

    @FindBy(xpath = "//div/button[@class=\"btnCard\"]")
    protected  WebElement botonMantenerPlan;

    @FindBy(xpath = "(//div/button[@class=\"buttonG\"])[3]")
    protected  WebElement botonConsultaClienteNuevo;
    public void btnAnadirEquipo() {
        UtilWeb.waitForSeconds(2);
        esperaProgresiva(driver(), 3, 5, btnAnadirE);
        js().scrollElementTop(btnAnadirE);
        click(btnAnadirE);
        //waitUntilElementIsClickable(btnAnadirE,20).click();
        UtilWeb.waitForSeconds(1);
    }

    public void btnSeleecionar() {
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(botonSeleecionar);
        //waitUntilElementIsVisible(botonSeleecionar,10);
        click(botonSeleecionar);
        UtilWeb.waitForSeconds(5);
    }

    public void btnMantenerPlan() {
        UtilWeb.waitForSeconds(5);
        click(botonMantenerPlan);
    }

    public void btnConsultarClienteNuevo() {
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(botonConsultaClienteNuevo);
        click(botonConsultaClienteNuevo);
    }
}
