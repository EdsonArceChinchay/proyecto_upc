package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AltaTrioMTconUpfrontTiendaPage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div/div[3]/div[1]/div/div")
    protected WebElement btnLineaNueva ;

    @FindBy(xpath = "//div[2]/div[3]/button")
    protected WebElement btnMostrarOfertas ;

    public void clickBotonLineaNueva(){
        js().scrollElementTop(btnLineaNueva);
        waitUntilElementIsVisible(btnLineaNueva,15);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(1);

    }
    public void clickBotonMostrarOfertas(){
        js().scrollElementTop(btnMostrarOfertas);
        click(btnMostrarOfertas);
    }
}
