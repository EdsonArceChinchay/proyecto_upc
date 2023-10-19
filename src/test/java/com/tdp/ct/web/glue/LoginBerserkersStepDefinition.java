package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.LoginBerserkerStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Objects;


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

    @Y("me logueo con las credenciales en la aplicacion")
    public void meLogueoConLasCredencialesEnLaAplicacion(DataTable credenciales) {
        String tipoUsuario = UtilWeb.getValueFromDataTable(credenciales, "tipoUsuario");
        String userName = UtilWeb.getValueFromDataTable(credenciales, "userName");
        String password = UtilWeb.getValueFromDataTable(credenciales, "password");
        loginBerserkerStep.clickBtnIniciarSesion();
        loginBerserkerStep.selectTipoUsuario(tipoUsuario);
        loginBerserkerStep.writeUserName(userName);
        loginBerserkerStep.writePassword(password);
        loginBerserkerStep.clickBtnContinuarHaciaHome();
    }

    @Y("doy click en el icono de Asesor")
    public void doyClickEnElIconoDeAsesor() {
        loginBerserkerStep.doyClickEnElIconoDeAsesor();
    }

    @Y("doy click en Cerrar Sesion")
    public void doyClickEnCerrarSesion() {
        loginBerserkerStep.doyClickEnCerrarSesion();
    }

    @Y("doy click en Atras")
    public void doyClickEnAtras() {
        loginBerserkerStep.doyClickEnAtras();
    }

    @Y("confirmo Cerrar Sesion")
    public void confirmoCerrarSesion() {
        loginBerserkerStep.confirmoCerrarSesion();
    }

    @Entonces("valido en la etapa resumen el nombre del plan escogido {string}")
    public void validoEnLaEtapaResumenElNombreDelPlanEscogido(String nomPlan) {
        loginBerserkerStep.validarNomPlan(nomPlan);
    }

    @Y("valido la velocidad de internet {string}")
    public void validoLaVelocidadDeInternet(String mbpsBB) {
        loginBerserkerStep.scrollDown();
        loginBerserkerStep.validarVelocidadInternet(mbpsBB);
    }

    @Y("valido el precio de descuento del componente Internet {string}")
    public void validoElPrecioDeDescuentoDelComponenteInternet(String precDesc) {
        loginBerserkerStep.validarPrecioDescuento(precDesc);
    }

    @Y("valido el nombre del SVA de contenido externo {string}")
    public void validoElNombreDelSVADeContenidoExterno(String nomsvaTV) {
        loginBerserkerStep.validarnombreSVAcontenido(nomsvaTV);
    }

    @Y("valido el precio de descuento del componente TV {string}")
    public void validoElPrecioDeDescuentoDelComponenteTV(String pDescTV) {
        loginBerserkerStep.validarPrecioDescuentoTV(pDescTV);
    }


    @E("ingreso el captcha")
    public void ingresoElCaptcha() throws IOException, InterruptedException {
        loginBerserkerStep.ingresoCaptcha();
    }
}
