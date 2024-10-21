package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.Helper.compareWebElementTextAndString;
import static com.tdp.ct.web.utils.Helper.typeInShadowRootCssSelector;

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
    @FindBy(xpath = "//*[@label='Confirmar dirección']")
    protected WebElement btnConfirmarDireccion;
    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    protected WebElement botonContinuar;
    @FindBy(xpath = "//*[contains(@class,'titleForm') or contains(text(),'Selecciona los servicios a consultar')]")
    protected WebElement labelSelectService;
    @FindBy(xpath = "(//*[@class='detailHogar'])[1]")
    protected WebElement btnCardPlanActual;
    @FindBy(xpath = "//button[contains(text(),' Renovar ')]")
    protected WebElement btnRenovarPlan;
    @FindBy(css = ".text-info")
    protected WebElement nombreClienteUserData;
    @FindBy(xpath = "//button[text()='Crear cliente']")
    protected WebElement buttonCrearCliente;
    @FindBy(xpath = "//*[contains(@class,'texto-numero') or contains(@class,'seccion-orden')]")
    protected WebElement btnOrder;

    public boolean isNewCustomer() {
        esperaProgresiva(driver(),5,5,nombreClienteUserData);
        return nombreClienteUserData.getText().length() <= 8;
    }

    public void ingresarNombreClienteExtranjero(String nombre) {
        UtilWeb.waitForSeconds(3);
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='nomCli']");
        esperaProgresiva(driver(), 5, 5, rootElement);
        revisarModalError(driver());
        typeInShadowRootCssSelector(nombre,rootElement,"div > div > div > input");
        UtilWeb.waitForSeconds(1);
    }

    public void ingresarApellidoClienteExtranjero(String apellidos) {
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='apeCli']");
        typeInShadowRootCssSelector(apellidos,rootElement,"div > div > div > input");
    }

    public void seleccionarGeneroClienteExtranjero(String genero) {
        WebElement generoList = find().getElementByXPath("//div/tdp-st-select[@formcontrolname='genero']");
        click(generoList);
        String dataValue;
        SearchContext context = sh().getContext(generoList);
        if (genero.equalsIgnoreCase("femenino")) {
            dataValue = "F";
        } else {
            dataValue = "M";
        }
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void crearCliente() {
        js().scrollElementTop(buttonCrearCliente);
        click(buttonCrearCliente);
        UtilWeb.waitForSeconds(2);
    }

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
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "No cumplen con la condicion");
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
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "No cumplen con la condicion");
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
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "No cumplen con la condicion");
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
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "No cumplen con la condicion");
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

    @FindBy(xpath = "//div[@class=\"div-product-name\"]")
    WebElement scrollCartillaMT;

    public void seleccionoCartillaPlanMT() {
        js().scrollElementTop(scrollCartillaMT);
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(scrollCartillaMT, 40).click();
    }

    public void verificoLaDireccionActualDelServicio(String dir) {
        revisarModalError(driver());
        waitUntilElementIsVisible(txtDirC, 5);
        js().scrollElementTop(txtDirC);
        compareWebElementTextAndString(txtDirC,dir);
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
        UtilWeb.logger(this.getClass()).log(Level.INFO, "click duo");
        UtilWeb.waitForSeconds(2);
        WebElement btnMono = find().getElementByXPath("//*[contains(text(),'" + mono.trim() + "')]");
        waitUntilElementIsVisible(btnMono, 30);
        click(btnMono);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "click mono");
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

    public void scrollToLabelSelectService(){
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(labelSelectService);
        UtilWeb.waitForSeconds(5);
    }

    public void clickBtnVerDetalle(String nroServicio) {
        WebElement btnVerDetalle = find().getElementByXPath("//*[contains(text(),'" + nroServicio + "')]//following::div[contains(text(),' Ver detalle ')][1]");
        esperaProgresiva(driver(), 5, 8, btnVerDetalle);
        js().scrollElementTop(btnVerDetalle);
        btnVerDetalle.click();
        revisarModalError(driver());
    }

    public void selectLineWithNumber(String number) {
        WebElement numberLine = find().getElementByXPath("(//*[contains(text(),'" + number + "')]/ancestor::div[contains(@class,'content') or contains(@class,'contenedor')]/div)[1]");
        esperaProgresiva(driver(), 3, 5, numberLine);
        js().scrollElementTop(numberLine);
        numberLine.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click in line " + number);
    }

    public void esperarBtnCardPlanActual() {
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(find().getElementByCss("h1.titleForm"));

    }

    public void clickBtnCardPlanActual() {
        esperaProgresiva(driver(), 3, 5, btnCardPlanActual);
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnCardPlanActual);
        js().scrollElementTop(btnCardPlanActual);
        click(btnCardPlanActual);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnRenovarPlan() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(10);
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnRenovarPlan);
        js().scrollElementTop(btnRenovarPlan);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnRenovarPlan.getText());
        click(btnRenovarPlan);
        UtilWeb.waitForSeconds(1);
    }

    @FindBy(xpath = "//button[contains(text(),'Cambio de chip')]")
    protected WebElement btnCambiodeChip;

    public void seleccionoelbotonCambiodeChip() {
        Addons.esperaProgresiva(driver(), 5, 5, btnCambiodeChip);
        js().scrollElementTop(btnCambiodeChip);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnCambiodeChip.getText());
        click(btnCambiodeChip);
    }

    @FindBy(xpath = "//*[contains(text(),'CONTINUAR')]")
    protected WebElement btnClienteExonerado;

    public void cierroPopUpDeClienteExonerado() {
        Addons.esperaProgresiva(driver(), 3, 5, btnClienteExonerado);
        try {
            if (btnClienteExonerado.isDisplayed()) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Cierre Nuevo Popup....");
                click(btnClienteExonerado);
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "No existe Popup....");
            }
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No hay ningún popup.....");
        }
    }

    @FindBy(xpath = "//app-banner-cu/div/div/div[1]/img[2]")
    protected WebElement cerrarCU;

    @FindBy(xpath = "//*[@id='mat-mdc-dialog-1']/div/div/app-modal-uniquepass-park/div/mat-dialog-actions/button")
    protected WebElement cerrarPopUpEstadoCU;


    public void cerrarPopupCU() {
        UtilWeb.waitForSeconds(4);
        try {
            if (cerrarCU.isDisplayed()) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarCU);
            } else {
                UtilWeb.waitForSeconds(4);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "No existe Popup....");
            }
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No hay ningún popup.....");
        }
    }

    public void cerrarPopUpEstadoCU() {
        try {
            if (cerrarPopUpEstadoCU.isDisplayed()) {
                UtilWeb.logger(this.getClass()).log(Level.INFO,"Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarPopUpEstadoCU);
            } else {
                UtilWeb.waitForSeconds(4);
                UtilWeb.logger(this.getClass()).log(Level.INFO,"No existe Popup....");
            }
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO,"No hay ningún popup.....");
        }
    }

    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUpError;

    public void clickCierrePopup() {
        UtilWeb.waitForSeconds(3);//inhabilitado
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='dialog-container']")).isEmpty();
        if (elementoExistente) {
            Addons.esperaProgresiva(driver(), 3, 5, cierrePopUpError);
            UtilWeb.logger(this.getClass()).log(Level.INFO,"Se cierra Popup de error");
            try {
                click(cierrePopUpError);

            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO,"error al hacer click");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO,"no se encontró mensaje de error");
        }
    }

    public void selectOrder() {
        esperaProgresiva(driver(),5,5,btnOrder);
        btnOrder.click();
    }
}
