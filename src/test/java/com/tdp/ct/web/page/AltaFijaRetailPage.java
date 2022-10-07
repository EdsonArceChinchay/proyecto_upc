package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

public class AltaFijaRetailPage extends WebBase {

    @FindBy(xpath = "//div[contains(@class,'button-filter-section')]")
    protected WebElement listTipoPlan;

    @FindBy(xpath = "//div[contains(@class,'offert-card-body')]")
    protected List<WebElement> listNombPlan;

    @FindBy(xpath = "//button[@class='btnSky btnsForms']")
    protected WebElement selecOferta;

    @FindBy(xpath = "//span[contains(text(), 'HOGAR NUEVO')]/../following-sibling::div/div/button")
    protected WebElement lineaNueva;

    @FindBy(xpath = "//*[@label='Iniciar Registro' or  @type='button' and @class='btnStart']")
    protected WebElement iniciarRegistro;

    @FindBy(css = ".services-section:nth-child(1) .section-container .row-content:nth-child(1) .actions-content .tdp-st-icon-button:nth-child(1)")
    protected WebElement iconPlus;

    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnCerrar;

    public void irSeleccionarTipoPlan(String tipoPlan) {
        UtilWeb.waitForSeconds(1);
        List<WebElement> lista = listTipoPlan.findElements(By.cssSelector("button"));
        for (WebElement element : lista) {
            if (element.getText().contains(tipoPlan)) {
                UtilWeb.waitForSeconds(1);
                click(element, 5);
            }
        }
    }

    public void irSeleccionarPlan(String nombrePlan) {
        /*UtilWeb.waitForSeconds(3);
        for (WebElement element : listNombPlan){
            if (element.getText().contains(nombrePlan)){
                //click(element);
                System.out.println("El plan es :" + element);

            }
        }
        UtilWeb.waitForSeconds(2);
        clickElementInAList(listNombPlan, nombrePlan);*/

        UtilWeb.waitForSeconds(3);
        WebElement nPlan = find().getElementByXPath("//div[contains(text(), '" + nombrePlan + "')]/../..");
        click(nPlan, 2);
        UtilWeb.waitForSeconds(2);
    }

    public void darClickOferta() {
        js().scrollElementTop(selecOferta);
        click(selecOferta);
    }

    public void irLineaNueva() {
        UtilWeb.waitForSeconds(1);
        click(lineaNueva, 2);
    }

    public void irIniciarRegistro() {
        UtilWeb.waitForSeconds(3);
        js().scrollElementTop(iniciarRegistro);
        click(iniciarRegistro, 2);
        clickBtnCerrarModalError(iniciarRegistro);
    }

    public void clickBtnCerrarModalError(WebElement metodoRepedito) {
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")).size() != 0;
        if (elementoExistente) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al Cerrar");
            click(btnCerrar);
            UtilWeb.waitForSeconds(2);
            click(metodoRepedito);
        }
    }
}
