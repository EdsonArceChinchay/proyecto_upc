package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.*;

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

    // MENSAJE DE BIENVENIDA
    @FindBy(css = ".message-welcome span")
    protected WebElement msgHome;

    // REINTENTAR LOGIN
    @FindBy(xpath = "//*[//*[contains(normalize-space(text()), 'Iniciar sesion')] and contains(@type, 'button')]")
    protected WebElement btnIniciarSesion;
    @FindBy(xpath = "//*[contains(normalize-space(text()), 'presione regresar') and contains(@class, 'descrip')]")
    protected WebElement errorIniciarSesion;
    @FindBy(xpath = "//*[contains(@class, 'validate')]/*[contains(normalize-space(text()), 'Regresar')]")
    protected WebElement btnRegresarAIniciarSesion;
    @FindBy(xpath = "//*[contains(@class, 'attr')]/*[contains(normalize-space(text()), 'usuario')]")
    protected WebElement titlesIniciarSesion;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

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
        click(btnContinue,5);
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

    /**
     * FUNCION VISUALIZAR MENSAJE DE BIENVENIDA
     * */

    public void validateHomeMessage(String msg, String tipoUsuario, String userName, String passwordUser) {
        int maxAttempts = 3; // Número máximo de intentos
        int attempt = 0;
        boolean isMatched = false;

        while (attempt < maxAttempts && !isMatched) {
            try {
                // Verificar si existe un modal de error y cerrarlo
                Addons.revisarModalError(driver());

                // Intentar encontrar el mensaje de bienvenida
                WebElement message = explicitWaitCss(driver(), 30, ".message-welcome span");
                compareWebElementTextAndString(message, msg);

                // Verificar mensaje adicional, si aplica
                esperaProgresiva(driver(), 5, 2, msgHome);
                compareWebElementTextAndString(msgHome, msg);

                // Si no lanza excepción, el texto coincide
                isMatched = true;
            } catch (AssertionError e) {
                // El texto no coincide
                logInfo("El texto no coincide. Se refrescará la página, intento Nro: " + (attempt + 1));
            } catch (TimeoutException e) {
                // El elemento no fue encontrado dentro del tiempo de espera
                logInfo("No se encontró el elemento esperado. Se refrescará la página, intento Nro: " + (attempt + 1));
            } catch (Exception e) {
                // Otros errores inesperados
                throw new RuntimeException("Error inesperado durante la validación de la página de bienvenida: ", e);
            }

            if (!isMatched) {
                attempt++;
                if (attempt < maxAttempts) {
                    // Regresar a la página y reintentar
                    reintentarLogin(tipoUsuario, userName, passwordUser);
                    logInfo("Página refrescada. Reintentando...");
                } else {
                    // Agotar intentos
                    throw new RuntimeException("Se alcanzó el máximo de intentos. El texto no coincide.");
                }
            }
        }
        view.homePage().Zoom(65);
        miScenario.printFullView();
    }

    /**
     * FUNCION REINTENTAR LOGIN
     * */

    public void reintentarLogin(String tipoUsuario, String userName, String passwordUser) {
        logInfo("Ingreso a reintentar Login");
        click(btnIniciarSesion,5);
        waitUntilElementIsVisible(errorIniciarSesion,15);
        logInfo("Se visualiza el error de Iniciar Sesion");
        click(btnRegresarAIniciarSesion,5);
        waitUntilElementIsVisible(titlesIniciarSesion,15);
        logInfo("Se visualiza el formulario de Inicio de Sesion");
        selectUserType(tipoUsuario);
        typeUserName(userName);
        typePassword(passwordUser);
        view.captchaPage().getCaptcha();
        clickOnContinueButton();
    }
}
