package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.config.PropertiesVault;
import com.tdp.ct.web.service.config.options.BaseOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Recrea Chrome con {@link ChromeStealthApplier#applyToChromeOptions} porque el JAR
 * web-automation no aplica excludeSwitches=enable-automation al crear el driver.
 */
public final class StealthChromeDriverFactory {

    private StealthChromeDriverFactory() {
    }

    public static WebDriver recreateIfNeeded(WebDriver current, BaseOptions baseOptions, PropertiesVault props) {
        WebDriver real = WebDriverErrorDecorator.unwrap(current);
        if (!ChromeStealthApplier.isEnabled() || !(real instanceof ChromeDriver)) {
            return real;
        }

        LogUtils.logInfo("[STEALTH] Recreando Chrome con excludeSwitches (login-cert)");

        try {
            real.quit();
        } catch (Exception e) {
            LogUtils.logInfo("[STEALTH] Cierre del driver previo: " + e.getMessage());
        }

        ChromeOptions options = baseOptions.getChrome().fetchChromeOptions();
        ChromeStealthApplier.applyToChromeOptions(options);

        ChromeDriver driver = new ChromeDriver(options);
        applyFrameworkSettings(driver, props);
        return driver;
    }

    private static void applyFrameworkSettings(ChromeDriver driver, PropertiesVault props) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(props.getImplicitWait()));
        } catch (Exception ignored) {
            // continuar
        }

        try {
            driver.manage().window().maximize();
        } catch (Exception ignored) {
            // continuar
        }
    }
}
