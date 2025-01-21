package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.step.DataClienteStep;
import io.cucumber.java.an.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;

public class DataClienteGlue {

    @Autowired
    private DataClienteStep dataClienteStep;
    @Autowired
    private Cliente cliente;

    String tipoDocumentoCliente;
    String numeroDocumentoCliente;

    @Y("selecciono el tipo documento {string}")
    public void seleccionoElTipoDeDocumento(String tipoDocumento) {
        tipoDocumentoCliente = tipoDocumento;
        dataClienteStep.seleccionoTipoDocumento(tipoDocumento);
    }

    @Y("ingreso el numero de documento {string}")
    public void ingresoElDocumento(String documento) {
        getScenarioContext().put("nroDocumento", documento);
        numeroDocumentoCliente = documento;
        dataClienteStep.ingresoNumDocumento(documento);
    }

    @Y("doy click al boton Cargar Mas")
    public void visualizarBtnCargarMas() {
        dataClienteStep.visualizarBtnCargarMas();
    }

    @Y("doy click al boton consultar")
    public void doyClickAlBotonConsultar() {
        dataClienteStep.clickBotonConsultar();
    }

    @Y("visualizo los planes del cliente")
    public void visualizoPlanesCliente() {
        dataClienteStep.visualizoPlanesCliente(tipoDocumentoCliente, numeroDocumentoCliente);
    }

    @Y("doy click al boton Continuar Login")
    public void clickBtnContinuar() {
        dataClienteStep.clickBtnContinuar();
    }

    @Y("visualizo los planes de {string} y {string}")
    public void visualizoMasPlanesCliente(String docs, String numers) {
        dataClienteStep.visualizoMasPlanesCliente(docs, numers);
    }
}