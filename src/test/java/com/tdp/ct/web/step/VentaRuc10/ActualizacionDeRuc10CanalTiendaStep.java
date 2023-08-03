package com.tdp.ct.web.step.VentaRuc10;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActualizacionDeRuc10CanalTiendaStep {
    @Autowired
    private StepPages page;
    @ScreenShotBefore
    public void seleccionoBotonVerDetalle() {
        page.actualizacionDeRuc10CanalTiendaPage().seleccionoBotonVerDetalle();
    }
    @ScreenShotBefore
    public void clickBotonActualizarRuc() {
        page.actualizacionDeRuc10CanalTiendaPage().clickBotonActualizarRuc();
    }
    @ScreenShotAfter
    public void ingresoRuc(String ruc) {
       page.actualizacionDeRuc10CanalTiendaPage().ingresoRuc(ruc);
    }
    @ScreenShotBefore
    public void clickBotonActualizar() {
        page.actualizacionDeRuc10CanalTiendaPage().clickBotonActualizar();
    }
    @ScreenShotAfter
    public void validoMensajeActualizacionCorrecta() {
        page.actualizacionDeRuc10CanalTiendaPage().validoMesajeActualizacionCorrecta();
    }
    @ScreenShotBefore
    public void clickBotonEntendido() {
        page.actualizacionDeRuc10CanalTiendaPage().clickBotonEntendido();
    }
    @ScreenShotAfter
    public void seleccionoDireccionSugerida() {
        page.actualizacionDeRuc10CanalTiendaPage().seleccionoDireccionSugerida();
    }
}
