package com.tdp.ct.web.service;

import com.tdp.ct.web.utils.FileUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ApiClient {

    /**
     * Realiza una solicitud POST a la URL especificada con el cuerpo y los encabezados proporcionados.
     *
     * @param url     La URL del endpoint.
     * @param body    El cuerpo de la solicitud a enviar.
     * @param headers Los encabezados a incluir en la solicitud.
     * @return La respuesta de la solicitud como String.
     */
    public String post(String url, String body, Map<String, String> headers) {
        Response response = RestAssured.given()
                .headers(headers)
                .body(body)
                .when()
                .post(url);

        validateResponse(response); // Validar la respuesta antes de devolver el resultado
        return response.asString(); // Retorna la respuesta en forma de String
    }

    /**
     * Realiza una solicitud GET a la URL especificada con los encabezados proporcionados.
     *
     * @param url     La URL del endpoint.
     * @param headers Los encabezados a incluir en la solicitud.
     * @return La respuesta de la solicitud como String.
     */
    public String get(String url, Map<String, String> headers) {
        Response response = RestAssured.given()
                .headers(headers)
                .when()
                .get(url);

        validateResponse(response); // Validar la respuesta antes de devolver el resultado
        return response.asString(); // Retorna la respuesta en forma de String
    }

    /**
     * Método para validar la respuesta de las solicitudes HTTP.
     * Puede lanzar una excepción si la respuesta no es satisfactoria.
     *
     * @param response La respuesta de la solicitud para validar.
     */
    private void validateResponse(Response response) {
        if (response.getStatusCode() < 200 || response.getStatusCode() >= 300) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, response.asPrettyString());
            throw new RuntimeException("Failed: HTTP error code : " + response.getStatusCode());
        }
    }

}