package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Imei;
import com.tdp.ct.web.model.SimCard;

import java.io.IOException;
import java.util.List;

public class MaterialsManager {

    private List<SimCard> simCards;
    private List<Imei> imeis;
    private String simCardFilePath;
    private String imeiFilePath;

    public MaterialsManager(String simCardFilePath, String imeiFilePath) throws Exception {
        this.simCardFilePath = simCardFilePath;
        this.imeiFilePath = imeiFilePath;
        this.simCards = FileUtil.readSimCards(simCardFilePath);
        this.imeis = FileUtil.readImeis(imeiFilePath);
    }

    public SimCard getAvailableSimCard() {
        for (SimCard simCard : simCards) {
            if ("DISPONIBLE".equals(simCard.getStatus())) {
                return simCard;
            }
        }
        return null;
    }

    public Imei getAvailableImei(String sapid, String name) {
        for (Imei imei : imeis) {
            if ("DISPONIBLE".equals(imei.getStatus()) && imei.getSapId().equals(sapid) && imei.getName().equals(name)) {
                return imei;
            }
        }
        return null;
    }

    public void assignSimCard(SimCard simCard) throws IOException {
        if (simCard != null) {
            simCard.setStatus("ASIGNADO");
            FileUtil.saveSimCards(simCardFilePath, simCards);
        }
    }

    public void assignImei(Imei imei) throws IOException {
        if (imei != null) {
            imei.setStatus("ASIGNADO");
            FileUtil.saveImeis(imeiFilePath, imeis);
        }
    }
    }

