package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginBerserkerStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickBtnIniciarSesion() {
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

}
