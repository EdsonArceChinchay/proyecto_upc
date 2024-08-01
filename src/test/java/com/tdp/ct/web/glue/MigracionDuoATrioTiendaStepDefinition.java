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
        migracionDuoATrioTiendaStep.scrollUp();
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

    @Y("doy click en Cambiar plan hogar")
    public void doyClickEnCambiarPlanHogar() {
        migracionDuoATrioTiendaStep.seleccionarboton();
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

    @Y("doy click en Finalizar registro")
    public void doyClickEnFinalizarRegistro() {
        migracionDuoATrioTiendaStep.clickFinalizarRegistro();
    }

}
