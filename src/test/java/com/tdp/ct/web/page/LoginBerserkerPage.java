package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.compareWebElementTextAndString;
import static com.tdp.ct.web.utils.WebUtils.validateAndType;

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
        Addons.resetTimeOut(driver());
        Addons.esperaProgresiva(driver(), 3, 5, btnLogIn);
        click(btnLogIn);
    }

    public void selectUserType(String user) {
        esperaProgresiva(driver(), 3, 5, userType);
        Select usuarioSelect = new Select(userType);
        String userTypeText = getValueConfig("config", "credential.user." + user).trim();
        usuarioSelect.selectByVisibleText(userTypeText);
        logInfo(String.format("Select %s", userTypeText));
        UtilWeb.waitForSeconds(1);
    }

    public void typeUserName(String name) {
        validateAndType("user name", inputNameUser, readValues(name));
        UtilWeb.waitForSeconds(1);
    }

    public void typePassword(String pass) {
        validateAndType("password", inputPassword, readValues(pass));
        UtilWeb.waitForSeconds(1);
    }

    public void clickOnContinueButton() {
        js().scrollElementTop(btnContinue);
        logInfo("Click button", btnContinue.getText());
        click(btnContinue);
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
            logInfo("No captcha error");
            return false;
        }
    }

    public String readValues(String key) {
        return getValueConfig("config", "credential.user." + key);
    }


}
