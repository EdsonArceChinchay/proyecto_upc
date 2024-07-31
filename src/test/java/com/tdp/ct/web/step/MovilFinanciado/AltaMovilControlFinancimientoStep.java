package com.tdp.ct.web.step.MovilFinanciado;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilControlFinancimientoStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void seleccionarLineaNueva() {
        page.altaMovilControlFinancimientoPage().selectBtnLineaNueva();
    }

}
