package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.config.PropertiesVault;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Crea Chrome stealth en una sola pasada (sin setUpDriver + recreate).
 * Evita args duplicados de fetchChromeOptions() y bloqueo del perfil user-data-dir.
 */
public final class StealthChromeDriverFactory {

    private StealthChromeDriverFactory() {
    }

    /**
     * Crea ChromeDriver stealth listo para login-cert / Cloudflare Turnstile.
     */
    public static WebDriver createStealthDriver(PropertiesVault props) {
        configureChromeDriverPath(props);

        LogUtils.logInfo("[STEALTH] Creando Chrome con excludeSwitches (login-cert)");

        ChromeOptions options = buildChromeOptions(props);
        ChromeStealthApplier.applyToChromeOptions(options);

        ChromeDriver driver = new ChromeDriver(options);
        applyFrameworkSettings(driver, props);
        return driver;
    }

    /**
     * @deprecated Usar {@link #createStealthDriver(PropertiesVault)} desde Hooks (una sola pasada).
     */
    @Deprecated
    public static WebDriver recreateIfNeeded(WebDriver current, PropertiesVault props) {
        WebDriver real = WebDriverErrorDecorator.unwrap(current);
        if (!ChromeStealthApplier.isEnabled() || !(real instanceof ChromeDriver)) {
            return real;
        }

        LogUtils.logInfo("[STEALTH] Recreando Chrome con excludeSwitches");

        try {
            real.quit();
            Thread.sleep(1500);
        } catch (Exception e) {
            LogUtils.logInfo("[STEALTH] Cierre del driver previo: " + e.getMessage());
        }

        return createStealthDriver(props);
    }

    static ChromeOptions buildChromeOptions(PropertiesVault props) {
        ChromeOptions options = new ChromeOptions();

        if (props.isWebDriverAcceptInsecureCerts()) {
            options.setAcceptInsecureCerts(true);
        }

        if (props.isWebDriverHeadless()) {
            options.addArguments("--headless=new");
            String headlessDim = props.getWebDriverHeadlessDimension();
            if (headlessDim != null && !headlessDim.trim().isEmpty()) {
                options.addArguments(headlessDim.trim());
            }
        }

        if ("FULLSCREEN".equalsIgnoreCase(props.getWebDriverSize())) {
            options.addArguments("--kiosk");
        }

        Set<String> args = new LinkedHashSet<>();
        List<String> extraArgs = props.getChromeExtraArgsOptions();
        if (extraArgs != null) {
            for (String arg : extraArgs) {
                if (arg != null && !arg.trim().isEmpty()) {
                    args.add(arg.trim());
                }
            }
        }
        // Selenium 4.3 + Chrome 115+ suele requerir este flag
        args.add("--remote-allow-origins=*");
        options.addArguments(args.toArray(new String[0]));
        LogUtils.logInfo("[STEALTH] ChromeOptions extra arguments >>> True");

        String pageLoad = props.getPageLoadStrategy();
        if (pageLoad != null && !pageLoad.trim().isEmpty()) {
            try {
                options.setPageLoadStrategy(PageLoadStrategy.fromString(pageLoad.trim()));
            } catch (IllegalArgumentException e) {
                LogUtils.logInfo("[STEALTH] PageLoadStrategy no reconocido: " + pageLoad);
            }
        }

        return options;
    }

    private static void configureChromeDriverPath(PropertiesVault props) {
        try {
            WebDriverManager.chromedriver().setup();
            LogUtils.logInfo("[STEALTH] Chromedriver vía WebDriverManager (compatible con Chrome instalado)");
        } catch (Exception e) {
            LogUtils.logInfo("[STEALTH] WebDriverManager falló; usando path del framework: " + e.getMessage());
            String path = props.getDriverPath();
            if (path != null && !path.isEmpty() && !"NOT_DEFINED".equalsIgnoreCase(path)) {
                System.setProperty("webdriver.chrome.driver", path);
            }
        }
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
