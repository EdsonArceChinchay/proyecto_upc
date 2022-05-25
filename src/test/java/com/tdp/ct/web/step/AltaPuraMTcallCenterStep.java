package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.service.util.UtilWeb.getValueFromDataTable;

@ScreenShot
@Component
public class AltaPuraMTcallCenterStep {

    @Autowired
    private StepPages page;

    public void clickConfirmoUbicacion(){
        UtilWeb.waitForSeconds(3);
        page.altaPuraMTcallCenterPage().btnConfirmarUbicacion();
    }

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
    public void ingresoDireccionTT(String direccion){
        page.altaPuraMTcallCenterPage().ingresoDireccionTT(direccion);
    }

    @ScreenShotAfter
    public void ingresarReferencia(String  referencia){
        page.altaPuraMTcallCenterPage().ingresarReferencia(referencia);
    }

    @ScreenShotAfter
    public void ingresarCorreoVerif(String verifCorreo){
        page.altaPuraMTcallCenterPage().ingresarCorreoVerif(verifCorreo);
    }

    @ScreenShotAfter
    public void clicBotonContinuar(){
        page.altaPuraMTcallCenterPage().clicBotonContinuar();
    }

    public void clickCierrePopup(){
        page.altaPuraMTcallCenterPage().clickCierrePopup();
    }

}
