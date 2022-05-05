package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaMovilRegistroStep {

    @Autowired
    private StepPages page;


    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue(page.altaFijaMovilRegistroPage().validarQueExistanOfertasSugeridas());
    }

    public void seleccionarOferta(String oferta) {

        page.altaFijaMovilRegistroPage().seleccionarOferta(oferta);
    }

    public void seleccionarPlan(String plan) {
        page.altaFijaMovilRegistroPage().seleccionarPlan();
    }

    public void validarDetalleSeleccion() {
        page.altaFijaMovilRegistroPage().validarDetalleSeleccion();
    }

    public void clicIniciarRegistro() {
        page.altaFijaMovilRegistroPage().clicIniciarRegistro();
    }
}
