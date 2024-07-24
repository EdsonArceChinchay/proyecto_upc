package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.PortabilidadStep;
import com.tdp.ct.web.step.Portabilidad.ServiceTest;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class PortabilidadStepDefinition {

    @Autowired
    PortabilidadStep portabilidadStep;

    @Autowired
    AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    ServiceTest serviceTest;

    private String token;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

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
    public void validoLosServicios(DataTable dataTable) throws IOException {
        serviceTest.receiveMessage(dataTable);
    }

    @Y("doy tiempo extra")
    public void doyTiempoExtra() {
        UtilWeb.waitForSeconds(60);
    }

    @Y("doy click en el boton Porta Movil")
    public void doyClickEnElBotonPortaMovil() {
        portabilidadStep.clickPortaMovil();
    }

    @Y("valido que este activo el flag de Porta Directa")
    public void validoQueEsteActivoElFlagDePortaDirecta() throws JSONException {
        portabilidadStep.setValuePortaDirecta();
        portabilidadStep.getValuePortaDirecta();
        this.scenario.log(portabilidadStep.getValuePortaDirecta());
    }

    @Y("doy click en el boton Validar Codigo de Portabilidad")
    public void doyClickEnElBotonValidarCodigoDePortabilidad() {
        portabilidadStep.clickButtonCodigoDePorta();
    }

    @Y("doy click en {string} y doy click en el boton Confirmar")
    public void doyClickEnYDoyClickEnElBotonConfirmar(String nameButton) {
        portabilidadStep.selectButton(nameButton);
        portabilidadStep.clickButtonConfirmar();

    }

    @Y("obtengo el token")
    public void obtengoElToken(DataTable dataTable) throws IOException {
        String codigoDeVenta =altaFijaMovilRegistroStep.getSalesCode();
        token = serviceTest.getCodeToken(dataTable,codigoDeVenta);
        this.scenario.log("Token:" + token);
    }

    @Cuando("ingreso el token y doy click en el boton Confirmar")
    public void ingresoElTokenYDoyClickEnElBotonConfirmar() {
        portabilidadStep.inputToken(token);
        portabilidadStep.clickButtonConfirmar();
    }

    @Entonces("valido el mensaje {string} y doy click en el boton Continuar")
    public void validoElMensajeYDoyClickEnElBotonContinuar(String message) {
        portabilidadStep.validateMessage(message);
        portabilidadStep.clickButtonContinuar();

    }

}
