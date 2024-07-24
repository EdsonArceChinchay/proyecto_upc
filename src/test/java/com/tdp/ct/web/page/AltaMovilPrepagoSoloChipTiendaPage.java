package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class AltaMovilPrepagoSoloChipTiendaPage extends WebBase {

    @FindBy(xpath = "(//div[contains(@class,'pt-4')]/div[@class='tdp-row'])[1]")
    protected List<WebElement> listOfert;
    @FindBy(xpath = "//div[@class='button-filter-section']/button[contains(text(),'Prepago')]")
    protected WebElement selecPrepago;
    @FindBy(xpath = "//div[contains(@class,'offert-card-title-prepaid')]")
    protected List<WebElement> listaPrepago;
    @FindBy(xpath = "//span[contains(text(),'MÓVIL NUEVO')]/../following-sibling::div[2]/div/button")
    protected WebElement lineaNueva;
    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmar;
    @FindBy(xpath = "//span[contains(text(),'Continuar')]/..")
    protected WebElement buttonContinuar;

    public void seleccionarOferta(String oferta) {
        UtilWeb.waitForSeconds(10);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,400)");
        UtilWeb.waitForSeconds(1);
        WebElement btnOferta = find().getElementByXPath("//span[text()='" + oferta + "']/../../following-sibling::*//img");
        click(btnOferta);
        UtilWeb.waitForSeconds(2);
    }


    public void seleccionaPrepago() {
        UtilWeb.waitForSeconds(3);
        click(selecPrepago);
        UtilWeb.waitForSeconds(3);
    }

    public void seleccionaPlan(String plan) {
        UtilWeb.waitForSeconds(2);
        for (WebElement element : listaPrepago) {
            if (element.getText().contains(plan)) {
                click(element);
            }
        }
        UtilWeb.waitForSeconds(2);
        clickElementInAList(listaPrepago, plan);
    }

    public void seleccionarOferta() {
        UtilWeb.waitForSeconds(2);
        String selecOferta = "app-oferta-opciones div div:nth-child(3) tdp-st-button;button";
        WebElement ofertaElement = js().getWebElement(selecOferta);
        js().scrollElementTop(ofertaElement);
        click(ofertaElement);
        UtilWeb.waitForSeconds(2);
    }

    public void irMovilNuevo() {
        waitUntilElementIsVisible(lineaNueva, 3).click();
        UtilWeb.waitForSeconds(3);
    }


    public void clicBotonContinuar(){
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonContinuar, 100).click();
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
        UtilWeb.waitForSeconds(20);
    }


}
