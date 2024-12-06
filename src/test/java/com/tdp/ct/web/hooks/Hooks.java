package com.tdp.ct.web.hooks;

import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private WebDriverManager manager;

    @Autowired
    private ManageScenario scenario;

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

    @After(order = 0)
    public void afterScenario() {
        manager.quitDriver();
    }

    @After(order = 1)
    public void tearDown() {
//        saveHTMLCode(manager.getDriver());
        scenario.shotWhenFail();
    }

}
