package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.migracion.MigraDuoTrioActualizarDireccionTiendasStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class MigraDuoTrioActualizarDireccionTiendasStepDefinition {
    @Autowired
    private MigraDuoTrioActualizarDireccionTiendasStep migraDuoTrioActualizarDireccionTiendasStep;
    @Y("Doy click en el boton {string}")
    public void doyClickEnElBoton(String button) {
        migraDuoTrioActualizarDireccionTiendasStep.doyClickEnElBoton(button);
    }

    @Y("valido que se presente el siguiente mensaje {string}")
    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        migraDuoTrioActualizarDireccionTiendasStep.validoQueSePresenteElSiguienteMensaje(mensaje);
    }
}
