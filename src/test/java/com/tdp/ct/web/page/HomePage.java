package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.Helper.compareWebElementTextAndText;

public class HomePage extends WebBase {

    @FindBy(xpath = "//app-root/app-park/body/div/div[1]/div[3]/div[1]")
    protected WebElement boton01;

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

    @FindBy(css = ".tienda-row span")
    protected WebElement tiendaLabel;

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
        UtilWeb.waitForSeconds(2);
        WebElement documentoList = find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
        js().scrollElementTop(btnSearch);
        click(documentoList);
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
    }

    public void typeDocumentNumber(String number) {
        WebElement document = find().getElementByCss("#doc");
        click(document);
        type(document, number);
    }

    public void clickOnConsultButton() {
        esperaProgresiva(driver(), 3, 5, btnSearch);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " +btnSearch.getText());
        btnSearch.click();
        UtilWeb.waitForSeconds(10);
        boolean isB2B =  !driver().findElements(By.xpath("//*[contains(text(),'RUC')]")).isEmpty();
        if (isB2B) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Customer is B2B");
        }
        else{
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Customer is B2C");
            //Addons.esperaCargaMontoDeuda(driver(), 50);
           // esperaProgresiva(driver(), 3, 20, boton01);
        }
        revisarModalError(driver());
    }

    public void validarDatosCliente(String nombre, String tipoDocumento, String nroDocumento) {
        UtilWeb.waitForSeconds(2);
        compareWebElementTextAndText(txtNombre,nombre);
        compareWebElementTextAndText(txtNombre,tipoDocumento);
        compareWebElementTextAndText(txtNombre,nroDocumento);
    }

    public void seleccionoElIDDeClienteNro(String nro) {
        UtilWeb.waitForSeconds(10);
        WebElement nroItem = find().getElementByXPath("(//tdp-st-radio)[" + nro.trim() + "]");
        esperaProgresiva(driver(), 3, 5, nroItem);
        waitUntilElementIsClickable(nroItem, 20);
        nroItem.click();
        UtilWeb.waitForSeconds(1);
        WebElement btnGuardar = find().getElementByXPath("//*[contains(text(),'Guardar')]");
        btnGuardar.click();
    }

    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        UtilWeb.waitForSeconds(5);
        boolean serviciosContratados;
        serviciosContratados = !driver().findElements(By.xpath("//app-card-line")).isEmpty();
        if (serviciosContratados) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El cliente SI tiene servicios contratados");
            js().scrollElementTop(find().getElementByXPath("//app-card-line"));
            UtilWeb.waitForSeconds(1);
        }
        Assertions.assertTrue(serviciosContratados, "El Cliente NO tiene servicios contratados");

    }

    public void seleccionoElTipoDeDocumentoDelRepresentanteLegal(String tipDoc) {
        boolean existe = false;
        String tipoDocEsperado = tipDoc.trim().toLowerCase();
        String nombretipoDoc = "";
        esperaProgresiva(driver(), 2, 5, listaDocumentos);
        js().scrollElementTop(listaDocumentos);
        click(listaDocumentos);
        SearchContext context = sh().getContext(listaDocumentos);
        List<WebElement> listaDoc = context.findElements(By.cssSelector("ul li"));
        UtilWeb.waitForSeconds(1);
        for (WebElement element : listaDoc) {
            nombretipoDoc = element.getText().trim().toLowerCase();
            if (nombretipoDoc.contains(tipoDocEsperado)) {
                existe = true;
                element.click();
            }
            System.out.println(nombretipoDoc + "nombre documento");
        }
        Assertions.assertTrue(existe, "no se encontro: " + nombretipoDoc);
    }

    public void ingresoElNumeroDelDocumentoDelRepresentanteLegal(String numDoc) {
        waitUntilElementIsVisible(txtDocumento, 10).click();
        type(txtDocumento, numDoc);
    }

    public void doyClickEnValidarRepresentaLegal() {
        waitUntilElementIsVisible(btnValidar, 10).click();
    }

    public void clickXPopUpCU() {
        esperaProgresiva(driver(), 2, 3, botonX);
        try {
            botonX.click();
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.WARNING, "ERROR -" +e.getMessage());

        }
    }

    public void clickOnTheBackOfficeButton() {
        esperaProgresiva(driver(), 3, 5, btnBackOffice);
        click(btnBackOffice);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Back Office ");
        UtilWeb.waitForSeconds(5);
    }

    public void validateHomeMessage(String msg) {
        UtilWeb.waitForSeconds(1);
        Addons.revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, msgHome);
        compareWebElementTextAndText(msgHome,msg);
        UtilWeb.waitForSeconds(1);
    }

    public void validateStoreType(String tienda) {
       // compareWebElementTextAndText(tiendaLabel,tienda);
        //UtilWeb.waitForSeconds(1);
    }

    public void regresarPaginaInicio() {
        esperaProgresiva(driver(), 3, 5, btnInicio);
        js().scrollElementTop(btnInicio);
        btnInicio.click();
        esperaProgresiva(driver(), 5, 5, msgHome);
    }

    public void clickOnTheAdvisorIcon() {
        waitUntilElementIsClickable(iconAsesor, 10).click();
    }

    public void clickOnTheLogoutButton() {
        waitUntilElementIsClickable(btnCerrar, 10).click();
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnAtras() {
        waitUntilElementIsClickable(btnAtras, 10).click();
    }

}
