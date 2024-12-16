package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.CheckoutStep;
import com.tdp.ct.web.step.PortabilityStep;
import com.tdp.ct.web.step.ServiceTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class PortabilityStepDefinition {

    @Autowired
    private PortabilityStep portabilityStep;

    @Autowired
    private CheckoutStep checkoutStep;

    @Autowired
    private ServiceTest serviceTest;

    private String token;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Y("doy click en el boton portabilidad")
    public void doyClickEnElBotonPortabilidad() {
        portabilityStep.clickBotonPortabilidad();
    }

    @Y("ingreso numero de telefono para portar {string}")
    public void ingresoNumeroDeTelefonoParaPortar(String phoneNumber) {
        portabilityStep.typePhoneNumber(phoneNumber);
    }

    @Y("escojo tipo de linea {string}")
    public void escojoTipoDeLinea(String plan) {
        portabilityStep.selectLineType(plan);
    }

    @Y("escojo tipo de operador {string}")
    public void escojoTipoDeOperador(String operador) {
        portabilityStep.selectOperatorType(operador);
    }

    @Y("doy click en el boton Consultar Portabilidad")
    public void doyClickEnElBotonConsultarPortabilidad() {
        portabilityStep.clickBotonConsultar();
    }

    @Y("valido el servicio prevalidateportin")
    public void validoLosServiciosPorta(DataTable dataTable) {
        serviceTest.serviceManager("prevalidateportin");
        serviceTest.receiveMessage(dataTable);
    }

    @Y("valido el servicio requestportin")
    public void validoLosServiciosPorta2(DataTable dataTable) {
        serviceTest.serviceManager("requestportin");
        serviceTest.receiveMessage(dataTable);
    }

    @Y("doy tiempo extra")
    public void doyTiempoExtra() {
        UtilWeb.waitForSeconds(60);
    }

    @Y("doy click en el boton Porta Movil")
    public void doyClickEnElBotonPortaMovil() {
        portabilityStep.clickPortaMovil();
    }

    @Y("valido que este activo el flag de Porta Directa")
    public void validoQueEsteActivoElFlagDePortaDirecta() {
        portabilityStep.setValuePortaDirecta();
        this.scenario.log(portabilityStep.getValuePortaDirecta());
    }

    @Y("doy click en el boton Validar Codigo de Portabilidad")
    public void doyClickEnElBotonValidarCodigoDePortabilidad() {
        portabilityStep.clickButtonCodigoDePorta();
    }

    @Y("doy click en {string} y doy click en el boton Confirmar")
    public void doyClickEnYDoyClickEnElBotonConfirmar(String nameButton) {
        portabilityStep.selectButton(nameButton);
        portabilityStep.clickButtonConfirm();
    }

    @Y("obtengo el token")
    public void getToken(DataTable dataTable) {
        token = serviceTest.getCodeToken(dataTable, checkoutStep.getSalesCode());
        this.scenario.log("Token:" + token);
    }

    @Cuando("ingreso el token y doy click en el boton Confirmar")
    public void ingresoElTokenYDoyClickEnElBotonConfirmar() {
        portabilityStep.inputToken(token);
        portabilityStep.clickButtonConfirm();
    }

    @Entonces("valido el mensaje {string} y doy click en el boton Continuar")
    public void validoElMensajeYDoyClickEnElBotonContinuar(String message) {
        portabilityStep.validateMessage(message);
        portabilityStep.clickButtonContinuar();
    }

    @Y("valido el servicio de status de portabilidad")
    public void validoElServicioDeStatusDePortabilidad(DataTable dataTable) {
        serviceTest.serviceManager("");
        serviceTest.receiveMessage(dataTable);
    }
}
