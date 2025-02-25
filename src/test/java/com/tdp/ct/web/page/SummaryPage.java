package com.tdp.ct.web.page;

import com.google.gson.JsonObject;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.SessionStorage.getSessionStorageAsJsonObject;
import static com.tdp.ct.web.utils.SessionStorage.getValueJsonObjectSessionStorage;
import static com.tdp.ct.web.utils.WebUtils.*;

public class SummaryPage extends WebBase {

    private static JsonObject saleObject;
    protected final String summaryPage = "(//div[@class='title'])/span";

    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnClose;
    @FindBy(css = ".title span")
    protected WebElement nombrePlan;
    @FindBy(xpath = "//div[@class='plan2']")
    protected WebElement lblPrice;
    @FindBy(css = "app-agenda-page .info-user, app-agenda-mt .info-user")
    protected WebElement labelAppointment;

    // BOTON INICIAR REGISTRO
    @FindBy(css = "button[class=\"btnStart\"],tdp-st-button[label=\"Iniciar Registro\"]")
    protected WebElement btnStartRegister;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void validacionPrecio(String precioPlan) {
        Assert.assertEquals(precioPlan, lblPrice.getText());
    }

    public void validarNomPlan(String nomPlan) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(nombrePlan, nomPlan);
    }

    public void validateSummaryPage() {
        revisarModalError(driver());
        WebElement sumaryPage = explicitWaitXpath(driver(), 20, summaryPage);
        esperaProgresiva(driver(), 10, 10, sumaryPage);
        js().scrollElementTop(sumaryPage);
        Assert.assertTrue("El elemento no existe", sumaryPage.isDisplayed());
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

    /**
     * FUNCION - MOVER A BOTON INICIAR REGISTR0
     * */

    public void moverToElementStartRegister() {
        logInfo("Ingreso a visualizar el boton de INCIAR REGISTRO");
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsClickable(btnStartRegister,15);
        logInfo("Se visualizo el boton de INICIAR REGISTRO");
        js().scrollElementTop(btnStartRegister);
        logInfo("Se escrolea al boton de INICIAR REGISTRO");
    }

    public void additionalData() {
        logInfo("Se procede a obtener datos");
        logInfo("##########################");
        saleObject = getSessionStorageAsJsonObject(driver(), "saleObject");
        logInfo("getSalesID(): " + getSalesID());
        logInfo("productType(): " + getProductType());
        int number = (getProductType().equals("MT")) ? 1 : 0;
        logInfo("needAppointment(): " + needAppointment(number));
        logInfo("isUpfront(): " + isUpfront(number));
        logInfo("getReason(): " + getReason(number));
        logInfo("getAction(): " + getAction(number));
        logInfo("getCOAdditionalData()" + getCOAdditionalData());
        logInfo("##########################");
    }

    public void clickButtonStartRegister() {
        logInfo("Se procede a dar click al boton de INICIAR REGISTRO");
        waitUntilElementIsClickable(btnStartRegister,15);
        miScenario.printFullView();
        click(btnStartRegister,5);
        logInfo("Se dio click al boton de INICIAR REGISTRO");
        view.temporalPage().clickBtnReintentar();
    }
}
