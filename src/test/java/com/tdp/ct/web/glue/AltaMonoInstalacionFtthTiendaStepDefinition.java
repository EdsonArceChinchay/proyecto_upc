package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaMonoInstalacionFtthTiendaStep;
import io.cucumber.java.es.Entonces;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMonoInstalacionFtthTiendaStepDefinition {

    @Autowired
    private AltaMonoInstalacionFtthTiendaStep altaMonoHfcTiendaStep;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Entonces("valido que se presente la pantalla con el titulo {string}")
    public void validoSePresentePantallaConTitulo(String title) {
        altaMonoHfcTiendaStep.validarOfertasSugeridasView(title);
    }
}
