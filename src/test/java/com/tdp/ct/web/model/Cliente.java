package com.tdp.ct.web.model;

import com.tdp.ct.web.WebAutomationApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Cliente {
    @Setter @Getter private boolean clienteNuevo;
    @Setter @Getter String clienteTest;
    @Setter @Getter String numeroSolicitud;
    @Setter @Getter String numeroDocumento;
    @Setter @Getter List <String> codigosDeOrdenes;

    public Cliente(){

    }

}
