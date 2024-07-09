package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.Caeq.CambioDeEquipoConCambioDeSimStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CambioDeEquipoConCambioDeSimStepDefinition {
    @Autowired
    private CambioDeEquipoConCambioDeSimStep cambioDeEquipoConCambioDeSimStep;

    @Y("Selecciono boton Cambiar Chip")
    public void seleccionoBotonCambiarChip() {
        cambioDeEquipoConCambioDeSimStep.SeleccionarBotonCambiarChip();
    }

    @Y("selecciono tipo de pago Al Contado")
    public void seleccionoTipoDePagoAlContado() {
        cambioDeEquipoConCambioDeSimStep.seleccionoTipoPagoAlContado();
    }

    @Y("selecciono el boton Cambiar Chip")
    public void seleccionoelbotonCambiodeChip() {
        cambioDeEquipoConCambioDeSimStep.seleccionoelbotonCambiodeChip();
    }

    @Y("cierro pop up de Cliente Exonerado")
    public void cierroPopUpDeClienteExonerado() {
        cambioDeEquipoConCambioDeSimStep.cierroPopUpDeClienteExonerado();
    }
}
