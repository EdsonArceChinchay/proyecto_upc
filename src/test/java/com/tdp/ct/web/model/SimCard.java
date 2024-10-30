package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SimCard {
    private String number;
    @Setter
    private String status;

    public SimCard(String number, String status) {
        this.number = number;
        this.status = status;
    }

}
