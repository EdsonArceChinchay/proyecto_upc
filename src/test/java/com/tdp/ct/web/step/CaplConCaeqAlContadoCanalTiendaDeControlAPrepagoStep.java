package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tdp.ct.web.utils.Addons;

@Component
public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep {
    @Autowired
    private StepPages page;

    public void visualizaDetallesPlanElejido(ManageScenario scenario) {
        page.caplConCaeqAlContadoCanalTiendaPage().visualizaDetallesPlanElejido(scenario);
    }
}
