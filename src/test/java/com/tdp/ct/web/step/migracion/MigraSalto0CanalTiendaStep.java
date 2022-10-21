package com.tdp.ct.web.step.migracion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigraSalto0CanalTiendaStep {
    @Autowired
    StepPages page;
    @ScreenShotBefore
    public void seleccionoOpcionMigraFibra() {
        page.migraSalto0CanalTiendaPage().seleccionoOpcionMigraFibra();
    }
    @ScreenShotAfter
    public void validoPantallaAgendamiento() {
        page.migraSalto0CanalTiendaPage().validoPantallaAgendamiento();
    }
    @ScreenShotAfter
    public void ingresoDatosAgendamiento(String contacto) {
        page.migraSalto0CanalTiendaPage().ingresoDatosAgendamiento(contacto);
    }
    @ScreenShotBefore
    public void clicBotonConfirmarAgendamiento() {
        page.migraSalto0CanalTiendaPage().clicBotonConfirmarAgendamiento();
    }
}
