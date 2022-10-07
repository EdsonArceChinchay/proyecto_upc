package com.tdp.ct.web.glue.Paquetizacion;

import com.tdp.ct.web.step.Paquetizacion.PaquetizacionDuoMasMonoPorCallCenterStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import com.tdp.ct.web.WebAutomationApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class PaquetizacionDuoMasMonoPorCallCenterStepDefinition {
    @Autowired
    private PaquetizacionDuoMasMonoPorCallCenterStep paquetizacionDuoMasMonoPorCallCenterStep;
    @Y("selecciono el servicio mono {string} y  el servicio duo {string} a paquetizar")
    public void selecciono_el_mono_y_duo_a_paquetizar(String mono,String duo){
        paquetizacionDuoMasMonoPorCallCenterStep.clickMonoYDuo(mono,duo);
    }

    @Y("doy click en el boton continuar")
    public void doyClickEnElBotonContinuar() {
        paquetizacionDuoMasMonoPorCallCenterStep.botonContinuar();
    }
}
