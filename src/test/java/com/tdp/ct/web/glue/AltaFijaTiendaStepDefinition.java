package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaTiendaStepDefinition {

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;


    @Y("selecciono el tipo de plan fija {string}")
    public void selecciono_el_tipo_de_plan_fija(String planFija) {
        altaFijaTiendaStep.seleccionarListaPLanFija(planFija);
    }

    @Y("selecciono el plan {string}")
    public void selecciono_el_plan(String nombrePlan) {
        altaFijaTiendaStep.seleccionarListaOfertas(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
        altaFijaTiendaStep.clickListaBotones();

    }

    @Y("doy click en añadir SVA")
    public void doyClickEnAñadirSVA() {
        altaFijaTiendaStep.doyClickEnAñadirSVA();
    }

    @Y("doy click en el boton validar identidad representante legal")
    public void doyClicEnElBotonValidarIdentidadRepresentanteLegal() {
        altaFijaTiendaStep.clickBotonValidarRepreLegal();
    }

    @Y("selecciono el boton Linea Nueva")
    public void seleccionoElBotonLineaNueva() {
        altaFijaTiendaStep.clickListaBotones();
    }
}
