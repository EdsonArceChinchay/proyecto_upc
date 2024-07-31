package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.Caeq.CaeqPorReatilStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class CaeqPorReatilStepDefinition {
    @Autowired
    private CaeqPorReatilStep caeqPorReatilStep;
    @Autowired
    private Customer customer;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("presiona el boton anadir equipo")
    public void presionaElBotonAnadirEquipo() {
        caeqPorReatilStep.btnAnadirEquipo(2);
    }

    @Y("presiona el boton anadir equipo del mismo plan")
    public void presionaElBotonAnadirEquipoDelMismoPlan() {
        caeqPorReatilStep.btnAnadirEquipo(1);
    }

    @Y("selecciono boton mantener plan")
    public void seleccionoBotonMantenerPlan() {
        caeqPorReatilStep.btnMantenerPlan();
    }

    @Y("selecciono boton Cambiar plan")
    public void seleccionoBotonCambiarPlan() {
        caeqPorReatilStep.clickBotonCambiarPlan();
    }

    @Y("valido que CAEQ:{string}, CAPL: {string} y CASI:{string} en el response del salesLead")
    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) throws JSONException {
        String salesCode = altaFijaMovilRegistroStep.getSalesCode();
        salesCode = salesCode == null ? customer.getSalesCode() : salesCode;
        this.scenario.log("[Código de Venta: " + salesCode + "]");
        caeqPorReatilStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, caeqPorReatilStep.getSalesLead(salesCode));
        this.scenario.log(caeqPorReatilStep.getSalesLead(salesCode).toString());

    }

    @Y("selecciono el boton Cambiar Chip")
    public void seleccionoelbotonCambiodeChip() {
        caeqPorReatilStep.seleccionoelbotonCambiodeChip();
    }

    @Y("cierro pop up de Cliente Exonerado")
    public void cierroPopUpDeClienteExonerado() {
        caeqPorReatilStep.cierroPopUpDeClienteExonerado();
    }

}
