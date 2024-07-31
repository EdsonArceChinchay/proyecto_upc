package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.JsonModifierDatosAgente.modifyJsonValue;
import static com.tdp.ct.web.utils.SessionStorage.*;

public class PortabilityPage extends WebBase {

    @FindBy(xpath = "//*[@class='buttonG' and contains(text(),'Consultar')]")
    protected WebElement btnConsultar;

    @FindBy(xpath = "//div[contains(text(),'Portabilidad')]")
    protected WebElement btnPortabilidad;

    @FindBy(xpath = "//button[contains(text(),'Portabilidad móvil')]")
    protected WebElement btnPortaMovil;

    @FindBy(xpath = "//*[contains(text(),'Validar Código de Portabilidad')]/parent::button")
    protected WebElement btnCodePorta;

    @FindBy(xpath = "//div[@class='modal_body']//button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmar;

    @FindBy(xpath = "//div[@class='modal_body']//button[contains(text(),'Continuar')]")
    protected WebElement btnContinuar;

    public void clickBotonPortabilidad() {
        waitUntilElementIsVisible(btnPortabilidad, 10);
        js().scrollElementTop(btnPortabilidad);
        esperaProgresiva(driver(), 5, 5, btnPortabilidad);
        click(btnPortabilidad);
        UtilWeb.waitForSeconds(5);
    }

    public void ingresarNumeroPortar(String numero) {
        UtilWeb.waitForSeconds(5);
        WebElement document = find().getElementByCss(".tdp-col-sm-9:nth-child(1) .ng-pristine");
        click(document);
        type(document, numero);
    }

    public void escogerTipoLinea(String plan) {
        UtilWeb.waitForSeconds(4);//
        WebElement listElementPLan = find().getElementByCss(".tdp-col-sm-9:nth-child(2) .ng-pristine");
        click(listElementPLan);
        UtilWeb.waitForSeconds(4);//es 1
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.className("mdc-list-item"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(plan)) {
                UtilWeb.waitForSeconds(1);
                click(elements, 30);
            }
        }
    }

    public void esogerTipoOperador(String operador) {
        UtilWeb.waitForSeconds(4);//
        WebElement listElementPLan = find().getElementByCss(".tdp-col-sm-9:nth-child(5) .ng-pristine");
        js().scrollElementTop(listElementPLan);
        click(listElementPLan);
        UtilWeb.waitForSeconds(4);//es 1
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.className("mdc-list-item"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(operador)) {
                UtilWeb.waitForSeconds(1);
                click(elements, 30);
            }
        }
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

    public void setValuePortaDirecta() throws JSONException {
        String primaryKey = "datosAgente";
        String secondaryKey = "additionalData";
        String key = "PortaDirecta";
        String newValue = "A";

        String jsonStr = getItemSessionStorage(driver(), primaryKey);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Before modified localStorage" + jsonStr);
        JSONObject jsonObject = modifyJsonValue(jsonStr, key, newValue);
        setValueItemSessionStorage(driver(), primaryKey, secondaryKey, jsonObject);
        jsonStr = getItemSessionStorage(driver(), primaryKey);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "After modified localStorage" + jsonStr);
    }

    public String getValuePortaDirecta() throws JSONException {
        String primaryKey = "datosAgente";
        String key = "additionalData";
        String valuePortaDirecta =getValueItemSessionStorage(driver(), primaryKey, key);
        valuePortaDirecta = (valuePortaDirecta == null) ? " {\"key\": \"PortaDirecta\", \"value\": \"A\"}" : valuePortaDirecta;
        return valuePortaDirecta;
    }

    public void clickButtonCodigoDePorta() {
         esperaProgresiva(driver(),3,5,btnCodePorta);
         js().scrollElementTop(btnCodePorta);
         click(btnCodePorta,2);
    }


    public void selectButton(String name) {
        WebElement buttonSelected = find().getElementByXPath("//*[contains(text(),'"+name.trim()+"')]");
        esperaProgresiva(driver(),3,5,buttonSelected);
        click(buttonSelected,2);
    }

    public void clickButtonConfirmar() {
        esperaProgresiva(driver(),3,5,btnConfirmar);
        click(btnConfirmar,2);
    }

    public void clickButtonContinuar() {
        esperaProgresiva(driver(),3,5,btnContinuar);
        click(btnContinuar,2);
    }

    public void inputToken(String token) {
       String valueToken = token.trim().toUpperCase();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Get token" + valueToken);
        List<WebElement> inputToken = find().getElementsByXPath("//input[contains(@class,'entrada')]");
        esperaProgresiva(driver(),3,5,inputToken.get(0));

        for (int i=0;i<inputToken.size();i++){
            String value =String.valueOf(valueToken.charAt(i));
            type(inputToken.get(i), value);
        }
    }

    public void validateMessage(String message) {
        WebElement label = find().getElementByXPath("//*[contains(text(),'"+message.trim()+"')]");
        esperaProgresiva(driver(),3,5,label);
        Assertions.assertTrue(label.isDisplayed(),"No se muestra en mensaje");
    }
}
