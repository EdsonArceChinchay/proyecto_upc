package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.LoginBerserkerStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

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
        System.out.println("Enviroment: " + env);
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
        loginBerserkerStep.clickButtonLogin();
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
        loginBerserkerStep.clickBtnContinuarHaciaHome();
    }

    @Entonces("valido que se presente el mensaje de error {string}")
    public void validoQueSePresenteElMensajeDeError(String msg) {
        loginBerserkerStep.validarMensajeError(msg);
    }

    @Y("presiono el boton Continuar")
    public void presionoElBotonContinuar() {
        loginBerserkerStep.clickButtonContinue();
    }

    @Entonces("valido que se presente el mensaje de credenciales incorrectas {string}")
    public void validoQueSePresenteElMensajeDeCredencialesIncorrectas(String msg) {
        loginBerserkerStep.validarMsgIncorrectCredential(msg);
    }

    @Y("presiono el boton Continuar para intentar el ingreso")
    public void presionoElBotonContinuarParaIntentarElIngreso() {
        loginBerserkerStep.clickBtnContinuarToLogin();
    }

    @Y("me logueo con las credenciales en la aplicacion")
    public void meLogueoConLasCredencialesEnLaAplicacion(DataTable credenciales) {
        String tipoUsuario = UtilWeb.getValueFromDataTable(credenciales, "tipoUsuario");
        String userName = UtilWeb.getValueFromDataTable(credenciales, "userName");
        String password = UtilWeb.getValueFromDataTable(credenciales, "password");
        loginBerserkerStep.clickButtonLogin();
        loginBerserkerStep.selectUserType(tipoUsuario);
        loginBerserkerStep.typeUserName(userName);
        loginBerserkerStep.typePassword(password);
        loginBerserkerStep.clickButtonContinue();
    }

    @E("ingreso el captcha")
    public void ingresoElCaptcha() throws InterruptedException {
        loginBerserkerStep.typeCaptcha();
    }
}
