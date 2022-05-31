package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AltaMonoInstalacionHfcTiendaPage extends WebBase {

    @FindBy(css = ".content_title .title")
    protected WebElement titleOfertas;

    @FindBy(css = ".tdp-col-md-6:nth-child(2) .tdp-col-2 .margin-icon.add_pointer")
    protected WebElement btnPlanNuevo;

    @FindBy(xpath = "//button[contains(text(),'Mono')]")
    protected WebElement btnPlanMono;

    @FindBy(xpath = "//button[contains(text(),'Línea nueva')]")
    protected WebElement btnLineaNueva;

    @FindBy(css = ".tdp-col-4:nth-child(1) .detail-content div.features")
    protected WebElement featureContent;

    @FindBy(xpath = "//button[text()='Crear cliente']")
    protected WebElement buttonCrearCliente;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnConsultarCobertura;

    public void scrollToBtnCrearCliente(){
        js().scrollElementTop(find().getElementByCss("div.consulta"));
    }

    public void crearCliente() {
        click(buttonCrearCliente);
        UtilWeb.waitForSeconds(2);
    }

    public void scrollDirecCompleta(){
        js().scrollElementTop(find().getElementByCss("div.info-user"));
        UtilWeb.waitForSeconds(3);
    }

    public void clickBtnConsultarCobertura(){
        click(btnConsultarCobertura);
    }

    public void validarOfertasSugeridasView(String title){
        waitUntilElementIsVisible(titleOfertas, 25);
        UtilWeb.waitForSeconds(4);
        js().scrollElementTop(find().getElementByXPath("//nav"));
        String actualTitle = titleOfertas.getText().toLowerCase();
        Assert.assertEquals("El titulo obtenido: "+ actualTitle +", no coincide con lo esperado", title.toLowerCase(), actualTitle);
    }

    public void scrollToBtnPlanNuevo(){
        js().scrollElementTop(titleOfertas);
    }

    public void clickBtnPlanNuevo(){
        click(btnPlanNuevo);
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnMono(){
        click(btnPlanMono);
    }

    public void esperarBtnLineaNueva(){
        waitUntilElementIsVisible(btnLineaNueva, 8);
    }

    public void clickBtnLineaNueva(){
        click(btnLineaNueva);
    }

    public void validarDetallePlan(){
        waitUntilElementIsVisible(featureContent, 10);
        js().scrollElementTop(find().getElementByCss("span.pst-return"));
        Assertions.assertFalse(featureContent.getText().isEmpty(), "No se encuentran caracteristicas en el contenedor");
        UtilWeb.waitForSeconds(1);
    }

    public void scrollToViewAgendamiento(){
        js().scrollElementTop(find().getElementByCss("div.return"));
    }
}
