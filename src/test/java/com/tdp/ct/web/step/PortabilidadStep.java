package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
