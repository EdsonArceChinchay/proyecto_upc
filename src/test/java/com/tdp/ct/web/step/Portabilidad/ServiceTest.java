package com.tdp.ct.web.step.Portabilidad;

import com.jayway.jsonpath.JsonPath;
import com.tdp.ct.web.legacy.datasession.SessionData;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;

@Component
public class ServiceTest {

    private static String consultation = "";

    public String readerJson(String path) {
        String jsonFile = System.getProperty("user.dir") + "/src/test/resources" + path;
        File file = new File(jsonFile);
        String body = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            return new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void preValidate() {
        String body = readerJson("/features/Portabilidad/JsonRequest/preValidate.json");
        String consultation1 = given()
                .header("unica-application", "FrontEnd")
                .header("unica-pid", "e7165d6c-3c53-4c0e-afd9-67a01b476855")
                .header("unica-serviceid", "8dcf22a1-129d-4bf5-84f2-22f438bac469")
                .header("unica-user", "jpachaot")
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/ms-fesimple-portability-certi-preprod/fesimple/api/v1/portability/prevalidateportin/")
                .then().statusCode(200).extract().path("previousConsultationId");
        System.out.println("previousConsultationId: " + consultation1);
        // Separa en 2 grupos el código recibido
        String numero1 = consultation1.substring(0,8);
        String numero2 = consultation1.substring(9,17);
        // La segunda parte del código recibido le resta 1
        int restaNumero2 = Integer.parseInt(numero2) - 1;
        // convierte la segunda parte del código recibido en String
        String numero2Correcto = String.valueOf(restaNumero2);
        // Unimos para obtener el código correcto
        consultation = numero1 + numero2Correcto;
    }

    public void receiveMessage(DataTable dataTable) throws IOException {
        preValidate();
        var telefono = UtilWeb.getValueFromDataTable(dataTable, "telefono");
        var fechaSig = UtilWeb.getValueFromDataTable(dataTable, "Fecha_Sig");
        var fechaFinMes = UtilWeb.getValueFromDataTable(dataTable, "Fecha_FinMes");

        Path filePath = Path.of(System.getProperty("user.dir") + "/src/test/resources/features/Portabilidad/JsonRequest/receive.json");
        String statusBody = Files.readString(filePath);


        statusBody = statusBody.replace("{Code}", consultation);
        statusBody = statusBody.replace("{number}", telefono);
        statusBody = statusBody.replace("{fechaSig}", fechaSig);
        statusBody = statusBody.replace("{fechaFinMes}", fechaFinMes);

        System.out.println("Nuevo Body: " + statusBody);

        String message = given()
                .header("UNICA-ServiceId", "550e8400-e29b-41d4-a716-446655440005")
                .header("UNICA-Application", "FrontendPlatform")
                .header("UNICA-PID", "550e8400-e29b-41d4-a716-446655440011")
                .header("UNICA-User", "UserFrontend")
                .contentType("application/json; charset=UTF-8")
                .body(statusBody)
                .when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/ms-fesimple-portability-certi-preprod/fesimple/api/v1/portability/receivemessageportability")
                .then().statusCode(201).extract().path("message");
    }
}
