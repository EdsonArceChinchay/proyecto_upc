package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.SumaryStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class SumaryStepDefinition {

    @Autowired
    private SumaryStep sumaryStep;

    @Y("valido que este en el resumen de venta")
    public void valido_que_este_en_la_pagina_de_registro() {
        sumaryStep.validarPaginaResumen();
    }

    @Y("doy click en el boton Iniciar registro")
    public void doyClickEnIniciarRegistro() {
        sumaryStep.moverToElementStartRegister();
        sumaryStep.clickButtonStartRegister();
    }

    @Entonces("valido en la etapa resumen el nombre del plan escogido {string}")
    public void validoEnLaEtapaResumenElNombreDelPlanEscogido(String nomPlan) {
        sumaryStep.validarNomPlan(nomPlan);
    }

    @Y("valido el precio establecido sea {string}")
    public void validacionPrecio(String precioPlan) {
        sumaryStep.validacionPrecio(precioPlan);
    }

}
