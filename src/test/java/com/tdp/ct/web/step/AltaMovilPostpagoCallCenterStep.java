package com.tdp.ct.web.step;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilPostpagoCallCenterStep {

    @Autowired
    private  StepPages page;

    public void BtonOpciones() {
        page.altaMovilPostpagoCallCenterPage().BtonOpciones();
    }


    public  void seleccionarPlan(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionarPlan(tipoPlan);

    }

    public  void seleccionarEquipo() {
        page.altaMovilPostpagoCallCenterPage().seleccionarEquipo();
    }

    public  void seleccionarTiempo(String tiempoP) {
        page.altaMovilPostpagoCallCenterPage().seleccionarTiempo(tiempoP);
    }

    public  void seleccionarTipoPago(String tipoPago) {
    }

    public  void BuscarEquipo(String buscarE) {
        page.altaMovilPostpagoCallCenterPage().BuscarEquipo(buscarE);
    }


    public  void seleccionoElPlanMovil(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionoElPlanMovil(tipoPlan);
    }

    public void seleccionoLaCartillaLineaNueva() {
        page.altaMovilPostpagoCallCenterPage().seleccionoLaCartillaLineaNueva();
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnElBotonSeleccionarOferta();
    }

    public void doyClickEnElBotonSeleccionar() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnElBotonSeleccionar();
    }

    public void doyClickEnIniciarRegistro() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnIniciarRegistro();
    }

    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        Assert.assertTrue(page.altaMovilPostpagoCallCenterPage().meMuestraLaPantallaDeDeliveryDeLineaNueva());
    }
}

