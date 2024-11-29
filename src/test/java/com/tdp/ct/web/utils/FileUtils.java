package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Material;
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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.DateUtils.getFormattedCurrentDate;

public class FileUtils {
    public static List<Material> readSimCards(String filePath) throws Exception {
        List<Material> simCards = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            simCards.add(new Material(parts[0], parts[1]));
        }

        return simCards;
    }

    public static List<Material> readIMEIs(String filePath) throws Exception {
        List<Material> imeis = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            imeis.add(new Material(parts[0], parts[1], parts[2], parts[3]));
        }

        return imeis;
    }

    public static void saveSimCards(String filePath, List<Material> simCards) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SIMCARD;ESTADO\n");  // Write header
            for (Material simCard : simCards) {
                writer.write(simCard.getSerialNumber() + ";" + simCard.getStatus() + "\n");
            }
        }
    }

    public static void saveIMEIs(String filePath, List<Material> imeis) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SAPID;NOMBRE;IMEI;ESTADO\n");  // Write header
            for (Material imei : imeis) {
                writer.write(imei.getSapId() + ";" + imei.getNameMaterial() + ";" + imei.getSerialNumber() + ";" + imei.getStatus() + "\n");
            }
        }
    }

    public static String getValueConfig(String properties, String key) {
        String path = ((properties.equalsIgnoreCase("config")) ? "src/test/resources/config.properties" : "src/test/resources/application.properties");
        Properties properties1 = new Properties();
        try {
            properties1.load(new FileInputStream(path));
            return properties1.getProperty(key);
        } catch (IOException e) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, String.format("Error in read values %s", e.getMessage()));
            return null;
        }
    }

    public static String getAbsolutePathString(String relativePath) {
        return getAbsolutePath(relativePath).toString();
    }

    public static Path getAbsolutePath(String relativePath) {
        Path absolutePath = Paths.get(relativePath).toAbsolutePath();
        Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, String.format("Absolute path: %s", absolutePath));
        return absolutePath;
    }

    public static void createDirectory(String path) {
        Path absolutePath = getAbsolutePath(path);
        if (!Files.exists(absolutePath)) {
            try {
                Files.createDirectories(absolutePath);
                Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, String.format("Directory created in: %s", path));
            } catch (IOException e) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, String.format("ERROR! - %s", e.getMessage()));
            }
        } else {
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, "The directory already exists.");
        }
    }

    public static void cleanFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (!file1.getName().equalsIgnoreCase(".gitkeep")) {
                        file1.delete();
                        Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, String.format("File deleted: %s", file1.getName()));
                    }
                }
            } else {
                Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, "The folder is empty");
            }
        } else {
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, "The specified path is not a valid folder.");
        }
    }

    public static String readJson(String relativePath) {
        try {
            return java.nio.file.Files.readString(getAbsolutePath(relativePath));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, String.format("Error reading JSON file - %s", e.getMessage()));
            return null;
        }
    }

    public static void downloadPDF(String url, String downloadDir) {
        try (PDDocument document = PDDocument.load(new URL(url).openStream());
             FileOutputStream outputFile = new FileOutputStream(new File(downloadDir, url.substring(url.lastIndexOf("/") + 1)))) {
            document.save(outputFile);
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, (String.format("PDF downloaded to: %s.", downloadDir)));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, String.format("Error downloading PDF - %s", e.getMessage()));
        }
    }

    public static void saveHTMLCode(WebDriver driver) {
        String naneFile = String.format("codigoHTML_%s.html", getFormattedCurrentDate("yyyy-MM-dd-(HH-mm-ss)"));
        String path = getAbsolutePathString("target/html");
        createDirectory(naneFile);
        String pathFile = path + naneFile;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String htmlCode = (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            fileWriter.write(htmlCode);
            fileWriter.close();
            Logger.getLogger(FileUtils.class.getName()).log(Level.INFO, (String.format("El archivo %s se ha guardado correctamente en %s", naneFile, pathFile)));
        } catch (IOException e) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, (String.format("Error al guardar el archivo %s en %s: %s ", naneFile, pathFile, e.getMessage())));
        }
    }
}

