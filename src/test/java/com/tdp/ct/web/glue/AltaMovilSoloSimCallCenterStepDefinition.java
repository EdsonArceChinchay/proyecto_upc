package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaMovilSoloSimCallCenterStep;
import com.tdp.ct.web.step.CheckoutStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMovilSoloSimCallCenterStepDefinition {

    @Autowired
    private AltaMovilSoloSimCallCenterStep altaMovilSoloSimCallCenterStep;

    @Autowired
    private AltaFijaAltaMovilCallCenterStep altaFijaAltaMovilCallCenterStep;
    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Autowired
    private Customer customer;

    @Autowired
    private CheckoutStep checkoutStep;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Y("doy click en el boton Agregar SVA")
    public void seleccionoElBotonAgregarSva() {
        altaMovilSoloSimCallCenterStep.seleccionoElBotonAgregarSva();
    }

    @Y("valido que muestre el nombre completo del cliente {string}")
    public void valido_que_muestre_el_nombre_completo_del_cliente(String data) {
        if (!customer.isNewCustomer()) {
            altaFijaTiendaStep.validarNombresCompletosCliente(data);
        } else {
            logInfo("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("selecciono el tipo de plan movil {string}")
    public void selecciono_el_tipo_de_plan_movil(String tipoPlanMovil) {
        altaMovilSoloSimCallCenterStep.seleccionarListaTipoPlanMovil(tipoPlanMovil);
    }

    @Y("selecciono un plan movil {string}")
    public void selecciono_un_plan_movil(String planMovil) {
        altaMovilSoloSimCallCenterStep.seleccionarListaPlanMovil(planMovil);
        altaMovilSoloSimCallCenterStep.clickBotonSeleccionarOferta();
        altaFijaAltaMovilCallCenterStep.clickListaBotones();
    }

    @Y("selecciono la opcion {string}")
    public void seleccionoLaOpcion(String Tipo) {
        altaMovilSoloSimCallCenterStep.seleccionarPlan(Tipo);
    }

    @Y("valido que este en la seccion Postpago o Prepago")
    public void valido_que_este_en_seccion_Postpago_Prepago() {
        altaMovilSoloSimCallCenterStep.validarSeleccionaPostpagoPrepago();
    }

    @Y("selecciono añadir equipos")
    public void clickOnAddDevice() {
        altaMovilSoloSimCallCenterStep.clickOnAddDevice();
    }

    @Y("doy click en el boton seleccionar oferta")
    public void doyClickEnElBotonSeleccionarOferta() {
        altaMovilSoloSimCallCenterStep.doyClickEnElBotonSeleccionarOferta();
    }

    @Y("presiona el boton anadir equipo")
    public void presionaElBotonAnadirEquipo() {
        altaMovilSoloSimCallCenterStep.clickOnAddDevice(2);
    }

    @Y("presiona el boton anadir equipo del mismo plan")
    public void presionaElBotonAnadirEquipoDelMismoPlan() {
        altaMovilSoloSimCallCenterStep.clickOnAddDevice(1);
    }

    @Y("selecciono boton mantener plan")
    public void seleccionoBotonMantenerPlan() {
        altaMovilSoloSimCallCenterStep.btnMantenerPlan();
    }

    @Y("selecciono boton Cambiar plan")
    public void seleccionoBotonCambiarPlan() {
        altaMovilSoloSimCallCenterStep.clickBotonCambiarPlan();
    }

    @Y("valido que CAEQ:{string}, CAPL: {string} y CASI:{string} en el response del salesLead")
    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI) {
        String salesCode = checkoutStep.getSalesCode();
        salesCode = salesCode == null ? customer.getSalesCode() : salesCode;
        this.scenario.log("[Código de Venta: " + salesCode + "]");
        altaMovilSoloSimCallCenterStep.validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, altaMovilSoloSimCallCenterStep.getSalesLead(salesCode));
        this.scenario.log(altaMovilSoloSimCallCenterStep.getSalesLead(salesCode).toString());
    }

}
