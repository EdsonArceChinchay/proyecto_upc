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
    @FindBy(xpath = "//div[@class='stl_plan_actual' and contains(text(),'PLAN ACTUAL')]")
    protected WebElement lblCurrentPlan;
    @FindBy(xpath = "//span[@class='itemPriceEquip' and contains(text(),' Precio')]")
    protected WebElement lblDevicePaymentDetail;

    @FindBy(xpath = "//app-device-detail//h3")
    protected List<WebElement> deviceList;

    protected List<WebElement> getDeviceList() {
        return driver().findElements(By.xpath("//h3[contains(text(),'')]"));
    }


    // VENTANA EMERGENTE DE EQUIPO SIN STOCK
    @FindBy(xpath = "//*[contains(normalize-space(text()), 'Equipo No Disponible')]")
    protected WebElement titleEquipoNoDisponible;
    @FindBy(xpath = "//*[contains(normalize-space(text()), 'Equipo No Disponible')]/parent::*/following-sibling::*/*[contains(@class, 'detail')]/*/*[contains(@class, 'format')]")
    protected WebElement obtenerNombreEquipoNoDisponible;
    @FindBy(xpath = "//*[contains(normalize-space(text()), 'ELEGIR OTRO')] | //*[contains(normalize-space(text()), 'legir otro')]")
    protected WebElement btnElegirOtroEquipo;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void selectTypeOfPayment(String payment) {
        boolean typePaymentMethod = false;
        for (WebElement elements : listTypeOfPayment) {
            if (elements.getText().contains(payment)) {
                waitUntilElementIsClickable(elements, 20).click();
                UtilWeb.waitForSeconds(1);
                typePaymentMethod = driver().findElement(By.xpath("//div[@class='_item mb-10 active']")).getText().contains(payment);
                break;
            }
        }
        Assert.assertTrue("No se pudo dar click en el tipo de pago requerido", typePaymentMethod);
        UtilWeb.waitForSeconds(5);
    }

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


    public void clickBtnSeeDeviceDetails(String equipo) {

        JavascriptExecutor js = (JavascriptExecutor) driver();

        List<WebElement> devices = driver().findElements(
                By.xpath("//app-device-detail//h3")
        );

        if (devices.isEmpty()) {
            throw new RuntimeException("❌ No se encontraron dispositivos en el DOM");
        }

        for (WebElement element : devices) {

            String deviceName = element.getText().trim();
            logInfo("🔍 Evaluando: " + deviceName);

            if (deviceName.equalsIgnoreCase(equipo)) {

                logInfo("✅ Equipo encontrado");

                WebElement container = element.findElement(
                        By.xpath("./ancestor::app-device-detail")
                );

                WebElement button = container.findElement(
                        By.xpath(".//tdp-st-button[@label='Ver detalle']//button")
                );

                js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
                js.executeScript("arguments[0].click();", button);

                logInfo("✅ Click ejecutado");

                return;
            }
        }

        throw new RuntimeException("❌ No se encontró el equipo: " + equipo);
    }


    /**
     * FUNCION VALIDAR STOCK EQUIPO
     * */

    public void clickBtnSeeDeviceDetails() {
        try {
            logInfo("Ingreso a visualizar si existe stock del equipo movil");
            if (titleEquipoNoDisponible.isDisplayed()) {
                miScenario.printFullView();
                String nombreEquipoMovil = obtenerNombreEquipoNoDisponible.getText().trim();
                logInfo("No hay stock disponible para el Equipo Movil - " + nombreEquipoMovil);
                logInfo("Se procede a finalizar el script");
                driver().quit();
            }
        } catch (Exception e) {
            logInfo("No se visualizo alerta de equipo movil sin stock");
        }
    }
}
