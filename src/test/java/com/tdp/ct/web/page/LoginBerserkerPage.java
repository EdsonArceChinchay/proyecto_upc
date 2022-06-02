package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginBerserkerPage extends WebBase {

    @FindBy(css = ".welcome-container .content .title-desc button")
    protected WebElement btnIniciarSesion;

    @FindBy(id = "procedencia_usuario")
    protected WebElement tipoUsuario;

    @FindBy(id = "signInName")
    protected WebElement inputNameUsuario;

    @FindBy(id = "password")
    protected WebElement inputPassword;

    @FindBy(id = "continue")
    protected WebElement btnContinuar;

    @FindBy(css = ".message-welcome span")
    protected WebElement msgHome;

    @FindBy(css = ".tienda-row span")
    protected WebElement tiendaLabel;

    @FindBy(css = ".error.itemLevel.show")
    protected WebElement msgError;
    public String getMsgError(){ return msgError.getText().trim().toLowerCase(); }

    @FindBy(id = "claimVerificationServerError")
    protected WebElement msgErrorCredential;
    public String getMsgErrorCredential(){ return msgErrorCredential.getText().trim().toLowerCase(); }

    public void clickBtnIniciarSesion(){
        waitUntilElementIsVisible(btnIniciarSesion, 8);
        click(btnIniciarSesion);
        waitUntilElementIsVisible(tipoUsuario, 10);
    }

    public void selectTipoUsuario(String usuario){
        Select usuarioSelect = new Select(tipoUsuario);
        usuarioSelect.selectByVisibleText(usuario);
        UtilWeb.waitForSeconds(1);
    }

    public void writeUserName(String name){
        type(inputNameUsuario, name);
        UtilWeb.waitForSeconds(1);
    }

    public void writePassword(String pass){
        type(inputPassword, pass);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnContinuarHaciaHome(){
        click(btnContinuar);
        waitUntilElementIsVisible(msgHome, 15);
    }

    public void clickBtnContinuar(){
        click(btnContinuar);
        waitUntilElementIsVisible(msgError, 13);
    }

    public void clickBtnContinuarToLogin(){
        click(btnContinuar);
        waitUntilElementIsVisible(msgErrorCredential, 13);
    }

    public void validarMsgHome(String msg){
        String expectedMsg = msg.trim().toLowerCase();
        String actualMsg = msgHome.getText().trim().toLowerCase();
        Assertions.assertTrue(actualMsg.contains(expectedMsg), "El mensaje obtenido: "+ actualMsg +", no coincide con lo esperado "+expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarTiendaAsesor(String tienda){
        String expectedTienda = tienda.trim().toLowerCase();
        String actualTienda = tiendaLabel.getText().trim().toLowerCase();
        Assertions.assertTrue(actualTienda.contains(expectedTienda), "La tienda obtenida: "+ actualTienda +", no coincide con lo esperado "+expectedTienda);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMensajeError(String msgError){
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgError().contains(expectedMsg), "El mensaje obtenido: "+ getMsgError() +", no coincide con lo esperado "+expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMsgIncorrectCredential(String msgError){
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgErrorCredential().contains(expectedMsg), "El mensaje obtenido: "+ getMsgErrorCredential() +", no coincide con lo esperado "+expectedMsg);
        UtilWeb.waitForSeconds(1);
    }
}
