package com.tdp.ct.web.step.MovilFinanciado;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilControlFinancimientoStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotAfter
    public void ingresarPlanActual() {
        page.altaMovilControlFinancimientoPage().selectPlanActual();
    }

    @ScreenShotBefore
    public void ingresarPlanMovil() {
        page.altaMovilControlFinancimientoPage().selectPlanMovil();
    }

    @ScreenShotAfter
    public void seleccionarCampania() {
        page.altaMovilControlFinancimientoPage().selectCampania();
    }

    @ScreenShotBefore
    public void btnSeleccionarOferta() {
        page.altaMovilControlFinancimientoPage().selectBtnOferta();
    }

    @ScreenShotBefore
    public void seleccionarLineaNueva() {
        page.altaMovilControlFinancimientoPage().selectBtnLineaNueva();
    }

    @ScreenShotAfter
    public void btnAgregarEquipo() {
        page.altaMovilControlFinancimientoPage().selectBtnAgregarEquipo();
    }

    @ScreenShotBefore
    public void seleccionarEquipo() {
        page.altaMovilControlFinancimientoPage().selectBtnEquipo();
    }

    @ScreenShotBefore
    public void seleccionarBtnIniciarRegistro() {
        page.altaMovilControlFinancimientoPage().selectBtnIniciarRegistro();
    }

    @ScreenShotAfter
    public String validarTituloIniciarRegistro() {
        return page.altaMovilControlFinancimientoPage().validateTituloIniciarRegistro();
    }

    @ScreenShotAfter
    public void ingresarBtnPostpago() {
        page.altaMovilControlFinancimientoPage().selectBtnPostpago();
    }

    @ScreenShotAfter
    public void ingresarBtnControl() {
        page.altaMovilControlFinancimientoPage().selectBtnControl();
    }

    public void completarDatosClienteExtranjeroMovilFinanciado(DataTable datosCliente) {
        String fechaNac = UtilWeb.getValueFromDataTable(datosCliente, "fechaNac");
        String estadoCivil = UtilWeb.getValueFromDataTable(datosCliente, "estadoCivil");
        String dir = UtilWeb.getValueFromDataTable(datosCliente, "direccion");

        page.altaMovilControlFinancimientoPage().ingresarFechaNac(fechaNac);
        page.altaMovilControlFinancimientoPage().seleccionoNacionalidad();
        page.altaMovilControlFinancimientoPage().seleccionarEstadoCivil(estadoCivil);
        page.altaMovilControlFinancimientoPage().seleccionoDepartamento();
        page.altaMovilControlFinancimientoPage().seleccionoProvincia();
        page.altaMovilControlFinancimientoPage().seleccionoDistrito();
        page.altaMovilControlFinancimientoPage().ingresarDireccion(dir);
        scenario.printFullView();
        page.altaMovilControlFinancimientoPage().selectBtnConfirmar();

    }

    @ScreenShotAfter
    public String validarSeleccionarEquipo() {
        return page.altaMovilControlFinancimientoPage().validateTituloSeleccionarEquipo();
    }

    @ScreenShotAfter
    public void seleccionoElPlanQueDesea(String planMovil) {
        page.altaMovilControlFinancimientoPage().clickPlanMovil(planMovil);
    }
    @ScreenShotAfter
    public void doyClickEnBotonSiguiente() {
        page.altaMovilControlFinancimientoPage().clickEnBotonSiguiente();
    }
}
