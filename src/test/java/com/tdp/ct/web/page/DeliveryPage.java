package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.*;

public class DeliveryPage extends WebBase {
    @FindBy(css = "tdp-st-select[formcontrolname='deliveryType']")
    protected WebElement selectDeliveryType;
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Confirmar ubicación') or contains(@class,'button') and contains(text(),'Confirmar ubicación')]")
    protected WebElement btnConfirmLocation;
    @FindBy(xpath = "(//button[@class='button_step'])")
    protected WebElement btnConfirmDelivery;
    @FindBy(css = "tdp-st-input-text[formcontrolname='instruction'] input")
    protected WebElement inputInstruction;
    @FindBy(css = "tdp-st-input-text[formcontrolname='contactNumber'] input")
    protected WebElement inputContactNumber;
    @FindBy(css = "body > app-root > app-delivery > div.info-user span")
    protected WebElement titleDelivery;

    public boolean meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        boolean existe = waitUntilElementIsVisible(titleDelivery, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina de delivery de la linea nueva", existe);
        return existe;
    }

    public void clickButtonConfirmLocation() {
        esperaProgresiva(driver(), 6, 5, btnConfirmLocation);
        js().scrollElementTop(btnConfirmLocation);
        logInfo("Click button", btnConfirmLocation.getText());
        btnConfirmLocation.click();
    }

    public void selectTypeOfDelivery(String deliveryType) {
        esperaProgresiva(driver(), 6, 6, selectDeliveryType);
        js().scrollElementTop(selectDeliveryType);
        clickAndSelectElementCSS(deliveryType, selectDeliveryType, "tdp-st-select[formcontrolname='deliveryType'] li");
    }

    public void clickOnDeliveryTime(String hour) {
        WebElement btnElement = driver().findElement(By.xpath("//*[@class='boxHour']//*[contains(text(),'" + hour + "')]"));
        waitUntilElementIsClickable(btnElement, 20);
        logInfo("Click hour", btnElement.getText());
        btnElement.click();
    }

    public void typeTelephone(String numberPhone) {
        validateAndType("telephone", inputContactNumber, numberPhone);
    }

    public void typeDeliveryInstructions(String instruction) {
        validateAndType("instruction", inputInstruction, instruction);
    }

    public void clickButtonConfirmDevlivery() {
        esperaProgresiva(driver(), 3, 5, btnConfirmDelivery);
        js().scrollElementTop(btnConfirmDelivery);
        logInfo("Click button", btnConfirmDelivery.getText());
        click(btnConfirmDelivery);
    }
}
