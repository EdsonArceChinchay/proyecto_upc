package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AltaFijaRetailPage extends WebBase {

    @FindBy(xpath = "//div[contains(@class,'button-filter-section')]")
    protected WebElement listTipoPlan;

    @FindBy(xpath = "//button[@class='btnSky btnsForms']")
    protected WebElement selecOferta;

    @FindBy(xpath = "//span[contains(text(), 'HOGAR NUEVO')]/../following-sibling::div/div/button")
    protected WebElement lineaNueva;

    public void irSeleccionarTipoPlan(String tipoPlan) {
        UtilWeb.waitForSeconds(1);
        List<WebElement> lista = listTipoPlan.findElements(By.cssSelector("button"));
        for (WebElement element : lista) {
            if (element.getText().contains(tipoPlan)) {
                UtilWeb.waitForSeconds(1);
                click(element, 5);
            }
        }
    }

    public void irSeleccionarPlan(String nombrePlan) {
        UtilWeb.waitForSeconds(3);
        WebElement nPlan = find().getElementByXPath("//div[contains(text(), '" + nombrePlan + "')]/../..");
        click(nPlan, 2);
        UtilWeb.waitForSeconds(2);
    }

    public void darClickOferta() {
        js().scrollElementTop(selecOferta);
        click(selecOferta);
    }

    public void irLineaNueva() {
        UtilWeb.waitForSeconds(1);
        click(lineaNueva, 2);
    }

}
