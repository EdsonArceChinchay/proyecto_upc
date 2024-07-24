package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SumaryStep {
    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickButtonStartRegister() {
        page.summaryPage().clickButtonStartRegister();
    }

    @ScreenShotAfter
    public void validarPaginaResumen() {
        page.summaryPage().paginaResumen();
    }

    public void moverToElementIniciarRegistro() {
        page.summaryPage().moverToElementIniciarRegistro();
    }

}
