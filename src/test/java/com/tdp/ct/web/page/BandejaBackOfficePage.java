package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.obtenerRutaAbsoluta;

public class BandejaBackOfficePage extends WebBase {
    @FindBy(xpath = "//app-root/app-success-simple/div[2]/button")
    protected WebElement btnBandejaPrincipal;
    @FindBy(xpath = "//p[@class='codigo-small' and text()='Código de orden']")
    protected WebElement codigoOrden;
    @FindBy(xpath = "//div[contains(text(), 'APROBADO')]")
    protected WebElement etiquetaAprobado;
    @FindBy(xpath = "//*[@type='button' and contains(text(),'Aprobar')]")
    protected WebElement btnAprobar;
    @FindBy(xpath = "//button[text()='Ver detalle']")
    protected WebElement btnDetalle;
    @FindBy(xpath = "//span[contains(text(), 'PENDIENTE AUDIO')]")
    protected WebElement etiquetaCargando;
    @FindBy(xpath = "//span[contains(text(), 'CARGADO')]")
    protected WebElement etiquetaCargado;
    @FindBy(id = "fileDropRef")
    protected WebElement fileRuta;
    @FindBy(xpath = "//*[contains(@alt,'icon_bandeja') or contains(@src,'icon_bandeja.svg')]")
    protected WebElement btnBackOffice;
    @FindBy(xpath = "//*[contains(@type,'submit') or contains(text(),'Buscar')]")
    protected WebElement btnBuscar;
    @FindBy(xpath = "//tdp-st-button[@type='button']")
    protected WebElement btnCargarAudio;

    public void clickBackOffice() {
        esperaProgresiva(driver(), 3, 5, btnBackOffice);
        click(btnBackOffice);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Back Office ");
        UtilWeb.waitForSeconds(5);
    }

    public void typeDocument(String documento) {
        WebElement document = find().getElementByXPath("//*[@name='filterPost' or @formcontrolname='filterPost'or contains(@placeholder,'Buscar DNI o código FE')]");
        waitUntilElementIsClickable(document, 20).click();
        type(document, documento);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type document number: " + documento);
    }

    public void clickButtonSearch() {
        btnBuscar.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Search");
        esperaProgresiva(driver(), 5, 5, btnCargarAudio);
    }

    public void openPopUpUploadAudio() {
        esperaProgresiva(driver(), 5, 5, btnCargarAudio);
        btnCargarAudio.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Upload Audio");
    }

    public void uploadAudio() {
        esperaProgresiva(driver(), 5, 6, etiquetaCargando);
        if (etiquetaCargando.getText().equals("PENDIENTE AUDIO")) {
            fileRuta.sendKeys(obtenerRutaAbsoluta("src//test//resources//mp3//FE-audio-ejemplo.mp3"));
            UtilWeb.waitForSeconds(1);
            esperaProgresiva(driver(), 4, 7, etiquetaCargado);
            Assert.assertEquals("No se Cargo correctamente", "CARGADO", etiquetaCargado.getText());
        } else {
            System.out.println("Adjunto ya subido anteriormente");
        }
    }

    public void selectRequest(String numberRequest) {
        String codigoVenta = numberRequest.trim();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Sales code: " + codigoVenta);

        //      if (codigoVenta.equals("")) {
        //         System.out.println("no viene numero solicitud");
        esperaProgresiva(driver(), 3, 3, btnDetalle);
        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
        WebElement verDetalleButton = verDetalleButtons.get(verDetalleButtons.size() - 1);
        js().scrollElementTop(verDetalleButton);
        UtilWeb.waitForSeconds(1);
        verDetalleButtons.get(verDetalleButtons.size() - 1).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click a Ver detalle " + codigoVenta);

//        }
//    else{
//        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
//        System.out.println("Botones: " + verDetalleButtons.size());
//        String btnVerDetalle = "//span[contains(text(), '" + codigoVenta + "')]/ancestor::div[contains(@class, 'tdp-row')]//*[text()='Ver detalle']";
//        System.out.println("ver Detalle: " +  btnVerDetalle);
//        WebElement solicitudElement = driver().findElement(By.xpath(btnVerDetalle));
//
//        if (solicitudElement != null) {
//            js().scrollElementTop(solicitudElement);
//            solicitudElement.click();
//            UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click a Ver detalle del "+ codigoVenta);
//
//        }else{
//            System.out.println("ver Detalle - no encontrado" );
//        }
//    }
        esperaProgresiva(driver(), 3, 3, btnCargarAudio);
    }

    public void approveRequest() {
        btnAprobar.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Approve");
        esperaProgresiva(driver(), 3, 3, btnBandejaPrincipal);
        if (etiquetaAprobado.getText().equals("APROBADO")) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El registro móvil fue exitoso con código de orden: " + codigoOrden);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Hubo en error al enviar orden");
        }
        UtilWeb.waitForSeconds(20);
    }

    public boolean isNumber(String tipoDoc) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type document: " + tipoDoc + " is number: ");
        boolean result;
        try {
            Long.parseLong(tipoDoc);
            result = true;
        } catch (NumberFormatException excepcion) {
            result = false;
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type document: " + tipoDoc + " is number: " + result);
        return result;
    }

}
