package com.tdp.ct.web.glue.VentaRuc10;

import com.tdp.ct.web.step.VentaRuc10.ActualizacionDeRuc17CanalTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class ActualizacionDeRuc17CanalTiendaStepDefinition {

    @Autowired
    private ActualizacionDeRuc17CanalTiendaStep actualizacionDeRuc17CanalTiendaStep;

    @Y("ingreso el ruc {string}, digito verificador {string} y actualizo")
    public void ingresoElRucDigitoVerificadorYActualizo(String ruc, String digito) {
        actualizacionDeRuc17CanalTiendaStep.ingresoRuc17(ruc);
        actualizacionDeRuc17CanalTiendaStep.ingresoDigitoV(digito);
        actualizacionDeRuc17CanalTiendaStep.clickBotonActualizar();
    }

}
