package com.tdp.ct.web.utils;

import com.tdp.ct.web.model.Material;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.tdp.ct.web.utils.DateUtils.getFormattedCurrentDate;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class FileUtils {
    private static final String APPLICATION_PROPERTIES_PATH = "src/test/resources/application.properties";
    private static final String CONFIG_PROPERTIES_PATH = "src/test/resources/config.properties";

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
        String overrideValue = getOverrideValue(properties, key);
        if (overrideValue != null) {
            logInfo(String.format("Key: %s - value from override", key));
            return overrideValue;
        }

        String path = getPropertiesPath(properties);
        Properties properties1 = new Properties();
        try {
            properties1.load(new FileInputStream(path));
        } catch (IOException e) {
            logSevere(String.format("Error in read values %s", e.getMessage()));
            throw new RuntimeException(String.format("Error in read values %s", key));
        }
        logInfo(String.format("Key: %s - value: %s", key, properties1.getProperty(key)));
        return properties1.getProperty(key);
    }

    private static String getPropertiesPath(String properties) {
        return properties.equalsIgnoreCase("config") ? CONFIG_PROPERTIES_PATH : APPLICATION_PROPERTIES_PATH;
    }

    private static String getOverrideValue(String properties, String key) {
        String exactProperty = System.getProperty(key);
        if (exactProperty != null) {
            return exactProperty;
        }

        String namespacedProperty = System.getProperty(buildOverrideKey(properties, key));
        if (namespacedProperty != null) {
            return namespacedProperty;
        }

        String envValue = System.getenv(toEnvironmentVariableName(properties, key));
        if (envValue != null) {
            return envValue;
        }

        return null;
    }

    private static String buildOverrideKey(String properties, String key) {
        return properties.toLowerCase() + "." + key;
    }

    private static String toEnvironmentVariableName(String properties, String key) {
        return (properties + "_" + key)
                .toUpperCase()
                .replace('.', '_')
                .replace('-', '_');
    }

    public static String getAbsolutePathString(String relativePath) {
        return getAbsolutePath(relativePath).toString();
    }

    public static Path getAbsolutePath(String relativePath) {
        Path absolutePath = Paths.get(relativePath).toAbsolutePath();
        logSevere(String.format("Absolute path: %s", absolutePath));
        return absolutePath;
    }

    public static void createDirectory(String path) {
        Path absolutePath = getAbsolutePath(path);
        if (!Files.exists(absolutePath)) {
            try {
                Files.createDirectories(absolutePath);
                logInfo(String.format("Directory created in: %s", path));
            } catch (IOException e) {
                logSevere(String.format("ERROR! - %s", e.getMessage()));
            }
        } else {
            logInfo("The directory already exists");
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
                        logInfo(String.format("File deleted: %s", file1.getName()));
                    }
                }
            } else {
                logInfo("The folder is empty");
            }
        } else {
            logInfo("The specified path is not a valid folder");
        }
    }

    public static String readJson(String relativePath) {
        try {
            return java.nio.file.Files.readString(getAbsolutePath(relativePath));
        } catch (IOException e) {
            logSevere(String.format("Error reading JSON file - %s", e.getMessage()));
            return null;
        }
    }

    public static void downloadPDF(String url, String downloadDir) {
        try (PDDocument document = PDDocument.load(new URL(url).openStream());
             FileOutputStream outputFile = new FileOutputStream(new File(downloadDir, url.substring(url.lastIndexOf("/") + 1)))) {
            document.save(outputFile);
            logInfo((String.format("PDF downloaded to: %s", downloadDir)));
        } catch (IOException e) {
            logSevere(String.format("Error downloading PDF - %s", e.getMessage()));
        }
    }

    public static void saveHTMLCode(WebDriver driver) {
        String naneFile = String.format("codigoHTML_%s.html", getFormattedCurrentDate("yyyy-MM-dd-(HH-mm-ss)"));
        String path = getAbsolutePathString("target/html");
        createDirectory(naneFile);
        String pathFile = path + File.separator + naneFile;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String htmlCode = (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            fileWriter.write(htmlCode);
            fileWriter.close();
            logInfo(String.format("The %s file has been successfully saved in %s", naneFile, pathFile));
        } catch (IOException e) {
            logSevere(String.format("Error saving file %s in %s - %s", naneFile, pathFile, e.getMessage()));
        }
    }

    public static boolean saveScreenshot(WebElement webElement, String path) {
        try {
            File image = webElement.getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(image, new File(path));
            logInfo(String.format("Screenshot saved in: %s", path));
            return true;
        } catch (Exception e) {
            logSevere(String.format("Error saving screenshot: %s", e.getMessage()));
            return false;
        }
    }

}
