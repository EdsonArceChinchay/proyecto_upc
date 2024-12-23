package com.tdp.ct.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SeleniumErrorListener extends AbstractWebDriverEventListener {

    private static String lastSeleniumError = "";
    private static final Logger logger = Logger.getLogger(SeleniumErrorListener.class.getName());

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        if (throwable instanceof WebDriverException) {
            lastSeleniumError = throwable.toString(); // Captura el mensaje de error de Selenium
            logger.log(Level.SEVERE, "Capturando error de Selenium: " + lastSeleniumError);
        }
    }

    public static String getLastSeleniumError() {
        return lastSeleniumError;
    }
}

