package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;


@Component
public class PortabilidadStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickBotonPortabilidad() {
        UtilWeb.waitForSeconds(20);
        page.portabilidadPage().clickBotonPortabilidad();

    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresarNumeroPortar(String numero) {
        page.portabilidadPage().ingresarNumeroPortar(numero);
    }

    @ScreenShotAfter
    public void escogerTipoLinea(String plan) {
        page.portabilidadPage().escogerTipoLinea(plan);
    }

    @ScreenShotAfter
    public void escogerTipoOperador(String operador) {
        page.portabilidadPage().esogerTipoOperador(operador);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickBotonConsultar() {
        page.portabilidadPage().clickBotonConsultar();
    }

    @ScreenShotBefore
    public void clickPortaMovil() {
        page.portabilidadPage().clickPortaMovil();
    }

    public void setValuePortaDirecta() throws JSONException {
        page.portabilidadPage().setValuePortaDirecta();
    }

    public String getValuePortaDirecta() throws JSONException {
        return page.portabilidadPage().getValuePortaDirecta();
    }

    @ScreenShotAfter
    public void clickButtonCodigoDePorta() {
        page.portabilidadPage().clickButtonCodigoDePorta();
    }

    public void selectButton(String name) {
        page.portabilidadPage().selectButton(name);
    }

    @ScreenShotBefore
    public void clickButtonConfirmar() {
        page.portabilidadPage().clickButtonConfirmar();
    }

    @ScreenShotBefore
    public void clickButtonContinuar() {
        page.portabilidadPage().clickButtonContinuar();
    }

    @ScreenShotAfter
    public void inputToken(String token) {
        page.portabilidadPage().inputToken(token);
    }

    @ScreenShotAfter
    public void validateMessage(String message) {
        page.portabilidadPage().validateMessage(message);
    }
}
