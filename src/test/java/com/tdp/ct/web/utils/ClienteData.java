package com.tdp.ct.web.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteData {
    private String tipoDocumento;
    private String nroDocumento;
    private String nombreCliente;
    private String tipoPlanDelCliente;
    private String numeroDeLinea;
    private String nombrePlan;
    private String tipoPlan;
    private String componentesPlan;
    private String estadoDePlan;
    private String estadoDeuda;
    private String cantidadDeDeuda;
    private String planIPTV;
    private String ordenEnVuelo;
    private String tecnologiaDelPlan;
    private String velocidadRedPlan;
    private String sva;
    private String direccionAFibra;
    private String verSiTieneEtiquetaFibra;
    private String cicloDeFacturacion;
    private String antiguedad;
    private String direccion;
    private String estadoDireccion;
    private String tecnologiaAMigrar;
    private String saltoCero;

    public ClienteData(String tipoDocumento, String nroDocumento, String nombreCliente, String tipoPlanDelCliente, String numeroDeLinea, String nombrePlan, String tipoPlan, String componentesPlan, String estadoDePlan, String estadoDeuda, String cantidadDeDeuda, String planIPTV, String ordenEnVuelo, String tecnologiaDelPlan, String velocidadRedPlan, String sva, String direccionAFibra, String verSiTieneEtiquetaFibra, String cicloDeFacturacion, String antiguedad, String direccion, String estadoDireccion, String tecnologiaAMigrar, String saltoCero) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombreCliente = nombreCliente;
        this.tipoPlanDelCliente = tipoPlanDelCliente;
        this.numeroDeLinea = numeroDeLinea;
        this.nombrePlan = nombrePlan;
        this.tipoPlan = tipoPlan;
        this.componentesPlan = componentesPlan;
        this.estadoDePlan = estadoDePlan;
        this.estadoDeuda = estadoDeuda;
        this.cantidadDeDeuda = cantidadDeDeuda;
        this.planIPTV = planIPTV;
        this.ordenEnVuelo = ordenEnVuelo;
        this.tecnologiaDelPlan = tecnologiaDelPlan;
        this.velocidadRedPlan = velocidadRedPlan;
        this.sva = sva;
        this.direccionAFibra = direccionAFibra;
        this.verSiTieneEtiquetaFibra = verSiTieneEtiquetaFibra;
        this.cicloDeFacturacion = cicloDeFacturacion;
        this.antiguedad = antiguedad;
        this.direccion = direccion;
        this.estadoDireccion = estadoDireccion;
        this.tecnologiaAMigrar = tecnologiaAMigrar;
        this.saltoCero = saltoCero;
    }
}