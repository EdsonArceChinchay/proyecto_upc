package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;


public class AltaMovilPostpagoCallCenterPage extends WebBase {


    @FindBy(xpath = "//app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement BtnOpciones;

    @FindBy(xpath = "// div[@class='add_Product']")
    protected WebElement LblEquipos;

    @FindBy(xpath = "//div[@class='cont-button']")
    protected WebElement btnBuscar;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected WebElement lblLineaNueva;


    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement lblSeleccionarOferta;

    @FindBy(xpath = "//tdp-st-button[@class='tdp-st-button-l hydrated']")
    protected WebElement btnSeleccionar;

    @FindBy(xpath = "//div[@class='button-filter-section']//button")
    protected List<WebElement> listPlan;

    @FindBy(css= "tdp-st-input-text")
    protected WebElement inputText;

    @FindBy(xpath = "//tdp-st-button[@type=\"button\"]")
    protected WebElement btnIniciar;

    @FindBy(css= "body > app-root > app-delivery > div.info-user span")
    protected WebElement titleDelivery;


    public void BtonOpciones() {
        waitUntilElementIsVisible(BtnOpciones, 5);
        System.out.println("Aqui");
        click(BtnOpciones, 30);
        UtilWeb.waitForSeconds(10);
    }

    public void seleccionoElPlanMovil(String tipoPlan) {
        System.out.println("cantidad: " + listPlan.size());
        for (WebElement elements : listPlan) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().equals(tipoPlan))
                click(elements, 30);
        }
    }

    public void seleccionarEquipo() {
        js().scrollElementTop(LblEquipos);
        waitUntilElementIsVisible(LblEquipos, 10);
        click(LblEquipos, 30);
        UtilWeb.waitForSeconds(10);
    }

    public void seleccionarTiempo(String tiempoP) {
                WebElement listElementPLan=find().getElementByCss(".comboPermanecia tdp-st-select");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tiempoP)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
    }



    public void BuscarEquipo(String buscarE) {

        System.out.println("producto: "+buscarE);
        waitUntilElementIsVisible(inputText, 5);
        click(inputText,5);
        type(inputText, buscarE);
//        click(btnBuscar, 10);
    }

    public void seleccionoLaCartillaLineaNueva() {
        waitUntilElementIsVisible(lblLineaNueva, 5);
        click(lblLineaNueva, 10);
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsVisible(lblSeleccionarOferta, 5);
        click(lblSeleccionarOferta, 10);
    }


    //RV Plan Ilimitado Mi Movistar S/149.9
    public void seleccionarPlan(String tipoPlan) {
        UtilWeb.waitForSeconds(5);
        String elemento = "//div[contains(text(),'" + tipoPlan + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", tipoPlan);
    }

    public void doyClickEnElBotonSeleccionar() {
        js().scrollElementTop(btnSeleccionar);
        waitUntilElementIsVisible(btnSeleccionar, 5);
        click(btnSeleccionar, 10);

    }

    public void doyClickEnIniciarRegistro() {
        js().scrollElementTop(btnIniciar);
        waitUntilElementIsVisible(btnIniciar, 5);
        click(btnIniciar, 10);
    }

    public boolean meMuestraLaPantallaDeDeliveryDeLineaNueva() {

        boolean existe = waitUntilElementIsVisible(titleDelivery, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de delivery de la linea nueva", existe);
        return existe;
    }
}




