package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.getVisibleAndClickableElement;

public class AltaMovilSoloSimCallCenterPage extends WebBase {

    @FindBy(xpath = "(//div[@class='button-filter-section'])/button")
    protected List<WebElement> listaTipoPlanMovil;
    @FindBy(xpath = "(//div[contains(@class,'offert-card-title')])/div[2]")
    protected List<WebElement> listaPlanMovil;
    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement botonSeleccionarOferta;
    @FindBy(css = "img[alt='right-arrow']")
    protected WebElement btnRight;
    @FindBy(css = "img[alt='left-arrow']")
    protected WebElement btnLeft;
    @FindBy(xpath = "//h4[contains(text(), 'Desea un plan Prepago o Postpago')]")
    protected WebElement preguntaTipoPlan;
    @FindBy(xpath = "//div[contains(@class, 'card-option-ofert-content')]")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;

    public void listaTipoPlanMovil(String planMovil) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 3, 5, "loading-offer");
        clickElementInAList(listaTipoPlanMovil, planMovil, 10);
    }

    public void listaPlanMovil(String planMovil, ManageScenario scenario) {
        revisarModalError(driver());
        scenario.printFullView();
        UtilWeb.waitForSeconds(2);
        WebElement inputElement = driver().findElement(By.cssSelector(".search-section tdp-st-input-text[formcontrolname='name']"));
        esperaProgresiva(driver(), 3, 5, inputElement);
        boolean elementoExistenteRight;
        boolean elementoExistenteleft;
        elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
        int contador = 0;
        int contadorMax = 12;
        while (elementoExistenteRight && contador < contadorMax) {
            if (btnRight != null) {
                esperaProgresiva(driver(), 3, 3, btnRight);
                btnRight.click();
                logInfo("dio click right while");
            } else {
                logInfo("El elemento btnRight no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnRight, 5);
                logInfo("Se muestra el btnRight");
            } catch (Exception e) {
                logSevere("El elemento btnRight ya no fue encontrado", e.getMessage());
            }
            elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            contador++;
        }
        UtilWeb.waitForSeconds(2);
        contador = 0;
        elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
        while (elementoExistenteleft && contador < contadorMax) {
            if (btnLeft != null) {
                waitUntilElementIsClickable(btnLeft, 8).click();
                logInfo("dio click left while");
            } else {
                logInfo("El elemento btnleft no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnLeft, 5);
                logInfo("Se muestra el btnLeft");
            } catch (Exception e) {
                logSevere("El elemento btnLeft ya no fue encontrado", e.getMessage());
            }
            elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
            contador++;
        }

        logInfo("Ofertas : " + listaPlanMovil.size());
        int cont = listaPlanMovil.size() - 1;
        boolean encontroElemento = false;
        for (int i = 0; i < listaPlanMovil.size(); i++) {

            logInfo("Oferta: " + i + " " + listaPlanMovil.get(i).getText());
            if (!encontroElemento && listaPlanMovil.get(i).getText().trim().toUpperCase().contains(planMovil.trim().toUpperCase())) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaPlanMovil.get(i));

            }
            if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20 || i == 23 || i == 26 || i == 29 || i == 32 || i == 35 || i == 38) {
                scenario.printFullView();
                js().scrollElementTop(botonSeleccionarOferta);
                scenario.printFullView();
                WebElement buscarButton = driver().findElement(By.cssSelector(".search-section .search-button"));
                js().scrollElementTop(buscarButton);
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }

            if (!encontroElemento && (i == cont || listaPlanMovil.get(i + 1).getText().trim().isEmpty())) {
                logInfo("No encontro elemento en la lista");
                UtilWeb.waitForSeconds(2);
                click(listaPlanMovil.get(i));
                break;
            }
        }

        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarPlan(String tipoPlan) {
        UtilWeb.waitForSeconds(4);
        String ofertaEsperada = tipoPlan.trim().toUpperCase();
        logInfo("cantidad de la lista : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            if (elementoExistente) {
                logInfo("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }

        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            logInfo("Entro al for de las lista de ofertas");
            logInfo("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }

        if (!encontroElemento && !listaOfertas.isEmpty()) {
            logInfo("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
        UtilWeb.waitForSeconds(1);
    }

    public void botonSeleccionarOfeta() {
        js().scrollElementTop(botonSeleccionarOferta);
        click(botonSeleccionarOferta, 10);
    }

    public void validarSeleccionaPostpagoPrepago() {
        esperaProgresiva(driver(), 3, 3, preguntaTipoPlan);
        boolean existe = waitUntilElementIsVisible(preguntaTipoPlan, 90).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina preguntaTipoPlan >>> {0}", existe);
    }

    public void seleccionoElBotonAgregarSva() {
        revisarModalError(driver());
        List<WebElement> listbtnAddSVA = find().getElementsByXPath("(//app-modal-detail-landline//div[2]/tdp-st-button)[1] | (//app-modal-detail-mt//div[2]/tdp-st-button)[1] | //*[contains(@class,'buttonG') and contains(text(),'SVA')]");
        esperaProgresiva(driver(), 3, 5, listbtnAddSVA.get(0));
        WebElement btnAddSVA = getVisibleAndClickableElement(listbtnAddSVA);
        js().scrollElementTop(btnAddSVA);
        btnAddSVA.click();
        UtilWeb.waitForSeconds(5);
    }

    public void imprimoLaOfertaSeleccionada(ManageScenario scenario) {
        waitUntilElementIsVisible(ofertasSugeridas, 20);
        js().scrollElementTop(ofertasSugeridas);
        scenario.printFullView();
    }
}
