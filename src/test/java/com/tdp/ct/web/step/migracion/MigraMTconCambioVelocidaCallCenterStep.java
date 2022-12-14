package com.tdp.ct.web.step.migracion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigraMTconCambioVelocidaCallCenterStep {
    @Autowired
    StepPages page;

    @ScreenShotBefore
    public void seleccionoCartillaPlanMT() {
        page.migraMTconCambioVelocidaCallCenterPage().seleccionoCartillaPlanMT();
    }

    public void seleccionoLineaMovil() {
        page.migraMTconCambioVelocidaCallCenterPage().seleccionoLineaMovil();
    }

    public void SeleccionoMostrarOfecta() {
        page.migraMTconCambioVelocidaCallCenterPage().seleccionoMostrarOferta();
    }
}
