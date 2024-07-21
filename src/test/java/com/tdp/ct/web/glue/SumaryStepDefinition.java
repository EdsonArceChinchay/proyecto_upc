package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.SumaryStep;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class SumaryStepDefinition {

    @Autowired
    private SumaryStep sumaryStep;

    @E("inicio su registro")
    public void inicioSuRegistro() {
        sumaryStep.irIniciarRegistro();
    }

    @Y("valido que este en el resumen de venta")
    public void valido_que_este_en_la_pagina_de_registro() {
        sumaryStep.validarPaginaResumen();
    }

}
