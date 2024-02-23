package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;


public class AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage extends WebBase {

    @FindBy(xpath = "//app-card-line/div/div[2]/img")
    protected WebElement lblVerDetalle;

    @FindBy(xpath = "(//tdp-st-modal/div[3]/form/div/div[2]/tdp-st-button)")
    protected List<WebElement> listBtnAgregarSva;
    @FindBy(xpath = "//button[@class='button-light-green']")
    protected WebElement btnGuardarCambios;
    @FindBy(css = ".services-section:nth-child(1) .section-container .row-content:nth-child(1) .actions-content .tdp-st-icon-button:nth-child(1)")
    protected WebElement iconPlus;

    @FindBy(xpath = "//div//span[contains(text(),'Postpago')]")
    protected WebElement btnPostpago;

    public void selecciono_agregar_sva_fija() {
        esperaProgresiva(driver(), 3, 5, lblVerDetalle);
        click(lblVerDetalle);
        WebElement btnAgregarSva = listBtnAgregarSva.get(listBtnAgregarSva.size() - 1);
        esperaProgresiva(driver(), 3, 5, btnAgregarSva);
        click(btnAgregarSva);
        UtilWeb.waitForSeconds(5);

    }

    public void seleccionamosGuardarCambios() {
        UtilWeb.waitForSeconds(5);
        click(btnGuardarCambios, 5);
    }

    public void seleccionamosAgregarDecodificador() {
        WebElement element = sh().getWebElement(iconPlus, "button");
        esperaProgresiva(driver(), 6, 5, element);
        element.click();
    }

    public void scrollToUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,700)");
    }

    public void seleccionoElPlan_movilPostpago() {
        UtilWeb.waitForSeconds(10);
        click(btnPostpago, 2);
        UtilWeb.waitForSeconds(5);
        seleccionarBotonSiguiente();
        UtilWeb.waitForSeconds(10);

    }

    public void seleccionarBotonSiguiente() {
        UtilWeb.waitForSeconds(5);
        WebElement btnSiguiente = find().getElementByCss(".modal_footer tdp-st-button");
        click(btnSiguiente, 10);
    }
}