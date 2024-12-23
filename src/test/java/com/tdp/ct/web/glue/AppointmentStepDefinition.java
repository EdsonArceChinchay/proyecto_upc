package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AppointmentStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentStepDefinition {

    @Autowired
    private AppointmentStep appointmentStep;

    @Y("valido que me encuentre en la pantalla agendamiento")
    public void validoQueMeEncuentreEnLaPantallaAgendamiento() {
        appointmentStep.validarPantallaAgendamiento();
    }

    @Y("escojo un turno de agendamiento")
    public void escojoUnTurnoDeAgendamiento() {
        appointmentStep.escogerTurnoAgendamiento();
    }

    @Y("ingreso datos del contacto en la pantalla agendamiento {string}")
    public void ingresoDatosDelContactoEnLaPantallaAgendamiento(String contact) {
        appointmentStep.typeContactNumber(contact);
    }

    @Y("valido que se presente la pantalla agendamiento")
    public void validoQueSePresenteLaPantallaAgendamiento() {
        appointmentStep.scrollToViewAgendamiento();
        appointmentStep.validarPantallaAgendamiento();
    }

    @Y("ingreso telefono de contacto")
    public void ingresoTelefonoDeContacto() {
        appointmentStep.typeContactNumber(null);
    }

    @Y("presiono el boton Confirmar agendamiento")
    public void presionoElBotonConfirmarAgendamiento() {
        appointmentStep.clickBotonConfirmarAgendamiento();
    }

    @Y("ingreso los datos de agendamiento")
    public void ingreso_los_datos_de_agendamiento() {
        appointmentStep.typeContactNumber(null);
    }

    @Y("presiono el boton confirmar agendamiento")
    public void presiono_el_boton_confirmar_agendamiento() {
        appointmentStep.clickBotonConfirmarAgendamiento();
    }

    @Y("ingreso los datos de agendamiento para RUC")
    public void ingresoLosDatosDeAgendamientoParaRUC() {
        appointmentStep.ingresarDatosAgendamientoParaRUC();
    }

}

