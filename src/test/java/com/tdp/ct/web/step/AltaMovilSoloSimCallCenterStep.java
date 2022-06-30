package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilSoloSimCallCenterStep {

    @Autowired
    private StepPages page;

    public void clickBotonMostrarOfertasRapido(){
        page.altaMovilSoloSimCallCenterPage().botonMostrarOfertasRapido();
    }

    public void validarOfertasSugeridas(){
        page.altaMovilSoloSimCallCenterPage().ofertasSugeridas();
    }

    public void seleccionarListaTipoPlanMovil(String planMovil){page.altaMovilSoloSimCallCenterPage().listaTipoPlanMovil(planMovil);}

    public void seleccionarListaPlanMovil(String planMovil){page.altaMovilSoloSimCallCenterPage().listaPlanMovil(planMovil);}

    public void clickBotonSeleccionarOferta(){page.altaMovilSoloSimCallCenterPage().botonSeleccionarOfeta();}

    public void validarPaginaResumen(String data){

        Assert.assertTrue("El elemento esperado no es igual al actual",
                page.altaMovilSoloSimCallCenterPage().paginaResumen().equalsIgnoreCase(data));
    }

    public void validarCompletaDatosSolicitados(){
        page.altaMovilSoloSimCallCenterPage().completaDatosSolicitados();
    }

}

