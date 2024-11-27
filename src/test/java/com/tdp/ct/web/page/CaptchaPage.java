package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.ImageToText;
import com.tdp.ct.web.Helper.DebugHelper;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.UUID;
import java.util.logging.Level;

public class CaptchaPage extends WebBase {

    private static final String PATH = System.getProperty("user.dir") + File.separator + "captcha";
    private static final int MAX_RETRIES = 5;
    @FindBy(xpath = "//div[@class='contentFake50Percent']/input[@class='textInput']")
    protected WebElement inputCaptcha;
    @FindBy(xpath = "//a[contains(@onclick,'generate')]")
    protected WebElement btnUpdateCaptcha;

    public static String createIDCaptcha() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void updateAndTypeCaptcha() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type incorrect captcha...");
        updateCaptcha();
        getCaptcha();
    }

    public void getCaptcha() {
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Get captcha...");
        WebElement captchaElement = driver().findElement(By.id("captcha"));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "captchaElement displayed..." + captchaElement.isDisplayed());
        int retries = 0;
        while (!captchaElement.isDisplayed() && retries < MAX_RETRIES) {
            updateCaptcha();
            UtilWeb.waitForSeconds(retries);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "captchaElement displayed..." + captchaElement.isDisplayed() + " - retries: " + (retries + 1));
            retries++;
        }
        saveCaptchaScreenshot(captchaElement);
    }

    private void saveCaptchaScreenshot(WebElement captchaElement) {
        try {
            File captcha = captchaElement.getScreenshotAs(OutputType.FILE);
            String path = PATH + File.separator + createIDCaptcha() + ".png";
            FileUtils.copyFile(captcha, new File(path));
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Screenshot saved in: " + path);
            decodeCaptcha(path);
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error saving screenshot: " + e.getMessage());
        }
    }

    public void decodeCaptcha(String path) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Decoding captcha...");
        try {
            DebugHelper.setVerboseMode(true);
            ImageToText api = initializeApi(path);
            if (!api.createTask()) {
                DebugHelper.out("API v2 send failed. " + api.getErrorMessage(), DebugHelper.Type.ERROR);
            } else if (!api.waitForResult()) {
                DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
            } else {
                handleCaptchaResult(api);
            }
        } catch (Exception e) {
            DebugHelper.out("An error occurred: " + e.getMessage(), DebugHelper.Type.ERROR);
        }
    }

    private ImageToText initializeApi(String path) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Initialize Api");
        ImageToText api = new ImageToText();
        api.setClientKey("ebbfcdddae2c552ed5e3ef935aef7c8c");
        api.setFilePath(path);
        api.setSoftId(0);
        return api;
    }

    private void handleCaptchaResult(ImageToText api) {
        String captchaText = api.getTaskSolution().getText();
        DebugHelper.out("Result: " + captchaText, DebugHelper.Type.SUCCESS);
        if (captchaText.length() == 4) {
            typeCaptcha(captchaText);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Captcha length is less than 4..." + captchaText.length());
            getCaptcha();
        }
    }

    public void typeCaptcha(String sCaptcha) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type captcha...");
        clear(inputCaptcha);
        type(inputCaptcha, sCaptcha);
        cleanFile(PATH);
    }

    public void updateCaptcha() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Update captcha...");
        btnUpdateCaptcha.click();
        UtilWeb.waitForSeconds(5);
    }

    public void cleanFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (!file1.getName().equalsIgnoreCase(".gitkeep")) {
                        file1.delete();
                        UtilWeb.logger(this.getClass()).log(Level.INFO, "File deleted: " + file1.getName());
                    }
                }
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "The folder is empty");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "The specified path is not a valid folder.");
        }
    }
}
