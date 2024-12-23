package com.tdp.ct.web.model;

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
    @Setter @Getter String direccion;
    @Setter @Getter String planSeleccionado;
    @Setter @Getter List <String> codigosDeOrdenes;

    @Setter @Getter String usuarioVendedor;
    @Setter @Getter String vendedor;
    @Setter @Getter String tiqltHu;
    @Setter @Getter String tipoDocumento;
    @Setter @Getter String tipoVenta;
    @Setter @Getter String horarioVenta;
    @Setter @Getter String nombreCliente;
    @Setter @Getter String numeroTelefono;
    @Setter @Getter String password;
    @Setter @Getter String tipoUsuarioVendedor;
    @Setter @Getter boolean captchaResuelto = false;


}
