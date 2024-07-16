package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class MigracionDuoATrioTiendaPage extends WebBase {
    @FindBy(xpath = "//app-card-mt[1]")
    protected WebElement cartillaMovistarTotal;
    @FindBy(xpath = "//img[@src='assets/images/Cargando.gif']")
    protected WebElement btnCargango;
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

    @FindBy(xpath = "//*[@label='Confirmar dirección' or contains(text(),'Confirmar dirección')]")
    protected WebElement btnConfirmarDir;

    @FindBy(xpath = " //*[@label='Actualizar dirección' or contains(text(),'Actualizar dirección')]")
    protected WebElement btnActualizarDir;

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

    @FindBy(xpath = "//*[@type='button' and @class='close']")
    protected WebElement btnClosePopUp;

    @FindBy(xpath = "//div[text()='MÓDEM']/parent::div/../descendant-or-self::tdp-st-checkbox[1]")
    protected WebElement agregarModem;

    @FindBy(xpath = "/html/body/app-root/app-park/body/div/div[2]/app-banner-cu/div/div/div[1]/img[2]")
    protected WebElement cerrarCU;

    public void selecciono_la_cartilla_del_plan_Activo() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, cartillaHogar);
        revisarModalError(driver());
        js().scrollElementTop(cartillaHogar);
        revisarModalError(driver());
        cartillaHogar.click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionPlanNuevoParaVerLasOfertas() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnOpcionPlanNuevo);
        btnOpcionPlanNuevo.click();
        UtilWeb.waitForSeconds(1);
    }

    public void cerrarPopupCU() {
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
        revisarModalError(driver());
        UtilWeb.waitForSeconds(5);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void doyClickEnEnElBoton(String nameButton) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        String btnEsperado = nameButton.toUpperCase().trim();
        WebElement botonEsperado = null;
        switch (btnEsperado) {
            case "MANTENER PLAN":
                botonEsperado = btnMantenerPlan;
                break;

            case "ACTUALIZAR":
            case "ACTUALIZAR DIRECCION":
            case "ACTUALIZAR DIRECCIÓN":
                botonEsperado = btnActualizarDir;
                break;

            case "CONFIRMAR":
            case "CONFIRMAR DIRECCION":
            case "CONFIRMAR DIRECCIÓN":
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
            case "RENOVAR PLAN / EQUIPO":
                botonEsperado = btnRenovarPlan;
                break;
        }
        if (botonEsperado != null) {
            revisarModalError(driver());
            esperaProgresiva(driver(), 5, 5, botonEsperado);
            js().scrollElementTop(botonEsperado);
            botonEsperado.click();
        } else {
            System.out.println("ERROR - NO HAY BOTON CONFIGURADO");
        }
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

    public void agregoSVALinea(String svaLinea) {
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

    public void seleccionoCartillaMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 4, 5, cartillaMovistarTotal);
        js().scrollElementTop(cartillaMovistarTotal);
        revisarModalError(driver());
        Addons.esperaCargaMontoDeuda(driver(), 120);
        waitUntilElementIsClickable(cartillaMovistarTotal, 20);
        click(cartillaMovistarTotal);
    }
}
