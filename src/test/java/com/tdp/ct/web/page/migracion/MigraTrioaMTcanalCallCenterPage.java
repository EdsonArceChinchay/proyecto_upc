package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraTrioaMTcanalCallCenterPage extends WebBase {

    @FindBy(xpath = "//div[3]/app-mt-card/div[1]/div/div[1]/div[3]/img")
    protected WebElement btnselecOferta;

    @FindBy(xpath = "//app-mt-change-plan-card/div/div[2]/div[1]/div[1]")
    protected WebElement planOferta;
    @FindBy(xpath = "//button[@class=\"btnSky btnsForms\"]")
    protected WebElement btnseleccionarOferta;

    @FindBy(xpath = "//*[@class='btnCard' and contains(text(),'Ir a movistar total') or @class='btnCard' and contains(text(),'Ir a movistar')]")
    protected WebElement btnIrMovistarTotal;

    @FindBy(xpath = "//app-register/body/div[2]/form/div[7]/button/span")
    protected WebElement btnFinalizarRegistro;

    public void seleccionoPlanMovistarTotal() {
        UtilWeb.waitForSeconds(3);
        waitUntilElementIsClickable(btnselecOferta, 50).click();
        UtilWeb.waitForSeconds(5);
    }

    public void scrollUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void seleccionoPlandeOferta() {
        click(planOferta);
    }

    public void clickBotonSeleccionarOferta() {
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(btnseleccionarOferta);
        click(btnseleccionarOferta);

    }

    public void clickBtnIrMovistarTotal() {
        waitUntilElementIsVisible(btnIrMovistarTotal, 5);
        click(btnIrMovistarTotal);
    }

    //tiempo sperarOrden
    @FindBy(xpath = "/html/body/app-root/app-success/div[2]/div[3]")
    protected WebElement esperarOrden;

    public void clickFinalizarRegistro() {
        waitUntilElementIsVisible(btnFinalizarRegistro, 10);
        click(btnFinalizarRegistro);
        waitUntilElementIsVisible(esperarOrden, 30);
    }
}
