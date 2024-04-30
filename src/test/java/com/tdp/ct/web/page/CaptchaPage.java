package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.ImageToText;
import com.tdp.ct.web.CaptchaBase.Util;
import com.tdp.ct.web.Helper.DebugHelper;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
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

    //public WebElement imgCaptcha;

    public void obtenerCaptcha() throws IOException {
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo captcha...");

        WebElement captchaElement =  driver().findElement(By.id("captcha"));
        File captcha = captchaElement.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\captcha\\captcha.png";
        //System.out.println("path: " + path);
        FileHandler.copy(captcha, new File(path));
    }

    public void decodificarCaptcha() throws InterruptedException {
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("ebbfcdddae2c552ed5e3ef935aef7c8c");
        api.setFilePath("captcha/captcha.png");

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
        escribirCaptcha(CAPTCHA);
    }

    public void escribirCaptcha(String sCaptcha) {
        click(inputCaptcha);
        type(inputCaptcha,sCaptcha);

    }
}
