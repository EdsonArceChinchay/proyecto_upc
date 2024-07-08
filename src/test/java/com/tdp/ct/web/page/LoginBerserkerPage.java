package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.getValueConfig;

public class LoginBerserkerPage extends WebBase {

    @FindBy(xpath = "//button[text()='Iniciar sesion']")
    protected WebElement btnIniciarSesion;

    @FindBy(id = "procedencia_usuario")
    protected WebElement tipoUsuario;

    @FindBy(id = "signInName")
    protected WebElement inputNameUser;

    @FindBy(id = "password")
    protected WebElement inputPassword;

    @FindBy(name = "btnpruebavalidate")
    protected WebElement btnContinuar;

    @FindBy(css = ".error.itemLevel.show")
    protected WebElement msgError;

    @FindBy(id = "claimVerificationServerError")
    protected WebElement msgErrorCredential;

    public String getMsgError() {
        return msgError.getText().trim().toLowerCase();
    }

    public String getMsgErrorCredential() {
        return msgErrorCredential.getText().trim().toLowerCase();
    }

    public void clickButtonLogin() {
        Addons.reiniciaTimeout(driver());
        Addons.esperaProgresiva(driver(), 3, 5, btnIniciarSesion);
        click(btnIniciarSesion);
    }

    public void selectUserType(String usuario) {
        esperaProgresiva(driver(), 3, 5, tipoUsuario);
        Select usuarioSelect = new Select(tipoUsuario);
        usuarioSelect.selectByVisibleText(usuario);
        UtilWeb.waitForSeconds(1);
    }

    public void typeUserName(String name) {
        type(inputNameUser, readValues(name));
        UtilWeb.waitForSeconds(1);
    }

    public void typePassword(String pass) {
        type(inputPassword, readValues(pass));
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnContinuarHaciaHome() {
        esperaProgresiva(driver(), 3, 5, btnContinuar);
        js().scrollElementTop(btnContinuar);
        click(btnContinuar);
        UtilWeb.waitForSeconds(2);
    }

    public void clickButtonContinue() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgError, 30);
    }

    public void clickBtnContinuarToLogin() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgErrorCredential, 30);
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

    public String readValues(String key) {
        return getValueConfig("credential.user." + key) == null ? "" : getValueConfig("credential.user." + key);
    }

}
