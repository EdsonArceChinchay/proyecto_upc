package com.tdp.ct.web.step.Paquetizacion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaquetizacionDuoMasMonoPorCallCenterStep {
    @Autowired
    private StepPages page;
    @ScreenShotAfter
    public void clickMonoYDuo(String mono, String duo) {
        page.paquetizacionDuoMasMonoPorCallCenterPage().clickMonoYDuo(mono,duo);
    }
     @ScreenShotBefore
     @ScreenShotAfter
    public void botonContinuar() {
        page.paquetizacionDuoMasMonoPorCallCenterPage().clickBotonContinuar();
    }

}
