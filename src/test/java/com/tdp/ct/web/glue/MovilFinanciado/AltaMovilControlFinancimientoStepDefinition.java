package com.tdp.ct.web.glue.MovilFinanciado;

import com.tdp.ct.web.step.MovilFinanciado.AltaMovilControlFinancimientoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMovilControlFinancimientoStepDefinition {

    @Autowired
    private AltaMovilControlFinancimientoStep altaMovilControlFinancimientoStep;

    @Y("selecciono tipo de oferta alta movil")
    public void ingreso_tipo_de_oferta_alta_movil(DataTable ofertas) {
        var oferta = UtilWeb.getValueFromDataTable(ofertas, "Ofertas_Sugeridas");
        switch (oferta) {
            case "PLAN ACTUAL":
                altaMovilControlFinancimientoStep.ingresarPlanActual();
                break;
            case "PLAN MOVIL":
                altaMovilControlFinancimientoStep.ingresarPlanMovil();
                break;
            case "MOVISTAR TOTAL":
                break;
        }
    }

    @Y("selecciono la campania")
    public void selecciono_campania(DataTable dataTable) {
        var tipo_oferta = UtilWeb.getValueFromDataTable(dataTable, "Tipo_Ofertas");
        switch (tipo_oferta) {
            case "Postpago":
                altaMovilControlFinancimientoStep.ingresarBtnPostpago();
                break;
            case "Control":
                altaMovilControlFinancimientoStep.ingresarBtnControl();
                break;
            case "Caribu":
                break;
            case "Prepago":
                break;
        }
        altaMovilControlFinancimientoStep.seleccionarCampania();

    }

    @Y("selecciono el boton de Seleccionar Oferta")
    public void selecciono_el_boton_Seleccionar_Oferta() {
        altaMovilControlFinancimientoStep.btnSeleccionarOferta();
    }

    @Y("selecciono en linea Nueva")
    public void selecciono_en_linea_nueva() {
        altaMovilControlFinancimientoStep.seleccionarLineaNueva();
    }

    @Y("selecciono en agregar equipo y valido la pantalla de seleccionar equipo:{string}")
    public void seleccionoEnAgregarEquipoYValidoLaPantallaDeSeleccionarEquipo(String addEquipo) {
        altaMovilControlFinancimientoStep.btnAgregarEquipo();
        Assertions.assertEquals(addEquipo, altaMovilControlFinancimientoStep.validarSeleccionarEquipo());
    }

    @Y("selecciono un equipo movil")
    public void selecciono_un_equipo_equipo() {
        altaMovilControlFinancimientoStep.seleccionarEquipo();
    }

    @Y("selecciono el boton de iniciar registro")
    public void selecciono_el_boton_de_iniciar_registro() {
        altaMovilControlFinancimientoStep.seleccionarBtnIniciarRegistro();

    }

    @Entonces("valido la pantalla despues de iniciar registro :{string}")
    public void validoLaPantallaDespuesDeIniciarRegistro(String title) {
        Assertions.assertEquals(title, altaMovilControlFinancimientoStep.validarTituloIniciarRegistro());
    }

    @Y("completo los datos del cliente en alta movil con financiamiento")
    public void completoLosDatosDelClienteMovilFinanciamiento(DataTable datosCliente) {
        altaMovilControlFinancimientoStep.completarDatosClienteExtranjeroMovilFinanciado(datosCliente);
    }

    @Y("selecciono el plan {string} que desea")
    public void seleccionoElPlanQueDesea(String planMovil) {
        altaMovilControlFinancimientoStep.seleccionoElPlanQueDesea(planMovil);
    }

    @Y("doy click en el boton Siguiente")
    public void doyClickEnBotonSiguiente() {
        altaMovilControlFinancimientoStep.doyClickEnBotonSiguiente();
    }
}
