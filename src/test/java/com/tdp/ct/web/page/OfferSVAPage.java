package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.compareWebElementTextAndString;
import static com.tdp.ct.web.utils.WebUtils.selectElementXpath;

public class OfferSVAPage extends WebBase {

    @FindBy(xpath = " //button[contains(text(),'Guardar cambios') ] | //*[contains(text(),'Guardar cambios')] ")
    protected WebElement btnSaveChanges;

    @FindBy(xpath = "//*[@class='title']/h1")
    protected WebElement labelTitle;

    public void validateScreenName(String name) {
        logInfo("Validate screen name", name);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 7, labelTitle);
        js().scrollElementTop(labelTitle);
        compareWebElementTextAndString(labelTitle, name);
    }

    public void clickButtonSaveChanges() {
        js().scrollElementTop(btnSaveChanges);
        btnSaveChanges.click();
        logInfo("Click button Save Changes");
    }

    public void clickBackToSumary() {
    }

    public void addSVAIconButton(String name) {
        WebElement nameSVA = find().getElementByXPath("(//*[contains(text(),'" + name + "')]/ancestor::div[contains(@class,'content-section')]//tdp-st-icon-button[contains(@icon,'add')])[1]");
        logInfo("Add SVA " + nameSVA.getText());
        nameSVA.click();
    }

    public void addSVACheckBox(String name) {
        WebElement nameSVA = find().getElementByXPath("(//*[contains(text(),'" + name + "')]/parent::div/following-sibling::div[contains(@class,'container-actions')]//tdp-st-checkbox)[1]");
        logInfo("Add SVA " + nameSVA.getText());
        nameSVA.click();
    }

    public void scrollToTitle(String name) {
        WebElement titleSection = find().getElementByXPath("//*[contains(@class,'title-section') or contains(@class,'section-options')]/*[contains(text(),'" + name + "')]");
        esperaProgresiva(driver(), 5, 5, titleSection);
        js().scrollElementTop(titleSection);
    }

    public void addSVASelect(String section, String nameSVA) {
        WebElement listElementPLan = find().getElementByXPath("//div[contains(text(),'" + section + "')]/../descendant-or-self::tdp-st-select");
        selectElementXpath(nameSVA, listElementPLan, "//div[contains(text(),'" + section + "')]/../descendant-or-self::tdp-st-select//li");
    }

}
