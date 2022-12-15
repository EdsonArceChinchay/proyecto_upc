package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraMTconCambioVelocidaCallCenterPage extends WebBase {

    @FindBy(xpath = "//div[@class=\"div-product-name\"]")
    WebElement scrollCartillaMT;

    @FindBy(xpath = "(//div[@class=\"content-card\"]/strong)[1]")
    WebElement LineaMovil;

    @FindBy(xpath = "//div[@class=\"footer\"]/button")
    WebElement mostrarOfertas;
    public void seleccionoCartillaPlanMT() {
        js().scrollElementTop(scrollCartillaMT);
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(scrollCartillaMT, 40).click();
        UtilWeb.waitForSeconds(10);
    }

    public void seleccionoLineaMovil() {
        UtilWeb.waitForSeconds(1);
        waitUntilElementIsClickable(LineaMovil, 40).click();
    }

    public void seleccionoMostrarOferta() {
        click(mostrarOfertas);
    }
}
