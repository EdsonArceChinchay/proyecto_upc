package com.tdp.ct.web.glue;

import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.step.HomeStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeStepDefinition {
    @Autowired
    private WebDriverManager manager;

    @Autowired
    private HomeStep homeStep;

    @Y("selecciono el tipo de documento {string}")
    public void seleccionoElTipoDeDocumento(String tipoDocumento) {
        homeStep.seleccionoTipoDocumento(tipoDocumento);
    }

    @Y("ingreso el documento {string}")
    public void ingresoElDocumento(String documento) {
        homeStep.ingresoDocumento(documento);
    }

    @Y("doy click en el boton consultar")
    public void doyClickEnElBotonConsultar() {
        homeStep.clickBotonConsultar();
    }

}
