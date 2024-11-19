package com.tdp.ct.web.Helper;

import org.apache.commons.codec.binary.Base64;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StringHelper {
    public static String toCamelCase(String s) {
        String[] parts = s.split("_");
        StringBuilder camelCaseString = new StringBuilder();

        for (String part : parts) {
            camelCaseString.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
        }

        return camelCaseString.substring(0, 1).toLowerCase() + camelCaseString.substring(1);
    }

    public static String imageFileToBase64String(String path) {
        try {
            return new String(Base64.encodeBase64(Files.readAllBytes(Paths.get(path))));
        } catch (Exception e) {
            return null;
        }
    }
}
