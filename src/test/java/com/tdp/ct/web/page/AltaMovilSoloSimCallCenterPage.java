package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.checkerframework.common.value.qual.EnsuresMinLenIf;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    @FindBy(xpath = "//div[@class='detalle_sub']")
    protected WebElement subDetalles;

    @FindBy(xpath = "//button[contains(text(),'Mostrar ofertas')]")
    protected WebElement btnMostrarOfertas;

    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    public void botonMostrarOfertasRapido() {
        clickBtnReintentar();
        waitUntilElementIsVisible(btnMostrarOfertas, 60).click();
    }

    public void ofertasSugeridas() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        waitUntilElementIsVisible(ofertasSugeridas, 1500);//300
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//p[contains(text(),'RESTRICCIONES')]")).size() != 0;
        if (elementoExistente) {
            click(subDetalles);
            System.out.println("si estaba abierto el detalle");
            UtilWeb.waitForSeconds(1);
        }
        Assert.assertTrue("No esta presente el elemento", ofertasSugeridas.isDisplayed());
    }

    public void listaTipoPlanMovil(String planMovil) {
        UtilWeb.waitForSeconds(4);
        clickElementInAList(listaTipoPlanMovil, planMovil);
    }

    public void listaPlanMovil(String planMovil) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        System.out.println("Ofertas : " + listaPlanMovil.size());
        UtilWeb.waitForSeconds(2);
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                click(btnRight);
                UtilWeb.waitForSeconds(1);
            }
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        //-------------------------------------------------------//
        for (int i = 0; i < listaPlanMovil.size(); i++) {
            System.out.println(listaPlanMovil.get(i).getText());
            if (listaPlanMovil.get(i).getText().contains(planMovil)) {
                UtilWeb.waitForSeconds(2);
                click(listaPlanMovil.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }
    }

    public void botonSeleccionarOfeta() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        js().scrollElementTop(botonSeleccionarOferta);
        click(botonSeleccionarOferta, 10);
    }

    public void paginaResumen() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Assert.assertTrue("El elemento no existe", paginaResumen.isDisplayed());
    }

    public void completaDatosSolicitados() {
        waitUntilElementIsVisible(completaDatosSolicitados, 20);
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void clickBtnReintentar() {
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            btnReintentar.click();
            UtilWeb.waitForSeconds(2);
        }

    }


}
