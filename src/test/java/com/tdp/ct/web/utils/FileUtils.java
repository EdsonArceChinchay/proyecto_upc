package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Imei;
import com.tdp.ct.web.model.SimCard;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.DateUtils.getFormattedCurrentDate;

public class FileUtils {
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

    public static String getAbsolutePathS(String relativePath) {
        return System.getProperty("user.dir") + relativePath;
    }

    public static Path getAbsolutePath(String relativePath) {
        return Path.of(getAbsolutePathS(relativePath));
    }

    public static String readJson(String relativePath) {
        try {
            return java.nio.file.Files.readString(java.nio.file.Paths.get(getAbsolutePathS(relativePath)));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, "Error reading JSON file", e.getMessage());
            return null;
        }
    }

    public static void downloadPDF(String url, String downloadDir) {
        try (PDDocument document = PDDocument.load(new URL(url).openStream());
             FileOutputStream outputFile = new FileOutputStream(new File(downloadDir, url.substring(url.lastIndexOf("/") + 1)))) {
            document.save(outputFile);
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, (String.format("PDF downloaded to: %s.", downloadDir)));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, "Error downloading PDF", e);
        }
    }

    public static void saveHTMLCode(WebDriver driver) {
        String nombreArchivo = String.format("codigoHTML_%s.html", getFormattedCurrentDate("yyyy-MM-dd-(HH-mm-ss)"));
        String rutabase = getAbsolutePathS("/target/html");
        File directorio = new File(rutabase);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        String rutaArchivo = rutabase + nombreArchivo;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String codigoHTML = (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");
        try {
            FileWriter fileWriter = new FileWriter(new File(rutaArchivo));
            fileWriter.write(codigoHTML);
            fileWriter.close();
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, (String.format("El archivo %s se ha guardado correctamente en %s", nombreArchivo, rutaArchivo)));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, (String.format("Error al guardar el archivo %s en %s: %s ", nombreArchivo, rutaArchivo, e.getMessage())));
        }
    }
}

