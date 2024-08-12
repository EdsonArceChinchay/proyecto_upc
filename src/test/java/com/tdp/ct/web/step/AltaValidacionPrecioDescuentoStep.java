package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaValidacionPrecioDescuentoStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotBefore
    @ScreenShotAfter
    public void validacionClienteNuevo(String nombre, String apellidos, String genero) {
        page.altaValidacionPrecioDescuentoPage().validacionClienteNuevo(nombre, apellidos, genero);
    }

    @ScreenShotAfter
    public void validacionBeneficioPlan(String beneficioPlan) {
        page.altaValidacionPrecioDescuentoPage().validacionBeneficioPlan(beneficioPlan);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void comprueboCliente(String nombre, String apellido) {
        page.altaValidacionPrecioDescuentoPage().comprueboCliente(nombre, apellido);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void escojoPlan(String plan) {
        page.altaFijaTiendaPage().listaOfertas(plan, scenario);
        page.altaFijaTiendaPage().seleccionarOferta();
    }
}
