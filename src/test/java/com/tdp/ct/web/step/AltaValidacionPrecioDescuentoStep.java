package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import io.cucumber.datatable.DataTable;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AltaValidacionPrecioDescuentoStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void validacionClienteNuevo(String nombre, String apellidos, String genero) {
        if(Addons.esEntornoProductivo()){
            page.altaValidacionPrecioDescuentoPage().validacionClienteNuevoProduccion(nombre, apellidos, genero,7);
        }else{
            page.altaValidacionPrecioDescuentoPage().validacionClienteNuevo(nombre, apellidos, genero);
        }

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
        page.altaFijaTiendaPage().listaOfertas(plan);
        page.altaFijaTiendaPage().seleccionarOferta();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void escojoPlanMultiple(List<String> escenario, List<String> planes, List<String> precios, List<String> beneficiosPlan, List<String> descuentosPlan) {
        page.altaFijaTiendaPage().listaOfertasMultiple(escenario,planes,precios,beneficiosPlan,descuentosPlan);

    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void cerrarVentana() {
        page.altaFijaTiendaPage().cerrarVentanaOfertas();

    }

    public static List<String> getValuesFromDataTable(DataTable dataTable, String title) {
        List<String> values = new ArrayList<>();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            if (row.containsKey(title)) {
                values.add(row.get(title));
            }
        }

        return values;
    }
}
