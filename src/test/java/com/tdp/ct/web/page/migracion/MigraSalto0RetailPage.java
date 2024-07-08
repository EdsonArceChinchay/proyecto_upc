package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.*;

public class MigraSalto0RetailPage extends WebBase {

    @FindBy(xpath = "(//div/button[@class='btnCard'])[2] | //button[@class='btnCard' and contains(text(),'Migrar a Fibra')]")
    protected WebElement BtnMigrarFibra;

    @FindBy(xpath = "//div/button[@class='btnStart']")
    protected WebElement BotonIniciarRegistro;

    @FindBy(css = "h1.title")
    protected WebElement titleOffer;

    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[1]")
    protected WebElement currentHomePlanPrice;

    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[2]")
    protected WebElement currentMonthlyPlanPrice;

    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[3]")
    protected WebElement newHomePlanPrice;

    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[4]")
    protected WebElement newMonthlyPlanPrice;

    @FindBy(xpath = "(//*[contains(@class,'border_upgrade')]//*[contains(@class,'separator')])[1]")
    protected WebElement separator;

    public void SeleccionarBtnMigrarFibra() {
        esperaProgresiva(driver(), 3, 5, BtnMigrarFibra);
        js().scrollElementTop(BtnMigrarFibra);
        click(BtnMigrarFibra);

    }

    public void ClicIniciarRegistro() {
        esperaProgresiva(driver(), 5, 5, BotonIniciarRegistro);
        js().scrollElementTop(BotonIniciarRegistro);
        click(BotonIniciarRegistro);

    }

    public void clickBotonEntendido() {
        revisarModalError(driver());
    }

    public void validateTagUVSC(String value) {
        js().scrollElementTop(titleOffer);
        revisarModalError(driver());
        WebElement tagUVSC = find().getElementByXPath("//*[contains(@class,'banner-upgrade') or contains(text(),'" + value + "')]");
        boolean hasTagUVSC = tagUVSC.isDisplayed();
        Assertions.assertTrue(hasTagUVSC, "The tag UVSC no exist");
    }

    public void validateCurrentAndNewPrice() {
        js().scrollElementTop(separator);
       boolean hasSameHomePlanPrice = compareTextWebElement(currentHomePlanPrice,newHomePlanPrice);
        Assertions.assertTrue(hasSameHomePlanPrice,"Not the same home plan price");
       boolean hasSameMonthlyPlanPrice =compareTextWebElement(currentMonthlyPlanPrice,newMonthlyPlanPrice);
        Assertions.assertTrue(hasSameMonthlyPlanPrice,"Not the same monthly plan price");
    }

    public boolean compareTextWebElement(WebElement element1, WebElement element2)
    {
        return element1.getText().trim().equalsIgnoreCase(element2.getText().trim());
    }
}
