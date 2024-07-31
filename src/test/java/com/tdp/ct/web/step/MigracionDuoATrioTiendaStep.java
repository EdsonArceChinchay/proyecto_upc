package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
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

    public void scrollUp() {
        page.migracionDuoATrioTiendaPage().scrollUp();
    }

    public void clickButton(String nameButton) {
        page.migracionDuoATrioTiendaPage().clickButton(nameButton);
    }

    public void seleccionarboton() {
        page.migracionDuoATrioTiendaPage().seleccionarboton();
    }

    @ScreenShotBefore
    public void seleccionoPlanMovistarTotal() {
        page.migracionDuoATrioTiendaPage().seleccionoPlanMovistarTotal();
    }

    @ScreenShotBefore
    public void seleccionoPlandeOferta() {
        page.migracionDuoATrioTiendaPage().seleccionoPlandeOferta();
    }

    @ScreenShotBefore
    public void clickBotonSeleccionarOferta() {
        page.migracionDuoATrioTiendaPage().clickBotonSeleccionarOferta();
    }

    @ScreenShotBefore
    public void clickBtnIrMovistarTotal() {
        page.migracionDuoATrioTiendaPage().clickBtnIrMovistarTotal();
    }

    @ScreenShotBefore
    public void clickFinalizarRegistro() {
        page.migracionDuoATrioTiendaPage().clickFinalizarRegistro();
    }
}
