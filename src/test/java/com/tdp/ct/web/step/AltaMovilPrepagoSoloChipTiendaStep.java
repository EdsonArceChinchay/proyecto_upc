package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.service.util.UtilWeb.getValueFromDataTable;

@Component
public class AltaMovilPrepagoSoloChipTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickSeleccionarOferta(String oferta) {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionarOferta(oferta);
    }

    @ScreenShotBefore
    public void clickSeleccionaPlan(String plan) {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionaPrepago();
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionaPlan(plan);
    }

    @ScreenShotAfter
    public void clickSeleccionarOferta() {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionarOferta();
    }


    @ScreenShotAfter
    public void clickIrMovilNuevo() {
        page.altaMovilPrepagoSoloChipTiendaPage().irMovilNuevo();
    }


    @ScreenShotAfter
    public void clicBotonContinuar() {
        page.altaMovilPrepagoSoloChipTiendaPage().clicBotonContinuar();
    }
}
