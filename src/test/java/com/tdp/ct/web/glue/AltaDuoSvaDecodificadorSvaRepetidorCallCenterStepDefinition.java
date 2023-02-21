package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaDuoSvaDecodificadorSvaRepetidorCallCenterStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaDuoSvaDecodificadorSvaRepetidorCallCenterStepDefinition {

    @Autowired
    private AltaDuoSvaDecodificadorSvaRepetidorCallCenterStep svadeco;

    @Y("elijo una opcion")
    public void elijo_una_opcion() {
        System.out.println("primer step");

    }

    @Y("elegimos sva {string}")
    public void elegimos_sva(String string) {
        System.out.println("segundo step");
        svadeco.seleccionardecodificador(string);
    }

}
