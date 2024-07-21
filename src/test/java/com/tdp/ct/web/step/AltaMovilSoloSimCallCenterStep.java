package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilSoloSimCallCenterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    public void cerrarPopUpEstadoCU() {
        page.altaMovilSoloSimCallCenterPage().cerrarPopUpEstadoCU();
    }

    public void validarOfertasSugeridas() {
        page.altaMovilSoloSimCallCenterPage().ofertasSugeridas();
    }

    public void seleccionarListaTipoPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaTipoPlanMovil(planMovil);
    }

    public void seleccionarListaPlanMovil(String planMovil) {
        page.altaMovilSoloSimCallCenterPage().listaPlanMovil(planMovil, scenario);
    }

    public void clickBotonSeleccionarOferta() {
        page.altaMovilSoloSimCallCenterPage().botonSeleccionarOfeta();
    }

    public void validarCompletaDatosSolicitados() {
        page.altaMovilSoloSimCallCenterPage().completaDatosSolicitados();
    }

    public void validarSeleccionaPostpagoPrepago() {
        page.altaMovilSoloSimCallCenterPage().validarSeleccionaPostpagoPrepago();
    }

    public void completoDatosCliente(DataTable datosCliente) {
        String fechaNac= UtilWeb.getValueFromDataTable(datosCliente,"fechaNac");
        String nacionalidad=UtilWeb.getValueFromDataTable(datosCliente,"nacionalidad");
        String estadoCivil=UtilWeb.getValueFromDataTable(datosCliente,"estadoCivil");
        String departamento=UtilWeb.getValueFromDataTable(datosCliente,"departamento");
        String provincia=UtilWeb.getValueFromDataTable(datosCliente,"provincia");
        String distrito=UtilWeb.getValueFromDataTable(datosCliente,"distrito");
        String direccion=UtilWeb.getValueFromDataTable(datosCliente,"direccion");

        page.altaMovilSoloSimCallCenterPage().ingresarFechaNac(fechaNac);
        page.altaMovilSoloSimCallCenterPage().seleccionoNacionalidad(nacionalidad);
        page.altaMovilSoloSimCallCenterPage().seleccionarEstadoCivil(estadoCivil);
        page.altaMovilSoloSimCallCenterPage().seleccionarDepartamento(departamento);
        page.altaMovilSoloSimCallCenterPage().seleccionarProvincia(provincia);
        page.altaMovilSoloSimCallCenterPage().seleccionarDistrito(distrito);
        page.altaMovilSoloSimCallCenterPage().seleccionarDireccion(direccion);
    }

    public void seleccionoElBotonAgregarSva() {
        page.altaMovilSoloSimCallCenterPage().seleccionoElBotonAgregarSva();
    }
}

