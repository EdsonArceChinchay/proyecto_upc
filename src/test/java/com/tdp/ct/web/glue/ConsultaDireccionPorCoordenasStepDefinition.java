package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.ConsultaDireccionPorCoordenasStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class ConsultaDireccionPorCoordenasStepDefinition {

    @Autowired
    private ConsultaDireccionPorCoordenasStep consultaDireccionPorCoordenasStep;

    @Y("ingreso las coordenadas de Longitud X: {string} y Latitud Y:{string}")
    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        consultaDireccionPorCoordenasStep.ingresoLasCoordenadasDeLogitudyLatitud(x,y);
    }

    @Y("valido que la direccion sea {string}")
    public void validoQueLaDireccionSea(String direccion) {
        consultaDireccionPorCoordenasStep.validoQueLaDireccionSea(direccion);
    }

    @Y("valido que que me muestre el mensajde de error {string}")
    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        consultaDireccionPorCoordenasStep.validoQueQueMeMuestreElMensajdeDeError(msj);
    }


    @Y("doy click Aceptar en el modal de error")
    public void doyClickAceptarEnElModalDeError() {
        consultaDireccionPorCoordenasStep.doyClickAceptarEnElModalDeError();
    }
}
