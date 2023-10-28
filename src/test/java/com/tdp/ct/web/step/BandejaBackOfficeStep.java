package com.tdp.ct.web.step;

import com.tdp.ct.web.CaptchaBase.Util;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BandejaBackOfficeStep {

    @Autowired
    private StepPages page;
    @Autowired
    private Cliente cliente;

    @ScreenShotAfter
    public void clickBackOffice() {
    page.bandejaBackOfficePage().clickBackOffice();
    }

    public void ingresoDocumento(String documento) {
        page.bandejaBackOfficePage().ingresoDocumento(documento);
        page.bandejaBackOfficePage().buscoDocumento();
    }
    public void seleccionoSolicitud(String numeroSolicitud){
        page.bandejaBackOfficePage().seleccionoSolicitud(numeroSolicitud);
    }
    @ScreenShotAfter
    public void abrirPopUpCargaAudio() {
        page.bandejaBackOfficePage().abrirPopUpCargaAudio();
    }
    @ScreenShotAfter
    public void cargarAudio(){
        page.bandejaBackOfficePage().cargarAudio();
    }
    @ScreenShotAfter
    public void aprueboSolicitud() throws InterruptedException {
        page.bandejaBackOfficePage().aprueboSolicitud();
    }
}
