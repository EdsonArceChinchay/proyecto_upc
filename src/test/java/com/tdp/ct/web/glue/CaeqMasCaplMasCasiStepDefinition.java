package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.Caeq.CaeqMasCaplMasCasiStep;
import com.tdp.ct.web.step.Portabilidad.ServiceTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class CaeqMasCaplMasCasiStepDefinition {
    @Autowired
    private CaeqMasCaplMasCasiStep caeqMasCaplMasCasiStep;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    private Customer customer;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Y("selecciono boton Cambiar plan")
    public void seleccionoBotonCambiarPlan() {
        caeqMasCaplMasCasiStep.clickBotonCambiarPlan();
    }

    @Y("valido que CAEQ:{string}, CAPL: {string} y CASI:{string} en el response del salesLead")
    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) throws JSONException {
        String salesCode = altaFijaMovilRegistroStep.getSalesCode();
        salesCode = salesCode == null ? customer.getSalesCode() : salesCode;
        this.scenario.log("[Código de Venta: " + salesCode + "]");
        caeqMasCaplMasCasiStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, caeqMasCaplMasCasiStep.getSalesLead(salesCode));
        this.scenario.log(caeqMasCaplMasCasiStep.getSalesLead(salesCode).toString());

    }
}
