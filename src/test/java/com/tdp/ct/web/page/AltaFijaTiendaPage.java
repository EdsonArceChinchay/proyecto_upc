package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class AltaFijaTiendaPage extends WebBase {
    ArrayList<String> tabs;
    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;

    @FindBy(xpath = "//div[@class='tdp-col-md-2']")
    protected WebElement esperalistaPlanFija;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement buttonConfirmar;
    @FindBy(xpath = "(//button[contains(text(),'Confirmar')])[2]")
    protected WebElement buttonConfirmar2;
    @FindBy(xpath = "(//button[@class='buttonG'])[1]")
    protected WebElement btnDescargar;
    @FindBy(xpath = "(//button[@class='_close'])")
    protected WebElement btnClose;
    @FindBy(xpath = "//div[@class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//div[contains(text(),'Nombre:')]")
    protected WebElement nombresCompletosCliente;

    @FindBy(xpath = "(//button[contains(text(),'Línea nueva móvil') or @class='btnCard' and contains(text(),'Línea nueva')  or @class='btnCard' and contains(text(),'Cambiar plan hogar')])[1]")
    protected WebElement btnLineaNueva;

    @FindBy(xpath = "//*[@class='buttonG' and contains(text(),'SVA')]")
    protected WebElement btnSVA;

    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;

    @FindBy(xpath = "//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    public String nombresCompletosCliente() {
        waitUntilElementIsVisible(nombresCompletosCliente, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        return getText(nombresCompletosCliente);
    }

    public void listaPlanFija(String planFija) {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        waitUntilElementIsVisible(esperalistaPlanFija, 100);
        UtilWeb.waitForSeconds(5);
        clickElementInAList(listaPlanFija, planFija);
        UtilWeb.waitForSeconds(10);
    }

    public void listaOfertas(String planOfertas) {
        String ofertaEsperada = planOfertas.trim().toUpperCase();
        System.out.println("Ofertas : " + listaOfertas.size());
        UtilWeb.waitForSeconds(2);
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                System.out.println("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(1);
            }
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            System.out.println("Entro al for de las lista de ofertas");
            System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
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

    public void seleccionarOferta() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > div.tdp-container.pt-16 > modal-plan-hogar > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(1);
        buttonSeleccionarOferta.click();
        UtilWeb.waitForSeconds(10);
    }


    public void listaBotones() {
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsVisible(btnLineaNueva, 50);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(5);
    }

    public void datosAgendamiento() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//         Calendario
        boolean elementoExistenteDias;
        elementoExistenteDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']")).size() != 0;
        if (elementoExistenteDias) {
            System.out.println("paso aqui 1");
            List<WebElement> listaDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']"));
            click(listaDias.get(0));
            System.out.println("paso aqui 2 " + listaDias.get(0).getText());
        }

        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            List<WebElement> listaHorario = driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
            click(listaHorario.get(0));
            System.out.println("paso aqui 2 " + listaHorario.get(0).getText());
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys("956425985");
        UtilWeb.waitForSeconds(2);

    }

    public void botonConfirmarAgendamiento() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            click(buttonConfirmar);
            UtilWeb.waitForSeconds(1);
            click(buttonConfirmar2);
            System.out.println("paso aqui 2");
        } else {
            click(buttonConfirmar);
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(5);
    }

    public void descargarContrato() {
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        UtilWeb.waitForSeconds(10);
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement boton = find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[1]/tdp-st-button");
        waitUntilElementIsClickable(boton, 500).click();
        UtilWeb.waitForSeconds(10);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-success > app-modal-pdf > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(1);

    }

    public void descargarPdf() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(2,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        click(btnDescargar);
    }

    public void cambiarPestanaPrincipal() {
        modalError(2,btnReintentar,"Click al elemento Reitentar");
        modalError(1,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        tabs = new ArrayList<String>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(0));
        UtilWeb.waitForSeconds(1);
    }

    public void cerrarPopUp() {
        UtilWeb.waitForSeconds(1);
        click(btnClose);
        UtilWeb.waitForSeconds(1);
    }

    public void registrarVenta() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(2,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        UtilWeb.waitForSeconds(100);
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement boton = find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button");
        waitUntilElementIsClickable(boton, 1500);
        click(boton,50);
        UtilWeb.waitForSeconds(5);
    }

    public void doyClickEnAñadirSVA() {
        waitUntilElementIsVisible(btnSVA, 100);
        js().scrollElementTop(btnSVA);
        click(btnSVA,10);
    }

    public void doyClickEnAgregarBloque(String bloque) {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        WebElement btnbloque = find().getElementByXPath("//*[@class='text' and contains(text(),'" + bloque + "')]//following::tdp-st-checkbox[1]");
        waitUntilElementIsVisible(btnbloque, 500);
        js().scrollElementTop(btnbloque);
        click(btnbloque,10);
    }

    public void doyClickEnGuardarCambios() {
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement btnGuardar = find().getElementByXPath("//*[@type='button' and contains(text(),'Guardar')]");
        waitUntilElementIsVisible(btnGuardar, 10);
        click(btnGuardar);
    }

    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() !=0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        }
        else {
            System.out.println("No se encontro el modal error");
        }
    }
}
