package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.compareWebElementTextAndText;
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

    @FindBy(xpath = "//*[contains(@class,'error itemLevel show') or contains(@id,'erro-captcha') or contains(@id,'claimVerificationServerError')]")
    protected List<WebElement> labelsError;

    @FindBy(xpath = "//*[contains(@id,'erro-captcha')]")
    protected WebElement labelCaptchaError;

    public void clickOnLoginButton() {
        Addons.reiniciaTimeout(driver());
        Addons.esperaProgresiva(driver(), 3, 5, btnIniciarSesion);
        click(btnIniciarSesion);
    }

    public void selectUserType(String usuario) {
        esperaProgresiva(driver(), 3, 5, tipoUsuario);
        Select usuarioSelect = new Select(tipoUsuario);
        usuarioSelect.selectByVisibleText(usuario);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Select " + usuario);
        UtilWeb.waitForSeconds(1);
    }

    public void typeUserName(String name) {
        type(inputNameUser, readValues(name));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type user " + readValues(name));
        UtilWeb.waitForSeconds(1);
    }

    public void typePassword(String pass) {
        type(inputPassword, readValues(pass));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type password " + readValues(pass));
        UtilWeb.waitForSeconds(1);
    }

    public void clickOnContinueButton() {
        js().scrollElementTop(btnContinuar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnContinuar.getText());
        click(btnContinuar);
        UtilWeb.waitForSeconds(5);
    }

    public void validateErrorMessage(String msg) {
        waitUntilElementIsVisible(msgError, 10);
        compareWebElementTextAndText(msgError, msg);
        UtilWeb.waitForSeconds(1);
    }

    public void validateIncorrectCredentialsMessage(String msg) {
        waitUntilElementIsVisible(msgErrorCredential, 10);
        compareWebElementTextAndText(msgErrorCredential, msg);
        UtilWeb.waitForSeconds(1);
    }

    public boolean validateCaptchaErrorMessage() {
        try {
            return waitUntilElementIsVisible(labelCaptchaError, 10).isDisplayed();
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error " + e.getMessage());
            return false;
        }
    }

    public String readValues(String key) {
        return getValueConfig("credential.user." + key) == null ? "" : getValueConfig("credential.user." + key);
    }

}
