package com.tdp.ct.web.runner;

import com.tdp.ct.web.jira.JiraXray;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/build/report/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        stepNotifications = true,
        features = {"src/test/resources/features"},
        glue = {"com.tdp.ct.web.hooks", "com.tdp.ct.web.glue"},
<<<<<<< HEAD
        tags = "@totalizaciontriomasaltamovil"
=======
        tags = "@prueba"
>>>>>>> 74c8dac38a4bd028228197541e692f96e9dca05c

)


class Runner {

    @BeforeClass
    public static void beforeExecution() {
        Logger.getLogger(Runner.class.getName()).log(Level.INFO, "BEFORE EXECUTION --->");
    }

    @AfterClass
    public static void afterExecution() {
        Logger.getLogger(Runner.class.getName()).log(Level.INFO, "AFTER EXECUTION --->");
        JiraXray.importResults();
    }
}