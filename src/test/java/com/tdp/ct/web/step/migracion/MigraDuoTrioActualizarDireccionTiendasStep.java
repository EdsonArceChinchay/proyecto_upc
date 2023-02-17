package com.tdp.ct.web.step.migracion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigraDuoTrioActualizarDireccionTiendasStep {
    @Autowired
    private StepPages pages;
    @ScreenShotBefore
    @ScreenShotAfter
    public void doyClickEnElBoton(String button) {
        pages.migraDuoTrioActualizarDireccionTiendasPage().doyClickEnElBoton(button);
    }
    @ScreenShotAfter
    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        pages.migraDuoTrioActualizarDireccionTiendasPage().validoQueSePresenteElSiguienteMensaje(mensaje);
    }
}
