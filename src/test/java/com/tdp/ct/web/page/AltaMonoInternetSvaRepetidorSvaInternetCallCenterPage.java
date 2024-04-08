package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;


public class AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage extends WebBase {

    @FindBy(xpath = "//button[contains(text(),'SVA')]")
    protected WebElement buttonAgregarSVA;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/div/tdp-st-icon-button[1]")
    protected WebElement sva_repetidor;

    public void agregarsva() {
        UtilWeb.waitForSeconds(10);
        WebElement sva = find().getElementByXPath("//button[contains(text(),'SVA')]");
        waitUntilElementIsClickable(sva, 200);
        js().scrollElementTop(sva);
        sva.click();
    }

    public void agregarsvainternet(String string) {
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
        UtilWeb.waitForSeconds(3);
        String repetidor = "//div[text()='" + string + "']/parent::div/../descendant-or-self::tdp-st-icon-button[1]";
        WebElement deco = find().getElementByXPath(repetidor);
        waitUntilElementIsClickable(deco,20);
        js().scrollElementTop(deco);
        deco.click();
    }

    public void seleccionardecodificador(String string) {
        UtilWeb.waitForSeconds(3);
        String decodificador = "//div[text()=' Cuota mensual : S/" + string + " " + "']/parent::div/../descendant-or-self::tdp-st-icon-button[1]";
        WebElement deco = find().getElementByXPath(decodificador);
        waitUntilElementIsClickable(deco,20);
        js().scrollElementTop(deco);
        deco.click();
    }

}
