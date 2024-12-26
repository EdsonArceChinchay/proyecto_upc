package com.tdp.ct.web.hooks;

import com.tdp.ct.web.context.ScenarioContext;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.utils.BitacoraService;
import com.tdp.ct.web.utils.HttpSender;
import io.cucumber.java.*;
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
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        manager.setUpDriver();
    }

    @Before(order = 1)
    public void handleScenario(Scenario scenario) {
        this.scenario.setScenario(scenario);
    }

//    @After(order = 0)
//    public void afterScenario() {
//        manager.quitDriver();
//    }

    @After(order = 1)
    public void tearDown() {
//        saveHTMLCode(manager.getDriver());
        scenario.shotWhenFail();
    }
    @After(order = 0)
    public void afterScenario() {
        // Captura el error de Selenium si existe
        String seleniumError = (String) getScenarioContext().getOrDefault("seleniumError", ""); // Obtiene el error de Selenium

        // Genera la bitácora utilizando el servicio BitacoraService
        bitacoraService.generarBitacora();

        // Llama la petición post usando SendPost
        httpSender.sendRunStatus(
                (String) getScenarioContext().get("transaccion"),
                " -- ",
                String.valueOf(scenario.getScenario().getStatus()),
                (String) getScenarioContext().get("test"),
                (String) getScenarioContext().get("hu"),
                seleniumError // Pasa el error de Selenium
        );

        // Cierro el driver de manera segura
//        if (manager.isDriverOn()) manager.quitDriver();
    }

    public static ScenarioContext getScenarioContext() {
        return scenarioContext.get();
    }
}
