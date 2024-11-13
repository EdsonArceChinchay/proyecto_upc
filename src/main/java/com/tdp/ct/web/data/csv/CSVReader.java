package com.tdp.ct.web.data.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {

    private static final String DATA_PATH = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator
            + "data" + File.separator;

    /**
     * Obtener los datos del archivo CSV en formato de DataTable.
     * Para posteriormente insertar la tabla en al seccion de Ejemplos de un Escenario tipo Scenario Outline o Escenario del Esquema
     *
     * @param csvDataFile Nombre del archivo .csv
     * @return Los datos obtenidos (cabeceras, valores por filas) del archivo CSV en formato DataTable String
     */
    protected static String getCSV(String csvDataFile) {
        String newTable = "";
        try (FileReader csvReader = new FileReader(DATA_PATH + csvDataFile)) {
            BufferedReader csvBr = new BufferedReader(csvReader);
            StringBuilder bufferHeaders = getHeaderRow(csvBr);
            StringBuilder bufferBody = getBodyRow(csvBr);
            newTable = bufferHeaders.append("\n")
                    .append(bufferBody).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newTable.trim();
    }

    /**
     * Obtiene el nombre del archivo de datos .csv escrito en el formato requerido para su lectura.
     * <p>
     * Example
     * | file@nombre_del_archivo.csv |
     *
     * @param lineWithFileName Linea especifica del feature leido donde se encuentra el valor file@nombre_del_archivo.csv
     * @return El nombre del archivo ubicado despues del caracter '@'
     */
    protected static String getCSVFileName(String lineWithFileName) {
        lineWithFileName = lineWithFileName.replace("|", "").trim();
        lineWithFileName = lineWithFileName.substring(lineWithFileName.indexOf("@") + 1);
        Logger.getLogger(CSVReader.class.getName())
                .log(Level.INFO, "Get data from csv file >>> \"{0}\"", lineWithFileName);
        return lineWithFileName;
    }

    /**
     * Configura las cabeceras del DataTable a partir de la primera fila en el archivo de datos .csv
     *
     * @param csvBr Lectura buffer del archivo de datos .csv
     * @return Las cabeceras en formato buffer obtenido a partir de la primera fila en el archivo de datos .csv
     */
    protected static StringBuilder getHeaderRow(BufferedReader csvBr) {
        StringBuilder bufferHeaders = new StringBuilder();
        try {
            String titles = csvBr.readLine();
            String[] headers = titles.split(",");
            bufferHeaders.append("| ");
            for (String head : headers)
                bufferHeaders.append(head).append(" | ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferHeaders;
    }

    /**
     * Configura el cuerpo del DataTable a partir de las filas de valores despues de la numero (1) separada para las cabeceras.
     *
     * @param csvBr Lectura buffer del archivo de datos .csv
     * @return El cuerpo del DataTable a partir de las filas de valores despues de la numero (1) separada para las cabeceras.
     */
    protected static StringBuilder getBodyRow(BufferedReader csvBr) {
        String line;
        StringBuilder bufferBody = new StringBuilder();
        int ctdLine = 0;
        try {
            while ((line = csvBr.readLine()) != null) {
                ctdLine++;
                if (ctdLine > 0) {
                    bufferBody.append("| ");
                    String[] row = line.split(",");
                    for (String value : row)
                        bufferBody.append(value).append(" | ");
                    bufferBody.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferBody;
    }

}