package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

public class AltaTrioMTconUpfrontTiendaPage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div/div[3]/div[1]/div/div")
    protected WebElement btnLineaNueva ;

    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement btnConsultaCobertura ;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;

    @FindBy(css = "button.btnStart")
    protected WebElement btnIniciarRegistro ;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmar ;

    @FindBy(xpath = "//app-modal-detalle//div/h1[contains(text(),'Detalles')]")
    protected WebElement detalleInstalacion;
    public String getDetalleInst() {return getText(detalleInstalacion);}

    @FindBy(xpath = "//app-modal-detalle//div/button")
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
        UtilWeb.waitForSeconds(3);
        System.out.println("click en consulta cobertura");
    }
    public void clickBotonIrMovistarTotal(){
        UtilWeb.waitForSeconds(10);
        waitUntilElementIsVisible(botoneraIrA.get(1), 15);
        waitUntilElementIsClickable(botoneraIrA.get(1),10);
        click(botoneraIrA.get(1));
        UtilWeb.waitForSeconds(1);
        //waitUntilElementIsVisible(btnIrMovistarTotal,30);
        //click(btnIrMovistarTotal);
    }
    public void clickBotonIniciarRegistro(){
        waitUntilElementIsVisible(btnIniciarRegistro,20);
        click(btnIniciarRegistro);
    }
    public void ingresoTelefonoContacto(String numContacto){
        UtilWeb.waitForSeconds(10);
        WebElement numeroContac= find().getElementByCss("div:nth-child(1) > div:nth-child(1) > tdp-st-input-text");
        click(numeroContac);
        type(numeroContac, numContacto);

    }
    public void clickBotonConfirmar(){
        js().scrollElementTop(btnConfirmar);
        UtilWeb.waitForSeconds(5);
      //  waitUntilElementIsVisible(btnConfirmar, 10);
        waitUntilElementIsClickable(btnConfirmar,10);
        click(btnConfirmar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a confirmar agendamiento");
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
