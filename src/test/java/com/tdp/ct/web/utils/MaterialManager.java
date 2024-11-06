package com.tdp.ct.web.utils;

import com.tdp.ct.web.db.JDBCOperations;
import com.tdp.ct.web.model.Imei;
import com.tdp.ct.web.model.SimCard;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MaterialManager {
    @Autowired
    private JDBCOperations operations;

    private List<SimCard> simCards;
    private List<Imei> imeis;

    public MaterialManager() {
        this.simCards = parseSimCards(operations.select.listMaterialSimCardByState("public.f_listar_materiales_por_estado", 1, "UAT4", "5P36"));
        this.imeis = parseImeis(operations.select.listMaterialIMEIByState("public.f_listar_materiales_por_estado", 1, "UAT4", "5P36", "TMGPESAA346MNESC"));
    }

    public MaterialManager(List<String> rawSimCardData, List<String> rawImeiData) {
        this.simCards = parseSimCards(rawSimCardData);
        this.imeis = parseImeis(rawImeiData);
    }

    private List<SimCard> parseSimCards(List<String> rawSimCardData) {
        List<SimCard> simCards = new ArrayList<>();

        for (String data : rawSimCardData) {
            String[] parts = data.replaceAll("[()]", "").split(",");
            int idMaterial = Integer.parseInt(parts[0].trim());
            String nombreMaterial = parts[1].trim();
            String numeroSerie = parts[3].trim(); // Assuming this is the SIM card field
            String estado = parts[9].trim(); // Estado (1 or 2)
            String estadoStr = estado.equals("1") ? "DISPONIBLE" : "ASIGNADO";
            String almacen = parts[12].trim(); // Almacen
            String ambiente = parts[13].trim(); // Ambiente

            simCards.add(new SimCard(idMaterial, nombreMaterial, numeroSerie, estadoStr, almacen, ambiente));
        }

        return simCards;
    }

    private List<Imei> parseImeis(List<String> rawImeiData) {
        List<Imei> imeis = new ArrayList<>();

        for (String data : rawImeiData) {
            String[] parts = data.replaceAll("[()]", "").split(",");
            int idMaterial = Integer.parseInt(parts[0].trim());
            String nombreMaterial = parts[1].trim();
            String numeroSerie = parts[3].trim(); // Assuming this is the IMEI field
            String estado = parts[9].trim(); // Estado (1 or 2)
            String estadoStr = estado.equals("1") ? "DISPONIBLE" : "ASIGNADO";
            String almacen = parts[12].trim(); // Almacen
            String ambiente = parts[13].trim(); // Ambiente
            String sapId = parts[16].trim(); // sap_id

            imeis.add(new Imei(idMaterial, nombreMaterial, numeroSerie, estadoStr, almacen, ambiente, sapId));
        }

        return imeis;
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

    public void assignSimCard(SimCard simCard) {
        if (simCard != null) {
            simCard.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "SIM CARD: " + simCard.getSimCard() + " assigned.");
            operations.update.updateMaterialBySerialNumber("public.f_actualiza_material", simCard.getSimCard(), 2, "MESAS", "DITO", "AutomationTester");

        }
    }

    public void assignImei(Imei imei) {
        if (imei != null) {
            imei.setStatus("ASIGNADO");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "IMEI: " + imei.getImei() + " assigned.");
            operations.update.updateMaterialBySerialNumber("public.f_actualiza_material", imei.getImei(), 2, "MESAS", "DITO", "AutomationTester");
        }
    }
}
