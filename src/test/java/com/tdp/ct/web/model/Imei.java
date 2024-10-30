package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Imei {
    private String sapId;
    private String name;
    private String imei;
    @Setter
    private String status;

    // Constructor
    public Imei(String sapId, String name, String imei, String status) {
        this.sapId = sapId;
        this.name = name;
        this.imei = imei;
        this.status = status;
    }


}
