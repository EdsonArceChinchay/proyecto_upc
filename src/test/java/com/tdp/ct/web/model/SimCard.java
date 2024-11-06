package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SimCard {
    private int idMaterial;
    private String nameMaterial;
    private String simCard;
    @Setter
    private String status;
    private String warehouse;
    private String environment;

    public SimCard(String simCard, String status) {
        this.simCard = simCard;
        this.status = status;
    }

    public SimCard(int idMaterial, String nameMaterial, String simCard, String status, String warehouse, String environment) {
        this.idMaterial = idMaterial;
        this.nameMaterial = nameMaterial;
        this.simCard = simCard;
        this.status = status;
        this.warehouse = warehouse;
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "idMaterial=" + idMaterial +
                ", nameMaterial='" + nameMaterial + '\'' +
                ", simCard='" + simCard + '\'' +
                ", status='" + status + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", environment='" + environment + '\'' +
                '}';
    }
}