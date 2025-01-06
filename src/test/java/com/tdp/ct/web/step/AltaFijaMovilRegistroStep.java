package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaMovilRegistroStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Cliente cliente;

    @Autowired
    private ManageScenario scenario;

    public void verificarClienteNuevo() {
        cliente.setClienteNuevo(page.altaFijaMovilRegistroPage().esNuevoCliente());
    }

    @ScreenShotAfter
    public void ingresarDatosClienteExtranjero(DataTable datos) {
        if (cliente.isClienteNuevo()) {
            String nombre = UtilWeb.getValueFromDataTable(datos, "nombres");
            String apellidos = UtilWeb.getValueFromDataTable(datos, "apellidos");
            String genero = UtilWeb.getValueFromDataTable(datos, "genero");
            page.altaFijaMovilRegistroPage().ingresarNombreClienteExtranjero(nombre);
            page.altaFijaMovilRegistroPage().ingresarApellidoClienteExtranjero(apellidos);
            page.altaFijaMovilRegistroPage().seleccionarGeneroClienteExtranjero(genero);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @ScreenShotAfter
    public void clicEnCrearCliente() {
        if (cliente.isClienteNuevo()) {
            page.altaFijaMovilRegistroPage().crearCliente();
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }

    }
}
