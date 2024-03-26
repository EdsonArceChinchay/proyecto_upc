package com.tdp.ct.web.model;

import com.tdp.ct.web.WebAutomationApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Cliente {
    @Setter @Getter private boolean clienteNuevo;
    @Setter @Getter private String clienteTest;
    @Setter @Getter private String numeroSolicitud;
    @Setter @Getter private String numeroDocumento;
    @Setter @Getter private List <String> codigosDeOrdenes;

    public Cliente(){

    }

}
