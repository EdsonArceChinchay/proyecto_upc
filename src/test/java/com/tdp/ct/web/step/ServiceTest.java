package com.tdp.ct.web.step;

import io.cucumber.datatable.DataTable;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ServiceTest {


    public void login(){
        String consultationId = given()
                .queryParam("application/json")
                .queryParam("unica-application","FrontEnd")
                .queryParam("unica-pid", "e7165d6c-3c53-4c0e-afd9-67a01b476855")
                .queryParam("unica-serviceid", "8dcf22a1-129d-4bf5-84f2-22f438bac469")
                .queryParam("unica-user","jpachaot")
                .when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/ms-fesimple-portability-certi-preprod/fesimple/api/v1/portability/prevalidateportin/")
                .then().statusCode(200).extract().path("previousConsultationId");
        System.out.println("previousConsultationId" + consultationId);
    }

    public void receiveMessage(DataTable dataTable) {
    }
}
