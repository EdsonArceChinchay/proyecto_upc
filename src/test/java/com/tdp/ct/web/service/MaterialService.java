package com.tdp.ct.web.service;

import com.tdp.ct.web.model.Material;
import com.tdp.ct.web.repository.MaterialRepository;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public String getSimCard(String warehouse, String environment) {
        List<Material> simCards = materialRepository.getSimCards(warehouse, environment);
        if (!simCards.isEmpty()) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "SIM CARD: " + simCards.get(0).getSerialNumber() );
            return simCards.get(0).getSerialNumber();
        }
        return null;
    }

    public String getIMEIByName(String name, String warehouse, String environment) {
        List<Material> imeis = materialRepository.getIMEIs(warehouse, environment, name, "");
        if (!imeis.isEmpty()) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "IMEI: " + imeis.get(0).getSerialNumber() );
            return imeis.get(0).getSerialNumber();
        }
        return null;
    }

    public String getIMEIBySapId(String sapId, String warehouse, String environment) {
        List<Material> imeis = materialRepository.getIMEIs(warehouse, environment, "", sapId);
        if (!imeis.isEmpty()) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "IMEI: " + imeis.get(0).getSerialNumber() );
            return imeis.get(0).getSerialNumber();
        }
        return null;
    }

    public void assignSimCard(String simCard) {
        materialRepository.assignMaterial(simCard);
    }

    public void assignIMEI(String imei) {
        materialRepository.assignMaterial(imei);
    }
}