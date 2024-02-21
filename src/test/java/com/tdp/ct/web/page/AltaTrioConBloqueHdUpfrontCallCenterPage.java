package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class AltaTrioConBloqueHdUpfrontCallCenterPage extends WebBase {

    @FindBy(xpath = "//*[@class='detalle_sub']")
    protected WebElement subDetalles;

    @FindBy(xpath = "//*[contains(text(),'aplica UPFRONT')]")
    protected WebElement lblAplicaUpFront;

    public void subDetalles(){
        UtilWeb.waitForSeconds(5);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        esperaProgresiva(driver(), 3, 100, subDetalles);
        click(subDetalles);
    }

    public void lblAplicaUpFrom(){
        UtilWeb.waitForSeconds(1);
        esperaProgresiva(driver(), 3, 30, lblAplicaUpFront);
        Assert.assertTrue("el elemento no existe",lblAplicaUpFront.isDisplayed());
        UtilWeb.waitForSeconds(1);
        click(subDetalles,5);
    }

    public void callID(String data){
        UtilWeb.waitForSeconds(1);
        WebElement callID= find().getElementByXPath("(//tdp-st-input-text)[4]");
        click(callID);
        UtilWeb.waitForSeconds(1);
        type(callID, data);
    }


}
