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

    public static org.openqa.selenium.html5.SessionStorage getSessionStorage(WebDriver driver) {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        return webStorage.getSessionStorage();
    }

    public static String getItemSessionStorage(WebDriver driver, String item) {
        org.openqa.selenium.html5.SessionStorage SessionStorage = getSessionStorage(driver);
        return SessionStorage.getItem(item);
    }

    public static String getValueItemSessionStorage(WebDriver driver, String primaryKey, String Key) {
        try {
            String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
            JSONObject jsonObject = new JSONObject(itemLocalStorage);
            return jsonObject.getString(Key);
        } catch (Exception e) {
            Logger.getLogger(SessionStorage.class.getName()).log(Level.INFO, "Error get value of session storage item " + e.getMessage());
            return null;
        }
    }

    public static String getValueJsonObjectSessionStorage(WebDriver driver, String primaryKey, String key) {
        JsonObject jsonObject = getSesionStorageConvertToJSONObject(driver, primaryKey);
        return getValueFromJson(jsonObject, key);
    }

    public static JsonObject getSesionStorageConvertToJSONObject(WebDriver driver, String primaryKey) {
        try {
            String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
            Gson gson = new Gson();
            return gson.fromJson(itemLocalStorage, JsonObject.class);
        } catch (Exception e) {
            Logger.getLogger(SessionStorage.class.getName()).log(Level.INFO, "Error convert session  to json " + e.getMessage());
            return null;
        }
    }

    public static String getValueFromJson(JsonObject jsonObject, String key) {
        String[] parts = key.split("\\.");
        JsonElement current = jsonObject;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (current.isJsonObject()) {
                current = current.getAsJsonObject().get(part);
            } else if (current.isJsonArray()) {
                try {
                    int index = Integer.parseInt(parts[i + 1]);
                    current = current.getAsJsonArray().get(index);
                    i++;
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    Logger.getLogger(SessionStorage.class.getName()).log(Level.SEVERE, "Invalid or out of range index " + e.getMessage());
                    return null;
                }
            } else {
                Logger.getLogger(SessionStorage.class.getName()).log(Level.SEVERE, "Key not found or incorrect data type");
                return null;
            }
        }
        return current.getAsString();
    }

    public static void setValueItemSessionStorage(WebDriver driver, String primaryKey, String key, JSONObject modifiedJson) {
        try {
            String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
            JSONObject jsonObject = new JSONObject(itemLocalStorage);
            JSONArray parentObject1 = modifiedJson.getJSONArray(key);
            String jsonObjectModified = jsonObject.put(key, parentObject1).toString();
            setJsonToSessionStorage(driver, primaryKey, jsonObjectModified);
        } catch (Exception e) {
            Logger.getLogger(SessionStorage.class.getName()).log(Level.SEVERE, "Error set value of session storage item " + e.getMessage());
        }
    }

    public static void setJsonToSessionStorage(WebDriver driver, String key, String modifiedJson) {
        org.openqa.selenium.html5.SessionStorage sessionStorage = getSessionStorage(driver);
        sessionStorage.setItem(key, modifiedJson);
    }
}
