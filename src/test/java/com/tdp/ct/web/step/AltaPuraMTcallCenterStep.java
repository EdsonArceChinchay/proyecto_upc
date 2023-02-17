package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaPuraMTcallCenterStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickConfirmoUbicacion(){
        UtilWeb.waitForSeconds(3);
        page.altaPuraMTcallCenterPage().btnConfirmarUbicacion();
    }
    @ScreenShotAfter
    public void selectTipoHorario(String horaio){
        UtilWeb.waitForSeconds(3);
        page.altaPuraMTcallCenterPage().selectTipoHorario(horaio);
    }

    @ScreenShotAfter
    public void completarIdCall(String idCall){
        page.altaPuraMTcallCenterPage().completarIdCall(idCall);
    }

    @ScreenShotAfter
    public void selectTipoDePago(String tipo){
        page.altaPuraMTcallCenterPage().selectTipoDePago(tipo);
    }

    @ScreenShotAfter
    public void ingresarReferencia(String  referencia){
        page.altaPuraMTcallCenterPage().ingresarReferencia(referencia);
    }

    @ScreenShotAfter
    public void ingresarCorreoVerif(String verifCorreo){
        page.altaPuraMTcallCenterPage().ingresarCorreoVerif(verifCorreo);
    }

    @ScreenShotBefore
    public void clicBotonContinuar(){
        UtilWeb.waitForSeconds(15);
        page.altaPuraMTcallCenterPage().clicBotonContinuar();
        UtilWeb.waitForSeconds(200);//15
    }

    @ScreenShotBefore
    public void clickCierrePopup(){
        page.altaPuraMTcallCenterPage().clickCierrePopup();
    }

    @ScreenShotAfter
    public void ingresoTelefono(String telefono) {
       page.altaPuraMTcallCenterPage().ingresarTelefono(telefono);
    }
}
