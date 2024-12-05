package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

@Slf4j
public class RegisterPage extends WebBase {

    @FindBy(css = "[formcontrolname='medioPago']")
    protected WebElement selectMethodPayment;
    @FindBy(css = "tdp-st-input-text[formcontrolname='mail'] input")
    protected WebElement inputEmail;
    @FindBy(css = "tdp-st-input-text[formcontrolname='confirmEmail'] input")
    protected WebElement inputConfirmEmail;
    @FindBy(css = "tdp-st-input-text[formcontrolname='callID'] input")
    protected WebElement inputCallID;
    //@FindBy(xpath = "(//span[contains(text(),'Datos del Cliente')]/..)[2] | //button//*[contains(text(),' Datos del Cliente ')]")
    protected String btnCustomerData =
            "(//span[contains(text(),'Datos del Cliente')]/..)[2] | //button//*[contains(text(),' Datos del Cliente ')]";
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')] | //button//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;
    @FindBy(xpath = "//*[contains(text(),'Confirmar') and @type='submit'] | //button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirm;
    @FindBy(css = "tdp-st-select[formcontrolname='estadoCivil']")
    protected WebElement selectMaritalStatus;
    @FindBy(css = "tdp-st-select[formcontrolname='nacionalidad']")
    protected WebElement selectNationality;
    @FindBy(css = "tdp-st-select[formcontrolname='department']")
    protected WebElement selectDepartment;
    @FindBy(css = "tdp-st-select[formcontrolname='province']")
    protected WebElement selectProvince;
    @FindBy(css = "tdp-st-select[formcontrolname='district']")
    protected WebElement selectDistrict;
    @FindBy(css = "tdp-st-input-text[formcontrolname='fechaNacimiento'] input")
    protected WebElement inputDateOfBirth;
    @FindBy(css = "tdp-st-textarea[formcontrolname='direccion'] textarea")
    protected WebElement inputAddress;
    @FindBy(xpath = "//*[contains(text(),'Continuar') or contains(text(),'Finalizar registro') ]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;
    @FindBy(css = "tdp-st-select[formcontrolname='typePage']")
    protected WebElement selectPage;
    @FindBy(xpath = "//*[contains(text(),'La validación de identidad se completará')]")
    protected WebElement textIdentityValidationError;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmModal;
    @FindBy(xpath = "//*[contains(text(),'Finalizar registro') or @type='submit' and contains(text(),'Finalizar registro')]")
    protected WebElement btnFinalizarRegistro;

    public void completaDatosSolicitados() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 7, completaDatosSolicitados);
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void selectMethodPayment(String methodPayment) {
        esperaProgresiva(driver(), 6, 6, selectMethodPayment);
        clickAndSelectElementCSS(methodPayment, selectMethodPayment, "[formcontrolname='medioPago'] li");
    }

    public void typeEmail(String email) {
        esperaProgresiva(driver(), 6, 6, inputEmail);
        validateAndType("email", inputEmail, email);
    }

    public void typeConfirmEmail(String email) {
        validateAndType("confirm email", inputConfirmEmail, email);
    }

    public void typeIdCall(String idCall) {
        validateAndType("id call", inputCallID, idCall);
    }

    public void waitButtonCustomerData() {
        WebElement scrollBtnCustomerData = explicitWaitXpath(driver(), 5, btnCustomerData);
        js().scrollElementTop(scrollBtnCustomerData);
    }

    public void clickButtonCustomerData() {
        WebElement ButtonCustomerData = explicitWaitXpath(driver(), 5, btnCustomerData);
        ButtonCustomerData.click();
        UtilWeb.waitForSeconds(5);
    }

    public void typeDateOfBirth(String dateOfBirth) {
        js().scrollElementTop(inputDateOfBirth);
        validateAndType("date of birth", inputDateOfBirth, dateOfBirth);
    }

    public void selectMaritalStatus(String maritalStatus) {
        boolean isExsited;
        try {
            logInfo("Search by without shadowRoot");
            clickAndSelectElementCSS(maritalStatus, js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"]"), "tdp-st-select[formcontrolname='estadoCivil'] ul > li");
            isExsited = false;
        } catch (Exception e) {
            logSevere("ERROR", e.getMessage());
            isExsited = true;
            if(js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"] ul > li").isDisplayed()){
                logInfo("1 catch");
                selectElementCSS(maritalStatus,"tdp-st-select[formcontrolname='estadoCivil'] ul > li");
                isExsited = false;
            }
        }
        if (isExsited){
            try {
                logInfo("Search by shadowRoot");
                validateSelectShadow("marital status", maritalStatus, js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"]"), "div > ul > li");
            } catch (Exception e) {
                logSevere("ERROR", e.getMessage());
                   if(js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"] ul > li").isDisplayed()){
                       logInfo("2 catch");
                       selectElementCSS(maritalStatus,"tdp-st-select[formcontrolname='estadoCivil'] ul > li");
                }
            }
        }
    }

    public void selectNationality(String nationality) {
        clickAndSelectElementCSS(nationality, selectNationality, "tdp-st-select[formcontrolname='nacionalidad'] li");
    }

    public void selectDepartment(String department) {
        clickAndSelectElementCSS(department, selectDepartment, "tdp-st-select[formcontrolname='department'] li");
    }

    public void selectProvince(String province) {
        clickAndSelectElementCSS(province, selectProvince, "tdp-st-select[formcontrolname='province'] li");
    }

    public void selectDistrict(String district) {
        clickAndSelectElementCSS(district, selectDistrict, "tdp-st-select[formcontrolname='district'] li");
    }

    public void typeAddress(String address) {
        js().scrollElementTop(inputAddress);
        validateAndType("address", inputAddress, address);
    }

    public void clickButtonConfirm() {
        js().scrollElementTop(btnConfirm);
        btnConfirm.click();
        esperaProgresiva(driver(), 6, 6, buttonValidarContrato);
    }

    public void selectTipoDePago(String type) {
        clickAndSelectElementCSS(type, selectPage, "tdp-st-select[formcontrolname='typePage'] li");
    }

    public void clickButtonContinue() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            logInfo("Entra al while");
            try {
                logInfo("Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 30);
                buttonFound = true;
            } catch (Exception e) {
                logInfo("Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                logInfo(contador + " vez");
            }
        }
        logInfo("Sale del While");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
//        Addons.esperaProgresivaReintentos(driver(), 5, 5, buttonContinuar);
        Addons.revisarModalError(driver());
    }

    public boolean hasIdentityValidationError() {
        boolean isError = false;
        try {
            UtilWeb.waitForSeconds(120);
            if (textIdentityValidationError.isDisplayed()) {
                logInfo("Error Validate Identity");
                isError = true;
            }
        } catch (Exception e) {
            logSevere("Element no found" + e.getMessage());

        }
        return isError;
    }

    public void clickOnButtonConfirm() {
        btnConfirmModal.click();
        logInfo("Click button confirm");
        UtilWeb.waitForSeconds(2);
    }

    public void clickOnTheFinishRegistrationButton() {
        waitUntilElementIsVisible(btnFinalizarRegistro, 10);
        click(btnFinalizarRegistro);
    }

}
