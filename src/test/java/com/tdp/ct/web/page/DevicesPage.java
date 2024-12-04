package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class DevicesPage extends WebBase {

    @FindBy(xpath = "//div[@class='option-boxes']//div")
    protected List<WebElement> listPago;

    @FindBy(css = ".col-2 ._info")
    protected WebElement caracteristicasContent;

    @FindBy(css = "tdp-st-button[label='Seleccionar'] button")
    protected WebElement btnSelect;

    @FindBy(xpath = "(//tdp-st-button[@label='Seleccionar equipo'])[1]")
    protected WebElement btnSelectDevice;

    public void selectTypeOfPayment(String payment) {
        boolean tipoPagoEncontrado = false;
        esperaProgresiva(driver(), 5, 5, listPago.get(0));
        js().scrollElementTop(listPago.get(0));
        logInfo("Count type of payment", listPago.size());
        for (WebElement elements : listPago) {
            logInfo("Type of payment", elements.getText());
            boolean isEquals = returnValueCompareWebElementTextAndString(elements, payment);
            if (isEquals) {
                logInfo("Payment type found: " + payment);
                waitUntilElementIsClickable(elements, 20).click();
                tipoPagoEncontrado = true;
                break;
            }
        }
        if (!tipoPagoEncontrado) {
            logInfo("No payment type found", payment);
        }
        UtilWeb.waitForSeconds(5);
    }

    public void selectTimeOfPermanency(String timePermanency) {
        revisarModalError(driver());
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss(".comboPermanecia tdp-st-select");
        esperaProgresiva(driver(), 6, 8, listElementPLan);
        selectElementCSS(timePermanency, listElementPLan, ".comboPermanecia tdp-st-select li");
    }

    public void typeDeviceAndSearch(String device) {
        WebElement inputDevice = find().getElementByCss("div.search-input-content > tdp-st-input-text input");
        validateAndType("device", inputDevice, device);
        inputDevice.sendKeys(Keys.ENTER);
    }

    public void clickButtonSelect() {
        esperaProgresiva(driver(), 6, 8, btnSelect);
        js().scrollElementTop(btnSelect);
        waitUntilElementIsClickable(btnSelect, 10).click();
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
    }

    public void clickButtonSelectDevice() {
        esperaProgresiva(driver(), 5, 5, btnSelectDevice);
        js().scrollElementTop(btnSelectDevice);
        waitUntilElementIsClickable(btnSelectDevice, 10).click();
        revisarModalError(driver());
    }

    public int quantityOfDevicesOfTheSearchResult() {
        try {
            UtilWeb.waitForSeconds(5);
            List<WebElement> elementos = driver().findElements(By.className("_item-device"));
            int counter = elementos.size();
            logInfo("Quantity of devices", counter);
            return counter;
        } catch (Exception e) {
            logSevere("No devices", e.getMessage());
            return 0;
        }
    }

    public void scrollToButtonSeeDetail() {
        js().scrollElementTop(find().getElementByCss(".cont-devices .tdp-container"));
        UtilWeb.waitForSeconds(5);
    }

    public void clickButtonSeeDetail() {
        String btnVerOfertas = ".btn-detail tdp-st-button button";
        WebElement element = js().getWebElement(btnVerOfertas);
        element.click();
    }

    public void validateFeatures() {
        Assertions.assertFalse(caracteristicasContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
        UtilWeb.waitForSeconds(1);
    }

}
