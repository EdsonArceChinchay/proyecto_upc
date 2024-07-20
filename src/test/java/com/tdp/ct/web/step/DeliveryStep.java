package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryStep {
    @Autowired
    private StepPages page;

    public void clickButtonConfirmLocation() {
        page.deliveryPage().clickButtonConfirmLocation();
    }

    public void seleccionarTipoEntrega(String tipEntrega) {
        page.deliveryPage().tipoEntrega(tipEntrega);
    }

    public void seleccionarBtnHorario(String horario) {
        page.deliveryPage().btnHorario(horario);
    }

    @ScreenShotAfter
    public void clickButtonConfirmDevlivery() {
        page.deliveryPage().clickButtonConfirmDevlivery();
    }

    @ScreenShotAfter
    public void selectTipoHorario(String horaio){
        UtilWeb.waitForSeconds(3);
        page.deliveryPage().selectTipoHorario(horaio);
    }

    @ScreenShotAfter
    public void typeTelephone(String number) {
        page.deliveryPage().typeTelephone(number);
    }

    @ScreenShotAfter
    public void typeDeliveryInstructions(String  instruction){
        page.deliveryPage().typeDeliveryInstructions(instruction);
    }
}
