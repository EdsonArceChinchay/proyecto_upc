package com.tdp.ct.web.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class LocalStorage {

    public static org.openqa.selenium.html5.LocalStorage getLocalStorage(WebDriver driver) {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        return webStorage.getLocalStorage();
    }

    public static String getItemLocalStorage(WebDriver driver, String item) {
        org.openqa.selenium.html5.LocalStorage localStorage = getLocalStorage(driver);
        return localStorage.getItem(item);
    }

    public static String getValueItemLocalStorage(WebDriver driver, String primaryKey, String Key) throws JSONException {
        String itemLocalStorage = getItemLocalStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        return jsonObject.getString(Key);
    }

    public static String setValueItemLocalStorage(WebDriver driver, String primaryKey, String key, JSONObject modifiedJson) throws JSONException {
        String itemLocalStorage = getItemLocalStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        JSONArray parentObject1 = modifiedJson.getJSONArray(key);
        String jsonObjectModified = jsonObject.put(key, parentObject1).toString();
        setJsonToLocalStorage(driver, primaryKey, jsonObjectModified);
        return jsonObjectModified;
    }

    public static void setJsonToLocalStorage(WebDriver driver, String key, String modifiedJson) {
        org.openqa.selenium.html5.LocalStorage localStorage = getLocalStorage(driver);
        localStorage.setItem(key, modifiedJson);
    }
}
