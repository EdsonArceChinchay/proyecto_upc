package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.SvaBloqueHboaDuoPorTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class SvaBloqueHboaDuoPorTiendaStepDefinition {
    @Autowired
    private SvaBloqueHboaDuoPorTiendaStep svaBloqueHboaDuoPorTiendaStep;
    @Y("seleccionamos agregar Bloque HBO")
    public void seleccionamosAgregarBloqueHBO() {
        svaBloqueHboaDuoPorTiendaStep.seleccionoBloqueHbo();
        svaBloqueHboaDuoPorTiendaStep.guardarCambios();

    }
}
