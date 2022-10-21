package com.tdp.ct.web.step.migracion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MigraSalto0RetailStep {
    @Autowired
    StepPages page;
    @ScreenShotBefore
    public void SeleccionarBtnMigrarFibra() {
        page.migraSalto0RetailPage().SeleccionarBtnMigrarFibra();
    }
    @ScreenShotBefore
    public void clicIniciarRegistro() {
        page.migraSalto0RetailPage().ClicIniciarRegistro();
    }
}
