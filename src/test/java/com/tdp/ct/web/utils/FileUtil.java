package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Imei;
import com.tdp.ct.web.model.SimCard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<SimCard> readSimCards(String filePath) throws Exception {
        List<SimCard> simCards = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            simCards.add(new SimCard(parts[0], parts[1]));
        }

        return simCards;
    }

    public static List<Imei> readImeis(String filePath) throws Exception {
        List<Imei> imeis = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            imeis.add(new Imei(parts[0], parts[1], parts[2], parts[3]));
        }

        return imeis;
    }

    public static void saveSimCards(String filePath, List<SimCard> simCards) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SIMCARD;ESTADO\n");  // Write header
            for (SimCard simCard : simCards) {
                writer.write(simCard.getSimCard() + ";" + simCard.getStatus() + "\n");
            }
        }
    }

    public static void saveImeis(String filePath, List<Imei> imeis) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SAPID;NOMBRE;IMEI;ESTADO\n");  // Write header
            for (Imei imei : imeis) {
                writer.write(imei.getSapId() + ";" + imei.getNameMaterial() + ";" + imei.getImei() + ";" + imei.getStatus() + "\n");
            }
        }
    }
}

