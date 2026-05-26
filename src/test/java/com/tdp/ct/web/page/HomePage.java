package com.tdp.ct.web.page;

import com.google.gson.JsonObject;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.SessionStorage.getSessionStorageAsJsonObject;
import static com.tdp.ct.web.utils.SessionStorage.getValueJsonObjectSessionStorage;
import static com.tdp.ct.web.utils.WebUtils.*;

public class HomePage extends WebBase {

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div | //app-client-info")
    protected WebElement txtNombre;
    @FindBy(css = "[class*='buttonConsultar']")
    protected WebElement btnSearch;
    @FindBy(css = "[class='validation'] tdp-st-input-text")
    protected WebElement txtDocumento;
    @FindBy(xpath = "//*[@class='validation']//app-simple-button")
    protected WebElement btnValidar;
    @FindBy(css = "[class='validation'] tdp-st-select")
    protected WebElement listaDocumentos;
    @FindBy(xpath = "//img[@class='close'] | //button[contains(text(),' CONTINUAR')]")
    protected WebElement botonX;
    @FindBy(css = ".message-welcome span")
    protected WebElement msgHome;
    @FindBy(xpath = "//*[contains(text(),'Inicio')]")
    protected WebElement btnInicio;
    @FindBy(xpath = "//img[@src='assets/images/login-icono.svg']")
    protected WebElement iconAsesor;
    @FindBy(xpath = "(//*[contains(text(),'Cerrar s')])[1]")
    protected WebElement btnCerrar;
    @FindBy(css = "[@class='atras']")
    protected WebElement btnAtras;
    @FindBy(xpath = "//*[contains(@alt,'icon_bandeja') or contains(@src,'icon_bandeja.svg')]")
    protected WebElement btnBackOffice;
    @FindBy(css = "tdp-st-select[formcontrolname='tipoDoc']")
    protected WebElement selectDocumentType;

    @FindBy(id = "id-searchclient-tdp")
    protected WebElement inputDocumentNumber;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();
    public void typeDocumentNumber(String documentNumber) {
        validateAndTypeWithAndWithoutShadowRoot("document number", inputDocumentNumber, documentNumber);
    }
    public void selectDocumentType(String type) {
        String valueDocumentType;
        switch (type) {
            case "CE":
            case "C":
                valueDocumentType = "CE";
                break;
            case "DNI":
                valueDocumentType = "DNI";
                break;
            case "Pasaporte":
            case "P":
                valueDocumentType = "P";
                break;
            case "RUC":
                valueDocumentType = "RUC";
                break;
            default:
                throw new IllegalArgumentException("Tipo de documento no existe " + type);
        }
        esperaProgresiva(driver(), 6, 5, selectDocumentType);
        js().scrollElementTop(selectDocumentType);

        selectElementCSSWithAndWithoutShadowRoot("document type", selectDocumentType, valueDocumentType);

        // ✅ ESPERAR QUE EL INPUT SE REGENERE
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(20));

        wait.until(d -> {
            try {
                WebElement host = driver().findElement(By.id("id-searchclient-tdp"));
                return host.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });

        UtilWeb.waitForSeconds(1); // micro stabilizer

    }

    public void typeDocumentNumber1(String documentNumber) {

        JavascriptExecutor js = (JavascriptExecutor) driver();

        int maxRetries = 5;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {

            try {
                logInfo("🚀 intento #" + attempt);

                WebElement input = null;

                // ✅ 1. localizar input (shadow o normal)
                try {
                    WebElement host = driver().findElement(By.id("id-searchclient-tdp"));

                    try {
                        // intentar shadow
                        input = host.getShadowRoot().findElement(By.cssSelector("input"));
                        logInfo("✅ encontrado en SHADOW DOM");

                    } catch (Exception shadowError) {
                        // fallback: buscar dentro del host (light DOM)
                        input = host.findElement(By.cssSelector("input"));
                        logInfo("✅ encontrado en DOM INTERNO (sin shadow)");
                    }

                } catch (Exception e) {
                    // fallback global por si todo cambia
                    input = driver().findElement(By.cssSelector("input[id='id-searchclient-tdp']"));
                    logInfo("✅ encontrado en DOM GLOBAL");
                }

                // ✅ 2. escribir directo (sin esperar Angular)
                js.executeScript(
                        "arguments[0].value = arguments[1];",
                        input,
                        documentNumber
                );

                // ✅ 3. eventos Angular
                js.executeScript(
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                        input
                );

                js.executeScript(
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                        input
                );

                // ✅ 4. pequeña espera
                UtilWeb.waitForSeconds(1);

                // ✅ 5. validar
                String value = input.getAttribute("value");
                logInfo("🔍 valor actual: " + value);

                if (documentNumber.equals(value)) {
                    logInfo("✅ DOCUMENTO INGRESADO OK");
                    return;
                }

            } catch (Exception e) {
                logInfo("❌ intento falló -> " + e.getMessage());
            }

            UtilWeb.waitForSeconds(2);
        }

        throw new RuntimeException("No se pudo ingresar documento (shadow + DOM dinámico)");
    }

    public void clickOnConsultButton() {
        esperaProgresiva(driver(), 5, 5, btnSearch);
        logInfo("Click button", btnSearch.getText());
        btnSearch.click();
        boolean isB2B = !driver().findElements(By.xpath("//*[contains(text(),'RUC')]")).isEmpty();
        String message = isB2B ? "Customer is B2B" : "Customer is B2C";
        logInfo(message);
        revisarModalError(driver());
    }

    public void validateCustomerData(String customerName, String customerDocumentType, String customerDocumentNumber) {
        UtilWeb.waitForSeconds(2);
        compareWebElementTextAndString(txtNombre, customerName);
        compareWebElementTextAndString(txtNombre, customerDocumentType);
        compareWebElementTextAndString(txtNombre, customerDocumentNumber);
    }

    public void selectCustomerId(String nro) {
        WebElement nroItem = explicitWaitXpath(driver(), 60, "(//tdp-st-radio)[" + nro.trim() + "]");
        nroItem.click();
        UtilWeb.waitForSeconds(1);
    }

    public void clickOnSaveButton() {
        WebElement btnSave = find().getElementByXPath("//*[contains(text(),'Guardar')]");
        btnSave.click();
    }

    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        boolean serviciosContratados = !driver().findElements(By.xpath("//app-card-line")).isEmpty();
        if (serviciosContratados) {
            logInfo("El cliente SI tiene servicios contratados");
            js().scrollElementTop(find().getElementByXPath("//app-card-line"));
            UtilWeb.waitForSeconds(1);
        }
        Assertions.assertTrue(serviciosContratados, "El Cliente NO tiene servicios contratados");
    }

    public void selectTheTypeOfDocumentOfTheLegalRepresentative(String documentType) {
        esperaProgresiva(driver(), 5, 5, listaDocumentos);
        selectElementCSSWithAndWithoutShadowRoot("document type of the legal representative", listaDocumentos, documentType);
    }

    public void typeTheDocumentNumberOfTheLegalRepresentative(String numDoc) {
        waitUntilElementIsVisible(txtDocumento, 10).click();
        validateAndTypeWithAndWithoutShadowRoot("document number of legal representative", txtDocumento, numDoc);
    }

    public void clickOnTheValidateLegalRepresentativeButton() {
        waitUntilElementIsVisible(btnValidar, 10).click();
        UtilWeb.waitForSeconds(20);
    }

    public void clickXPopUpCU() {
        esperaProgresiva(driver(), 2, 3, botonX);
        try {
            botonX.click();
        } catch (Exception e) {
            logSevere("ERROR", e.getMessage());
        }
    }

    public void clickOnTheBackOfficeButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(btnBackOffice));
            click(btnBackOffice);
        } catch (Exception errorClickBackOffice) {
            errorClickBackOffice.printStackTrace();
            Assertions.fail("Error al hacer clic en Back Office: " + errorClickBackOffice.getMessage());
        }
    }

    public String getChannelType() {
        JsonObject agentData = getSessionStorageAsJsonObject(driver(), "datosAgente");
        return getValueJsonObjectSessionStorage(agentData, "channels.id").trim();
    }

    public void validateAgentData(Agent agent, String storeTypeExpected) {
        String message = null;
        if (agent.getFirstName() != null && agent.getLastName() != null) {
            message = validateThatYouAreOnThePage("Agent's name: %s. ", agent.getFullName());
        }
        message = message + validateThatYouAreOnThePage("\nChannel name: %s. ", agent.getChannelName());
        message = message + validateStoreType("\nChannel type: %s", storeTypeExpected, agent.getChannelType());
        printAgentData(message);
    }

    public String validateStoreType(String message, String storeTypeExpected, String storeTypeCurrent) {
        if (storeTypeCurrent != null) {
            if (storeTypeExpected != null) {
                compareStringAndString(storeTypeExpected, storeTypeCurrent);
            }
            return String.format(message, storeTypeCurrent);
        }
        return "";
    }

    public void printAgentData(String message) {
        message = message == null ? "" : message;
        logInfo(message);
    }

    public void backToHomePage() {
        esperaProgresiva(driver(), 3, 5, btnInicio);
        js().scrollElementTop(btnInicio);
        logInfo("Click button " + btnInicio.getText());
        btnInicio.click();
        esperaProgresiva(driver(), 5, 5, msgHome);
    }

    public void clickOnTheAdvisorIcon() {
        waitUntilElementIsClickable(iconAsesor, 10).click();
        logInfo("Click button");
    }

    public void clickOnTheLogoutButton() {
        waitUntilElementIsClickable(btnCerrar, 10).click();
        logInfo("Click button Logout");
        UtilWeb.waitForSeconds(2);
    }

    public void ClickOnBackButton() {
        waitUntilElementIsClickable(btnAtras, 10);
    }

    public String validateThatYouAreOnThePage(String message, String name) {
        if (name != null) {
            WebElement element = find().getElementByXPath("//*[contains(text(),'" + name + "')]");
            Assertions.assertTrue(element.isDisplayed(), String.format("No found element %s", name));
            return String.format(message, name);
        }
        return null;
    }
    public void Zoom(int zoomLevel){
        String zoomScript = "document.body.style.zoom='" + zoomLevel + "%'";
        ((JavascriptExecutor) driver()).executeScript(zoomScript);
        logInfo("Zoom ajustado al " + zoomLevel + "%.");
    }
}