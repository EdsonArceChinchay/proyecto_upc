package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMonoInstalacionFtthTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void validarOfertasSugeridasView(String title) {
        page.altaMonoFtthTiendaPage().validarOfertasSugeridasView(title);
    }

}
