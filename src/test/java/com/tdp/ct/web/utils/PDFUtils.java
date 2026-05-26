package com.tdp.ct.web.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class PDFUtils {

    public static String leerTextoPDF(String ruta) {
        try (PDDocument document = PDDocument.load(new File(ruta))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo PDF: " + e.getMessage());
        }
    }
}
