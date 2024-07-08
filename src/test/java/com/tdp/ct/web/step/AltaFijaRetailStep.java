package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.service.util.UtilWeb.getValueFromDataTable;

@Component
public class AltaFijaRetailStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotAfter
    public void irSeleccionarTipoPlan(String tipoPlan){
        page.altaFijaRetailPage().irSeleccionarTipoPlan(tipoPlan);
    }

    @ScreenShotAfter
    public void irSeleccionarPlan(String nombrePlan){
        page.altaFijaRetailPage().irSeleccionarPlan(nombrePlan);

        UtilWeb.waitForSeconds(1);
        scenario.printFullView();

        page.altaFijaRetailPage().darClickOferta();
    }

    @ScreenShotAfter
    public void clickIrLineaNueva() {
        page.altaFijaRetailPage().irLineaNueva();
    }

    @ScreenShotAfter
    public void irIniciarRegistro(){
        page.altaFijaRetailPage().irIniciarRegistro();
    }

    @ScreenShotAfter
    public void ingresarDatosCliente(DataTable dataTable){
        var fechNacimiento = getValueFromDataTable(dataTable, "fechaNac");
        var nacionalidad = getValueFromDataTable(dataTable, "nacionalidad");
        var estadoCivil = getValueFromDataTable(dataTable, "estado_civil");

        page.altaMovilPostpagoCallCenterPage().ingresarFechaNac(fechNacimiento);
        page.altaMovilPostpagoCallCenterPage().seleccionoNacionalidad(nacionalidad);
        page.altaMovilPostpagoCallCenterPage().seleccionarEstadoCivil(estadoCivil);

        scenario.printFullView();
        UtilWeb.waitForSeconds(2);

        page.altaMovilPrepagoSoloChipTiendaPage().clickConfirmar();
        UtilWeb.waitForSeconds(10);
    }

    @ScreenShotAfter
    public void selectLineWithNumber(String number) {
        page.altaMovilPrepagoSoloChipTiendaPage().selectLineWithNumber(number);
    }
}
