package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Material;
import com.tdp.ct.web.service.util.UtilWeb;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class MaterialsManager {

    private List<Material> simCards;
    private List<Material> imeis;
    private String simCardFilePath = System.getProperty("user.dir") + "/src/test/resources/materials/simCard.txt";
    private String imeiFilePath = System.getProperty("user.dir") + "/src/test/resources/materials/imei.txt";

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
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available SIM CARD: " + simCard.getSerialNumber());
                return simCard;
            }
        }
        return null;
    }

    public Material getAvailableImeiBySapId(String sapid) {
        for (Material imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getSapId().equals(sapid)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available IMEI: " + imei.getSerialNumber());
                return imei;
            }
        }
        return null;
    }

    public Material getAvailableImeiByName(String name) {
        for (Material imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getNameMaterial().equals(name)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available IMEI: " + imei.getSerialNumber());
                return imei;
            }
        }
        return null;
    }

    public void assignSimCard(Material simCard) throws IOException {
        if (simCard != null) {
            simCard.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "SIM CARD: " + simCard.getSerialNumber() + " assigned.");
            FileUtils.saveSimCards(simCardFilePath, simCards);
        }
    }

    public void assignImei(Material imei) throws IOException {
        if (imei != null) {
            imei.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "IMEI: " + imei.getSerialNumber() + " assigned.");
            FileUtils.saveIMEIs(imeiFilePath, imeis);
        }
    }
}

