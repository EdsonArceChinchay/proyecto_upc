package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraSalto0RetailPage extends WebBase {
    @FindBy(xpath = "(//div/button[@class=\"btnCard\"])[2]")
    WebElement BtnMigrarFibra;
    @FindBy(xpath = "//div/button[@class=\"btnStart\"]")
    WebElement BotonIniciarRegistro;
    public void SeleccionarBtnMigrarFibra() {
        waitUntilElementIsVisible(BtnMigrarFibra,60);
        click(BtnMigrarFibra);

    }

    public void ClicIniciarRegistro() {
        waitUntilElementIsVisible(BotonIniciarRegistro,30);
        click((BotonIniciarRegistro));

    }
}
