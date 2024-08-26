package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Addons {
    private static final Logger LOGGER = Logger.getLogger(Addons.class.getName());

    public static void esperaProgresivaLoading(WebDriver driver, int reintentosMax, int segundosEspera, String sLoadingXPath) {
        //USAR SOLO EN ALGUNOS CASOS, CUANDO TIENE UN LOADING DIFERENTE
        LOGGER.log(Level.INFO, "esperaProgresivaLoading(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", sLoading: " + sLoadingXPath + ")");
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
        } while (bCargando && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTiempo(tiempoEjecucion, "esperaProgresivaLoading");

    }

    public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elementoContenedor, By byBuscarEnContenxto, SearchContext context) {
        //USAR SOLO EN ALGUNOS CASOS
        LOGGER.log(Level.INFO, "esperaProgresiva(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", byBuscarEnContenxto: " + byBuscarEnContenxto + ")");
        long inicio = System.currentTimeMillis();
        int contador = 0;
        boolean bOK = false;

        UtilWeb.waitForSeconds(1);

        LOGGER.log(Level.INFO, "elementoContenedor: " + elementoContenedor.toString());
        do {
            LOGGER.log(Level.INFO, "esperaProgresiva - Context - Reintento # " + (contador + 1) + " => espera: " + segundosEspera * contador);
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                String s = elementoContenedor.getText();
                bOK = true;
                LOGGER.log(Level.INFO, "elementoContenedor text: " + s);

                s = context.findElement(byBuscarEnContenxto).getText();
                LOGGER.log(Level.INFO, "elementoContenedorContexto text: " + s);

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "error Message: " + e.getMessage());
                LOGGER.log(Level.SEVERE, "error StackTrace: " + Arrays.toString(e.getStackTrace()));
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTiempo(tiempoEjecucion, "esperaProgresiva *");
    }

    public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elemento) {
        //USAR ESTA ESPERA DE FORMA MASIVA
        LOGGER.log(Level.INFO, "esperaProgresiva(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", WebElement: " + elemento.toString() + ")");
        long inicio = System.currentTimeMillis();
        int contador = 0;
        boolean bOK = false;

        //Detecta el Splash: Telefónica ...
        boolean bCargando = false;
        UtilWeb.waitForSeconds(1);
        do {
            try {
                LOGGER.log(Level.INFO, "Buscando Splash ...");
                By by;
                //by = By.cssSelector(".splash");
                //by = By.xpath("//div[@class='splash']");
                //by = By.xpath("//tdp-loader[contains(@class, 'splash')]");
                //by = By.tagName("tdp-loader");
                //by = By.xpath("//tdp-loader/div[@class='splash']/div[@class='splash-title']");
                //by = By.xpath("//div[@class='splash-title']");

                by = By.cssSelector("tdp-loader");
                //List<WebElement> elements = driver.findElements(by);
                //if (!elements.isEmpty()){
                //LOGGER.log(Level.INFO, "SEARCH:");
                WebElement splashElement = driver.findElement(by);
                String splashText = splashElement.getText();
                if (splashText.length() > 3) {
                    bCargando = true;
                }
                if (bCargando) {
                    LOGGER.log(Level.INFO, "Splash detectado: " + splashText + " #" + (contador + 1));
                    UtilWeb.waitForSeconds(segundosEspera * contador);
                }
                // }else{
                //         LOGGER.log(Level.INFO, "NO hay Splash");
                // }

            } catch (Exception e) {
                bCargando = false;
                LOGGER.log(Level.INFO, "Splash notFound");
            }
            contador++;
        } while (bCargando && contador < reintentosMax);

        LOGGER.log(Level.INFO, "WebElement: " + elemento);
        contador = 0;
        do {
            LOGGER.log(Level.INFO, "esperaProgresiva - Reintento # " + (contador + 1) + " => espera: " + segundosEspera * contador);
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                String s = elemento.getText();
                bOK = true;
                LOGGER.log(Level.INFO, "text: " + s);
                break;
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "error Message: " + e.getMessage());
                LOGGER.log(Level.SEVERE, "error StackTrace: " + Arrays.toString(e.getStackTrace()));
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTiempo(tiempoEjecucion, "esperaProgresiva");
    }

    public static void esperaProgresivaReintentos(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elemento) {
        LOGGER.log(Level.INFO, "esperaProgresiva2(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", WebElement: " + elemento.toString() + ")");

        int contador = 0;

        do {
            UtilWeb.waitForSeconds(segundosEspera);
            esperaProgresivaLoading(driver, 5, 4, "loadingCard");
            esperaProgresiva(driver, 5, 4, elemento);
            LOGGER.log(Level.INFO, "Esperando " + segundosEspera + " segundos...");

            try {
                if (elemento.isDisplayed()) {
                    LOGGER.log(Level.INFO, "Elemento visible. Realizando clic...");
                    esperaProgresivaLoading(driver, 9, 3, "loadingCard");
                    elemento.click();
                } else {
                    LOGGER.log(Level.INFO, "Elemento no visible. Saliendo del bucle.");
                    break;
                }
            } catch (NoSuchElementException e) {
                LOGGER.log(Level.WARNING, "Elemento no encontrado en el intento #" + (contador + 1));
                break;
            } catch (ElementClickInterceptedException el) {
                LOGGER.log(Level.WARNING, "No se puede dar click al elemento en el intento #" + (contador + 1));
                break;
            }

            contador++;
        } while (contador < reintentosMax);
    }

    private static void formatTiempo(long tiempo, String msg) {
        try {
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
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "ERROR -" + e.getMessage());
        }
    }

    public static void revisarModalError(WebDriver driver) {
/*
    Se tiene como objetivo detectar avisos de Error,
    y reintentar como máximo 2 veces el boton de error para permitir continuar.

    Se está identificando diferentes modalidades de error.
*/
        boolean bReintentar = true;
        boolean isModalError = false;
        int contador = 0;
        int reintentosMax = 5;
        int segundosEspera = 15;

        do {
            boolean modal1SinError = false;
            boolean sinBtnReintentar = false;
            boolean sinBtnEntendido = false;
            boolean modal2SinError = false;
            UtilWeb.waitForSeconds(3);
            LOGGER.log(Level.INFO, "revisarModalError #" + (contador + 1) + "/" + reintentosMax);
            isModalError = !driver.findElements(By.xpath("//app-card-plan-error//*[contains(text(),'Reintentar')] | //mat-dialog-actions | //app-modal-confirmation-financing | //app-modal-confirmation-financing/tdp-st-modal//button")).isEmpty();
            LOGGER.log(Level.INFO, "bExisteModal(Reintentar / Entendido): " + isModalError);

            if (isModalError) {
                UtilWeb.waitForSeconds(segundosEspera * contador);
                WebElement btnReintentar;
                WebElement btnEntendido;

                try {
                    //Busca un boton para Reintentar
                    LOGGER.log(Level.INFO, "Buscando - btn Reintentar");
                    List<WebElement> btnsReintentar = driver.findElements(By.xpath("//*[contains(text(),'Reintentar')] | //app-card-plan-error//*[contains(text(),'Reintentar')] "));
                    btnReintentar = btnsReintentar.get(btnsReintentar.size() - 1);
                    if (btnReintentar.isEnabled()) {
                        btnReintentar.click();
                        System.out.println("################ CLIC en Reintentar");
                        LOGGER.log(Level.INFO, "CLIC en Reintentar");
                    } else {
                        sinBtnReintentar = true;
                        LOGGER.log(Level.INFO, "btnReintentarEntendido.isEnabled() false");
                    }
                } catch (Exception e) {
                    System.out.println("revisarModalError(R): " + e.getMessage());
                }

                try {
                    //Busca un boton para Entendido
                    LOGGER.log(Level.INFO, "Buscando - btn Entendido");
                    List<WebElement> btnsEntendido = driver.findElements(By.xpath("//*[contains(text(),'Entendido')]"));
                    btnEntendido = btnsEntendido.get(btnsEntendido.size() - 1);
                    if (btnEntendido.isEnabled()) {
                        btnEntendido.click();
                        System.out.println("################ CLIC en Entendido");
                        LOGGER.log(Level.INFO, "CLIC en Entendido");
                    } else {
                        sinBtnEntendido = true;
                        LOGGER.log(Level.INFO, "btnReintentarEntendido.isEnabled() false");
                    }
                    if (sinBtnReintentar && sinBtnEntendido) {
                        modal1SinError = true;
                    }

                } catch (Exception e) {
                    System.out.println("revisarModalError(E): " + e.getMessage());
                }
            } else {
                modal1SinError = true;
                System.out.println("No se encontró el modal error (Reintentar / Entendido)");
                //break;
            }


            //Revisar el tipo de Errores: Uno de los servicios no respondio, porfavor continuar
            //Mostrando un boton: Continuar
            isModalError = !driver.findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')] | //app-modal-confirmation-financing | //app-modal-confirmation-financing/tdp-st-modal//button")).isEmpty();
            LOGGER.log(Level.INFO, "bExisteModal(Continuar): " + isModalError);
            if (isModalError) {
                WebElement btnContinuar;
                try {
                    //Busca un boton para Continuar
                    LOGGER.log(Level.INFO, "Buscando - btn Continuar");
                    btnContinuar = driver.findElement(By.xpath("//mat-dialog-actions//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')] | //app-modal-confirmation-financing//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')]"));
                    if (btnContinuar.isEnabled()) {
                        btnContinuar.click();
                        System.out.println("################ CLIC en Continuar");
                        LOGGER.log(Level.INFO, "CLIC en Continuar");
                    } else {
                        LOGGER.log(Level.INFO, "btnReintentarEntendidoContinuar.isEnabled() false");
                        modal2SinError = true;
                    }

                } catch (Exception e) {
                    System.out.println("revisarModalError(E): " + e.getMessage());
                }
            } else {
                modal2SinError = true;
                System.out.println("No se encontró el modal error (Continuar)");

            }

            if (modal1SinError && modal2SinError) {
                //Si no hay formulario de error, sale del bucle.
                break;
            }
            boolean bCargando = false;
            try {
                LOGGER.log(Level.INFO, "Buscando Splash ...");
                By by;
                //by = By.cssSelector(".splash");
                //by = By.xpath("//div[@class='splash']");
                //by = By.xpath("//tdp-loader[contains(@class, 'splash')]");
                //by = By.tagName("tdp-loader");
                //by = By.xpath("//tdp-loader/div[@class='splash']/div[@class='splash-title']");
                //by = By.xpath("//div[@class='splash-title']");

                by = By.cssSelector("tdp-loader");
                //List<WebElement> elements = driver.findElements(by);
                //if (!elements.isEmpty()){
                //LOGGER.log(Level.INFO, "SEARCH:");
                WebElement splashElement = driver.findElement(by);
                String splashText = splashElement.getText();
                if (splashText.length() > 3) {
                    bCargando = true;
                }
                if (bCargando) {
                    LOGGER.log(Level.INFO, "Splash detectado: " + splashText + " #" + (contador + 1));
                    UtilWeb.waitForSeconds(segundosEspera * contador);
                }
                // }else{
                //         LOGGER.log(Level.INFO, "NO hay Splash");
                // }

            } catch (Exception e) {
                bCargando = false;
                LOGGER.log(Level.INFO, "Splash notFound");
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
    public static void revisarModalEntendido(WebDriver driver) {
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
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "ERROR -" + e.getMessage());

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

    public static String obtenerRutaBaseProyecto() {
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
        String rutabase = obtenerRutaBaseProyecto() + "\\target\\html\\";
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

    public static boolean esEntornoProductivo() {
        String env = System.getProperty("environment");
        System.out.println("Enviroment: " + env);
        if (Objects.nonNull(env)) {
            if (env.compareTo("dev") == 0) {
                return false;
            } else return env.compareTo("prod") == 0;
        }
        return false;
    }

    public static void reiniciaTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void scrollFinalPagina(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void esperaCargaMontoDeuda(WebDriver driver, int tiempoEsperaMaximo) {
        try {
            By loaderCard = By.cssSelector("app-deuda img.stl_loader");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaMaximo));
            wait.until(ExpectedConditions.attributeContains(loaderCard, "hidden", "true"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static WebElement validarElementoPresente(WebDriver driver, String rutaElemento) {
        WebElement resultado = null;
        try {
            resultado = driver.findElement(By.xpath(rutaElemento));
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.WARNING, "Elemento no encontrado en el intento");
        }
        return resultado;
    }
}
