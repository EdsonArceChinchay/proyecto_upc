package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaMovilPrepagoSoloChipTiendaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMovilPrepagoSoloChipTiendaStepDefinition {

    @Autowired
    private AltaMovilPrepagoSoloChipTiendaStep altaMovilPrepagoSoloChipTiendaStep;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Y("selecciono la oferta de plan movil {string}")
    public void seleccionoLaOfertaDePlanMovil(String oferta) {
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionarOferta(oferta);
        //altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Y("selecciono plan prepago {string}")
    public void seleccionoPlanPrepago(String plan) {
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionaPlan(plan);
        altaMovilPrepagoSoloChipTiendaStep.clickSeleccionarOferta();
        altaMovilPrepagoSoloChipTiendaStep.clickIrMovilNuevo();
    }

    @Y("presiono continuar")
    public void presionoContinuar() {
        altaMovilPrepagoSoloChipTiendaStep.clicBotonContinuar();
    }
}
