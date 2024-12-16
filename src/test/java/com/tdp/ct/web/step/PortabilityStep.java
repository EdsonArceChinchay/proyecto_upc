package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortabilityStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickBotonPortabilidad() {
        page.portabilityPage().clickBotonPortabilidad();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void typePhoneNumber(String phoneNumber) {
        page.portabilityPage().typePhoneNumber(phoneNumber);
    }

    @ScreenShotAfter
    public void selectLineType(String plan) {
        page.portabilityPage().selectLineType(plan);
    }

    @ScreenShotAfter
    public void selectOperatorType(String operator) {
        page.portabilityPage().selectOperatorType(operator);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickBotonConsultar() {
        page.portabilityPage().clickBotonConsultar();
    }

    @ScreenShotBefore
    public void clickPortaMovil() {
        page.portabilityPage().clickPortaMovil();
    }

    public void setValuePortaDirecta() {
        page.portabilityPage().setValuePortaDirecta();
    }

    public String getValuePortaDirecta() {
        return page.portabilityPage().getValuePortaDirecta();
    }

    @ScreenShotAfter
    public void clickButtonCodigoDePorta() {
        page.portabilityPage().clickButtonCodigoDePorta();
    }

    public void selectButton(String name) {
        page.portabilityPage().selectButton(name);
    }

    @ScreenShotBefore
    public void clickButtonConfirm() {
        page.portabilityPage().clickButtonConfirmar();
    }

    @ScreenShotBefore
    public void clickButtonContinuar() {
        page.portabilityPage().clickButtonContinuar();
    }

    @ScreenShotAfter
    public void inputToken(String token) {
        page.portabilityPage().inputToken(token);
    }

    @ScreenShotAfter
    public void validateMessage(String message) {
        page.portabilityPage().validateMessage(message);
    }
}
