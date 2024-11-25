package com.tdp.ct.web.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HeaderService {

    public Map<String, String> getAksBerserkersHeaders() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json; charset=UTF-8");
        headerMap.put("UNICA-Application", "FrontEnd");
        headerMap.put("UNICA-ServiceId", "8dcf22a1-129d-4bf5-84f2-22f438bac469");
        headerMap.put("UNICA-PID", "e7165d6c-3c53-4c0e-afd9-67a01b476855");
        headerMap.put("UNICA-User", "UserFrontend");
        return headerMap;
    }

    public Map<String, String> getApimBerserkersHeaders() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json; charset=UTF-8");
        headerMap.put("Ocp-Apim-Subscription-Key", "caa80390fcd14eddb4fec1013ec7f201");
        headerMap.put("X-IBM-Client-Id", "c02a3410-1a23-4e3a-b812-b06f8886e004");
        headerMap.put("X-IBM-Client-Secret", "F7mW4pU3gC7gM7hI3fQ1dU0gX1dX8tV4yJ2wE1sW3eT0aY0oD3");
        return headerMap;
    }
}