package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage extends WebBase{

    @FindBy(xpath = "//div[@class='container-btns']/button[contains(text(),'SVA')]")
    protected WebElement buttonAgregarSVA;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/tdp-st-icon-button[1]")
    protected WebElement sva_repetidor;

    public void agregarsva() {
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(buttonAgregarSVA);
        waitUntilElementIsVisible(buttonAgregarSVA, 10);
        click(buttonAgregarSVA);
        UtilWeb.waitForSeconds(20);
    }

    public void agregarsvainternet(String string) {
        //js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByXPath("//div[contains(text(),'SVA INTERNET')]/../descendant-or-self::tdp-st-select");
        listElementPLan.click();
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
    public void elegimossvarepetidor(String string) {
        System.out.println("aqui");
        String decodificador = "//div[text()='"+string+"']/parent::div/../descendant-or-self::tdp-st-icon-button[1]";
        WebElement deco = find().getElementByXPath(decodificador);
        deco.click();
        UtilWeb.waitForSeconds(3);

    }

}
