package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MigraSalto0RetailStep {
    @Autowired
    StepPages page;
    @ScreenShotBefore
    public void SeleccionarBtnMigrarFibra() {
        page.migraSalto0RetailPage().SeleccionarBtnMigrarFibra();
    }

    public void clickBotonEntendido() {
        page.migraSalto0RetailPage().clickBotonEntendido();
    }

    @ScreenShotAfter
    public void validateTagUVSC(String value) {
        page.migraSalto0RetailPage().validateTagUVSC(value);
    }
    @ScreenShotAfter
    public void validateCurrentAndNewPrice() {
        page.migraSalto0RetailPage().validateCurrentAndNewPrice();
    }
    @ScreenShotBefore
    public void seleccionoCartillaPlanMT() {
        page.migraSalto0RetailPage().seleccionoCartillaPlanMT();
    }

    @ScreenShotAfter
    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        page.migraSalto0RetailPage().validoQueSePresenteElSiguienteMensaje(mensaje);
    }
}
