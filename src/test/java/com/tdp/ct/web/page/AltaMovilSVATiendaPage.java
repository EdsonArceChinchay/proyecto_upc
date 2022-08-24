package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class AltaMovilSVATiendaPage extends WebBase {
    @FindBy(xpath = "//div//span[contains(text(),'Prepago')]")
    protected WebElement btnPrepago;

    public void seleccionoElPlanPrepago() {
        UtilWeb.waitForSeconds(5);
        click(btnPrepago, 2);
        UtilWeb.waitForSeconds(5);
       seleccionarBotonSiguiente();

    }
    public void seleccionarBotonSiguiente(){
        UtilWeb.waitForSeconds(5);
    WebElement btnSiguiente=find().getElementByCss(".modal_footer tdp-st-button");
        click(btnSiguiente, 10);


}

}