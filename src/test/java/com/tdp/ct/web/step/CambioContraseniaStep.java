package com.tdp.ct.web.step;

import com.tdp.ct.web.CaptchaBase.Parameters;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CambioContraseniaStep {
    @Autowired
    private StepPages page;
    @Autowired
    private Cliente cliente;
    @Autowired
    private ManageScenario manageScenario;

    @ScreenShotAfter
    public void doyClickEnElBotonCambioDeContrasenia() {
        page.cambioContraseniaPage().clickBotonCambioDeContrasenia();
    }

    @ScreenShotAfter
    public void ingresoLaContraseniaActual(String clave) {
        page.cambioContraseniaPage().ingresarContraseniaActual(clave);
    }

    @ScreenShotAfter
    public void ingresoLaNuevaContrasenia(String clave) {
        page.cambioContraseniaPage().ingresarNuevaContrasenia(clave);
    }

    @ScreenShotAfter
    public void confirmoLaNuevaContrasenia(String clave) {
        page.cambioContraseniaPage().confirmarNuevaCotrasenia(clave);
    }

    @ScreenShotAfter
    public void doyClickEnElBotonCambiarContrasenia() {
        page.cambioContraseniaPage().clickBotonCambiarContrasenia();
    }

    @ScreenShotAfter
    public void visualizoElMensajeDeExitoEnElCambioDeContrasenia() {
        page.cambioContraseniaPage().visualizarExitoEnCambioDeContrasenia();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void presionoElBotonEntendido() {
        if (Parameters.cambioDirecciones) {
            page.cambioContraseniaPage().presionarBotonEntendido(manageScenario);
        } else {
            System.out.println("Skipped: botonActualizarDireccion()");
        }
    }
}
