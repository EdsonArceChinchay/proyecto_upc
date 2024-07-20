package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
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

    @ScreenShotBefore
    public void seleccionarTipoPago(String tipoPago) {
        page.altaFijaAltaMovilCallCenterPage().tipoPago(tipoPago);
    }

    public void ingresarCorreo(String correo) {
        page.altaFijaAltaMovilCallCenterPage().correo(correo);
    }

    public void ingresarCorreoNuevamente(String correo) {
        page.altaFijaAltaMovilCallCenterPage().confirmarCorreo(correo);
    }

    public void clickBtnConfirmar2() {
        page.altaFijaAltaMovilCallCenterPage().btnConfirmar2();
    }

    public void clickBtnFinalizarRegistro() {
        page.altaFijaAltaMovilCallCenterPage().btnFinalizarRegistro();
    }

    public void scrollUp() {
        page.altaFijaAltaMovilCallCenterPage().scrollUp();
    }

    public void clickPrimeraOferta() {
        page.altaFijaAltaMovilCallCenterPage().ofertaUno();
    }

    public void clickOferta() {
        page.altaFijaAltaMovilCallCenterPage().oferta();
    }

    public void seleccionarListaOferta(String listaOferta) {
        page.altaFijaAltaMovilCallCenterPage().listaOfertas(listaOferta, scenario);
    }

    public void clickIrAMovistarTotal() {
        page.altaFijaAltaMovilCallCenterPage().irAMovistarTotal();
    }

}

