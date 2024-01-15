package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;

import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;

import org.junit.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;


import static com.tdp.ct.web.utils.Addons.*;

public class AltaMovilSoloSimCallCenterPage extends WebBase {

    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;
    @FindBy(xpath = "(//div[@class='title'])/span")
    protected WebElement paginaResumen;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;
    @FindBy(xpath = "(//div[@class='button-filter-section'])/button")
    protected List<WebElement> listaTipoPlanMovil;
    @FindBy(xpath = "(//div[contains(@class,'offert-card-title')])/div[2]")
    protected List<WebElement> listaPlanMovil;
    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement botonSeleccionarOferta;
    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;

    @FindBy(xpath = "//img[@src='assets/images/left-arrow.png']")
    protected WebElement btnLeft;
    @FindBy(xpath = "//div[@class='detalle_sub']")
    protected WebElement subDetalles;
    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[2]/div/div[4]/button")
    protected WebElement btnMostrarOfertas;

    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    @FindBy(xpath = "//*[@id=\"mat-mdc-dialog-1\"]/div/div/app-modal-uniquepass-park/div/mat-dialog-actions/button")
    protected WebElement cerrarPopUpEstadoCU;

    @FindBy(xpath = "//button[contains(text(),\" Entendido\")]")
    protected WebElement btnEntendido;

    @FindBy(xpath = "//h4[contains(text(), 'Desea un plan Prepago o Postpago')]")
    protected WebElement preguntaTipoPlan;

    public void botonMostrarOfertasRapido() {
        clickBtnReintentar();
        esperaProgresiva(driver(),5,5,btnMostrarOfertas);
        waitUntilElementIsVisible(btnMostrarOfertas, 10).click();
    }
    public void cerrarPopUpEstadoCU(){
//        UtilWeb.waitForSeconds(1);
//        waitUntilElementIsVisible(cerrarPopUpEstadoCU, 10).click();
//        UtilWeb.waitForSeconds(1);
        try {
            if (cerrarPopUpEstadoCU.isDisplayed()) {
                System.out.println("Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarPopUpEstadoCU);
            } else {
                UtilWeb.waitForSeconds(4);
                System.out.println("No existe Popup....");
            }
        } catch (Exception e) {
            System.out.println("No hay ningún popup.....");
        }
    }

    public void ofertasSugeridas() {
        revisarModalError(driver());
        esperaProgresiva(driver(),3,5,ofertasSugeridas);
        revisarModalError(driver());
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//p[contains(text(),'RESTRICCIONES')]")).size() != 0;
        if (elementoExistente) {
            js().scrollElementTop(subDetalles);
            click(subDetalles);
            System.out.println("si estaba abierto el detalle");
            UtilWeb.waitForSeconds(1);
        }
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", ofertasSugeridas.isDisplayed());
    }

    public void listaTipoPlanMovil(String planMovil) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 3,5,"loading-offer");
        clickElementInAList(listaTipoPlanMovil, planMovil,10);
    }

    public void listaPlanMovil(String planMovil,ManageScenario scenario) {

        revisarModalError(driver());
        scenario.printFullView();
        UtilWeb.waitForSeconds(2);
        WebElement inputElement = driver().findElement(By.cssSelector(".search-section tdp-st-input-text[formcontrolname='name']"));
        esperaProgresiva(driver(), 3, 5, inputElement);
        boolean elementoExistenteRight;
        boolean elementoExistenteleft;
        elementoExistenteRight = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
        int contador = 0;
        int contadorMax =12;
        while (elementoExistenteRight && contador<contadorMax)
        {
            if (btnRight != null) {
                esperaProgresiva(driver(), 3, 3, btnRight);
                btnRight.click();
                System.out.println("dio click right while");
            } else {
                System.out.println("El elemento btnRight no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnRight,5);
                UtilWeb.logger(this.getClass()).log(Level.INFO,"Se muestra el btnRight");
            } catch (Exception e) {
                System.out.println("El elemento btnRight ya no fue encontrado: ");
            }
            elementoExistenteRight = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            contador++;
        }
        UtilWeb.waitForSeconds(2);
        contador = 0;
        elementoExistenteleft = driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).size() != 0;
        while (elementoExistenteleft && contador<contadorMax)
        {
            if (btnLeft != null) {
                waitUntilElementIsClickable(btnLeft, 8).click();

                System.out.println("dio click left while");
            } else {
                System.out.println("El elemento btnleft no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnLeft,5);
                UtilWeb.logger(this.getClass()).log(Level.INFO,"Se muestra el btnLeft");
            } catch (Exception e) {
                System.out.println("El elemento btnLeft ya no fue encontrado: ");
            }
            elementoExistenteleft = driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).size() != 0;
            contador++;
        }

        System.out.println("Ofertas : " + listaPlanMovil.size());
        int cont = listaPlanMovil.size() - 1;
        boolean encontroElemento = false;
        for (int i = 0; i < listaPlanMovil.size(); i++) {

            System.out.println("Oferta: "+i +" "+listaPlanMovil.get(i).getText());
            if (!encontroElemento && listaPlanMovil.get(i).getText().trim().equalsIgnoreCase(planMovil.trim()) ) {
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
                elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }

            if(!encontroElemento && (i==cont || listaPlanMovil.get(i + 1).getText().trim().equals(""))) {
                System.out.println("No encontro elemento en la lista");
                UtilWeb.waitForSeconds(2);
                click(listaPlanMovil.get(i));
                break;
            }
        }

        UtilWeb.waitForSeconds(1);
    }

    public void botonSeleccionarOfeta() {
        js().scrollElementTop(botonSeleccionarOferta);
        click(botonSeleccionarOferta, 10);
    }

    public void paginaResumen() {
        UtilWeb.waitForSeconds(7);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Assert.assertTrue("El elemento no existe", paginaResumen.isDisplayed());
    }

    public void completaDatosSolicitados() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(),3,5,completaDatosSolicitados);
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void validarSeleccionaPostpagoPrepago() {
        esperaProgresiva(driver(),3,3,preguntaTipoPlan);
        boolean existe = waitUntilElementIsVisible(preguntaTipoPlan, 90).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina preguntaTipoPlan >>> {0}", existe);
    }


    public void clickBtnReintentar() {
        //NECESITA REFACTORIZAR: ELIMINAR
        UtilWeb.waitForSeconds(2);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            btnReintentar.click();
            UtilWeb.waitForSeconds(2);
        }

    }

    public void botonentendidoOfertas(){
        UtilWeb.waitForSeconds(10);
        click(btnEntendido,10);
    }


}
