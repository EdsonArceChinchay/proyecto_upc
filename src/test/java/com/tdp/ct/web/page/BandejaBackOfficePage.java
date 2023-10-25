package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class BandejaBackOfficePage extends WebBase{
    @FindBy(xpath = "//button[text()='Ver detalle']")
    protected WebElement btnDetalle;
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

        if(!etiquetaCargado.getText().equals("CARGADO")){
            fileRuta.sendKeys("C://Almacenar//Audio//FE-1000044792.mp3");
            UtilWeb.waitForSeconds(1);
            esperaProgresiva(driver(),3,5,etiquetaCargado);
            Assert.assertEquals("No se Cargo correctamente","CARGADO",etiquetaCargado.getText());
        }else{
            System.out.println("Adjuno ya subido anteriormente");
        }

    }

    public void seleccionoSolicitud(String solicitud) {
        esperaProgresiva(driver(),3,3,btnDetalle);
        //btnDetalle.click();
        List<WebElement> verDetalleButtons = driver().findElements(By.xpath("//button[text()='Ver detalle']"));
        System.out.println("Botones: " + verDetalleButtons.size());
        for (WebElement button : verDetalleButtons){
            WebElement parentDiv = button.findElement(By.xpath("../../.."));

            //WebElement solicitudElement = parentDiv.findElement(By.xpath(".//span[contains(text(), '" + solicitud + "')]"));
            WebElement solicitudElement = parentDiv.findElement(By.xpath("//span[contains(text(), '" + solicitud + "')]/ancestor::div[contains(@class, 'tdp-row')]//button[text()='Ver detalle']"));
            //span[contains(text(), 'FE1000142105')]/ancestor::div[contains(@class, 'tdp-row')]//button[text()='Ver detalle']
            if (solicitudElement != null) {
                button.click();
                break;
            }else{
                System.out.println("no encontrado" );
            }
        }
        esperaProgresiva(driver(),3,3,btnCargarAudio);
    }


}
