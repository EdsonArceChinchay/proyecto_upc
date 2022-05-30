package com.tdp.ct.web.glue;

import com.tdp.ct.web.page.AltaMovilPrepagoSoloChipTiendaPage;
import com.tdp.ct.web.step.AltaMovilPrepagoSoloChipTiendaStep;
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
    }
}
