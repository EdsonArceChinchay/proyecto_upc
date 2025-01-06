package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.step.CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep;

import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStepDefinition {
    @Autowired
    private CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep caplConCaeqAlContadoCanalTiendaStep;

    @Autowired
    private ManageScenario scenario;

    @Y("visualizo los detalles del plan seleccionado")
    public void visualizoLosDetallesDelPlanSeleccionado() {
        caplConCaeqAlContadoCanalTiendaStep.visualizaDetallesPlanElejido(scenario);
    }
}
