package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Cliente;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonStepDefinition {
    @Autowired
    private Cliente cliente;
    @Y("cargo los datos para buscar")
    public void regresoPaginaInicio(){
        cliente.setNumeroSolicitud("FE-1036101758");
        cliente.setNumeroDocumento("1100000792");
    }
}
