package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaValidacionPrecioDescuentoStep;
import io.cucumber.datatable.DataTable;
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

    @Y("compruebo si el cliente {string}, {string} es el correcto")
    public void comprueboCLiente(String nombre, String Apellido) {
        altaValidacionPrecioDescuentoStep.comprueboCliente(nombre, Apellido);
    }

    @Y("selecciono el departamento donde se instalara {string}")
    public void ingresoDepartamento(String deparmaneto) {
        altaValidacionPrecioDescuentoStep.ingresoDepartamento(deparmaneto);
    }

    @Y("selecciono la provincia donde se instalara {string}")
    public void ingresoProvincia(String provincia) {
        altaValidacionPrecioDescuentoStep.ingresoProvincia(provincia);
    }

    @Y("selecciono el distrito donde se instalara {string}")
    public void ingresoDistrito(String distrito) {
        altaValidacionPrecioDescuentoStep.ingresoDistrito(distrito);
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

    @Y("valido el precio establecido sea {string}")
    public void validacionPrecio(String precioPlan) {
        altaValidacionPrecioDescuentoStep.validacionPrecio(precioPlan);
    }

    @Y("ingreso correo electronico {string}")
    public void ingresoCorreo(String email) {
        altaValidacionPrecioDescuentoStep.ingresoCorreo(email);
    }

    @Y("ingreso el callId {string}")
    public void ingresoCallID(String callId) {
        altaValidacionPrecioDescuentoStep.ingresoCallId(callId);
    }

    @Y("valido el ingreso de datos del cliente")
    public void ingresoDatosCliente(DataTable datosCliente) {
        altaValidacionPrecioDescuentoStep.ingresoDatosClientes(datosCliente);
    }

    @Y("escojo el plan {string}")
    public void escojoPlan(String plan) {
        altaValidacionPrecioDescuentoStep.escojoPlan(plan);
    }
}
