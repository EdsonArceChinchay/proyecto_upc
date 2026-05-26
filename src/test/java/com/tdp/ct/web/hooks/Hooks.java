package com.tdp.ct.web.hooks;

import com.tdp.ct.web.context.ScenarioContext;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.utils.BitacoraService;
import com.tdp.ct.web.utils.HttpSender;
import com.tdp.ct.web.utils.WebDriverErrorDecorator;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


public class Hooks {

    @Autowired
    private WebDriverManager manager;

    @Autowired
    private ManageScenario scenario;

    @Autowired
    private HttpSender httpSender;

    @Autowired
    private BitacoraService bitacoraService;

    private static final ThreadLocal<ScenarioContext> scenarioContext = ThreadLocal.withInitial(ScenarioContext::new);

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @ParameterType(value = "true|false")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Before(order = 0)
    public void setUp() {

        httpSender.disableSSLValidation();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        manager.setUpDriver();

        // Crea una instancia del WebDriver decorado con el soporte para errores y capturas
        WebDriver decoratedDriver = WebDriverErrorDecorator.create(manager.getDriver());

        // Actualiza el driver en manager con el decorado
        manager.setDriver(decoratedDriver);
    }

    @Before(order = 1)
    public void handleScenario(Scenario scenario) {
        this.scenario.setScenario(scenario);
    }

    @After(order = 1)
    public void tearDown() {
        try {
            scenario.shotWhenFail();

            // ✅ NUEVO: Screenshot grande (no thumbnail)
            attachScreenshotGrandeOnFail();

        } catch (Exception e) {
            System.out.println("⚠️ Error en screenshot (ignorado): " + e.getMessage());
        }
    }

    @After(order = 0)
    public void afterScenario() {

        httpSender.disableSSLValidation();

        String seleniumError = WebDriverErrorDecorator.getLastSeleniumError();

        bitacoraService.generarBitacora();

        httpSender.sendRunStatus(
                (String) getScenarioContext().get("transaccion"),
                (String) getScenarioContext().get("tags"),
                String.valueOf(scenario.getScenario().getStatus()),
                (String) getScenarioContext().get("test"),
                (String) getScenarioContext().get("hu"),
                seleniumError
        );

        // ✅ NO cerrar si falló
        if (!scenario.getScenario().isFailed()) {
            if (manager.isDriverOn()) manager.quitDriver();
        } else {
            System.out.println("❌ Escenario falló → NO cierro navegador para análisis");
        }
    }

    public static ScenarioContext getScenarioContext() {
        return scenarioContext.get();
    }

    // ================== MÉTODOS NUEVOS ==================

    /**
     * Adjunta screenshot en tamaño completo (HTML + Base64)
     */
    private void attachScreenshotGrande() {
        try {
            WebDriver driver = manager.getDriver();

            if (driver == null || !(driver instanceof org.openqa.selenium.TakesScreenshot)) {
                return;
            }

            byte[] bytes = ((org.openqa.selenium.TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

            String base64 = java.util.Base64.getEncoder().encodeToString(bytes);

            // HTML que evita thumbnail
            String html = "<img src='data:image/png;base64," + base64 + "' style='width:100%; height:auto;'/>";

            scenario.getScenario().attach(html.getBytes(), "text/html", "📸 Evidencia");

        } catch (Exception e) {
            System.out.println("⚠️ Error adjuntando screenshot grande: " + e.getMessage());
        }
    }

    /**
     * Ejecuta screenshot solo si el escenario falla
     */
    private void attachScreenshotGrandeOnFail() {
        if (scenario.getScenario().isFailed()) {
            attachScreenshotGrande();
        }
    }

}