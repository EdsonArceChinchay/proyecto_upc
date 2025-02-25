package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class AltaFijaMovilRegistroPage extends WebBase {
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;
    @FindBy(xpath = "//span[contains(text(),'Validar identidad del titular')]/..")
    protected WebElement buttonValidarIdentidad;
    @FindBy(xpath = "(//button[contains(text(),'Discapacitado o huella desgastada') or contains(text(),'Validación no biométrica')])[1]")
    protected WebElement buttonDiscapacitado;
    @FindBy(xpath = "(//button[contains(text(),'Validación biométrica'))[1]")
    protected WebElement buttonValBiometrica;
    @FindBy(xpath = "(//button[contains(text(),'Validación biométrica')])[3]")
    protected WebElement buttonValBiometrica3;
    @FindBy(css = "mat-select[formcontrolname=\"tipoDoc\"]")
    protected WebElement selectDocumentType;
    @FindBy(xpath = "//h4[contains(text(),'Validar identidad del titular')]")
    protected WebElement lblPreguntas;
    @FindBy(xpath = "//*[contains(text(),' Continuar ')]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(css = "tdp-st-button[label=\"Sí, acepta\"]")
    protected WebElement btnYes;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Identidad Validada')]")
    protected WebElement buttonIdentidadValidada;
    @FindBy(css = ".text-info")
    protected WebElement nombreClienteUserData;
    @FindBy(xpath = "//button[text()='Crear cliente']")
    protected WebElement buttonCrearCliente;

    // BOTON VALIDAR CONTRATO
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void clickOnTheValidateHolderIdentityButton() {
        esperaProgresiva(driver(), 6, 5, buttonValidarIdentidad);
        js().scrollElementTop(buttonValidarIdentidad);
        waitUntilElementIsVisible(buttonValidarIdentidad, 10).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoTipoValidacion(String tipoValidacion) {
        UtilWeb.waitForSeconds(5);
        if (tipoValidacion.equalsIgnoreCase("discapacitado")) {
            esperaProgresiva(driver(), 5, 5, buttonDiscapacitado);
            waitUntilElementIsClickable(buttonDiscapacitado, 5).click();
        } else {
            if (buttonValBiometrica3.isEnabled()) {
                waitUntilElementIsClickable(buttonValBiometrica3, 5).click();
            } else {
                waitUntilElementIsClickable(buttonValBiometrica, 5).click();
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void ingresarDatosValidacionReniec(DataTable datos, Integer i) {
        String nomMadre = UtilWeb.getValueFromDataTable(datos, "nombreMadre");
        String nomPadre = UtilWeb.getValueFromDataTable(datos, "nombrePadre");
        String distritoNacimiento = UtilWeb.getValueFromDataTable(datos, "distritoNac");
        validacionesCliente(nomMadre, nomPadre, distritoNacimiento, i);
    }

    public void clicSiguiente() {
        WebElement rootInputCorreo = find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        esperaProgresiva(driver(), 3, 3, rootInputCorreo);
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.waitForSeconds(2);
    }

    public void clicEnConfirmar() {
        UtilWeb.waitForSeconds(10);
        List<WebElement> btnConfirm = find().getElementsByXPath("//*[contains(@label,'Confirmar')]"); //find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        esperaProgresiva(driver(), 5, 6, btnConfirm.get(0));
        getVisibleAndClickableElement(btnConfirm).click();
        logInfo("Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void verificarIdentidadValidada() {
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        String loadingInserted = "//div[@class='loadingCard ng-star-inserted']";

        if (esperarLoadingIsNotVisible(loadingInserted, 50)) {
            waitUntilElementIsVisible(buttonIdentidadValidada, 30).isDisplayed();
            logInfo("Identidad validada");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public void clicBotonContinuar() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            logInfo("Entra al while");
            try {
                logInfo("Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 10);
                buttonFound = true;
            } catch (Exception e) {
                logInfo("Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                logInfo(contador + " vez");
            }
        }
        logInfo("Sale del while");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
        logInfo("Click en continuar");
        UtilWeb.waitForSeconds(5);
    }

    public void visualizarContratoEnPantalla() {
        UtilWeb.waitForSeconds(2);
        esperaProgresiva(driver(), 6, 7, btnYes);
    }

    public void clicSiAcepto() {
        esperaProgresiva(driver(), 10, 7, btnYes);
        validateAndClickWithAndWithoutShadowRoot("Yes, accept", btnYes);
        UtilWeb.waitForSeconds(6);
    }

    public void selectDocumentTypeSupervisor(String documentTypeSupervisor) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, selectDocumentType);
        selectDocumentType.click();
        UtilWeb.waitForSeconds(1);
        selectElementCSS("mat-option", documentTypeSupervisor);
    }

    public void typeDocumentNumberSupervisor(String documentNumberSupervisor) {
        WebElement inputDocumentNumber = find().getElementByCss("tdp-st-input-text[formcontrolname='numDoc']");
        validateAndTypeWithAndWithoutShadowRoot("document number", inputDocumentNumber, documentNumberSupervisor);
        UtilWeb.waitForSeconds(1);
    }

    public void typeUserNameSupervisor(String user) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(1);
        WebElement inputSuperUser = find().getElementByCss("tdp-st-input-text[formcontrolname=\"usuarioCitrixSupervisor\"], tdp-st-input-text[id=\"usuarioCitrixSupervisor\"]");
        validateAndTypeWithAndWithoutShadowRoot("user supervisor", inputSuperUser, user);
    }

    public void typePasswordNameSupervisor(String password) {
        UtilWeb.waitForSeconds(1);
        WebElement inputPassword = find().getElementByCss("tdp-st-input-text[formcontrolname=\"passwordCitrixSupervisor\"],tdp-st-input-text[id=\"passwordCitrixSupervisor\"]");
        validateAndTypeWithAndWithoutShadowRoot("password supervisor", inputPassword, password);
    }

    public void clicConfirmarUsuarioSupervisor() {
        WebElement btnConfirmar = find().getElementByCss("app-modal-discapacitado [label=\"Confirmar\"].buttonConsultar,  app-modal-discapacitado  button[type=\"submit\"]");
        js().scrollElementTop(btnConfirmar);
        click(btnConfirmar);
        UtilWeb.waitForSeconds(2);
    }

    public void validacionesCliente(String madre, String padre, String lugar, Integer i) {
        revisarModalError(driver());

        try {
            WebElement elementPadre = driver().findElement(By.xpath("//p[contains(text(),'el nombre de tu padre')]"));
            esperaProgresiva(driver(), 5, 6, elementPadre);
            logInfo("Cual es el nombre de tu padre : " + true);
            WebElement padreElement = find().getElementByXPath("//span[contains(text(),'" + padre + "')]/..");
            padreElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            logSevere("No hay padre");
        }

        try {
            WebElement elementMadre = driver().findElement(By.xpath("//p[contains(text(),'el nombre de tu madre')]"));
            esperaProgresiva(driver(), 5, 6, elementMadre);
            logInfo("Cual es el nombre de tu madre : " + true);
            WebElement madreElement = find().getElementByXPath("//span[contains(text(),'" + madre + "')]/..");
            madreElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            logSevere("No hay madre");
        }

        try {
            WebElement elementNacimiento = driver().findElement(By.xpath("//p[contains(text(),'distrito naciste')]"));
            esperaProgresiva(driver(), 5, 6, elementNacimiento);
            logInfo("En que distrito naciste : " + true);
            WebElement lugarElement = find().getElementByXPath("//span[contains(text(),'" + lugar + "')]/..");
            lugarElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            logSevere("No hay nacimiento");
        }
        UtilWeb.waitForSeconds(5);
    }

    public boolean esperarLoadingIsNotVisible(String xpath, int segundos) {
        boolean retorno;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver(), Duration.ofSeconds(segundos));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            logSevere("No se espero a que se oculte el elemento");
        }
        return retorno;
    }

    public boolean esNuevoCliente() {
        if (nombreClienteUserData.getText().length() > 8) {
            return false;
        } else {
            return true;
        }
    }

    public void ingresarNombreClienteExtranjero(String nombre) {
        UtilWeb.waitForSeconds(3);
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='nomCli']");
        esperaProgresiva(driver(), 5, 5, rootElement);
        revisarModalError(driver());
        SearchContext context = sh().getContext(rootElement);
        revisarModalError(driver());
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(nombre);
        UtilWeb.waitForSeconds(1);
    }

    public void ingresarApellidoClienteExtranjero(String apellidos) {
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='apeCli']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(apellidos);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarGeneroClienteExtranjero(String genero) {
        WebElement generoList = find().getElementByXPath("//div/tdp-st-select[@formcontrolname='genero']");
        click(generoList);
        String dataValue = "";
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

    /**
     * FUNCION - VALIDAR CONTRATO GENERADO CALL CENTER
     * */

    public void clicValidarContrato() {
        int contador = 0;
        boolean existeElement = false;
        while (contador <= 3 && !existeElement) {
            contador++;
            try {
                logInfo("Ingreso a visualizar la existencia del boton VALIDAR CONTRATO");
                UtilWeb.waitForSeconds(2);
                if (buttonValidarContrato.isDisplayed()) {
                    logInfo("BOTON VALIDAR CONTRATO - EXISTE");
                    js().scrollElementTop(buttonValidarContrato);
                    existeElement = true;
                    logInfo("Click button " + buttonValidarContrato.getText());
                    logInfo("buttonValidarContrato isDisplayed: " + buttonValidarContrato.isDisplayed() +
                            " - isEnabled " + buttonValidarContrato.isEnabled() +
                            " - isSelected " + buttonValidarContrato.isSelected());
                    click(buttonValidarContrato,5);
                    view.temporalPage().barraCargando();
                }
            } catch (Exception e) {
                logInfo("NO SE VISUALIZO EL BOTON VALIDAR CONTRATO - N°" + contador);
                logSevere("ERROR", e.getMessage());
            }
        }
    }
}
