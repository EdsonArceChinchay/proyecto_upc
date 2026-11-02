package com.tdp.ct.web.healing;

import java.awt.Color;
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
import java.util.LinkedHashMap;
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
     * Genera un PDF local en español con los indicadores y eventos de reparación.
     * La estimación se configura con -Dhealing.report.minutes-per-repair (30 minutos por defecto).
     */
    public static void generateHealingReportPDF(String outputPath) throws IOException {
        generateHealingReportPDF(outputPath, configuredMinutesPerRepair());
    }

    public static void generateHealingReportPDF(String outputPath, double minutesPerRepair) throws IOException {
        if (outputPath == null || outputPath.trim().isEmpty()) {
            throw new IllegalArgumentException("La ruta de salida del reporte PDF es obligatoria.");
        }
        if (!Double.isFinite(minutesPerRepair) || minutesPerRepair < 0) {
            throw new IllegalArgumentException("Los minutos ahorrados por reparación deben ser un número finito no negativo.");
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
            int textPages = (lines.size() + 49) / 50;
            int pageCount = textPages + 1;
            drawDashboardPage(document, history, stats, minutesPerRepair, pageCount);
            for (int pageIndex = 0; pageIndex < textPages; pageIndex++) {
                PDPage page = new PDPage();
                document.addPage(page);
                try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA_BOLD, 14);
                    content.newLineAtOffset(50, 750);
                    content.showText("REPORTE DE AUTO-REPARACIÓN");
                    content.setFont(PDType1Font.HELVETICA, 9);
                    content.newLineAtOffset(0, -18);
                    content.showText("Página " + (pageIndex + 2) + " de " + pageCount);

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
        logger.log(Level.INFO, "Reporte PDF de auto-reparación generado localmente en: " + output);
    }

    private static final Color COLOR_BLUE = new Color(0, 102, 204);
    private static final Color COLOR_GREEN = new Color(76, 175, 80);
    private static final Color COLOR_RED = new Color(244, 67, 54);
    private static final Color COLOR_ORANGE = new Color(255, 152, 0);
    private static final Color COLOR_GRAY = new Color(224, 224, 224);
    private static final Color COLOR_TEXT = new Color(51, 51, 51);
    private static final Color COLOR_MUTED = new Color(110, 110, 110);
    private static final Color COLOR_CARD = new Color(244, 247, 252);

    private static void drawDashboardPage(PDDocument document,
                                          Map<String, AutoHealingManager.HealingResult> history,
                                          AutoHealingManager.HealingStatistics stats,
                                          double minutesPerRepair, int pageCount) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);
        double savedMinutes = stats.getSuccessful() * minutesPerRepair;

        try (PDPageContentStream c = new PDPageContentStream(document, page)) {
            drawText(c, PDType1Font.HELVETICA_BOLD, 18, 50, 745, "DASHBOARD DE AUTO-REPARACIÓN", COLOR_TEXT);
            drawText(c, PDType1Font.HELVETICA, 9, 50, 730,
                    "Generado: " + Instant.now() + "   |   Página 1 de " + pageCount, COLOR_MUTED);
            c.setNonStrokingColor(COLOR_BLUE);
            c.addRect(50, 722, 512, 2);
            c.fill();

            // Tarjetas de indicadores
            float cardW = 120, cardH = 62, cardY = 645;
            drawCard(c, 50, cardY, cardW, cardH, "AHSR",
                    String.format(Locale.ROOT, "%.1f%%", stats.getAHSR()), COLOR_ORANGE);
            drawCard(c, 182, cardY, cardW, cardH, "Eventos detectados",
                    String.valueOf(stats.getTotal()), COLOR_BLUE);
            drawCard(c, 314, cardY, cardW, cardH, "Reparaciones exitosas",
                    String.valueOf(stats.getSuccessful()), COLOR_GREEN);
            drawCard(c, 446, cardY, cardW - 4, cardH, "Reparaciones fallidas",
                    String.valueOf(stats.getFailed()), COLOR_RED);

            c.setNonStrokingColor(COLOR_CARD);
            c.addRect(50, 595, 512, 36);
            c.fill();
            drawText(c, PDType1Font.HELVETICA_BOLD, 11, 62, 617,
                    String.format(Locale.ROOT, "Tiempo estimado ahorrado: %.2f minutos (%.2f horas)",
                            savedMinutes, savedMinutes / 60), COLOR_TEXT);
            drawText(c, PDType1Font.HELVETICA, 8, 62, 603,
                    String.format(Locale.ROOT, "Estimación: %.2f minutos por reparación exitosa", minutesPerRepair),
                    COLOR_MUTED);

            // Dona + medidor AHSR
            drawText(c, PDType1Font.HELVETICA_BOLD, 12, 50, 570, "Resultado de las reparaciones", COLOR_TEXT);
            drawDonut(c, 140, 490, 62, 36,
                    new double[]{stats.getSuccessful(), stats.getFailed()}, new Color[]{COLOR_GREEN, COLOR_RED});
            drawCenteredText(c, PDType1Font.HELVETICA_BOLD, 12, 140, 487,
                    String.format(Locale.ROOT, "%.0f%%", stats.getAHSR()), COLOR_TEXT);

            drawLegend(c, 240, 520, COLOR_GREEN, "Exitosas: " + stats.getSuccessful());
            drawLegend(c, 240, 500, COLOR_RED, "Fallidas: " + stats.getFailed());
            drawText(c, PDType1Font.HELVETICA, 9, 240, 470, "Tasa de éxito (AHSR)", COLOR_MUTED);
            float gaugeW = 300;
            c.setNonStrokingColor(COLOR_GRAY);
            c.addRect(240, 450, gaugeW, 12);
            c.fill();
            c.setNonStrokingColor(COLOR_GREEN);
            c.addRect(240, 450, (float) (gaugeW * Math.min(100, stats.getAHSR()) / 100.0), 12);
            c.fill();
            if (stats.getTotal() == 0) {
                drawText(c, PDType1Font.HELVETICA, 8, 240, 436, "Sin eventos de reparación en este ciclo.", COLOR_MUTED);
            }

            // Gráficos de barras
            Map<String, Integer> byStrategy = new LinkedHashMap<>();
            Map<String, Integer> byElement = new LinkedHashMap<>();
            for (AutoHealingManager.HealingResult r : history.values()) {
                byStrategy.merge(strategyGroup(r.getStrategy()), 1, Integer::sum);
                byElement.merge(r.getElementName(), 1, Integer::sum);
            }
            drawBarChart(c, 50, 395, "Eventos por estrategia de recuperación", byStrategy, COLOR_BLUE);
            drawBarChart(c, 50, 230, "Eventos por elemento", byElement, COLOR_ORANGE);
        }
    }

    private static String strategyGroup(String strategy) {
        if (strategy == null) {
            return "Desconocida";
        }
        String group = strategy;
        for (String separator : new String[]{" -> ", " #", " score="}) {
            int idx = group.indexOf(separator);
            if (idx > 0) {
                group = group.substring(0, idx);
            }
        }
        return group.trim();
    }

    private static void drawBarChart(PDPageContentStream c, float x, float topY, String title,
                                     Map<String, Integer> data, Color color) throws IOException {
        drawText(c, PDType1Font.HELVETICA_BOLD, 12, x, topY, title, COLOR_TEXT);
        if (data.isEmpty()) {
            drawText(c, PDType1Font.HELVETICA, 9, x, topY - 20, "Sin datos para graficar.", COLOR_MUTED);
            return;
        }
        List<Map.Entry<String, Integer>> rows = new ArrayList<>(data.entrySet());
        rows.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        int max = rows.get(0).getValue();
        float labelW = 190, barMaxW = 280, rowH = 22;
        for (int i = 0; i < Math.min(5, rows.size()); i++) {
            float y = topY - 28 - i * rowH;
            String label = toPdfSafeText(rows.get(i).getKey());
            if (label.length() > 38) {
                label = label.substring(0, 35) + "...";
            }
            drawText(c, PDType1Font.HELVETICA, 8, x, y + 2, label, COLOR_TEXT);
            float w = Math.max(3, barMaxW * rows.get(i).getValue() / max);
            c.setNonStrokingColor(color);
            c.addRect(x + labelW, y - 2, w, 12);
            c.fill();
            drawText(c, PDType1Font.HELVETICA_BOLD, 8, x + labelW + w + 5, y + 2,
                    String.valueOf(rows.get(i).getValue()), COLOR_TEXT);
        }
    }

    private static void drawCard(PDPageContentStream c, float x, float y, float w, float h,
                                 String label, String value, Color accent) throws IOException {
        c.setNonStrokingColor(COLOR_CARD);
        c.addRect(x, y, w, h);
        c.fill();
        c.setNonStrokingColor(accent);
        c.addRect(x, y, 4, h);
        c.fill();
        drawText(c, PDType1Font.HELVETICA_BOLD, 20, x + 14, y + 28, value, accent);
        drawText(c, PDType1Font.HELVETICA, 8, x + 14, y + 12, label, COLOR_MUTED);
    }

    private static void drawLegend(PDPageContentStream c, float x, float y, Color color, String text)
            throws IOException {
        c.setNonStrokingColor(color);
        c.addRect(x, y, 10, 10);
        c.fill();
        drawText(c, PDType1Font.HELVETICA, 10, x + 16, y + 1, text, COLOR_TEXT);
    }

    private static void drawDonut(PDPageContentStream c, float cx, float cy, float outer, float inner,
                                  double[] values, Color[] colors) throws IOException {
        double total = 0;
        for (double v : values) {
            total += v;
        }
        if (total <= 0) {
            values = new double[]{1};
            colors = new Color[]{COLOR_GRAY};
            total = 1;
        }
        double start = Math.PI / 2;
        for (int i = 0; i < values.length; i++) {
            double sweep = values[i] / total * 2 * Math.PI;
            if (sweep <= 0) {
                continue;
            }
            int steps = Math.max(2, (int) Math.ceil(sweep / (Math.PI / 90)));
            c.setNonStrokingColor(colors[i]);
            for (int k = 0; k <= steps; k++) {
                double a = start - sweep * k / steps;
                float px = (float) (cx + outer * Math.cos(a));
                float py = (float) (cy + outer * Math.sin(a));
                if (k == 0) {
                    c.moveTo(px, py);
                } else {
                    c.lineTo(px, py);
                }
            }
            for (int k = steps; k >= 0; k--) {
                double a = start - sweep * k / steps;
                c.lineTo((float) (cx + inner * Math.cos(a)), (float) (cy + inner * Math.sin(a)));
            }
            c.closePath();
            c.fill();
            start -= sweep;
        }
    }

    private static void drawText(PDPageContentStream c, PDType1Font font, float size, float x, float y,
                                 String text, Color color) throws IOException {
        c.beginText();
        c.setFont(font, size);
        c.setNonStrokingColor(color);
        c.newLineAtOffset(x, y);
        c.showText(toPdfSafeText(text));
        c.endText();
    }

    private static void drawCenteredText(PDPageContentStream c, PDType1Font font, float size, float cx, float y,
                                         String text, Color color) throws IOException {
        float width = font.getStringWidth(toPdfSafeText(text)) / 1000 * size;
        drawText(c, font, size, cx - width / 2, y, text, color);
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
        lines.add("Generado: " + Instant.now());
        lines.add("");
        lines.add("INDICADORES CLAVE");
        lines.add("AHSR (Tasa de éxito de Auto-Healing): "
                + String.format(Locale.ROOT, "%.2f%%", stats.getAHSR()));
        lines.add("Eventos de reparación detectados: " + stats.getTotal());
        lines.add("Reparaciones exitosas: " + stats.getSuccessful());
        lines.add("Reparaciones fallidas: " + stats.getFailed());
        lines.add("Tiempo estimado ahorrado: " + String.format(Locale.ROOT, "%.2f minutos", savedMinutes));
        lines.add("Ahorro estimado por reparación exitosa: "
                + String.format(Locale.ROOT, "%.2f minutos", minutesPerRepair));
        lines.add("");
        lines.add("DETALLE DE EVENTOS DE REPARACIÓN");
        lines.add("--------------------------------------------------------------------------------");

        List<AutoHealingManager.HealingResult> events = new ArrayList<>(history.values());
        events.sort(Comparator.comparingLong(AutoHealingManager.HealingResult::getTimestamp));
        if (events.isEmpty()) {
            lines.add("No se registraron eventos de reparación en este ciclo de pruebas.");
        } else {
            int index = 1;
            for (AutoHealingManager.HealingResult event : events) {
                lines.add(index++ + ". " + (event.isSuccess() ? "REPARADO" : "NO REPARADO")
                        + " | " + Instant.ofEpochMilli(event.getTimestamp()));
                addWrapped(lines, "   Elemento: " + event.getElementName());
                addWrapped(lines, "   Estrategia de recuperación: " + event.getStrategy());
                addWrapped(lines, "   Localizador original: "
                        + (event.getOriginalLocator() == null ? "No disponible" : event.getOriginalLocator()));
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
