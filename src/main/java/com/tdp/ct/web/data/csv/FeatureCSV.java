package com.tdp.ct.web.data.csv;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeatureCSV {

    private static final String FEATURE_PATH = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator
            + "features" + File.separator;

    private static final String REGEX_CSV_FILE = "file@";
    private static final String EXPECTED_ANNOTATION_REGEX_CSV = "@CSV";

    static List<String> featuresFiles = new LinkedList<>();
    private static Map<String, String> initFeatureFiles = new LinkedHashMap<>();

    public static Map<String, String> getInitFeatureFiles() {
        return initFeatureFiles;
    }

    public static void setInitFeatureFiles(Map<String, String> initFeatureFiles) {
        FeatureCSV.initFeatureFiles = initFeatureFiles;
    }

    public static void replaceCSVDataOnFeature() {
        List<String> allFiles = getListFilesForFolder();
        List<String> featureFileFiltered = getFilterFeatureFiles(allFiles);
        Logger.getLogger(CSVReader.class.getName())
                .log(Level.INFO, "Only features files to be replaced >>> \n\n \"{0}\"\n", featureFileFiltered);
        replaceCSVDataOnFeature(featureFileFiltered);
    }

    /**
     * Obtiene todos los archivos de tipo Feature *.feature en el directorio
     * --> resources/features/...
     * @return Lista de nombre de archivos ubicados en el directorio --> resources/features/...
     */
    private static List<String> getListFilesForFolder() {
        File folder = new File(FEATURE_PATH);
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                getListFilesForFolder();
            } else {
                featuresFiles.add(fileEntry.getName());
            }
        }

        Logger.getLogger(CSVReader.class.getName())
                .log(Level.INFO, "All files found \"{0}\" >>> \n\n", featuresFiles);

        return featuresFiles;
    }

    private static List<String> getFilterFeatureFiles(List<String> allFiles) {
        List<String> featureFileFiltered = new LinkedList<>();
        for(String files : allFiles){
            String featureFilePath = FEATURE_PATH + files;
            String featureLine;
            //find a file with csv format
            try (FileReader frFinal = new FileReader(featureFilePath)) {
                BufferedReader brFinal = new BufferedReader(frFinal);
                while ((featureLine = brFinal.readLine()) != null)
                    if (featureLine.contains(EXPECTED_ANNOTATION_REGEX_CSV))
                        featureFileFiltered.add(files);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return featureFileFiltered;
    }

    /**
     * Reemplaza el contenido del archivo feature durante la ejecucion con los datos del archivo .csv
     * Para ubicar el archivo de datos .csv se debe utilizar el siguiente formato en un escenario de tipo:
     * Scenario Outline, Esquema del escenario
     * <p>
     * Example
     * | file@nombre_del_archivo.csv |
     * <p>
     * El archivo .csv debe estar ubicado en la ruta: resources/data/*.csv
     *
     * @param featureNames Listsa de nombre del archivo feature a evaluar para reemplazar su contenido
     */
    public static void replaceCSVDataOnFeature(List<String> featureNames) {
        for (String featureName : featureNames)
            replaceCSVDataOnFeature(featureName);
    }

    /**
     * Reemplaza el contenido del archivo feature durante la ejecucion con los datos del archivo .csv
     * Para ubicar el archivo de datos .csv se debe utilizar el siguiente formato en un escenario de tipo:
     * Scenario Outline, Esquema del escenario
     * <p>
     * Example
     * | file@nombre_del_archivo.csv |
     * <p>
     * El archivo .csv debe estar ubicado en la ruta: resources/data/*.csv
     *
     * @param featureName Nombre del archivo feature a evaluar para reemplazar su contenido
     */
    public static void replaceCSVDataOnFeature(String featureName) {
        String featureFilePath = FEATURE_PATH + featureName;
        setSourceFeatureContent(featureFilePath);
        String line;
        //replacedContent
        StringBuilder totalContentReplaced = new StringBuilder();
        try (FileReader frFinal = new FileReader(featureFilePath)) {
            BufferedReader brFinal = new BufferedReader(frFinal);
            while ((line = brFinal.readLine()) != null) {
                if (line.contains(REGEX_CSV_FILE)) {
                    String fileName = CSVReader.getCSVFileName(line);
                    line = line.replace(line, CSVReader.getCSV(fileName));
                }
                totalContentReplaced.append(line).append("\n");
            }

            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.INFO, "New temp feature \"{0}\" >>> \n\n{1}",
                            new Object[]{featureName, totalContentReplaced});
        } catch (IOException e) {
            e.printStackTrace();
        }

        //write replaceContent in featureFile
        try (FileWriter fw = new FileWriter(featureFilePath)) {
            fw.write(totalContentReplaced.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Obtiene y guarda en sesion los siguientes datos del archivo feature antes de reemplazarlo:
     * Ruta origen del archivo feature
     * Contenido origen del archivo feature
     * @param featureFilePath Nombre del archivo feature a evaluar para reemplazar su contenido
     */
    private static void setSourceFeatureContent(String featureFilePath) {
        //initContent
        StringBuilder originalFeatureContent = new StringBuilder();
        try (FileReader frInit = new FileReader(featureFilePath)) {
            BufferedReader brInit = new BufferedReader(frInit);
            String line;
            while ((line = brInit.readLine()) != null)
                originalFeatureContent.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        initFeatureFiles.put(featureFilePath, originalFeatureContent.toString());
        setInitFeatureFiles(initFeatureFiles);
    }

    /**
     * Reinicia el contenido original de el/los archivo(s) Feature(s) guardados en un Mapa de archivos originales
     */
    public static void resetFeatures() {
        //getKey(): feature file path to reset
        //getValue(): origin feature content
        List<String> features = new LinkedList<>();
        for (Map.Entry<String, String> fileToReset : getInitFeatureFiles().entrySet()) {
            String featurePath = fileToReset.getKey();
            String originalContent = fileToReset.getValue();
            try (FileWriter fw = new FileWriter(featurePath)) {
                features.add(featurePath);
                fw.write(originalContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Logger.getLogger(CSVReader.class.getName())
                .log(Level.INFO, "Features that was reset >>> \n\n \"{0}\"\n",features);
    }

}
