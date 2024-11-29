package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.compareWebElementTextAndString;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

public class LoginBerserkerPage extends WebBase {

    @FindBy(css = "button[type='button']")
    protected WebElement btnLogIn;

    @FindBy(id = "procedencia_usuario")
    protected WebElement userType;

    @FindBy(id = "signInName")
    protected WebElement inputNameUser;

    @FindBy(id = "password")
    protected WebElement inputPassword;

    @FindBy(name = "btnpruebavalidate")
    protected WebElement btnContinue;

    @FindBy(css = ".error.itemLevel.show")
    protected WebElement msgError;

    @FindBy(id = "claimVerificationServerError")
    protected WebElement msgErrorCredential;

    @FindBy(css = "div[id*='erro-captcha']")
    protected WebElement labelCaptchaError;

    public void clickOnLoginButton() {
        Addons.reiniciaTimeout(driver());
        Addons.esperaProgresiva(driver(), 3, 5, btnLogIn);
        click(btnLogIn);
    }

    public void selectUserType(String user) {
        esperaProgresiva(driver(), 3, 5, userType);
        Select usuarioSelect = new Select(userType);
        String userType = Objects.requireNonNull(getValueConfig("config","credential.user.userType")).trim();
        usuarioSelect.selectByVisibleText(userType);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Select " + userType);
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
        js().scrollElementTop(btnContinue);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnContinue.getText());
        click(btnContinue);
        UtilWeb.waitForSeconds(5);
    }

    public void validateErrorMessage(String msg) {
        waitUntilElementIsVisible(msgError, 10);
        compareWebElementTextAndString(msgError, msg);
        UtilWeb.waitForSeconds(1);
    }

    public void validateIncorrectCredentialsMessage(String msg) {
        waitUntilElementIsVisible(msgErrorCredential, 10);
        compareWebElementTextAndString(msgErrorCredential, msg);
        UtilWeb.waitForSeconds(1);
    }

    public boolean validateCaptchaErrorMessage() {
        try {
            return waitUntilElementIsVisible(labelCaptchaError, 10).isDisplayed();
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR! - " + e.getMessage());
            return false;
        }
    }

    public String readValues(String key) {
        return getValueConfig("config","credential.user." + key) == null ? "" : getValueConfig("config","credential.user." + key);
    }

}
