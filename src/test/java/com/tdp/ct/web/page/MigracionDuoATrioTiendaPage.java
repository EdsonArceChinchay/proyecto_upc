package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.explicitWaitCss;

public class MigracionDuoATrioTiendaPage extends WebBase {

    @FindBy(css = "div:nth-child(2) > app-card-plan > div.card.ng-star-inserted > div > div.tdp-row.tdp-mt-3.tdp-mb-3 > div.tdp-col-2.mt-10.ng-star-inserted > img")
    protected WebElement btnOpcionPlanNuevo;

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
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "//div[3]/app-mt-card/div[1]/div/div[1]/div[3]/img")
    protected WebElement btnselecOferta;
    @FindBy(xpath = "//app-mt-change-plan-card/div/div[2]/div[1]/div[1]")
    protected WebElement planOferta;
    @FindBy(xpath = "//button[@class=\"btnSky btnsForms\"]")
    protected WebElement btnseleccionarOferta;
    // @FindBy(xpath = "//*[@class='btnCard' and contains(text(),'Ir a movistar total') or @class='btnCard' and contains(text(),'Ir a movistar')]")
    protected final String btnIrMovistarTotal =
            "//*[@class='btnCard' and contains(text(),'Ir a movistar total') or @class='btnCard' and contains(text(),'Ir a movistar')]";
    @FindBy(xpath = "(//div/button[@class='btnCard'])[2] | //button[@class='btnCard' and contains(text(),'Migrar a Fibra')]")
    protected WebElement BtnMigrarFibra;
    @FindBy(xpath = "//div/button[@class='btnStart']")
    protected WebElement BotonIniciarRegistro;
    @FindBy(css = "h1.title")
    protected WebElement titleOffer;
    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[1]")
    protected WebElement currentHomePlanPrice;
    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[2]")
    protected WebElement currentMonthlyPlanPrice;
    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[3]")
    protected WebElement newHomePlanPrice;
    @FindBy(xpath = "(//*[contains(@class,'price-upgrade')])[4]")
    protected WebElement newMonthlyPlanPrice;
    @FindBy(xpath = "(//*[contains(@class,'border_upgrade')]//*[contains(@class,'separator')])[1]")
    protected WebElement separator;

    public void seleccionPlanNuevoParaVerLasOfertas() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, btnOpcionPlanNuevo);
        btnOpcionPlanNuevo.click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoElTipoDePlanHogar(String plaHogar) {
        UtilWeb.waitForSeconds(8);
        clickElementInAList(listaPlanFija, plaHogar);
        UtilWeb.waitForSeconds(1);
    }


    public void clickButton(String nameButton) {
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
            logSevere("ERROR - NO HAY BOTON CONFIGURADO");
        }
        revisarModalError(driver());
    }

    public void seleccionarboton() {
        UtilWeb.waitForSeconds(4);
        for (WebElement element : listaBotones) {
            if (element.getText().contains("Cambiar plan hogar")) {
                click(element, 40);
            }
        }
    }

    public void seleccionoPlanMovistarTotal() {
        UtilWeb.waitForSeconds(3);
        waitUntilElementIsClickable(btnselecOferta, 50).click();
        UtilWeb.waitForSeconds(5);
    }

    public void seleccionoPlandeOferta() {
        click(planOferta);
    }

    public void clickBotonSeleccionarOferta() {
        UtilWeb.waitForSeconds(1);
        js().scrollElementTop(btnseleccionarOferta);
        click(btnseleccionarOferta);
    }

    public void clickBtnIrMovistarTotal() {
        //UtilWeb.waitForSeconds(15);//15
        revisarModalError(driver());
        revisarModalError(driver());
        WebElement botonIrMovistalTotal = explicitWaitCss(driver(), 15, btnIrMovistarTotal);
        // waitUntilElementIsVisible(btnIrMovistarTotal, 150);
        botonIrMovistalTotal.click();
    }

    public void SeleccionarBtnMigrarFibra() {
        esperaProgresiva(driver(), 3, 5, BtnMigrarFibra);
        js().scrollElementTop(BtnMigrarFibra);
        click(BtnMigrarFibra);
    }

    public void validateTagUVSC(String value) {
        js().scrollElementTop(titleOffer);
        revisarModalError(driver());
        WebElement tagUVSC = find().getElementByXPath("//*[contains(@class,'banner-upgrade') or contains(text(),'" + value + "')]");
        boolean hasTagUVSC = tagUVSC.isDisplayed();
        Assertions.assertTrue(hasTagUVSC, "The tag UVSC no exist");
    }

    public void validateCurrentAndNewPrice() {
        js().scrollElementTop(separator);
        boolean hasSameHomePlanPrice = compareTextWebElement(currentHomePlanPrice, newHomePlanPrice);
        Assertions.assertTrue(hasSameHomePlanPrice, "Not the same home plan price");
        boolean hasSameMonthlyPlanPrice = compareTextWebElement(currentMonthlyPlanPrice, newMonthlyPlanPrice);
        Assertions.assertTrue(hasSameMonthlyPlanPrice, "Not the same monthly plan price");
    }

    public boolean compareTextWebElement(WebElement element1, WebElement element2) {
        return element1.getText().trim().equalsIgnoreCase(element2.getText().trim());
    }

}
