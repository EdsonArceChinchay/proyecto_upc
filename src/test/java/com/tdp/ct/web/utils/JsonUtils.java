package com.tdp.ct.web.utils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class JsonUtils {

    /**
     * Método reutilizable para extraer valores de un string JSON.
     *
     * @param jsonString El string JSON desde el cual se extraerá el valor.
     * @param key        La clave del valor que se desea extraer.
     * @return El valor correspondiente a la clave, o un mensaje de error si no se encuentra.
     */
    public static String extractValue(String jsonString, String key) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.optString(key, null);
        } catch (JSONException e) {
            logSevere("Error parsing JSON", e.getMessage());
            return null;
        } catch (Exception e) {
            logSevere("An error occurred", e.getMessage());
            return "";
        }
    }

}