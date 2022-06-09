package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class AltaTrioConBloqueHdUpfrontCallCenterPage extends WebBase {

    @FindBy(xpath = "//div[@class='detalle_sub']")
    protected WebElement subDetalles;

    @FindBy(xpath = "//p[contains(text(),'aplica UPFRONT')]")
    protected WebElement lblAplicaUpFront;

    public void subDetalles(){
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        click(subDetalles,10);
    }

    public void lblAplicaUpFrom(){
        UtilWeb.waitForSeconds(1);
        Assert.assertTrue("el elemento no existe",lblAplicaUpFront.isDisplayed());
        UtilWeb.waitForSeconds(1);
        click(subDetalles,10);
    }

    public void callID(String data){
        UtilWeb.waitForSeconds(1);
        WebElement callID= find().getElementByXPath("(//tdp-st-input-text)[4]");
        click(callID);
        UtilWeb.waitForSeconds(1);
        type(callID, data);
    }


}
