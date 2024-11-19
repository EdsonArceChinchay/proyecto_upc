package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Customer {
    @Setter
    @Getter
    private String customerTest;
    @Setter
    @Getter
    private String nameCustomer;
    @Setter
    @Getter
    private String documentType;
    @Setter
    @Getter
    private String documentNumber;
    @Setter
    @Getter
    private String salesCode;
    @Setter
    @Getter
    private List<String> ordersCode;
    @Setter
    @Getter
    private boolean isNewCustomer;

    public Customer() {
    }
}
