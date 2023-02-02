package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaMonoInternetSvaRepetidorSvaInternetCallCenterStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMonoInternetSvaRepetidorSvaInternetCallCenterStepDefinition {

    @Autowired
    private AltaMonoInternetSvaRepetidorSvaInternetCallCenterStep altaMonoInternetSvaRepetidorSvaInternetCallCenterStep;

    @Entonces("doy click en Agregar Sva")
    public void doyclickenAgregarSva() {
        altaMonoInternetSvaRepetidorSvaInternetCallCenterStep.agregarsva();
    }

    @Y("agrego {string}")
    public void agregosvainternet(String string) {
        altaMonoInternetSvaRepetidorSvaInternetCallCenterStep.agregarsvainternet(string);
    }


}
