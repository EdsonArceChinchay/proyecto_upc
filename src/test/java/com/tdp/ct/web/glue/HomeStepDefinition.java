package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.HomeStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeStepDefinition {

    @Autowired
    private HomeStep homeStep;

    @Autowired
    private Customer customer;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Entonces("valido el login exitoso mediante el mensaje {string}")
    public void validoElLoginExitosoMedianteElMensaje(String msg) {
        homeStep.validateHomeMessage(msg);
    }

    @Y("valido que se presente el canal {string}")
    public void validoQueSePresenteLaTienda(String tienda) {
        homeStep.validateStoreType(tienda);
        this.scenario.log(homeStep.getAgentData());
    }

    @Y("selecciono el tipo de documento {string}")
    public void seleccionoElTipoDeDocumento(String tipoDocumento) {
        System.out.println("Cliente: " +  customer.getCustomerTest());
        customer.setTypeDocument(tipoDocumento);
        homeStep.selectDocumentType(tipoDocumento);
    }

    @Y("ingreso el documento {string}")
    public void ingresoElDocumento(String documento) {
        Customer.setNumberDocument(documento);
        homeStep.typeDocumentNumber(documento);
    }

    @Y("doy click en el boton Consultar")
    public void doyClickEnElBotonConsultar() {
        homeStep.clickOnConsultButton();
    }

    @Y("me dirijo a la bandeja de Back Office")
    public void meDirijoALaBandejaDeBackOffice() {
        homeStep.clickOnTheBackOfficeButton();
    }

    @Dado("regreso a la pagina de inicio")
    public void regresoPaginaInicio() {
        homeStep.backToHomePage();
    }

    @Y("doy click en el icono de Asesor")
    public void doyClickEnElIconoDeAsesor() {
        homeStep.clickOnTheAdvisorIcon();
    }

    @Y("doy click en Cerrar Sesion")
    public void doyClickEnCerrarSesion() {
        homeStep.clickOnTheLogoutButton();
    }

    @Y("doy click en Atras")
    public void doyClickEnAtras() {
        homeStep.ClickOnBackButton();
    }

    @Y("confirmo Cerrar Sesion")
    public void confirmoCerrarSesion() {
        homeStep.confirmoCerrarSesion();
    }

    @Y("valido que el nombre del cliente sea {string} y su {string} sea {string}")
    public void validoQueElNombreDelClienteSeaYSuSea(String nombre, String tipoDocumento, String nroDocumento) {
        homeStep.validateCustomerData(nombre,tipoDocumento,nroDocumento);
    }

    @Y("selecciono el ID de Cliente nro {string}")
    public void seleccionoElIDDeClienteNro(String nro) {
        homeStep.selectCustomerId(nro);
        homeStep.clickOnSaveButton();
    }

    @Y("valido que me traiga los servicios contratados por el cliente")
    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        homeStep.validoQueMeTraigaLosServiciosContratadosPorElCliente();
    }

    @Y("selecciono el tipo de documento {string} del Representante Legal")
    public void seleccionoElTipoDeDocumentoDelRepresentanteLegal(String documentType) {
        homeStep.selectTheTypeOfDocumentOfTheLegalRepresentative(documentType);
    }

    @E("ingreso el numero de documento {string} del Representante Legal")
    public void ingresoElNumeroDelDocumentoDelRepresentanteLegal(String numDoc) {
        homeStep.typeTheDocumentNumberOfTheLegalRepresentative(numDoc);
    }

    @Y("doy click en Validar Representa Legal")
    public void doyClickEnValidarRepresentaLegal() {
        homeStep.clickOnTheValidateLegalRepresentativeButton();
    }

    @Y("cierro pop up de CU")
    public void cierroPopUpDeCU() {
        homeStep.clickXPopUpCU();
    }
}
