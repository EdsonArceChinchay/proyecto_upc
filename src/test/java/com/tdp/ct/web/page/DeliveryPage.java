package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.returnCompareWebElementTextAndText;
import static com.tdp.ct.web.utils.Helper.typeInputShadowRootCSS;

public class DeliveryPage extends WebBase {
    @FindBy(xpath = "//tdp-st-select[@formcontrolname='deliveryType'] | //*[@formcontrolname='deliveryType']")
    protected WebElement selectDeliveryType;
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Confirmar ubicación') or contains(@class,'button') and contains(text(),'Confirmar ubicación')]")
    protected WebElement btnConfirmLocation;
    @FindBy(xpath = "(//button[@class='button_step'])")
    protected WebElement btnConfirmDelivery;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='instruction'] | //*[@formcontrolname='instruction']")
    protected WebElement inputInstruction;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='contactNumber'] | //*[@formcontrolname='contactNumber']")
    protected WebElement inputContactNumber;


    public void clickButtonConfirmLocation() {
        esperaProgresiva(driver(), 6, 5, btnConfirmLocation);
        js().scrollElementTop(btnConfirmLocation);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnConfirmLocation.getText());
        btnConfirmLocation.click();
    }

    public void selectTypeOfDelivery(String deliveryType) {
        esperaProgresiva(driver(), 6, 6, selectDeliveryType);
        js().scrollElementTop(selectDeliveryType);
        selectDeliveryType.click();
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = selectDeliveryType.getShadowRoot();
        List<WebElement> listItems = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement item : listItems) {
            boolean isEquals = returnCompareWebElementTextAndText(item, deliveryType);
            if (isEquals) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Select element " + item.getText());
                item.click();
                break;
            }
        }
    }

    public void clickOnDeliveryTime(String hour) {
        WebElement btnElement = driver().findElement(By.xpath("//*[@class='boxHour']//*[contains(text(),'" + hour + "')]"));
        waitUntilElementIsClickable(btnElement, 20);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click hour" + btnElement.getText());
        btnElement.click();
    }

    public void typeTelephone(String numberPhone) {
        typeInputShadowRootCSS(numberPhone, inputContactNumber, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type telephone " + numberPhone);
    }

    public void typeDeliveryInstructions(String instruction) {
        typeInputShadowRootCSS(instruction, inputInstruction, "div > div > div > input");
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Type instruction " + instruction);
    }

    public void clickButtonConfirmDevlivery() {
        esperaProgresiva(driver(), 3, 5, btnConfirmDelivery);
        js().scrollElementTop(btnConfirmDelivery);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button " + btnConfirmDelivery.getText());
        click(btnConfirmDelivery);
    }

}
