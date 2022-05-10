package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AltaFijaMovilRegistroPage extends WebBase {

    @FindBy(xpath = "//span[contains(text(),'Lugar de')]")
    protected WebElement titleLugarInstalacion;

    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement titleOfertasSugeridas;
    @FindBy(xpath = "//div[@class='tdp-col-sm-4 stl_plan_actual']/../following-sibling::*//img[@class='margin-icon add_pointer']")
    protected List<WebElement> listaOfertasSugeridas;

    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;

    @FindBy(xpath = "//span[@class='text-capitalize']")
    protected WebElement titlePlan;

    @FindBy(xpath = "//button[@class='btnStart']")
    protected WebElement buttonIniciarRegistro;

    @FindBy(xpath = "//span[contains(text(),'Agendamiento')]")
    protected WebElement labelAgendamiento;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement buttonConfirmar;

    @FindBy(xpath = "//span[contains(text(),'Validar identidad del titular')]/..")
    protected WebElement buttonValidarIdentidad;

    @FindBy(xpath = "(//button[contains(text(),'Discapacitado o huella desgastada')])[1]")
    protected WebElement buttonDiscapacitado;
    @FindBy(xpath = "(//button[contains(text(),'Validaci')])[1]")
    protected WebElement buttonValBiometrica;

    @FindBy(xpath = "//*[contains(text(),'Tipo de Documento')]/../../../../..")
    protected WebElement selectTipoDoc;
    @FindBy(xpath = "//mat-option/span")
    protected List<WebElement> listDocumentos;

    @FindBy(xpath = "//h4[contains(text(),'Validar identidad del titular')]")
    protected WebElement lblPreguntas;

    @FindBy(xpath = "//span[contains(text(),'Continuar')]/..")
    protected WebElement buttonContinuar;

    @FindBy(xpath = "(//div/div/tdp-st-button)[3]")
    protected WebElement rootModalButtonSiAcepto;

    @FindBy(xpath = "//span[contains(text(),'ha sido exitoso')]")
    protected WebElement msjExitoso;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Identidad Validada')]")
    protected WebElement buttonIdentidadValidada;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Validar contrato')]/..")
    protected WebElement buttonValidarContrato;


    public boolean validarPantallaIngresarDireccion() {
        boolean existe = waitUntilElementIsVisible(titleLugarInstalacion, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Lugar de instalacion >>> {0}", existe);
        return existe;
    }

    public boolean validarQueExistanOfertasSugeridas() {
        boolean existe = waitUntilElementIsVisible(listaOfertasSugeridas.get(0), 60).isDisplayed();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de ofertas >>> {0}", existe);
        return existe;
    }

    public void seleccionarOferta(String oferta) {
        scrollByJavaScript();
        String elemento = "(//span[contains(text(),'" + oferta + "')]/../../following-sibling::*//img)[1]";
        WebElement elementOferta = find().getElementByXPath(elemento);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando la oferta >>> {0}", oferta);
        elementOferta.click();
    }

    public void seleccionarPlan(String plan) {
        UtilWeb.waitForSeconds(3);
        String elemento = "//div[contains(text(),'" + plan + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", plan);
        js().scrollElementTop(buttonSeleccionarOferta);
    }

    public void clicSeleccionarOferta() {
        buttonSeleccionarOferta.click();
        UtilWeb.waitForSeconds(1);
    }


    public void clicIrAMovistarTotal() {
        waitUntilElementIsVisible(botoneraIrA.get(1), 5).click();
        UtilWeb.waitForSeconds(1);
    }

    public void validarDetalleSeleccion() {
        waitUntilElementIsVisible(titlePlan, 20);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mostrando pantalla del plan seleccionado");
        UtilWeb.waitForSeconds(2);
    }
    public void moverToElementIniciarRegistro() {
        js().scrollElementTop(buttonIniciarRegistro);
        UtilWeb.waitForSeconds(1);
    }
    public void clicIniciarRegistro() {
        waitUntilElementIsVisible(buttonIniciarRegistro, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a iniciar registro");
       // UtilWeb.waitForSeconds(2);
    }

    public boolean validarPantallaAgendamiento() {
        boolean existe = waitUntilElementIsVisible(labelAgendamiento, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Existe titulo >>> {0}", labelAgendamiento.getText());
        return existe;
    }

    public void ingresarContacto(String contacto) {
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByXPath("(//div[@class='tdp-row']//tdp-st-input-text)[1]");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(contacto);
        UtilWeb.waitForSeconds(2);
    }


    public void clicConfirmarAgendamiento() {
        waitUntilElementIsVisible(buttonConfirmar, 10).click();
    }

    public boolean validarDetalleInstalacion() {

        boolean existe;
        try {
            WebElement element = find().getElementByXPath("//app-modal-detalle/tdp-st-modal//div/h1");
            waitUntilElementIsVisible(element, 5);
            element.isDisplayed();
            existe = true;
        } catch (NoSuchElementException ex) {
            existe = false;
            System.out.println(ex.getMessage());
        }
        UtilWeb.waitForSeconds(2);
        return existe;
    }

    public void clicConfirmarInstalacion() {
        WebElement element = find().getElementByXPath("//app-modal-detalle/tdp-st-modal//div/button");
        element.click();
     //   UtilWeb.waitForSeconds(2);
    }

    public void completarCorreo(String correo) {
        UtilWeb.waitForSeconds(2);
        scrollByJavaScriptToPrincipio();
        UtilWeb.waitForSeconds(3);
        WebElement rootInputCorreo = find().getElementByXPath("(//div[contains(@class,'tdp-row')]//tdp-st-input-text)[1]");
        SearchContext context1 = sh().getContext(rootInputCorreo);
        context1.findElement(By.cssSelector("div > div > div > input")).sendKeys(correo);

        WebElement rootInputConfirmarCorreo = find().getElementByXPath("(//div[contains(@class,'tdp-row')]//tdp-st-input-text)[2]");
        SearchContext context2 = sh().getContext(rootInputConfirmarCorreo);
        context2.findElement(By.cssSelector("div > div > div > input")).sendKeys(correo);

        UtilWeb.waitForSeconds(1);
    }

    public void clicValidarIdentidadTitular() {
        js().scrollElementTop(buttonValidarIdentidad);
        waitUntilElementIsVisible(buttonValidarIdentidad, 10).click();
        UtilWeb.waitForSeconds(2);
    }

    public void seleccionoTipoValidacion(String tipoValidacion) {
        UtilWeb.waitForSeconds(1);
        if (tipoValidacion.equalsIgnoreCase("discapacitado")) {
            waitUntilElementIsVisible(buttonDiscapacitado, 5).click();

        } else {
            waitUntilElementIsVisible(buttonValBiometrica, 5).click();
        }
        UtilWeb.waitForSeconds(1);
    }

    public void ingresarDatosValidacionReniec(DataTable datos) {
        String nomMadre = UtilWeb.getValueFromDataTable(datos, "nombreMadre");
        String nomPadre = UtilWeb.getValueFromDataTable(datos, "nombrePadre");
        String distritoNacimiento = UtilWeb.getValueFromDataTable(datos, "distritoNac");
        validacionesCliente(nomMadre, nomPadre, distritoNacimiento);
    }

    public void clicSiguiente() {
        WebElement rootInputCorreo = find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.waitForSeconds(3);
    }

    public void clicEnConfirmar() {
        WebElement rootInputCorreo = find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void verificarIdentidadValidada() {
        UtilWeb.waitForSeconds(3);
        String loadingInserted="//div[@class='loadingCard ng-star-inserted']";

        if(esperarLoadingIsNotVisible(loadingInserted,30)){
            waitUntilElementIsVisible(buttonIdentidadValidada,20).isDisplayed();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Identidad validada");
        }
    }
    public void clicValidarContrato() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonValidarContrato,10).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "clic validar contrato");
    }
    public void clicBotonContinuar() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonContinuar, 10).click();
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
    }

    public void visualizarContratoEnPantalla() {

        WebElement element= sh().getWebElement(rootModalButtonSiAcepto,"button");
        waitUntilElementIsVisible(element, 10);
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mostrando contrato en pantalla");
    }

    public void clicSiAcepto() {
        WebElement element= sh().getWebElement(rootModalButtonSiAcepto,"button");
        waitUntilElementIsVisible(element, 10).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dando click en si acepto");

    }

    public boolean validarMensajeExitoso() {
        boolean existe=false;
        UtilWeb.waitForSeconds(10);
        String loadingSplascargando="//div[@class='splash ng-star-inserted']";
        String labelCargando="//div/h1[text()='Cargando']";
        int segundos=60;

        if(esperarLoadingIsNotVisible(loadingSplascargando,segundos)){
            if(esperarLoadingIsNotVisible(labelCargando,60)){
                UtilWeb.waitForSeconds(2);
                existe = waitUntilElementIsVisible(msjExitoso, 20).isDisplayed();
                UtilWeb.waitForSeconds(1);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Mensaje exitoso >>> {0}", msjExitoso.getText());
            }else{
                UtilWeb.logger(this.getClass()).log(Level.INFO, "La pantalla se quedo con el mensaje de cargando... luego de "+segundos+" segundos");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Ocurrio un error, el loading no desaparecio despues de 60 segundos");
        }

        return existe;
    }


    public void ingresarDNISupervisor(String numdoc) {
        waitUntilElementIsVisible(selectTipoDoc,5).click();
        clickElementInAList(listDocumentos,"DNI");
        UtilWeb.waitForSeconds(1);
        WebElement rootInput = find().getElementByXPath("//app-modal-discapacitado//form//div/div/tdp-st-input-text");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div input")).sendKeys(numdoc);
        UtilWeb.waitForSeconds(1);
    }

    public void IngresarUsuarioSupervisor(String user) {
        UtilWeb.waitForSeconds(1);
        WebElement rootInputCorreo = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("div input")).sendKeys(user);
    }

    public void ingresarPasswordSupervisor(String password) {
        UtilWeb.waitForSeconds(1);
        WebElement rootInputCorreo = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[2]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("div input")).sendKeys(password);
    }

    public void clicConfirmarUsuarioSupervisor() {
        WebElement btnConfirmar = find().getElementByXPath("//button[@label='Confirmar']");
        click(btnConfirmar);
        UtilWeb.waitForSeconds(2);
    }

    //OTROS metodos
    public void validacionesCliente(String madre, String padre, String lugar) {
        waitUntilElementIsVisible(lblPreguntas, 30);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);

        if (isElementVisible(By.xpath("//p[contains(text(),'distrito naciste')]"))) {
            System.out.println("En que distrito naciste : " + true);
            WebElement element = find().getElementByXPath("//span[contains(text(),'" + lugar + "')]/..");
            element.click();
        } else {
            System.out.println("no existe pregunta lugar de nacimiento");
        }
        if (isElementVisible(By.xpath("//p[contains(text(),'el nombre de tu padre')]"))) {
            System.out.println("Cual es el nombre de tu padre : " + true);
            WebElement element = find().getElementByXPath("//span[contains(text(),'" + padre + "')]/..");
            element.click();
        } else {
            System.out.println("no existe pregunta nombre padre");
        }
        if (isElementVisible(By.xpath("//p[contains(text(),'el nombre de tu madre')]"))) {
            System.out.println("nCual es el nombre de tu madre : " + true);
            WebElement element = find().getElementByXPath("//span[contains(text(),'" + madre + "')]/..");
            element.click();
        } else {
            System.out.println("no existe pregunta nombre madre");
        }

        UtilWeb.waitForSeconds(2);
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public boolean isElementVisible(By nombre) {
        boolean present;
        UtilWeb.waitForSeconds(2);
        try {
            driver().findElement(nombre);
            System.out.println("si existe");
            present = true;
        } catch (NoSuchElementException e) {
            System.out.println("No existe el elemento:" + e.getMessage());
            present = false;
        }
        return present;
    }

    public void scrollByJavaScript() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollBy(100,150)");
    }
    public void scrollByJavaScriptToPrincipio() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(0, 0);");
    }
    public void scrollByJavaScriptToFinal() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        UtilWeb.waitForSeconds(2);
    }

    public boolean esperarLoadingIsNotVisible(String xpath,int segundos) {
        boolean retorno;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver(), segundos);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            retorno= true;
        } catch (Exception e) {
            retorno=false;
            System.out.println("No se esperó a que se oculte el elemento");
        }
        return retorno;
    }

    public void clicEnValidarHuella() {
        WebElement rootInputCorreo = find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en Validar huella");
        UtilWeb.waitForSeconds(2);
    }

}
