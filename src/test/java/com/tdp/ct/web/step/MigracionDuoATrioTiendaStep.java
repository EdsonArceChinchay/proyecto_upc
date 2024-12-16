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
        scrollUp();
    }

    public void clickButton(String nameButton) {
        page.migracionDuoATrioTiendaPage().clickButton(nameButton);
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
    public void SeleccionarBtnMigrarFibra() {
        page.migracionDuoATrioTiendaPage().SeleccionarBtnMigrarFibra();
    }

    @ScreenShotAfter
    public void validateTagUVSC(String value) {
        page.migracionDuoATrioTiendaPage().validateTagUVSC(value);
    }

    @ScreenShotAfter
    public void validateCurrentAndNewPrice() {
        page.migracionDuoATrioTiendaPage().validateCurrentAndNewPrice();
    }

}
