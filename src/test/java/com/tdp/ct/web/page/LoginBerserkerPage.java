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

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div")
    protected WebElement txtNombre;

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div/div[2]")
    protected WebElement txtDocumento;

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div")
    protected WebElement txtNombreRuc;

    @FindBy(xpath = "//*[contains(@class,'info-user')]/div/div[2]")
    protected WebElement txtDocumentoRuc;

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnconsultar;

    public String getMsgErrorCredential() {
        return msgErrorCredential.getText().trim().toLowerCase();
    }

    public void clickBtnIniciarSesion() {
        waitUntilElementIsVisible(btnIniciarSesion, 8);
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
        UtilWeb.waitForSeconds(5);
        click(btnContinuar);
        waitUntilElementIsVisible(msgHome, 15);
    }

    public void clickBtnContinuar() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgError, 13);
    }

    public void clickBtnContinuarToLogin() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgErrorCredential, 13);
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

    public void validarDatosCliente(String nombre, String tipoDocumento, String nroDocumento) {
        String expectedNombre = nombre.trim().toUpperCase();
        String expectedTipoDocumento = tipoDocumento.trim().toUpperCase();
        String expectedNroDocumento = nroDocumento.trim().toUpperCase();
        String Nombre = txtNombre.getText().trim().toUpperCase();
      //  System.out.println(tipoDocumento.toUpperCase().trim().equals("RUC"));
        Assertions.assertTrue(Nombre.contains(expectedNombre), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedNombre);
        Assertions.assertTrue(Nombre.contains(expectedTipoDocumento), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedTipoDocumento);
        Assertions.assertTrue(Nombre.contains(expectedNroDocumento), "El mensaje obtenido: " + Nombre + ", no coincide con lo esperado " + expectedNroDocumento);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoElIDDeClienteNro(String nro) {
        WebElement nroItem = find().getElementByXPath("//*[@class='table']/tbody/tr/td[" + nro.trim() + "]");
        waitUntilElementIsVisible(nroItem, 10).click();
        UtilWeb.waitForSeconds(1);
        WebElement btnGuardar = find().getElementByXPath("//*[contains(text(),'Guardar')]");
        waitUntilElementIsVisible(btnGuardar, 10).click();
    }

    public void clickBtnConsultar() {
        waitUntilElementIsVisible(btnconsultar, 10);
        click(btnconsultar);
    }


}
