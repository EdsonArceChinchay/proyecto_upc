package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaDireccionPorCoordenasStep {

    @Autowired
    private StepPages page;


    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        page.consultaDireccionPorCoordenasPage().ingresoLasCoordenadasDeLogitudyLatitud(x,y);
    }
}
