package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraSalto0RetailPage extends WebBase {
    @FindBy(xpath = "(//div/button[@class=\"btnCard\"])[2]")
    WebElement BtnMigrarFibra;
    @FindBy(xpath = "//div/button[@class=\"btnStart\"]")
    WebElement BotonIniciarRegistro;
    @FindBy(xpath = "//mat-dialog-actions/button[contains(text(),'Entendido')]")
    WebElement btnEntendido;
    public void SeleccionarBtnMigrarFibra() {
        waitUntilElementIsVisible(BtnMigrarFibra,60);
        click(BtnMigrarFibra);

    }

    public void ClicIniciarRegistro() {
        waitUntilElementIsVisible(BotonIniciarRegistro,30);
        click((BotonIniciarRegistro));

    }

    public void clickBotonEntendido() {
        UtilWeb.waitForSeconds(10);
        click(btnEntendido);
        UtilWeb.waitForSeconds(5);
        click(btnEntendido);
    }
}
