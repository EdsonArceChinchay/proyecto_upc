package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Imei;
import com.tdp.ct.web.model.SimCard;
import com.tdp.ct.web.service.util.UtilWeb;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class MaterialsManager {

    private List<SimCard> simCards;
    private List<Imei> imeis;
    private String simCardFilePath = System.getProperty("user.dir") + "/src/test/resources/materials/simCard.txt";
    private String imeiFilePath = System.getProperty("user.dir") + "/src/test/resources/materials/imei.txt";

    public MaterialsManager() throws Exception {
        this.simCards = FileUtils.readSimCards(simCardFilePath);
        this.imeis = FileUtils.readImeis(imeiFilePath);
    }

    public MaterialsManager(String simCardFilePath, String imeiFilePath) throws Exception {
        this.simCardFilePath = simCardFilePath;
        this.imeiFilePath = imeiFilePath;
        this.simCards = FileUtils.readSimCards(simCardFilePath);
        this.imeis = FileUtils.readImeis(imeiFilePath);
    }

    public SimCard getAvailableSimCard() {
        for (SimCard simCard : simCards) {
            if ("DISPONIBLE".equals(simCard.getStatus())) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available SimCard: " + simCard.getSimCard());
                return simCard;
            }
        }
        return null;
    }

    public Imei getAvailableImeiBySapId(String sapid) {
        for (Imei imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getSapId().equals(sapid)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available IMEI: " + imei.getImei());
                return imei;
            }
        }
        return null;
    }

    public Imei getAvailableImeiByName(String name) {
        for (Imei imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getNameMaterial().equals(name)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Available Imei: " + imei.getImei());
                return imei;
            }
        }
        return null;
    }

    public void assignSimCard(SimCard simCard) throws IOException {
        if (simCard != null) {
            simCard.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "SimCard: " + simCard.getSimCard() + " assigned.");
            FileUtils.saveSimCards(simCardFilePath, simCards);
        }
    }

    public void assignImei(Imei imei) throws IOException {
        if (imei != null) {
            imei.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "IMEI: " + imei.getImei() + " assigned.");
            FileUtils.saveImeis(imeiFilePath, imeis);
        }
    }
}

