package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaeqMasCaplMasCasiPage  extends WebBase {
    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement BtnCambiarPlan;
    public void clickBotonCambiarPlan() {
        UtilWeb.waitForSeconds(10);
        click(BtnCambiarPlan);
    }
}
