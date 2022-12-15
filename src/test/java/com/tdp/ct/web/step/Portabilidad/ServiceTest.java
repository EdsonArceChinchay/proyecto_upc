package com.tdp.ct.web.step.Portabilidad;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceTest {

    @Test
    public void login(){
        String consultationId = given().contentType("application/json")
                .formParam("unica-application","FrontEnd")
                .formParam("unica-pid", "e7165d6c-3c53-4c0e-afd9-67a01b476855")
                .formParam("unica-serviceid", "8dcf22a1-129d-4bf5-84f2-22f438bac469")
                .formParam("unica-user","jpachaot")
                .when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/ms-fesimple-portability-certi-preprod/fesimple/api/v1/portability/prevalidateportin/")
                .then().statusCode(201).extract().path("previousConsultationId");
        System.out.println("previousConsultationId" + consultationId);
    }
}
