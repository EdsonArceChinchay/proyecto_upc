package com.tdp.ct.web.step.migracion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigraTrioaMTcanalCallCenterStep {
    @Autowired
    StepPages page;

    @ScreenShotBefore
    public void seleccionoPlanMovistarTotal() {
        page.migraTrioaMTcanalCallCenterPage().seleccionoPlanMovistarTotal();

    }
    public void scrollUp() {
        page.migracionDuoATrioTiendaPage().scrollUp();
    }

    @ScreenShotBefore
    public void seleccionoPlandeOferta() {
        page.migraTrioaMTcanalCallCenterPage().seleccionoPlandeOferta();
    }
    @ScreenShotBefore
    public void clickBotonSeleccionarOferta() {
        page.migraTrioaMTcanalCallCenterPage().clickBotonSeleccionarOferta();
    }
    @ScreenShotBefore
    public void clickBtnIrMovistarTotal() {
        page.migraTrioaMTcanalCallCenterPage().clickBtnIrMovistarTotal();
    }
    @ScreenShotBefore
    public void clickFinalizarRegistro() {
        page.migraTrioaMTcanalCallCenterPage().clickFinalizarRegistro();
    }
}
