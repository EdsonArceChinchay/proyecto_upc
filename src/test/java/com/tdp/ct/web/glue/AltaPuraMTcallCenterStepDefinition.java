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
        altaPuraMTcallCenterStep.selectTipoHorario();
    }

    @Y("completo id call {string}")
    public void completoIdCall(String idCall) {
        altaPuraMTcallCenterStep.completarIdCall(idCall);
    }

}
