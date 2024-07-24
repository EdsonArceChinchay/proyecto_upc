package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.RegisterStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterStepDefinition {

    @Autowired
    private RegisterStep registerStep;

    @Autowired
    private Customer customer;

    @Y("ingreso correo electronico {string}")
    public void ingresoCorreo(String email) {
        registerStep.ingresoCorreo(email);
    }

    @Y("ingreso nuevamente el correo electronico {string}")
    public void ingreso_nuevamente_el_correo_electronico(String correo) {
        registerStep.ingresarCorreoNuevamente(correo);
    }

    @Y("selecciono el metodo de pago {string}")
    public void selecciono_el_metodo_de_pago(String metodoPago) {
        registerStep.seleccionarTipoPago(metodoPago);
    }

    @Y("ingreso el callId {string}")
    public void ingresoCallID(String callId) {
        registerStep.ingresoCallId(callId);
    }

    @Y("doy click en datos del cliente")
    public void doyClickEnDatosDelCliente() {
        if (customer.isNewCustomer()) {
            registerStep.esperarBtnDatosCliente();
            registerStep.clicDatosDelCliente();
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("completo los datos del cliente")
    public void completoLosDatosSolicitados(DataTable dataTable) {
        if (customer.isNewCustomer()) {
            registerStep.ingresarDatosCliente(dataTable);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }


    @Y("selecciono completar los datos del cliente")
    public void selecciono_completar_los_datos_del_cliente(DataTable datosCliente) {
        if (customer.isNewCustomer()) {
            registerStep.completoDatosCliente(datosCliente);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("doy click en el boton confirmar")
    public void doyClickEnElBotonConfirmar() {
        if (customer.isNewCustomer()) {
            registerStep.clickBotonConfirmar();
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }
}
