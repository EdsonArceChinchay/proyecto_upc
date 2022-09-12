package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AltaFijaMovilRegistroPage extends WebBase {

    @FindBy(xpath = "//span[contains(text(),'Lugar de')]")
    protected WebElement titleLugarInstalacion;
    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement titleOfertasSugeridas;
    @FindBy(xpath = "//div/span[contains(@class,'smallTitle')]/../../following-sibling::*//img")
    protected List<WebElement> listaOfertasSugeridas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;
    @FindBy(xpath = "//span[@class='text-capitalize']")
    protected WebElement titlePlan;
    @FindBy(xpath = "//*[@label='Iniciar Registro' or  @type='button' and @class='btnStart']")
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
    @FindBy(xpath = "//div[contains(text(),'ha sido exitoso')]")
    protected WebElement msjExitoso;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Identidad Validada')]")
    protected WebElement buttonIdentidadValidada;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Validar contrato')]/..")
    protected WebElement buttonValidarContrato;

    @FindBy(xpath = "//div[@class='codigo-venta ng-star-inserted']")
    protected WebElement lblNumeroOrden;
    @FindBy(xpath = "//div[@class='container-btns']/button[contains(text(),'SVA')]")
    protected WebElement buttonAgregarSVA;
    @FindBy(xpath = "//div/button[contains(text(),'Guardar cambios')]")
    protected WebElement buttonGuardarCambios;
    @FindBy(xpath = "//div[@class='boxHour active']")
    protected WebElement buttonTurnoAgendamientoActivo;
    @FindBy(xpath = "//button[text()='Crear cliente']")
    protected WebElement buttonCrearCliente;
    @FindBy(xpath = "(//span[contains(text(),'Datos del Cliente')]/..)[2]")
    protected WebElement buttonDatosDeCliente;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Datos del Cliente')]")
    protected WebElement labelDatosDeCliente;
    @FindBy(xpath = "//div[contains(text(),'Descarga el contrato')]")
    protected WebElement titleDescargaContrato;
    @FindBy(xpath = "//button[@class='_close']")
    protected WebElement buttonCerrarModal;

    @FindBy(css = ".services-section:nth-child(1) .section-container .row-content:nth-child(1) .actions-content .tdp-st-icon-button:nth-child(1)")
    protected WebElement iconPlus;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnCerrar;

    public boolean validarPantallaIngresarDireccion() {
        boolean existe = waitUntilElementIsVisible(titleLugarInstalacion, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Lugar de instalacion >>> {0}", existe);
        return existe;
    }

    public boolean validarQueExistanOfertasSugeridas() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        boolean existe = waitUntilElementIsVisible(listaOfertasSugeridas.get(0), 100).isDisplayed();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de ofertas >>> {0}", existe);
        return existe;
    }

    public void seleccionarOferta(String oferta) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        scrollByJavaScript();
        UtilWeb.waitForSeconds(4);
        //String elemento = "(//span[contains(text(),'" + oferta + "')]/../../following-sibling::*//img)[1]";
        String elemento = "(//div/span/text()[contains(translate(., 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), '" + oferta + "')]/../../../following-sibling::*//img)[1]";
        WebElement elementOferta = find().getElementByXPath(elemento);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando la oferta >>> {0}", oferta);
        elementOferta.click();
    }

    public void seleccionarPlan(String plan) {
        UtilWeb.waitForSeconds(3);
        //String elemento = "//div[contains(text(),'" + plan + "')]/../../../div";
        String elemento = "//div[text()='" + plan + "']/../..";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", plan);
        js().scrollElementTop(find().getElementByCss("div.block_scroll"));
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
        UtilWeb.waitForSeconds(5);
        js().scrollElementTop(buttonIniciarRegistro);
        UtilWeb.waitForSeconds(5);
    }

    public void clicIniciarRegistro() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        waitUntilElementIsVisible(buttonIniciarRegistro, 20);
        click(buttonIniciarRegistro);
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a iniciar registro");
        clickBtnCerrarModalError(buttonIniciarRegistro);
    }

    public boolean validarPantallaAgendamiento() {
        clickBtnCerrarModalError(buttonIniciarRegistro);
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
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
        UtilWeb.waitForSeconds(4);
        waitUntilElementIsClickable(buttonConfirmar, 10);
        click(buttonConfirmar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a confirmar agendamiento");
    }

    public boolean validarDetalleInstalacion() {
        UtilWeb.waitForSeconds(1);
        boolean existe;
        try {
            WebElement element = find().getElementByXPath("//app-modal-detalle//div/h1[contains(text(),'Detalles')]");
            waitUntilElementIsVisible(element, 5);
            element.isDisplayed();
            existe = true;
        } catch (NoSuchElementException ex) {
            existe = false;
            System.out.println(ex.getMessage());
        }
        UtilWeb.waitForSeconds(1);
        return existe;
    }

    public void clicConfirmarInstalacion() {
        WebElement element = find().getElementByXPath("//app-modal-detalle//div/button");
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
        UtilWeb.waitForSeconds(5);
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
        UtilWeb.waitForSeconds(5);
        WebElement rootInputCorreo = find().getElementByXPath("(//div[@class='modal_footer']//tdp-st-button)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void verificarIdentidadValidada() {
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        String loadingInserted = "//div[@class='loadingCard ng-star-inserted']";

        if (esperarLoadingIsNotVisible(loadingInserted, 30)) {
            waitUntilElementIsVisible(buttonIdentidadValidada, 20).isDisplayed();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Identidad validada");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public void clicValidarContrato() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        UtilWeb.waitForSeconds(100);
        waitUntilElementIsVisible(buttonValidarContrato, 50);
        waitUntilElementIsClickable(buttonValidarContrato, 100).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "clic validar contrato");
    }

    public void clicBotonContinuar() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsVisible(buttonContinuar, 100).click();
        UtilWeb.waitForSeconds(60);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
    }

    public void visualizarContratoEnPantalla() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        WebElement element = sh().getWebElement(rootModalButtonSiAcepto, "button");
        waitUntilElementIsVisible(element, 20);
        UtilWeb.waitForSeconds(2);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mostrando contrato en pantalla");
    }

    public void clicSiAcepto() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        WebElement element = sh().getWebElement(rootModalButtonSiAcepto, "button");
        waitUntilElementIsVisible(element, 30).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dando click en si acepto");

    }
    /*
    public boolean validarMensajeExitoso() {
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        boolean existe = false;
        UtilWeb.waitForSeconds(10);
        String loadingSplascargando = "//div[@class='splash ng-star-inserted']";
        String labelCargando = "//div/h1[text()='Cargando']";
        int segundos = 60;

        if (esperarLoadingIsNotVisible(loadingSplascargando, segundos)) {
            if (esperarLoadingIsNotVisible(labelCargando, 60)) {
                UtilWeb.waitForSeconds(3);
                scrollByJavaScriptToPrincipio();
                existe = waitUntilElementIsVisible(msjExitoso, 30).isDisplayed();
                UtilWeb.waitForSeconds(1);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Mensaje exitoso >>> {0}", msjExitoso.getText());
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "La pantalla se quedo con el mensaje de cargando... luego de 60 segundos");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Ocurrio un error, el loading no desaparecio despues de " + segundos + "  segundos");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        return existe;
    }

     */


    public void ingresarDNISupervisor(String numdoc) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        waitUntilElementIsVisible(selectTipoDoc, 10).click();
        clickElementInAList(listDocumentos, "DNI");
        UtilWeb.waitForSeconds(1);
        WebElement rootInput = find().getElementByXPath("//app-modal-discapacitado//form//div/div/tdp-st-input-text");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div input")).sendKeys(numdoc);
        UtilWeb.waitForSeconds(1);
    }

    public void IngresarUsuarioSupervisor(String user) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        UtilWeb.waitForSeconds(1);
        WebElement rootInputCorreo = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[1]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("div input")).sendKeys(user);
    }

    public void ingresarPasswordSupervisor(String password) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        UtilWeb.waitForSeconds(1);
        WebElement rootInputCorreo = find().getElementByXPath("(//app-modal-discapacitado//form//div/div/tdp-st-input-text)[2]");
        SearchContext context = sh().getContext(rootInputCorreo);
        context.findElement(By.cssSelector("div input")).sendKeys(password);
    }

    public void clicConfirmarUsuarioSupervisor() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        WebElement btnConfirmar = find().getElementByXPath("//button[@label='Confirmar']");
        js().scrollElementTop(btnConfirmar);
        UtilWeb.waitForSeconds(1);
        click(btnConfirmar);
        UtilWeb.waitForSeconds(2);
    }

    //OTROS metodos
    public void validacionesCliente(String madre, String padre, String lugar) {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        //   waitUntilElementIsVisible(lblPreguntas, 30);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);

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

        if (isElementVisible(By.xpath("//p[contains(text(),'distrito naciste')]"))) {
            System.out.println("En que distrito naciste : " + true);
            WebElement element = find().getElementByXPath("//span[contains(text(),'" + lugar + "')]/..");
            element.click();
        } else {
            System.out.println("no existe pregunta lugar de nacimiento");
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

    public boolean esperarLoadingIsNotVisible(String xpath, int segundos) {
        boolean retorno;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver(), segundos);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            System.out.println("No se espero a que se oculte el elemento");
        }
        return retorno;
    }


    public void clicEnAgregarSVA() {
        js().scrollElementTop(buttonAgregarSVA);
        waitUntilElementIsVisible(buttonAgregarSVA, 10);
        click(buttonAgregarSVA);
        UtilWeb.waitForSeconds(5);
    }

    public void clicSVAHBO() {
        WebElement rootElement = find().getElementByXPath("//div[contains(text(),'HBO')]/../following-sibling::div//tdp-st-checkbox");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > input")).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en sva HBO");
        UtilWeb.waitForSeconds(5);
    }

    public void clicGuardarCambios() {
        js().scrollElementTop(buttonGuardarCambios);
        waitUntilElementIsVisible(buttonGuardarCambios, 10);
        click(buttonGuardarCambios);
        UtilWeb.waitForSeconds(5);
    }

    public void clicEnUnTurnoAgendamiento() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(buttonTurnoAgendamientoActivo, 10);
        click(buttonTurnoAgendamientoActivo);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Haciendo clic a en turno agendamiento");
        UtilWeb.waitForSeconds(4);
    }

    //CAMBIOS PARA RETAIL
    public void ingresarNombreClienteExtranjero(String nombre) {
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='nomCli']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(nombre);
        UtilWeb.waitForSeconds(1);
    }

    public void ingresarApellidoClienteExtranjero(String apellidos) {
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-input-text[@formcontrolname='apeCli']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(apellidos);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarGeneroClienteExtranjero(String genero) {
        WebElement generoList = find().getElementByXPath("//div/tdp-st-select[@formcontrolname='genero']");
        click(generoList);
        String dataValue = "";
        SearchContext context = sh().getContext(generoList);
        if (genero.equalsIgnoreCase("femenino")) {
            dataValue = "F";
        } else {
            dataValue = "M";
        }
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void crearCliente() {
        //waitUntilElementIsClickable(buttonCrearCliente, 10);
        js().scrollElementTop(buttonCrearCliente);
        click(buttonCrearCliente);
        UtilWeb.waitForSeconds(2);
        //UtilWeb.waitForSeconds(10);
    }

    public void esperarBtnDatosCliente() {
        js().scrollElementTop(buttonDatosDeCliente);
        waitUntilElementIsVisible(buttonDatosDeCliente, 10);
    }

    public void clicDatosDeCliente() {
        UtilWeb.waitForSeconds(2);
        click(buttonDatosDeCliente);
        UtilWeb.waitForSeconds(2);
    }

    public void ingresarFechaNac(String fechaNac) {
        WebElement rootElement = find().getElementByXPath("//tdp-st-input-text[@formcontrolname='fechaNacimiento']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(fechaNac);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoNacionalidad() {
        WebElement nacList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(nacList);
        UtilWeb.waitForSeconds(2);
        String dataValue = "DEU";
        SearchContext context = sh().getContext(nacList);
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando nacionalidad");
    }

    public void seleccionarEstadoCivil(String genero) {
        WebElement generoList = find().getElementByXPath("//div/tdp-st-select[@formcontrolname='genero']");
        click(generoList);
        String dataValue = "";
        SearchContext context = sh().getContext(generoList);
        if (genero.equalsIgnoreCase("femenino")) {
            dataValue = "F";
        } else {
            dataValue = "M";
        }
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        UtilWeb.waitForSeconds(1);
    }

    public void clicConfirmarCliente() {
        UtilWeb.waitForSeconds(1);
        WebElement element = find().getElementByXPath("//button[contains(text(),'Confirmar')]");
        element.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void datosClienteValidado() {
        UtilWeb.waitForSeconds(3);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        String loadingInserted = "//div[@class='loadingCard ng-star-inserted']";

        if (esperarLoadingIsNotVisible(loadingInserted, 30)) {
            waitUntilElementIsVisible(labelDatosDeCliente, 10).isDisplayed();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "datos cliente validado");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    public boolean mostrarPantallaDescargarContrato() {
        UtilWeb.waitForSeconds(2);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        boolean existe = false;
        UtilWeb.waitForSeconds(2);
        String loadingSplascargando = "//div[@class='splash ng-star-inserted']";
        String labelCargando = "//div/h1[text()='Cargando']";
        int segundos = 60;

        if (esperarLoadingIsNotVisible(loadingSplascargando, segundos)) {
            if (esperarLoadingIsNotVisible(labelCargando, 60)) {
                UtilWeb.waitForSeconds(3);
                scrollByJavaScriptToPrincipio();
                existe = waitUntilElementIsVisible(titleDescargaContrato, 20).isDisplayed();
                UtilWeb.waitForSeconds(1);

            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "La pantalla se quedo con el mensaje de cargando... luego de 60 segundos");
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Ocurrio un error, el loading no desaparecio despues de " + segundos + "  segundos");
        }
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        return existe;
    }

    public void clicDescargarContrato() {

        UtilWeb.waitForSeconds(7);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-button[contains(@label,'Descargar contrato')]");
        js().scrollElementTop(rootElement);
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.waitForSeconds(3);
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

    }

    public void clicRegistrarVenta() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        UtilWeb.waitForSeconds(10);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        waitUntilElementIsVisible(buttonCerrarModal, 100).click();
        UtilWeb.waitForSeconds(1);
        scrollByJavaScriptToFinal();
        UtilWeb.waitForSeconds(1);
        WebElement rootElement = find().getElementByXPath("//div/tdp-st-button[contains(@label,'Registrar venta')]");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("button")).click();
        UtilWeb.waitForSeconds(3);
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    @FindBy(xpath = "/html/body/app-root/app-success/div[2]/div[3]")
    protected WebElement scrollorden;

    public boolean validarVentaGenerada() {
        clickBtnReintentar();
        clickBtnReintentar();
        clickBtnReintentar();
        waitUntilElementIsVisible(scrollorden, 100);
        js().scrollElementTop(scrollorden);
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        clickBtnReintentar();
        boolean existe = false;
        //scrollByJavaScriptToPrincipio();
        existe = waitUntilElementIsVisible(msjExitoso, 100).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mensaje exitoso >>> {0}", msjExitoso.getText());
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        return existe;
    }


    public void agregoSVAINTERNET(String svaInternet) {
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan = find().getElementByCss("app-adicionales tdp-st-select");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listElementPLan);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            System.out.println(elements.getText());
            if (elements.getText().equals(svaInternet)) {
                UtilWeb.waitForSeconds(2);
                click(elements, 3);
            }
        }
    }

    public void clickBtnReintentar() {
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al boton reintentar");
            btnReintentar.click();
            UtilWeb.waitForSeconds(2);
        }

    }

    public void clickBtnCerrarModalError( WebElement metodoRepedito){
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
