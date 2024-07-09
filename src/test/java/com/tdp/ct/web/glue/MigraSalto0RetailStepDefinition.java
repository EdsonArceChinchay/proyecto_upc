package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.migracion.MigraSalto0RetailStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class MigraSalto0RetailStepDefinition {
    @Autowired
    private MigraSalto0RetailStep migraSalto0RetailStep;
    @Y("doy click en el boton Migrar a fibra")
    public void seleccinarBotonMigrarAFibra() {
    migraSalto0RetailStep.SeleccionarBtnMigrarFibra();
    }

    @Cuando("doy clic en iniciar registro")
    public void doyClicEnIniciarRegistro() {
        migraSalto0RetailStep.clicIniciarRegistro();
    }

    @Y("cierro el popup de Detail")
    public void cierroElPopupDeDetail() {
        migraSalto0RetailStep.clickBotonEntendido();
    }

    @Y("valido que se muestre la etiqueta {string}")
    public void validoQueSeMuestreLaEtiqueta(String value) {
        migraSalto0RetailStep.validateTagUVSC(value);
    }

    @Y("valido que los precio de plan hogar y plan mensual sean los mismos")
    public void validoQueLosPrecioDePlanHogarYPlanMensualSeanLosMismos() {
        migraSalto0RetailStep.validateCurrentAndNewPrice();
    }
}
