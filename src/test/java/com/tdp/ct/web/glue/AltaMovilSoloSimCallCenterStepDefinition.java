package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMovilSoloSimCallCenterStepDefinition {

    @Autowired
    private AltaMovilSoloSimCallCenterStep altaMovilSoloSimCallCenterStep;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Autowired
    private Customer customer;

    @Y("doy click en el boton Agregar SVA")
    public void seleccionoElBotonAgregarSva() {
        altaMovilSoloSimCallCenterStep.seleccionoElBotonAgregarSva();
    }

    @Y("valido que muestre el nombre completo del cliente {string}")
    public void valido_que_muestre_el_nombre_completo_del_cliente(String data) {
        if (!customer.isNewCustomer()) {
            altaFijaTiendaStep.validarNombresCompletosCliente(data);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("valido que este en la pagina de ofertas sugeridas")
    public void valido_que_este_en_la_pagina_de_ofertas_sugeridas() {
        altaMovilSoloSimCallCenterStep.validarOfertasSugeridas();
    }

    @Y("selecciono el tipo de plan movil {string}")
    public void selecciono_el_tipo_de_plan_movil(String tipoPlanMovil) {
        altaMovilSoloSimCallCenterStep.seleccionarListaTipoPlanMovil(tipoPlanMovil);
    }

    @Y("selecciono un plan movil {string}")
    public void selecciono_un_plan_movil(String planMovil) {
        altaMovilSoloSimCallCenterStep.seleccionarListaPlanMovil(planMovil);
        altaMovilSoloSimCallCenterStep.clickBotonSeleccionarOferta();
        altaFijaTiendaStep.clickListaBotones();
    }

    @Y("valido que este en la seccion Postpago o Prepago")
    public void valido_que_este_en_seccion_Postpago_Prepago() {
        altaMovilSoloSimCallCenterStep.validarSeleccionaPostpagoPrepago();
    }

    @Y("cierro el popup de validación de estado de contraseña única")
    public void cierroElPopupDeValidaciónDeEstadoDeContraseñaÚnica() {
        altaMovilSoloSimCallCenterStep.cerrarPopUpEstadoCU();
    }

}
