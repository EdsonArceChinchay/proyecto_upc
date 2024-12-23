package com.tdp.ct.web.step;

import com.tdp.ct.web.config.SSLConfigurator;
import com.tdp.ct.web.service.ApiClient;
import com.tdp.ct.web.service.HeaderService;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.tdp.ct.web.utils.DateUtils.*;
import static com.tdp.ct.web.utils.FileUtils.readJson;
import static com.tdp.ct.web.utils.JsonUtils.extractValue;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

@Component
public class ServiceTest {

    private static final String URL_AKS = "https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/";
    private static String consultation = "";
    private final ApiClient apiClient;
    private final HeaderService headerService;

    @Autowired
    public ServiceTest(ApiClient apiClient, SSLConfigurator sslConfigurator, HeaderService headerService) {
        this.apiClient = apiClient;
        this.headerService = headerService;
        sslConfigurator.configureSSL();
    }

    public void portability(String endpointPath, String jsonPath, String value) {
        String body = readJson(jsonPath);
        logInfo("Endpoint: " + (URL_AKS + endpointPath));
        logInfo("Value: " + value);
        String consultationResult = extractValue(apiClient.post(URL_AKS + endpointPath, body, headerService.getAksBerserkersHeaders()), value);
        updateConsultation(value, consultationResult);
    }

    private void updateConsultation(String value, String consultationResult) {
        String parteOne = consultationResult.substring(0, 9);
        String parteTwoCorrected = String.valueOf(Integer.parseInt(consultationResult.substring(9, 17)) - 1);
        consultation = parteOne + parteTwoCorrected;
        logInfo("Correct " + value + ": " + consultation);
    }

    public void serviceManager(String service) {
        switch (service) {
            case "prevalidateportin":
                portability("fesimple/api/v1/portability/requestportin",
                        "src/test/resources/json/portaNormal/preValidate.json", "previousConsultationId");
                break;
            case "requestportin":
                portability("fesimple/api/v1/portability/requestportin",
                        "src/test/resources/json/portaDirecta/requestPortIn.json", "previousConsultationNumber");
                break;
            default:
                consultation = generate18DigitString();
                logInfo("Correct: " + consultation);
        }
    }

    public String modifyJson(DataTable dataTable) {
        String phoneNumber = UtilWeb.getValueFromDataTable(dataTable, "phoneNumber");
        String nextDay = getNextDayFormatted("yyyy-MM-dd");
        String endOfMonthNextDay = getEndOfMonthNextDayFormatted("yyyy-MM-dd");
        String baseDate = getFormattedCurrentDate("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        String statusBody = "";

        try {
            statusBody = readJson("src/test/resources/json/portaNormal/receive.json")
                    .replace("{code}", consultation)
                    .replace("{phoneNumber}", phoneNumber)
                    .replace("{nextDay}", nextDay)
                    .replace("{endOfMonthNextDay}", endOfMonthNextDay)
                    .replace("{baseDate}", baseDate);
        } catch (Exception e) {
            logSevere("ERROR", e.getMessage());
        }

        logInfo("New Body:\n" + statusBody);
        return statusBody;
    }

    public void receiveMessage(DataTable dataTable) {
        String message = extractValue(apiClient.post(URL_AKS + "fesimple/api/v1/portability/receivemessageportability",
                modifyJson(dataTable), headerService.getAksBerserkersHeaders()), "message");
        logInfo("Message: " + message);
    }

    public Map<String, String> getSalesLead(String salesCode) {
        String FE = salesCode.trim();
        Map<String, String> parameter = new HashMap<>();

        if (!FE.isEmpty()) {
            String response = apiClient.get(URL_AKS + "fesimple/v2/saleslead/" + FE, headerService.getAksBerserkersHeaders());
            logInfo("Response FE: " + response);
            JSONArray additionalData = null;
            try {
                additionalData = new JSONObject(response)
                        .getJSONArray("commercialOperation")
                        .getJSONObject(0)
                        .getJSONArray("additionalData");
            } catch (JSONException e) {
                logSevere("ERROR get additional data" + e.getMessage());
            }

            for (int i = 0; i < additionalData.length(); i++) {
                try {
                    String key = additionalData.getJSONObject(i).getString("key");
                    String value = additionalData.getJSONObject(i).getString("value");
                    if (key.equalsIgnoreCase("CAEQ") || key.equalsIgnoreCase("CAPL") || key.equalsIgnoreCase("CASI")) {
                        parameter.put(key, value);
                    }
                } catch (JSONException e) {
                    logSevere("ERROR parsing additional data", e.getMessage());
                }
            }
        } else {
            logInfo("No se envió el código de Venta");
        }
        return parameter;
    }

    public String getCodeToken(DataTable dataTable, String salesCode) {
        String URL_AZURE = "https://apimngr-genesis-cert.azure-api.net/";

        String token = extractValue(apiClient.post(URL_AZURE + "api-ne-generartoken-movistartokenapi-op/v1/token",
                modifyBody(dataTable, salesCode), headerService.getApimBerserkersHeaders()), "token");
        logInfo("Token: " + token);

        return token;
    }

    private String getIdTransactionOfSalesLead(String salesCode) {
        String idTransaction = extractValue(apiClient.get(URL_AKS + "fesimple/v2/saleslead/" + salesCode.trim(),
                headerService.getAksBerserkersHeaders()), "id");
        logInfo("idTransaction: " + idTransaction);
        return idTransaction;
    }

    public String modifyBody(DataTable dataTable, String salesCode) {
        String newBody;
        try {
            String idTransaction = getIdTransactionOfSalesLead(salesCode);
            String documentType = UtilWeb.getValueFromDataTable(dataTable, "documentType");
            String documentNumber = UtilWeb.getValueFromDataTable(dataTable, "documentNumber");
            String phoneNumber = UtilWeb.getValueFromDataTable(dataTable, "phoneNumber");

            newBody = readJson("src/test/resources/json/portaDirecta/movistarToken.json")
                    .replace("{documentType}", documentType)
                    .replace("{documentNumber}", documentNumber)
                    .replace("{idTransaction}", idTransaction)
                    .replace("{phoneNumber}", phoneNumber);

            logInfo("New Body: " + newBody);
        } catch (Exception e) {
            logSevere("ERROR!", e.getMessage());
            return null;
        }
        return newBody;
    }

}