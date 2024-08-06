package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.OfferStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class OfferStepDefinition {

    @Autowired
    OfferStep offerStep;

    @Y("valido que este en la pagina de ofertas sugeridas")
    public void valido_que_este_en_la_pagina_de_ofertas_sugeridas() {
        offerStep.validarOfertasSugeridas();
    }

    @Entonces("me muestra la pantalla de ofertas sugeridos")
    public void meMuestraLaPantallaDeOfertasSugeridos() {
        offerStep.mostrarDetalleOfertasSugeridas();
    }

    @Entonces("valido que se presente la pantalla con el titulo {string}")
    public void validoSePresentePantallaConTitulo(String title) {
        offerStep.validarOfertasSugeridasView(title);
    }

    @Cuando("valido si el usuario aplica para upfront")
    public void valido_si_el_usuario_aplica_para_upfront() {
        offerStep.clickSubDetalles();
        offerStep.validarlblAplicaUpFrom();
    }
}
