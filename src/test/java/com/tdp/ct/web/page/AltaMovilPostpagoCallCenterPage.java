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

    @FindBy(css= "//tdp-st-input-text[@iconright=\"search\"]")
    protected WebElement inputText;

    @FindBy(xpath = "//tdp-st-button[@type=\"button\"]")
    protected WebElement btnIniciar;

    @FindBy(css= "body > app-root > app-delivery > div.info-user span")
    protected WebElement titleDelivery;

    @FindBy(xpath = "//div[@class='option-boxes']//div")
    protected List<WebElement> listPago;


    @FindBy(css = "div.cont-autocomplete")
    protected WebElement lblItem;

    @FindBy(xpath= "//*[@id=\"modal3\"]/div[2]/form/div/div[5]/button")
    protected WebElement btnConfirmar;


    public void BtonOpciones() {
        js().scrollElementTop(BtnOpciones);
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
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan=find().getElementByCss(".comboPermanecia tdp-st-select");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tiempoP)){
                UtilWeb.waitForSeconds(2);
                click(elements,3);
            }
        }
    }



    public void BuscarEquipo(String buscarE) {
        WebElement Input= find().getElementByXPath("//tdp-st-input-text[@iconright='search']");
        click(Input);
        type(Input, buscarE);
        UtilWeb.waitForSeconds(1);
        click(lblItem);
    }

    public void seleccionoLaCartillaLineaNueva() {
        waitUntilElementIsVisible(lblLineaNueva, 10);
        click(lblLineaNueva, 10);
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsVisible(lblSeleccionarOferta, 10);
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
        waitUntilElementIsVisible(btnIniciar, 10);
        click(btnIniciar, 10);
    }

    public boolean meMuestraLaPantallaDeDeliveryDeLineaNueva() {

        boolean existe = waitUntilElementIsVisible(titleDelivery, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de delivery de la linea nueva", existe);
        return existe;
    }

    public void ingresoElTipoDePago(String pago) {
        System.out.println("cantidad: " + listPago.size());
        for (WebElement elements : listPago) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().equals(pago))
                click(elements, 3);
                break;
        }
    }


    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[1]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tipo)){
                UtilWeb.waitForSeconds(1);
                click(elements,30);
            }
        }
        UtilWeb.waitForSeconds(1);

    }

    public void seleccionamosElHorarioDeEntrega(String horario) {
//        WebElement listElementHorario=find().getElementByCss("tdp-st-card:nth-child(3) > div > div._body > form > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1)");
//        click(listElementHorario);
//        UtilWeb.waitForSeconds(2);
//        SearchContext contexPlan=sh().getContext(listElementHorario);
//        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
//        for(WebElement elements:lista){
//            System.out.println(elements.getText());
//            if(elements.getText().equals(horario)){
//                UtilWeb.waitForSeconds(2);
//                click(elements,30);
//            }
//        }

    }

    public void ingresarFechaNac(String fechaNac) {
        WebElement rootElement = find().getElementByXPath("//tdp-st-input-text[@formcontrolname='fechaNacimiento']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(fechaNac);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoNacionalidad(String nacionalidad) {
        WebElement listNacionalidad = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(listNacionalidad);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listNacionalidad);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(nacionalidad)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
    }

    public void seleccionarEstadoCivil(String estadoCivil) {
        WebElement generoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']");
        click(generoList);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(generoList);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(estadoCivil)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
}}




