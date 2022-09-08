package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultaDireccionPorCoordenasPage extends WebBase {

    @FindBy (xpath = "(//*[@formcontrolname='longitude'])[1]")
    protected WebElement txtX;

    @FindBy (xpath = "(//*[@formcontrolname='latitude'])[1]")
    protected WebElement txtY;

    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        type(txtX,x.trim());
        UtilWeb.waitForSeconds(1);
        type(txtY,y.trim());
        UtilWeb.waitForSeconds(1);
    }
}
