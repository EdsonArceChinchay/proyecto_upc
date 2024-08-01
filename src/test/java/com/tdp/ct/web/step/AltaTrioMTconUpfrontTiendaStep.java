package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaTrioMTconUpfrontTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void clickBotonLineaNueva(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonLineaNueva();
    }
    @ScreenShotBefore
    public void clickBotonIrMovistarTotal(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonIrMovistarTotal();
    }

    public void seleccionoElNombreDePlanMovistarTotal() {
        page.altaTrioMTconUpfrontTiendaPage().seleccionoElNombreDePlanMovistarTotal();
    }

    @ScreenShotAfter
    public void scrollFinalPagina() {
        page.altaTrioMTconUpfrontTiendaPage().scrollFinalPagina();
    }

    @ScreenShotBefore
    public void clickSubDetalles(){
        page.altaTrioMTconUpfrontTiendaPage().subDetalles();
    }

    @ScreenShotBefore
    public void validarlblAplicaUpFrom(){
        page.altaTrioMTconUpfrontTiendaPage().lblAplicaUpFrom();
    }

    @ScreenShotBefore
    public void clickCierrePopup() {
        page.altaTrioMTconUpfrontTiendaPage().clickCierrePopup();
    }
}
