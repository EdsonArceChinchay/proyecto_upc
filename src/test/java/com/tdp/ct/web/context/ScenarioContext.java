package com.tdp.ct.web.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    // Clase para poder controlar el contexto en sesiones paralelas

    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.getOrDefault(key, "");
    }

    // Método para obtener un valor del contexto con un valor predeterminado si no existe
    public String getOrDefault(String key, String defaultValue) {
        return (String) data.getOrDefault(key, defaultValue);
    }

    public void clear() {
        data.clear(); // Para limpiar el contexto después de cada escenario si es necesario
    }
}
