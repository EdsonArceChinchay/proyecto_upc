package com.tdp.ct.web.step.Caeq;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaeqMasCaplMasCasiStep {
    @Autowired
    StepPages page;
    @ScreenShotBefore
    public void clickBotonCambiarPlan() {
        page.caeqMasCaplMasCasiPage().clickBotonCambiarPlan();
    }

    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) {
        page.caeqMasCaplMasCasiPage().validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ,valueCAPL,valueCASI);
    }
}
