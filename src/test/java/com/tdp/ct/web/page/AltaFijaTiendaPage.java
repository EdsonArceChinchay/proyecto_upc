package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static org.assertj.core.api.BDDAssertions.and;


public class AltaFijaTiendaPage extends WebBase {
    ArrayList<String> tabs;
    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;

    @FindBy(xpath = "//div[@class='tdp-col-md-2']")
    protected WebElement esperalistaPlanFija;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement buttonConfirmar;
    @FindBy(xpath = "(//button[contains(text(),'Confirmar')])[2]")
    protected WebElement buttonConfirmar2;
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

    @FindBy(xpath = "//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    @FindBy(xpath = "(//button[contains(text(),'Reintentar')])[1]")
    protected WebElement btnReintentarFinal;

    @FindBy(xpath = "(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button")
    protected WebElement btnRegistrarVenta;

    @FindBy(xpath = "//button/span[contains(text(), 'Validar identidad del Rep. Legal')]/..")
    protected WebElement btnValidaLegal;

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
    }

    public void listaOfertas(String planOfertas, ManageScenario scenario) {
        revisarModalError(driver());
        String ofertaEsperada = planOfertas.trim().toUpperCase();
        int countMax = 10;
        try {
            boolean isBtnRigth;
            isBtnRigth = btnRight.isDisplayed();
            int count = 0;
            while (isBtnRigth ) {
                esperaProgresiva(driver(), 4, 5, btnRight);
                waitUntilElementIsClickable(btnRight, 5);
                btnRight.click();
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button right");
                isBtnRigth = btnRight.isDisplayed();
                count++;
                if (count == countMax)
                {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        try {
            boolean isBtnLeft;
            isBtnLeft = btnLeft.isDisplayed();
            int count = 0;
            while (isBtnLeft ) {
                btnLeft.click();
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button left ");
                isBtnLeft = btnLeft.isDisplayed();
                count++;
                if (count == countMax)
                {
                    break;
                }

            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Cantidad de Ofertas : " + listaOfertas.size());

        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            js().scrollElementTop(listaOfertas.get(i));
            scenario.printFullView();
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
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
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No se encontro oferta en la Lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Se selecciono oferta: " + listaOfertas.get(cont).getText());

        }
    }

    public void seleccionarOferta() {
        revisarModalError(driver());
        for (int i = 0; i < listBtnSeleccionarOferta.size(); i++) {
            if (listBtnSeleccionarOferta.get(i).isEnabled()) {
                js().scrollElementTop(listBtnSeleccionarOferta.get(i));
                listBtnSeleccionarOferta.get(i).click();
            }
        }
        UtilWeb.waitForSeconds(3);
    }


    public void listaBotones() {
        waitUntilElementIsClickable(btnLineaNueva, 50);
        String nameButton = btnLineaNueva.getText();
        click(btnLineaNueva);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click en el boton: " + nameButton);
    }

    public void datosAgendamiento() {
        revisarModalError(driver());
//         Calendario
        boolean elementoExistenteDias;
        esperaProgresiva(driver(), 3, 5, buttonConfirmar);
        elementoExistenteDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']")).size() != 0;
        if (elementoExistenteDias) {
            System.out.println("elementoExistenteDias: true");
            List<WebElement> listaDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']"));
            click(listaDias.get(0));
            System.out.println("listaDias: " + listaDias.get(0).getText());
        }

        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            List<WebElement> listaHorario = driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
            click(listaHorario.get(0));
            System.out.println("paso aqui 2 " + listaHorario.get(0).getText());
        }

        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys("956425985");
        UtilWeb.waitForSeconds(2);

    }

    public boolean verficarPantallaAgendamiento() {
        revisarModalError(driver());
        boolean existe = false;
        try {
            existe = find().getElementByXPath("//span[contains(text(),'Agendamiento')]").isDisplayed();
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Comprobando elemento");
        }
        return existe;
    }

    public void botonConfirmarAgendamiento() {
        revisarModalError(driver());
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            click(buttonConfirmar);
            UtilWeb.waitForSeconds(1);
            click(buttonConfirmar2);
            System.out.println("paso aqui 2");
        } else {
            click(buttonConfirmar);
            System.out.println("paso aqui 3");
        }
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
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
        tabs = new ArrayList<String>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(0));
        UtilWeb.waitForSeconds(1);
    }

    public void cerrarPopUp() {
        UtilWeb.waitForSeconds(1);
        click(btnClose);
        UtilWeb.waitForSeconds(1);
    }

    public void registrarVenta() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 7, 8, btnRegistrarVenta);
        click(btnRegistrarVenta);
    }

    public void doyClickEnAñadirSVA() {
        UtilWeb.waitForSeconds(10);
        waitUntilElementIsClickable(btnSVA, 100);
        js().scrollElementTop(btnSVA);
        click(btnSVA);
    }

    public void doyClickEnAgregarBloque(String bloque) {
        UtilWeb.waitForSeconds(10);
        WebElement btnbloque = find().getElementByXPath("//*[@class='text' and contains(text(),'" + bloque + "')]//following::tdp-st-checkbox[1]");
        waitUntilElementIsClickable(btnbloque, 100);
        js().scrollElementTop(btnbloque);
        click(btnbloque);
    }

    public void doyClickEnGuardarCambios() {
        WebElement btnGuardar = find().getElementByXPath("//*[@type='button' and contains(text(),'Guardar')]");
        js().scrollElementTop(btnGuardar);
        btnGuardar.click();

    }

    public void ingresarDatosAgendamientoParaRUC() {
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//         Calendario
        boolean elementoExistenteDias;
        elementoExistenteDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']")).size() != 0;
        if (elementoExistenteDias) {
            System.out.println("paso aqui 1");
            List<WebElement> listaDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']"));
            click(listaDias.get(0));
            System.out.println("paso aqui 2 " + listaDias.get(0).getText());
        }

        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            List<WebElement> listaHorario = driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
            click(listaHorario.get(0));
            System.out.println("paso aqui 2 " + listaHorario.get(0).getText());
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        WebElement rootInput1 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(2) > tdp-st-input-text");
        WebElement rootInput2 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(3) > tdp-st-input-text");
        WebElement rootInput3 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(5) > tdp-st-input-text");

        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys("Edson");
        UtilWeb.waitForSeconds(2);

        SearchContext context1 = sh().getContext(rootInput1);
        context1.findElement(By.cssSelector("div > div > div > input")).sendKeys("Arce");
        UtilWeb.waitForSeconds(2);

        SearchContext context2 = sh().getContext(rootInput2);
        context2.findElement(By.cssSelector("div > div > div > input")).sendKeys("976709704");
        UtilWeb.waitForSeconds(2);

        SearchContext context3 = sh().getContext(rootInput3);
        context3.findElement(By.cssSelector("div > div > div > input")).sendKeys("906701238");
        UtilWeb.waitForSeconds(2);

    }

    public void clickValidarRepreLegal() {
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(btnValidaLegal);
        waitUntilElementIsClickable(btnValidaLegal, 30);
        click(btnValidaLegal);
        UtilWeb.waitForSeconds(4);
    }

    public void clickBotonRegistrarVenta() {
        revisarModalError(driver());
        System.out.println("Entra al primer try");
        try {
            boolean buttonFound = false;
            int contador = 0;
            int reintentoBucles = 15;
            while (!buttonFound && contador <= reintentoBucles) {
                System.out.println("Entra al while");
                System.out.println("Entra al segundo try");
                try {
                    JavascriptExecutor jse = (JavascriptExecutor) driver();
                    jse.executeScript("window.scrollBy(0,250)");
                    UtilWeb.waitForSeconds(1);
                    waitUntilElementIsVisible(btnRegistrarVenta, 2);
                    buttonFound = true;
                    System.out.println("Sale del segundo try");
                } catch (Exception e) {
                    System.out.println("Espera 20 seg");
                    UtilWeb.waitForSeconds(20);
                    revisarModalError(driver());
                    contador++;
                    System.out.println(contador + " vez");
                }
            }
            System.out.println("Sale del while");
            click(btnRegistrarVenta);
            System.out.println("Hace click en el boton Registrar Venta");
        } catch (Exception e) {
            System.out.println("Salió del primer try");
            System.out.println("Salta el registrar");
        }
    }
}
