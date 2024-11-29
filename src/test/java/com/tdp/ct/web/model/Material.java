package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Material {
    private int idMaterial;
    private String nameMaterial;
    private String serialNumber;
    private String status;
    private String warehouse;
    private String environment;
    private String sapId;

    public Material() {
    }

    public Material(String sapId, String nameMaterial, String imei, String status) {
        this.sapId = sapId;
        this.nameMaterial = nameMaterial;
        this.serialNumber = imei;
        this.status = status;
    }

    public Material(String simCard, String status) {
        this.nameMaterial = simCard;
        this.status = status;
    }

}