package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class ParkPage extends WebBase {

    @FindBy(xpath = "//div[@class=\"contenedor_park add_pointer\"]")
    protected WebElement btnHogar;
    @FindBy(css = ".tdp-col-sm-2:nth-child(2) .stl-movil")
    protected WebElement btnMovil;

    @FindBy(css = ".stl_position_movil:nth-child(1) app-card-line:nth-child(1) .container")
    protected WebElement btnLineaExistente;
    @FindBy(css = ".stl_position_movil:nth-child(2) app-card-line:nth-child(1) .container")
    protected WebElement btnLineaCelularExistente;

    @FindBy(css = ".stl_position_movil:nth-child(2) app-card-line:nth-child(1) .btn-try-again")
    protected WebElement btnRefreshLineaCelularExistente;

    @FindBy(css = ".stl_position_movil:nth-child(3) app-card-mt:nth-child(1) .contenedor_park_plan_MT")
    protected WebElement btnPlanMtExistente;

    @FindBy(css = ".stl_position_movil:nth-child(2) app-card-line:nth-child(1) .container")
    protected WebElement btnLineaMovilExistente;
    @FindBy(xpath = "(//*[contains(text(),'Mostrar Ofertas') or contains(text(),'Mostrar ofertas')])[1]")
    protected WebElement btnMostrar;
    @FindBy(xpath = "//app-card-mt[1]")
    protected WebElement cartillaMovistarTotal;
    @FindBy(xpath = "//img[@src='assets/images/Cargando.gif']")
    protected WebElement btnCargango;
    @FindBy(xpath = "//app-card-line[1]")
    protected WebElement cartillaHogar;

    @FindBy(xpath = "//div[@slot='modal_body']/div[2]/div/p[2]")
    protected WebElement txtDirC;

    @FindBy(xpath = "//button[@class='update_button']")
    protected WebElement btnActualizar;

    @FindBy(xpath = "//div[@class='detailHogar']")
    protected WebElement btnVerDetalle;

    @FindBy(xpath = "//div[@class='update_ruc']")
    protected WebElement btnActualizarRuc;

    @FindBy(xpath = "//label[contains(text(),' El RUC se ha actualizado de manera correcta. ')]")
    protected WebElement mensaje;

    @FindBy(xpath = "(//button[contains(text(),'Entendido')])[2]")
    protected WebElement Entendido;

    @FindBy(xpath = "//*[contains(@label,'Siguiente')]")
    protected WebElement btnSiguiente;

    @FindBy(xpath = "//app-banner-cu/div/div/div[1]/img[2]")
    protected WebElement cerrarCU;

    @FindBy(xpath = "//*[@label='Confirmar dirección']")
    protected WebElement btnConfirmarDireccion;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    protected WebElement botonContinuar;

    @FindBy(xpath = "//*[contains(@class,'titleForm') or contains(text(),'Selecciona los servicios a consultar')]")
    protected WebElement labelSelectService;


    public void altaHogar() {
        UtilWeb.waitForSeconds(10);
        esperaProgresiva(driver(), 6, 5, btnHogar);
        js().scrollElementTop(btnHogar);
        if (btnHogar.isDisplayed()) {
            click(btnHogar);
        } else {
            revisarModalError(driver());
            click(btnHogar);
        }

    }

    public void altaMovil() {
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(btnMovil);
        esperaProgresiva(driver(), 5, 5, btnMovil);
        click(btnMovil);
    }

    public void lineaExistente(String numeroExistente) {
        esperaProgresiva(driver(), 3, 5, btnLineaExistente);
        js().scrollElementTop(btnLineaExistente);
        String LineaExistente = btnLineaExistente.getText();

        if (LineaExistente.contains("Activo") && LineaExistente.contains(numeroExistente)) {

            refrescarLineaExistente(".stl_position_movil:nth-child(1) app-card-line:nth-child(1) .btn-try-again");
            click(btnLineaExistente);

        } else {
            int i = 2;
            int reintentos = 5;
            boolean elementoExistente;
            while (i < reintentos) {
                String selector = ".stl_position_movil:nth-child(1) app-card-line:nth-child(" + i + ") .container";
                String refreshSelector = ".stl_position_movil:nth-child(1) app-card-line:nth-child(" + i + ") .btn-try-again";
                WebElement elemento = driver().findElement(By.cssSelector(selector));
                elementoExistente = waitUntilElementIsVisible(elemento, 4).isDisplayed();
                if (elementoExistente) {
                    if (elemento.getText().contains("Activo") && elemento.getText().contains(numeroExistente)) {

                        refrescarLineaExistente(refreshSelector);

                        click(elemento);
                        break;
                    } else {
                        i++;
                    }
                } else {
                    System.out.println("No cumplen con la condicion");
                    break;
                }
            }

        }

        UtilWeb.waitForSeconds(1);
    }

    public void lineaCelularExistente(String numeroExistente) {
        esperaProgresiva(driver(), 3, 5, btnLineaCelularExistente);
        js().scrollElementTop(btnLineaCelularExistente);
        String LineaExistente = btnLineaCelularExistente.getText();
        if (LineaExistente.contains("Activo") && LineaExistente.contains(numeroExistente)) {
            refrescarLineaExistente(".stl_position_movil:nth-child(2) app-card-line:nth-child(1) .container");
            click(btnLineaCelularExistente);
        } else {
            int i = 2;
            int reintentos = 5;
            boolean elementoExistente;
            while (i < reintentos) {
                String selector = ".stl_position_movil:nth-child(2) app-card-line:nth-child(" + i + ") .container";
                String refreshSelector = ".stl_position_movil:nth-child(2) app-card-line:nth-child(" + i + ") .btn-try-again";
                WebElement elemento = driver().findElement(By.cssSelector(selector));
                elementoExistente = waitUntilElementIsVisible(elemento, 4).isDisplayed();
                if (elementoExistente) {
                    if (elemento.getText().contains("Activo") && elemento.getText().contains(numeroExistente)) {
                        refrescarLineaExistente(refreshSelector);
                        js().scrollElementTop(elemento);
                        click(elemento);
                        break;
                    } else {
                        i++;
                    }
                } else {
                    System.out.println("No cumplen con la condicion");
                    break;
                }
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void planMtExistente(String numeroExistente) {
        esperaProgresiva(driver(), 3, 5, btnPlanMtExistente);
        js().scrollElementTop(btnPlanMtExistente);
        String LineaExistente = btnPlanMtExistente.getText();
        if (LineaExistente.contains("Activo") && LineaExistente.contains(numeroExistente)) {
            click(btnPlanMtExistente);
        } else {
            int i = 2;
            int reintentos = 5;
            boolean elementoExistente;
            while (i < reintentos) {
                String selector = ".stl_position_movil:nth-child(3) app-card-line:nth-child(" + i + ") .contenedor_park_plan_MT";
                WebElement elemento = driver().findElement(By.cssSelector(selector));
                elementoExistente = waitUntilElementIsVisible(elemento, 4).isDisplayed();
                if (elementoExistente) {
                    if (elemento.getText().contains("Activo") && elemento.getText().contains(numeroExistente)) {
                        click(elemento);
                        break;
                    } else {
                        i++;
                    }
                } else {
                    System.out.println("No cumplen con la condicion");
                    break;
                }
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void detalleLineaCelularExistente(String numeroExistente) {
        esperaProgresiva(driver(), 3, 5, btnLineaCelularExistente);
        js().scrollElementTop(btnLineaCelularExistente);
        String LineaExistente = btnLineaCelularExistente.getText();
        WebElement detalle;
        if (LineaExistente.contains("Activo") && LineaExistente.contains(numeroExistente)) {
            click(btnLineaCelularExistente);
            detalle = driver().findElement(By.cssSelector(".stl_position_movil:nth-child(2) app-card-line:nth-child(1) .detailHogar"));
            click(detalle);
        } else {
            int i = 2;
            int reintentos = 5;
            boolean elementoExistente;
            while (i < reintentos) {
                String selector = ".stl_position_movil:nth-child(2) app-card-line:nth-child(" + i + ") .container";
                WebElement elemento = driver().findElement(By.cssSelector(selector));
                detalle = driver().findElement(By.cssSelector(".stl_position_movil:nth-child(2) app-card-line:nth-child(" + i + ") .detailHogar"));
                elementoExistente = waitUntilElementIsVisible(elemento, 4).isDisplayed();
                if (elementoExistente) {
                    js().scrollElementTop(elemento);
                    if (elemento.getText().contains("Activo") && elemento.getText().contains(numeroExistente)) {
                        click(elemento);
                        js().scrollElementTop(detalle);
                        click(detalle);
                        break;
                    } else {
                        i++;
                    }
                } else {
                    System.out.println("No cumplen con la condicion");
                    break;
                }
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void lineaMovilExistente() {
        esperaProgresiva(driver(), 3, 5, btnLineaMovilExistente);
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnLineaMovilExistente);
        js().scrollElementTop(btnLineaMovilExistente);
        click(btnLineaMovilExistente);
        UtilWeb.waitForSeconds(1);
    }

    public void mostrarOfertas() {
        Addons.esperaCargaMontoDeuda(driver(), 20);
        esperaProgresiva(driver(), 5, 6, btnMostrar);
        revisarModalError(driver());
        click(btnMostrar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton Mostrar Ofertas");
    }

    public void selecciono_la_cartilla_del_plan_Activo() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, cartillaHogar);
        revisarModalError(driver());
        js().scrollElementTop(cartillaHogar);
        revisarModalError(driver());
        cartillaHogar.click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoCartillaMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 4, 5, cartillaMovistarTotal);
        js().scrollElementTop(cartillaMovistarTotal);
        revisarModalError(driver());
        Addons.esperaCargaMontoDeuda(driver(), 120);
        waitUntilElementIsClickable(cartillaMovistarTotal, 20);
        click(cartillaMovistarTotal);
    }

    public void verificoLaDireccionActualDelServicio(String dir) {
        revisarModalError(driver());
        String direccionEsperada = dir.toUpperCase().trim();
        waitUntilElementIsVisible(txtDirC, 5);
        js().scrollElementTop(txtDirC);
        String direccionRecibida = txtDirC.getText().toUpperCase().trim();
        Assertions.assertTrue(direccionRecibida.contains(direccionEsperada), "La direccion recibida: " + direccionRecibida + " es distinta a la esperada: " + direccionEsperada);
    }

    public void seleccionoBotonVerDetalle() {
        Addons.esperaProgresiva(driver(), 2, 2, btnVerDetalle);
        js().scrollElementTop(btnVerDetalle);
        click(btnVerDetalle);
    }

    public void clickBotonActualizarRuc() {
        Addons.esperaProgresiva(driver(), 2, 2, btnActualizarRuc);
        click(btnActualizarRuc);
        UtilWeb.waitForSeconds(3);
    }

    public void ingresoRuc(String ruc) {
        WebElement Input = find().getElementByCss("app-update-ruc > form > div > tdp-st-input-text");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        click(Input);
        type(Input, ruc);
    }

    public void clickBotonEntendido() {
        click(Entendido);
        UtilWeb.waitForSeconds(5);
    }

    public void clickBotonActualizar() {
        click(btnActualizar);
    }

    public void validoMesajeActualizacionCorrecta() {
        Assert.assertTrue("ruc incorrecto intentelo mas tarde", mensaje.isDisplayed());
    }

    public void ingresoRuc17(String ruc) {
        WebElement Input = find().getElementByXPath("//input[@formcontrolname='twoDigitRuc']");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        click(Input);
        type(Input, ruc);
    }

    public void ingresoDigitoV(String digito) {
        WebElement Input = find().getElementByXPath("//input[@formcontrolname='endDigitRuc']");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        click(Input);
        type(Input, digito);
    }


    public void clickPlanMovil(String planMovil) {
        WebElement btnplanMovil = find().getElementByXPath("//*[@class='item']/span[contains(text(),'" + planMovil + "')]");
        esperaProgresiva(driver(), 5, 5, btnplanMovil);
        waitUntilElementIsClickable(btnplanMovil, 50);
        click(btnplanMovil);
    }

    public void clickEnBotonSiguiente() {
        esperaProgresiva(driver(), 3, 5, btnSiguiente);
        click(btnSiguiente);
    }

    public void cerrarPopupCU() {
        UtilWeb.waitForSeconds(4);
        try {
            if (cerrarCU.isDisplayed()) {
                System.out.println("Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarCU);
            } else {
                UtilWeb.waitForSeconds(4);
                System.out.println("No existe Popup....");
            }
        } catch (Exception e) {
            System.out.println("No hay ningún popup.....");
        }
    }

    public void btnConfirmarDireccion() {
        esperaProgresiva(driver(), 5, 5, btnConfirmarDireccion);
        js().scrollElementTop(btnConfirmarDireccion);
        click(btnConfirmarDireccion);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Confirmar Direccion");
        revisarModalError(driver());
    }

    public void clickMonoYDuo(String mono, String duo) {
        UtilWeb.waitForSeconds(2);
        WebElement btnDuo = find().getElementByXPath("//*[contains(text(),'" + duo.trim() + "')]");
        waitUntilElementIsVisible(btnDuo, 30);
        js().scrollElementTop(btnDuo);
        click(btnDuo);
        System.out.println("click duo");
        UtilWeb.waitForSeconds(2);
        WebElement btnMono = find().getElementByXPath("//*[contains(text(),'" + mono.trim() + "')]");
        waitUntilElementIsVisible(btnMono, 30);
        click(btnMono);
        System.out.println("click mono");
        UtilWeb.waitForSeconds(5);
    }

    public void clickBotonContinuar() {
        waitUntilElementIsVisible(botonContinuar, 30);
        botonContinuar.click();
    }

    public void refrescarLineaExistente(String ruta) {
        boolean status = true;
        WebElement elementoRefresh;
        do {
            try {
                elementoRefresh = driver().findElement(By.cssSelector(ruta));
                try {
                    elementoRefresh.click();
                    status = false;
                } catch (ElementClickInterceptedException ecie) {
                    waitUntilElementIsClickable(elementoRefresh, 3);
                }
            } catch (NoSuchElementException nsee) {
                status = false;
            }
        } while (status);
    }


    public void clickBtnVerDetalle(String nroServicio) {
        UtilWeb.waitForSeconds(5);
        WebElement btnVerDetalle = find().getElementByXPath("//*[contains(text(),'" + nroServicio + "')]//following::div[contains(text(),' Ver detalle ')][1]");
        esperaProgresiva(driver(), 5, 5, btnVerDetalle);
        js().scrollElementTop(btnVerDetalle);
        btnVerDetalle.click();
        revisarModalError(driver());

    }

    public void selectLineWithNumber(String number) {
        js().scrollElementTop(labelSelectService);
        WebElement numberLine = find().getElementByXPath("(//*[contains(text(),'"+number+"')]/ancestor::div[contains(@class,'content') or contains(@class,'contenedor')]/div)[1]");
        esperaProgresiva(driver(),3,5,numberLine);
        js().scrollElementTop(numberLine);
        numberLine.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click in line "+number);
    }
}
