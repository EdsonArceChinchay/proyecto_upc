package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Material;

import java.io.IOException;
import java.util.List;

import static com.tdp.ct.web.utils.FileUtils.getAbsolutePathString;
import static com.tdp.ct.web.utils.LogUtils.logInfo;

public class MaterialsManager {

    private final List<Material> simCards;
    private final List<Material> imeis;
    private String simCardFilePath = getAbsolutePathString("src/test/resources/materials/simCard.txt");
    private String imeiFilePath = getAbsolutePathString("src/test/resources/materials/imei.txt");

    public MaterialsManager() throws Exception {
        this.simCards = FileUtils.readSimCards(simCardFilePath);
        this.imeis = FileUtils.readIMEIs(imeiFilePath);
    }

    public MaterialsManager(String simCardFilePath, String imeiFilePath) throws Exception {
        this.simCardFilePath = simCardFilePath;
        this.imeiFilePath = imeiFilePath;
        this.simCards = FileUtils.readSimCards(simCardFilePath);
        this.imeis = FileUtils.readIMEIs(imeiFilePath);
    }

    public Material getAvailableSimCard() {
        for (Material simCard : simCards) {
            if ("DISPONIBLE".equals(simCard.getStatus())) {
                logInfo("Available SIM CARD", simCard.getSerialNumber());
                return simCard;
            }
        }
        return null;
    }

    public Material getAvailableImeiBySapId(String sapid) {
        for (Material imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getSapId().equals(sapid)) {
                logInfo("Available IMEI", imei.getSerialNumber());
                return imei;
            }
        }
        return null;
    }

    public Material getAvailableImeiByName(String name) {
        for (Material imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getNameMaterial().equals(name)) {
                logInfo("Available IMEI", imei.getSerialNumber());
                return imei;
            }
        }
        return null;
    }

    public void assignSimCard(Material simCard) throws IOException {
        if (simCard != null) {
            simCard.setStatus("ASIGNADO");
            logInfo(String.format("SIM CARD: %s assigned.", simCard.getSerialNumber()));
            FileUtils.saveSimCards(simCardFilePath, simCards);
        }
    }

    public void assignImei(Material imei) throws IOException {
        if (imei != null) {
            imei.setStatus("ASIGNADO");
            logInfo(String.format("IMEI: %s assigned.", imei.getSerialNumber()));
            FileUtils.saveIMEIs(imeiFilePath, imeis);
        }
    }
}

