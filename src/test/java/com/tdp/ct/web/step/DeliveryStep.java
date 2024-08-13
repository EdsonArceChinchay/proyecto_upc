package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryStep {
    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        Assert.assertTrue(page.deliveryPage().meMuestraLaPantallaDeDeliveryDeLineaNueva());
    }

    @ScreenShotAfter
    public void clickButtonConfirmLocation() {
        page.deliveryPage().clickButtonConfirmLocation();
    }

    @ScreenShotAfter
    public void selectTypeOfDelivery(String tipEntrega) {
        page.deliveryPage().selectTypeOfDelivery(tipEntrega);
    }

    @ScreenShotAfter
    public void clickOnDeliveryTime(String horario) {
        page.deliveryPage().clickOnDeliveryTime(horario);
    }

    @ScreenShotAfter
    public void clickButtonConfirmDevlivery() {
        page.deliveryPage().clickButtonConfirmDevlivery();
    }

    @ScreenShotAfter
    public void typeTelephone(String number) {
        page.deliveryPage().typeTelephone(number);
    }

    @ScreenShotAfter
    public void typeDeliveryInstructions(String instruction) {
        page.deliveryPage().typeDeliveryInstructions(instruction);
    }
}
