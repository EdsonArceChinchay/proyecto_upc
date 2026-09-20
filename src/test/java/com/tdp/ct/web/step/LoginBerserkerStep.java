package com.tdp.ct.web.step;

import com.tdp.ct.web.builder.AgentBuilder;
import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginBerserkerStep {

    @Autowired
    private StepPages page;

    @Autowired
    protected AgentBuilder agentBuilder;

    @Autowired
    private Customer customer;

    @ScreenShotBefore
    public void clickOnLoginButton() {
        customer.setCustomerTest("Test Cliente");
        page.loginBerserkerPage().clickOnLoginButton();
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

    @ScreenShotAfter
    public void clickBtnContinueToHome() {
        page.loginBerserkerPage().clickOnContinueButton();
      //  retryCaptcha();
    }

    @ScreenShotBefore
    public void clickOnContinueButton() {
        page.loginBerserkerPage().clickOnContinueButton();
        retryCaptcha();
    }

    @ScreenShotAfter
    public void validateErrorMessage(String msg) {
        retryCaptcha();
        page.loginBerserkerPage().validateErrorMessage(msg);
    }

    @ScreenShotBefore
    public void validateIncorrectCredentialsMessage(String msg) {
        retryCaptcha();
        page.loginBerserkerPage().validateIncorrectCredentialsMessage(msg);
    }

    @ScreenShotAfter
    @ScreenShotBefore
    /**
     * Step legacy "ingreso el captcha": ahora resuelve Cloudflare Turnstile (checkbox).
     * El captcha clásico de imagen ya no aplica en login Azure B2C CERT.
     */
    public void resolveCloudflareTurnstile() {
        page.loginBerserkerPage().handleCloudflareTurnstileBeforeContinue();
    }

    /** @deprecated usar {@link #resolveCloudflareTurnstile()} — mantiene compatibilidad con glue. */
    public void getAndTypeCaptcha() {
        resolveCloudflareTurnstile();
    }

    @ScreenShotAfter
    public void retryCaptcha() {
        if (page.loginBerserkerPage().validateCaptchaErrorMessage()) {
            page.loginBerserkerPage().handleCloudflareTurnstileBeforeContinue();
            page.loginBerserkerPage().clickOnContinueButton();
        }
    }

    /**
     * FUNCION VISUALIZAR MENSAJE DE BIENVENIDA
     * */

    public void initializeAgent(Agent agent) {
        AgentBuilder.initializeAgent(agent);
        agentBuilder.modifyGroupAgent("B2C_FRONTEND_WEB_RETENCIONES", agent);
        agent.setRetention(AgentBuilder.isRetention());
    }

    public void validateHomeMessage(String msg, String tipoUsuario, String userName, String passwordUser) {
        page.loginBerserkerPage().validateHomeMessage(msg, tipoUsuario, userName, passwordUser);
    }

}
