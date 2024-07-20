package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;

public class AltaFijaAltaMovilRetailPage extends WebBase {

    public void tipearCorreo(String correo) {
        String getCorreo = "div form div:nth-child(4) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement correoElement = js().getWebElement(getCorreo);
        click(correoElement);
        correoElement.sendKeys(correo);

        String inputCorreo2 = "div form div:nth-child(5) tdp-st-input-text;input";
        WebElement correoElement2 = js().getWebElement(inputCorreo2);
        click(correoElement2);
        type(correoElement2, correo);

        UtilWeb.waitForSeconds(3);
    }

}