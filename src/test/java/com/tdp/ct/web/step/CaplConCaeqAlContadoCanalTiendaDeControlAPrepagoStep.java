package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep {

    @Autowired
    private StepPages page;

    public void esperarBtnCardPlanActual() {
        page.caplConCaeqAlContadoCanalTiendaPage().esperarBtnCardPlanActual();
    }

    @ScreenShotBefore
    public void clickBtnCardPlanActual() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnCardPlanActual();
    }

    @ScreenShotBefore
    public void clickBtnRenovarPlan() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnRenovarPlan();
    }

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickSelectOferta();
    }

    public void validarPlanSelected(String plan) {
        page.caplConCaeqAlContadoCanalTiendaPage().validarPlanSelected(plan);
    }

    public void esperarBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().esperarBtnAddEquipoInCard();
    }

    @ScreenShotBefore
    public void clickBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnAddEquipoInCard();
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
        page.caplConCaeqAlContadoCanalTiendaPage().scrollToVerBtnDetalles();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnVerDetalle();
    }

    public void validarFeatures() {
        page.caplConCaeqAlContadoCanalTiendaPage().validarFeatures();
    }

    @ScreenShotBefore
    public void clickBtnSelectEquipo() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnSelectEquipo();
    }

    @ScreenShotBefore
    public void clickBtnConShadowIniciarRegistro() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnConShadowIniciarRegistro();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void writeEmail(String email) {
        page.caplConCaeqAlContadoCanalTiendaPage().writeEmail(email);
    }

}
