package com.tdp.ct.web.step;

import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Helper.*;
import static io.restassured.RestAssured.given;

@Component
public class ServiceTest {

    private static String consultation = "";
    private final String URL_AKS = "https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/";

    public void testPfxKey() {
        String password = getValueConfig("credential.certificate.password");
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("src/test/resources/certificado/apim-client-certificate.pfx"), password.toCharArray());

            SSLSocketFactory clientAuthFactory = new SSLSocketFactory(keyStore, password);
            SSLConfig config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();

            RestAssured.config = RestAssured.config().sslConfig(config);

        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error al cargar el almacén de claves." + e.getMessage());
            e.printStackTrace();
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

    public void portability(String endpointPath, String jsonPath, String value) {
        testPfxKey();
        String body = readJson(jsonPath);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Endpoint: " + (URL_AKS + endpointPath));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Value: " + value);
        String consultation1 = given().headers(headersAksBerserkers())
                .body(body).when()
                .post(URL_AKS + endpointPath)
                .then().statusCode(200).extract().path(value);
        UtilWeb.logger(this.getClass()).log(Level.INFO, value + ": " + consultation1);

        String numero1 = consultation1.substring(0, 9); // Separa en 2 grupos el código recibido
        String numero2 = consultation1.substring(9, 17); // La segunda parte del código recibido le resta 1
        String numero2Correcto = String.valueOf(Integer.parseInt(numero2) - 1); // convierte la segunda parte del código recibido en String
        consultation = numero1 + numero2Correcto;         // Unimos para obtener el código correcto
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Correct " + value + ": " + consultation);
    }

    public void serviceManager(String service) {
        switch (service) {
            case "prevalidateportin":
                portability("fesimple/api/v1/portability/prevalidateportin", "/json/portaNormal/preValidate.json", "previousConsultationId");
                break;
            case "requestportin":
                portability("fesimple/api/v1/portability/prevalidateportin", "/json/portaNormal/preValidate.json", "previousConsultationId");
                break;
            default:
                consultation = generate18DigitString();
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Correct: " + consultation);

        }
    }

    public String modifyJson(DataTable dataTable) {
        var telefono = UtilWeb.getValueFromDataTable(dataTable, "telefono");
        var fechaSig = UtilWeb.getValueFromDataTable(dataTable, "Fecha_Sig");
        var fechaFinMes = UtilWeb.getValueFromDataTable(dataTable, "Fecha_FinMes");
        var baseDate = getCurrentDateFormatted("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        Path filePath = Path.of(System.getProperty("user.dir") + "/src/test/resources/json/portaNormal/receive.json");

        String statusBody = "";

        try {
            Files.readString(filePath)
                    .replace("{Code}", consultation)
                    .replace("{number}", telefono)
                    .replace("{fechaSig}", fechaSig)
                    .replace("{fechaFinMes}", fechaFinMes)
                    .replace("{baseDate}", baseDate);
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR - " + e.getMessage());

        }

        UtilWeb.logger(this.getClass()).log(Level.INFO, "New Body:" + statusBody);

        return statusBody;

    }

    public void receiveMessage(DataTable dataTable) {
        testPfxKey();

        String statusBody = modifyJson(dataTable);
        String message = given().headers(headersAksBerserkers())
                .body(statusBody)
                .when()
                .post(URL_AKS + "fesimple/api/v1/portability/receivemessageportability")
                .then().statusCode(201).extract().path("message");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Message: " + message);
    }

    public Map<String, String> getSalesLead(String codigoVenta) throws JSONException {
        testPfxKey();
        String FE = codigoVenta.trim();
        Map<String, String> parameter = new HashMap<>();

        if (!FE.isEmpty()) {
            String response = given().headers(headersAksBerserkers())
                    .when()
                    .get(URL_AKS + "fesimple/v2/saleslead/" + FE)
                    .getBody().asString();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Response FE: " + response);

            JSONArray additionalData = new JSONObject(response).getJSONArray("commercialOperation")
                    .getJSONObject(0).getJSONArray("additionalData");

            for (int i = 0; i < additionalData.length(); i++) {
                try {
                    String key = additionalData.getJSONObject(i).getString("key");
                    String value = additionalData.getJSONObject(i).getString("value");
                    if (key.equalsIgnoreCase("CAEQ") || key.equalsIgnoreCase("CAPL") || key.equalsIgnoreCase("CASI")) {
                        parameter.put(key, value);
                    }
                } catch (JSONException e) {
                    UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR");
                    e.printStackTrace();
                }
            }

        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No se envio el codigo de Venta");
        }
        return parameter;
    }

    public String getCodeToken(DataTable dataTable, String salesCode) {
        UtilWeb.waitForSeconds(10);
        String URL_AZURE = "https://apimngr-genesis-cert.azure-api.net/";

        try {
            String idTransaction = getIdTransactionOfSaleslead(salesCode);
            var documentType = UtilWeb.getValueFromDataTable(dataTable, "documentType");
            var documentNumber = UtilWeb.getValueFromDataTable(dataTable, "documentNumber");
            var phoneNumber = UtilWeb.getValueFromDataTable(dataTable, "phoneNumber");

            Path filePath = Path.of(System.getProperty("user.dir") + "/src/test/resources/json/portaDirecta/movistarToken.json");
            String statusBody = Files.readString(filePath)
                    .replace("{documentType}", documentType)
                    .replace("{documentNumber}", documentNumber)
                    .replace("{idTransaction}", idTransaction)
                    .replace("{phoneNumber}", phoneNumber);

            UtilWeb.logger(this.getClass()).log(Level.INFO, "New Body " + statusBody);

            String token = given().headers(headersAksBerserkers()).headers(headersApimBerserkers())
                    .body(statusBody)
                    .when().post(URL_AZURE + "api-ne-generartoken-movistartokenapi-op/v1/token")
                    .then().statusCode(200).extract().path("token");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Token: " + token);
            return token;

        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "ERROR! Get code token " + e.getMessage());
            return null;
        }
    }

    private String getIdTransactionOfSaleslead(String salesCode) {
        testPfxKey();
        String idTransaction = given().headers(headersAksBerserkers())
                .when()
                .get(URL_AKS + "fesimple/v2/saleslead/" + salesCode.trim())
                .then().statusCode(200).extract().path("id");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "idTransaction: " + idTransaction);
        return idTransaction;
    }

}

