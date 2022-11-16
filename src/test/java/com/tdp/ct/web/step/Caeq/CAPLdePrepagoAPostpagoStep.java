package com.tdp.ct.web.step.Caeq;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;

public class CAPLdePrepagoAPostpagoStep {
    @Autowired
    private StepPages page;

    public void esperarBtnCardPlanActual() {
        page.capLdePrepagoAPostpagoPage().esperarBtnCardPlanActual();
    }

    @ScreenShotBefore
    public void clickBtnCardPlanActual() {
        page.capLdePrepagoAPostpagoPage().clickBtnCardPlanActual();
    }

    @ScreenShotBefore
    public void clickBtnRenovarPlan() {
        page.capLdePrepagoAPostpagoPage().clickBtnRenovarPlan();
    }

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.capLdePrepagoAPostpagoPage().clickSelectOferta();
    }

    @ScreenShotBefore
    public void validarPlanSelected(String plan) {
        page.caplConCaeqAlContadoCanalTiendaPage().validarPlanSelected(plan);
    }

    @ScreenShotBefore
    public void esperarBtnAddEquipoInCard() {
        page.capLdePrepagoAPostpagoPage().esperarBtnAddEquipoInCard();
    }

    @ScreenShotBefore
    public void clickBtnAddEquipoInCard() {
        page.capLdePrepagoAPostpagoPage().clickBtnAddEquipoInCard();
    }

    public void selectPermanencia(String dato) {
        page.altaMovilPostpagoCallCenterPage().seleccionarTiempo(dato);
    }

    public void selectTipoPago(String tipoPago) {
        page.altaMovilPostpagoCallCenterPage().ingresoElTipoDePago(tipoPago);
    }

    @ScreenShotAfter
    public void writeModeloEquipo(String modelo) {
        page.altaMovilPostpagoCallCenterPage().BuscarEquipo(modelo);
    }

    public void scrollToVerBtnDetalles() {
        page.capLdePrepagoAPostpagoPage().scrollToVerBtnDetalles();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle() {
        page.capLdePrepagoAPostpagoPage().clickBtnVerDetalle();
    }

    public void validarFeatures() {
        page.capLdePrepagoAPostpagoPage().validarFeatures();
    }

    @ScreenShotBefore
    public void clickBtnSelectEquipo() {
        page.capLdePrepagoAPostpagoPage().clickBtnSelectEquipo();
    }

    @ScreenShotBefore
    public void clickBtnConShadowIniciarRegistro() {
        page.capLdePrepagoAPostpagoPage().clickBtnConShadowIniciarRegistro();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void writeEmail(String email) {
        page.capLdePrepagoAPostpagoPage().writeEmail(email);
    }

}
