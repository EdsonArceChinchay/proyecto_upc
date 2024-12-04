package com.tdp.ct.web.utils;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class JsonModifierAgentData {

    public static JSONObject modifyJsonValue(String jsonString, String key, String newValue) {
        try {
            Gson gson = new Gson();
            Data data = gson.fromJson(jsonString, Data.class);
            for (int i = 0; i < data.additionalData.size(); i++) {
                if (data.additionalData.get(i).key.equals(key)) {
                    AdditionalData targetData = data.additionalData.get(i);
                    targetData.value = newValue;
                    break;
                }
            }
            return new JSONObject(gson.toJson(data));
        } catch (Exception e) {
            logSevere("Error modify json values", e.getMessage());
            return null;
        }
    }

    public static String modifyGroup(String metadata, String group, String action) {
        if (metadata == null || group == null || action == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        String[] pairs = metadata.split(";");
        StringBuilder modifiedMetadata = new StringBuilder();

        for (String pair : pairs) {
            if (pair.startsWith("grupos=")) {
                String existingGroups = pair.substring(7); // "grupos=" is 7 chars long
                String newGroups = updateGroups(existingGroups, group, action);
                modifiedMetadata.append("grupos=").append(newGroups).append(";");
            } else {
                modifiedMetadata.append(pair).append(";");
            }
        }

        if (modifiedMetadata.length() > 0) {
            modifiedMetadata.setLength(modifiedMetadata.length() - 1);
        }

        return modifiedMetadata.toString();
    }

    private static String updateGroups(String existingGroups, String group, String action) {
        Set<String> groupSet = new HashSet<>(Arrays.asList(existingGroups.split(",")));

        switch (action.toLowerCase()) {
            case "add":
                groupSet.add(group);
                break;
            case "remove":
                groupSet.remove(group);
                break;
            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }

        return String.join(",", groupSet);
    }

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

}