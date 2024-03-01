package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SvaBloqueHboaDuoPorTiendaPage extends WebBase {
    @FindBy(css = "div:nth-child(2) > div.container-actions > div.actions-content > div > tdp-st-checkbox")
    WebElement seletcBloqueHbo;

    @FindBy(xpath = "//div/button[contains(text(),'Guardar cambios')]")
    protected WebElement buttonGuardarCambios;

    public void seleccionoBloqueHbo() {
        UtilWeb.waitForSeconds(3);
        click(seletcBloqueHbo);
    }

    public void guardarCambios() {
        js().scrollElementTop(buttonGuardarCambios);
        waitUntilElementIsVisible(buttonGuardarCambios, 10);
        click(buttonGuardarCambios);
        UtilWeb.waitForSeconds(5);
    }
}
