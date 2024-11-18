package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void validarOfertasSugeridas() {
        page.offerPage().ofertasSugeridas();
    }

    @ScreenShotAfter
    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue("La pantalla de ofertas sugeridas no cargo correctamente!!!",
                page.offerPage().validarQueExistanOfertasSugeridas());
    }

    @ScreenShotAfter
    public void validarOfertasSugeridasView(String title) {
        page.offerPage().validarOfertasSugeridasView(title);
    }

    @ScreenShotBefore
    public void clickSubDetalles() {
        page.offerPage().subDetalles();
    }

    @ScreenShotBefore
    public void validarlblAplicaUpFrom() {
        page.offerPage().lblAplicaUpFrom();
    }
}
