package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.JsonModifierAgentData.modifyJsonValue;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.SessionStorage.*;
import static com.tdp.ct.web.utils.WebUtils.selectElementCSSWithAndWithoutShadowRoot;
import static com.tdp.ct.web.utils.WebUtils.validateAndTypeWithAndWithoutShadowRoot;

public class PortabilityPage extends WebBase {

    @FindBy(css = "[type=\"submit\"].button-g, [type=\"submit\"].buttonG")
    protected WebElement btnConsultar;

    @FindBy(xpath = "//div[contains(text(),'Portabilidad')]")
    protected WebElement btnPortabilidad;

    @FindBy(xpath = "//button[contains(text(),'Portabilidad móvil')]")
    protected WebElement btnPortaMovil;

    @FindBy(xpath = "//*[contains(text(),'Validar Código de Portabilidad')]/parent::button")
    protected WebElement btnCodePorta;

    @FindBy(xpath = "//div[@class='modal_body']//button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirm;

    @FindBy(xpath = "//div[@class='modal_body']//button[contains(text(),'Continuar')]")
    protected WebElement btnContinue;

    @FindBy(css = "tdp-st-input-text[formcontrolname='numTelefono']")
    protected WebElement inputPhoneNumber;

    @FindBy(css = "tdp-st-select[formcontrolname='tipoLinea']")
    protected WebElement selectLineType;

    @FindBy(css = "tdp-st-select[formcontrolname='tipoOperador']")
    protected WebElement selectOperatorType;

    public void clickBotonPortabilidad() {
        esperaProgresiva(driver(), 5, 6, btnPortabilidad);
        js().scrollElementTop(btnPortabilidad);
        click(btnPortabilidad);
    }

    public void typePhoneNumber(String phoneNumber) {
        waitUntilElementIsClickable(inputPhoneNumber, 10);
        validateAndTypeWithAndWithoutShadowRoot("mobile number", inputPhoneNumber, phoneNumber);
    }

    public void selectLineType(String plan) {
        selectElementCSSWithAndWithoutShadowRoot("line type", selectLineType, plan);
    }

    public void selectOperatorType(String operator) {
        UtilWeb.waitForSeconds(2);
        selectElementCSSWithAndWithoutShadowRoot("operator", selectOperatorType, operator);
    }

    public void clickBotonConsultar() {
        waitUntilElementIsClickable(btnConsultar, 10);
        js().scrollElementTop(btnConsultar);
        btnConsultar.click();
        UtilWeb.waitForSeconds(5);
    }

    public void clickPortaMovil() {
        waitUntilElementIsClickable(btnPortaMovil, 20);
        js().scrollElementTop(btnPortaMovil);
        btnPortaMovil.click();
        UtilWeb.waitForSeconds(5);
    }

    public void setValuePortaDirecta() {
        String primaryKey = "datosAgente";
        String secondaryKey = "additionalData";
        String key = "PortaDirecta";
        String newValue = "A";

        String jsonStr = getItemSessionStorage(driver(), primaryKey);
        logInfo("Before modified localStorage" + jsonStr);
        JSONObject jsonObject = modifyJsonValue(jsonStr, key, newValue);
        setValueItemSessionStorage(driver(), primaryKey, secondaryKey, jsonObject);
        jsonStr = getItemSessionStorage(driver(), primaryKey);
        logInfo("After modified localStorage" + jsonStr);
    }

    public String getValuePortaDirecta() {
        String primaryKey = "datosAgente";
        String key = "additionalData";
        String valuePortaDirecta = getValueItemSessionStorage(driver(), primaryKey, key);
        valuePortaDirecta = (valuePortaDirecta == null) ? " {\"key\": \"PortaDirecta\", \"value\": \"A\"}" : valuePortaDirecta;
        return valuePortaDirecta;
    }

    public void clickButtonCodigoDePorta() {
        esperaProgresiva(driver(), 3, 5, btnCodePorta);
        js().scrollElementTop(btnCodePorta);
        click(btnCodePorta, 2);
    }

    public void selectButton(String name) {
        WebElement buttonSelected = find().getElementByXPath("//*[contains(text(),'" + name.trim() + "')]");
        esperaProgresiva(driver(), 3, 5, buttonSelected);
        js().scrollElementTop(buttonSelected);
        click(buttonSelected, 2);
    }

    public void clickButtonConfirmar() {
        esperaProgresiva(driver(), 3, 5, btnConfirm);
        js().scrollElementTop(btnConfirm);
        click(btnConfirm, 2);
        UtilWeb.waitForSeconds(20);
    }

    public void clickButtonContinuar() {
        esperaProgresiva(driver(), 3, 5, btnContinue);
        click(btnContinue, 2);
    }

    public void inputToken(String token) {
        String valueToken = token.trim().toUpperCase();
        logInfo("Get token: " + valueToken);
        List<WebElement> inputToken = find().getElementsByXPath("//input[contains(@class,'entrada')]");
        esperaProgresiva(driver(), 3, 5, inputToken.get(0));
        js().scrollElementTop(inputToken.get(0));
        for (int i = 0; i < inputToken.size(); i++) {
            String value = String.valueOf(valueToken.charAt(i));
            type(inputToken.get(i), value);
        }
    }

    public void validateMessage(String message) {
        UtilWeb.waitForSeconds(5);
        WebElement label = find().getElementByXPath("//*[contains(text(),'" + message.trim() + "')]");
        esperaProgresiva(driver(), 5, 6, label);
        Assertions.assertTrue(label.isDisplayed(), "No se muestra en mensaje");
    }
}
