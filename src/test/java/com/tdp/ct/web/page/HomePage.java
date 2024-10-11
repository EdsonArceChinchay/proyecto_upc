package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.Helper.*;
import static com.tdp.ct.web.utils.SessionStorage.*;

public class HomePage extends WebBase {

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div | //app-client-info")
    protected WebElement txtNombre;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnSearch;

    @FindBy(xpath = "//*[@class='validation']//tdp-st-input-text")
    protected WebElement txtDocumento;

    @FindBy(xpath = "//*[@class='validation']//app-simple-button")
    protected WebElement btnValidar;

    @FindBy(xpath = "//*[@class='validation']//tdp-st-select")
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

    @FindBy(xpath = "//*[@class='atras']")
    protected WebElement btnAtras;

    @FindBy(xpath = "//*[contains(@alt,'icon_bandeja') or contains(@src,'icon_bandeja.svg')]")
    protected WebElement btnBackOffice;

    public void selectDocumentType(String type) {
        WebElement documentoList = find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
        js().scrollElementTop(btnSearch);
        esperaProgresiva(driver(), 6, 5, documentoList);
        click(documentoList);
        UtilWeb.waitForSeconds(2);
        String valueTipoDocumento;
        SearchContext context = sh().getContext(documentoList);
        switch (type) {
            case "CE":
            case "C":
                valueTipoDocumento = "C";
                break;
            case "DNI":
                valueTipoDocumento = "DNI";
                break;
            case "Pasaporte":
            case "P":
                valueTipoDocumento = "P";
                break;
            case "RUC":
                valueTipoDocumento = "RUC";
                break;
            default:
                throw new IllegalArgumentException("Tipo de documento no existe " + type);
        }
        context.findElement(By.cssSelector("[data-value='" + valueTipoDocumento + "']")).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Select document type " + valueTipoDocumento);
    }

    public void typeDocumentNumber(String number) {
        WebElement document = find().getElementByCss("#doc");
        click(document);
        type(document, number);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type document number " + number);
    }

    public void clickOnConsultButton() {
        esperaProgresiva(driver(), 5, 5, btnSearch);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnSearch.getText());
        btnSearch.click();
        boolean isB2B = !driver().findElements(By.xpath("//*[contains(text(),'RUC')]")).isEmpty();
        String message = isB2B ? "Customer is B2B" : "Customer is B2C";
        UtilWeb.logger(this.getClass()).log(Level.INFO, message);
        revisarModalError(driver());
    }

    public void validateCustomerData(String nombre, String tipoDocumento, String nroDocumento) {
        UtilWeb.waitForSeconds(2);
        compareWebElementTextAndString(txtNombre, nombre);
        compareWebElementTextAndString(txtNombre, tipoDocumento);
        compareWebElementTextAndString(txtNombre, nroDocumento);
    }

    public void selectCustomerId(String nro) {
        UtilWeb.waitForSeconds(30);
        WebElement nroItem = find().getElementByXPath("(//tdp-st-radio)[" + nro.trim() + "]");
        esperaProgresiva(driver(), 6, 8, nroItem);
        waitUntilElementIsClickable(nroItem, 20).click();
        UtilWeb.waitForSeconds(1);
    }

    public void clickOnSaveButton() {
        WebElement btnSave = find().getElementByXPath("//*[contains(text(),'Guardar')]");
        btnSave.click();
    }

    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        boolean serviciosContratados = !driver().findElements(By.xpath("//app-card-line")).isEmpty();
        if (serviciosContratados) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El cliente SI tiene servicios contratados");
            js().scrollElementTop(find().getElementByXPath("//app-card-line"));
            UtilWeb.waitForSeconds(1);
        }
        Assertions.assertTrue(serviciosContratados, "El Cliente NO tiene servicios contratados");
    }

    public void selectTheTypeOfDocumentOfTheLegalRepresentative(String documentType) {
        esperaProgresiva(driver(), 5, 5, listaDocumentos);
        selectElementShadowRootCSS(documentType, listaDocumentos, "ul li");
    }

    public void typeTheDocumentNumberOfTheLegalRepresentative(String numDoc) {
        waitUntilElementIsVisible(txtDocumento, 10).click();
        type(txtDocumento, numDoc);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type document number of legal representative" + numDoc);
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
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR -" + e.getMessage());
        }
    }

    public void clickOnTheBackOfficeButton() {
        esperaProgresiva(driver(), 5, 5, btnBackOffice);
        click(btnBackOffice);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Back Office ");
        UtilWeb.waitForSeconds(5);
    }

    public void validateHomeMessage(String msg) {
        Addons.revisarModalError(driver());
        UtilWeb.waitForSeconds(10);
        esperaProgresiva(driver(), 5, 8, msgHome);
        compareWebElementTextAndString(msgHome, msg);
    }

    public String getAgentName(){
       return getValueJsonObjectSessionStorage(driver(), "datosAgente", "name");
    }
    public String getAgentLastName(){
        return getValueJsonObjectSessionStorage(driver(), "datosAgente", "surname").trim();
    }
    public String getChannelType(){
        return getValueJsonObjectSessionStorage(driver(), "datosAgente", "channels.id").trim();
    }

    public String getChannelName(){
        return getValueJsonObjectSessionStorage(driver(), "datosAgente", "sites.1.0.name").trim();
    }

    public String getDocumentNumber(){
        return getValueJsonObjectSessionStorage(driver(), "datosAgente", "legalId.nationalID").trim();
    }
    public String getDocumentType(){
        return getValueJsonObjectSessionStorage(driver(), "datosAgente", "legalId.nationalIDType").trim();
    }

    public boolean isRetention() {
        String metadata = getValueJsonObjectSessionStorage(driver(),"MSAL_INFO","metadata");
        boolean isRetention = metadata.contains("B2C_FRONTEND_WEB_RETENCIONES");
        UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("Is retention: "+isRetention));
        return isRetention;
    }

    public String validateAgentData(String storeTypeExpected) {
        String message = null;
        if (getAgentName() != null && getAgentLastName() != null) {
            String fullName = getAgentName() + " " + getAgentLastName();
            message = validateThatYouAreOnThePage("Agent's name: %s. ", fullName);
        }
        message = message + validateThatYouAreOnThePage("\nChannel name: %s. ", getChannelName());
        message = message + validateStoreType("\nChannel type: %s. ", storeTypeExpected, getChannelType());
        return printAgentData(message);
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

    public String printAgentData(String message) {
        message = message == null ? "" : message;
        UtilWeb.logger(this.getClass()).log(Level.INFO, message);
        return message;
    }

    public void backToHomePage() {
        esperaProgresiva(driver(), 3, 5, btnInicio);
        js().scrollElementTop(btnInicio);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnInicio.getText());
        btnInicio.click();
        esperaProgresiva(driver(), 5, 5, msgHome);
    }

    public void clickOnTheAdvisorIcon() {
        waitUntilElementIsClickable(iconAsesor, 10).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button");
    }

    public void clickOnTheLogoutButton() {
        waitUntilElementIsClickable(btnCerrar, 10).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Logout");
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

}
