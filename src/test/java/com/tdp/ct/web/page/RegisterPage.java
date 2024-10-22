package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Helper.*;

public class RegisterPage extends WebBase {

    @FindBy(xpath = "//*[@formcontrolname='medioPago']")
    protected WebElement selectMethodPayment;
    @FindBy(xpath = "//tdp-st-input-text[contains(@class,'ng-invalid') and @formcontrolname='mail'] | //*[contains(@class,'ng-invalid') and @formcontrolname='mail']")
    protected WebElement inputEmail;
    @FindBy(xpath = "//tdp-st-input-text[contains(@class,'ng-invalid') and @formcontrolname='confirmEmail'] | //*[contains(@class,'ng-invalid') and @formcontrolname='confirmEmail']")
    protected WebElement inputConfirmEmail;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='callID']")
    protected WebElement inputCallID;
    @FindBy(xpath = "(//span[contains(text(),'Datos del Cliente')]/..)[2] | //button//*[contains(text(),' Datos del Cliente ')]")
    protected WebElement btnCustomerData;
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')] | //button//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;
    @FindBy(xpath = "//*[contains(text(),'Confirmar') and @type='submit'] | //button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirm;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='estadoCivil']")
    protected WebElement selectMaritalStatus;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='nacionalidad']")
    protected WebElement selectNationality;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='department']")
    protected WebElement selectDepartment;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='province']")
    protected WebElement selectProvince;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='district']")
    protected WebElement selectDistrict;
    @FindBy(xpath = "//tdp-st-input-text[contains(@class,'ng-invalid') and @formcontrolname='fechaNacimiento'] | //*[contains(@class,'ng-invalid') and @formcontrolname='fechaNacimiento']")
    protected WebElement inputDateOfBirth;
    @FindBy(xpath = "//tdp-st-textarea[contains(@class,'ng-invalid') and @formcontrolname='direccion'] | //*[contains(@class,'ng-invalid') and @formcontrolname='direccion']")
    protected WebElement inputAddress;
    @FindBy(xpath = "//*[contains(text(),'Continuar') or contains(text(),'Finalizar registro') ]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;
    @FindBy(xpath = "//tdp-st-modal//tdp-st-select[contains(@class,'ng-invalid') and @formcontrolname='typePage']")
    protected WebElement selectPage;
    @FindBy(xpath = "//*[contains(text(),'La validación de identidad se completará')]")
    protected WebElement textIdentityValidationError;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmModal;

    public void completaDatosSolicitados() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 7, completaDatosSolicitados);
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void selectMethodPayment(String methodPayment) {
        esperaProgresiva(driver(), 6, 6, selectMethodPayment);
        validateCompletedInputForm(methodPayment, selectMethodPayment, "div > ul > li");
    }

    public void typeEmail(String email) {
        esperaProgresiva(driver(), 6, 6, inputEmail);
        validateCompletedInputForm(email, inputEmail, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type email: " + email);

    }

    public void typeConfirmEmail(String email) {
        validateCompletedInputForm(email, inputConfirmEmail, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type confirm email: " + email);
    }

    public void typeIdCall(String idCall) {
        validateCompletedInputForm(idCall, inputCallID, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type id call: " + idCall);
    }

    public void waitButtonCustomerData() {
        esperaProgresiva(driver(), 6, 6, btnCustomerData);
        js().scrollElementTop(btnCustomerData);
    }

    public void clickButtonCustomerData() {
        UtilWeb.waitForSeconds(2);
        click(btnCustomerData);
        UtilWeb.waitForSeconds(5);
    }

    public void typeDateOfBirth(String dateOfBirth) {
        js().scrollElementTop(inputDateOfBirth);
        validateCompletedInputForm(dateOfBirth, inputDateOfBirth, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type date of birth: " + dateOfBirth);
    }

    public void selectMaritalStatus(String estadoCivil) {
        js().scrollElementTop(selectMaritalStatus);
        validateCompletedSelectForm(estadoCivil, selectMaritalStatus, "div > ul > li");
    }

    public void selectNationality(String nationality) {
        js().scrollElementTop(selectNationality);
        validateCompletedSelectForm(nationality, selectNationality, "div > ul > li");
    }

    public void selectDepartment(String department) {
        js().scrollElementTop(selectDepartment);
        validateCompletedSelectForm(department, selectDepartment, "div > ul > li");
    }

    public void selectProvince(String province) {
        js().scrollElementTop(selectProvince);
        validateCompletedSelectForm(province, selectProvince, "div > ul > li");
    }

    public void selectDistrict(String district) {
        js().scrollElementTop(selectDistrict);
        validateCompletedSelectForm(district, selectDistrict, "div > ul > li");
    }

    public void typeAddress(String address) {
        js().scrollElementTop(inputAddress);
        validateCompletedInputForm(address, inputAddress, "div > div > span > textarea");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type address: " + address);
    }

    public void clickButtonConfirm() {
        js().scrollElementTop(btnConfirm);
        btnConfirm.click();
        esperaProgresiva(driver(), 6, 6, buttonValidarContrato);
    }

    public void selectTipoDePago(String tipo) {
        js().scrollElementTop(selectPage);
        validateCompletedSelectForm(tipo, selectPage, "div > ul > li");
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
//        Addons.esperaProgresivaReintentos(driver(), 5, 5, buttonContinuar);
        Addons.revisarModalError(driver());
    }

    public void validateCompletedSelectForm(String text, WebElement webElement, String shadowElement) {
        final int MAX_RETRIES = 5;
        int counter = 0;
        boolean isDisplayed = true;
        while (counter < MAX_RETRIES && isDisplayed) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Retry shadow N° " + (counter + 1));
            try {
                selectElementShadowRootCSS(text, webElement, shadowElement);
                UtilWeb.waitForSeconds(3);
                isDisplayed = webElement.isDisplayed();
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No found element - " + e.getMessage());
                isDisplayed = false;
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Element is Displayed" + false);
            }
            counter++;
        }
    }

    public void selectElementShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        click(webElement, 10);
        UtilWeb.waitForSeconds(2);
        SearchContext contextPlan = sh().getContext(webElement);
        List<WebElement> elementsList = contextPlan.findElements(By.cssSelector(shadowElement));
        for (WebElement element : elementsList) {
            js().scrollElementTop(element);
            boolean isEquals = returnValueCompareWebElementTextAndString(element, text);
            if (isEquals) {
                js().scrollElementTop(element);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Select element: " + element.getText());
                click(element, 10);
                break;
            }
        }
    }

    public boolean hasIdentityValidationError() {
       boolean isError=false;
        try {
            UtilWeb.waitForSeconds(120);
            if (textIdentityValidationError.isDisplayed()) {
                btnConfirmModal.click();
                isError= true;
            }
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Element no found" + e.getMessage());

        }
        return isError;
    }
}
