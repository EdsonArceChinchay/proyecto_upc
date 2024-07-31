package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.isVisible;
import static com.tdp.ct.web.utils.Helper.returnCompareWebElementTextAndText;

public class RegisterPage extends WebBase {

    @FindBy(xpath = "//*[@formcontrolname='medioPago']")
    protected WebElement selectMethodPayment;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='mail'] | //*[@formcontrolname='mail']")
    protected WebElement inputEmail;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='confirmEmail'] | //*[@formcontrolname='confirmEmail']")
    protected WebElement inputConfirmEmail;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='callID']")
    protected WebElement inputCallID;
    @FindBy(xpath = "(//span[contains(text(),'Datos del Cliente')]/..)[2] | //button//*[contains(text(),' Datos del Cliente ')]")
    protected WebElement btnCustomerData;
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')] | //button//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;
    @FindBy(xpath = "//*[contains(text(),'Confirmar')]")
    protected WebElement lblConsultar;
    @FindBy(xpath = "//*[contains(text(),'Confirmar') and @type='submit'] | //button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirm;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']")
    protected WebElement selectMaritalStatus;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']")
    protected WebElement selectNationality;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[@formcontrolname='department']")
    protected WebElement selectDepartment;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[@formcontrolname='province']")
    protected WebElement selectProvince;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[@formcontrolname='district']")
    protected WebElement selectDistrict;
    @FindBy(xpath = "//*[contains(text(),'Continuar') or contains(text(),'Finalizar registro') ]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;

    public void completaDatosSolicitados() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 7, completaDatosSolicitados);
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void selectMethodPayment(String methodPayment) {
        esperaProgresiva(driver(), 6, 6, selectMethodPayment);
        selectElementShadowRootCSS(methodPayment,selectMethodPayment,"div > ul > li");
    }

    public void typeEmail(String email) {
        typeShadowRootCss(email, inputEmail, "div > div > div > input");
    }

    public void typeConfirmEmail(String email) {
        typeShadowRootCss(email, inputConfirmEmail, "div > div > div > input");
    }

    public void typeIdCall(String idCall) {
        typeShadowRootCss(idCall, inputCallID, "div > div > div > input");
    }

    public void waitButtonCustomerData() {
        waitUntilElementIsVisible(btnCustomerData, 10);
        js().scrollElementTop(btnCustomerData);
    }

    public void clickButtonCustomerData() {
        UtilWeb.waitForSeconds(2);
        click(btnCustomerData);
        UtilWeb.waitForSeconds(5);
    }

    public void typeDateOfBirth(String dateOfBirth) {
        String inputDateOfBirth = "tdp-st-input-text;input";
        WebElement dateOfBirthElement = js().getWebElement(inputDateOfBirth);
        dateOfBirthElement.sendKeys(dateOfBirth);
        UtilWeb.waitForSeconds(2);
    }

    public void selectMaritalStatus(String estadoCivil) {
        selectElementShadowRootCSS(estadoCivil,selectMaritalStatus,"div > ul > li");
    }

    public void selectNationality(String nationality) {
        selectElementShadowRootCSS(nationality,selectNationality,"div > ul > li");
    }

    public void selectDepartment(String department) {
        selectElementShadowRootCSS(department,selectDepartment,"div > ul > li");
    }

    public void selectProvince(String province) {
        selectElementShadowRootCSS(province,selectProvince,"div > ul > li");
    }

    public void selectDistrict(String district) {
        selectElementShadowRootCSS(district,selectDistrict,"div > ul > li");
    }

    public void typeAddress(String address) {
        UtilWeb.waitForSeconds(2);
        WebElement direccionElement = js().getWebElement("tdp-st-textarea;textarea");
        js().scrollElementTop(direccionElement);
        type(direccionElement, address);
        js().scrollElementTop(lblConsultar);
        click(lblConsultar, 10);
    }

    public void clickButtonConfirm() {
        UtilWeb.waitForSeconds(5);
        esperaProgresiva(driver(), 3,5,btnConfirm);
        js().scrollElementTop(btnConfirm);
        click(btnConfirm);
        esperaProgresiva(driver(),6,6,buttonValidarContrato);
    }

    public void selectTipoDePago(String tipo) {
        String clickTipo = "div form div:nth-child(7) tdp-st-select;div:nth-child(1)";
        WebElement tipoElement = js().getWebElement(clickTipo);
        click(tipoElement);
        switch (tipo) {
            case "Boleta":
                String selectTipo = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(1)";
                WebElement selectElement = js().getWebElement(selectTipo);
                click(selectElement);
                break;
            case "Factura":
                String selectTipo2 = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(2)";
                WebElement selectElement2 = js().getWebElement(selectTipo2);
                click(selectElement2);
                break;
        }
    }

    public void clickButtonContinue() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            System.out.println("Entra al while");
            try {
                System.out.println("Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 30);
                buttonFound = true;
            } catch (Exception e) {
                System.out.println("Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                System.out.println(contador + " vez");
            }
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Sale del While");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
        //Addons.esperaProgresivaReintentos(driver(), 5, 5, buttonContinuar);
        Addons.revisarModalError(driver());
    }

    public void typeShadowRootCss(String text, WebElement webElement, String shadowElement){
        SearchContext context = webElement.getShadowRoot();
        WebElement inputElement = context.findElement(By.cssSelector(shadowElement));
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.DELETE);
        type(inputElement, text);
    }

    public void selectElementShadowRootCSS(String text, WebElement webElement, String shadowElement)
    {
        click(webElement,10);
        UtilWeb.waitForSeconds(2);
        SearchContext contextPlan=sh().getContext(webElement);
        List<WebElement>elementsList= contextPlan.findElements(By.cssSelector(shadowElement));
        for(WebElement element:elementsList){
            js().scrollElementTop(element);
            boolean isEquals =returnCompareWebElementTextAndText(element,text);
            if(isEquals){
                js().scrollElementTop(element);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Select element: "+ element.getText());
                click(element,10);
                break;
            }
        }
    }

}
