package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage extends WebBase {

    @FindBy(xpath = "//span[@class='itemPriceEquip']")
    protected List<WebElement> listTotalPlan;
    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;

    public void visualizaDetallesPlanElejido(ManageScenario scenario) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        js().scrollElementTop(ofertasSugeridas);
        scenario.printFullView();
        for (WebElement e : listTotalPlan) {
            js().scrollElementTop(e);
            scenario.printFullView();
        }
    }
}
