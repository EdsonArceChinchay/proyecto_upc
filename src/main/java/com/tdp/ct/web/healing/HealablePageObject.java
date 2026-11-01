package com.tdp.ct.web.healing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase base para PageObjects con soporte de Auto-Healing
 * Extiende esta clase en lugar de WebBase para habilitar auto-healing
 */
public abstract class HealablePageObject {
    protected static final Logger logger = Logger.getLogger(HealablePageObject.class.getName());
    protected WebDriver driver;
    private final Map<String, By> locatorMap = new HashMap<>();
    private final Map<String, By[]> alternativeLocators = new HashMap<>();

    public HealablePageObject(WebDriver driver) {
        this.driver = driver;
        registerLocators();
        logger.log(Level.INFO, "✓ HealablePageObject inicializado: " + this.getClass().getSimpleName());
    }

    /**
     * Encuentra elemento con auto-healing habilitado
     * @param elementKey Clave del elemento registrado
     * @return WebElement encontrado
     */
    protected WebElement findWithHealing(String elementKey) {
        By primaryLocator = locatorMap.get(elementKey);
        if (primaryLocator == null) {
            String errorMsg = "Element key not registered: " + elementKey +
                            " | Available keys: " + locatorMap.keySet();
            logger.log(Level.SEVERE, errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        return AutoHealingManager.findElementWithHealing(driver, primaryLocator, elementKey);
    }

    /**
     * Registra localizador primario para un elemento
     * @param key Identificador único del elemento
     * @param locator Localizador By (xpath, css, id, etc.)
     */
    protected void registerLocator(String key, By locator) {
        locatorMap.put(key, locator);
        logger.log(Level.FINE, "Localizador registrado: " + key + " -> " + locator);
    }

    /**
     * Registra localizadores alternativos para recuperación automática
     * @param key Identificador del elemento
     * @param alternatives Array de localizadores alternativos
     */
    protected void registerAlternatives(String key, By[] alternatives) {
        alternativeLocators.put(key, alternatives);
        for (By alt : alternatives) {
            AutoHealingManager.registerAlternative(key, alt.toString());
        }
        logger.log(Level.FINE, "Alternativas registradas para " + key + ": " + alternatives.length + " opciones");
    }

    /**
     * Obtiene todas las claves de elementos registrados
     */
    protected Map<String, By> getRegisteredLocators() {
        return new HashMap<>(locatorMap);
    }

    /**
     * Método abstracto que cada PageObject debe implementar
     * Aquí se deben registrar todos los localizadores del page
     */
    protected abstract void registerLocators();

    /**
     * Obtiene el WebDriver actual
     */
    public WebDriver getDriver() {
        return driver;
    }
}

