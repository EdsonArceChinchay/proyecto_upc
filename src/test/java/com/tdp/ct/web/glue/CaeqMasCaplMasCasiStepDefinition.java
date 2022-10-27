package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.Caeq.CaeqMasCaplMasCasiStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CaeqMasCaplMasCasiStepDefinition {
    @Autowired
    private CaeqMasCaplMasCasiStep caeqMasCaplMasCasiStep;

    @Y("selecciono boton Cambiar plan")
    public void seleccionoBotonCambiarPlan() {
    caeqMasCaplMasCasiStep.clickBotonCambiarPlan();
    }
}
