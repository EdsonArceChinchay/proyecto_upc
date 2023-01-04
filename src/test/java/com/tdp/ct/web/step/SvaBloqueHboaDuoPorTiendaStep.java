package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SvaBloqueHboaDuoPorTiendaStep {
    @Autowired
    private StepPages page;
    @ScreenShotAfter
    public void seleccionoBloqueHbo() {
        page.svaBloqueHboaDuoPorTiendaPage().seleccionoBloqueHbo();

    }

    public void guardarCambios() {
        page.svaBloqueHboaDuoPorTiendaPage().guardarCambios();
    }
}
