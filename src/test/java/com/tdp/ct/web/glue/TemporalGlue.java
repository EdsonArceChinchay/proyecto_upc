package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.step.TemporalStep;
import io.cucumber.java.an.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;

public class TemporalGlue {

    @Autowired
    private TemporalStep temporalStep;
    @Autowired
    private Cliente cliente;

    String tipoDocumentoCliente;
    String numeroDocumentoCliente;

    @Y("selecciono el tipo documento {string}")
    public void seleccionoElTipoDeDocumento(String tipoDocumento) {
        tipoDocumentoCliente = tipoDocumento;
        temporalStep.seleccionoTipoDocumento(tipoDocumento);
    }

    @Y("ingreso el numero de documento {string}")
    public void ingresoElDocumento(String documento) {
        getScenarioContext().put("nroDocumento", documento);
        numeroDocumentoCliente = documento;
        temporalStep.ingresoNumDocumento(documento);
    }

    @Y("doy click al boton Cargar Mas")
    public void visualizarBtnCargarMas() {
        temporalStep.visualizarBtnCargarMas();
    }

    @Y("doy click al boton consultar")
    public void doyClickAlBotonConsultar() {
        temporalStep.clickBotonConsultar();
    }

    @Y("visualizo los planes del cliente")
    public void visualizoPlanesCliente() {
        temporalStep.visualizoPlanesCliente(tipoDocumentoCliente, numeroDocumentoCliente);
    }

    @Y("doy click al boton Continuar Login")
    public void clickBtnContinuar() {
        temporalStep.clickBtnContinuar();
    }

    @Y("visualizo los planes de {string} y {string}")
    public void visualizoMasPlanesCliente(String docs, String numers) {
        temporalStep.visualizoMasPlanesCliente(docs, numers);
    }
}