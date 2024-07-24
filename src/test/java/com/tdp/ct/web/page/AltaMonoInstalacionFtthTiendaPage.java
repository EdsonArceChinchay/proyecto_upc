package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class AltaMonoInstalacionFtthTiendaPage extends WebBase {

    @FindBy(css = "h1.title")
    protected WebElement titleOfertas;

    @FindBy(css = ".tdp-col-md-6:nth-child(2) .tdp-col-2 .margin-icon.add_pointer")
    protected WebElement btnPlanNuevo;

    @FindBy(css = ".button-filter-section .button-filter")
    protected List<WebElement> btnPlanList;

    @FindBy(css = ".detail-content div.features")
    protected WebElement featureContent;

    @FindBy(xpath = "//*[contains(@class,'detalle')]")
    protected WebElement labelDetail;

    public void validarOfertasSugeridasView(String title) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, titleOfertas);
        js().scrollElementTop(labelDetail);
        String actualTitle = titleOfertas.getText().toLowerCase();
        Assert.assertEquals("El titulo obtenido: " + actualTitle + ", no coincide con lo esperado", title.toLowerCase(), actualTitle);
    }

    public void scrollToBtnPlanNuevo() {
        UtilWeb.waitForSeconds(3);
        js().scrollElementTop(titleOfertas);
    }

    public void clickBtnPlanNuevo() {
        esperaProgresiva(driver(), 3, 5, btnPlanNuevo);
        click(btnPlanNuevo);
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnTipoPlan(String tipoPlan) {
        for (WebElement element : btnPlanList) {
            String encontrado = element.getText().toLowerCase();
            if (encontrado.equals(tipoPlan.toLowerCase())) {
                element.click();
                break;
            }
        }
        UtilWeb.waitForSeconds(3);
    }

    public void esperarBtnLineaNueva() {
        UtilWeb.waitForSeconds(5);
        boolean existe = !find().getElementsByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)").isEmpty();
        if (existe) {
            js().scrollElementTop(find().getElementByCss(".tdp-col-md-6:nth-child(1) .line:nth-child(2)"));
        }
    }

    public void clickBtnLinea(String btnName) {
        String element = "//button[contains(text(),'" + btnName + "')]";
        WebElement btn = find().getElementByXPath(element);
        click(btn);
    }

    public void validarDetallePlan() {
        waitUntilElementIsVisible(featureContent, 20);
        js().scrollElementTop(find().getElementByCss("span.pst-return"));
        Assertions.assertFalse(featureContent.getText().isEmpty(), "No se encuentran caracteristicas en el contenedor");
        UtilWeb.waitForSeconds(1);
    }

}
