package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

@Component
public class HttpSender {
    private boolean enviarNotificacion = Boolean.parseBoolean(getValueConfig("config", "environment.sendNotification").trim());
    private final String BASE_URL; // URL Base a la que se enviará la solicitud
    private final String[] SENDER_NUMBER; // Número de teléfono al que le llegará el mensaje
    private static final Logger LOGGER = UtilWeb.logger(HttpSender.class); // Logger

    public HttpSender() {
        // Obtener las variables de entorno
        this.BASE_URL = "https://syn-mon.jeffersonriobueno.com/";
//        this.SENDER_NUMBER = env.get("SENDER_NUMBER");
//        this.SENDER_NUMBER = new String[]{"51923094244@c.us","51942964007@c.us","120363231256426271@g.us"};
        this.SENDER_NUMBER = new String[]{"51923094244@c.us"};
        // 51969944146@c.us DANTE
        // 51920004138@c.us CARMEN
        // 51923094244@c.us JEFF
        // 51942964007@c.us JORGE
        // 120363231256426271@g.us INFRA
    }

    private void sendRequest(String url, JSONObject jsonBody, int expectedResponseCode) {
        HttpURLConnection connection = null;
        try {
            LOGGER.log(Level.INFO, "Configurando conexión para URL: {0}", url);
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            LOGGER.log(Level.INFO, "Conexión configurada, enviando datos...");

            String jsonInputString = jsonBody.toString();
            LOGGER.log(Level.INFO, "Cuerpo del mensaje: {0}", jsonInputString);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
                LOGGER.log(Level.INFO, "Datos enviados");
            }

            int responseCode = connection.getResponseCode();
            LOGGER.log(Level.INFO, "Código de respuesta recibido: {0}", responseCode);

            if (responseCode == expectedResponseCode) {
                LOGGER.log(Level.INFO, "Solicitud enviada exitosamente.");
            } else {
                LOGGER.log(Level.WARNING, "Error en la solicitud. Código de respuesta: {0}", responseCode);
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error en el envío de la solicitud: {0}", e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
                LOGGER.log(Level.INFO, "Conexión cerrada.");
            }
        }
    }

    public void sendRunStatus(String transaction, String tags, String status, String keyTest, String keyHu, String seleniumError) {
        LOGGER.log(Level.INFO, "enviarNotificacion : " + enviarNotificacion);
        if (!enviarNotificacion) return;
        LOGGER.log(Level.INFO, "sendRunStatus");

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("app", "DITO");
            jsonBody.put("transaction", transaction);
            jsonBody.put("tags", tags);
            jsonBody.put("status", status);
            jsonBody.put("key_test", keyTest);
            jsonBody.put("key_hu", keyHu);
            jsonBody.put("error_details", seleniumError); // Agrega el error de Selenium al JSON
            jsonBody.put("env", "Prod"); // Tipo de ejecucion Test | Prod
        } catch (JSONException e) {
            throw new RuntimeException("Error inesperado en sendRunStatus: " + e.getMessage());
        }
        String url = BASE_URL + "execution_details";
        sendRequest(url, jsonBody, HttpURLConnection.HTTP_CREATED);
    }

    public void sendDetailsRun(String keyHu) {
        LOGGER.log(Level.INFO, "enviarNotificacion : " + enviarNotificacion);
        if (!enviarNotificacion) return;
        LOGGER.log(Level.INFO, "sendDetailsRun");

        JSONObject jsonBody = new JSONObject();
        try {
            // Agregar "hu" al JSON
            jsonBody.put("hu", keyHu);

            // Convertir SENDER_NUMBER a JSONArray y agregarlo al JSON
            JSONArray jsonArray = new JSONArray();
            for (String sender : SENDER_NUMBER) {
                jsonArray.put(sender);
            }
            jsonBody.put("id", jsonArray);

        } catch (JSONException e) {
            throw new RuntimeException("Error inesperado en sendRunStatus: " + e.getMessage());
        }

        // Construir la URL y enviar la solicitud
        String url = BASE_URL + "send_report";
        sendRequest(url, jsonBody, HttpURLConnection.HTTP_OK);
    }

    /**
     * Desactiva la validación SSL para permitir conexiones a servidores
     * sin certificados válidos. Esto debe usarse únicamente en entornos de
     * desarrollo o pruebas.
     *
     * @throws NoSuchAlgorithmException si no se encuentra el algoritmo SSL/TLS.
     * @throws KeyManagementException si hay un error en la inicialización.
     */
    public void disableSSLValidation() {
        if (!enviarNotificacion) return;

        LOGGER.log(Level.INFO, "Iniciando desactivación de validación SSL...");
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                    }
            };
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            LOGGER.log(Level.INFO, "Validación SSL desactivada exitosamente.");
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            // Manejo más específico de excepciones
            LOGGER.log(Level.SEVERE, "Error al desactivar la validación SSL", e);
        }
    }
}