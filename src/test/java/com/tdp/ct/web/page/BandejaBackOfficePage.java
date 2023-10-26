package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;
import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class BandejaBackOfficePage extends WebBase{
    @FindBy(xpath = "/html/body/app-root/app-success-simple/div[2]/button")
    protected WebElement btnBandejaPrincipal;
    @FindBy(xpath = "//p[@class='codigo-small' and text()='Código de orden']")
    protected WebElement codigoOrden;
    @FindBy(xpath = "//div[contains(text(), 'APROBADO')]")
    protected WebElement etiquetaAprobado;
    @FindBy(xpath = "/html/body/app-root/app-offer-detail/div[2]/button[2]")
    protected WebElement btnAprobar;
    @FindBy(xpath = "//button[text()='Ver detalle']")
    protected WebElement btnDetalle;
    @FindBy(xpath = "//span[contains(text(), 'PENDIENTE AUDIO')]")
    protected WebElement etiquetaCargando;
    @FindBy(xpath = "//span[contains(text(), 'CARGADO')]")
    protected WebElement etiquetaCargado;
    @FindBy(id = "fileDropRef")
    protected WebElement fileRuta;
    @FindBy(xpath = "/html/body/app-root/app-inicio/div/div/div[1]/div[1]")
    protected WebElement btnBackOffice;
    @FindBy(xpath = "/html/body/app-root/app-offer-tray/body/div/div[1]/div[2]/form/div[2]/div/div[3]")
    protected WebElement btnBuscar;
    //@FindBy(xpath = "//*[@id=\"offer-row_item\"]/div/div[3]/button")
    //protected WebElement btnDetalle;

    @FindBy(xpath = "//tdp-st-button[@type='button']")
    protected WebElement btnCargarAudio;
    public void clickBackOffice(){
        click(btnBackOffice);
        waitUntilElementIsVisible(find().getElementByXPath("/html/body/app-root/app-offer-tray/body/div/div[1]/div[2]/form/div[2]/div/div[3]/button"), 5);
    }
    public void ingresoDocumento(String documento) {
        WebElement document = find().getElementByXPath("/html/body/app-root/app-offer-tray/body/div/div[1]/div[2]/form/div[1]/div/div/input");
        click(document);
        type(document,documento);
    }
    public void buscoDocumento() {
        btnBuscar.click();
        waitUntilElementIsVisible(find().getElementByXPath("//*[@id=\"offer-row_item\"]/div/div[3]/button"),5 );

    }
    public void abrirPopUpCargaAudio() {
        btnCargarAudio.click();
        UtilWeb.waitForSeconds(3);
    }

    public void cargarAudio() {
        if(etiquetaCargando.getText().equals("PENDIENTE AUDIO")){
            fileRuta.sendKeys("C://Almacenar//Audio//FE-1000044792.mp3");
            UtilWeb.waitForSeconds(1);
            esperaProgresiva(driver(),3,5,etiquetaCargado);
            Assert.assertEquals("No se Cargo correctamente","CARGADO",etiquetaCargado.getText());
        }else{
            System.out.println("Adjunto ya subido anteriormente");
        }

    }

    public void seleccionoSolicitud(String solicitud) {
        esperaProgresiva(driver(),3,3,btnDetalle);
        //btnDetalle.click();
        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
        System.out.println("Botones: " + verDetalleButtons.size());
        //for (WebElement button : verDetalleButtons){
           // WebElement parentDiv = driver().findElement(By.xpath("../../.."));

            //WebElement solicitudElement = parentDiv.findElement(By.xpath(".//span[contains(text(), '" + solicitud + "')]"));
            String btnVerDetalle = "//span[contains(text(), '" + solicitud + "')]/ancestor::div[contains(@class, 'tdp-row')]//button[text()='Ver detalle']";
            System.out.println("ver Detalle: " +  btnVerDetalle);
            WebElement solicitudElement = driver().findElement(By.xpath(btnVerDetalle));

            //span[contains(text(), 'FE1000142105')]/ancestor::div[contains(@class, 'tdp-row')]//button[text()='Ver detalle']
            if (solicitudElement != null) {
                System.out.println("Clic Ver Detalle");
                js().scrollElementTop(solicitudElement);
                solicitudElement.click();
                //button.click();
                //break;
            }else{
                System.out.println("ver Detalle - no encontrado" );
            }
        //}
        esperaProgresiva(driver(),3,3,btnCargarAudio);
    }

    public void aprueboSolicitud() {
        btnAprobar.click();
        esperaProgresiva(driver(),3,3,btnBandejaPrincipal);
        if (etiquetaAprobado.getText().equals("APROBADO")){
            System.out.println("El registro móvil fue exitoso con código de orden: "+ codigoOrden);
        }else{
            System.out.println("Hubo en error al enviar orden");
        }
    }
}
