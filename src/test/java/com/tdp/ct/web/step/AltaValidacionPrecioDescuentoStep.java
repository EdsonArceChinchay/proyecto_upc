package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
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

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoDepartamento(String departamento) {
        page.altaValidacionPrecioDescuentoPage().ingresoDepartamento(departamento);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoProvincia(String provincia) {
        page.altaValidacionPrecioDescuentoPage().ingresoProvincia(provincia);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoDistrito(String distrito) {
        page.altaValidacionPrecioDescuentoPage().ingresoDistrito(distrito);
    }

    @ScreenShotAfter
    public void validacionBeneficioPlan(String beneficioPlan) {
        page.altaValidacionPrecioDescuentoPage().validacionBeneficioPlan(beneficioPlan);
    }

    @ScreenShotAfter
    public void validacionPrecio(String precioPLan) {
        page.altaValidacionPrecioDescuentoPage().validacionPrecio(precioPLan);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoCorreo(String email) {
        page.altaValidacionPrecioDescuentoPage().ingresoCorreo(email);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoCallId(String callId) {
        page.altaValidacionPrecioDescuentoPage().ingresoCallId(callId);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoDatosClientes(DataTable datos) {
        String fecha = UtilWeb.getValueFromDataTable(datos, "fechaNac");
        String estadoCivil = UtilWeb.getValueFromDataTable(datos, "estadoCivil");
        String nacionalidad = UtilWeb.getValueFromDataTable(datos, "nacionalidad");
        page.altaValidacionPrecioDescuentoPage().ingresoDatosCliente(fecha);
        page.altaValidacionPrecioDescuentoPage().ingresoNacionalidad(nacionalidad);
        page.altaValidacionPrecioDescuentoPage().ingresoEstadoCivil(estadoCivil);
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
