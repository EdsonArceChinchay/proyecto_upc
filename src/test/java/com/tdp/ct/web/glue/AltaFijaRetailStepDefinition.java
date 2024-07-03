package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.step.AltaFijaRetailStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaRetailStepDefinition {

    @Autowired
    private AltaFijaRetailStep altaFijaRetailStep;

    @Autowired
    private Cliente cliente;

    @Y("selecciono un plan hogar {string}")
    public void seleccionoUnPlanHogar(String tipoPlan) {
        altaFijaRetailStep.irSeleccionarTipoPlan(tipoPlan);
    }

    @Y("selecciono el plan hogar {string}")
    public void seleccionoElPlanHogar(String nombrePlan) {
        altaFijaRetailStep.irSeleccionarPlan(nombrePlan);
        altaFijaRetailStep.clickIrLineaNueva();
    }

    @E("inicio su registro")
    public void inicioSuRegistro() {
        altaFijaRetailStep.irIniciarRegistro();
    }

    @Y("completo los datos solicitados")
    public void completoLosDatosSolicitados(DataTable dataTable) {
        if(cliente.isClienteNuevo()) {
            altaFijaRetailStep.ingresarDatosCliente(dataTable);
        }else{
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("selecciono la linea con numero {string}")
    public void seleccionoLaLineaConNumero(String number) {
        altaFijaRetailStep.selectLineWithNumber(number);
    }
}
