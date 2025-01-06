package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.DateUtils.formatTime;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

public class Addons {
    private static final Logger LOGGER = Logger.getLogger(Addons.class.getName());

    public static void esperaProgresivaLoading(WebDriver driver, int reintentosMax, int segundosEspera, String sLoadingXPath) {
        //USAR SOLO EN ALGUNOS CASOS, CUANDO TIENE UN LOADING DIFERENTE
        logInfo("esperaProgresivaLoading(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", sLoading: " + sLoadingXPath + ")");
        long inicio = System.currentTimeMillis();
        int contador = 0;
        boolean bCargando;
        do {
            try {
                logInfo("Buscando Loading ...");
                By by;
                by = By.className(sLoadingXPath);
                WebElement loading = driver.findElement(by);
                logInfo("loading: " + loading.toString());
                bCargando = true;

            } catch (Exception e) {
                bCargando = false;
                logSevere("loading notFound");
                UtilWeb.waitForSeconds(segundosEspera);
            }
            contador++;
        } while (bCargando && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTime(tiempoEjecucion, "esperaProgresivaLoading");
    }

    public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elementoContenedor, By byBuscarEnContenxto, SearchContext context) {
        //USAR SOLO EN ALGUNOS CASOS
        logInfo("esperaProgresiva(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", byBuscarEnContenxto: " + byBuscarEnContenxto + ")");
        long inicio = System.currentTimeMillis();
        int contador = 0;
        boolean bOK = false;

        UtilWeb.waitForSeconds(1);

        logInfo("elementoContenedor: " + elementoContenedor.toString());
        do {
            logInfo("esperaProgresiva - Context - Reintento # " + (contador + 1) + " => espera: " + segundosEspera * contador);
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                String s = elementoContenedor.getText();
                bOK = true;
                logInfo("elementoContenedor text: " + s);

                s = context.findElement(byBuscarEnContenxto).getText();
                logInfo("elementoContenedorContexto text: " + s);

            } catch (Exception e) {
                logSevere("Error Message", e.getMessage());
                logSevere("Error StackTrace", Arrays.toString(e.getStackTrace()));
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTime(tiempoEjecucion, "esperaProgresiva *");
    }

    public static void esperaProgresiva(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elemento) {
        //USAR ESTA ESPERA DE FORMA MASIVA
        logInfo("esperaProgresiva(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", WebElement: " + elemento.toString() + ")");
        long inicio = System.currentTimeMillis();
        int contador = 0;
        boolean bOK = false;

        //Detecta el Splash: Telefónica ...
        boolean bCargando = false;
        UtilWeb.waitForSeconds(1);
        do {
            try {
                logInfo("Buscando Splash ...");
                By by;
                by = By.cssSelector("tdp-loader");
                WebElement splashElement = driver.findElement(by);
                String splashText = splashElement.getText();
                if (splashText.length() > 3 && splashElement.isDisplayed()) {
                    bCargando = true;
                } else {
                    logInfo("Continue ... ");
                    break;
                }
                if (bCargando) {
                    logInfo("Splash detectado: " + splashText + " #" + (contador + 1));
                    UtilWeb.waitForSeconds(segundosEspera * contador);
                }

            } catch (Exception e) {
                bCargando = false;
                logInfo("Splash notFound");
            }
            contador++;
        } while (bCargando && contador < reintentosMax);

        logInfo("WebElement: " + elemento);
        contador = 0;
        do {
            logInfo("esperaProgresiva - Reintento # " + (contador + 1) + " => espera: " + segundosEspera * contador);
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                String s = elemento.getText();
                bOK = true;
                logInfo("text: " + s);
                break;
            } catch (Exception e) {
                logSevere("error Message: " + e.getMessage());
                logSevere("error StackTrace: " + Arrays.toString(e.getStackTrace()));
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTime(tiempoEjecucion, "esperaProgresiva");
    }

    public static void esperaProgresivaReintentos(WebDriver driver, int reintentosMax, int segundosEspera, WebElement elemento) {
        logInfo("esperaProgresiva2(reintentosMax: " + reintentosMax + ", segundosEspera: " + segundosEspera + ", WebElement: " + elemento.toString() + ")");

        int contador = 0;

        do {
            UtilWeb.waitForSeconds(segundosEspera);
            esperaProgresivaLoading(driver, 5, 4, "loadingCard");
            esperaProgresiva(driver, 5, 4, elemento);
            logInfo("Esperando " + segundosEspera + " segundos...");

            try {
                if (elemento.isDisplayed()) {
                    logInfo("Elemento visible. Realizando clic...");
                    esperaProgresivaLoading(driver, 9, 3, "loadingCard");
                    elemento.click();
                } else {
                    logInfo("Elemento no visible. Saliendo del bucle.");
                    break;
                }
            } catch (NoSuchElementException e) {
                logSevere("Elemento no encontrado en el intento #" + (contador + 1));
                break;
            } catch (ElementClickInterceptedException el) {
                logSevere("No se puede dar click al elemento en el intento #" + (contador + 1));
                break;
            }
            contador++;
        } while (contador < reintentosMax);
    }

    public static void revisarModalError(WebDriver driver) {
/*
    Se tiene como objetivo detectar avisos de Error,
    y reintentar como máximo 2 veces el boton de error para permitir continuar.

    Se está identificando diferentes modalidades de error.
*/
        boolean bReintentar = true;
        boolean isModalError;
        int contador = 0;
        int reintentosMax = 5;
        int segundosEspera = 15;

        do {
            boolean modal1SinError = false;
            boolean sinBtnReintentar = false;
            boolean sinBtnEntendido = false;
            boolean modal2SinError = false;
            UtilWeb.waitForSeconds(3);
            logInfo("revisarModalError #" + (contador + 1) + "/" + reintentosMax);
            isModalError = !driver.findElements(By.xpath("//app-card-plan-error//*[contains(text(),'Reintentar')] | //mat-dialog-actions | //app-modal-confirmation-financing | //app-modal-confirmation-financing/tdp-st-modal//button")).isEmpty();
            logInfo("bExisteModal(Reintentar / Entendido): " + isModalError);

            if (isModalError) {
                UtilWeb.waitForSeconds(segundosEspera * contador);
                WebElement btnReintentar;
                WebElement btnEntendido;

                try {
                    //Busca un boton para Reintentar
                    logInfo("Buscando - btn Reintentar");
                    List<WebElement> btnsReintentar = driver.findElements(By.xpath("//*[contains(text(),'Reintentar')] | //app-card-plan-error//*[contains(text(),'Reintentar')] "));
                    btnReintentar = btnsReintentar.get(btnsReintentar.size() - 1);
                    if (btnReintentar.isEnabled()) {
                        btnReintentar.click();
                        logInfo("################ CLIC en Reintentar");
                        logInfo("CLIC en Reintentar");
                    } else {
                        sinBtnReintentar = true;
                        logInfo("btnReintentarEntendido.isEnabled() false");
                    }
                } catch (Exception e) {
                    logSevere("revisarModalError(R): " + e.getMessage());
                }

                try {
                    //Busca un boton para Entendido
                    logSevere("Buscando - btn Entendido");
                    List<WebElement> btnsEntendido = driver.findElements(By.xpath("//*[contains(text(),'Entendido')]"));
                    btnEntendido = btnsEntendido.get(btnsEntendido.size() - 1);
                    if (btnEntendido.isEnabled()) {
                        btnEntendido.click();
                        logInfo("################ CLIC en Entendido");
                        logInfo("CLIC en Entendido");
                    } else {
                        sinBtnEntendido = true;
                        logInfo("btnReintentarEntendido.isEnabled() false");
                    }
                    if (sinBtnReintentar && sinBtnEntendido) {
                        modal1SinError = true;
                    }

                } catch (Exception e) {
                    logSevere("revisarModalError(E): " + e.getMessage());
                }
            } else {
                modal1SinError = true;
                logInfo("No se encontró el modal error (Reintentar / Entendido)");
                //break;
            }


            //Revisar el tipo de Errores: Uno de los servicios no respondio, porfavor continuar
            //Mostrando un boton: Continuar
            isModalError = !driver.findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')] | //app-modal-confirmation-financing | //app-modal-confirmation-financing/tdp-st-modal//button")).isEmpty();
            logInfo("bExisteModal(Continuar): " + isModalError);
            if (isModalError) {
                WebElement btnContinuar;
                try {
                    //Busca un boton para Continuar
                    logInfo("Buscando - btn Continuar");
                    btnContinuar = driver.findElement(By.xpath("//mat-dialog-actions//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')] | //app-modal-confirmation-financing//*[contains(text(),'Continuar') or contains(text(),'CONTINUAR')]"));
                    if (btnContinuar.isEnabled()) {
                        btnContinuar.click();
                        logInfo("################ CLIC en Continuar");
                        logInfo("CLIC en Continuar");
                    } else {
                        logInfo("btnReintentarEntendidoContinuar.isEnabled() false");
                        modal2SinError = true;
                    }

                } catch (Exception e) {
                    logSevere("revisarModalError(E): " + e.getMessage());
                }
            } else {
                modal2SinError = true;
                logInfo("No se encontró el modal error (Continuar)");
            }

            if (modal1SinError && modal2SinError) {
                //Si no hay formulario de error, sale del bucle.
                break;
            }
            boolean bCargando = false;
            try {
                logInfo("Buscando Splash ...");
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
                    logInfo("Splash detectado: " + splashText + " #" + (contador + 1));
                    UtilWeb.waitForSeconds(segundosEspera * contador);
                }
                // }else{
                //         LOGGER.log(Level.INFO, "NO hay Splash");
                // }

            } catch (Exception e) {
                logSevere("Splash notFound");
            }
            contador++;
            if (contador >= reintentosMax) {
                bReintentar = false;
            }
        } while (bReintentar);
    }

    public static void revisarModalEntendido(WebDriver driver) {
        boolean bReintentar = true;
        int contador = 0;
        int reintentosMax = 2;
        long inicio = System.currentTimeMillis();
        logInfo("revisarModalEntendido");
        do {
            try {
                //Busca un boton para Reintentar
                WebElement botonReintentar = driver.findElement(By.xpath("//button[text()='Entendido']"));
                botonReintentar.click();
                logInfo("CLIC en ENTENDIDO");
            } catch (Exception e) {
                logSevere("ERROR -" + e.getMessage());

            }

            if (contador > reintentosMax) {
                bReintentar = false;
            }
            contador++;
        } while (bReintentar);

        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;
        formatTime(tiempoEjecucion, "revisarModalEntendido");
    }

    public static boolean esEntornoProductivo() {
        String env = System.getProperty("environment");
        logInfo("Enviroment: " + env);
        if (Objects.nonNull(env)) {
            if (env.compareTo("dev") == 0) {
                return false;
            } else return env.compareTo("prod") == 0;
        }
        return false;
    }

    public static void resetTimeOut(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void esperaCargaMontoDeuda(WebDriver driver, int tiempoEsperaMaximo) {
        try {
            By loaderCard = By.cssSelector("app-deuda img.stl_loader");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempoEsperaMaximo));
            wait.until(ExpectedConditions.attributeContains(loaderCard, "hidden", "true"));
        } catch (Exception e) {
            logSevere("Error: " + e.getMessage());
        }
    }

    public static void esperaSimple(WebDriver driver, int maxAttempts, WebElement elemento, boolean action) {
        boolean isActionSuccessful = false;
        int attempt = 0;
        LOGGER.log(Level.INFO, "Inicio de esperaSimple: "+ elemento);
        while (attempt < maxAttempts && !isActionSuccessful) {
            try {
                if (elemento != null && elemento.isDisplayed()) { // Verificar existencia y visibilidad del elemento
                    if (action) {
                        elemento.click();
                        LOGGER.log(Level.INFO, "Click al elemento: "+ elemento);
                    }
                    isActionSuccessful = true; // Si el clic es exitoso, se sale del bucle.
                } else {
                    throw new NoSuchElementException("El elemento no está disponible o no es visible en la página.");
                }
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                attempt++;
                LOGGER.log(Level.INFO, "Reintentando... Intento " + attempt + " ERROR: " + e.getMessage());
                UtilWeb.waitForSeconds(2); // Espera de 2 segundos antes del siguiente intento
            }
        }

        if (!isActionSuccessful) {
            throw new RuntimeException("No se pudo realizar la acción sobre el elemento " + elemento + " después de " + maxAttempts + " intentos.");
        }else{
            LOGGER.log(Level.INFO, "Elemento encontrado en el intento " + attempt );
        }
    }
}
