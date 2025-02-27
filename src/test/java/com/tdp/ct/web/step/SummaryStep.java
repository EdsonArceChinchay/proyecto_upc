package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SummaryStep {

    @Autowired
    private StepPages page;

    public void validarNomPlan(String nomPlan) {
        page.summaryPage().validarNomPlan(nomPlan);
    }

    @ScreenShotAfter
    public void validacionPrecio(String precioPLan) {
        page.summaryPage().validacionPrecio(precioPLan);
    }

    /**
     * FUNCION - VISUALIZAR RESUMEN DE VENTA
     * */

    public void validateSummaryPage() {
        page.summaryPage().validateSummaryPage();
    }

    /**
     * FUNCION - MOVER A BOTON INICIAR REGISTR0
     * */

    public void moverToElementStartRegister() {
        page.summaryPage().moverToElementStartRegister();
    }

    public void additionalData() {
        page.summaryPage().additionalData();
    }

    public void clickButtonStartRegister() {
        additionalData();
        page.summaryPage().clickButtonStartRegister();
    }
}
