package com.tdp.ct.web.glue;

import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.HomeStep;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeStepDefinition {
    @Autowired
    private WebDriverManager manager;

    @Autowired
    private HomeStep homeStep;

    @Autowired
    private Customer customer;

    @Y("selecciono el tipo de documento {string}")
    public void seleccionoElTipoDeDocumento(String tipoDocumento) {
        System.out.println("Cliente: " +  customer.getCustomerTest());
        customer.setTypeDocument(tipoDocumento);
        homeStep.seleccionoTipoDocumento(tipoDocumento);
    }

    @Y("ingreso el documento {string}")
    public void ingresoElDocumento(String documento) {
        Customer.setNumberDocument(documento);
        homeStep.ingresoDocumento(documento);
    }

    @Y("doy click en el boton consultar")
    public void doyClickEnElBotonConsultar() {
        homeStep.clickBotonConsultar();
    }

    @Y("valido que el nombre del cliente sea {string} y su {string} sea {string}")
    public void validoQueElNombreDelClienteSeaYSuSea(String nombre, String tipoDocumento, String nroDocumento) {
        homeStep.validacionDeDatos(nombre,tipoDocumento,nroDocumento);
    }

    @Y("selecciono el ID de Cliente nro {string}")
    public void seleccionoElIDDeClienteNro(String nro) {
        homeStep.seleccionoElIDDeClienteNro(nro);
    }

    @Y("doy click en el boton Consultar")
    public void doyClickEnElBotonConsultarRuc() {
        homeStep.clickBtnConsultar();
    }

    @Y("valido que me traiga los servicios contratados por el cliente")
    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        homeStep.validoQueMeTraigaLosServiciosContratadosPorElCliente();
    }

    @Y("selecciono el tipo de documento {string} del Representante Legal")
    public void seleccionoElTipoDeDocumentoDelRepresentanteLegal(String tipDoc) {
        homeStep.seleccionoElTipoDeDocumentoDelRepresentanteLegal(tipDoc);
    }

    @E("ingreso el numero del documento {string} del Representante Legal")
    public void ingresoElNumeroDelDocumentoDelRepresentanteLegal(String numDoc) {
        homeStep.ingresoElNumeroDelDocumentoDelRepresentanteLegal(numDoc);
    }

    @Y("doy click en Validar Representa Legal")
    public void doyClickEnValidarRepresentaLegal() {
        homeStep.doyClickEnValidarRepresentaLegal();
    }

    @Y("cierro pop up de CU")
    public void cierroPopUpDeCU() {
        homeStep.clickXPopUpCU();
    }

}
