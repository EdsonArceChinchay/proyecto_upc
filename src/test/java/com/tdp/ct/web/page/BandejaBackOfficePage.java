package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.FileUtils.getAbsolutePathString;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.validateInput;

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
    @FindBy(xpath = "//*[contains(@type,'submit') or contains(text(),'Buscar')]")
    protected WebElement btnBuscar;
    @FindBy(css = "tdp-st-button[type='button']")
    protected WebElement btnCargarAudio;

    public void typeDocument(String document) {
        WebElement inputDocument = find().getElementByCss("[formcontrolname='filterPost']");
        waitUntilElementIsClickable(inputDocument, 20).click();
        validateInput("document number", inputDocument, document);
    }

    public void clickButtonSearch() {
        btnBuscar.click();
        logInfo("Click button Search");
        esperaProgresiva(driver(), 3, 5, btnCargarAudio);
    }

    public void openPopUpUploadAudio() {
        esperaProgresiva(driver(), 5, 5, btnCargarAudio);
        btnCargarAudio.click();
        logInfo("Click button Upload Audio");
    }

    public void uploadAudio() {
        esperaProgresiva(driver(), 5, 6, etiquetaCargando);
        if (etiquetaCargando.getText().equals("PENDIENTE AUDIO")) {
            logInfo("Upload Audio");
            fileRuta.sendKeys(getAbsolutePathString("src/test/resources/mp3/FE-audio-ejemplo.mp3"));
            UtilWeb.waitForSeconds(10);
            esperaProgresiva(driver(), 6, 7, etiquetaCargado);
            Assert.assertEquals("No se Cargo correctamente", "CARGADO", etiquetaCargado.getText());
        } else {
            logInfo("Adjunto ya subido anteriormente");
        }
    }

    public void selectRequest(String numberRequest) {
        String codigoVenta = numberRequest.trim();
        logInfo("Sales code: " + codigoVenta);
        esperaProgresiva(driver(), 3, 3, btnDetalle);
        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
        WebElement verDetalleButton = verDetalleButtons.get(verDetalleButtons.size() - 1);
        js().scrollElementTop(verDetalleButton);
        UtilWeb.waitForSeconds(1);
        verDetalleButtons.get(verDetalleButtons.size() - 1).click();
        logInfo("Dio click a Ver detalle " + codigoVenta);
        esperaProgresiva(driver(), 3, 3, btnCargarAudio);
    }

    public void approveRequest() {
        UtilWeb.waitForSeconds(10);
        btnAprobar.click();
        logInfo("Click button Approve");
        esperaProgresiva(driver(), 5, 5, btnBandejaPrincipal);
        UtilWeb.waitForSeconds(5);
        if (etiquetaAprobado.getText().equals("APROBADO")) {
            logInfo("El registro móvil fue exitoso con código de orden: " + codigoOrden);
        } else {
            logInfo("Hubo en error al enviar orden");
        }
    }

}
