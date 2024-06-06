package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.ImageToText;
import com.tdp.ct.web.CaptchaBase.Util;
import com.tdp.ct.web.Helper.DebugHelper;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;

import static com.tdp.ct.web.lib.WebDriverManager.getDriver;

public class CaptchaPage extends WebBase {

    String CAPTCHA = null;
    public WebElement txtCaptcha;

    private ManageScenario scenario;

    @FindBy(xpath = "//div[@class='contentFake50Percent']/input[@class='textInput']")
    protected WebElement inputCaptcha;

    @FindBy(id = "captcha")
    protected WebElement imgCaptcha;

    @FindBy(xpath = "//a[contains(@onclick,'generate')]")
    protected WebElement btnUpdateCaptcha;

    public void getCaptcha() throws InterruptedException {

        String path = System.getProperty("user.dir") + File.separator + "captcha";

        cleanFile(path);

        UtilWeb.waitForSeconds(2);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Get captcha...");

        WebElement captchaElement = driver().findElement(By.id("captcha"));

        UtilWeb.logger(this.getClass()).log(Level.INFO, "captchaElement..." + captchaElement.isDisplayed());

        int retries = 0;

        while (!captchaElement.isDisplayed() || retries == 5) {
            updateCaptcha();
            UtilWeb.waitForSeconds(retries);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "captchaElement..." + captchaElement.isDisplayed() + " - retries: " + (retries + 1));
            retries++;
        }

        try {

            File captcha = captchaElement.getScreenshotAs(OutputType.FILE);

            path = path + File.separator + createNameCaptcha() + ".png";

            FileUtils.copyFile(captcha, new File(path));
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Screenshot save in: " + path);
        } catch (IOException e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "¡Error save Screenshot! " + e.getMessage());
        }

        decodeCaptcha(path);

    }

    public void decodeCaptcha(String path) throws InterruptedException {

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Decoding captcha...");

        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("ebbfcdddae2c552ed5e3ef935aef7c8c");
        api.setFilePath(path);

        api.setSoftId(0);

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getText(), DebugHelper.Type.SUCCESS);
            CAPTCHA = api.getTaskSolution().getText();
        }
        typeCaptcha(CAPTCHA);
    }

    public void typeCaptcha(String sCaptcha) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type captcha...");
        click(inputCaptcha);
        type(inputCaptcha, sCaptcha);
    }

    public void updateCaptcha() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Update captcha...");
        btnUpdateCaptcha.click();
        UtilWeb.waitForSeconds(5);
    }

    public static String createNameCaptcha() {
        int valor = (int) (Math.random() * 1000) + 1;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime() + valor);
    }

    public void cleanFile(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File file1 : files) {
                    if (!file1.getName().equalsIgnoreCase(".gitkeep")) {
                        file1.delete();
                    }
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "File deleted: " + file1.getName());
                }
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "The folder is empty");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "The specified path is not a valid folder.");
        }
    }
}
