package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkStep {
    @Autowired
    private StepPages page;

    public void selecciono_la_cartilla_del_plan_Activo() {
        page.parkPage().selecciono_la_cartilla_del_plan_Activo();
    }
    @ScreenShotAfter
    public void btnHogar() {
        page.parkPage().altaHogar();
    }

    @ScreenShotAfter
    public void btnLineaExistente(String numeroExistente) {
        page.parkPage().lineaExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnLineaCelularExistente(String numeroExistente) {
        page.parkPage().lineaCelularExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnPlanMtExistente(String numeroExistente) {
        page.parkPage().planMtExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnDetalleLineaCelularExistente(String numeroExistente) {
        page.parkPage().detalleLineaCelularExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnLineaMovilExistente() {
        page.parkPage().lineaMovilExistente();
    }

    @ScreenShotAfter
    public void btnMovil() {
        page.parkPage().altaMovil();
    }

    @ScreenShotBefore
    public void btnMostrar() {
        page.parkPage().mostrarOfertas();
    }

    public void cerrarPopupCU() {
        page.parkPage().cerrarPopupCU();
    }

    public void seleccionoCartillaMovistarTotal() {
        page.parkPage().seleccionoCartillaMovistarTotal();
    }
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
    public void seleccionoBotonVerDetalle() {
        page.parkPage().seleccionoBotonVerDetalle();
    }
    @ScreenShotBefore
    public void clickBotonActualizarRuc() {
        page.parkPage().clickBotonActualizarRuc();
    }
    @ScreenShotAfter
    public void ingresoRuc(String ruc) {
        page.parkPage().ingresoRuc(ruc);
    }
    @ScreenShotBefore
    public void clickBotonActualizar() {
        page.parkPage().clickBotonActualizar();
    }
    @ScreenShotAfter
    public void validoMensajeActualizacionCorrecta() {
        page.parkPage().validoMesajeActualizacionCorrecta();
    }
    @ScreenShotBefore
    public void clickBotonEntendido() {
        page.parkPage().clickBotonEntendido();
    }

    @ScreenShotAfter
    public void ingresoRuc17(String ruc) {
        page.parkPage().ingresoRuc17(ruc);
    }

    public void ingresoDigitoV(String digito) {
        page.parkPage().ingresoDigitoV(digito);
    }

    @ScreenShotAfter
    public void seleccionoElPlanQueDesea(String planMovil) {
        page.parkPage().clickPlanMovil(planMovil);
    }
    @ScreenShotAfter
    public void doyClickEnBotonSiguiente() {
        page.parkPage().clickEnBotonSiguiente();
    }

    @ScreenShotAfter
    public void verificoLaDireccionActualDelServicio(String dir) {
        page.parkPage().verificoLaDireccionActualDelServicio(dir);
    }

    @ScreenShotAfter
    public void btnConfirmarDireccion() {
        page.parkPage().btnConfirmarDireccion();
    }
    @ScreenShotAfter
    public void clickMonoYDuo(String mono, String duo) {
        page.parkPage().clickMonoYDuo(mono,duo);
    }
    @ScreenShotBefore
    @ScreenShotAfter
    public void botonContinuar() {
        page.parkPage().clickBotonContinuar();
    }

}
