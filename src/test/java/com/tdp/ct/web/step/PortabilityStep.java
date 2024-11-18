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
    public void ingresarNumeroPortar(String numero) {
        page.portabilityPage().ingresarNumeroPortar(numero);
    }

    @ScreenShotAfter
    public void escogerTipoLinea(String plan) {
        page.portabilityPage().escogerTipoLinea(plan);
    }

    @ScreenShotAfter
    public void escogerTipoOperador(String operador) {
        page.portabilityPage().esogerTipoOperador(operador);
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
