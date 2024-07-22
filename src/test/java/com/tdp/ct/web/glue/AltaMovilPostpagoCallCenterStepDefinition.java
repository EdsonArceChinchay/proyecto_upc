package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.model.Customer;
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
    private Customer customer;

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

    @Entonces("me muestra la pantalla de Delivery de linea nueva")
    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        altaMovilPostpagoCallCenterStep.meMuestraLaPantallaDeDeliveryDeLineaNueva();
    }

    @Y("selecciono el tipo de entrega de delivery {string}")
    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        altaMovilPostpagoCallCenterStep.seleccionoElTipoDeEntregaDeDelivery(tipo);
    }

    @Y("ingreso los datos del cliente")
    public void ingresoLosDatosDelCliente(DataTable datosCliente) {
        if (customer.isNewCustomer()) {
            altaMovilPostpagoCallCenterStep.ingresoLosDatosDelCliente(datosCliente);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

}
