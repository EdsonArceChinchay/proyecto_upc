package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginBerserkerStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Cliente cliente;

    @ScreenShotBefore
    public void clickBtnIniciarSesion() {
        cliente.setClienteTest("Test Cliente");
        page.loginBerserkerPage().clickBtnIniciarSesion();
    }

    @ScreenShotAfter
    public void selectTipoUsuario(String user) {
        page.loginBerserkerPage().selectTipoUsuario(user);
    }

    @ScreenShotAfter
    public void writeUserName(String name) {
        page.loginBerserkerPage().writeUserName(name);
    }

    @ScreenShotAfter
    public void writePassword(String pass) {
        page.loginBerserkerPage().writePassword(pass);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickBtnContinuarHaciaHome() {
        page.loginBerserkerPage().clickBtnContinuarHaciaHome();
    }

    @ScreenShotBefore
    public void clickBtnContinuar() {
        page.loginBerserkerPage().clickBtnContinuar();
    }

    @ScreenShotBefore
    public void clickBtnContinuarToLogin() {
        page.loginBerserkerPage().clickBtnContinuarToLogin();
    }

    @ScreenShotAfter
    public void validarMsgHome(String msg) {
        page.loginBerserkerPage().validarMsgHome(msg);
    }

    @ScreenShotAfter
    public void validarTiendaAsesor(String tienda) {
        page.loginBerserkerPage().validarTiendaAsesor(tienda);
    }

    @ScreenShotAfter
    public void validarMensajeError(String msg) {
        page.loginBerserkerPage().validarMensajeError(msg);
    }

    @ScreenShotBefore
    public void validarMsgIncorrectCredential(String msg) {
        page.loginBerserkerPage().validarMsgIncorrectCredential(msg);
    }

    @ScreenShotAfter
    public void doyClickEnElIconoDeAsesor() {
        page.loginBerserkerPage().clickIconoAsesor();
    }

    @ScreenShotAfter
    public void doyClickEnCerrarSesion() {
        page.loginBerserkerPage().clickBtnCerrarSesion();
    }

    @ScreenShotAfter
    public void doyClickEnAtras() {
        page.loginBerserkerPage().clickBtnAtras();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void confirmoCerrarSesion() {
        page.loginBerserkerPage().clickBtnCerrarSesion();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void ingresoCaptcha() throws IOException, InterruptedException {
        UtilWeb.waitForSeconds(4);
        page.captchaPage().getCaptcha();
    }

    public void validarNomPlan(String nomPlan) {
        page.loginBerserkerPage().validarNomPlan(nomPlan);
    }

    public void scrollDown() {
        page.altaFijaMovilRegistroPage().scrollDown();
    }

    public void validarVelocidadInternet(String mbpsBB) {
        page.loginBerserkerPage().validarVelocidadInternet(mbpsBB);
    }

    public void validarPrecioDescuento(String precDesc) {
        page.loginBerserkerPage().validarPrecioDescuento(precDesc);
    }

    public void validarnombreSVAcontenido(String nomsvaTV) {
        page.loginBerserkerPage().validarnombreSVAcontenido(nomsvaTV);
    }

    public void validarPrecioDescuentoTV(String pDescTV) {
        page.loginBerserkerPage().validarPrecioDescuentoTV(pDescTV);
    }

    public void regresarPaginaInicio() {
        page.loginBerserkerPage().regresarPaginaInicio();
    }
}
