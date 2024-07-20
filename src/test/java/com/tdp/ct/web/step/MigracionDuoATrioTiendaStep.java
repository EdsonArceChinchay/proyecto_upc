package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class MigracionDuoATrioTiendaStep {

    @Autowired
    private StepPages page;

    public void seleccionPlanNuevoParaVerLasOfertas() {
        page.migracionDuoATrioTiendaPage().seleccionPlanNuevoParaVerLasOfertas();
    }

    public void seleccionoElTipoDePlanHogar(String planHogar) {
        page.migracionDuoATrioTiendaPage().seleccionoElTipoDePlanHogar(planHogar);
    }

    public void seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(String planTrio) {
        page.migracionDuoATrioTiendaPage().seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(planTrio);
    }

    public void luegoDoyClickEnLaCartillaCambiarPlanHogar() {
        page.migracionDuoATrioTiendaPage().luegoDoyClickEnLaCartillaCambiarPlanHogar();
    }

    public void scrollUp() {
        page.migracionDuoATrioTiendaPage().scrollUp();
    }


    public void clickButton(String nameButton) {
        page.migracionDuoATrioTiendaPage().clickButton(nameButton);
    }

    public void seleccionarboton(){
        page.migracionDuoATrioTiendaPage().seleccionarboton();
    }
}
