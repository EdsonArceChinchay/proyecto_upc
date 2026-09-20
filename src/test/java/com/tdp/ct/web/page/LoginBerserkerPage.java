package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import com.tdp.ct.web.utils.CloudflareTurnstileHelper;
import com.tdp.ct.web.utils.LoginConfigUtil;
import com.tdp.ct.web.utils.SelfHealingLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
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
    /** Botón Continuar Azure B2C (login CERT integratel). */
    private static final By BTN_CONTINUE_B2C = By.id("continue");
    private static final By CF_TURNSTILE = By.id("cf-turnstile");
    private static final By CF_TURNSTILE_WRAPPER = By.cssSelector(".turnstile-wrapper");
    private static final By CF_TURNSTILE_IFRAME = By.cssSelector(
            "iframe[src*='challenges.cloudflare.com'], iframe[id^='cf-chl-widget']");
    private static final By INPUT_TURNSTILE_RESPONSE = By.cssSelector(
            "input[name='cf-turnstile-response'], textarea[name='cf-turnstile-response']");
    private static final By LBL_TURNSTILE_SUCCESS = By.xpath(
            "//*[contains(normalize-space(),'Operación exitosa') or contains(normalize-space(),'exitosa!')]");
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
        Addons.esperaProgresiva(driver(), 5, 15, btnLogIn);

        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", btnLogIn);

        boolean isObstructed = (Boolean) js.executeScript(
                "var elem = arguments[0];" +
                        "var rect = elem.getBoundingClientRect();" +
                        "var x = rect.left + rect.width / 2;" +
                        "var y = rect.top + rect.height / 2;" +
                        "return document.elementFromPoint(x, y) !== elem;",
                btnLogIn
        );

        if (isObstructed) {
            js.executeScript("document.querySelector('.footer').style.display='none';");
        }

        new Actions(driver()).moveToElement(btnLogIn).click().perform();

    }

    public void selectUserType(String user) {
        waitBeforeB2cFormInteraction();
        esperaProgresiva(driver(), 3, 5, userType);
        Select usuarioSelect = new Select(userType);
        String userTypeText = getValueConfig("config", "credential.user." + user).trim();
        usuarioSelect.selectByVisibleText(userTypeText);
        logInfo(String.format("Select %s", userTypeText));
        UtilWeb.waitForSeconds(1);
    }

    /**
     * Espera antes de llenar el login B2C (evita error de captcha si Turnstile aún carga).
     * Config: environment.login.b2c-wait-mode y b2c-form-sleep-seconds en config.properties.
     */
    private void waitBeforeB2cFormInteraction() {
        String mode = LoginConfigUtil.get("environment.login.b2c-wait-mode", "sleep");

        if ("sleep".equalsIgnoreCase(mode)) {
            int seconds = LoginConfigUtil.getInt("environment.login.b2c-form-sleep-seconds", 5);
            logInfo("[B2C] Modo sleep — espera fija de " + seconds + "s");
            UtilWeb.waitForSeconds(seconds);
            return;
        }

        int timeoutSeconds = LoginConfigUtil.getInt("environment.login.b2c-form-wait-seconds", 15);
        logInfo("[B2C] Modo turnstile-ready — esperando formulario (máx. " + timeoutSeconds + "s)");

        try {
            waitUntilElementIsVisible(userType, timeoutSeconds);
            waitUntilElementIsVisible(inputNameUser, timeoutSeconds);
        } catch (Exception e) {
            logInfo("[B2C] Formulario B2C no listo a tiempo: " + e.getMessage());
        }

        if (!CloudflareTurnstileHelper.waitUntilWidgetReady(driver(), timeoutSeconds)) {
            int fallbackSeconds = LoginConfigUtil.getInt("environment.login.b2c-form-sleep-seconds", 5);
            logInfo("[B2C] Turnstile no listo; fallback sleep " + fallbackSeconds + "s");
            UtilWeb.waitForSeconds(fallbackSeconds);
        }
    }

    public void typeUserName(String name) {
        WebElement userField = SelfHealingLocator.resolve(
                driver(), By.id("signInName"), "Usuario (login)", SelfHealingLocator.FieldRole.USERNAME);
        validateAndType("user name", userField, readValues(name));
        UtilWeb.waitForSeconds(1);
    }

    public void typePassword(String pass) {
        WebElement passwordField = SelfHealingLocator.resolve(
                driver(), By.id("password"), "Contraseña (login)", SelfHealingLocator.FieldRole.PASSWORD);
        validateAndType("password", passwordField, readValues(pass));
        UtilWeb.waitForSeconds(1);
    }

    public void clickOnContinueButton() {
        int timeoutSeconds = LoginConfigUtil.getInt("environment.login.turnstile.wait-seconds", 15);
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(timeoutSeconds));
        WebElement button = wait.until(d -> {
            WebElement continueButton = findContinueButton();
            return continueButton != null && isContinueButtonEnabled(continueButton) ? continueButton : null;
        });

        UtilWeb.waitForSeconds(1);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", button);
        UtilWeb.waitForSeconds(1);

        logInfo("Click button Continuar");
        try {
            button.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", button);
        }
    }

    /**
     * Resuelve Cloudflare Turnstile después de usuario/contraseña y antes de Continuar.
     */
    public void handleCloudflareTurnstileBeforeContinue() {
        if (!isTurnstilePresent()) {
            logInfo("Cloudflare Turnstile no detectado en login");
            return;
        }

        int timeoutSeconds = LoginConfigUtil.getInt("environment.login.turnstile.wait-seconds", 15);
        logInfo("Cloudflare Turnstile detectado; esperando validación (" + timeoutSeconds + "s)");

        if (waitForTurnstileResolved(5)) {
            logInfo("Turnstile validado automáticamente");
            return;
        }

        for (int attempt = 1; attempt <= 3; attempt++) {
            if (waitForTurnstileResolved(2)) {
                logInfo("Turnstile validado antes del intento " + attempt);
                UtilWeb.waitForSeconds(1);
                return;
            }

            logInfo("Intento " + attempt + " de interacción con Turnstile");

            if (!CloudflareTurnstileHelper.tryClickCheckbox(driver(), attempt)) {
                logInfo("No se pudo enviar clic al checkbox Turnstile en intento " + attempt);
            }

            if (waitForTurnstileResolved(6)) {
                logInfo("Turnstile validado correctamente en intento " + attempt);
                UtilWeb.waitForSeconds(1);
                return;
            }
        }

        if (!waitForTurnstileResolved(timeoutSeconds)) {
            throw new RuntimeException("Cloudflare Turnstile no se validó en " + timeoutSeconds + " segundos");
        }

        logInfo("Turnstile validado correctamente");
        UtilWeb.waitForSeconds(2);
    }

    private boolean isTurnstilePresent() {
        return !driver().findElements(CF_TURNSTILE).isEmpty()
                || !driver().findElements(CF_TURNSTILE_WRAPPER).isEmpty()
                || !driver().findElements(CF_TURNSTILE_IFRAME).isEmpty();
    }

    private boolean waitForTurnstileResolved(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(timeoutSeconds));
        try {
            return wait.until(d -> isTurnstileResolved());
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean isTurnstileResolved() {
        if (hasTurnstileToken()) {
            return true;
        }

        WebElement button = findContinueButton();
        if (button != null && isContinueButtonEnabled(button)) {
            return true;
        }

        try {
            for (WebElement label : driver().findElements(LBL_TURNSTILE_SUCCESS)) {
                if (label.isDisplayed()) {
                    return true;
                }
            }
        } catch (Exception ignored) {
            // continuar
        }

        try {
            String bodyText = driver().findElement(By.tagName("body")).getText();
            return bodyText.contains("Operación exitosa") || bodyText.contains("exitosa!");
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean hasTurnstileToken() {
        try {
            for (WebElement input : driver().findElements(INPUT_TURNSTILE_RESPONSE)) {
                String value = input.getAttribute("value");
                if (value != null && !value.isBlank()) {
                    return true;
                }
            }
        } catch (Exception ignored) {
            // continuar
        }
        return false;
    }

    private WebElement findContinueButton() {
        for (By locator : Arrays.asList(
                BTN_CONTINUE_B2C,
                By.name("btnpruebavalidate"),
                By.xpath("//button[contains(normalize-space(),'Continuar') or @aria-label='Continuar']")
        )) {
            try {
                for (WebElement button : driver().findElements(locator)) {
                    if (button.isDisplayed()) {
                        return button;
                    }
                }
            } catch (Exception ignored) {
                // probar siguiente locator
            }
        }
        return btnContinue != null && btnContinue.isDisplayed() ? btnContinue : null;
    }

    private boolean isContinueButtonEnabled(WebElement button) {
        if (button == null || !button.isDisplayed()) {
            return false;
        }

        String disabled = button.getAttribute("disabled");
        String ariaDisabled = button.getAttribute("aria-disabled");
        if ("true".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(ariaDisabled)) {
            return false;
        }

        String style = button.getAttribute("style");
        if (style != null) {
            String normalized = style.replace(" ", "").toLowerCase();
            if (normalized.contains("pointer-events:none") || normalized.contains("opacity:0")) {
                return false;
            }
        }

        return button.isEnabled();
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
         *
         */

        public void validateHomeMessage(String msg, String tipoUsuario, String userName, String passwordUser) {

            int maxAttempts = 5;
            int attempt = 0;
            boolean isMatched = false;

            while (attempt < maxAttempts && !isMatched) {
                attempt++;
                try {
                    logInfo("Intento #" + attempt + " - Revisando el Modal de Error del Mensaje de Bienvenida");
                    Addons.revisarModalError(driver());

                    logInfo("Verificando barra de carga...");
                    view.temporalPage().barraCargando();

                    logInfo("Buscando mensajes visibles...");
                    List<WebElement> messages = driver().findElements(By.cssSelector(".message-welcome span"));
                    logInfo("Cantidad de mensajes encontrados: " + messages.size());

                    for (WebElement message : messages) {
                        if (message.isDisplayed()) {
                            String text = message.getText().trim();
                            logInfo("Texto encontrado: '" + text + "' vs esperado: '" + msg + "'");
                            if (text.toLowerCase().contains(msg.toLowerCase())) {
                                isMatched = true;
                                break;
                            }
                        }
                    }

                    // Validación adicional con msgHome si aplica
                    if (!isMatched && msgHome != null && msgHome.isDisplayed()) {
                        String msgHomeText = msgHome.getText().trim();
                        logInfo("Texto en msgHome: '" + msgHomeText + "'");
                        if (msgHomeText.toLowerCase().contains(msg.toLowerCase())) {
                            isMatched = true;
                        }
                    }

                } catch (Exception e) {
                    logInfo("Error durante la validación del mensaje. Intento #" + attempt + " - " + e.getMessage());
                }

                if (!isMatched) {
                    if (attempt < maxAttempts) {
                        if (!tipoUsuario.equalsIgnoreCase("Tienda")) {
                            logInfo("Reintentando login para usuario tipo '" + tipoUsuario + "' - Reintento #" + attempt);
                            reintentarLogin(tipoUsuario, userName, passwordUser);
                            try {
                                Thread.sleep(3000); // Espera de 3 segundos antes del siguiente intento
                            } catch (InterruptedException ie) {
                                logInfo("Interrupción durante la espera: " + ie.getMessage());
                            }
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
     *
     */

    public void reintentarLogin(String tipoUsuario, String userName, String passwordUser) {
        logInfo("Ingreso a reintentar Login");
        click(btnIniciarSesion, 15);
        waitUntilElementIsVisible(errorIniciarSesion, 15);
        logInfo("Se visualiza el error de Iniciar Sesion");
        click(btnRegresarAIniciarSesion, 5);
        waitUntilElementIsVisible(titlesIniciarSesion, 15);
        logInfo("Se visualiza el formulario de Inicio de Sesion");
        selectUserType(tipoUsuario);
        typeUserName(userName);
        typePassword(passwordUser);
        handleCloudflareTurnstileBeforeContinue();
        clickOnContinueButton();
    }
}
