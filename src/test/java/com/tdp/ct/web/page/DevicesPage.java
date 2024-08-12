package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.Helper.returnValueCompareWebElementTextAndString;

public class DevicesPage extends WebBase {

    @FindBy(xpath = "//div[@class='option-boxes']//div")
    protected List<WebElement> listPago;

    @FindBy(css = ".col-2 ._info")
    protected WebElement caracteristicasContent;

    @FindBy(xpath = "(//tdp-st-button[@class='tdp-st-button-l hydrated' and @label='Seleccionar'])[1]")
    protected WebElement btnSelect;

    @FindBy(xpath = "(//tdp-st-button[@label='Seleccionar equipo'])[1]")
    protected WebElement btnSelectDevice;

    public void selectTypeOfPayment(String payment) {
        boolean tipoPagoEncontrado = false;
        esperaProgresiva(driver(), 5, 5, listPago.get(0));
        js().scrollElementTop(listPago.get(0));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Count type of payment: " + listPago.size());
        for (WebElement elements : listPago) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type of payment: " + elements.getText());
            if (elements.getText().equalsIgnoreCase(payment)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Payment type found: " + payment);
                waitUntilElementIsClickable(elements, 20).click();
                tipoPagoEncontrado = true;
                break;
            }
        }
        if (!tipoPagoEncontrado) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No payment type found: " + payment);
        }
        UtilWeb.waitForSeconds(5);
    }

    public void selectTimeOfPermanency(String timePermanency) {
        UtilWeb.waitForSeconds(3);
        revisarModalError(driver());
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss(".comboPermanecia tdp-st-select");
        waitUntilElementIsClickable(listElementPLan, 40).click();
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > div > ul > li"));
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Count of Time of permanency " + lista.size());
        for (WebElement elements : lista) {
            boolean isEquals = returnValueCompareWebElementTextAndString(elements, timePermanency);
            if (isEquals) {
                click(elements, 3);
            }
        }
    }

    public void typeDeviceAndSearch(String buscarE) {
        WebElement Input = find().getElementByCss("div.search-input-content > tdp-st-input-text");
        click(Input);
        type(Input, buscarE);
        UtilWeb.waitForSeconds(10);
        Input.sendKeys(Keys.ENTER);
    }

    public void clickButtonSelect() {
        esperaProgresiva(driver(), 5, 5, btnSelect);
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
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Quantity of devices " + counter);
            return counter;
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No devices" + e.getMessage());
            return 0;
        }
    }

    public void scrollToButtonSeeDetail() {
        js().scrollElementTop(find().getElementByCss(".button-offer:nth-child(1)"));
        UtilWeb.waitForSeconds(5);
    }

    public void clickButtonSeeDetail() {
        String btnVerOfertas = ".btn-detail tdp-st-button;button";
        WebElement element = js().getWebElement(btnVerOfertas);
        element.click();
    }

    public void validateFeatures() {
        Assertions.assertFalse(caracteristicasContent.getText().isEmpty(), "Error, no se encuentran las caracteristicas del equipo");
        UtilWeb.waitForSeconds(1);
    }

}
