package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.service.RetentionService;
import com.tdp.ct.web.step.CheckoutStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;

public class CheckoutStepDefinition {

    @Autowired
    private CheckoutStep checkoutStep;

    @Autowired
    private Cliente cliente;
    private Scenario scenario;
    @Autowired
    private RetentionService retentionService;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    private void executeIfRetention(Runnable action) {
        String productType = checkoutStep.getProductType();
        if (retentionService.isRetention() && productType.equals("MT")) {
            action.run();
        }
    }

    @Y("me muestra pantalla para Descargar contrato")
    public void meMuestraPantallaParaDescargarContrato() {
        checkoutStep.mostrarPantallaDescargarContrato();
    }

    @Y("presiono el boton descargar contrato")
    public void presiono_el_boton_descargar_contrato() {
        checkoutStep.clickDescargarContrato();
        checkoutStep.clickDescargarPdf();
        checkoutStep.cambiarPestanaPrincipal();
        checkoutStep.clickCerrarPopUp();
    }

    @Y("doy clic para descargar el contrato")
    public void doyClicParaDescargarElContrato() {
        checkoutStep.clicDescargarContrato();
    }

    @Entonces("me muestra la pantalla registrar venta")
    public void meMuestraLaPantallaParaRegistrarVenta() {
        checkoutStep.validarPantallaRegistrarVenta();
    }

    @Y("doy click en el boton Registrar venta")
    public void doyClicEnRegistrarVenta() {
        checkoutStep.clickRegistrarVenta();
    }

    @Y("presiono en el boton de Registrar Venta")
    public void presionoEnElBotonDeRegistrarVenta() {
        checkoutStep.clickBotonRegistrarVenta();
    }

    @Entonces("visualizo en pantalla el mensaje de exito de la venta generada")
    public void visualizoEnPantallaElMensajeDeExitoDeLaVentaGenerada() {
        executeIfRetention(() -> checkoutStep.clickBotonRegistrarVenta());
        checkoutStep.validateTheBillingCycle();
        checkoutStep.validateRegistrationHasBeenSuccessful();
        this.scenario.log("[Código de Venta: " + checkoutStep.getSalesCode() + "]");
        this.scenario.log(checkoutStep.getOrderCode());

        System.out.println("Orden Generada: " + checkoutStep.getOrderCode());
        System.out.println("Plan Seleccionado: " + cliente.getPlanSeleccionado());
        System.out.println("Num Documento: " + getScenarioContext().get("nroDocumento"));
        this.scenario.log("Num Documento: " +getScenarioContext().get("nroDocumento"));
        this.scenario.log("Orden Generada: " + checkoutStep.getOrderCode());
        this.scenario.log("Plan Seleccionado: " + cliente.getPlanSeleccionado());

        String fullText = checkoutStep.getOrderCode();
        String[] splitText = fullText.split(": ");
        String orderCode = splitText[1];
        getScenarioContext().put("orden", orderCode);
    }

    @Y("doy click en ver detalle del pedido")
    public void doyClickenVerDetalleDelPedido() {
        checkoutStep.doyClickenVerDetalleDelPedido();
    }

    @Y("valido que se muestre el detalle del pedido de {string}")
    public void validoQueSeMuestreElDetalleDelPedido(String service) {
        checkoutStep.ValidoQuePresenteDetallePedido(service);
    }

    @Entonces("visualizo en pantalla el mensaje de exito del ticket generado")
    public void visualizoEnPantallaElMensajeDeExitoDelTicketGenerado() {
        checkoutStep.validateTheBillingCycle();
        checkoutStep.validateRegistrationHasBeenSuccessful();
        checkoutStep.validateTicket();
        this.scenario.log("[Código de Venta: " + checkoutStep.getSalesCode() + "]");
    }
}
