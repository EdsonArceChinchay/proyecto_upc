package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(css = ".btn-detail tdp-st-button")
    protected WebElement btnSeeDetail;

//    public void selectTypeOfPayment(String payment) {
//        esperaProgresiva(driver(), 5, 5, listTypeOfPayment.get(0));
//        js().scrollElementTop(listTypeOfPayment.get(0));
//        selectElement(listTypeOfPayment, payment);
//        UtilWeb.waitForSeconds(5);
//    }

    public void selectTypeOfPayment(String payment) {
        boolean typePaymentMethod = false;
        System.out.println("cantidad: " + listTypeOfPayment.size());
        for (WebElement elements : listTypeOfPayment) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().contains(payment)) {
                System.out.println("Se encontro: " + payment);
                waitUntilElementIsClickable(elements, 20).click();
                UtilWeb.waitForSeconds(1);
                typePaymentMethod = driver().findElement(By.xpath("//div[@class='_item mb-10 active']")).getText().contains(payment);

                break;
            }
        }
        Assert.assertTrue("No se pudo dar click en el tipo de pago requerido",
                typePaymentMethod);
        UtilWeb.waitForSeconds(5);
    }

//    public void selectTypeOfPayment(String pago) {
//        boolean tipoPagoEncontrado = false;
//        System.out.println("cantidad: " + listTypeOfPayment.size());
//        for (WebElement elements : listTypeOfPayment) {
//            System.out.println("Producto: " + elements.getText());
//            if (elements.getText().equals(pago)) {
//                System.out.println("Se encontro: " + pago);
//                waitUntilElementIsClickable(elements, 20).click();
//                UtilWeb.waitForSeconds(1);
//                tipoPagoEncontrado = driver().findElement(By.xpath("//div[@class='_item mb-10 active']")).getText().contains(pago);
//                break;
//            }
//        }
//        Assert.assertTrue("No se pudo dar click en el tipo de pago requerido",
//                tipoPagoEncontrado);
//        UtilWeb.waitForSeconds(5);
//    }

    public void selectTimeOfPermanency(String timePermanency) {
        revisarModalError(driver());
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss(".comboPermanecia tdp-st-select");
        esperaProgresiva(driver(), 6, 8, listElementPLan);
        selectElementCSSWithAndWithoutShadowRoot("time permanency", listElementPLan, timePermanency);
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
        validateAndClickWithAndWithoutShadowRoot("see detail", btnSeeDetail);
    }

    public void validateFeatures() {
        UtilWeb.waitForSeconds(2);
        Assertions.assertFalse(featureContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
    }

    @FindBy(xpath = "//div[@class='stl_plan_actual' and contains(text(),'PLAN ACTUAL')]")
    protected WebElement lblCurrentPlan;

    @FindBy(xpath = "//span[@class='itemPriceEquip' and contains(text(),' Precio')]")
    protected WebElement lblDevicePaymentDetail;

    public void scrollToOfertDetails(ManageScenario scenario) {
        esperaProgresiva(driver(), 5, 5, lblCurrentPlan);
        js().scrollElementTop(lblCurrentPlan);
        scenario.printFullView();
        js().scrollElementTop(lblDevicePaymentDetail);
        scenario.printFullView();
    }

    public void scrollToDeviceList() {
        js().scrollElementTop(find().getElementByXPath("(//div[@class='_item-device']/h3)[1]"));
        UtilWeb.waitForSeconds(5);
    }

    @FindBy(xpath = "(//div[@class='_item-device']/h3)")
    protected List<WebElement> deviceList;

    public void clickBtnSeeDeviceDetails(String equipo) {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        for (WebElement element : deviceList) {
            if (element.getText().equals(equipo)) {
                js.executeScript("return document.querySelectorAll(\"body > app-root > app-devices > " +
                        "div.cont-devices > div > div:nth-child(1) > div > div.btn-detail > tdp-st-button\")[" +
                        deviceList.indexOf(element) + "].shadowRoot.querySelector(\"button > div\").click()");
                break;
            }
        }
    }
}
