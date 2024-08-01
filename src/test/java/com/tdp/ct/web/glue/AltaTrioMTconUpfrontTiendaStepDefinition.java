package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaTrioMTconUpfrontTiendaStepDefinition {

    @Autowired
    private AltaTrioMTconUpfrontTiendaStep altaTrioMTconUpfrontTiendaStep;

    @Autowired
    private Customer customer;

    @Y("doy click en el boton linea nueva")
    public void doyClickEnElBotonLineaNueva() {
        altaTrioMTconUpfrontTiendaStep.clickBotonLineaNueva();
    }

    @Y("doy click en el boton Ir a movistar total")
    public void doyClickEnElBotonIrAMovistarTotal() {
        altaTrioMTconUpfrontTiendaStep.clickBotonIrMovistarTotal();
    }


    @Y("voy hasta el final de la pagina")
    public void voyHastaElFinalDeLaPagina() {
        altaTrioMTconUpfrontTiendaStep.scrollFinalPagina();
    }

    @Y("selecciono el nombre de plan movistar total")
    public void seleccionoElNombreDePlanMovistarTotal() {
        altaTrioMTconUpfrontTiendaStep.seleccionoElNombreDePlanMovistarTotal();
    }

    @Cuando("valido si el usuario aplica para upfront")
    public void valido_si_el_usuario_aplica_para_upfront() {
        altaTrioMTconUpfrontTiendaStep.clickSubDetalles();
        altaTrioMTconUpfrontTiendaStep.validarlblAplicaUpFrom();
    }

    @Y("cierro popup de error")
    public void cierroPopupDeError() {
        altaTrioMTconUpfrontTiendaStep.clickCierrePopup();
    }
}
