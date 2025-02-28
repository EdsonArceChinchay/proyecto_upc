package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

@Slf4j
public class RegisterPage extends WebBase {

    protected final String btnCustomerData = "(//span[contains(text(),'Datos del Cliente')]/..)[2] | //button//*[contains(text(),' Datos del Cliente ')]";

    @FindBy(css = "tdp-st-select[formcontrolname='medioPago']")
    protected WebElement selectMethodPayment;
    @FindBy(css = "tdp-st-input-text[formcontrolname='mail']")
    protected WebElement inputEmail;
    @FindBy(css = "tdp-st-input-text[formcontrolname='confirmEmail']")
    protected WebElement inputConfirmEmail;
    @FindBy(css = "tdp-st-input-text[formcontrolname='callID']")
    protected WebElement inputCallID;
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
    @FindBy(css = "tdp-st-input-text[formcontrolname='fechaNacimiento']")
    protected WebElement inputDateOfBirth;
    @FindBy(css = "tdp-st-textarea[formcontrolname='direccion']")
    protected WebElement inputAddress;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;
    @FindBy(css = "tdp-st-select[formcontrolname='typePage']")
    protected WebElement selectPage;
    @FindBy(xpath = "//*[contains(text(),'La validación de identidad se completará')]")
    protected WebElement textIdentityValidationError;
    @FindBy(css = "tdp-st-modal .body_bio .font_title_validation")
    protected WebElement titleValidation;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Confirmar')]")
    protected WebElement btnConfirmModal;
    @FindBy(xpath = "//*[contains(text(),'Finalizar registro') or @type='submit' and contains(text(),'Finalizar registro')]")
    protected WebElement btnFinalizarRegistro;

    // BOTON CONTINUAR
    @FindBy(xpath = "//*[contains(text(),'Continuar') or contains(text(),'Finalizar registro') ]/parent::button")
    protected WebElement buttonContinuar;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void completaDatosSolicitados() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 7, completaDatosSolicitados);
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", completaDatosSolicitados.isDisplayed());
    }

    public void selectMethodPayment(String methodPayment) {
        esperaProgresiva(driver(), 6, 6, selectMethodPayment);
        selectElementCSSWithAndWithoutShadowRoot("method payment", selectMethodPayment, methodPayment);
    }

    public void typeEmail(String email) {
        esperaProgresiva(driver(), 6, 4, inputEmail);
        validateAndTypeWithAndWithoutShadowRoot("email", inputEmail, email);
    }

    public void typeConfirmEmail(String email) {
        validateAndTypeWithAndWithoutShadowRoot("confirm email", inputConfirmEmail, email);
    }

    public void typeIdCall(String idCall) {
        validateAndTypeWithAndWithoutShadowRoot("id call", inputCallID, idCall);
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
        validateAndTypeWithAndWithoutShadowRoot("date of birth", inputDateOfBirth, dateOfBirth);
    }

    public void selectMaritalStatus(String maritalStatus) {
        selectElementCSSWithAndWithoutShadowRoot("marital status", selectMaritalStatus, maritalStatus);
        try {
            if (js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"] ul > li").isDisplayed()) {
                selectElementCSS("tdp-st-select[formcontrolname='estadoCivil'] ul > li", maritalStatus);
            }
        } catch (Exception e) {
            logSevere("ERROR", e.getMessage());
        }
    }

    public void validateMaterialStatus(String maritalStatus) {
        try {
            if (js().getWebElement("tdp-st-select[formcontrolname=\"estadoCivil\"].ng-invalid").isDisplayed()) {
                selectMaritalStatus(maritalStatus);
            }
        } catch (Exception e) {
            logSevere("ERROR", e.getMessage());
        }
    }

    public void selectNationality(String nationality) {
        selectElementCSSWithAndWithoutShadowRoot("nationality", selectNationality, nationality);
        UtilWeb.waitForSeconds(2);
    }

    public void selectDepartment(String department) {
        selectElementCSSWithAndWithoutShadowRoot("department", selectDepartment, department);
    }

    public void selectProvince(String province) {
        selectElementCSSWithAndWithoutShadowRoot("province", selectProvince, province);
    }

    public void selectDistrict(String district) {
        selectElementCSSWithAndWithoutShadowRoot("district", selectDistrict, district);
    }

    public void typeAddress(String address) {
        js().scrollElementTop(inputAddress);
        validateAndTypeWithAndWithoutShadowRoot("address", inputAddress, address);
    }

    public void clickButtonConfirm() {
        js().scrollElementTop(btnConfirm);
        btnConfirm.click();
        esperaProgresiva(driver(), 6, 6, buttonValidarContrato);
    }

    public void selectTipoDePago(String type) {
        selectElementCSSWithAndWithoutShadowRoot("type of payment", selectPage, type);
    }

    public boolean hasIdentityValidationError() {
        boolean isError = false;
        UtilWeb.waitForSeconds(10);
        if (!validateIsDisplayed(titleValidation)) {
            try {
                UtilWeb.waitForSeconds(30);
                if (textIdentityValidationError.isDisplayed()) {
                    logInfo("Error Validate Identity");
                    isError = true;
                }
            } catch (Exception e) {
                logSevere("Title error no found" + e.getMessage());
            }
        } else {
            logSevere("Title error no found");
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

    /**
     * FUNCION CLICK BOTON CONTINUAR
     * */

    public void clickButtonContinue() {
        int cont = 0;
        boolean existeElement = false;
        int contadorBoton = 0;
        boolean existeBoton = false;
        while (cont < 3 && !existeElement) {
            cont++;
            try {
                logInfo("Ingreso a visualizar el BOTON CONTINUAR");
                waitUntilElementIsVisible(buttonContinuar,5);
                while (contadorBoton < 3 && !existeBoton) {
                    contadorBoton++;
                    try {
                        if (buttonContinuar.isDisplayed()) {
                            logInfo("Se visualizo el BOTON CONTINUAR - RECORRIDO N°" + contadorBoton);
                            if (contadorBoton == 1) {
                                miScenario.printFullView();
                            }
                            click(buttonContinuar,5);
                            view.temporalPage().clickBtnReintentar();
                        }
                    } catch (Exception e) {
                        logInfo("Ya no se visualiza el BOTON CONTINUAR");
                        existeBoton = true;
                        logSevere("SE PRESENTA ERROR - " + e.getMessage());
                    }
                }
                existeElement = true;
            } catch (Exception e) {
                logSevere("NO SE ENCONTRO ELEMENTO: " + e.getMessage());
                logInfo("SE PROCEDE A REINTENTAR - REINTENTO N°" + cont);
                if (cont == 3) {
                    logInfo("SE SUPERO EL NUMERO DE REINTENTO - SE PROCEDE A CERRAR VENTANA");
                    logSevere("ERROR PERSISTE - " + e.getMessage());
                    driver().quit();
                }
            }
        }
    }
}
