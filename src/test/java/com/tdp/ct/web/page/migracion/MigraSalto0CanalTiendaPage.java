package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

public class MigraSalto0CanalTiendaPage extends WebBase {

    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement btnMigrafibra;

    @FindBy(xpath = "//span[contains(text(),'Agendamiento')]")
    protected WebElement labelAgendamiento;

    @FindBy(xpath = "//app-lista-contactos/div/div/div[1]/div/h2")
    protected WebElement datosAgendamiento;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement buttonConfirmar;

    @FindBy(css = "//tdp-st-input-text[@formcontrolname=\"contactNumber1\"]")
    protected WebElement ingresarContacto;

    public void seleccionoOpcionMigraFibra() {
        waitUntilElementIsVisible(btnMigrafibra,100);
        click(btnMigrafibra);
    }

    public boolean validoPantallaAgendamiento() {
        boolean existe = waitUntilElementIsVisible(labelAgendamiento, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Existe titulo >>> {0}", labelAgendamiento.getText());
        return existe;
    }

    public void ingresoDatosAgendamiento(String contacto) {
        WebElement ingresaNum = find().getElementByCss("//tdp-st-input-text[@formcontrolname=\"contactNumber1\"]");
        click(ingresaNum);
        type(ingresaNum, contacto);
        //js().scrollElementTop(datosAgendamiento);
        /*type(ingresarContacto, contacto);
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByXPath("(//div[@class='tdp-row']//tdp-st-input-text)[1]");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(contacto);
        UtilWeb.waitForSeconds(2);
         */
    }

    public void clicBotonConfirmarAgendamiento() {
        UtilWeb.waitForSeconds(4);
        waitUntilElementIsClickable(buttonConfirmar, 10);
        click(buttonConfirmar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a confirmar agendamiento");
    }
}
