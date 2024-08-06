package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

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
        esperaProgresiva(driver(), 3, 5, ofertasSugeridas);
        revisarModalError(driver());
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//p[contains(text(),'RESTRICCIONES')]")).isEmpty();
        if (elementoExistente) {
            js().scrollElementTop(subDetalles);
            click(subDetalles);
            System.out.println("si estaba abierto el detalle");
            UtilWeb.waitForSeconds(1);
        }
        revisarModalError(driver());
        Assert.assertTrue("No esta presente el elemento", ofertasSugeridas.isDisplayed());
    }

    public boolean validarQueExistanOfertasSugeridas() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 6, listaOfertasSugeridas.get(0));
        boolean existe = listaOfertasSugeridas.get(0).isDisplayed();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de ofertas >>> {0}", existe);
        return existe;
    }

    public void validarOfertasSugeridasView(String title) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, titleOfertas);
        js().scrollElementTop(labelDetail);
        String actualTitle = titleOfertas.getText().toLowerCase();
        Assert.assertEquals("El titulo obtenido: " + actualTitle + ", no coincide con lo esperado", title.toLowerCase(), actualTitle);
    }

    public void subDetalles(){
        UtilWeb.waitForSeconds(5);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        esperaProgresiva(driver(), 5, 10, subDetalles);
        click(subDetalles);
    }

    public void lblAplicaUpFrom(){
        UtilWeb.waitForSeconds(1);
        esperaProgresiva(driver(), 4, 10, lblAplicaUpFront);
        Assert.assertTrue("el elemento no existe",lblAplicaUpFront.isDisplayed());
        UtilWeb.waitForSeconds(1);
        click(subDetalles,5);
    }

}
