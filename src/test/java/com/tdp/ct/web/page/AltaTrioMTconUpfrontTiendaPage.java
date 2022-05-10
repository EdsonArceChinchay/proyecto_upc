package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AltaTrioMTconUpfrontTiendaPage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div/div[3]/div[1]/div/div")
    protected WebElement btnLineaNueva ;

    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement btnConsultaCobertura ;

    @FindBy(xpath = "//app-oferta-age/body/div[3]/div[4]/app-footer-offert/div[1]/div/div/div[3]/app-footer-item/div/div[2]/div[3]/div/button")
    protected WebElement btnIrMovistarTotal ;

    @FindBy(xpath = "//app-resume-mt/div/div[6]/div[3]/div/button")
    protected WebElement btnIniciarRegistro ;

    @FindBy(xpath = "//app-lista-contactos/div/div/div[2]/form/div[2]/div/button")
    protected WebElement btnConfirmar ;

    @FindBy(xpath = "//app-modal-detalle/tdp-st-modal/div[2]/div[2]//h1")
    protected WebElement detalleInstalacion;
    public String getDetalleInst() {return getText(detalleInstalacion);}

    @FindBy(xpath = "//app-modal-detalle/tdp-st-modal/div[2]/div[4]/button")
    protected WebElement btnConfirmarRegistro ;

    @FindBy(xpath = "//div[6]/div/div/button/span")
    protected WebElement btnValidarIdentidad ;

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div/div[2]/div[2]/button")
    protected WebElement btnHuellaDes ;

    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]//div[3]/app-modal-discapacitado//form/div/div[3]/button")
    protected WebElement btnConfirmaSuper ;

    public void clickBotonLineaNueva(){
        js().scrollElementTop(btnLineaNueva);
        waitUntilElementIsVisible(btnLineaNueva,15);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(1);

    }
    public void clickBotonConsultarCobertura(){
        waitUntilElementIsVisible(btnConsultaCobertura,10);
        click(btnConsultaCobertura);

    }
    public void clickBotonIrMovistarTotal(){
        waitUntilElementIsVisible(btnIrMovistarTotal,30);
        click(btnIrMovistarTotal);
    }
    public void clickBotonIniciarRegistro(){
        click(btnIniciarRegistro);
    }
    public void ingresoTelefonoContacto(String numContacto){
        WebElement numeroContac= find().getElementByCss("div:nth-child(1) > div:nth-child(1) > tdp-st-input-text");
        click(numeroContac);
        type(numeroContac, numContacto);
    }
    public void clickBotonConfirmar(){
        click(btnConfirmar);
    }
    public void validoDetalleDeInstalacion(){
        Assert.assertEquals("El resultado obtenido no coincide con lo esperado", "Detalles de instalación", getDetalleInst());
    }
    public void clickBtnConfirmarElRegistro(){
        click(btnConfirmarRegistro);
    }
    public void ingresoCorreoElectronico(String correoElectronico){
        WebElement ingresoCorreo= find().getElementByCss("div:nth-child(02) > div > div > div > tdp-st-input-text");
        click(ingresoCorreo);
        type(ingresoCorreo,correoElectronico);
    }
    public void vuelveIngresarCorreoElectronico(String vuelveIngresarCorreo){
        WebElement vuelveIngresarC= find().getElementByCss("div:nth-child(3) > div > div > div > tdp-st-input-text");
        click(vuelveIngresarC);
        type(vuelveIngresarC,vuelveIngresarCorreo);
    }
    public void clickBotonValidarIdentidad(){
        click(btnValidarIdentidad);
    }
    public void clickDiscapacitadoHuellaDesgastado(){
        click(btnHuellaDes);
    }
    public void seleccionoTipoDocumentoSupervisor(String tipoDoc){
        WebElement distritoList= find().getElementByXPath(" //*[@id=\"modal\"]/div[2]/div/div[3]/app-modal-discapacitado//div[3]//mat-form-field");
        click(distritoList);
        SearchContext context=sh().getContext(distritoList);
        context.findElement(By.cssSelector("[id='"+tipoDoc+"']")).click();
    }
    public void ingresoNumeroDocumentoSuper(String documentoSuper){
        WebElement numeroDocument= find().getElementByCss("#doc");
        click(numeroDocument);
        type(numeroDocument,documentoSuper);
    }
    public void presionoBotonConfirmar(){
       click(btnConfirmaSuper);
    }
    public void ingresoUsuarioSupervisor(String user){
        WebElement usuario= find().getElementByCss("#usuarioCitrixSupervisor");
        click(usuario);
        type(usuario,user);
    }
    public void ingresoContraseñaSupervisor(String passw){
        WebElement contraseña= find().getElementByCss("#passwordCitrixSupervisor");
        click(contraseña);
        type(contraseña,passw);
    }

}
