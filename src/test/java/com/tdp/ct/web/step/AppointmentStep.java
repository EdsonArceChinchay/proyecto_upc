package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void validarPantallaAgendamiento() {
        Assert.assertTrue("No se mostro pantalla de agendamiento",
                page.appointmentPage().validarPantallaAgendamiento());
    }

    @ScreenShotAfter
    public void escogerTurnoAgendamiento() {
        page.appointmentPage().clicEnUnTurnoAgendamiento();
    }

    @ScreenShotAfter
    public void typeContactNumber(String contact) {
        page.appointmentPage().typeContactNumber(contact);
    }

    public void scrollToViewAgendamiento() {
        page.appointmentPage().scrollToViewAgendamiento();
    }

    @ScreenShotBefore
    public void clickBotonConfirmarAgendamiento() {
        page.appointmentPage().botonConfirmarAgendamiento();
    }

    @ScreenShotAfter
    public void ingresarDatosAgendamientoParaRUC() {
        page.appointmentPage().ingresarDatosAgendamientoParaRUC();
    }

}
