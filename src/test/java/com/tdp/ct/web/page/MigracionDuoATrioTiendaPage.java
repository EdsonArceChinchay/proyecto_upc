package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class MigracionDuoATrioTiendaPage extends WebBase {

    //@FindBy(xpath = "/html/body/app-root/app-park/body/div/div[1]/div[4]/div[1]/app-card-line")
    @FindBy(xpath = "//app-card-line[1]")
    protected WebElement cartillaHogar;
    @FindBy(css = "div:nth-child(2) > app-card-plan > div.card.ng-star-inserted > div > div.tdp-row.tdp-mt-3.tdp-mb-3 > div.tdp-col-2.mt-10.ng-star-inserted > img")
    protected WebElement btnOpcionPlanNuevo;

    @FindBy(css = "body > div.tdp-container.pt-16 > div.tdp-row.add_aling_center > div.tdp-col-md-6.tdp-col-lg-4.ng-star-inserted > app-mt-card > div.card.ng-star-inserted > div > div.tdp-row.tdp-mt-3.tdp-mb-3.ng-star-inserted > div.tdp-col-2.ng-star-inserted > img")
    protected WebElement btnOpcionPlanNuevoMT;

    @FindBy(xpath = "//div[@class='tdp-col-md-2 ng-star-inserted']")
    protected List<WebElement> listPlanesNuevos;

    @FindBy(xpath = "//button[@class='btnSky btnsForms']")
    protected WebElement lblSeleccionarOferta;

    @FindBy(css = "div.footer_servicio > div > div > div:nth-child(2) > app-footer-item > div > div.tdp-container.background_container > div.tdp-row.buttonW.tdp-mt-1.ng-star-inserted > div > button")
    protected WebElement lblCartillaCambiar;

    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;

    @FindBy(xpath = "//*[@class='modal_footer']//tdp-st-button[@label='Confirmar dirección']")
    protected WebElement btnConfirmarDir;

    @FindBy(xpath = "//*[@class='modal_footer']//tdp-st-button[@label='Actualizar dirección']")
    protected WebElement btnActualizarDir;
    //*[@class='modal_footer']//tdp-st-button[@label='Actualizar dirección']
    @FindBy(xpath = "(//*[@type='submit' and contains(text(),'Buscar')])[1]")
    protected WebElement btnBuscar;

    @FindBy(xpath = "(//*[contains(text(),'Ingresar coordenadas')])[1]")
    protected WebElement btnIngCord;

    @FindBy(xpath = "(//*[contains(text(),'Entendido')])[1]")
    protected WebElement btnEntendido;

    @FindBy(xpath = "//*[contains(text(),'Mantener Plan') or @class='btnCard' and contains(text(),'Mantener Plan')]")
    protected WebElement btnMantenerPlan;

    @FindBy(xpath = "//*[contains(text(),'Cambiar Plan') or @class='btnCard' and contains(text(),'CAMBIAR PLAN')]")
    protected WebElement btnCambiarPlan;

    @FindBy(xpath = "//*[contains(text(),'Renovar plan') or contains(@class,'btn-renovate-plan') and contains(text(),'Renovar plan')]")
    protected WebElement btnRenovarPlan;

    @FindBy(xpath = "//div[@slot='modal_body']/div[2]/div/p[2]")
    protected WebElement txtDirC;

    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    @FindBy(xpath = "//*[@type='button' and @class='close']")
    protected WebElement btnClosePopUp;
    @FindBy(xpath = "//div[text()='MÓDEM']/parent::div/../descendant-or-self::tdp-st-checkbox[1]")
    protected WebElement agregarModem;

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[2]/app-banner-cu/div/div/div[1]/img[2]")
    protected WebElement cerrarCU;

    public void selecciono_la_cartilla_del_plan_Activo() {

        esperaProgresiva(driver(), 3,5,cartillaHogar);

        js().scrollElementTop(cartillaHogar);
        //UtilWeb.waitForSeconds(5);

        //String elXpath = "div:nth-child(1) > app-card-line";
        //Addons.reintentaModalError(driver(), 2, 5, null, this, elXpath);
        revisarModalError(driver());

        //waitUntilElementIsClickable(cartillaHogar, 40).click();
//        waitUntilElementIsVisible(cartillaHogar, 5);
//        click(cartillaHogar, 5);
        cartillaHogar.click();
        UtilWeb.waitForSeconds(1);

    }

    public void seleccionPlanNuevoParaVerLasOfertas() {
        revisarModalError(driver());
        //UtilWeb.waitForSeconds(4);
        esperaProgresiva(driver(), 3,5,btnOpcionPlanNuevo);
        //waitUntilElementIsClickable(btnOpcionPlanNuevo, 60).click();
        btnOpcionPlanNuevo.click();
        UtilWeb.waitForSeconds(1);
    }
    public void cerrarPopupCU(){
//        UtilWeb.waitForSeconds(1);
//        waitUntilElementIsClickable(cerrarCU, 10).click();
        UtilWeb.waitForSeconds(4);
        try {
            if (cerrarCU.isDisplayed()) {
                System.out.println("Cierre Nuevo Popup....");
                UtilWeb.waitForSeconds(4);
                click(cerrarCU);
            } else {
                UtilWeb.waitForSeconds(4);
                System.out.println("No existe Popup....");
            }
        } catch (Exception e) {
            System.out.println("No hay ningún popup.....");
        }

    }


    public void seleccionoElTipoDePlanHogar(String plaHogar) {
        UtilWeb.waitForSeconds(8);
        clickElementInAList(listaPlanFija, plaHogar);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(String planTrio) {
        UtilWeb.waitForSeconds(5);
        String elemento = "//div[contains(text(),'" + planTrio + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", planTrio);
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsVisible(lblSeleccionarOferta, 10);
        click(lblSeleccionarOferta, 10);


    }

    public void luegoDoyClickEnLaCartillaCambiarPlanHogar() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(lblCartillaCambiar);
        waitUntilElementIsVisible(lblCartillaCambiar, 10);
        click(lblCartillaCambiar, 18);//12
    }

    public void scrollUp() {
        //modalError(20,btnReintentar,"Click al elemento Reitentar");
        //modalError(20,btnReintentar,"Click al elemento Reitentar");
        //modalError(20,btnReintentar,"Click al elemento Reitentar");
        UtilWeb.waitForSeconds(5);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }
    @FindBy(xpath = "(//*[contains(text(),'Mostrar Ofertas') or contains(text(),'Mostrar ofertas')])[1]")
    protected WebElement btnMostrar;

    public void doyClickEnEnElBoton(String btn) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        String btnEsperado = btn.toUpperCase().trim();
        WebElement botonEsperado = null;
        switch (btnEsperado) {
            case "MANTENER PLAN":
                botonEsperado = btnMantenerPlan;
                break;
            case "ACTUALIZAR":
            case "ACTUALIZAR DIRECCION":
                botonEsperado = btnActualizarDir;
                break;
            case "CONFIRMAR":
            case "CONFIRMAR DIRECCION":
                botonEsperado = btnConfirmarDir;
                break;
            case "BUSCAR":
                botonEsperado = btnBuscar;
                break;
            case "INGRESAR COORDENADAS":
                botonEsperado = btnIngCord;
                break;
            case "ENTENDIDO":
                botonEsperado = btnEntendido;
                break;
            case "CAMBIAR PLAN":
                botonEsperado = btnCambiarPlan;
                break;
            case "RENOVAR PLAN":
                botonEsperado = btnRenovarPlan;
                break;
        }
        if(botonEsperado!=null){
            esperaProgresiva(driver(), 3, 5,botonEsperado);
            js().scrollElementTop(botonEsperado);
            botonEsperado.click();
        }else{
           System.out.println("ERROR - NO HAY BOTON CONFIGURADO");
        }

        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());

    }

    public void verificoLaDireccionActualDelServicio(String dir) {
        revisarModalError(driver());

        String direccionEsperada = dir.toUpperCase().trim();
        waitUntilElementIsVisible(txtDirC, 5);
        js().scrollElementTop(txtDirC);
        String direccionRecibida = txtDirC.getText().toUpperCase().trim();
        Assertions.assertTrue(direccionRecibida.contains(direccionEsperada), "La direccion recibida: " + direccionRecibida + " es distinta a la esperada: " + direccionEsperada);
    }


    public void clickBtnReintentar() {
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            btnReintentar.click();
            UtilWeb.waitForSeconds(1);
        }

    }

    public void agregoSVALinea(String svaLinea) {
        //js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        UtilWeb.waitForSeconds(5);
        WebElement listElementPLan = find().getElementByXPath("//div[contains(text(),'SVA LÍNEA')]/../descendant-or-self::tdp-st-select");
        js().scrollElementTop(listElementPLan);
        listElementPLan.click();
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(svaLinea)) {
                UtilWeb.waitForSeconds(2);
                click(elements, 3);
            }
        }
    }

    public void doyClickEnAgregarModem() {
        UtilWeb.waitForSeconds(3);
        agregarModem.click();
    }

    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        boolean modalExiste;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() !=0;
        modalExiste = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Entendido')]")).size() != 0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        }
        else {
            System.out.println("No se encontro el modal error");
        }
        if (modalExiste) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al boton entendido");
            btnEntendido.click();
            UtilWeb.waitForSeconds(2);
        }
    }

}
