package com.tdp.ct.web.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class SessionStorage {

    public static org.openqa.selenium.html5.SessionStorage getSessionStorage(WebDriver driver) {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        return webStorage.getSessionStorage();
    }

    public static String getItemSessionStorage(WebDriver driver, String item) {
        org.openqa.selenium.html5.SessionStorage SessionStorage = getSessionStorage(driver);
        return SessionStorage.getItem(item);
    }

    public static String getValueItemSessionStorage(WebDriver driver, String primaryKey, String Key) throws JSONException {
        String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        return jsonObject.getString(Key);
    }

    public static String setValueItemSessionStorage(WebDriver driver, String primaryKey, String key, JSONObject modifiedJson) throws JSONException {
        String itemLocalStorage = getItemSessionStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        JSONArray parentObject1 = modifiedJson.getJSONArray(key);
        String jsonObjectModified = jsonObject.put(key, parentObject1).toString();
        setJsonToSessionStorage(driver, primaryKey, jsonObjectModified);
        return jsonObjectModified;
    }

    public static void setJsonToSessionStorage(WebDriver driver, String key, String modifiedJson) {
        org.openqa.selenium.html5.SessionStorage sessionStorage = getSessionStorage(driver);
        sessionStorage.setItem(key, modifiedJson);
    }
}
