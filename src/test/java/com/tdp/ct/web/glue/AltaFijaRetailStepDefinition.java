package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaFijaRetailStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaRetailStepDefinition {

    @Autowired
    private AltaFijaRetailStep altaFijaRetailStep;

    @Autowired
    private Customer customer;

    @Y("selecciono un plan hogar {string}")
    public void seleccionoUnPlanHogar(String tipoPlan) {
        altaFijaRetailStep.irSeleccionarTipoPlan(tipoPlan);
    }

    @Y("selecciono el plan hogar {string}")
    public void seleccionoElPlanHogar(String nombrePlan) {
        altaFijaRetailStep.irSeleccionarPlan(nombrePlan);
        altaFijaRetailStep.clickIrLineaNueva();
    }

    @Y("completo los datos solicitados")
    public void completoLosDatosSolicitados(DataTable dataTable) {
        if (customer.isNewCustomer()) {
            altaFijaRetailStep.ingresarDatosCliente(dataTable);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }


}
