package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class DevicesPage extends WebBase {

    @FindBy(css = "[class='option-boxes'] div")
    protected List<WebElement> listTypeOfPayment;

    @FindBy(css = ".col-2 ._info")
    protected WebElement featureContent;

    @FindBy(css = "tdp-st-button[label='Seleccionar']")
    protected WebElement btnSelect;

    @FindBy(xpath = "(//tdp-st-button[@label='Seleccionar equipo'])[1]")
    protected WebElement btnSelectDevice;

    @FindBy(css = "tdp-st-input-text[formcontrolname=\"name\"]")
    protected WebElement inputDevice;

    public void selectTypeOfPayment(String payment) {
        esperaProgresiva(driver(), 5, 5, listTypeOfPayment.get(0));
        js().scrollElementTop(listTypeOfPayment.get(0));
        selectElement(listTypeOfPayment, payment);
        UtilWeb.waitForSeconds(5);
    }

    public void selectTimeOfPermanency(String timePermanency) {
        revisarModalError(driver());
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss(".comboPermanecia tdp-st-select");
        esperaProgresiva(driver(), 6, 8, listElementPLan);
        selectElementCSSWithAndWithoutShadowRoot("time permanency", listElementPLan, ".comboPermanecia tdp-st-select li", timePermanency);
    }

    public void typeDeviceAndSearch(String device) {
        validateAndTypeWithAndWithoutShadowRoot("search by device", inputDevice, device);
        enterWithAndWithoutShadowRoot("search by device", inputDevice);
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
        Assertions.assertFalse(featureContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
        UtilWeb.waitForSeconds(1);
    }

}
