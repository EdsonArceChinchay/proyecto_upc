package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.step.LoginBerserkerStep;
import io.cucumber.java.es.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class LoginBerserkersStepDefinition {

    @Value("${url.prod.movistar}")
    private String urlprodMovistar;

    @Value("${url.dev.movistar}")
    private String urldevMovistar;

    @Value("${url.qa.movistar}")
    private String urlqaMovistar;

    @Autowired
    private LoginBerserkerStep loginBerserkerStep;

    @Autowired
    private WebDriverManager manager;

    @Dado("que abro la pagina de movistar")
    public void queAbroLaPaginaDeMovistar() throws InterruptedException {
        String env = System.getProperty("environment");
        logInfo( String.format("Environment: %s - SO: %s", env, System.getProperty("os.name")));
        String urlMovistar = urlqaMovistar;
        if (Objects.nonNull(env)) {
            if (env.compareTo("dev") == 0) {
                urlMovistar = urldevMovistar;
            } else if (env.compareTo("prod") == 0) {
                urlMovistar = urlprodMovistar;
            }
        }
        manager.navigateTo(urlMovistar);
        Thread.sleep(1000);
    }

    @Cuando("presiono el boton Iniciar Sesion")
    public void presionoElBotonIniciarSesion() {
        loginBerserkerStep.clickOnLoginButton();
    }

    @Y("selecciono el tipo de usuario {string}")
    public void seleccionoElTipoDeUsuario(String user) {
        loginBerserkerStep.selectUserType(user);
    }

    @Y("ingreso el usuario {string}")
    public void ingresoElUsuario(String name) {
        loginBerserkerStep.typeUserName(name);
    }

    @Y("ingreso el password {string}")
    public void ingresoElPassword(String pass) {
        loginBerserkerStep.typePassword(pass);
    }

    @Y("presiono el boton Continuar hacia el home")
    public void presionoElBotonContinuarHaciaElHome() {
        loginBerserkerStep.clickBtnContinueToHome();
    }

    @Entonces("valido que se presente el mensaje de error {string}")
    public void validoQueSePresenteElMensajeDeError(String msg) {
        loginBerserkerStep.validateErrorMessage(msg);
    }

    @Y("presiono el boton Continuar")
    public void presionoElBotonContinuar() {
        loginBerserkerStep.clickOnContinueButton();
    }

    @Entonces("valido que se presente el mensaje de credenciales incorrectas {string}")
    public void validoQueSePresenteElMensajeDeCredencialesIncorrectas(String msg) {
        loginBerserkerStep.validateIncorrectCredentialsMessage(msg);
    }

    @E("ingreso el captcha")
    public void ingresoElCaptcha() {
        loginBerserkerStep.getAndTypeCaptcha();
    }

}
