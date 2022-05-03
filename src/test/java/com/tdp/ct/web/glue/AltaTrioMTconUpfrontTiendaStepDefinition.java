package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaTrioMTconUpfrontTiendaStepDefinition {

    @Autowired
    private AltaTrioMTconUpfrontTiendaStep altaTrioMTconUpfrontTiendaStep;


    @Y("doy click en el boton linea nueva")
    public void doyClickEnElBotonLineaNueva() {
        altaTrioMTconUpfrontTiendaStep.clickBotonLineaNueva();
    }

    @Y("doy click en el boton mostrar ofertas")
    public void doyClickEnElBotonMostrarOfertas() {
        altaTrioMTconUpfrontTiendaStep.clickBotonMostrarOfertas();
    }
}
