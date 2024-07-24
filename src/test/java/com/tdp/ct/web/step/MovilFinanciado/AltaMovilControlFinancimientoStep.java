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

    @Autowired
    private ManageScenario scenario;

    @ScreenShotAfter
    public void ingresarPlanActual() {
        page.altaMovilControlFinancimientoPage().selectPlanActual();
    }

    @ScreenShotBefore
    public void ingresarPlanMovil() {
        page.altaMovilControlFinancimientoPage().selectPlanMovil();
    }

    @ScreenShotAfter
    public void seleccionarCampania() {
        page.altaMovilControlFinancimientoPage().selectCampania();
    }

    @ScreenShotBefore
    public void seleccionarLineaNueva() {
        page.altaMovilControlFinancimientoPage().selectBtnLineaNueva();
    }

    @ScreenShotAfter
    public void ingresarBtnPostpago() {
        page.altaMovilControlFinancimientoPage().selectBtnPostpago();
    }

    @ScreenShotAfter
    public void ingresarBtnControl() {
        page.altaMovilControlFinancimientoPage().selectBtnControl();
    }

}
