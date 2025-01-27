package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataClienteStep {

    @Autowired
    private StepPages page;

    public void clickBtnContinuar() {
        page.temporalPage().clickBtnContinuar();
    }

    public void seleccionoTipoDocumento(String tipoDocumento) {
        page.temporalPage().seleccionoTipoDocumento(tipoDocumento);
    }

    public void ingresoNumDocumento(String documento) {
        page.temporalPage().ingresoNumDocumento(documento);
    }

    public void visualizarBtnCargarMas() {
        page.temporalPage().visualizarBtnCargarMas();
    }

    public void clickBotonConsultar() {
        page.temporalPage().clickBotonConsultar();
    }

    public void visualizoPlanesCliente(String tipoDocumentoCliente, String numeroDocumentoCliente) {
        page.temporalPage().visualizoPlanesCliente(tipoDocumentoCliente, numeroDocumentoCliente);
    }

    public void visualizoMasPlanesCliente(String docs, String numers) {
        page.temporalPage().visualizoMasPlanesCliente(docs, numers);
    }

    public void visualizoMasPlanesClienteWhiteList() {
        page.temporalPage().visualizoMasPlanesClienteWhiteList();
    }
}