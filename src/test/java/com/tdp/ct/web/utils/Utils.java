package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static com.tdp.ct.web.lib.WebDriverManager.getDriver;

public class Utils extends WebBase {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static void cargarMsgLog(Level tipo, String mensaje) {
        LOGGER.log(tipo, mensaje);
    }

    public void hacerScroll(String TipoScroll) {
        Actions actions = new Actions(driver());
        switch (TipoScroll.toUpperCase().trim()) {
            case "UP":
                actions.sendKeys(Keys.PAGE_UP).perform();
                break;
            case "DOWN":
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                break;
        }
    }

    public static String getToday() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.now().format(dateFormatter);
    }

    public static String getCurrentTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.now().format(timeFormatter);
    }

    public static String calcularTipoVentana() {

        // Tomo la primera parte que corresponde a la hora
        int horaActual = Integer.parseInt(getCurrentTime().split(":")[0]);

        // Determino si es Diurno o Nocturno
        return (horaActual >= 9 && horaActual <= 21) ? "Diurno" : "Nocturno";
    }

    public static String getHostname() {
        // Función para obtener el hostname del equipo
        try {
            // Obtiene el nombre del host directamente
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            // Maneja la excepción si no se puede determinar el hostname
            return "Desconocido";
        }
    }

    /**
     * Reemplaza los valores vacíos o nulos en un array de Strings con un nuevo valor especificado.
     *
     * @param array    El array de Strings a procesar.
     * @param newValue El valor con el que se reemplazarán los elementos vacíos o nulos en el array.
     * @return El array modificado con los valores vacíos o nulos reemplazados por el nuevo valor.
     */
    public static String[] replaceBlanksInArray(String[] array, String newValue) {
        // Recorre el array para reemplazar los valores vacíos o nulos con el nuevo valor
        for (int i = 0; i < array.length; i++) {
            // Si el valor es nulo o está vacío, lo reemplaza por el valor dado
            if (array[i] == null || array[i].isEmpty()) {
                array[i] = newValue;
            }
        }
        return array; // Retorna el array modificado
    }

    public static void refreshPage(){
        // Crea una instancia de Actions
        Actions actions = new Actions(getDriver());
        // Enviar la tecla F5 para refrescar la página
        actions.sendKeys(Keys.F5).perform();
    }

    public static Map<String, String> loadEnv() {
        Map<String, String> env = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(".env"))) {
            stream.filter(line -> !line.startsWith("#") && line.contains("="))
                    .forEach(line -> {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            env.put(parts[0].trim(), parts[1].trim());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return env;
    }

    public void seleccionarElementoLista(String XPathshadowHost, String XPathShadow, String plan) {
        Logger.getLogger(Utils.class.getName()).log(Level.INFO,"Ingreso a seleccionar un elemento de la lista desplegable");
        WebElement shadowHost = driver().findElement(By.cssSelector(XPathshadowHost));
        JavascriptExecutor js = (JavascriptExecutor) driver();
        String elementShadow = "return arguments[0].shadowRoot.findElement(By.cssSelector('" + XPathShadow + "'))";
        List<WebElement> listaElementos = (List<WebElement>) js.executeScript(elementShadow, shadowHost);
        for (WebElement element : listaElementos) {
            Logger.getLogger(Utils.class.getName()).log(Level.INFO,"Planes de la lista: " + element.getText());
            if (element.getText().contains(plan)) {
                click(element, 5);
                break;
            }
        }
    }
}