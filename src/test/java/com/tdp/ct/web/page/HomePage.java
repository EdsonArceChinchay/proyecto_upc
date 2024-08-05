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

    public static String AGENTNAME = null;
    public static String CHANNELTYPE = null;
    public static String CHANNELNAME = null;

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
        WebElement nroItem = find().getElementByXPath("(//tdp-st-radio)[" + nro.trim() + "]");
        esperaProgresiva(driver(), 5, 5, nroItem);
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
        esperaProgresiva(driver(), 5, 5, msgHome);
        compareWebElementTextAndString(msgHome, msg);
        validateAgentData();
    }

    public void validateAgentData() {
        String name = getValueJsonObjectSessionStorage(driver(), "datosAgente", "name");
        String lastName = getValueJsonObjectSessionStorage(driver(), "datosAgente", "surname");
        CHANNELTYPE = getValueJsonObjectSessionStorage(driver(), "datosAgente", "channels.id");
        CHANNELNAME = getValueJsonObjectSessionStorage(driver(), "datosAgente", "sites.1.0.name");
        if (name != null && lastName != null) {
            AGENTNAME = name + " " + lastName;
            UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("Agent's name: %s ", AGENTNAME));
            validateThatYouAreOnThePage(AGENTNAME);
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("Channel name: %s and channel type: %s ", CHANNELNAME, CHANNELTYPE));
        if (CHANNELNAME != null) {
            validateThatYouAreOnThePage(CHANNELNAME);
        }
    }

    public String getAgentData(){
        return String.format("Agent's name: %s. \nChannel name: %s. \nChannel type: %s. ", AGENTNAME,CHANNELNAME, CHANNELTYPE);
    }

    public void validateStoreType(String storeType) {
        if (CHANNELTYPE != null && storeType != null) {
            returnValueCompareStringAndString(storeType, CHANNELTYPE);
        }
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

    public void validateThatYouAreOnThePage(String name) {
        WebElement element = find().getElementByXPath("//*[contains(text(),'" + name + "')]");
        Assertions.assertTrue(element.isDisplayed(), String.format("No found element %s", name));
    }

}
