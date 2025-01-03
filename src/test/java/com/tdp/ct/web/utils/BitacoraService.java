package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;
import static com.tdp.ct.web.utils.Utils.*;

@Component
public class BitacoraService {
    private final ExcelUtil excelUtil;
    private final FileUtil fileUtil;
    private final String folderPath = "Bitacoras";
    private final String excelName = "bitacora" + getToday().replace("/", "");
    private final String sheetName = "Bitacora";
    private final String segment = "B2C";
    private final String aplication = "Web FrontEnd";

    private boolean generarBitacora = Boolean.parseBoolean(getValueConfig("config", "environment.generateBitacora").trim());

    public BitacoraService(ExcelUtil excelUtil, FileUtil fileUtil) {
        this.excelUtil = excelUtil;
        this.fileUtil = fileUtil;
    }

    public void generarBitacora() {
        if (!generarBitacora) return;

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Generando bitacora...");

        // Verificar y crear la carpeta y el archivo Excel
        fileUtil.createDirectory(folderPath);
        excelUtil.createExcelFile(folderPath, excelName, sheetName);

        // Obtener y procesar las órdenes
        String[] listaDeOrdenes = obtenerListaDeOrdenes((String) getScenarioContext().get("orden"));

        for (String orden : listaDeOrdenes) {
            // Crear los datos para cada orden
            String[] data = crearDatosBitacora(orden);

            // Agregar la fila al Excel
            excelUtil.addRowToExcel(folderPath, excelName, sheetName, replaceBlanksInArray(data, "NA"));
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Bitacora guardada para la orden: " + orden);
        }
    }

    private String[] obtenerListaDeOrdenes(String ordenes) {
        if (ordenes == null || ordenes.trim().isEmpty()) {
            ordenes = "NA";
        }
        ordenes = ordenes.replace("[", "").replace("]", "").trim();
        return ordenes.split("-");
    }

    private String[] crearDatosBitacora(String orden) {
        return new String[]{
                getToday(), calcularTipoVentana(), (String) getScenarioContext().get("analistaQa"),
                getScenarioContext().get("hu") + "/" + getScenarioContext().get("test"),
                (String) getScenarioContext().get("nroDocumento"), (String) getScenarioContext().get("tipoDocumento"),
                segment, (String) getScenarioContext().get("transaccion"), (String) getScenarioContext().get("tipoVenta"),
                aplication, (String) getScenarioContext().get("idCliente"), (String) getScenarioContext().get("usuarioVendedor"),
                orden.trim(), (String) getScenarioContext().get("numeroSolicitud"),
                (String) getScenarioContext().get("codigoAutogestion"), (String) getScenarioContext().get("codigoReclamo"),
                (String) getScenarioContext().get("simcard"), (String) getScenarioContext().get("imei"),
                (String) getScenarioContext().get("nroLinea"), (String) getScenarioContext().get("estadoOrden"), getHostname()
        };
    }
}
