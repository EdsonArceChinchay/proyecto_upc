package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaMovilPostpagoCallCenterStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMovilPostpagoCallCenterStepDefinition {

    @Autowired
    private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;
    @Autowired
    private AltaMovilPostpagoCallCenterStep altaMovilPostpagoCallCenterStep;

    @Autowired
    private Cliente cliente;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Y("selecciono la opcion {string}")
    public void seleccionoLaOpcion(String Tipo) {
        altaMovilPostpagoCallCenterStep.seleccionarPlan(Tipo);
    }

    @Y("selecciono añadir equipos")
    public void seleccionoAñadirEquipos() {
        altaMovilPostpagoCallCenterStep.seleccionarEquipo();
    }

    @Y("ingreso el tiempo de permanencia{string}")
    public void ingresoElTiempoDePermanencia(String TiempoP) {
        altaMovilPostpagoCallCenterStep.seleccionarTiempo(TiempoP);
    }

    @Y("busco el equipo {string}")
    public void seleccionoElEquipo(String BuscarE) {
        altaMovilPostpagoCallCenterStep.BuscarEquipo(BuscarE);
    }

    @Y("selecciono el boton de eleccion de planes")
    public void seleccionoElBotonDeEleccionDePlanes() {
        altaMovilPostpagoCallCenterStep.BtonOpciones();
    }

    @Y("selecciono el plan movil {string}")
    public void seleccionoElPlanMovil(String tipoPlan) {
        altaMovilPostpagoCallCenterStep.seleccionoElPlanMovil(tipoPlan);
    }

    @Y("selecciono la cartilla Linea Nueva")
    public void seleccionoLaCartillaLineaNueva() {
        altaMovilPostpagoCallCenterStep.seleccionoLaCartillaLineaNueva();
    }

    @Y("doy click en el boton seleccionar oferta")
    public void doyClickEnElBotonSeleccionarOferta() {
        altaMovilPostpagoCallCenterStep.doyClickEnElBotonSeleccionarOferta();
    }

    @Y("doy click en el boton seleccionar")
    public void doyClickEnElBotonSeleccionar() {
        altaMovilPostpagoCallCenterStep.doyClickEnElBotonSeleccionar();
    }

    @Y("doy click en iniciar registro")
    public void doyClickEnIniciarRegistro() throws InterruptedException {
        altaMovilPostpagoCallCenterStep.doyClickEnIniciarRegistro();
    }

    @Entonces("me muestra la pantalla de Delivery de linea nueva")
    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        altaMovilPostpagoCallCenterStep.meMuestraLaPantallaDeDeliveryDeLineaNueva();
    }

    @Y("ingreso el tipo de pago {string}")
    public void ingresoElTipoDePago(String Pago) {
        altaMovilPostpagoCallCenterStep.ingresoElTipoDePago(Pago);
    }

    @Y("selecciono el tipo de entrega de delivery {string}")
    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        altaMovilPostpagoCallCenterStep.seleccionoElTipoDeEntregaDeDelivery(tipo);
    }

    @Y("ingreso los datos del cliente")
    public void ingresoLosDatosDelCliente(DataTable datosCliente) {
        if (cliente.isClienteNuevo()) {
            altaMovilPostpagoCallCenterStep.ingresoLosDatosDelCliente(datosCliente);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("valido que se muestre el detalle del pedido")
    public void validoQueSeMuestreElDetalleDelPedido() {
        altaMovilPostpagoCallCenterStep.ValidoQuePresenteDetallePedido();
    }

    @Y("doy click en ver detalle del pedido")
    public void doyClickenVerDetalleDelPedido() {
        altaMovilPostpagoCallCenterStep.doyClickenVerDetalleDelPedido();
    }

    @Y("valido que se muestre el detalle del pedido de {string}")
    public void validoQueSeMuestreElDetalleDelPedido(String service) {
        altaMovilPostpagoCallCenterStep.ValidoQuePresenteDetallePedido(service);
    }
}
