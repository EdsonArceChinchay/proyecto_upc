package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaValidacionPrecioDescuentoStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AltaValidacionPrecioDescuentoStepDefinition {

    @Autowired
    private AltaValidacionPrecioDescuentoStep altaValidacionPrecioDescuentoStep;

    @Y("valido si el cliente {string}, {string} con genero {string} ya esta registrado")
    public void validoSiElClienteConGeneroYaEstaRegistrado(String nombre, String apellidos, String genero) {
        altaValidacionPrecioDescuentoStep.validacionClienteNuevo(nombre, apellidos, genero);
    }

    @Y("Valido que el beneficio sea {string}")
    public void validacionBeneficioPlan(String beneficioPlan) {
        if (!Objects.equals(beneficioPlan, "null")) {
            altaValidacionPrecioDescuentoStep.validacionBeneficioPlan(beneficioPlan);
        }
    }

    @Y("Valido que el descuento aplicado sea {string}")
    public void valdiacionDescuento(String descuento) {
        if (!Objects.equals(descuento, "")) {
            altaValidacionPrecioDescuentoStep.validacionBeneficioPlan(descuento);
        }
    }
}
