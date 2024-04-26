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
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Helper.getValueConfig;
import static io.restassured.RestAssured.given;

import org.apache.http.conn.ssl.SSLSocketFactory;

@Component
public class ServiceTest {

    private static String consultation = "";

    public void testPfxKey() {
        String password = getValueConfig("credential.certificate.password");
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("src/test/resources/certificado/apim-client-certificate.pfx"), password.toCharArray());

            SSLSocketFactory clientAuthFactory = new SSLSocketFactory(keyStore, password);
            SSLConfig config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();

            RestAssured.config = RestAssured.config().sslConfig(config);

        } catch (Exception ex) {
            System.out.println("Error al cargar el almacén de claves.");
            ex.printStackTrace();
        }
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

    public Map<String, String> headersApimBerserkers() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Ocp-Apim-Subscription-Key", "caa80390fcd14eddb4fec1013ec7f201");
        headerMap.put("X-IBM-Client-Id", "c02a3410-1a23-4e3a-b812-b06f8886e004");
        headerMap.put("X-IBM-Client-Secret", "F7mW4pU3gC7gM7hI3fQ1dU0gX1dX8tV4yJ2wE1sW3eT0aY0oD3");
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
        testPfxKey();
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
        testPfxKey();
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
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Response del FE es: " + response);

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
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No se envio el codigo de Venta");
        }
        return parametros;
    }



    public String getCodeToken(DataTable dataTable, String codigoVenta) throws IOException {
//String typeDocument, String numberDocument, String numberPhone

        String idTransaction = getIdTransactionOfSaleslead(codigoVenta);
        var typeDocument = UtilWeb.getValueFromDataTable(dataTable, "typeDocument");
        var numberDocument = UtilWeb.getValueFromDataTable(dataTable, "numberDocument");
        var numberPhone = UtilWeb.getValueFromDataTable(dataTable, "numberPhone");

        Path filePath = Path.of(System.getProperty("user.dir") + "/src/test/resources/features/Portabilidad/JsonRequest/movistarToken.json");
        String statusBody = Files.readString(filePath);

        statusBody = statusBody.replace("{typeDocument}", typeDocument);
        statusBody = statusBody.replace("{numberDocument}", numberDocument);
        statusBody = statusBody.replace("{idTransaction}", idTransaction);
        statusBody = statusBody.replace("{numberPhone}", numberPhone);

        System.out.println("Nuevo Body: " + statusBody);

        String token = given().headers(headersAksBerserkers()).headers(headersApimBerserkers())
                .body(statusBody).when().post("https://apimngr-genesis-cert.azure-api.net/api-ne-generartoken-movistartokenapi-op/v1/token")
                .then().statusCode(200).extract().path("token");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Token: " + token);

        return token;
    }

    private String getIdTransactionOfSaleslead(String codigoVenta) {
        testPfxKey();
        String FE = codigoVenta.trim();
        String idTransaction = given().headers(headersAksBerserkers())
                .when()
                .get("https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/fesimple/v2/saleslead/" + FE)
                .then().statusCode(200).extract().path("id");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "idTransaction: " + idTransaction);

        return idTransaction;
    }


}

