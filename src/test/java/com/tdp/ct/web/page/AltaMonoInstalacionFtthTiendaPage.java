package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AltaMonoInstalacionFtthTiendaPage extends WebBase {

    @FindBy(css = "h1.title")
    protected WebElement titleOfertas;

    @FindBy(css = ".tdp-col-md-6:nth-child(2) .tdp-col-2 .margin-icon.add_pointer")
    protected WebElement btnPlanNuevo;

    @FindBy(css = ".button-filter-section .button-filter")
    protected List<WebElement> btnPlanList;

    @FindBy(css = ".detail-content div.features")
    protected WebElement featureContent;

    @FindBy(xpath = "//button[text()='Crear cliente']")
    protected WebElement buttonCrearCliente;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnConsultarCobertura;

    public void scrollToBtnCrearCliente(){
        js().scrollElementTop(find().getElementByCss("div.consulta"));
    }

    public void crearCliente() {
        click(buttonCrearCliente);
        UtilWeb.waitForSeconds(2);
    }

    public void scrollDirecCompleta(){
        js().scrollElementTop(find().getElementByCss("div.info-user"));
        UtilWeb.waitForSeconds(3);
    }

    public void clickBtnConsultarCobertura(){
        click(btnConsultarCobertura);
    }

    public void validarOfertasSugeridasView(String title){
        waitUntilElementIsVisible(titleOfertas, 300);
        UtilWeb.waitForSeconds(4);
        js().scrollElementTop(find().getElementByXPath("//nav"));
        String actualTitle = titleOfertas.getText().toLowerCase();
        Assert.assertEquals("El titulo obtenido: "+ actualTitle +", no coincide con lo esperado", title.toLowerCase(), actualTitle);
    }

    public void scrollToBtnPlanNuevo(){
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(titleOfertas);
    }

    public void clickBtnPlanNuevo(){
        waitUntilElementIsVisible(btnPlanNuevo,100);
        click(btnPlanNuevo);
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnTipoPlan(String tipoPlan) {
        for (int i = 0; i < btnPlanList.size(); i++) {
            String encontrado = btnPlanList.get(i).getText().toLowerCase();
            if (encontrado.equals(tipoPlan.toLowerCase())) {
                btnPlanList.get(i).click();
                break;
            }
        }
        UtilWeb.waitForSeconds(3);
    }

    public void esperarBtnLineaNueva(){
        UtilWeb.waitForSeconds(5);
        boolean existe = find().getElementsByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)").size() != 0;
        if (existe) {
            js().scrollElementTop(find().getElementByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)"));
        }
    }

    public void clickBtnLinea(String btnName) {
        String element = "//button[contains(text(),'" + btnName + "')]";
        WebElement btn = find().getElementByXPath(element);
        click(btn);
    }

    public void validarDetallePlan(){
        waitUntilElementIsVisible(featureContent, 20);
        js().scrollElementTop(find().getElementByCss("span.pst-return"));
        Assertions.assertFalse(featureContent.getText().isEmpty(), "No se encuentran caracteristicas en el contenedor");
        UtilWeb.waitForSeconds(1);
    }

    public void scrollToViewAgendamiento(){
        js().scrollElementTop(find().getElementByCss("div.return"));
    }
}
