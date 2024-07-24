package com.tdp.ct.web.step;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import com.tdp.ct.web.page.StepPages;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilPostpagoCallCenterStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void BtonOpciones() {
        page.altaMovilPostpagoCallCenterPage().BtonOpciones();
    }

    @ScreenShotBefore
    public void seleccionarEquipo() {
        page.altaMovilPostpagoCallCenterPage().seleccionarEquipo();
    }

    @ScreenShotBefore
    public void seleccionarPlan(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionarPlan(tipoPlan);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionoElPlanMovil(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionoElPlanMovil(tipoPlan);
    }

    @ScreenShotBefore
    public void seleccionoLaCartillaLineaNueva() {
        page.altaMovilPostpagoCallCenterPage().seleccionoLaCartillaLineaNueva();
    }

    @ScreenShotBefore
    public void doyClickEnElBotonSeleccionarOferta() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnElBotonSeleccionarOferta();
    }

    @ScreenShotAfter
    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        Assert.assertTrue(page.altaMovilPostpagoCallCenterPage().meMuestraLaPantallaDeDeliveryDeLineaNueva());
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        page.altaMovilPostpagoCallCenterPage().seleccionoElTipoDeEntregaDeDelivery(tipo);
    }

}

