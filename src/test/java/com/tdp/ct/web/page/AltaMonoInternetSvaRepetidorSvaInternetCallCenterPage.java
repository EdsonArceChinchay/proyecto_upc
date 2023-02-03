package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage extends WebBase{

    @FindBy(xpath = "//div[@class='container-btns']/button[contains(text(),'SVA')]")
    protected WebElement buttonAgregarSVA;

    public void agregarsva() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(buttonAgregarSVA);
        waitUntilElementIsVisible(buttonAgregarSVA, 10);
        click(buttonAgregarSVA);
        UtilWeb.waitForSeconds(20);
    }

    public void agregarsvainternet(String string) {
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss("app-adicionales tdp-st-select");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(string)) {
                UtilWeb.waitForSeconds(2);
                click(elements, 3);
            }
        }
    }
}
