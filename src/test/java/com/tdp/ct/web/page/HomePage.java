package com.tdp.ct.web.page;

import com.google.gson.JsonObject;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "tdp-st-input-text[id=\"doc\"]")
    protected WebElement inputDocumentNumber;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnconsultar;

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[1]/div[3]/div[1]")
    protected WebElement boton01;

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
        UtilWeb.waitForSeconds(2);
    }

    public void typeDocumentNumber(String documentNumber) {
        validateAndTypeWithAndWithoutShadowRoot("document number", inputDocumentNumber, documentNumber);
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
        esperaProgresiva(driver(), 5, 5, btnBackOffice);
        click(btnBackOffice);
        logInfo("Click button Back Office");
        UtilWeb.waitForSeconds(5);
    }

    public void validateHomeMessage(String msg) {
        int maxAttempts = 3; // Número máximo de intentos
        int attempt = 0;
        boolean isMatched = false;

        while (attempt < maxAttempts && !isMatched) {
            try {
                // Verificar si existe un modal de error y cerrarlo
                Addons.revisarModalError(driver());

                // Intentar encontrar el mensaje de bienvenida
                WebElement message = explicitWaitCss(driver(), 30, ".message-welcome span");
                compareWebElementTextAndString(message, msg);

                // Verificar mensaje adicional, si aplica
                esperaProgresiva(driver(), 5, 5, msgHome);
                compareWebElementTextAndString(msgHome, msg);

                // Si no lanza excepción, el texto coincide
                isMatched = true;
            } catch (AssertionError e) {
                // El texto no coincide
                logInfo("El texto no coincide. Se refrescará la página, intento Nro: " + (attempt + 1));
            } catch (TimeoutException e) {
                // El elemento no fue encontrado dentro del tiempo de espera
                logInfo("No se encontró el elemento esperado. Se refrescará la página, intento Nro: " + (attempt + 1));
            } catch (Exception e) {
                // Otros errores inesperados
                throw new RuntimeException("Error inesperado durante la validación de la página de bienvenida: ", e);
            }

            if (!isMatched) {
                attempt++;
                if (attempt < maxAttempts) {
                    // Refrescar la página y reintentar
                    driver().navigate().refresh();
                    logInfo("Página refrescada. Reintentando...");
                } else {
                    // Agotar intentos
                    throw new RuntimeException("Se alcanzó el máximo de intentos. El texto no coincide.");
                }
            }
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