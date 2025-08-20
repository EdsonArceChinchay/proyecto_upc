package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        int maxAttempts = 3;
        int attempt = 0;
        boolean isMatched = false;

        while (attempt <= maxAttempts && !isMatched) {
            attempt++;
            try {
                logInfo("Ingreso a revisar el Modal de Error del Mensaje de Bienvenida");
                Addons.revisarModalError(driver());

                logInfo("Ingreso a la Funcion de Barra Cargando");
                view.temporalPage().barraCargando();

                logInfo("Ingreso a la funcion de ExplicitWait");

                // Obtener todos los mensajes visibles
                List<WebElement> messages = driver().findElements(By.cssSelector(".message-welcome span"));
                logInfo("Cantidad de mensajes encontrados: " + messages.size());

                for (WebElement message : messages) {
                    String text = message.getText().trim();
                    logInfo("Texto encontrado: " + text);
                    if (text.contains(msg)) {
                        isMatched = true;
                        break;
                    }
                }

                // También validar msgHome si aplica
                if (!isMatched && msgHome != null) {
                    String msgHomeText = msgHome.getText().trim();
                    logInfo("Texto en msgHome: " + msgHomeText);
                    if (msgHomeText.contains(msg)) {
                        isMatched = true;
                    }
                }

            } catch (Exception e) {
                logInfo("Error durante la validación del mensaje. Intento Nro: " + attempt + " - " + e.getMessage());
            }

            if (!isMatched) {
                if (attempt < maxAttempts) {
                    if (!tipoUsuario.equalsIgnoreCase("Tienda")) {
                        logInfo("Se procede a Reintentar el Login... - Reintento N°" + attempt);
                        reintentarLogin(tipoUsuario, userName, passwordUser);
                    } else {
                        logInfo("Rol Tienda detectado. No se realiza reintento.");
                        break;
                    }
                } else {
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
