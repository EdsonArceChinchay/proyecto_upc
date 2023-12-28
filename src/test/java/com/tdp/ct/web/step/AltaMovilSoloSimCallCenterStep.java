package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilSoloSimCallCenterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    public void clickBotonMostrarOfertasRapido(){
        page.altaMovilSoloSimCallCenterPage().botonMostrarOfertasRapido();
    }
    public void cerrarPopUpEstadoCU(){
        page.altaMovilSoloSimCallCenterPage().cerrarPopUpEstadoCU();
    }

    public void validarOfertasSugeridas(){
        page.altaMovilSoloSimCallCenterPage().ofertasSugeridas();
    }

    public void seleccionarListaTipoPlanMovil(String planMovil){page.altaMovilSoloSimCallCenterPage().listaTipoPlanMovil(planMovil);}

    public void seleccionarListaPlanMovil(String planMovil){
        page.altaMovilSoloSimCallCenterPage().listaPlanMovil(planMovil,scenario);
    }

    public void clickBotonSeleccionarOferta(){page.altaMovilSoloSimCallCenterPage().botonSeleccionarOfeta();}

    public void validarPaginaResumen(){
        page.altaMovilSoloSimCallCenterPage().paginaResumen();
    }

    public void validarCompletaDatosSolicitados(){
        page.altaMovilSoloSimCallCenterPage().completaDatosSolicitados();
    }

    public void botonentendidoOfertas(){
        page.altaMovilSoloSimCallCenterPage().botonentendidoOfertas();
    }
}

