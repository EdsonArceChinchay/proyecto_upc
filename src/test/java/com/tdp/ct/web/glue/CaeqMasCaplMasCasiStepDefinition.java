package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.Caeq.CaeqMasCaplMasCasiStep;
import com.tdp.ct.web.step.Portabilidad.ServiceTest;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CaeqMasCaplMasCasiStepDefinition {
    @Autowired
    private CaeqMasCaplMasCasiStep caeqMasCaplMasCasiStep;

    @Autowired
    private ServiceTest serviceTest;

    @Y("selecciono boton Cambiar plan")
    public void seleccionoBotonCambiarPlan() {
    caeqMasCaplMasCasiStep.clickBotonCambiarPlan();
    }

    @Y("valido que CAEQ:{string}, CAPL: {string} y CASI:{string} en el response del sales")
    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) throws JsonProcessingException {
        serviceTest.getSalesLead("FE-1000154486");
        caeqMasCaplMasCasiStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ,valueCAPL,valueCASI);
    }
}
