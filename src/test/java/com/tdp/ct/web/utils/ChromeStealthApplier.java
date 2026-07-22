package com.tdp.ct.web.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.HasCdp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reduce señales de automatización en Chrome para Cloudflare Turnstile (CERT).
 */
public final class ChromeStealthApplier {

    private ChromeStealthApplier() {
    }

    public static boolean isEnabled() {
        return LoginConfigUtil.getBoolean("browser.stealth", true);
    }

    public static void applyToChromeOptions(ChromeOptions options) {
        if (!isEnabled()) {
            return;
        }

        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments(
                "--disable-blink-features=AutomationControlled",
                "--disable-infobars",
                "--lang=es-PE"
        );

        String userDataDir = resolveUserDataDir();
        if (userDataDir != null) {
            options.addArguments("--user-data-dir=" + userDataDir);
            LogUtils.logInfo("[STEALTH] Perfil persistente de Chrome", userDataDir);
        }

        LogUtils.logInfo("[STEALTH] Opciones anti-detección aplicadas a ChromeOptions");
    }

    public static void applyToDriver(WebDriver driver) {
        WebDriver realDriver = WebDriverErrorDecorator.unwrap(driver);
        if (!isEnabled() || !(realDriver instanceof HasCdp)) {
            return;
        }

        HasCdp cdpDriver = (HasCdp) realDriver;

        try {
            Map<String, Object> scriptParams = new HashMap<String, Object>();
            scriptParams.put("source", STEALTH_SCRIPT);
            cdpDriver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", scriptParams);

            String userAgent = resolveUserAgent(realDriver);
            if (userAgent != null) {
                Map<String, Object> uaParams = new HashMap<String, Object>();
                uaParams.put("userAgent", userAgent);
                cdpDriver.executeCdpCommand("Network.setUserAgentOverride", uaParams);
            }

            LogUtils.logInfo("[STEALTH] CDP aplicado (webdriver oculto + user-agent normalizado)");
        } catch (Exception e) {
            LogUtils.logSevere("[STEALTH] No se pudo aplicar CDP: " + e.getMessage());
        }
    }

    private static String resolveUserDataDir() {
        String configured = LoginConfigUtil.get("browser.stealth.user-data-dir", "target/chrome-stealth-berserkers-profile");
        try {
            Path profilePath = Paths.get(configured);
            if (!profilePath.isAbsolute()) {
                profilePath = Paths.get(System.getProperty("user.dir")).resolve(profilePath).normalize();
            }

            Files.createDirectories(profilePath);
            cleanupChromeLockFiles(profilePath);
            return profilePath.toAbsolutePath().toString();
        } catch (IOException e) {
            LogUtils.logSevere("[STEALTH] No se pudo preparar user-data-dir: " + e.getMessage());
            return null;
        }
    }

    private static void cleanupChromeLockFiles(Path profilePath) {
        List<String> lockFiles = Arrays.asList("lockfile", "SingletonLock", "SingletonCookie", "SingletonSocket");
        for (String lockFile : lockFiles) {
            try {
                Files.deleteIfExists(profilePath.resolve(lockFile));
            } catch (IOException ignored) {
                // continuar
            }
        }
    }

    private static String resolveUserAgent(WebDriver driver) {
        try {
            if (!(driver instanceof JavascriptExecutor)) {
                return null;
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Object value = js.executeScript("return navigator.userAgent;");
            if (value == null) {
                return null;
            }
            return value.toString().replace("HeadlessChrome", "Chrome");
        } catch (Exception e) {
            return null;
        }
    }

    private static final String STEALTH_SCRIPT =
            "Object.defineProperty(navigator, 'webdriver', { get: () => undefined });"
                    + "window.chrome = window.chrome || { runtime: {} };"
                    + "Object.defineProperty(navigator, 'languages', { get: () => ['es-PE', 'es', 'en-US', 'en'] });"
                    + "Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3, 4, 5] });";
}
