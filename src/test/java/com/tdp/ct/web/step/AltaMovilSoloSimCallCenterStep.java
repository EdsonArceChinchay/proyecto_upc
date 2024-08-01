package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilSoloSimCallCenterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    public void cerrarPopUpEstadoCU() {
        page.altaMovilSoloSimCallCenterPage().cerrarPopUpEstadoCU();
    }

    public void validarOfertasSugeridas() {
        page.altaMovilSoloSimCallCenterPage().ofertasSugeridas();
    }

    public void seleccionarListaTipoPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaTipoPlanMovil(planMovil);
    }

    public void seleccionarListaPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaPlanMovil(planMovil, scenario);
    }

    public void seleccionarPlan(String tipoPlan) {
        page.altaMovilSoloSimCallCenterPage().seleccionarPlan(tipoPlan);
    }

    public void clickBotonSeleccionarOferta() {
        page.altaMovilSoloSimCallCenterPage().botonSeleccionarOfeta();
    }

    public void validarSeleccionaPostpagoPrepago() {
        page.altaMovilSoloSimCallCenterPage().validarSeleccionaPostpagoPrepago();
    }

    public void seleccionoElBotonAgregarSva() {
        page.altaMovilSoloSimCallCenterPage().seleccionoElBotonAgregarSva();
    }
}

