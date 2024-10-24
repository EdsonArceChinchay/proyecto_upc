package com.tdp.ct.web.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionStorage {

    private static final Logger logger = Logger.getLogger(SessionStorage.class.getName());
    private static final Gson gson = new Gson();

    private static org.openqa.selenium.html5.SessionStorage getSessionStorage(WebDriver driver) {
        return ((WebStorage) new Augmenter().augment(driver)).getSessionStorage();
    }

    public static String getItemSessionStorage(WebDriver driver, String item) {
        return getSessionStorage(driver).getItem(item);
    }

    public static String getValueItemSessionStorage(WebDriver driver, String primaryKey, String key) {
        return getJsonValue(getItemSessionStorage(driver, primaryKey), key);
    }

    public static String getValueJsonObjectSessionStorage(WebDriver driver, String primaryKey, String key) {
        return getValueFromJson(getSessionStorageAsJsonObject(driver, primaryKey), key);
    }

    public static String getValueJsonObjectSessionStorage(JsonObject primaryKey, String key){
        return getValueFromJson(primaryKey, key);
    }

    public static JsonObject getSessionStorageAsJsonObject(WebDriver driver, String primaryKey) {
        return getJsonObject(getItemSessionStorage(driver, primaryKey));
    }

    private static JsonObject getJsonObject(String jsonString) {
        try {
            return gson.fromJson(jsonString, JsonObject.class);
        } catch (Exception e) {
            logger.log(Level.INFO, "Error converting to JsonObject: " + e.getMessage());
            return null;
        }
    }

    private static String getJsonValue(String jsonString, String key) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.optString(key, null);
        } catch (Exception e) {
            logger.log(Level.INFO, "Error getting value from JSON: " + e.getMessage());
            return null;
        }
    }

    public static void setValueItemSessionStorage(WebDriver driver, String primaryKey, String key, JSONObject modifiedJson) {
        try {
            String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
            JSONObject jsonObject = new JSONObject(itemLocalStorage);
            JSONArray parentObject1 = modifiedJson.getJSONArray(key);
            String jsonObjectModified = jsonObject.put(key, parentObject1).toString();
            setJsonToSessionStorage(driver, primaryKey, jsonObjectModified);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error setting value in session storage: " + e.getMessage());
        }
    }

    public static void setValueItemSessionStorage(WebDriver driver, String primaryKey, String key, String modifiedString) {
        try {
            String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
            JSONObject jsonObject = new JSONObject(itemLocalStorage);
            String jsonObjectModified = jsonObject.put(key, modifiedString).toString();
            setJsonToSessionStorage(driver, primaryKey, jsonObjectModified);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error setting value in session storage: " + e.getMessage());
        }
    }

    private static void setJsonToSessionStorage(WebDriver driver, String key, String modifiedJson) {
        getSessionStorage(driver).setItem(key, modifiedJson);
    }

    private static String getValueFromJson(JsonObject jsonObject, String key) {
        String[] parts = key.split("\\.");
        JsonElement current = jsonObject;
        for (int i = 0; i < parts.length; i++) {
            if (current.isJsonObject()) {
                current = current.getAsJsonObject().get(parts[i]);
            } else if (current.isJsonArray()) {
                try {
                    int index = Integer.parseInt(parts[i+1]);
                    current = current.getAsJsonArray().get(index);
                    i++;
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    logger.log(Level.SEVERE, "Invalid or out-of-range index: " + e.getMessage());
                    return null;
                }} else {
                logger.log(Level.SEVERE, "Key not found or incorrect data type");
                return null;
            }
        }
        return current.isJsonNull() ? null : current.getAsString();
    }

}