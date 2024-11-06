package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Imei {
    private int idMaterial;
    private String nameMaterial;
    private String imei; // This is the IMEI number
    private String warehouse;
    private String environment;
    private String sapId;
    @Setter
    private String status;

    public Imei(String sapId, String nameMaterial, String imei, String status) {
        this.sapId = sapId;
        this.nameMaterial = nameMaterial;
        this.imei = imei;
        this.status = status;
    }

    public Imei(int idMaterial, String nameMaterial, String imei, String status, String warehouse, String environment, String sapId) {
        this.idMaterial = idMaterial;
        this.nameMaterial = nameMaterial;
        this.imei = imei;
        this.status = status;
        this.warehouse = warehouse;
        this.environment = environment;
        this.sapId = sapId;
    }

    @Override
    public String toString() {
        return "Imei{" +
                "idMaterial=" + idMaterial +
                ", nameMaterial='" + nameMaterial + '\'' +
                ", imei='" + imei + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", environment='" + environment + '\'' +
                ", sapId='" + sapId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
