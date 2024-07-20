package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.DeliveryStep;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryStepDefinition {

    @Autowired
    DeliveryStep deliveryStep;

    @Y("presiono el boton Confirmar ubicacion")
    public void presiono_el_boton_confirmar_ubicacion() {
        deliveryStep.clickButtonConfirmLocation();
    }

    @Y("selecciono un tipo de entrega {string}")
    public void selecciono_un_tipo_de_entrega(String tipoEntrega) {
        deliveryStep.seleccionarTipoEntrega(tipoEntrega);
    }

    @Y("selecciono el horario de entrega {string}")
    public void selecciono_el_horario_de_entrega(String horarioEntrega) {
        deliveryStep.seleccionarBtnHorario(horarioEntrega);
    }
    @Y("selecciono horario {string}")
    public void seleccionoHorario(String horario) {
        deliveryStep.selectTipoHorario(horario);
    }

    @Y("doy clic en confirmar delivery")
    public void doy_clic_en_confirmar_delivery() {
        deliveryStep.clickButtonConfirmDevlivery();
    }

    @E("ingreso telefono de contacto {string}")
    public void ingresoTelefonoDelTitular(String number) {
        deliveryStep.typeTelephone(number);
    }
    @E("ingreso instrucciones de delivery {string}")
    public void ingresoInstruccionesDeDelivery(String instruction) {
        deliveryStep.typeDeliveryInstructions(instruction);
    }

}
