package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.Caeq.CaeqPorReatilStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CaeqPorReatilStepDefinition {
    @Autowired
    private CaeqPorReatilStep caeqPorReatilStep;
    @Y("presiona el boton anadir equipo")
    public void presionaElBotonAnadirEquipo() {
        caeqPorReatilStep.btnAnadirEquipo();
    }

    @Y("presiono el boton seleccionar")
    public void presionoElBotonSeleccionar() {
        caeqPorReatilStep.btnSeleccionar();
    }

    @Y("selecciono boton mantener plan")
    public void seleccionoBotonMantenerPlan() {
        caeqPorReatilStep.btnMantenerPlan();
    }

    @Y("doy clic en consultar cliente nuevo")
    public void doyClicEnConsultarClienteNuevo() {
        caeqPorReatilStep.btnConsultarClienteNuevo();
    }


}
