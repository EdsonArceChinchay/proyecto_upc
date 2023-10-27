package com.tdp.ct.web.model;

import com.tdp.ct.web.WebAutomationApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class Cliente {
    @Setter @Getter private boolean clienteNuevo;
    @Setter @Getter String clienteTest;
    @Setter @Getter String numeroSolicitud;

    public Cliente(){

    }


}
