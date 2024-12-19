package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.MigracionDuoATrioTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class MigracionDuoATrioTiendaStepDefinition {

    @Autowired
    private MigracionDuoATrioTiendaStep migracionDuoATrioTiendaStep;

    @Y("seleccion plan nuevo para ver las ofertas")
    public void seleccionPlanNuevoParaVerLasOfertas() {
        migracionDuoATrioTiendaStep.scrollUP();
        migracionDuoATrioTiendaStep.seleccionPlanNuevoParaVerLasOfertas();
    }

    @Y("selecciono el tipo de plan Hogar {string}")
    public void seleccionoElTipoDePlanHogar(String planHogar) {
        migracionDuoATrioTiendaStep.seleccionoElTipoDePlanHogar(planHogar);
    }

    @Y("doy click en el boton {string}")
    public void doyClickEnEnElBoton(String nameButton) {
        migracionDuoATrioTiendaStep.clickButton(nameButton);
    }

    @Y("selecciono un plan y doy click en el boton seleccionar oferta")
    public void seleccionoUnPlanYDoyClickEnElBotonSeleccionarOferta() {
        migracionDuoATrioTiendaStep.seleccionoPlandeOferta();
        migracionDuoATrioTiendaStep.clickBotonSeleccionarOferta();
    }

    @Y("luego doy click en la cartilla ir a Movistar Total")
    public void luegoDoyClickEnLaCartillaIrAMovistarTotal() {
        migracionDuoATrioTiendaStep.clickBtnIrMovistarTotal();
    }

    @Y("doy click en el boton Migrar a fibra")
    public void seleccinarBotonMigrarAFibra() {
        migracionDuoATrioTiendaStep.SeleccionarBtnMigrarFibra();
    }

    @Y("valido que se muestre la etiqueta {string}")
    public void validoQueSeMuestreLaEtiqueta(String value) {
        migracionDuoATrioTiendaStep.validateTagUVSC(value);
    }

    @Y("valido que los precio de plan hogar y plan mensual sean los mismos")
    public void validoQueLosPrecioDePlanHogarYPlanMensualSeanLosMismos() {
        migracionDuoATrioTiendaStep.validateCurrentAndNewPrice();
    }

}
