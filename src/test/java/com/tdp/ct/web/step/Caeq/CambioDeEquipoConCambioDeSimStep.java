package com.tdp.ct.web.step.Caeq;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CambioDeEquipoConCambioDeSimStep {
    @Autowired
    private StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void SeleccionarBotonCambiarChip() {
        page.cambioDeEquipoConCambioDeSimPage().SeleccionarBotonCambiarChip();
    }
    @ScreenShotAfter
    public void seleccionoTipoPagoAlContado() {
        page.cambioDeEquipoConCambioDeSimPage().seleccionoTipoPagoAlContado();
    }
}
