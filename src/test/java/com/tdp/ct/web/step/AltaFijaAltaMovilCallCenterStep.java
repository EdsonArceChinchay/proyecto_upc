package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaFijaAltaMovilCallCenterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    public void scrollUp() {
        page.altaFijaAltaMovilCallCenterPage().scrollUP();
    }

    public void clickPrimeraOferta() {
        page.altaFijaAltaMovilCallCenterPage().ofertaUno();
    }

    public void clickOferta() {
        page.altaFijaAltaMovilCallCenterPage().oferta();
    }

    @ScreenShotBefore
    public void BtonOpciones() {
        page.altaFijaAltaMovilCallCenterPage().BtonOpciones();
    }

    public void seleccionarListaOferta(String listaOferta) {
        page.altaFijaAltaMovilCallCenterPage().listaOfertas(listaOferta, scenario);
    }

    public void clickIrAMovistarTotal() {
        page.altaFijaAltaMovilCallCenterPage().irAMovistarTotal();
    }

    @ScreenShotBefore
    public void clickBotonIrMovistarTotal() {
        page.altaFijaAltaMovilCallCenterPage().clickBotonIrMovistarTotal();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickListaBotones() {
        page.altaFijaTiendaPage().listaBotones();
    }

    @ScreenShotBefore
    public void seleccionarLineaNueva() {
        page.altaFijaAltaMovilCallCenterPage().selectBtnLineaNueva();
    }


    public void seleccionoElNombreDePlanMovistarTotal() {
        page.altaTrioMTconUpfrontTiendaPage().seleccionoElNombreDePlanMovistarTotal();
    }

    public void clickConsultarCobertura() {
        page.altaFijaAltaMovilCallCenterPage().btnConsultarCobertura();
    }

    public void clickSeleccionarOferta() {
        page.altaFijaAltaMovilCallCenterPage().seleccionarOferta();
    }
}

