package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraTrioaMTcanalCallCenterPage extends WebBase {

    @FindBy(xpath = "//div[3]/app-mt-card/div[1]/div/div[1]/div[3]/img")
    protected WebElement btnselecOferta;

    public void seleccionoPlanMovistarTotal() {
        UtilWeb.waitForSeconds(3);
        click(btnselecOferta);
        UtilWeb.waitForSeconds(10);
    }
    public void scrollUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }
}
