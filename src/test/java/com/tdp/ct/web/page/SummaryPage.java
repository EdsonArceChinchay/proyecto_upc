package com.tdp.ct.web.page;

import com.google.gson.JsonObject;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.SessionStorage.getSessionStorageAsJsonObject;
import static com.tdp.ct.web.utils.SessionStorage.getValueJsonObjectSessionStorage;
import static com.tdp.ct.web.utils.WebUtils.*;

public class SummaryPage extends WebBase {

    private static JsonObject saleObject;
    @FindBy(css = "button[class=\"btnStart\"],tdp-st-button[label=\"Iniciar Registro\"]")
    protected WebElement btnStartRegister;
    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnClose;
    protected final String paginaResumen = "(//div[@class='title'])/span";
    @FindBy(css = ".title span")
    protected WebElement nombrePlan;
    @FindBy(xpath = "//div[@class='plan2']")
    protected WebElement lblPrice;
    @FindBy(css = "app-agenda-page .info-user, app-agenda-mt .info-user")
    protected WebElement labelAppointment;

    public void validacionPrecio(String precioPlan) {
        Assert.assertEquals(precioPlan, lblPrice.getText());
    }

    public void validarNomPlan(String nomPlan) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(nombrePlan, nomPlan);
    }

    public void moverToElementStartRegister() {
        UtilWeb.waitForSeconds(5);
        esperaProgresiva(driver(), 6, 6, btnStartRegister);
        js().scrollElementTop(btnStartRegister);
    }

    public void clickButtonStartRegister() {
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 6, btnStartRegister);
        btnStartRegister.click();
        clickBtnCerrarModalError(btnStartRegister);
        revisarModalError(driver());
    }

    public void clickBtnCerrarModalError(WebElement repeatedMethod) {
        int contador = 0, i = 0;
        int reintentosMax = 3;
        int segundosEspera = 5;
        boolean bOK = false;

        UtilWeb.waitForSeconds(1);
        do {
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")).isEmpty();
                if (elementoExistente) {
                    click(btnClose);
                    logInfo("Dio click en cerrar - modal error Timeslot " + i);
                    UtilWeb.waitForSeconds(5);
                    click(repeatedMethod);
                    bOK = true;
                } else {
                    logInfo("No se encontro el modal error Timeslot");
                }

            } catch (Exception e) {
                logSevere("ERROR", e.getMessage());
            }
            if (validateIsDisplayed(labelAppointment)) {
                logInfo("You are on appointment");
                break;
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
    }

    public void paginaResumen() {
        revisarModalError(driver());
        WebElement sumaryPage = explicitWaitXpath(driver(), 10, paginaResumen);
        esperaProgresiva(driver(), 6, 6, sumaryPage);
        js().scrollElementTop(sumaryPage);
        Assert.assertTrue("El elemento no existe", sumaryPage.isDisplayed());
    }

    public void additionalData() {
        saleObject = getSessionStorageAsJsonObject(driver(), "saleObject");
        logInfo("getSalesID(): " + getSalesID());
        logInfo("productType(): " + getProductType());
        int number = (getProductType().equals("MT")) ? 1 : 0;
        logInfo("needAppointment(): " + needAppointment(number));
        logInfo("isUpfront(): " + isUpfront(number));
        logInfo("getReason(): " + getReason(number));
        logInfo("getAction(): " + getAction(number));
        logInfo("getCOAdditionalData()" + getCOAdditionalData());
    }

    public String getSalesID() {
        return getValueJsonObjectSessionStorage(saleObject, "salesId");
    }

    public String isUpfront(int number) {
        return "";//getValueJsonObjectSessionStorage(saleObject, "commercialOperation.1." + number + ".productOfferings.1.0.upFront.indicator");
    }

    public String getProductType() {
        return getValueJsonObjectSessionStorage(saleObject, "productType");
    }

    public String getReason(int number) {
        return "";//getValueJsonObjectSessionStorage(saleObject, "commercialOperation.1." + number + ".reason");
    }

    public String getAction(int number) {
        return "";//getValueJsonObjectSessionStorage(saleObject, "commercialOperation.1." + number + ".action");
    }

    public String getCOAdditionalData() {
        return "";// getValueJsonObjectSessionStorage(saleObject,"commercialOperation.1.0.additionalData");
    }

    public String needAppointment(int number) {
        String productType = getProductType();
        switch (productType) {
            case "WIRELINE":
                return getValueJsonObjectSessionStorage(saleObject, "commercialOperation.1." + number + ".productOfferings.1.0.additionalData.1.23.value");
            case "MT":
                return getValueJsonObjectSessionStorage(saleObject, "commercialOperation.1." + number + ".productOfferings.1.0.additionalData.1.25.value");
            default:
                return null;
        }
    }
}
