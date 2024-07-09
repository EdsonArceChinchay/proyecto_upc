package com.tdp.ct.web.step.VentaRuc10;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActualizacionDeRuc17CanalTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void ingresoRuc17(String ruc) {
        page.actualizacionDeRuc17CanalTiendaPage().ingresoRuc17(ruc);
    }

    public void ingresoDigitoV(String digito) {
        page.actualizacionDeRuc17CanalTiendaPage().ingresoDigitoV(digito);
    }

    public void clickBotonActualizar() {
        page.actualizacionDeRuc17CanalTiendaPage().clickBotonActualizar();
    }
}
