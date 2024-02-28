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

    @Y("valido que CAEQ:{string}, CAPL: {string} y CASI:{string} en el response del sales")
    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) {
        caeqMasCaplMasCasiStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ,valueCAPL,valueCASI);
    }
}
