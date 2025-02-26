package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AltaMovilSoloSimCallCenterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ServiceTest serviceTest;

    public void seleccionarListaTipoPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaTipoPlanMovil(planMovil);
    }

    public void seleccionarListaPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaPlanMovil(planMovil);
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

    @ScreenShotBefore
    public void clickOnAddDevice(int num) {
        page.caeqPorRetailPage().clickOnAddDevice(num);
    }

    @ScreenShotBefore
    public void clickOnAddDevice() {
        page.caeqPorRetailPage().clickOnAddDevice();
    }

    @ScreenShotBefore
    public void doyClickEnElBotonSeleccionarOferta() {
        page.caeqPorRetailPage().doyClickEnElBotonSeleccionarOferta();
    }

    @ScreenShotBefore
    public void btnMantenerPlan() {
        page.caeqPorRetailPage().btnMantenerPlan();
    }

    @ScreenShotBefore
    public void clickBotonCambiarPlan() {
        page.caeqPorRetailPage().clickBotonCambiarPlan();
    }

    public Map<String, String> getSalesLead(String codigoVenta) {
        Map<String, String> movileValues;
        movileValues = serviceTest.getSalesLead(codigoVenta);
        return movileValues;
    }

    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI, Map<String, String> salesLead) {
        page.caeqPorRetailPage().validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, salesLead);
    }

    public void seeTheChosenOffer() {
        page.caeqPorRetailPage().seeTheChosenOffer();
    }

    public void imprimoLaOfertaSeleccionada(ManageScenario scenario) {
        page.altaMovilSoloSimCallCenterPage().imprimoLaOfertaSeleccionada(scenario);
    }
}

