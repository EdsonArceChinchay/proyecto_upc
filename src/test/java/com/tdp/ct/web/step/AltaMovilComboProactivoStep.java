package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilComboProactivoStep {

    @Autowired
    private StepPages page;

    public void completoDatosCliente(DataTable datosCliente) {
        String fechaNac= UtilWeb.getValueFromDataTable(datosCliente,"fechaNac");
        String nacionalidad=UtilWeb.getValueFromDataTable(datosCliente,"nacionalidad");
        String estadoCivil=UtilWeb.getValueFromDataTable(datosCliente,"estadoCivil");
        String departamento=UtilWeb.getValueFromDataTable(datosCliente,"departamento");
        String provincia=UtilWeb.getValueFromDataTable(datosCliente,"provincia");
        String distrito=UtilWeb.getValueFromDataTable(datosCliente,"distrito");
        String direccion=UtilWeb.getValueFromDataTable(datosCliente,"direccion");

        page.altaMovilComboProactivoPage().ingresarFechaNac(fechaNac);
        page.altaMovilComboProactivoPage().seleccionoNacionalidad(nacionalidad);
        page.altaMovilComboProactivoPage().seleccionarEstadoCivil(estadoCivil);
        page.altaMovilComboProactivoPage().seleccionarDepartamento(departamento);
        page.altaMovilComboProactivoPage().seleccionarProvincia(provincia);
        page.altaMovilComboProactivoPage().seleccionarDistrito(distrito);
        page.altaMovilComboProactivoPage().seleccionarDireccion(direccion);
}

    @ScreenShotBefore
    public void seleccionoElBotonAgregarSva() {
        page.altaMovilComboProactivoPage().seleccionoElBotonAgregarSva();
    }

}


