package com.tdp.ct.web.glue;

import com.tdp.ct.web.CaptchaBase.Parameters;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaMovilRegistroStepDefinition {

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    private Customer customer;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Entonces("me muestra la pantalla de ofertas sugeridos")
    public void meMuestraLaPantallaDeOfertasSugeridos() {
        altaFijaMovilRegistroStep.mostrarDetalleOfertasSugeridas();
    }

    @Y("selecciono el tipo de oferta {string}")
    public void seleccionoElTipoDeOferta(String oferta) {
        altaFijaMovilRegistroStep.seleccionarOferta(oferta);
    }

    @Y("me muestra pantalla para Descargar contrato")
    public void meMuestraPantallaParaDescargarContrato() {
        altaFijaMovilRegistroStep.mostrarPantallaDescargarContrato();
    }

    @Y("presiono el boton descargar contrato")
    public void presiono_el_boton_descargar_contrato() {
        altaFijaTiendaStep.clickDescargarContrato();
        altaFijaTiendaStep.clickDescargarPdf();
        altaFijaTiendaStep.cambiarPestanaPrincipal();
        altaFijaTiendaStep.clickCerrarPopUp();
    }

    @Y("doy clic para descargar el contrato")
    public void doyClicParaDescargarElContrato() {
        if (Parameters.estadoFlujo) {
            altaFijaMovilRegistroStep.clicDescargarContrato();
        }
    }

    @Entonces("me muestra la pantalla registrar venta")
    public void meMuestraLaPantallaParaRegistrarVenta() {
        altaFijaMovilRegistroStep.validarPantallaRegistrarVenta();
    }

    @Y("doy clic en Registrar venta")
    public void doyClicEnRegistrarVenta() {
        altaFijaTiendaStep.clickRegistrarVenta();
    }

    @Y("presiono el boton Registrar venta")
    public void presiono_el_boton_Registrar_venta() {
        altaFijaTiendaStep.clickRegistrarVenta();
    }

    @Y("presiono en el boton de Registrar Venta")
    public void presionoEnElBotonDeRegistrarVenta() {
        altaFijaTiendaStep.clickBotonRegistrarVenta();
    }

    @Entonces("visualizo en pantalla el mensaje de exito de la venta generada")
    public void visualizoEnPantallaElMensajeDeExitoDeLaVentaGenerada() {
        altaFijaMovilRegistroStep.validarVentaGenerada();
        this.scenario.log("[Código de Venta: " + altaFijaMovilRegistroStep.getSalesCode() + "]");
        this.scenario.log(this.customer.getOrdersCode().toString());
    }

}
