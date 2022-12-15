package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.PortabilidadStep;
import com.tdp.ct.web.step.ServiceTest;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class PortabilidadStepDefinition {

    @Autowired
    PortabilidadStep portabilidadStep;

    @Autowired
    ServiceTest serviceTest;

    @Y("doy click en el boton portabilidad")
    public void doyClickEnElBotonPortabilidad() {
        portabilidadStep.clickBotonPortabilidad();

    }

    @Y("ingreso numero de telefono para portar {string}")
    public void ingresoNumeroDeTelefonoParaPortar(String numero) {
        portabilidadStep.ingresarNumeroPortar(numero);
    }

    @Y("escojo tipo de linea {string}")
    public void escojoTipoDeLinea(String plan) {
        portabilidadStep.escogerTipoLinea(plan);
    }

    @Y("escojo tipo de operador {string}")
    public void escojoTipoDeOperador(String operador) {
        portabilidadStep.escogerTipoOperador(operador);
    }

    @Y("doy click en el boton Consultar Portabilidad")
    public void doyClickEnElBotonConsultarPortabilidad() {
        portabilidadStep.clickBotonConsultar();
    }

    @Y("valido los servicios")
    public void validoLosServicios() {
        serviceTest.login();
    }
}
