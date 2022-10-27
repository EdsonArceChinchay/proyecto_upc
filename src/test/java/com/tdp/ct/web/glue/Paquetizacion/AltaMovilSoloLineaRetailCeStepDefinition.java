package com.tdp.ct.web.glue.Paquetizacion;

import com.tdp.ct.web.step.Paquetizacion.AltaMovilSoloLineaRetailCeStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMovilSoloLineaRetailCeStepDefinition {
    @Autowired
    private AltaMovilSoloLineaRetailCeStep altaMovilSoloLineaRetailCeStep;


    @Y("seleccion oferta Postpago")
    public void seleccionOferta() {
        altaMovilSoloLineaRetailCeStep.buscarOfertaRetail();
    }
}
