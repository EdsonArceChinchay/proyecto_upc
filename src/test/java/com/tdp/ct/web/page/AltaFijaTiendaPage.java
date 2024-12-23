package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.compareWebElementTextAndString;
import static com.tdp.ct.web.utils.WebUtils.returnValueCompareWebElementTextAndString;

public class AltaFijaTiendaPage extends WebBase {
    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;
    @FindBy(xpath = "//div[@class='tdp-col-md-2']")
    protected WebElement esperalistaPlanFija;
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "(//button[@class='buttonG'])[1]")
    protected WebElement btnDescargar;
    @FindBy(xpath = "(//button[@class='_close'])")
    protected WebElement btnClose;
    @FindBy(xpath = "//div[@class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected List<WebElement> listBtnSeleccionarOferta;
    @FindBy(xpath = "//div[contains(text(),'Nombre:')]")
    protected WebElement nombresCompletosCliente;
    @FindBy(xpath = "(//button[contains(text(),'Línea nueva móvil') or @class='btnCard' and contains(text(),'Línea nueva') or @class='btnCard' and contains(text(),'Portabilidad móvil') or contains(text(),'Portabilidad móvil')  or @class='btnCard' and contains(text(),'Línea Nueva')  or @class='btnCard' and contains(text(),'Cambiar plan hogar')  or @class='btnCard' and contains(text(),'Cambiar Plan')])[1]")
    protected WebElement btnLineaNueva;
    @FindBy(xpath = "//*[@class='buttonG' and contains(text(),'SVA')]")
    protected WebElement btnSVA;
    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;
    @FindBy(xpath = "//img[@src='assets/images/left-arrow.png']")
    protected WebElement btnLeft;
    @FindBy(xpath = "(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button")
    protected WebElement btnRegistrarVenta;
    @FindBy(xpath = "//button/span[contains(text(), 'Validar identidad del Rep. Legal')]/..")
    protected WebElement btnValidaLegal;
    @FindBy(xpath = "//app-root/app-alta-fija-page/app-resumen-page/div/div[4]/div/div[1]/app-summary-detail/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/span[2]")
    protected WebElement velocidadBB;
    @FindBy(xpath = "//app-root/app-alta-fija-page/app-resumen-page/div/div[5]/div[1]/div/div[1]/div[3]")
    protected WebElement precDescBB;
    @FindBy(css = "div.tdp-row.textBlue")
    protected WebElement svaTV;
    @FindBy(xpath = "//app-root/app-alta-fija-page/app-resumen-page/div/div[5]/div[1]/div/div[1]/div[3]")
    protected WebElement precDescTV;
    ArrayList<String> tabs;

    public String nombresCompletosCliente() {
        esperaProgresiva(driver(), 5, 5, nombresCompletosCliente);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        return getText(nombresCompletosCliente);
    }

    public void listaPlanFija(String planFija) {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, esperalistaPlanFija);
        UtilWeb.waitForSeconds(5);
        clickElementInAList(listaPlanFija, planFija);
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
    }

    public void listaOfertas(String planOfertas, ManageScenario scenario) {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());

        int countMax = 6;
        try {
            boolean isBtnRigth;
            isBtnRigth = btnRight.isDisplayed();
            int count = 0;
            while (isBtnRigth) {
                esperaProgresiva(driver(), 4, 5, btnRight);
                waitUntilElementIsClickable(btnRight, 5);
                logInfo("Click button", btnRight.getText());
                btnRight.click();
                isBtnRigth = btnRight.isDisplayed();
                count++;
                if (count == countMax) {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        try {
            boolean isBtnLeft;
            isBtnLeft = btnLeft.isDisplayed();
            while (isBtnLeft) {
                btnLeft.click();
                logInfo("Click button left");
                isBtnLeft = btnLeft.isDisplayed();
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        logInfo("Cantidad de Ofertas : " + listaOfertas.size());

        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            js().scrollElementTop(listaOfertas.get(i));
            scenario.printFullView();
            boolean isEquals = returnValueCompareWebElementTextAndString(listaOfertas.get(i), planOfertas);
            if (isEquals) {
                encontroElemento = true;
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
        if (!encontroElemento && !listaOfertas.isEmpty()) {
            logInfo("No se encontro oferta en la Lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
            logInfo("Se selecciono oferta: " + listaOfertas.get(cont).getText());
        }
    }

    public void seleccionarOferta() {
        logInfo("Metodo Seleccionar Oferta");
        revisarModalError(driver());
        for (WebElement element : listBtnSeleccionarOferta) {
            if (element.isEnabled()) {
                js().scrollElementTop(element);
                element.click();
                logInfo("Click boton Seleccionar Oferta");
            }
        }
        UtilWeb.waitForSeconds(3);
    }


    public void listaBotones() {
        logInfo("Metodo Lista de Oferta");
        esperaProgresiva(driver(), 5, 5, btnLineaNueva);
        String nameButton = btnLineaNueva.getText();
        click(btnLineaNueva);
        logInfo("Dio click en el boton: " + nameButton);
    }

    public void descargarContrato() {
        /*modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        UtilWeb.waitForSeconds(10);
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement boton = find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[1]/tdp-st-button");
        waitUntilElementIsClickable(boton, 500).click();
        UtilWeb.waitForSeconds(10);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-success > app-modal-pdf > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(1);*/
    }

    public void descargarPdf() {
        revisarModalError(driver());
        click(btnDescargar);
    }

    public void cambiarPestanaPrincipal() {
        revisarModalError(driver());
        tabs = new ArrayList<>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(0));
        UtilWeb.waitForSeconds(1);
    }

    public void cerrarPopUp() {
        UtilWeb.waitForSeconds(1);
        click(btnClose);
        UtilWeb.waitForSeconds(1);
    }

    public void onAddSvaClick() {
        UtilWeb.waitForSeconds(10);
        waitUntilElementIsClickable(btnSVA, 100);
        js().scrollElementTop(btnSVA);
        click(btnSVA);
    }

    public void clickValidarRepreLegal() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnValidaLegal);
        waitUntilElementIsClickable(btnValidaLegal, 30);
        click(btnValidaLegal);
        UtilWeb.waitForSeconds(4);
    }

    public void registrarVenta() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(10);
        esperaProgresiva(driver(), 7, 8, btnRegistrarVenta);
        click(btnRegistrarVenta);
    }

    public void clickBotonRegistrarVenta() {
        revisarModalError(driver());
        logInfo("Entra al primer try");
        try {
            boolean buttonFound = false;
            int contador = 0;
            int reintentoBucles = 10;
            while (!buttonFound && contador <= reintentoBucles) {
                logInfo("Entra al while");
                logInfo("Entra al segundo try");
                try {
                    JavascriptExecutor jse = (JavascriptExecutor) driver();
                    jse.executeScript("window.scrollBy(0,250)");
                    UtilWeb.waitForSeconds(1);
                    waitUntilElementIsVisible(btnRegistrarVenta, 2);
                    buttonFound = true;
                    logInfo("Sale del segundo try");
                } catch (Exception e) {
                    logInfo("Espera 20 seg");
                    UtilWeb.waitForSeconds(20);
                    revisarModalError(driver());
                    contador++;
                    logInfo(contador + " vez");
                }
            }
            logInfo("Sale del while");
            click(btnRegistrarVenta);
            logInfo("Hace click en el boton Registrar Venta");
        } catch (Exception e) {
            logInfo("Salió del primer try");
            logInfo("Salta el registrar");
        }
    }

    public void validarVelocidadInternet(String mbpsBB) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(velocidadBB, mbpsBB);
    }

    public void validarPrecioDescuento(String precDesc) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(precDescBB, precDesc);
    }

    public void validarnombreSVAcontenido(String nomsvaTV) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(svaTV, nomsvaTV);
    }

    public void validarPrecioDescuentoTV(String pDescTV) {
        Addons.revisarModalError(driver());
        compareWebElementTextAndString(precDescTV, pDescTV);
    }

}
