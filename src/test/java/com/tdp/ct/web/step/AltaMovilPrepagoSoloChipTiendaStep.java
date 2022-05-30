package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilPrepagoSoloChipTiendaStep {

    @Autowired
    private StepPages pages;

    public void clickSeleccionarOferta(String oferta){
        pages.altaMovilPrepagoSoloChipTiendaPage().seleccionarOferta(oferta);
    }

    public void clickSeleccionaPlan(String plan){
        pages.altaMovilPrepagoSoloChipTiendaPage().seleccionaPrepago();
        pages.altaMovilPrepagoSoloChipTiendaPage().seleccionaPlan(plan);
    }
}
