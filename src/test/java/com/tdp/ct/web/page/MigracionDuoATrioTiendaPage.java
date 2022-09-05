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

    @FindBy(xpath = "//div[@slot='modal_body']/div[2]/div/p[2]")
    protected WebElement txtDirC;

    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    public void selecciono_la_cartilla_del_plan_Activo() {
        js().scrollElementTop(cartillaHogar);
        waitUntilElementIsClickable(cartillaHogar,20).click();
//        waitUntilElementIsVisible(cartillaHogar, 5);
//        click(cartillaHogar, 5);
        UtilWeb.waitForSeconds(10);

    }

    public void seleccionPlanNuevoParaVerLasOfertas() {

        UtilWeb.waitForSeconds(4);
        waitUntilElementIsClickable(btnOpcionPlanNuevo,60).click();
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
        click(lblCartillaCambiar, 10);
    }

    public void scrollUp() {
        UtilWeb.waitForSeconds(4);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void doyClickEnEnElBoton(String btn) {
        String btnEsperado=btn.toUpperCase().trim();
        switch (btnEsperado) {
            case "ACTUALIZAR":
            case "ACTUALIZAR DIRECCION":
                js().scrollElementTop(btnActualizarDir);
                waitUntilElementIsClickable(btnActualizarDir, 5).click();
                break;

            case "CONFIRMAR":
            case "CONFIRMAR DIRECCION":
                js().scrollElementTop(btnConfirmarDir);
                waitUntilElementIsClickable(btnConfirmarDir, 5).click();
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
}
