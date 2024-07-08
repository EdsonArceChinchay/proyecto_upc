package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginBerserkerStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Customer customer;

    @ScreenShotBefore
    public void clickButtonLogin() {
        customer.setCustomerTest("Test Cliente");
        page.loginBerserkerPage().clickButtonLogin();
    }

    @ScreenShotAfter
    public void selectUserType(String user) {
        page.loginBerserkerPage().selectUserType(user);
    }

    @ScreenShotAfter
    public void typeUserName(String name) {
        page.loginBerserkerPage().typeUserName(name);
    }

    @ScreenShotAfter
    public void typePassword(String pass) {
        page.loginBerserkerPage().typePassword(pass);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickBtnContinuarHaciaHome() {
        page.loginBerserkerPage().clickBtnContinuarHaciaHome();
    }

    @ScreenShotBefore
    public void clickButtonContinue() {
        page.loginBerserkerPage().clickButtonContinue();
    }

    @ScreenShotBefore
    public void clickBtnContinuarToLogin() {
        page.loginBerserkerPage().clickBtnContinuarToLogin();
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
    @ScreenShotBefore
    public void typeCaptcha() throws InterruptedException {
        UtilWeb.waitForSeconds(4);
        page.captchaPage().getCaptcha();
    }

}
