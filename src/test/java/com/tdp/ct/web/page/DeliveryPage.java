package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class DeliveryPage extends WebBase {
    @FindBy(xpath = "//*[@formcontrolname='deliveryType']")
    protected WebElement deliveryType;
    @FindBy(xpath = "//div[@class='contHours']/div/span")
    protected List<WebElement> btnHorario;
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Confirmar ubicación') or contains(@class,'button') and contains(text(),'Confirmar ubicación')]")
    protected WebElement btnConfirmLocation;
    @FindBy(xpath = "(//button[@class='button_step'])")
    protected WebElement btnConfirmDelivery;

    public void clickButtonConfirmLocation() {
        esperaProgresiva(driver(), 5, 5, btnConfirmLocation);
        btnConfirmLocation.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Confirmar Ubicacion");
    }

    public void tipoEntrega(String tipEntrega) {
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 4, 5, "loadingCard");
        esperaProgresiva(driver(), 4, 6, deliveryType);
        scrollDown();
        click(deliveryType);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan = sh().getContext(deliveryType);

        String[][] deliveryOptions = {{"Express", "Delivery Express"}, {"R24h", "Delivery Regular 24 horas"}, {"R48h", "Delivery Regular 48 horas"}, {"R72h", "Delivery Regular 72 horas"}};
        String sCodigo = buscarValorOpcion(tipEntrega, deliveryOptions);
        seleccionarValueComboShadow(driver(), "deliveryType", sCodigo);

    }

    public void btnHorario(String horario) {
        clickElementInAList(btnHorario, horario);
        UtilWeb.waitForSeconds(5);
    }

    public void selectTipoHorario(String horario) {
        WebElement elegirHorario1 = find().getElementByXPath("//span[text()='" + horario + "']/..");
        click(elegirHorario1);
    }

    public void typeTelephone(String number) {
        WebElement direccionElement = find().getElementByXPath("//*[@formcontrolname='contactNumber']");
        js().scrollElementTop(direccionElement);
        click(direccionElement, 5);
        type(direccionElement, number);
    }

    public void typeDeliveryInstructions(String instruction) {
        WebElement txtInstr = find().getElementByXPath("//*[@formcontrolname='instruction']");
        esperaProgresiva(driver(), 5, 5, txtInstr);
        click(txtInstr);
        type(txtInstr, instruction);
    }

    public void clickButtonConfirmDevlivery() {
        esperaProgresiva(driver(), 3, 5, btnConfirmDelivery);
        click(btnConfirmDelivery, 5);
    }

    public void scrollDown() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }

}
