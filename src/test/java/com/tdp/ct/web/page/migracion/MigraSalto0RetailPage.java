package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.*;

public class MigraSalto0RetailPage extends WebBase {

    @FindBy(xpath = "(//div/button[@class=\"btnCard\"])[2]")
    WebElement BtnMigrarFibra;

    @FindBy(xpath = "//div/button[@class=\"btnStart\"]")
    WebElement BotonIniciarRegistro;

    @FindBy(xpath = "(//mat-dialog-actions/button[contains(text(),'Entendido')])[1]")
    WebElement btnEntendido;

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
        revisarModalError(driver());
        WebElement tagUVSC = find().getElementByXPath("//*[contains(@class,'banner-upgrade') or contains(text(),'"+value+"')]");
        boolean hasTagUVSC = tagUVSC.isDisplayed();
        Assertions.assertTrue(hasTagUVSC,"The tag UVSC no exist");
    }
}
