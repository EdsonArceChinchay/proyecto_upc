package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.MigracionMonoADuoSVATiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class MigracionMonoADuoSVATiendaStepDefinition {

    @Autowired
    private MigracionMonoADuoSVATiendaStep MigracionMonoADuoSVATiendaStep;
    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Y("selecciono la oferta {string}")
    public void seleccionoLaOferta(String oferta) {
        altaFijaTiendaStep.seleccionarListaOfertas(oferta);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Y("doy click en Cambiar plan hogar")
    public void doyClickEnCambiarPlanHogar() {
        MigracionMonoADuoSVATiendaStep.seleccionarboton();
    }



}
