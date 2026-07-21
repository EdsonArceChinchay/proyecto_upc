package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.RetentionService;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import com.tdp.ct.web.step.HomeStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;
import static com.tdp.ct.web.utils.LogUtils.logInfo;

public class HomeStepDefinition {

    public final ThreadLocal<Agent> agent = ThreadLocal.withInitial(Agent::new);

    @Autowired
    private HomeStep homeStep;
    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;
    @Autowired
    private RetentionService retentionService;
    @Autowired
    private Customer customer;
    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    private void executeIfNotRetention(Runnable action) {
        if (retentionService.isRetention()) {
            scenario.log("This step is skipped - Is retention");
            return;
        }
        action.run();
    }

    @Y("valido que se presente el canal {string}")
    public void validoQueSePresenteLaTienda(String channelType) {
        homeStep.validateAgentData(agent.get(), channelType);
        scenario.log(agent.get().print());
    }

    @Y("selecciono el tipo de documento {string}")
    public void seleccionoElTipoDeDocumento(String customerDocumentType) {
        //logInfo("Cliente: " + customer.getCustomerTest());
        //getScenarioContext().put("tipoDocumento", customerDocumentType);
        //  customer.setDocumentType(customerDocumentType);
        homeStep.selectDocumentType(customerDocumentType);
    }

    @Y("ingreso el documento {string}")
    public void ingresoElDocumento(String customerDocumentNumber) {
        getScenarioContext().put("nroDocumento", customerDocumentNumber);
        customer.setDocumentNumber(customerDocumentNumber);
        //homeStep.typeDocumentNumber(customerDocumentNumber);
        homeStep.typeDocumentNumber1(customerDocumentNumber);
    }

    @Y("me dirijo a la bandeja de Back Office")
    public void meDirijoALaBandejaDeBackOffice() {
        executeIfNotRetention(() -> homeStep.clickOnTheBackOfficeButton());
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
        homeStep.confirmSignOut();
    }

    @Y("valido que el nombre del cliente sea {string} y su {string} sea {string}")
    public void validoQueElNombreDelClienteSeaYSuSea(String customerName, String customerDocumentType, String customerDocumentNumber) {
        homeStep.validateCustomerData(customerName, customerDocumentType, customerDocumentNumber);
    }

    @Y("selecciono el ID de Cliente nro {string}")
    public void seleccionoElIDDeClienteNro(String id) {
        homeStep.selectCustomerId(id);
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

    @Y("doy click en el boton Consultar")
    public void doyClickEnElBotonConsultar() {
        homeStep.clickOnConsultButton();
    }
}