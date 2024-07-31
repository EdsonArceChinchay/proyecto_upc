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

    @Y("selecciono en linea Nueva")
    public void selecciono_en_linea_nueva() {
        altaMovilControlFinancimientoStep.seleccionarLineaNueva();
    }
}
