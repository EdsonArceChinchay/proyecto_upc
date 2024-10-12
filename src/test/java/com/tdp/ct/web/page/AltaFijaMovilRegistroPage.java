package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Helper.*;

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
    @FindBy(xpath = "//*[contains(text(),'Tipo de Documento')]/../../../../..")
    protected WebElement selectTipoDoc;
    @FindBy(xpath = "//mat-option/span")
    protected List<WebElement> listDocumentos;
    @FindBy(xpath = "//h4[contains(text(),'Validar identidad del titular')]")
    protected WebElement lblPreguntas;
    @FindBy(xpath = "//*[contains(text(),' Continuar ')]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(xpath = "//tdp-st-button[@label='Sí, acepta']")
    protected WebElement rootModalButtonSiAcepto;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Identidad Validada')]")
    protected WebElement buttonIdentidadValidada;
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;

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
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void verificarIdentidadValidada() {
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        String loadingInserted = "//div[@class='loadingCard ng-star-inserted']";

        if (esperarLoadingIsNotVisible(loadingInserted, 50)) {
            waitUntilElementIsVisible(buttonIdentidadValidada, 30).isDisplayed();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Identidad validada");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public void clicValidarContrato() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(20);
        Addons.esperaProgresiva(driver(), 7, 8, buttonValidarContrato);
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Start while");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Retry " + (contador + 1));
            try {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Start try");
                Addons.revisarModalError(driver());
                buttonFound = waitUntilElementIsClickable(buttonValidarContrato, 60).isDisplayed();
                UtilWeb.waitForSeconds(10);
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR - " + e.getMessage());
                UtilWeb.waitForSeconds(10);
            }
            contador++;
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Finish while");
        UtilWeb.waitForSeconds(10);
        Addons.revisarModalError(driver());
        js().scrollElementTop(buttonValidarContrato);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + buttonValidarContrato.getText());
        UtilWeb.logger(this.getClass()).log(Level.INFO, "buttonValidarContrato isDisplayed: " + buttonValidarContrato.isDisplayed() + " - isEnabled " + buttonValidarContrato.isEnabled() + " - isSelected " + buttonValidarContrato.isSelected());
        buttonValidarContrato.click();
    }

    public void clicBotonContinuar() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al while");
            try {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 10);
                buttonFound = true;
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO,"Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                UtilWeb.logger(this.getClass()).log(Level.INFO,contador + " vez");
            }
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO,"Sale del while");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
        UtilWeb.waitForSeconds(5);
    }

    public void visualizarContratoEnPantalla() {
        UtilWeb.waitForSeconds(2);
        WebElement element = sh().getWebElement(rootModalButtonSiAcepto, "button");
        int intentos = 4;
        for (int i = 0; i < intentos; i++) {
            try {
                esperaProgresiva(driver(), 5, 7, element);
                JavascriptExecutor js = (JavascriptExecutor) driver();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                return;
            } catch (NoSuchElementException e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO,"No se pudo encontrar el elemento" + (i + 1) + " intentos. Error: " + e.getMessage());

            }
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mostrando contrato en pantalla");
    }

    public void clicSiAcepto() {
        WebElement element = sh().getWebElement(rootModalButtonSiAcepto, "button");
        esperaProgresiva(driver(), 5, 5, element);
        element.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dando click en si acepto");
        UtilWeb.waitForSeconds(6);
    }

    public void ingresarDNISupervisor(String numdoc) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, selectTipoDoc);
        waitUntilElementIsClickable(selectTipoDoc, 30).click();
        clickElementInAList(listDocumentos, "DNI");
        UtilWeb.waitForSeconds(1);
        WebElement rootInput = find().getElementByXPath("//app-modal-discapacitado//form//div/div/tdp-st-input-text");
        typeInShadowRootCssSelector(numdoc, rootInput, "div input");
        UtilWeb.waitForSeconds(1);
    }

    public void IngresarUsuarioSupervisor(String user) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(1);
        WebElement inputSuperUser = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[1]");
        typeInShadowRootCssSelector(user, inputSuperUser, "div input");
    }

    public void ingresarPasswordSupervisor(String password) {
        UtilWeb.waitForSeconds(1);
        WebElement rootInputCorreo = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[2]");
        typeInShadowRootCssSelector(password, rootInputCorreo, "div input");
    }

    public void clicConfirmarUsuarioSupervisor() {
        WebElement btnConfirmar = find().getElementByXPath("//button[@label='Confirmar']");
        js().scrollElementTop(btnConfirmar);
        UtilWeb.waitForSeconds(1);
        click(btnConfirmar);
        UtilWeb.waitForSeconds(2);
    }

    public void validacionesCliente(String madre, String padre, String lugar, Integer i) {
        revisarModalError(driver());

        try {
            WebElement elementPadre = driver().findElement(By.xpath("//p[contains(text(),'el nombre de tu padre')]"));
            esperaProgresiva(driver(), 5, 6, elementPadre);
            UtilWeb.logger(this.getClass()).log(Level.INFO,"Cual es el nombre de tu padre : " + true);
            WebElement padreElement = find().getElementByXPath("//span[contains(text(),'" + padre + "')]/..");
            padreElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO,"No hay padre");
        }

        try {
            WebElement elementMadre = driver().findElement(By.xpath("//p[contains(text(),'el nombre de tu madre')]"));
            esperaProgresiva(driver(), 5, 6, elementMadre);
            UtilWeb.logger(this.getClass()).log(Level.INFO,"Cual es el nombre de tu madre : " + true);
            WebElement madreElement = find().getElementByXPath("//span[contains(text(),'" + madre + "')]/..");
            madreElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO,"No hay madre");
        }

        try {
            WebElement elementNacimiento = driver().findElement(By.xpath("//p[contains(text(),'distrito naciste')]"));
            esperaProgresiva(driver(), 5, 6, elementNacimiento);
            UtilWeb.logger(this.getClass()).log(Level.INFO,"En que distrito naciste : " + true);
            WebElement lugarElement = find().getElementByXPath("//span[contains(text(),'" + lugar + "')]/..");
            lugarElement.click();
            UtilWeb.waitForSeconds(5);
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO,"No hay nacimiento");
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
            UtilWeb.logger(this.getClass()).log(Level.INFO,"No se espero a que se oculte el elemento");
        }
        return retorno;
    }


}
