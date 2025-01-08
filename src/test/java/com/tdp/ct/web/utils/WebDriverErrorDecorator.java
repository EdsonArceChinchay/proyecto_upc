package com.tdp.ct.web.utils;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebDriverErrorDecorator implements InvocationHandler{

        private final WebDriver originalDriver;
        private static final Logger logger = Logger.getLogger(com.tdp.ct.web.utils.WebDriverErrorDecorator.class.getName());
        private static String lastSeleniumError = "";

        public WebDriverErrorDecorator(WebDriver driver) {
            this.originalDriver = driver;
        }

        public static WebDriver create(WebDriver driver) {
            // Detecta todas las interfaces implementadas por el driver original
            Class<?>[] allInterfaces = extractInterfaces(driver);

            // Crea el proxy dinámico con todas las interfaces
            return (WebDriver) Proxy.newProxyInstance(
                    WebDriver.class.getClassLoader(),
                    allInterfaces,
                    new com.tdp.ct.web.utils.WebDriverErrorDecorator(driver)
            );
        }

        // Método auxiliar para extraer todas las interfaces implementadas por el driver
        private static Class<?>[] extractInterfaces(WebDriver driver) {
            Set<Class<?>> interfaces = new HashSet<>();
            Class<?> current = driver.getClass();
            while (current != null) {
                interfaces.addAll(Arrays.asList(current.getInterfaces()));
                current = current.getSuperclass();
            }
            return interfaces.toArray(new Class<?>[0]);
        }

        private static Class<?>[] mergeInterfaces(WebDriver driver) {
            // Combina las interfaces implementadas por el driver con TakesScreenshot
            return driver instanceof TakesScreenshot
                    ? new Class<?>[]{WebDriver.class, TakesScreenshot.class}
                    : new Class<?>[]{WebDriver.class};
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                // Intenta invocar el método en el driver original
                return method.invoke(originalDriver, args);
            } catch (InvocationTargetException e) {
                // Captura y maneja la excepción lanzada dentro del método
                Throwable cause = e.getCause(); // Obtiene la causa original
                if (cause instanceof WebDriverException) {
                    // Si es una excepción de Selenium, registra el error
                    String fullMessage = cause.getMessage();
                    lastSeleniumError = extractRelevantError(fullMessage);
                    logger.log(Level.SEVERE, "Error capturado en WebDriver: " + lastSeleniumError, cause);
                }
                throw cause; // Re-lanza la causa original
            } catch (Exception e) {
                // Manejo genérico para otras excepciones
                logger.log(Level.SEVERE, "Excepción inesperada en WebDriver: " + e.getMessage(), e);
                throw e; // Propaga la excepción
            }
        }

        // Método auxiliar para extraer la parte relevante del mensaje de error
        private String extractRelevantError(String fullMessage) {
            if (fullMessage == null || fullMessage.isEmpty()) {
                return "Mensaje de error vacío o nulo";
            }

            // Usa una expresión regular para extraer la primera línea relevante
            Pattern pattern = Pattern.compile("^(no such element: .*?)\\n");
            Matcher matcher = pattern.matcher(fullMessage);
            if (matcher.find()) {
                return matcher.group(1);
            }

            // Si no encuentra coincidencia, retorna el mensaje completo
            return fullMessage.split("\\n")[0];
        }



        public static String getLastSeleniumError() {
            return lastSeleniumError;
        }
    }

