package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tdp.ct.web.utils.Addons;

import java.sql.Driver;

@Component
public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickSelectOferta();
    }

    @ScreenShotBefore
    public void validarPlanSelected(String plan) {
        page.caplConCaeqAlContadoCanalTiendaPage().validarPlanSelected(plan);
    }

    @ScreenShotBefore
    public void esperarBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().esperarBtnAddEquipoInCard();
    }

    @ScreenShotBefore
    public void clickBtnAddEquipoInCard() {
        page.caplConCaeqAlContadoCanalTiendaPage().clickBtnAddEquipoInCard();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void writeEmail(String email) {
        page.caplConCaeqAlContadoCanalTiendaPage().writeEmail(email);
    }

}
