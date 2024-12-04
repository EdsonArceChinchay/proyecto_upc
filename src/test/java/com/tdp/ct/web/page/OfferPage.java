package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;

public class OfferPage extends WebBase {

    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;
    @FindBy(css = "h1.title")
    protected WebElement titleOfertas;
    @FindBy(xpath = "//*[contains(@class,'detalle')]")
    protected WebElement labelDetail;
    @FindBy(xpath = "//*[@class='detalle_sub']")
    protected WebElement subDetalles;
    @FindBy(xpath = "//*[contains(text(),'aplica UPFRONT')]")
    protected WebElement lblAplicaUpFront;
    @FindBy(xpath = "//div/span[contains(@class,'smallTitle')]/../../following-sibling::*//img")
    protected List<WebElement> listaOfertasSugeridas;

    public void ofertasSugeridas() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, ofertasSugeridas);
        revisarModalError(driver());
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//p[contains(text(),'RESTRICCIONES')]")).isEmpty();
        if (elementoExistente) {
            js().scrollElementTop(subDetalles);
            click(subDetalles);
            logInfo("si estaba abierto el detalle");
            UtilWeb.waitForSeconds(1);
        }
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", ofertasSugeridas.isDisplayed());
    }

    public boolean validarQueExistanOfertasSugeridas() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 8, 9, listaOfertasSugeridas.get(0));
        boolean exist = waitUntilElementIsVisible(listaOfertasSugeridas.get(0), 60).isDisplayed();
        logInfo("Estas en la pagina de ofertas >>> {0}", exist);
        return exist;
    }

    public void validarOfertasSugeridasView(String title) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 7, titleOfertas);
        js().scrollElementTop(labelDetail);
        String actualTitle = titleOfertas.getText().toLowerCase();
        Assert.assertEquals("El titulo obtenido: " + actualTitle + ", no coincide con lo esperado", title.toLowerCase(), actualTitle);
    }

    public void subDetalles() {
        UtilWeb.waitForSeconds(20);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        esperaProgresiva(driver(), 5, 6, subDetalles);
        waitUntilElementIsClickable(subDetalles, 12);
        click(subDetalles);
    }

    public void lblAplicaUpFrom() {
        UtilWeb.waitForSeconds(1);
        esperaProgresiva(driver(), 4, 10, lblAplicaUpFront);
        Assert.assertTrue("el elemento no existe", lblAplicaUpFront.isDisplayed());
        click(subDetalles, 5);
    }

}
