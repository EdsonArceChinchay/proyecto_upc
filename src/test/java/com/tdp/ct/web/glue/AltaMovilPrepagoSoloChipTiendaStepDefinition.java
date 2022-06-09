package com.tdp.ct.web.glue;

import com.tdp.ct.web.page.AltaMovilPrepagoSoloChipTiendaPage;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaMovilPrepagoSoloChipTiendaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMovilPrepagoSoloChipTiendaStepDefinition {

    @Autowired
    private AltaMovilPrepagoSoloChipTiendaStep altaMovilPrepagoSoloChipTiendaStep;

    @Y("selecciono la oferta de plan movil {string}")
    public void seleccionoLaOfertaDePlanMovil(String oferta) {
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionarOferta(oferta);
    }

    @Y("selecciono plan prepago {string}")
    public void seleccionoPlanPrepago(String plan) {
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionaPlan(plan);
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionarOferta();
        altaMovilPrepagoSoloChipTiendaStep.clickIrMovilNuevo();
    }

    @E("inicio registro")
    public void inicioRegistro() {
        altaMovilPrepagoSoloChipTiendaStep.clickIniciarRegistro();
    }

    @Y("completo datos del cliente")
    public void completoDatosDelCliente(DataTable dataTable) {
        altaMovilPrepagoSoloChipTiendaStep.ingresarDatosCliente(dataTable);
        altaMovilPrepagoSoloChipTiendaStep.irAConfirmar();
    }

    @Y("presiono continuar")
    public void presionoContinuar() {
        altaMovilPrepagoSoloChipTiendaStep.clicBotonContinuar();
    }
}
