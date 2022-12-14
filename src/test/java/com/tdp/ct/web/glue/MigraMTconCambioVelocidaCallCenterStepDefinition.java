package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.migracion.MigraMTconCambioVelocidaCallCenterStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class MigraMTconCambioVelocidaCallCenterStepDefinition {
    @Autowired
    private MigraMTconCambioVelocidaCallCenterStep migraMTconCambioVelocidaCallCenterStep;

    @Y("selecciono la cartilla del plan MT")
    public void seleccionoLaCartillaDelPlanMT() {
        migraMTconCambioVelocidaCallCenterStep.seleccionoCartillaPlanMT();
    }


    @Y("Selecciono una linea movil y mostrar ofertas")
    public void seleccionoUnaLineaMovilYMostrarOfertas() {
        migraMTconCambioVelocidaCallCenterStep.seleccionoLineaMovil();
        migraMTconCambioVelocidaCallCenterStep.SeleccionoMostrarOfecta();
    }
}
