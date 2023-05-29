package com.tdp.ct.web.glue.VentaRuc10;

import com.tdp.ct.web.step.VentaRuc10.ActualizacionDeRuc10CanalTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class ActualizacionDeRuc10CanalTiendaStepDefinition {
    @Autowired
    private ActualizacionDeRuc10CanalTiendaStep actualizacionDeRuc10CanalTiendaStep;

    @Y("selecciono el boton Ver detalle del plan actual y actualizar ruc")
    public void seleccionoElBotonVerDetalleDelPlanActualYActualizarRuc() {
        actualizacionDeRuc10CanalTiendaStep.seleccionoBotonVerDetalle();
        actualizacionDeRuc10CanalTiendaStep.clickBotonActualizarRuc();
    }

    @Y("ingreso el ruc {string} y actualizo")
    public void ingresoElRucYActualizo(String ruc) {
        actualizacionDeRuc10CanalTiendaStep.ingresoRuc(ruc);
        actualizacionDeRuc10CanalTiendaStep.clickBotonActualizar();
    }

    @Y("valido el mensaje de la actualizacion de ruc correcta")
    public void validoElMensajeDeLaActualizacionDeRucCorrecta() {
        actualizacionDeRuc10CanalTiendaStep.validoMensajeActualizacionCorrecta();
        actualizacionDeRuc10CanalTiendaStep.clickBotonEntendido();
    }

}
