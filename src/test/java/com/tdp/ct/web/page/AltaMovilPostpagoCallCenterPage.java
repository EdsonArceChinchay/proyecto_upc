package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class AltaMovilPostpagoCallCenterPage extends WebBase {

    @FindBy(xpath = "//app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement BtnOpciones;
    @FindBy(xpath = "//button[contains(text(),'Línea nueva') or contains(text(),'Línea Nueva')]")
    protected WebElement lblLineaNueva;
    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement lblSeleccionarOferta;
    @FindBy(xpath = "//div[@class='button-filter-section']//button")
    protected List<WebElement> listPlan;
    @FindBy(xpath = "//div[contains(@class, 'card-option-ofert-content')]")
    protected List<WebElement> listaOfertas;
    @FindBy(css= "body > app-root > app-delivery > div.info-user span")
    protected WebElement titleDelivery;
    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;


    public void BtonOpciones() {
        revisarModalError(driver());
        esperaProgresiva(driver(),3,5,BtnOpciones);
        revisarModalError(driver());
        js().scrollElementTop(BtnOpciones);
        System.out.println("BtonOpciones clic");
        BtnOpciones.click();
    }

    public void seleccionoElPlanMovil(String tipoPlan) {
        UtilWeb.waitForSeconds(3);
        System.out.println("cantidad: " + listPlan.size());
        for (WebElement elements : listPlan) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().equals(tipoPlan)){
                waitUntilElementIsClickable(elements,10);
                click(elements, 30);
            }
        }
    }


    public void seleccionoLaCartillaLineaNueva() {
        UtilWeb.waitForSeconds(5);
        click(lblLineaNueva, 10);
        UtilWeb.waitForSeconds(10);
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsClickable(lblSeleccionarOferta, 40);//10
        click(lblSeleccionarOferta, 10);
    }

    public void seleccionarPlan(String tipoPlan) {

        UtilWeb.waitForSeconds(4);
        String ofertaEsperada = tipoPlan.trim().toUpperCase();
        System.out.println("cantidad de la lista : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            if (elementoExistente) {
                System.out.println("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }

        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            System.out.println("Entro al for de las lista de ofertas");
            System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }

        if(!encontroElemento && !listaOfertas.isEmpty()){
            System.out.println("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
        UtilWeb.waitForSeconds(1);
    }

    @FindBy(xpath = "(//*[contains(@class,'add_Product') or contains(text(),'Añadir equipo') or  contains(text(),'Agregar Equipo')])[1]")
    protected WebElement LblEquipos;
    public void seleccionarEquipo() {
        UtilWeb.waitForSeconds(3);
        esperaProgresiva(driver(),3,5,LblEquipos);
        js().scrollElementTop(LblEquipos);
        click(LblEquipos, 5);
        UtilWeb.waitForSeconds(5);
    }

    public boolean meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        boolean existe = waitUntilElementIsVisible(titleDelivery, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de delivery de la linea nueva", existe);
        return existe;
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
                waitUntilElementIsClickable(elements,30).click();
            }
        }
        UtilWeb.waitForSeconds(1);
    }

}