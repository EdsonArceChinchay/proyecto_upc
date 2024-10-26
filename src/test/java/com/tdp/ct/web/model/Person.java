package com.tdp.ct.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String documentType;

    public Person() {
    }

    public Person(String firstName, String lastName, String documentNumber, String documentType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String print() {
        return String.format("Full name: %s, %s:%s", getFullName(), documentType, documentNumber);
    }

}
