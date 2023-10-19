package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.jdbc.Sql;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Addons {
        private static final Logger LOGGER = Logger.getLogger(Addons.class.getName());

        public static void esperaProgresivaLoading(WebDriver driver, int reintentosMax, int segundosEspera, String  sLoadingXPath){
        //USAR SOLO EN ALGUNOS CASOS, CUANDO TIENE UN LOADING DIFERENTE
                LOGGER.log(Level.INFO, "esperaProgresivaLoading(reintentosMax: "+ reintentosMax + ", segundosEspera: " + segundosEspera + ", sLoading: " + sLoadingXPath +  ")");
                long inicio = System.currentTimeMillis();
                int contador = 0;
                boolean bCargando = false;
                do {
                        try {
                                LOGGER.log(Level.INFO, "Buscando Loading ...");
                                By by;
                                by = By.className(sLoadingXPath);
                                WebElement loading = driver.findElement(by);
                                LOGGER.log(Level.INFO, "loading: " + loading.toString());
                                bCargando = true;

                        } catch (Exception e) {
                                bCargando = false;
                                LOGGER.log(Level.INFO, "loading notFound");
                                UtilWeb.waitForSeconds(segundosEspera);
                        }
                        contador++;
                }while(bCargando && contador < reintentosMax);
                long fin = System.currentTimeMillis();
                long tiempoEjecucion = fin - inicio;
                formatTiempo(tiempoEjecucion, "esperaProgresivaLoading");

        }
        public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elementoContenedor, By byBuscarEnContenxto, SearchContext context){
        //USAR SOLO EN ALGUNOS CASOS
                LOGGER.log(Level.INFO, "esperaProgresiva(reintentosMax: "+ reintentosMax + ", segundosEspera: " + segundosEspera + ", byBuscarEnContenxto: " + byBuscarEnContenxto + ")");
                long inicio = System.currentTimeMillis();
                int contador = 0;
                boolean bOK = false;

                UtilWeb.waitForSeconds(1);

                LOGGER.log(Level.INFO, "elementoContenedor: " + elementoContenedor.toString());
                contador = 0;
                do{
                        LOGGER.log(Level.INFO, "esperaProgresiva - Context - Reintento # " + (contador+1) + " => espera: " + segundosEspera*contador);
                        UtilWeb.waitForSeconds(segundosEspera*contador);
                        try{
                                String s = elementoContenedor.getText();
                                bOK = true;
                                LOGGER.log(Level.INFO, "elementoContenedor text: " + s);

                                s = context.findElement(byBuscarEnContenxto).getText();
                                LOGGER.log(Level.INFO, "elementoContenedorContexto text: " + s);

                        }catch(Exception e){
                                LOGGER.log(Level.SEVERE, "error Message: " + e.getMessage());
                                LOGGER.log(Level.SEVERE,"error StackTrace: " + e.getStackTrace());
                        }
                        contador++;
                }while(!bOK && contador < reintentosMax);
                long fin = System.currentTimeMillis();
                long tiempoEjecucion = fin - inicio;
                formatTiempo(tiempoEjecucion, "esperaProgresiva *");
        }

        public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elemento){
        //USAR ESTA ESPERA DE FORMA MASIVA
                LOGGER.log(Level.INFO, "esperaProgresiva(reintentosMax: "+ reintentosMax + ", segundosEspera: " + segundosEspera + ", WebElement: " + elemento.toString()+ ")");
                long inicio = System.currentTimeMillis();
                int contador = 0;
                boolean bOK = false;

                //Detecta el Splash: Telefónica ...
                boolean bCargando = false;
                UtilWeb.waitForSeconds(1);
                do{
                        try {
                                LOGGER.log(Level.INFO, "Buscando Splash ...");
                                By by;
                                //by = By.cssSelector(".splash");
                                //by = By.xpath("//div[@class='splash']");
                                //by = By.xpath("//tdp-loader[contains(@class, 'splash')]");
                                by = By.tagName("tdp-loader");
                                WebElement splashElement = driver.findElement(by);
                                String splashText = splashElement.getText();
                                if(splashText.length()> 0){
                                        bCargando = true;
                                }
                                if(bCargando) {
                                        LOGGER.log(Level.INFO, "Splash detectado: " + splashText + " #" + (contador + 1));
                                        UtilWeb.waitForSeconds(segundosEspera);
                                }

                        } catch (Exception e) {
                                bCargando = false;
                                LOGGER.log(Level.INFO, "Splash notFound");
                        }
                        contador++;
                }while(bCargando && contador < reintentosMax);

                LOGGER.log(Level.INFO, "WebElement: " + elemento.toString());
                contador = 0;
                do{
                        LOGGER.log(Level.INFO, "esperaProgresiva - Reintento # " + (contador+1) + " => espera: " + segundosEspera*contador);
                        UtilWeb.waitForSeconds(segundosEspera*contador);
                        try{
                                String s = elemento.getText();
                                bOK = true;
                                LOGGER.log(Level.INFO, "text: " + s);
                                break;
                        }catch(Exception e){
                                LOGGER.log(Level.SEVERE, "error Message: " + e.getMessage());
                                LOGGER.log(Level.SEVERE,"error StackTrace: " + e.getStackTrace());
                        }
                        contador++;
                }while(!bOK && contador < reintentosMax);
                long fin = System.currentTimeMillis();
                long tiempoEjecucion = fin - inicio;
                formatTiempo(tiempoEjecucion, "esperaProgresiva");
        }
        private static void formatTiempo(long tiempo, String  msg){
                try{
                        if (tiempo < 60000) { // Menor a 1 minuto
                                System.out.println(msg + " - Tiempo de ejecución: " + tiempo / 1000 + " segundos");
                        } else if (tiempo < 3600000) { // Menor a 1 hora
                                long minutos = tiempo / 60000;
                                long segundos = (tiempo % 60000) / 1000;
                                System.out.println(msg + " - Tiempo de ejecución: " + minutos + " minutos y " + segundos + " segundos");
                        } else { // Mayor o igual a 1 hora
                                long horas = tiempo / 3600000;
                                long minutos = (tiempo % 3600000) / 60000;
                                long segundos = (tiempo % 60000) / 1000;
                                System.out.println(msg + " - Tiempo de ejecución: " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
                        }
                }catch(Exception e){

                }
        }
        public static void  revisarModalError(WebDriver driver) {
                boolean bExisteModal = false;
                boolean bReintentar = true;
                int contador = 0;
                int reintentosMax = 3;
                int segundosEspera = 3;
                do {
                        UtilWeb.waitForSeconds(1);
                        LOGGER.log(Level.INFO, "revisarModalError #" + (contador+1) + "/" + reintentosMax);
                        bExisteModal = driver.findElements(By.xpath("//mat-dialog-actions")).size() != 0;
                        if (bExisteModal) {
                                UtilWeb.waitForSeconds(segundosEspera*contador);
                                //UtilWeb.waitForSeconds(10); // MODIFICAR 2 ########################
                                WebElement btnReintentar;
                                WebElement btnEntendido;
                                try {
                                        //Busca un boton para Reintentar
                                        LOGGER.log(Level.INFO, "Buscando - btn Reintentar");
                                        //btnReintentar = driver.findElement(By.xpath("//button[text()='Reintentar']"));
                                        btnReintentar = driver.findElement(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]"));
                                        if(btnReintentar.isEnabled()){
                                                btnReintentar.click();
                                                System.out.println("################ CLIC en Reintentar");
                                                LOGGER.log(Level.INFO,"CLIC en Reintentar");
                                        }else{
                                                LOGGER.log(Level.INFO,"btnReintentarEntendido.isEnabled() false");
                                        }
                                }catch (Exception e){
                                        System.out.println("revisarModalError(R): " + e.getMessage());
                                }

                                try {
                                        //Busca un boton para Entendido
                                        LOGGER.log(Level.INFO, "Buscando - btn Entendido");
                                        //btnEntendido = driver.findElement(By.xpath("//button[text()='Entendido']"));
                                        btnEntendido = driver.findElement(By.xpath("//mat-dialog-actions//*[contains(text(),'Entendido')]"));
                                        if(btnEntendido.isEnabled()) {
                                                btnEntendido.click();
                                                System.out.println("################ CLIC en Entendido");
                                                LOGGER.log(Level.INFO,"CLIC en Entendido");
                                        }else{
                                                LOGGER.log(Level.INFO,"btnReintentarEntendido.isEnabled() false");
                                        }

                                }catch (Exception e){
                                        System.out.println("revisarModalError(E): " + e.getMessage());
                                }
                        } else {
                                System.out.println("No se encontró el modal error");
                                break;
                        }

                        contador++;
                        if (contador >= reintentosMax) {
                            bReintentar = false;
                        }
                } while (bReintentar);


        }

/*
        private static void modalError(WebDriver driver, int timeOnSeconds, String message) {
                boolean bReintentar;
                boolean bEntendido;
                System.out.println("modalError");
                WebElement btnReintentar = driver.findElement(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]"));
                bReintentar = driver.findElements((By) btnReintentar).size() != 0;
                esperaProgresiva(driver,8, 1, btnReintentar);
                if (bReintentar) {
                        btnReintentar.click();
                        if (message.isEmpty()) message = "Click al boton Reintentar";
                        System.out.println(message);
                }
                WebElement btnEntendido = (WebElement) By.xpath("//mat-dialog-actions//*[contains(text(),'Entendido')]");
                bEntendido = driver.findElements((By)btnEntendido).size() !=0;
                if (bEntendido){
                    System.out.println("Click al boton Entendido");
                    btnEntendido.click();
                }
        }
*/
        public static void  revisarModalEntendido(WebDriver driver) {
                boolean bReintentar = true;
                int contador = 0;
                int reintentosMax = 2;
                long inicio = System.currentTimeMillis();
                System.out.println("revisarModalEntendido");
                do {
                        try {
                                //Busca un boton para Reintentar
                                WebElement botonReintentar = driver.findElement(By.xpath("//button[text()='Entendido']"));
                                botonReintentar.click();
                                System.out.println("CLIC en ENTENDIDO");
                        }catch (Exception e){

                        }

                        if (contador > reintentosMax) {
                                bReintentar = false;
                        }
                        contador++;
                } while (bReintentar);

                long fin = System.currentTimeMillis();
                long tiempoEjecucion = fin - inicio;
                formatTiempo(tiempoEjecucion, "revisarModalEntendido");
        }
        private static String obtenerRutaBaseProyecto() {
                String rutaBase = "";
                try {
                        rutaBase = System.getProperty("user.dir");
                } catch (Exception e) {
                        System.out.println("Error al obtener la ruta base del proyecto: " + e.getMessage());
                }
                return rutaBase;
        }
        public static void guardarCodigoHTML(WebDriver driver) {
                String fecha = new SimpleDateFormat("yyyy-MM-dd-(HH-mm-ss)").format(new Date());
                String nombreArchivo = "codigoHTML_" + fecha + ".html";
                String rutabase = obtenerRutaBaseProyecto()+"\\target\\html\\";
                File directorio = new File(rutabase);
                if (!directorio.exists()) {
                        directorio.mkdirs();
                }

                String rutaArchivo = rutabase + nombreArchivo;

                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                String codigoHTML = (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");
                //String codigoHTML = driver.getPageSource();
                try {
                        FileWriter fileWriter = new FileWriter(new File(rutaArchivo));
                        fileWriter.write(codigoHTML);
                        fileWriter.close();
                        System.out.println("El archivo " + nombreArchivo + " se ha guardado correctamente en " + rutaArchivo);
                } catch (IOException e) {
                        System.out.println("Error al guardar el archivo " + nombreArchivo + " en " + rutaArchivo + ": " + e.getMessage());
                }

        }

        public static boolean esEntornoProductivo(){
                String env = System.getProperty("environment");
                System.out.println("Enviroment: " + env);
                if (Objects.nonNull(env)) {
                        if (env.compareTo("dev") == 0) {
                               return false;
                        } else if (env.compareTo("prod") == 0) {
                                return true;
                        }else{
                                return false;
                        }
                }
                return false;
        }

}
