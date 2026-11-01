package com.tdp.ct.web.healing;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Utilidad para generar reportes del sistema de Auto-Healing
 */
public class HealingReporter {
    private static final Logger logger = Logger.getLogger(HealingReporter.class.getName());

    /**
     * Genera un reporte detallado de healing
     * @param outputPath Ruta donde se guardará el reporte
     */
    public static void generateHealingReport(String outputPath) throws IOException {
        Map<String, AutoHealingManager.HealingResult> history = AutoHealingManager.getHealingHistory();
        AutoHealingManager.HealingStatistics stats = AutoHealingManager.getStatistics();

        try (FileWriter writer = new FileWriter(outputPath, true)) {
            writer.write("\n" + "=".repeat(80) + "\n");
            writer.write("AUTO-HEALING REPORT\n");
            writer.write("=".repeat(80) + "\n");
            writer.write("Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "\n\n");

            // Estadísticas generales
            writer.write(stats.toString() + "\n\n");

            // Detalles de cada healing
            writer.write("HEALING DETALLES:\n");
            writer.write("-".repeat(80) + "\n");

            if (history.isEmpty()) {
                writer.write("No healing events registrados.\n");
            } else {
                int index = 1;
                for (Map.Entry<String, AutoHealingManager.HealingResult> entry : history.entrySet()) {
                    AutoHealingManager.HealingResult result = entry.getValue();
                    writer.write(String.format(
                        "%d. Element: %s\n   Strategy: %s\n   Success: %s\n   Original Locator: %s\n   Timestamp: %d\n\n",
                        index++,
                        result.getElementName(),
                        result.getStrategy(),
                        result.isSuccess() ? "✓ YES" : "✗ NO",
                        result.getOriginalLocator() != null ? result.getOriginalLocator() : "N/A",
                        result.getTimestamp()
                    ));
                }
            }

            writer.write("=".repeat(80) + "\n");
        }

        logger.log(Level.INFO, "✓ Reporte de healing generado en: " + outputPath);
    }

    /**
     * Genera un reporte en formato HTML
     * @param outputPath Ruta donde se guardará el HTML
     */
    public static void generateHealingReportHTML(String outputPath) throws IOException {
        Map<String, AutoHealingManager.HealingResult> history = AutoHealingManager.getHealingHistory();
        AutoHealingManager.HealingStatistics stats = AutoHealingManager.getStatistics();

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang='es'>\n");
        html.append("<head>\n");
        html.append("  <meta charset='UTF-8'>\n");
        html.append("  <title>Auto-Healing Report</title>\n");
        html.append("  <style>\n");
        html.append("    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }\n");
        html.append("    .container { background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }\n");
        html.append("    h1 { color: #333; border-bottom: 3px solid #0066cc; padding-bottom: 10px; }\n");
        html.append("    .stats { background-color: #e3f2fd; padding: 15px; border-radius: 5px; margin: 20px 0; }\n");
        html.append("    .stat-item { display: inline-block; margin: 10px 20px 10px 0; }\n");
        html.append("    .stat-value { font-size: 24px; font-weight: bold; color: #0066cc; }\n");
        html.append("    .stat-label { color: #666; font-size: 14px; }\n");
        html.append("    table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
        html.append("    thead { background-color: #0066cc; color: white; }\n");
        html.append("    th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }\n");
        html.append("    tr:hover { background-color: #f9f9f9; }\n");
        html.append("    .success { color: #4caf50; font-weight: bold; }\n");
        html.append("    .failed { color: #f44336; font-weight: bold; }\n");
        html.append("    .timestamp { color: #999; font-size: 12px; }\n");
        html.append("  </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("  <div class='container'>\n");
        html.append("    <h1>Auto-Healing Report</h1>\n");
        html.append("    <p class='timestamp'>Generated: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "</p>\n");

        // Estadísticas
        html.append("    <div class='stats'>\n");
        html.append("      <div class='stat-item'>\n");
        html.append("        <div class='stat-value'>").append(stats.getTotal()).append("</div>\n");
        html.append("        <div class='stat-label'>Total Attempts</div>\n");
        html.append("      </div>\n");
        html.append("      <div class='stat-item'>\n");
        html.append("        <div class='stat-value' style='color: #4caf50;'>").append(stats.getSuccessful()).append("</div>\n");
        html.append("        <div class='stat-label'>Successful</div>\n");
        html.append("      </div>\n");
        html.append("      <div class='stat-item'>\n");
        html.append("        <div class='stat-value' style='color: #f44336;'>").append(stats.getFailed()).append("</div>\n");
        html.append("        <div class='stat-label'>Failed</div>\n");
        html.append("      </div>\n");
        html.append("      <div class='stat-item'>\n");
        html.append("        <div class='stat-value' style='color: #ff9800;'>").append(String.format("%.2f%%", stats.getSuccessRate())).append("</div>\n");
        html.append("        <div class='stat-label'>Success Rate</div>\n");
        html.append("      </div>\n");
        html.append("    </div>\n");

        // Tabla de detalles
        html.append("    <table>\n");
        html.append("      <thead>\n");
        html.append("        <tr>\n");
        html.append("          <th>#</th>\n");
        html.append("          <th>Element Name</th>\n");
        html.append("          <th>Strategy</th>\n");
        html.append("          <th>Status</th>\n");
        html.append("          <th>Original Locator</th>\n");
        html.append("        </tr>\n");
        html.append("      </thead>\n");
        html.append("      <tbody>\n");

        if (!history.isEmpty()) {
            int index = 1;
            for (Map.Entry<String, AutoHealingManager.HealingResult> entry : history.entrySet()) {
                AutoHealingManager.HealingResult result = entry.getValue();
                String statusClass = result.isSuccess() ? "success" : "failed";
                String statusText = result.isSuccess() ? "✓ Success" : "✗ Failed";

                html.append("        <tr>\n");
                html.append("          <td>").append(index++).append("</td>\n");
                html.append("          <td>").append(result.getElementName()).append("</td>\n");
                html.append("          <td>").append(result.getStrategy()).append("</td>\n");
                html.append("          <td class='").append(statusClass).append("'>").append(statusText).append("</td>\n");
                html.append("          <td>").append(result.getOriginalLocator() != null ? result.getOriginalLocator() : "N/A").append("</td>\n");
                html.append("        </tr>\n");
            }
        } else {
            html.append("        <tr>\n");
            html.append("          <td colspan='5'>No healing events registered</td>\n");
            html.append("        </tr>\n");
        }

        html.append("      </tbody>\n");
        html.append("    </table>\n");
        html.append("  </div>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(html.toString());
        }

        logger.log(Level.INFO, "✓ Reporte HTML de healing generado en: " + outputPath);
    }

    /**
     * Imprime estadísticas de healing en consola
     */
    public static void printStatistics() {
        AutoHealingManager.HealingStatistics stats = AutoHealingManager.getStatistics();
        System.out.println("\n" + "=".repeat(80));
        System.out.println(stats.toString());
        System.out.println("=".repeat(80) + "\n");
        logger.log(Level.INFO, stats.toString());
    }

    /**
     * Generates a local PDF with healing KPIs and repair events.
     * Configure the estimated time saved per repair with
     * -Dhealing.report.minutes-per-repair (defaults to 30 minutes).
     */
    public static void generateHealingReportPDF(String outputPath) throws IOException {
        generateHealingReportPDF(outputPath, configuredMinutesPerRepair());
    }

    public static void generateHealingReportPDF(String outputPath, double minutesPerRepair) throws IOException {
        if (outputPath == null || outputPath.trim().isEmpty()) {
            throw new IllegalArgumentException("La ruta de salida del reporte PDF es obligatoria.");
        }
        if (!Double.isFinite(minutesPerRepair) || minutesPerRepair < 0) {
            throw new IllegalArgumentException("Los minutos ahorrados por reparacion deben ser un numero finito no negativo.");
        }

        Map<String, AutoHealingManager.HealingResult> history = AutoHealingManager.getHealingHistory();
        AutoHealingManager.HealingStatistics stats = AutoHealingManager.getStatistics();
        List<String> lines = buildPdfReportLines(history, stats, minutesPerRepair);
        Path output = Paths.get(outputPath).toAbsolutePath();
        Path parent = output.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (PDDocument document = new PDDocument()) {
            int pageCount = (lines.size() + 49) / 50;
            for (int pageIndex = 0; pageIndex < pageCount; pageIndex++) {
                PDPage page = new PDPage();
                document.addPage(page);
                try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA_BOLD, 14);
                    content.newLineAtOffset(50, 750);
                    content.showText("AUTO-HEALING REPAIR REPORT");
                    content.setFont(PDType1Font.HELVETICA, 9);
                    content.newLineAtOffset(0, -18);
                    content.showText("Page " + (pageIndex + 1) + " of " + pageCount);

                    int start = pageIndex * 50;
                    int end = Math.min(start + 50, lines.size());
                    for (int lineIndex = start; lineIndex < end; lineIndex++) {
                        content.newLineAtOffset(0, -13);
                        content.showText(toPdfSafeText(lines.get(lineIndex)));
                    }
                    content.endText();
                }
            }
            document.save(output.toFile());
        }
        logger.log(Level.INFO, "Reporte PDF de healing generado localmente en: " + output);
    }

    private static double configuredMinutesPerRepair() {
        String configuredValue = System.getProperty("healing.report.minutes-per-repair", "30");
        try {
            return Double.parseDouble(configuredValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Valor invalido para -Dhealing.report.minutes-per-repair: " + configuredValue, e);
        }
    }

    private static List<String> buildPdfReportLines(
            Map<String, AutoHealingManager.HealingResult> history,
            AutoHealingManager.HealingStatistics stats,
            double minutesPerRepair) {
        List<String> lines = new ArrayList<>();
        double savedMinutes = stats.getSuccessful() * minutesPerRepair;
        lines.add("Generated: " + Instant.now());
        lines.add("");
        lines.add("KPIs");
        lines.add("AHSR (Auto-Healing Success Rate): "
                + String.format(Locale.ROOT, "%.2f%%", stats.getAHSR()));
        lines.add("Healing events detected: " + stats.getTotal());
        lines.add("Successfully repaired: " + stats.getSuccessful());
        lines.add("Unrecovered: " + stats.getFailed());
        lines.add("Estimated time saved: " + String.format(Locale.ROOT, "%.2f minutes", savedMinutes));
        lines.add("Estimate per successful repair: "
                + String.format(Locale.ROOT, "%.2f minutes", minutesPerRepair));
        lines.add("");
        lines.add("REPAIR EVENT DETAILS");
        lines.add("--------------------------------------------------------------------------------");

        List<AutoHealingManager.HealingResult> events = new ArrayList<>(history.values());
        events.sort(Comparator.comparingLong(AutoHealingManager.HealingResult::getTimestamp));
        if (events.isEmpty()) {
            lines.add("No repair events were recorded for this test cycle.");
        } else {
            int index = 1;
            for (AutoHealingManager.HealingResult event : events) {
                lines.add(index++ + ". " + (event.isSuccess() ? "REPAIRED" : "NOT REPAIRED")
                        + " | " + Instant.ofEpochMilli(event.getTimestamp()));
                addWrapped(lines, "   Element: " + event.getElementName());
                addWrapped(lines, "   Recovery strategy: " + event.getStrategy());
                addWrapped(lines, "   Original locator: "
                        + (event.getOriginalLocator() == null ? "N/A" : event.getOriginalLocator()));
                lines.add("");
            }
        }
        return lines;
    }

    private static void addWrapped(List<String> lines, String text) {
        String safeText = toPdfSafeText(text);
        while (safeText.length() > 95) {
            int splitAt = safeText.lastIndexOf(' ', 95);
            if (splitAt <= 0) {
                splitAt = 95;
            }
            lines.add(safeText.substring(0, splitAt));
            safeText = "      " + safeText.substring(splitAt).trim();
        }
        lines.add(safeText);
    }

    private static String toPdfSafeText(String text) {
        StringBuilder safe = new StringBuilder();
        for (int offset = 0; offset < text.length();) {
            int codePoint = text.codePointAt(offset);
            offset += Character.charCount(codePoint);
            switch (codePoint) {
                case 0x2013:
                case 0x2014:
                    safe.append('-');
                    break;
                case 0x2018:
                case 0x2019:
                    safe.append('\'');
                    break;
                case 0x201C:
                case 0x201D:
                    safe.append('"');
                    break;
                case 0x2192:
                    safe.append("->");
                    break;
                default:
                    if ((codePoint >= 32 && codePoint <= 126) || (codePoint >= 160 && codePoint <= 255)) {
                        safe.append((char) codePoint);
                    } else if (codePoint > 255) {
                        safe.append('?');
                    }
            }
        }
        return safe.toString();
    }
}
