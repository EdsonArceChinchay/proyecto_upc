package com.tdp.ct.web.utils;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonModifierDatosAgente {

    static class Data {
//        String id;
//        String type;
//        String name;
//        String surname;
//        String status;
//        String substatus;
        List<AdditionalData> additionalData;
   /*    List<ContactMedia> contactMedia;
       List<StatusPeriod> statusPeriod;
        List<LegalId> legalId;
*/

    }

    static class AdditionalData {
        String value;
        String key;
    }

    static class StatusPeriod {
        String startDateTime;
        String endDateTime;
    }

    static class ContactMedia {
        String phoneType;
        String type2;
        String addressType;
        String streetNr;
        String number;
        String type;
        String number2;
        String areaCode;
        String stateOrProvince;
        String neighborhoodCode;
        String emailType;
        String phoneType2;
        String neighborhood;
        String region;
        String email;
    }

    static class LegalId {
        String country;
        String nationalID;
        String nationalIDType;
    }

    public static JSONObject modifyJsonValue(String jsonString, String key, String newValue) throws JSONException {
        Gson gson = new Gson();
        Data data = gson.fromJson(jsonString, Data.class);
        for (int i = 0; i < data.additionalData.size(); i++) {
            if (data.additionalData.get(i).key.equals(key)) {
                AdditionalData targetData = data.additionalData.get(i);
                targetData.value = newValue;
                break;
            }
        }
        JSONObject jsonObject = new JSONObject(gson.toJson(data));
        return jsonObject;
    }
}