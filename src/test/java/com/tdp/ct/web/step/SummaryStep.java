package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SummaryStep {
    @Autowired
    private StepPages page;

    public void additionalData() {
        page.summaryPage().additionalData();
    }

    @ScreenShotBefore
    public void clickButtonStartRegister() {
        additionalData();
        page.summaryPage().clickButtonStartRegister();
    }

    @ScreenShotAfter
    public void validarPaginaResumen() {
        page.summaryPage().paginaResumen();
    }

    public void moverToElementStartRegister() {
        page.summaryPage().moverToElementStartRegister();
    }

    public void validarNomPlan(String nomPlan) {
        page.summaryPage().validarNomPlan(nomPlan);
    }

    @ScreenShotAfter
    public void validacionPrecio(String precioPLan) {
        page.summaryPage().validacionPrecio(precioPLan);
    }

}
