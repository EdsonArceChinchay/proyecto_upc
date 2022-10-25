package com.tdp.ct.web.glue.migracion;

import com.tdp.ct.web.step.migracion.MigraSalto0CanalTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class MigraSalto0CanalTiendaStepDefinition {
    @Autowired
    MigraSalto0CanalTiendaStep migraSalto0CanalTiendaStep;

    @Y("selecciono la opcion Migrar a fibra")
    public void seleccionoLaOpcionMigrarAFibra() {
        migraSalto0CanalTiendaStep.seleccionoOpcionMigraFibra();
    }

    @Y("valido que muestre la pantalla de Agendamiento")
    public void validoQueMuestreLaPantallaDeAgendamiento() {
        migraSalto0CanalTiendaStep.validoPantallaAgendamiento();
    }
    /*
    @Y("ingreso datos de agendamiento <{int}> y doy clic en continuar")
    public void ingresoDatosDeAgendamientoYDoyClicEnContinuar(String Contacto) {
        migraSalto0CanalTiendaStep.ingresoDatosAgendamiento(Contacto);
        migraSalto0CanalTiendaStep.clicBotonConfirmarAgendamiento();
    }
     */

    @Y("ingreso datos de agendamiento {string} y doy clic en continuar")
    public void ingresoDatosDeAgendamientoYDoyClicEnContinuar(String contacto) {
        migraSalto0CanalTiendaStep.ingresoDatosAgendamiento(contacto);
        migraSalto0CanalTiendaStep.clicBotonConfirmarAgendamiento();
    }
}
