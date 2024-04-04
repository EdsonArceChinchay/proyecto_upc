package com.tdp.ct.web.step.Portabilidad;

import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Component
public class ServiceTest {

    private static String consultation = "";

    public String getTokenOnpremise(){
        String token = given().header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "visid_incap_2970706=ZxBVFiCpR9Gpp63933baa8Ji1mQAAAAAQUIPAAAAAADJhwm1F2UhoUsEb6oKCIyE")
                .body(bodyTokenOnpremise())
                .when().post("https://apisd10.telefonica.com.pe/testing/bss/public/oauth2/token")
                .then().statusCode(200).extract().path("access_token");
        System.out.println("token = " + token);
        return token;
    }

    public Map<String, String> bodyTokenOnpremise() {
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("Content-Type", "73b10ad6fa6ca966b048b65306b817b2");
        bodyMap.put("grant_type", "password");
        bodyMap.put("scope", "scope1");
        bodyMap.put("username", "cs_ex_pr_gapim");
        bodyMap.put("password", "May,09V,66");
        return bodyMap;
    }

    public Map<String, String> headersOnpremiseBerserkers() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json; charset=UTF-8");
        headerMap.put("UNICA-Application", "FrontendPlatform");
        headerMap.put("UNICA-ServiceId", "1f994db3-477e-4c28-86df-0a840783fb08");
        headerMap.put("UNICA-PID", "5f90e0ac-1a35-4985-a158-a62cc52220b3");
        headerMap.put("UNICA-User", "UserFrontend");
        headerMap.put("X-IBM-Client-Id", "73b10ad6fa6ca966b048b65306b817b2");
        headerMap.put("Authorization", "Bearer " + getTokenOnpremise());
        return headerMap;
    }

    public void testPfxKey() {
        FileInputStream instream1 = null;
        KeyStore keyStore = null;
        org.apache.http.conn.ssl.SSLSocketFactory lSchemeSocketFactory = null;
        try {
            instream1 = new FileInputStream(new File("src/test/resources/certificado/apim-client-certificate.pfx"));
            keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(instream1, "pfxfilepwd".toCharArray());
            X509HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            lSchemeSocketFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, "D[e__G8VBTvZ1%wCW-s0");
            lSchemeSocketFactory.setHostnameVerifier(hostnameVerifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().with().sslSocketFactory(lSchemeSocketFactory).and().allowAllHostnames());
        System.out.println(
                RestAssured.given().
                        contentType("application/json").
                        headers(
                                "Accept-Encoding", "gzip,deflate"
                        )
                        .get("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com")
                        .getStatusCode()
        );
    }


    public Map<String, String> headersAksBerserkers() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json; charset=UTF-8");
        headerMap.put("UNICA-Application", "FrontEnd");
        headerMap.put("UNICA-ServiceId", "8dcf22a1-129d-4bf5-84f2-22f438bac469");
        headerMap.put("UNICA-PID", "e7165d6c-3c53-4c0e-afd9-67a01b476855");
        headerMap.put("UNICA-User", "UserFrontend");
        return headerMap;
    }

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
        String consultation1 = given().headers(headersAksBerserkers())
                .body(body).when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/fesimple/api/v1/portability/prevalidateportin")
                .then().statusCode(200).extract().path("previousConsultationId");
        System.out.println("previousConsultationId: " + consultation1);
        // Separa en 2 grupos el código recibido
        String numero1 = consultation1.substring(0, 9);
        String numero2 = consultation1.substring(9, 17);
        // La segunda parte del código recibido le resta 1
        int restaNumero2 = Integer.parseInt(numero2) - 1;
        // convierte la segunda parte del código recibido en String
        String numero2Correcto = String.valueOf(restaNumero2);
        // Unimos para obtener el código correcto
        consultation = numero1 + numero2Correcto;
        System.out.println("Correct previousConsultationId: " + consultation);
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

        String message = given().headers(headersAksBerserkers())
                .body(statusBody).when().post("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/fesimple/api/v1/portability/receivemessageportability")
                .then().statusCode(201).extract().path("message");
    }

    public Map<String, String> getSalesLead(String codigoVenta) throws JSONException {
        testPfxKey();
        String FE = codigoVenta.trim();
        Map<String, String> parametros = new HashMap<>();

        if (!FE.isEmpty()) {
            String response = given().headers(headersAksBerserkers())
                    .when()
                    .get("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/fesimple/v2/saleslead/" + FE)
                    .getBody().asString();
            System.out.println("response = " + response);

            JSONObject jsonResponse = new JSONObject(response);
            JSONArray additionalData = jsonResponse.getJSONArray("commercialOperation")
                    .getJSONObject(0).getJSONArray("additionalData");

            for (int i = 0; i < additionalData.length(); i++) {
                try {
                    String key = additionalData.getJSONObject(i).getString("key");
                    String value = additionalData.getJSONObject(i).getString("value");
                    if (key.equalsIgnoreCase("CAEQ") || key.equalsIgnoreCase("CAPL") || key.equalsIgnoreCase("CASI")) {
                        parametros.put(key, value);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("No se envio el codigo de Venta");
        }
        return parametros;
    }

}

