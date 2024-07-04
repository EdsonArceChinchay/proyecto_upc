package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.swing.*;
import java.awt.*;
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
    @FindBy(xpath = "//*[contains(@class,'titleForm') or contains(text(),'Selecciona los servicios a consultar')]")
    protected WebElement labelSelectService;

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

    public void entrarIniciarRegistro() {
        UtilWeb.waitForSeconds(2);
        String selectRegistro = "div tdp-st-button;div";
        WebElement registroElement = js().getWebElement(selectRegistro);
        click(registroElement);
        UtilWeb.waitForSeconds(2);
    }

    public void irMovilNuevo() {
        waitUntilElementIsVisible(lineaNueva, 3).click();
        UtilWeb.waitForSeconds(3);
    }

    public void ingresarFechaNacimiento(String fechaNac) {
        UtilWeb.waitForSeconds(2);
        String fechNacimiento = "tdp-st-input-text;input";
        WebElement fechNacimElement = js().getWebElement(fechNacimiento);
        fechNacimElement.sendKeys(fechaNac);
        UtilWeb.waitForSeconds(2);
    }

    public void ingresarNacionalidad(String nacionalidad) {
        UtilWeb.waitForSeconds(2);
        WebElement nacList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(nacList);

        UtilWeb.waitForSeconds(2);
        SearchContext contextNacionalidad = sh().getContext(nacList).findElement(By.cssSelector("div > ul > li"));
        List<WebElement> lista = contextNacionalidad.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            if (element.getText().contains(nacionalidad)) {
                UtilWeb.waitForSeconds(1);
                click(element, 2);
            }
        }
    }

    public void selecEstadoCivil(String estadoCivil) {
        UtilWeb.waitForSeconds(4);
        WebElement estadoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']");
        click(estadoList);
        UtilWeb.waitForSeconds(4);

        SearchContext contextEstado = sh().getContext(estadoList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextEstado.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            if (element.getText().contains(estadoCivil)) {
                UtilWeb.waitForSeconds(2);
                click(element, 3);
            }
        }
    }

    public void selecDepartamento(String departamento) {
        UtilWeb.waitForSeconds(2);
        WebElement departList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='department']");
        js().scrollElementTop(departList);
        click(departList);
        UtilWeb.waitForSeconds(2);

        SearchContext contextDepart = sh().getContext(departList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextDepart.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            if (element.getText().contains(departamento)) {
                UtilWeb.waitForSeconds(2);
                click(element);
                UtilWeb.waitForSeconds(2);
            }
        }
    }

    public void selecProvincia(String provincia) {
        UtilWeb.waitForSeconds(2);
        WebElement provinciaList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        click(provinciaList);
        UtilWeb.waitForSeconds(2);

        SearchContext contextProv = sh().getContext(provinciaList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextProv.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            if (element.getText().contains(provincia)) {
                UtilWeb.waitForSeconds(2);
                click(element);
                UtilWeb.waitForSeconds(3);
            }
        }
    }

    public void selecDistrito(String distrito) {
        UtilWeb.waitForSeconds(2);
        WebElement distritoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='district']");
        click(distritoList);
        UtilWeb.waitForSeconds(2);

        SearchContext contextEstado = sh().getContext(distritoList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextEstado.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            if (element.getText().contains(distrito)) {
                UtilWeb.waitForSeconds(1);
                click(element, 2);
            }
        }
    }

    public void ingresarDireccion(String direccion) {
        UtilWeb.waitForSeconds(2);
        String ingresaDireccion = "tdp-st-textarea;textarea";
        WebElement direccionElement = js().getWebElement(ingresaDireccion);
        js().scrollElementTop(direccionElement);
        direccionElement.sendKeys(direccion);
    }

    public void clickConfirmar(){
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(btnConfirmar);
        click(btnConfirmar);
        UtilWeb.waitForSeconds(10);
    }

    public void clicBotonContinuar(){
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonContinuar, 100).click();
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
        UtilWeb.waitForSeconds(20);
    }

    public void selectLineWithNumber(String number) {
        js().scrollElementTop(labelSelectService);
        WebElement numberLine = find().getElementByXPath("(//*[contains(text(),'14352752')]/ancestor::div[contains(@class,'content')]/div)[1]");
        esperaProgresiva(driver(),3,5,numberLine);
        js().scrollElementTop(numberLine);
        numberLine.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click in line "+number);
    }
}
