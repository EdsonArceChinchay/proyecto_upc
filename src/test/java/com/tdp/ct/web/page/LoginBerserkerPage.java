package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

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

    public String getMsgError() {
        return msgError.getText().trim().toLowerCase();
    }

    @FindBy(id = "claimVerificationServerError")
    protected WebElement msgErrorCredential;

    @FindBy(xpath = "//img[@src='assets/images/login-icono.svg']")
    protected WebElement iconAsesor;

    @FindBy(xpath = "(//*[contains(text(),'Cerrar s')])[1]")
    protected WebElement btnCerrar;

    @FindBy(xpath = "//*[@class='atras']")
    protected WebElement btnAtras;

    public String getMsgErrorCredential() {
        return msgErrorCredential.getText().trim().toLowerCase();
    }

    public void clickBtnIniciarSesion() {
        waitUntilElementIsVisible(btnIniciarSesion, 10);
        click(btnIniciarSesion);
        waitUntilElementIsVisible(tipoUsuario, 10);
    }

    public void selectTipoUsuario(String usuario) {
        Select usuarioSelect = new Select(tipoUsuario);
        usuarioSelect.selectByVisibleText(usuario);
        UtilWeb.waitForSeconds(1);
    }

    public void writeUserName(String name) {
        type(inputNameUsuario, name);
        UtilWeb.waitForSeconds(1);
    }

    public void writePassword(String pass) {
        type(inputPassword, pass);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnContinuarHaciaHome() {
/*        UtilWeb.waitForSeconds(8);//5
        click(btnContinuar);
        waitUntilElementIsVisible(msgHome, 100);*/
        esperaProgresiva(6,5,btnContinuar);
        click(btnContinuar);
        esperaProgresiva(10,10,msgHome);
    }

    public void clickBtnContinuar() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgError, 30);
    }

    public void clickBtnContinuarToLogin() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgErrorCredential, 30);
    }

    public void validarMsgHome(String msg) {
        String expectedMsg = msg.trim().toLowerCase();
        String actualMsg = msgHome.getText().trim().toLowerCase();
        Assertions.assertTrue(actualMsg.contains(expectedMsg), "El mensaje obtenido: " + actualMsg + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarTiendaAsesor(String tienda) {
        String expectedTienda = tienda.trim().toLowerCase();
        String actualTienda = tiendaLabel.getText().trim().toLowerCase();
        Assertions.assertTrue(actualTienda.contains(expectedTienda), "La tienda obtenida: " + actualTienda + ", no coincide con lo esperado " + expectedTienda);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMensajeError(String msgError) {
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgError().contains(expectedMsg), "El mensaje obtenido: " + getMsgError() + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMsgIncorrectCredential(String msgError) {
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgErrorCredential().contains(expectedMsg), "El mensaje obtenido: " + getMsgErrorCredential() + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void clickIconoAsesor() {
        waitUntilElementIsVisible(iconAsesor, 10).click();

    }

    public void clickBtnCerrarSesion() {
        waitUntilElementIsVisible(btnCerrar, 10).click();
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnAtras() {
        waitUntilElementIsVisible(btnAtras, 10).click();
    }


}
