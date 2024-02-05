package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaPuraMTcallCenterStep;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class AltaPuraMTcallCenterStepDefinition {

    @Autowired
    private AltaPuraMTcallCenterStep altaPuraMTcallCenterStep;

    @Y("Consulto ubicacion")
    public void consultoUbicacion() {
        altaPuraMTcallCenterStep.clickConfirmoUbicacion();
    }

    @Y("selecciono horario {string}")
    public void seleccionoHorario(String horario) {
        altaPuraMTcallCenterStep.selectTipoHorario(horario);
    }

    @Y("completo id call {string}")
    public void completoIdCall(String idCall) {
        altaPuraMTcallCenterStep.completarIdCall(idCall);
    }

    @Y("Selecciono tipo de pago {string}")
    public void seleccionoTipoDePago(String tipo) {
        altaPuraMTcallCenterStep.selectTipoDePago(tipo);
    }

    @E("ingreso telefono del titular {string}")
    public void ingresoTelefonoDelTitular(String telefono) {
        altaPuraMTcallCenterStep.ingresoTelefono(telefono);
    }

    @E("ingreso instrucciones de delivery {string}")
    public void ingresoInstruccionesDeDelivery(String referencia) {
        altaPuraMTcallCenterStep.ingresarReferencia(referencia);
    }

    @E("ingreso correo de verificacion {string}")
    public void ingresoCorreoDeVerificacion(String verifCorreo) {
        altaPuraMTcallCenterStep.ingresarCorreoVerif(verifCorreo);
    }

//    TODO:
    @Y("doy click en el boton de continuar")
    public void doyClickEnElBotonDeContinuar() {
        altaPuraMTcallCenterStep.clicBotonContinuar();
    }

    @Y("cierro popup de error")
    public void cierroPopupDeError() {
        altaPuraMTcallCenterStep.clickCierrePopup();
    }
}
