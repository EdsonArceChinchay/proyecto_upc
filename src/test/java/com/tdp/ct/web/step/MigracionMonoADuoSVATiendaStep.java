package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigracionMonoADuoSVATiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionarboton(){
        page.MigracionMonoADuoSVATiendaPage().seleccionarboton();
    }

    public void clicEnAgregarSVA() {
        page.MigracionMonoADuoSVATiendaPage().clicEnAgregarSVA();

    }

    public void agregoSVATV(String Bloques) {
        page.MigracionMonoADuoSVATiendaPage().SeleccionoBloques(Bloques);
    }

    public void clicGuardarCambios() {
        page.MigracionMonoADuoSVATiendaPage().clickGuardarCambios();
    }
}
