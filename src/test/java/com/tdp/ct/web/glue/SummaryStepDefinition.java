package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.SummaryStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class SummaryStepDefinition {

    @Autowired
    private SummaryStep summaryStep;

    @Y("valido que este en el resumen de venta")
    public void valido_que_este_en_la_pagina_de_registro() {
        summaryStep.validateSummaryPage();
    }

    @Entonces("valido en la etapa resumen el nombre del plan escogido {string}")
    public void validoEnLaEtapaResumenElNombreDelPlanEscogido(String nomPlan) {
        summaryStep.validarNomPlan(nomPlan);
    }

    @Y("valido el precio establecido sea {string}")
    public void validacionPrecio(String precioPlan) {
        summaryStep.validacionPrecio(precioPlan);
    }

    /**
     * FUNCION - MOVER A BOTON INICIAR REGISTR0
     * */

    @Y("doy click en el boton Iniciar registro")
    public void doyClickEnIniciarRegistro() {
        summaryStep.moverToElementStartRegister();
        summaryStep.clickButtonStartRegister();
    }
}
