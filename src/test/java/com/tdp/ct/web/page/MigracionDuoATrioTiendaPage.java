package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
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

public class MigracionDuoATrioTiendaPage extends WebBase {

    @FindBy(css = "div:nth-child(1) > app-card-line")
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

    @FindBy(xpath = "(//*[@type='submit' and contains(text(),'Buscar')])[1]")
    protected WebElement btnBuscar;

    @FindBy(xpath = "(//*[contains(text(),'Ingresar coordenadas')])[1]")
    protected WebElement btnIngCord;

    @FindBy(xpath = "(//*[contains(text(),'Entendido')])[1]")
    protected WebElement btnEntendido;


    @FindBy(xpath = "//app-footer-item//button[@class='btnCard' and contains(text(),'Cambiar Plan')]")
    protected WebElement btnCambiarPlan;


    @FindBy(xpath = "//div[@slot='modal_body']/div[2]/div/p[2]")
    protected WebElement txtDirC;

    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    public void selecciono_la_cartilla_del_plan_Activo() {
        js().scrollElementTop(cartillaHogar);
        UtilWeb.waitForSeconds(15);
        waitUntilElementIsClickable(cartillaHogar, 40).click();
//        waitUntilElementIsVisible(cartillaHogar, 5);
//        click(cartillaHogar, 5);
        UtilWeb.waitForSeconds(10);

    }

    public void seleccionPlanNuevoParaVerLasOfertas() {

        UtilWeb.waitForSeconds(4);
        waitUntilElementIsClickable(btnOpcionPlanNuevo, 60).click();
        UtilWeb.waitForSeconds(4);
    }


    public void seleccionoElTipoDePlanHogar(String plaHogar) {
        UtilWeb.waitForSeconds(4);
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
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void doyClickEnEnElBoton(String btn) {
        String btnEsperado = btn.toUpperCase().trim();
        switch (btnEsperado) {
            case "ACTUALIZAR":
            case "ACTUALIZAR DIRECCION":
                js().scrollElementTop(btnActualizarDir);
                waitUntilElementIsClickable(btnActualizarDir, 50).click();
                UtilWeb.waitForSeconds(1);
                break;

            case "CONFIRMAR":
            case "CONFIRMAR DIRECCION":
                js().scrollElementTop(btnConfirmarDir);
                waitUntilElementIsClickable(btnConfirmarDir, 50).click();
                UtilWeb.waitForSeconds(30);//1
                break;
            case "BUSCAR":
                js().scrollElementTop(btnBuscar);
                waitUntilElementIsClickable(btnBuscar, 50).click();
                UtilWeb.waitForSeconds(1);
                break;
            case "INGRESAR COORDENADAS":
                js().scrollElementTop(btnIngCord);
                waitUntilElementIsClickable(btnIngCord, 50).click();
                UtilWeb.waitForSeconds(1);
                break;
            case "ENTENDIDO":
                js().scrollElementTop(btnEntendido);
                waitUntilElementIsClickable(btnEntendido, 50).click();
                UtilWeb.waitForSeconds(1);
                break;

            case "CAMBIAR PLAN":
                UtilWeb.waitForSeconds(5);
//                waitUntilElementIsVisible(btnCambiarPlan, 50);
                js().scrollElementTop(btnCambiarPlan);
                click(btnCambiarPlan,10);
                UtilWeb.waitForSeconds(1);
                break;
        }

    }

    public void verificoLaDireccionActualDelServicio(String dir) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
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
            UtilWeb.waitForSeconds(2);
        }

    }

    public void agregoSVALinea(String svaLinea) {
        //js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss(".services-section:nth-child(2) .section-content:nth-child(4) .options-content .flex_100");
        click(listElementPLan);
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
}
