package com.tdp.ct.web.runner;

import com.tdp.ct.web.jira.JiraXray;
import com.tdp.ct.web.utils.HttpSender;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/build/report/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        stepNotifications = true,
        features = {"src/test/resources/features"},
        glue = {"com.tdp.ct.web.hooks", "com.tdp.ct.web.glue"},
        tags = "@AltaDuoCC " // cambiar el tag por el que se quiera ejecutar

)
class Runner {

    @BeforeClass
    public static void beforeExecution() {
        Logger.getLogger(Runner.class.getName()).log(Level.INFO, "BEFORE EXECUTION --->");
    }

    @AfterClass
    public static void afterExecution() {
        Logger.getLogger(Runner.class.getName()).log(Level.INFO, "AFTER EXECUTION --->");
        boolean Flag = Boolean.parseBoolean(getValueConfig("config", "environment.notification.sendReporte").trim());
        if (Flag) {
            new HttpSender().sendDetailsRun(getValueConfig("config", "environment.notification.huKey").trim());
        }
        JiraXray.importResults("/target/build/report/cucumber.json");
    }
}