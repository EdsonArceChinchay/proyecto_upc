package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

@Component
public class ExcelUtil {

    public void createExcelFile(String folderPath, String fileName, String sheetName) {
        Workbook workbook = new XSSFWorkbook();
        workbook.createSheet(sheetName);

        // Crear fila de encabezados
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("Campo 1");

        String path = Paths.get(folderPath, fileName).toString() + ".xlsx";
        if (!Files.exists(Path.of(path))) {
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Archivo Excel creado en: " + folderPath + "/" + fileName);
            } catch (FileNotFoundException e) {
                UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No se encontró la ruta: " + folderPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El Archivo Excel ya existe en: " + path.toString());
        }

    }

    public void addRowToExcel(String folderPath, String fileName, String sheetName, String[] data) {
        String filePath = Paths.get(folderPath, fileName).toString() + ".xlsx";

        try (FileInputStream fileIn = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount); // Crear una nueva fila

            // Insertar los datos en las celdas
            for (int i = 0; i < data.length; i++) {
                row.createCell(i).setCellValue(data[i]);
            }

            // Cerrar el FileInputStream antes de escribir el nuevo contenido
            fileIn.close();

            // Abrir FileOutputStream para guardar los cambios
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                workbook.close();
            }

            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Fila añadida al archivo Excel en: " + filePath);
        } catch (FileNotFoundException e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No se encontró el libro Excel: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Pruebas:
//    public static void main(String[] args) {
//        FileUtil fileUtil = new FileUtil();
//        ExcelUtil excelUtil = new ExcelUtil();
//        String folderPath = "Bitacoras";
//        String excelName = "bitacora" + getToday().replace("/", "");
//        String sheetName = "Bitacora";
//        System.out.println(excelName);
//        fileUtil.createDirectory(folderPath);
//        excelUtil.createExcelFile(folderPath, excelName, sheetName);
//        String[] data = {"Valor 1", "Valor 2", "Valor 31"};
//        excelUtil.addRowToExcel(folderPath, excelName, sheetName, data);
//    }
}

