package com.tdp.ct.web.utils;

/**
 * Lectura de parámetros de login/Cloudflare desde config.properties.
 */
public final class LoginConfigUtil {

    private LoginConfigUtil() {
    }

    public static String get(String key, String defaultValue) {
        try {
            String value = FileUtils.getValueConfig("config", key);
            if (value == null || value.trim().isEmpty()) {
                return defaultValue;
            }
            return value.trim();
        } catch (RuntimeException e) {
            return defaultValue;
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(get(key, String.valueOf(defaultValue)));
    }

    public static int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(get(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
