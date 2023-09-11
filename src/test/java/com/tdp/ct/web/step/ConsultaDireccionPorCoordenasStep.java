package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaDireccionPorCoordenasStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        page.consultaDireccionPorCoordenasPage().ingresoLasCoordenadasDeLogitudyLatitud(x, y);
    }

    @ScreenShotAfter
    public void validoQueLaDireccionSea(String direccion) {
        page.consultaDireccionPorCoordenasPage().validoQueLaDireccionSea(direccion);
    }

    @ScreenShotAfter
    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        page.consultaDireccionPorCoordenasPage().validoQueQueMeMuestreElMensajdeDeError(msj);

    }

    @ScreenShotAfter
    public void doyClickAceptarEnElModalDeError() {
        page.consultaDireccionPorCoordenasPage().doyClickAceptarEnElModalDeError();

    }
}
