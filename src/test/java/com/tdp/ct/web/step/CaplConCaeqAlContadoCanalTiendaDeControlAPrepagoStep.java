package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tdp.ct.web.utils.Addons;

import java.sql.Driver;

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

    @ScreenShotAfter
    public void clickBtnRenovarPlan(){
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnRenovarPlan();
    }

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickSelectOferta();
    }

    @ScreenShotBefore
    public void validarPlanSelected(String plan) {
        page.caplConCaeqAlContadoCanalTiendaPage().validarPlanSelected(plan);
    }

    @ScreenShotBefore
    public void esperarBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().esperarBtnAddEquipoInCard();
    }

    @ScreenShotBefore
    public void clickBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnAddEquipoInCard();
    }

    @ScreenShotAfter
    public void selectPermanency(String timePermanency) {
        page.altaMovilPostpagoCallCenterPage().selectPermanency(timePermanency);
    }
    @ScreenShotAfter
    public void selectTypeOfPayment(String typePayment) {
        page.altaMovilPostpagoCallCenterPage().selectTypeOfPayment(typePayment);
    }

    @ScreenShotAfter
    public void writeModeloEquipo(String modelo) {
        page.altaMovilPostpagoCallCenterPage().BuscarEquipo(modelo);
    }

    @ScreenShotAfter
    public int contadorResultadosBusquedaEquipos(){
        return page.caplConCaeqAlContadoCanalTiendaPage().contadorResultadosBusquedaEquipos();
    }
    public void scrollToVerBtnDetalles() {
        page.caplConCaeqAlContadoCanalTiendaPage().scrollToVerBtnDetalles();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnVerDetalle();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle(String nroServicio) {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnVerDetalle(nroServicio);
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
