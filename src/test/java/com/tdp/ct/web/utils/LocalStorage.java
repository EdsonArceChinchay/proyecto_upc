package com.tdp.ct.web.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalStorage {

    public static org.openqa.selenium.html5.LocalStorage getLocalStorage(WebDriver driver) {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        return webStorage.getLocalStorage();
    }

    public static String getItemLocalStorage(WebDriver driver, String item) {
        org.openqa.selenium.html5.LocalStorage localStorage = getLocalStorage(driver);
        return localStorage.getItem(item);
    }

    public static String getValueItemLocalStorage(WebDriver driver, String primaryKey, String Key) {
        try {
        String itemLocalStorage = getItemLocalStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        return jsonObject.getString(Key);
        } catch (Exception e) {
            Logger.getLogger(LocalStorage.class.getName()).log(Level.INFO, "Error get value of local storage item " + e.getMessage());
            return null;
        }
    }

    public static String setValueItemLocalStorage(WebDriver driver, String primaryKey, String key, JSONObject modifiedJson) {
        try {
        String itemLocalStorage = getItemLocalStorage(driver, primaryKey);
        JSONObject jsonObject = new JSONObject(itemLocalStorage);
        JSONArray parentObject1 = modifiedJson.getJSONArray(key);
        String jsonObjectModified = jsonObject.put(key, parentObject1).toString();
        setJsonToLocalStorage(driver, primaryKey, jsonObjectModified);
        return jsonObjectModified;
        } catch (Exception e) {
            Logger.getLogger(LocalStorage.class.getName()).log(Level.INFO, "Error get value of local storage item " + e.getMessage());
            return null;
        }
    }

    public static void setJsonToLocalStorage(WebDriver driver, String key, String modifiedJson) {
        org.openqa.selenium.html5.LocalStorage localStorage = getLocalStorage(driver);
        localStorage.setItem(key, modifiedJson);
    }
}
