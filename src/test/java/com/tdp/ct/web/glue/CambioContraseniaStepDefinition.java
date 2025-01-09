package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.CambioContraseniaStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class CambioContraseniaStepDefinition {
    @Autowired
    private CambioContraseniaStep cambioContraseniaStep;

    @Y("doy click en el boton cambio de contraseña")
    public void doyClickEnElBotonCambioDeContrasenia() {
        cambioContraseniaStep.doyClickEnElBotonCambioDeContrasenia();
    }

    @Y("ingreso la contraseña actual {string}")
    public void ingresoLaContraseniaActual(String clave) {
        cambioContraseniaStep.ingresoLaContraseniaActual(clave);
    }

    @Y("ingreso la nueva contraseña {string}")
    public void ingresoLaNuevaContrasenia(String clave) {
        cambioContraseniaStep.ingresoLaNuevaContrasenia(clave);
    }

    @Y("confirmo la nueva contraseña {string}")
    public void confirmoLaNuevaContrasenia(String clave) {
        cambioContraseniaStep.confirmoLaNuevaContrasenia(clave);
    }

    @Y("doy click en el boton cambiar contraseña")
    public void doyClickEnElBotonCambiarContrasenia() {
        cambioContraseniaStep.doyClickEnElBotonCambiarContrasenia();
    }

    @Entonces("visualizo el mensaje de exito en el cambio de contraseña")
    public void visualizoElMensajeDeExitoEnElCambioDeContrasenia() {
        cambioContraseniaStep.visualizoElMensajeDeExitoEnElCambioDeContrasenia();
    }

    @Y("presiono el boton entendido")
    public void presionoElBotonEntendido() {
        cambioContraseniaStep.presionoElBotonEntendido();
    }
}
