package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMonoInstalacionFtthTiendaStep {

    @Autowired
    private StepPages page;

    public void scrollToBtnCrearCliente() {
        page.altaMonoFtthTiendaPage().scrollToBtnCrearCliente();
    }

    @ScreenShotBefore
    public void crearCliente() {
        page.altaMonoFtthTiendaPage().crearCliente();
    }

    @ScreenShotAfter
    public void validarOfertasSugeridasView(String title) {
        page.altaMonoFtthTiendaPage().validarOfertasSugeridasView(title);
    }

    public void scrollToBtnPlanNuevo() {
        page.altaMonoFtthTiendaPage().scrollToBtnPlanNuevo();
    }

    @ScreenShotBefore
    public void clickBtnPlanNuevo() {
        page.altaMonoFtthTiendaPage().clickBtnPlanNuevo();
    }

    @ScreenShotBefore
    public void clickBtnTipoPlan(String plan) {
        page.altaMonoFtthTiendaPage().clickBtnTipoPlan(plan);
    }

    @ScreenShotBefore
    public void seleccionarPlan(String plan) {
        page.altaFijaMovilRegistroPage().seleccionarPlan(plan);
    }

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.altaFijaMovilRegistroPage().clicSeleccionarOferta();
    }

    public void esperarBtnLineaNueva() {
        page.altaMonoFtthTiendaPage().esperarBtnLineaNueva();
    }

    @ScreenShotBefore
    public void clickBtnLineaNueva(String btnName) {
        page.altaMonoFtthTiendaPage().clickBtnLinea(btnName);
    }

    @ScreenShotBefore
    public void validarDetallePlan() {
        page.altaMonoFtthTiendaPage().validarDetallePlan();
    }

}
