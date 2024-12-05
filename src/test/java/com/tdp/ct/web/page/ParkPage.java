package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.model.Material;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import com.tdp.ct.web.utils.MaterialsManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class ParkPage extends WebBase {

    // @FindBy(css = ".tdp-col-sm-4:nth-child(1) .stl-line_new")
    protected String btnHogar = ".tdp-col-sm-4:nth-child(1) .stl-line_new";
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
    //@FindBy(css = "div[class='show-offerts']")
    protected String btnShowOffers = "div[class='show-offerts']";
    @FindBy(xpath = "//app-card-mt[1]")
    protected WebElement cartillaMovistarTotal;
    @FindBy(xpath = "//img[@src='assets/images/Cargando.gif']")
    protected WebElement btnCargango;
    protected String cartillaHogar = "//app-card-line[1]";
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
    protected WebElement btnNext;
    @FindBy(xpath = "//*[@label='Confirmar dirección']")
    protected WebElement btnConfirmAddress;
    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    protected WebElement botonContinuar;
    protected String labelSelectService = "//*[contains(@class,'titleForm') or contains(text(),'Selecciona los servicios a consultar')]";
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
    @FindBy(xpath = "//*[contains(@label,'Validar Stock') or contains(text(),'Validar Stock') or @class='buttonConfirmar']")
    protected WebElement btnValidateStock;
    @FindBy(css = "tdp-st-input-text[formcontrolname='simcard'] input")
    protected WebElement inputSinCard;
    @FindBy(css = "tdp-st-input-text[formcontrolname='equipo'] input")
    protected WebElement inputImei;
    @FindBy(css = "tdp-st-input-text[formcontrolname='numeroCaja'] input")
    protected WebElement inputBoxNumber;
    @FindBy(css = "tdp-st-input-text[formcontrolname='numeroTicket'] input")
    protected WebElement inputTicketNumber;
    @FindBy(xpath = "//button[contains(text(),'Cambio de chip')]")
    protected WebElement btnCambiodeChip;
    @FindBy(xpath = "//*[contains(text(),'CONTINUAR')]")
    protected WebElement btnClienteExonerado;
    @FindBy(xpath = "//app-banner-cu/div/div/div[1]/img[2]")
    protected WebElement cerrarCU;
    @FindBy(xpath = "//*[@id='mat-mdc-dialog-1']/div/div/app-modal-uniquepass-park/div/mat-dialog-actions/button")
    protected WebElement cerrarPopUpEstadoCU;
    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUpError;
    @FindBy(xpath = "//div[@class=\"div-product-name\"]")
    WebElement scrollCartillaMT;
    @FindBy(css = "input[placeholder='Nombres']")
    WebElement inputName;
    @FindBy(css = "input[placeholder='Apellidos']")
    WebElement inputLastName;
    @FindBy(css = "tdp-st-select[formcontrolname='genero']")
    WebElement selectGender;

    public boolean isNewCustomer() {
        esperaProgresiva(driver(), 5, 5, nombreClienteUserData);
        return nombreClienteUserData.getText().length() <= 8;
    }

    public void ingresarNombreClienteExtranjero(String name) {
        UtilWeb.waitForSeconds(3);
        type(inputName, name);
        logInfo("Type last name", name);
    }

    public void ingresarApellidoClienteExtranjero(String lastName) {
        type(inputLastName, lastName);
        logInfo("Type last name", lastName);
    }

    public void seleccionarGeneroClienteExtranjero(String gender) {
        selectGender.click();
        String dataValue;
        if (gender.equalsIgnoreCase("femenino")) {
            dataValue = "F";
        } else {
            dataValue = "M";
        }
        driver().findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void createCustomer() {
        js().scrollElementTop(buttonCrearCliente);
        click(buttonCrearCliente);
        UtilWeb.waitForSeconds(2);
    }

    public void altaHogar() {

        WebElement BotonAltaHogar = explicitWaitCss(driver(), 10, btnHogar);
        js().scrollElementTop(BotonAltaHogar);
        if (BotonAltaHogar.isDisplayed()) {
            click(BotonAltaHogar);
        } else {
            revisarModalError(driver());
            click(BotonAltaHogar);
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
                    logInfo("No cumplen con la condicion");
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
                    logInfo("No cumplen con la condicion");
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
                    logInfo("No cumplen con la condicion");
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
                    logInfo("No cumplen con la condicion");
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
        revisarModalError(driver());
        WebElement showOffer = explicitWaitCss(driver(), 60, btnShowOffers);
        revisarModalError(driver());
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton Mostrar Ofertas");
        click(showOffer);
        /*revisarModalError(driver());
        WebElement showOffer = explicitWaitCss(driver(), 100, btnShowOffers);
        revisarModalError(driver());
        showOffer.click();*/
        logInfo("Dio click al boton Mostrar Ofertas");
    }

    public void selecciono_la_cartilla_del_plan_Activo() {
        revisarModalError(driver());
        WebElement selectCartilla = explicitWaitXpath(driver(),25,cartillaHogar);
        revisarModalError(driver());
        js().scrollElementTop(selectCartilla);
        selectCartilla.click();
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

    public void seleccionoCartillaPlanMT() {
        js().scrollElementTop(scrollCartillaMT);
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(scrollCartillaMT, 40).click();
    }

    public void verificoLaDireccionActualDelServicio(String dir) {
        revisarModalError(driver());
        waitUntilElementIsVisible(txtDirC, 5);
        js().scrollElementTop(txtDirC);
        compareWebElementTextAndString(txtDirC, dir);
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
        WebElement Input = find().getElementByCss("app-update-ruc > form > div > tdp-st-input-text input");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        validateAndType("RUC", Input, ruc);

    }

    public void ingresoRuc17(String ruc) {
        WebElement Input = find().getElementByXPath("//input[@formcontrolname='twoDigitRuc']");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        validateAndType("RUC 17", Input, ruc);
    }

    public void ingresoDigitoV(String digit) {
        WebElement Input = find().getElementByXPath("//input[@formcontrolname='endDigitRuc']");
        Addons.esperaProgresiva(driver(), 2, 2, Input);
        validateAndType("Digit V", Input, digit);
    }

    public void clickBotonEntendido() {
        click(Entendido);
        UtilWeb.waitForSeconds(5);
    }

    public void clickOnButtonUpdate() {
        click(btnActualizar);
    }

    public void validoMesajeActualizacionCorrecta() {
        Assert.assertTrue("ruc incorrecto intentelo mas tarde", mensaje.isDisplayed());
    }

    public void clickPlanMovil(String planMovil) {
        WebElement btnplanMovil = find().getElementByXPath("//*[@class='item']/span[contains(text(),'" + planMovil + "')]");
        esperaProgresiva(driver(), 5, 5, btnplanMovil);
        waitUntilElementIsClickable(btnplanMovil, 50);
        click(btnplanMovil);
    }

    public void clickOnButtonNext() {
        esperaProgresiva(driver(), 3, 5, btnNext);
        click(btnNext);
    }

    public void btnConfirmAddress() {
        esperaProgresiva(driver(), 5, 5, btnConfirmAddress);
        js().scrollElementTop(btnConfirmAddress);
        click(btnConfirmAddress);
        logInfo("Dio click al boton: Confirmar Direccion");
        revisarModalError(driver());
    }

    public void clickOnPark(String name, String park) {
        UtilWeb.waitForSeconds(2);
        WebElement btnPark = find().getElementByXPath("//*[contains(text(),'" + park.trim() + "')]");
        waitUntilElementIsVisible(btnPark, 30);
        js().scrollElementTop(btnPark);
        click(btnPark);
        logInfo(String.format("Click on %s park %s", name, park));
    }

    public void clickOnButtonContinue() {
        waitUntilElementIsVisible(botonContinuar, 30);
        js().scrollElementTop(botonContinuar);
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

    public void scrollToLabelSelectService() {
        WebElement scroll = explicitWaitXpath(driver(), 10,
                labelSelectService);
        js().scrollElementTop(scroll);
        //UtilWeb.waitForSeconds(5);
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
        logInfo("Click in line", number);
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
        logInfo("Click button", btnRenovarPlan.getText());
        click(btnRenovarPlan);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoelbotonCambiodeChip() {
        Addons.esperaProgresiva(driver(), 5, 5, btnCambiodeChip);
        js().scrollElementTop(btnCambiodeChip);
        logInfo("Click button", btnCambiodeChip.getText());
        click(btnCambiodeChip);
    }

    public void cierroPopUpDeClienteExonerado() {
        Addons.esperaProgresiva(driver(), 3, 5, btnClienteExonerado);
        try {
            if (btnClienteExonerado.isDisplayed()) {
                logInfo("Cierre Nuevo Popup....");
                click(btnClienteExonerado);
            } else {
                logInfo("No existe Popup....");
            }
        } catch (Exception e) {
            logSevere("No hay ningún popup.....");
        }
    }

    public void cerrarPopupCU() {
        UtilWeb.waitForSeconds(4);
        try {
            if (cerrarCU.isDisplayed()) {
                logInfo("Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarCU);
            } else {
                UtilWeb.waitForSeconds(4);
                logInfo("No existe Popup....");
            }
        } catch (Exception e) {
            logSevere("No hay ningún popup.....");
        }
    }

    public void cerrarPopUpEstadoCU() {
        try {
            if (cerrarPopUpEstadoCU.isDisplayed()) {
                logInfo("Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarPopUpEstadoCU);
            } else {
                UtilWeb.waitForSeconds(4);
                logInfo("No existe Popup....");
            }
        } catch (Exception e) {
            logSevere("No hay ningún popup.....");
        }
    }

    public void clickCierrePopup() {
        UtilWeb.waitForSeconds(3);//inhabilitado
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='dialog-container']")).isEmpty();
        if (elementoExistente) {
            Addons.esperaProgresiva(driver(), 3, 5, cierrePopUpError);
            logInfo("Se cierra Popup de error");
            try {
                click(cierrePopUpError);

            } catch (Exception e) {
                logSevere("error al hacer click");
            }
        } else {
            logInfo("no se encontró mensaje de error");
        }
    }

    public void selectOrder() {
        esperaProgresiva(driver(), 5, 5, btnOrder);
        btnOrder.click();
    }

    public String getSimCard() {
        String simcard = null;
        try {
            MaterialsManager manager = new MaterialsManager();
            Material availableSimCard = manager.getAvailableSimCard();
            if (availableSimCard != null) {
                simcard = availableSimCard.getSerialNumber();
                manager.assignSimCard(availableSimCard);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return simcard;
    }

    public String getIMEI(String device) {
        String imei = null;
        try {
            MaterialsManager manager = new MaterialsManager();
            Material availableImei = manager.getAvailableImeiByName(device);
            if (availableImei != null) {
                imei = availableImei.getSerialNumber();
                manager.assignImei(availableImei);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imei;
    }

    public void typeInput(String input, String value) {
        switch (input) {
            case "inputSimCard":
                esperaProgresiva(driver(), 6, 8, inputSinCard);
                js().scrollElementTop(inputSinCard);
                validateAndType("SIM CARD", inputSinCard, value);
                break;
            case "inputImei":
                esperaProgresiva(driver(), 6, 8, inputImei);
                js().scrollElementTop(inputImei);
                validateAndType("IMEI", inputImei, value);
                break;
            case "inputBoxNumber":
                esperaProgresiva(driver(), 6, 8, inputBoxNumber);
                js().scrollElementTop(inputBoxNumber);
                validateAndType("Box Number", inputBoxNumber, value);
                break;
            case "inputTicketNumber":
                esperaProgresiva(driver(), 6, 8, inputTicketNumber);
                js().scrollElementTop(inputTicketNumber);
                validateAndType("Ticket Number", inputTicketNumber, value);
                break;
        }
    }

    public void clickOnButtonValidateStock() {
        btnValidateStock.click();
        boolean isEnabled = true;
        while (isEnabled) {
            revisarModalError(driver());
            try {
                isEnabled = btnValidateStock.isEnabled();
                logInfo("isEnabled", isEnabled);
                if (isEnabled) btnValidateStock.click();

            } catch (Exception e) {
                logSevere("ERROR", e.getMessage());
                isEnabled = false;
            }
        }
    }

}
