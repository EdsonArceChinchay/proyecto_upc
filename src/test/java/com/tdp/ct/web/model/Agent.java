package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Agent extends Person {
    private String channelName;
    private String channelType;
    private String warehouse;
    private boolean isRetention;

    public Agent() {
        super();
    }

    public Agent(String firstName, String lastName, String documentNumber, String documentType, String channelName, String channelType) {
        super(firstName, lastName, documentNumber, documentType);
        this.channelName = channelName;
        this.channelType = channelType;
        this.isRetention = false;
    }

    public String print() {
        return "Agent [Full Name: " + getFullName() +
                ", Channel Name: " + channelName +
                ", Channel Type: " + channelType +
                ", Document Number: " + getDocumentNumber() +
                ", Document Type: " + getDocumentType() +
                ", Warehouse: " + getWarehouse() +
                ", Is retention: " + isRetention +
                "]";
    }

}