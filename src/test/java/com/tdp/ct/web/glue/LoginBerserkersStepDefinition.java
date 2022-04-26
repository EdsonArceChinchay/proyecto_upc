package com.tdp.ct.web.glue;

import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.step.LoginBerserkerStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class LoginBerserkersStepDefinition {

    @Value("${url.movistar}")
    private String urlMovistar;

    @Autowired
    private LoginBerserkerStep loginBerserkerStep;

    @Autowired
    private WebDriverManager manager;

    @Dado("que abro la pagina de movistar")
    public void queAbroLaPaginaDeMovistar() throws InterruptedException {
        manager.navigateTo(urlMovistar);
        Thread.sleep(3000);
    }

    @Cuando("presiono el boton Iniciar Sesion")
    public void presionoElBotonIniciarSesion() {
        loginBerserkerStep.clickBtnIniciarSesion();
    }

    @Y("selecciono el tipo de usuario {string}")
    public void seleccionoElTipoDeUsuario(String user) {
        loginBerserkerStep.selectTipoUsuario(user);
    }

    @Y("ingreso el usuario {string}")
    public void ingresoElUsuario(String name) {
        loginBerserkerStep.writeUserName(name);
    }

    @Y("ingreso el password {string}")
    public void ingresoElPassword(String pass) {
        loginBerserkerStep.writePassword(pass);
    }

    @Y("presiono el boton Continuar hacia el home")
    public void presionoElBotonContinuarHaciaElHome() {
        loginBerserkerStep.clickBtnContinuarHaciaHome();
    }

    @Entonces("valido el login exitoso mediante el mensaje {string}")
    public void validoElLoginExitosoMedianteElMensaje(String msg) {
        loginBerserkerStep.validarMsgHome(msg);
    }

    @Y("valido que se presente la tienda {string}")
    public void validoQueSePresenteLaTienda(String tienda) {
        loginBerserkerStep.validarTiendaAsesor(tienda);
    }

    @Entonces("valido que se presente el mensaje de error {string}")
    public void validoQueSePresenteElMensajeDeError(String msg) {
        loginBerserkerStep.validarMensajeError(msg);
    }

    @Y("presiono el boton Continuar")
    public void presionoElBotonContinuar() {
        loginBerserkerStep.clickBtnContinuar();
    }

    @Entonces("valido que se presente el mensaje de credenciales incorrectas {string}")
    public void validoQueSePresenteElMensajeDeCredencialesIncorrectas(String msg) {
        loginBerserkerStep.validarMsgIncorrectCredential(msg);
    }

    @Y("presiono el boton Continuar para intentar el ingreso")
    public void presionoElBotonContinuarParaIntentarElIngreso() {
        loginBerserkerStep.clickBtnContinuarToLogin();
    }
}
