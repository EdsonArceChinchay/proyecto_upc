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

    @Y("selecciono en linea Nueva")
    public void selecciono_en_linea_nueva() {
        altaMovilControlFinancimientoStep.seleccionarLineaNueva();
    }

}
