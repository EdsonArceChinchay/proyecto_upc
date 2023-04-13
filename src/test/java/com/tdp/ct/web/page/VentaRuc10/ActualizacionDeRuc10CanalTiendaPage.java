package com.tdp.ct.web.page.VentaRuc10;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActualizacionDeRuc10CanalTiendaPage extends WebBase {

    @FindBy(xpath = "//div[@class=\"detailHogar\"]")
    protected WebElement btnVerDetalle;
    @FindBy(xpath = "//div[@class=\"update_ruc\"]")
    protected WebElement btnActualizarRuc;
    @FindBy(xpath = "//button[@class=\"update_button\"]")
    protected WebElement btnActualizar;

    @FindBy(xpath = "//label[contains(text(),\" El RUC se ha actualizado de manera correcta. \")]")
    protected WebElement mensaje;
    @FindBy(xpath = "(//button[contains(text(),\"Entendido\")])[2]")
    protected WebElement Entendido;
    public void seleccionoBotonVerDetalle() {
        //String btnVerOfertas = ".btn-detail tdp-st-button;button";
       // WebElement element = js().getWebElement(btnVerOfertas);
        //element.click();
        js().scrollElementTop(btnVerDetalle);
        click(btnVerDetalle);
    }

    public void clickBotonActualizarRuc() {
        click(btnActualizarRuc);
        UtilWeb.waitForSeconds(3);
    }
    public void ingresoRuc(String ruc) {
        WebElement Input= find().getElementByCss("app-update-ruc > form > div > tdp-st-input-text");
        click(Input);
        type(Input, ruc);
    }
    public void clickBotonActualizar() {
        click(btnActualizar);
    }

    public void validoMesajeActualizacionCorrecta() {
        Assert.assertTrue("ruc incorrecto intentelo mas tarde",mensaje.isDisplayed());
    }

    public void clickBotonEntendido() {
        click(Entendido);
        UtilWeb.waitForSeconds(5);
    }
}
