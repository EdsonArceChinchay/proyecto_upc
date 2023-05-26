package com.tdp.ct.web.page.VentaRuc10;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActualizacionDeRuc17CanalTiendaPage extends WebBase {

    @FindBy(xpath = "//button[@class='update_button']")
    protected WebElement btnActualizar;

    public void ingresoRuc17(String ruc) {
        WebElement Input= find().getElementByXPath("//input[@formcontrolname=\"twoDigitRuc\"]");
        Addons.esperaProgresiva(driver(),2, 2, Input);
        click(Input);
        type(Input, ruc);
    }

    public void ingresoDigitoV(String digito) {
        WebElement Input= find().getElementByXPath("//input[@formcontrolname=\"endDigitRuc\"]");
        Addons.esperaProgresiva(driver(),2, 2, Input);
        click(Input);
        type(Input, digito);
    }

    public void clickBotonActualizar() {
        click(btnActualizar);
    }
}
