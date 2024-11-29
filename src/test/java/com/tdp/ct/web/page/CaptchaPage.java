package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.ImageToText;
import com.tdp.ct.web.Helper.DebugHelper;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.UUID;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.FileUtils.*;
import static com.tdp.ct.web.utils.Helper.isNumber;

public class CaptchaPage extends WebBase {

    private static final String PATH = System.getProperty("user.dir") + File.separator + "captcha";
    private static final int MAX_RETRIES = 5;
    private static final int MAX_ATTEMPTS = 5;
    private static final int EXPECTED_CAPTCHA_LENGTH = 4;

    private static int count = 0;

    @FindBy(id = "codeInput")
    protected WebElement inputCaptcha;
    @FindBy(css = "a[onclick]")
    protected WebElement btnUpdateCaptcha;
    @FindBy(css = "div[id='captcha']")
    protected WebElement captcha;

    public static String createIDCaptcha() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void updateAndTypeCaptcha() {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type incorrect captcha...");
        updateAndFetchNewCaptcha();
    }

    public void getCaptcha() {
        if (count >= MAX_ATTEMPTS) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Maximum captcha attempts reached.");
            throw new MaxCaptchaAttemptsException("Maximum captcha attempts reached.");
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Get captcha...");
        UtilWeb.waitForSeconds(5);
        UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("captchaElement displayed... %s", captcha.isDisplayed()));
        int retries = 0;
        while (!captcha.isDisplayed() && retries < MAX_RETRIES) {
            updateCaptcha();
            UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("captchaElement displayed... %s - retries: %s.", captcha.isDisplayed(), (retries + 1)));
            retries++;
        }
        String path = PATH + File.separator + createIDCaptcha() + ".png";
        boolean isSave = saveScreenshot(captcha, path);
        if (isSave) {
            String getCaptcha = decodeCaptcha(path);
            validateCaptcha(getCaptcha);
            count++;
        }
    }


    public String decodeCaptcha(String path) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Decoding captcha...");
        try {
            DebugHelper.setVerboseMode(true);
            ImageToText api = initializeApi(path);
            if (!api.createTask()) {
                DebugHelper.out("API v2 send failed. " + api.getErrorMessage(), DebugHelper.Type.ERROR);
                return null;
            } else if (!api.waitForResult()) {
                DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
                return null;
            } else {
                return handleCaptchaResult(api);
            }
        } catch (Exception e) {
            DebugHelper.out("An error occurred: " + e.getMessage(), DebugHelper.Type.ERROR);
            return null;
        }
    }

    private ImageToText initializeApi(String path) {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Initialize Api");
        ImageToText api = new ImageToText();
        api.setClientKey(getValueConfig("config", "credential.api.secret"));
        api.setFilePath(path);
        api.setSoftId(0);
        return api;
    }

    private String handleCaptchaResult(ImageToText api) {
        String captchaText = api.getTaskSolution().getText();
        DebugHelper.out("Result: " + captchaText, DebugHelper.Type.SUCCESS);
        return captchaText;
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

    public void validateCaptcha(String captcha) {
        if (isInvalidCaptcha(captcha)) {
            updateAndFetchNewCaptcha();
        } else {
            typeCaptcha(captcha);
        }
    }

    private boolean isInvalidCaptcha(String captcha) {
        if (captcha == null) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, ("Captcha is null."));
            return true;
        } else if (captcha.isEmpty()) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, ("Captcha is empty."));
            return true;
        } else if (!isNumber(captcha)) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, ("Captcha contains letters."));
            return true;
        } else if (captcha.trim().length() != EXPECTED_CAPTCHA_LENGTH) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, ("Captcha has a different length of 4."));
            return true;
        }
        return false;
    }

    private void updateAndFetchNewCaptcha() {
        updateCaptcha();
        getCaptcha();
    }
}

class MaxCaptchaAttemptsException extends RuntimeException {
    public MaxCaptchaAttemptsException(String message) {
        super(message);
    }
}
