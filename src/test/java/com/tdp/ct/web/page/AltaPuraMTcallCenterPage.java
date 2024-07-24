package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class AltaPuraMTcallCenterPage extends WebBase {

    @FindBy(xpath = "//*[contains(text(),'Continuar') or contains(text(),'Finalizar registro') ]/parent::button")
    protected WebElement buttonContinuar;

    @FindBy(xpath = "//div[contains(@class,'dialog-close')]/*")
    protected WebElement cierrePopUoError;


    public void completarIdCall(String idCall) {
        WebElement rootInputConfirmarCorreo = find().getElementByCss("tdp-st-input-text[formcontrolname=\"callID\"]");
        SearchContext context3 = sh().getContext(rootInputConfirmarCorreo);
        context3.findElement(By.cssSelector("div > div > div > input")).sendKeys(idCall);
        UtilWeb.waitForSeconds(1);
    }

    public void selectTipoDePago(String tipo) {
        String clickTipo = "div form div:nth-child(7) tdp-st-select;div:nth-child(1)";
        WebElement tipoElement = js().getWebElement(clickTipo);
        click(tipoElement);

        switch (tipo) {
            case "Boleta":
                String selectTipo = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(1)";
                WebElement selectElement = js().getWebElement(selectTipo);
                click(selectElement);
                break;
            case "Factura":
                String selectTipo2 = "div form div:nth-child(7) tdp-st-select;div div:nth-child(2) ul li:nth-child(2)";
                WebElement selectElement2 = js().getWebElement(selectTipo2);
                click(selectElement2);
                break;
        }

    }



    public void ingresarCorreoVerif(String verifCorreo) {
        String getCorreo = "div form div:nth-child(3) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement correoElement = js().getWebElement(getCorreo);
        click(correoElement);
        correoElement.sendKeys(Keys.CONTROL + "a");
        correoElement.sendKeys(Keys.DELETE);
        type(correoElement, verifCorreo);
        UtilWeb.waitForSeconds(5);
    }

    public void clicBotonContinuar() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            System.out.println("Entra al while");
            try {
                System.out.println("Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 10);
                buttonFound = true;
            } catch (Exception e) {
                System.out.println("Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                System.out.println(contador + " vez");
            }
        }
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Sale del While");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
        //Addons.esperaProgresivaReintentos(driver(), 5, 5, buttonContinuar);
        Addons.revisarModalError(driver());
    }

    public void clickCierrePopup() {
        UtilWeb.waitForSeconds(3);//inhabilitado
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='dialog-container']")).isEmpty();
        if (elementoExistente) {
            Addons.esperaProgresiva(driver(), 3, 5, cierrePopUoError);
            System.out.println("Se cierra Popup de error");
            try {
                click(cierrePopUoError);

            } catch (Exception e) {
                System.out.println("error al hacer click");
            }
        } else {
            System.out.println("no se encontró mensaje de error");
        }
    }


}
