package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.service.util.UtilWeb.getValueFromDataTable;

@Component
public class AltaMovilPrepagoSoloChipTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    public void clickSeleccionarOferta(String oferta) {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionarOferta(oferta);
    }

    @ScreenShotBefore
    public void clickSeleccionaPlan(String plan) {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionaPrepago();
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionaPlan(plan);
    }

    @ScreenShotAfter
    public void clickSeleccionarOferta() {
        page.altaMovilPrepagoSoloChipTiendaPage().seleccionarOferta();
    }

    @ScreenShotAfter
    public void clickIniciarRegistro() {
        page.altaMovilPrepagoSoloChipTiendaPage().entrarIniciarRegistro();
    }

    @ScreenShotAfter
    public void clickIrMovilNuevo() {
        page.altaMovilPrepagoSoloChipTiendaPage().irMovilNuevo();
    }

    @ScreenShotAfter
    public void ingresarDatosCliente(DataTable dataTable) {
        var fechNacimiento = getValueFromDataTable(dataTable, "fechaNac");
        var nacionalidad = getValueFromDataTable(dataTable, "nacionalidad");
        var estadoCivil = getValueFromDataTable(dataTable, "estado_civil");

        page.altaMovilPrepagoSoloChipTiendaPage().ingresarFechaNacimiento(fechNacimiento);
        page.altaMovilPrepagoSoloChipTiendaPage().ingresarNacionalidad(nacionalidad);
        page.altaMovilPrepagoSoloChipTiendaPage().selecEstadoCivil(estadoCivil);
        ingresarUbicacion(dataTable);
    }

    @ScreenShotAfter
    public void ingresarUbicacion(DataTable dataTable) {
        var departamento = getValueFromDataTable(dataTable, "departamento");
        var provincia = getValueFromDataTable(dataTable, "departamento");
        var distrito = getValueFromDataTable(dataTable, "distrito");
        var direccion = getValueFromDataTable(dataTable, "direccion");

        page.altaMovilPrepagoSoloChipTiendaPage().selecDepartamento(departamento);
        page.altaMovilPrepagoSoloChipTiendaPage().selecProvincia(provincia);
        page.altaMovilPrepagoSoloChipTiendaPage().selecDistrito(distrito);
        page.altaMovilPrepagoSoloChipTiendaPage().ingresarDireccion(direccion);
    }

    @ScreenShotBefore
    public void irAConfirmar() {
        page.altaMovilPrepagoSoloChipTiendaPage().clickConfirmar();
    }

    @ScreenShotAfter
    public void clicBotonContinuar() {
        page.altaMovilPrepagoSoloChipTiendaPage().clicBotonContinuar();
    }
}
