package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.ImageToText;
import com.tdp.ct.web.Helper.DebugHelper;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.UUID;

import static com.tdp.ct.web.utils.FileUtils.*;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.isNumber;

public class CaptchaPage extends WebBase {

    private static final String PATH = getAbsolutePathString("captcha");
    private static final int MAX_RETRIES = Integer.parseInt(getValueConfig("config", "environment.captcha.max-retries"));
    private static final int MAX_ATTEMPTS = Integer.parseInt(getValueConfig("config", "environment.captcha.max-attempts"));
    private static final int EXPECTED_CAPTCHA_LENGTH = Integer.parseInt(getValueConfig("config", "environment.captcha.expected_captcha_length"));
    private static final boolean CLEANED_CAPTCHA_SCREENSHOTS = Boolean.parseBoolean(getValueConfig("config", "environment.captcha.clean"));
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
        logInfo("Type incorrect captcha...");
        updateAndFetchNewCaptcha();
    }

    public void getCaptcha() {
        if (count >= MAX_ATTEMPTS) {
            String msg = String.format("Maximum %s captcha attempts reached", MAX_ATTEMPTS);
            logInfo(msg);
            throw new MaxCaptchaAttemptsException(msg);
        }
        logInfo("Get captcha...");
        logInfo("Captcha attempts...", ++count);
        UtilWeb.waitForSeconds(5);
        logInfo("captchaElement displayed...", captcha.isDisplayed());
        int retries = 0;
        while (!captcha.isDisplayed() && retries < MAX_RETRIES) {
            updateCaptcha();
            logInfo(String.format("captchaElement displayed... %s - retries: %s.", captcha.isDisplayed(), (retries + 1)));
            retries++;
        }
        String path = PATH + File.separator + createIDCaptcha() + ".png";
        boolean isSave = saveScreenshot(captcha, path);
        if (isSave) {
            String getCaptcha = decodeCaptcha(path);
            validateCaptcha(getCaptcha);
        }
    }

    public String decodeCaptcha(String path) {
        logInfo("Decoding captcha...");
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
        logInfo("Initialize Api");
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
        logInfo("Type captcha...");
        clear(inputCaptcha);
        type(inputCaptcha, sCaptcha);
        if (CLEANED_CAPTCHA_SCREENSHOTS) {
            cleanFile(PATH);
        }
    }

    public void updateCaptcha() {
        logInfo("Update captcha...");
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
            logInfo("Captcha is null");
            return true;
        }
        if (captcha.isEmpty()) {
            logInfo("Captcha is empty.");
            return true;
        }
        if (!isNumber(captcha)) {
            logInfo("Captcha contains letters.");
            return true;
        }
        if (captcha.trim().length() != EXPECTED_CAPTCHA_LENGTH) {
            logInfo(String.format("Captcha has a different length (expected: %d, found: %s).", EXPECTED_CAPTCHA_LENGTH, captcha.trim().length()));
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
