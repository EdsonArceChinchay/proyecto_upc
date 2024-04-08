package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
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
    private ServiceTest serviceTest;

    @Autowired
    private Cliente cliente;

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
        String codigoVenta ="FE-1000156745"; //cliente.getNumeroSolicitud();

        caeqMasCaplMasCasiStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, caeqMasCaplMasCasiStep.getSalesLead(codigoVenta));
        //this.scenario.log(caeqMasCaplMasCasiStep.getSalesLead(codigoVenta).toString());

    }
}
