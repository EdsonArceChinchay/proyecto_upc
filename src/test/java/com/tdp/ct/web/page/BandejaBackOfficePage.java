package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    @FindBy(xpath = "//*[@alt='icon_bandeja']")
    protected WebElement btnBackOffice;
    @FindBy(xpath = "//*[contains(@type,'submit') or contains(text(),'Buscar')]")

    protected WebElement btnBuscar;
    @FindBy(xpath = "//tdp-st-button[@type='button']")
    protected WebElement btnCargarAudio;
    @Autowired
    private Cliente cliente;

    public void clickBackOffice() {
        esperaProgresiva(driver(), 3, 5, btnBackOffice);
        click(btnBackOffice);
        esperaProgresiva(driver(), 5, 5, btnBuscar);
    }

    public void ingresoDocumento(String documento) {
        waitUntilElementIsClickable(btnBuscar, 20);
        WebElement document = find().getElementByXPath("//*[@name='filterPost' or @formcontrolname='filterPost'or contains(@placeholder,'Buscar DNI o código FE')]");
        esperaProgresiva(driver(), 3, 5, document);
        click(document);
        type(document, documento);
    }

    public void buscoDocumento() {
        btnBuscar.click();
        esperaProgresiva(driver(),3,20,btnCargarAudio);

    }

    public void abrirPopUpCargaAudio() {
        esperaProgresiva(driver(), 3, 20, btnCargarAudio);
        btnCargarAudio.click();
    }

    public void cargarAudio() {
        esperaProgresiva(driver(), 3, 30, etiquetaCargando);
        if (etiquetaCargando.getText().equals("PENDIENTE AUDIO")) {
            fileRuta.sendKeys(obtenerRutaAbsoluta("src//test//resources//mp3//FE-audio-ejemplo.mp3"));
            UtilWeb.waitForSeconds(1);
            esperaProgresiva(driver(), 4, 7, etiquetaCargado);
            Assert.assertEquals("No se Cargo correctamente", "CARGADO", etiquetaCargado.getText());
        } else {
            System.out.println("Adjunto ya subido anteriormente");
        }

    }

    public void seleccionoSolicitud(String numeroSolicitud) {


        if (numeroSolicitud.equals("")||numeroSolicitud!=null) {
            System.out.println("no viene numero solicitud");
            esperaProgresiva(driver(), 3, 3, btnDetalle); //click(btnDetalle);
            List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
            System.out.println("Ver Detalle");
            WebElement verDetalleButton = verDetalleButtons.get(verDetalleButtons.size() - 1);
            js().scrollElementTop(verDetalleButton);
            UtilWeb.waitForSeconds(1);
            verDetalleButtons.get(verDetalleButtons.size() - 1).click();
        }
    else{
        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
        System.out.println("Botones: " + verDetalleButtons.size());
        String btnVerDetalle = "//span[contains(text(), '" + numeroSolicitud + "')]/ancestor::div[contains(@class, 'tdp-row')]//*[text()='Ver detalle']";
        System.out.println("ver Detalle: " +  btnVerDetalle);
        WebElement solicitudElement = driver().findElement(By.xpath(btnVerDetalle));

        if (solicitudElement != null) {
            System.out.println("Clic Ver Detalle");
            js().scrollElementTop(solicitudElement);
            solicitudElement.click();
        }else{
            System.out.println("ver Detalle - no encontrado" );
        }
    }
    esperaProgresiva(driver(),3,3,btnCargarAudio);
    }

    public void aprueboSolicitud() {
        btnAprobar.click();
        esperaProgresiva(driver(), 3, 3, btnBandejaPrincipal);
        if (etiquetaAprobado.getText().equals("APROBADO")) {
            System.out.println("El registro móvil fue exitoso con código de orden: " + codigoOrden);
        } else {
            System.out.println("Hubo en error al enviar orden");
        }
        UtilWeb.waitForSeconds(20);
    }
}
