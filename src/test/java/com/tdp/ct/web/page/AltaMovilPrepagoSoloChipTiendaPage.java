package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AltaMovilPrepagoSoloChipTiendaPage extends WebBase {

    @FindBy(xpath = "(//div[contains(@class,'pt-4')]/div[@class='tdp-row'])[1]")
    protected List<WebElement> listOfert;

    @FindBy(xpath = "//div[@class='button-filter-section']")
    protected List<WebElement> selecPrepago;

    public void seleccionarOferta(String oferta) {
        //clickElementInAList(listOfert, oferta.toUpperCase());
        UtilWeb.waitForSeconds(20);
        WebElement btnOferta = find().getElementByXPath("//span[text()='" + oferta + "']/../../following-sibling::*//img");
        click(btnOferta);
        UtilWeb.waitForSeconds(3);
    }

    public void seleccionaPrepago() {
        UtilWeb.waitForSeconds(3);
        clickElementInAList(selecPrepago, "Prepago");
        UtilWeb.waitForSeconds(3);
    }

    public void seleccionaPlan(String plan) {
        UtilWeb.waitForSeconds(2);
        WebElement tipoPlan = find().getElementByXPath("\"//div[contains(text(),'" + plan + "')]/../..");
        click(tipoPlan);
    }
}
