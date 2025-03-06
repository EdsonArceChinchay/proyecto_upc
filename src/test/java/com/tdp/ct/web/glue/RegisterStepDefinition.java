package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.RetentionService;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.RegisterStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

public class RegisterStepDefinition {

    private static boolean isActiveValidateIdentity = false;
    @Autowired
    private RegisterStep registerStep;
    @Autowired
    private Customer customer;
    @Autowired
    private RetentionService retentionService;
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

    @Y("valido que este en la seccion completa los datos solicitados")
    public void valido_que_este_en_seccion_completa_los_datos_solicitados() {
        registerStep.validarCompletaDatosSolicitados();
    }

    @Y("selecciono el metodo de pago {string}")
    public void selecciono_el_metodo_de_pago(String metodoPago) {
        registerStep.selectMethodPayment(metodoPago);
    }

    @Y("ingreso correo electronico {string}")
    public void ingresoCorreo(String email) {
        registerStep.typeEmail(email);
    }

    @Y("ingreso nuevamente el correo electronico {string}")
    public void ingreso_nuevamente_el_correo_electronico(String email) {
        registerStep.typeConfirmEmail(email);
    }

    @Y("ingreso call id {string}")
    public void ingresoCallID(String callId) {
        registerStep.typeIdCall(callId);
    }

    @Y("doy click en datos del cliente")
    public void doyClickEnDatosDelCliente() {
        if (customer.isNewCustomer()) {
            registerStep.waitButtonCustomerData();
            registerStep.clickButtonCustomerData();
        } else {
            logInfo("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("completo los datos del cliente")
    public void completoLosDatosSolicitados(DataTable dataTable) {
        if (customer.isNewCustomer()) {
            registerStep.ingresarDatosCliente(dataTable);
        } else {
            logInfo("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("selecciono completar los datos del cliente")
    public void selecciono_completar_los_datos_del_cliente(DataTable datosCliente) {
        if (customer.isNewCustomer()) {
            registerStep.completoDatosCliente(datosCliente);
        } else {
            logInfo("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("doy click en el boton confirmar")
    public void doyClickEnElBotonConfirmar() {
        if (customer.isNewCustomer()) {
            registerStep.clickBotonConfirmar();
        } else {
            logInfo("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("Selecciono tipo de pago {string}")
    public void seleccionoTipoDePago(String type) {
        registerStep.selectTipoDePago(type);
    }

    @Y("doy click en el boton Continuar")
    public void doyClicEnContinuar() {
        registerStep.clicBotonContinuar();
    }

    @Y("doy click en validar identidad del titular")
    public void doyClickEnValidarIdentidadDelTitular() {
        logInfo("###############################");
        logInfo("SE INGRESA A VALIDAR IDENTIDAD DEL TITULAR");
        logInfo("###############################");
        executeIfNotRetention(() -> {
            registerStep.clickOnTheValidateHolderIdentityButton();
            isActiveValidateIdentity = registerStep.hasIdentityValidationError();
            if (isActiveValidateIdentity) {
                registerStep.clickOnButtonConfirm();
            }
        });
        logInfo("###############################");
        logInfo("SE TERMINO DE VALIDAR IDENTIDAD DEL TITULAR");
        logInfo("###############################");
    }

    @Y("elijo el tipo de validacion a realizar {string}")
    public void elijoElTipoDeValidacionARealizar(String tipoValidacion) {
        registerStep.seleccionoTipoValidacion(tipoValidacion);
    }

    @Y("ingreso los datos del supervisor")
    public void ingresoLosDatosDelSupervisor() {
        registerStep.ingresarDatosSupervisor();
        registerStep.clicConfirmarUsuarioSupervisor();
    }

    @Y("ingreso los datos solicitados para la validacion del cliente")
    public void ingresoLosDatosSolicitadosParaLaValidacionDelCliente(DataTable datos) {
        executeIfNotRetention(() -> {
            if (!isActiveValidateIdentity) {
                for (int i = 0; i < 3; i++) {
                    logInfo("###############################");
                    logInfo("SE INGRESA A FORMULARIO N°" + i);
                    logInfo("###############################");
                    registerStep.ingresarDatosValidacionSolicitada(datos, i);
                    logInfo("-- click en siguiente --");
                    registerStep.clicEnSiguiente();
                    logInfo("###############################");
                    logInfo("SE TERMINO FORMULARIO N°" + i);
                    logInfo("###############################");
                }
                logInfo("----- termino preguntas ----------");
                registerStep.clicEnConfirmar();
            } else {
                scenario.log("This step is skipped");
            }
        });
    }

    @Entonces("valido que me muestre el boton con el texto de identidad validada")
    public void validoQueMeMuestreElBotonConElTextoDeIdentidadValidada() {
        executeIfNotRetention(() -> {
            if (!isActiveValidateIdentity) {
                registerStep.validarIdentidadValidada();
            } else {
                scenario.log("This step is skipped");
            }
        });
    }

    @Y("doy click en Validar contrato {string}")
    public void doyClicParaValidarContrato(String name) {
        registerStep.clicValidarContrato();
    }

    @Y("me muestra en pantalla el contrato solicitado")
    public void meMuestraEnPantallaElContratoSolicitado() {
        registerStep.visualizarContratoEnPantalla();
    }

    @Y("imprimo el texto del contrato solicitado")
    public void imprimoElTextoDelContratoSolicitado() {
        this.scenario.log(registerStep.getSummary());
        this.scenario.log("[Código de Venta: " + registerStep.getSalesCode() + "]");
    }

    @Cuando("doy clic en si acepto")
    public void doyClicEnSiAcepto() {
        registerStep.clicSiAcepto();
    }

    @Y("doy click en discapacitado o huella desgastado")
    public void doyClickEnDiscapacitadoOHuellaDesgastado() {
        registerStep.clickDiscapacitadoHuellaDesgastado();
    }

    @Y("selecciono tipo de documento del supervisor {string}")
    public void selectSupervisorDocumentType(String type) {
        registerStep.selectSupervisorDocumentType(type);
    }

    @Y("ingreso el numero de documento del supervisor {string}")
    public void typeSupervisorDocumentNumber(String number) {
        registerStep.typeSupervisorDocumentNumber(number);
    }

    @Y("ingreso usuario citrix de supervisor {string}")
    public void typeSupervisorUser(String user) {
        registerStep.typeSupervisorUser(user);
    }

    @Y("ingreso contraseña de supervisor {string}")
    public void typeSupervisorPassword(String password) {
        registerStep.typeSupervisorPassword(password);
    }

    @Y("doy click en el boton validar identidad representante legal")
    public void doyClicEnElBotonValidarIdentidadRepresentanteLegal() {
        registerStep.clickBotonValidarRepreLegal();
    }

    @Y("doy click en Finalizar registro")
    public void clickOnTheFinishRegistrationButton() {
        registerStep.clickOnTheFinishRegistrationButton();
    }

    /**
     * FUNCION CLICK BOTON CONTINUAR
     * */

    @Y("doy click en el boton de continuar")
    public void doyClickEnElBotonDeContinuar() {
        registerStep.clickButtonContinue();
    }
}
