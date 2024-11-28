package com.tdp.ct.web.page;

import com.tdp.ct.web.CaptchaBase.Parameters;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.FileUtils.downloadPDF;
import static com.tdp.ct.web.utils.FileUtils.getAbsolutePathString;
import static com.tdp.ct.web.utils.SessionStorage.getValueItemSessionStorage;

public class CheckoutPage extends WebBase {

    private static String SALES_CODE;
    private static String CONTRACT;
    @FindBy(xpath = "//*[contains(text(),'Ver detalle del pedido') or contains(@class,'detalle_sub')]")
    protected WebElement btnDetallePedido;
    @FindBy(xpath = "//app-root/app-success/div[2]/div[3]")
    protected WebElement scrollorden;
    @FindBy(xpath = "(//*[@class=\"_close\"])[1]")
    protected WebElement cerrarPopUpContratos;
    @FindBy(xpath = "(//*[@class=\"btn btnFirst\"])[1]")
    protected WebElement contratoUno;
    @FindBy(xpath = "(//*[@class=\"btn btnSecond\"])[1]")
    protected WebElement contratoDos;
    @FindBy(xpath = "//span[contains(text(),'Ciclo de facturación:')]")
    protected WebElement cicloFacturacion;
    @FindBy(xpath = "//div/tdp-st-button[contains(@label,'Descargar contrato')]")
    protected WebElement descargarContrato;
    @FindBy(xpath = "//app-modal-contract//tdp-st-modal//div[@slot='modal_body']//p")
    protected WebElement textoContratoCliente;
    @FindBy(xpath = "//*[contains(text(), 'Estás a un paso de registrar el servicio')]")
    protected WebElement titleRegistrarServicio;
    @FindBy(xpath = "//div[contains(text(),'ha sido exitoso')]")
    protected WebElement msjExitoso;
    @FindBy(xpath = "//div[contains(text(),'no se ha concretado')]")
    protected WebElement msjFallo;
    @FindBy(xpath = "//body/div[2]/form/div[1]/h1")
    protected WebElement esperarCorreo;
    @FindBy(xpath = "//div[contains(text(),'Descarga el contrato')]")
    protected WebElement titleDescargaContrato;
    @FindBy(xpath = "//*[contains(@class,'orden-big')]")
    protected List<WebElement> listCodigoOrden;
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;
    @FindBy(xpath = "//*[contains(text(),' Continuar ')]/parent::button")
    protected WebElement buttonContinuar;
    @FindBy(xpath = "//tdp-st-button[@label='Sí, acepta']")
    protected WebElement rootModalButtonSiAcepto;
    @FindBy(xpath = "//*[contains(@class,'sectionToPrint') or contains(@class,'ticket-equipment')]")
    protected WebElement tittleTicket;

    public boolean validarPantallaRegistrarVenta() {
        boolean verificarUbicacion = true;
        int contadorEstado = 0;
        do {
            esperaProgresiva(driver(), 3, 3, titleRegistrarServicio);
//            Realizar un try catch para buscar el elemento devolver un return para almacenar el valor false si se ecnuntra la venta complketada
            try {
                msjExitoso.isDisplayed();
                Parameters.estadoFlujo = false;
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Ventana de venta exitosa visible");
                return true;
            } catch (NoSuchElementException nsee) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "No se encontro la ventana de venta exitosa");
//                verificarUbicacion = true;
            }
            try {
                titleRegistrarServicio.isDisplayed();
                verificarUbicacion = false;
                Parameters.estadoFlujo = true;
            } catch (NoSuchElementException nsee) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "No se encontro la ventana de registrar venta");
//                verificarUbicacion = true;
            }
            contadorEstado++;
        } while (verificarUbicacion && contadorEstado < 80);

        try {
            esperaProgresiva(driver(), 3, 4, titleRegistrarServicio);
            boolean existe = waitUntilElementIsVisible(titleRegistrarServicio, 70).isDisplayed();
            UtilWeb.waitForSeconds(1);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Lugar de instalacion >>> {0}", existe);
            return existe;

        } catch (TimeoutException ex) {

            WebElement mensajeElemento = driver().findElement(By.className("success-title"));

            // Obtener el texto del elemento
            String mensajeTexto = mensajeElemento.getText();
            // Verificar si el mensaje contiene la frase "ha sido cancelado"
            if (mensajeTexto.contains("ha sido cancelado")) {
                driver().navigate().back();
                esperaProgresiva(driver(), 3, 5, esperarCorreo);
                waitUntilElementIsVisible(esperarCorreo, 10);
                waitUntilElementIsClickable(buttonValidarContrato, 10);
                js().scrollElementTop(buttonValidarContrato);
                click(buttonValidarContrato);
                clicSiAcepto();
                clicBotonContinuar();
                return false;

            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "El mensaje 'Tu registro hogar ha sido cancelado' no está presente en la pantalla.");
                return false;
            }
        }
    }

    public void clicSiAcepto() {
        WebElement element = sh().getWebElement(rootModalButtonSiAcepto, "button");
        //waitUntilElementIsClickable(element, 30);
        esperaProgresiva(driver(), 2, 5, element);
        element.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dando click en si acepto");
        UtilWeb.waitForSeconds(6);
    }

    public void clicBotonContinuar() {
        Addons.revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 5;
        while (!buttonFound && contador <= reintentoBucles) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al while");
            try {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al try");
                waitUntilElementIsClickable(buttonContinuar, 10);
                buttonFound = true;
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al catch");
                UtilWeb.waitForSeconds(5);
                contador++;
                UtilWeb.logger(this.getClass()).log(Level.INFO, contador + " vez");
            }
        }
        System.out.println("Sale del while");
        esperaProgresiva(driver(), 5, 5, buttonContinuar);
        js().scrollElementTop(buttonContinuar);
        click(buttonContinuar);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en continuar");
        UtilWeb.waitForSeconds(5);
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

    public void scrollByJavaScriptToPrincipio() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(0, 0);");
    }

    public boolean esperarLoadingIsNotVisible(String xpath, int segundos) {
        boolean retorno;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver(), Duration.ofSeconds(segundos));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No se espero a que se oculte el elemento");
        }
        return retorno;
    }

    public void clicDescargarContrato(ManageScenario scenario) {
        revisarModalError(driver());
        for (int intento = 1; intento <= 2; intento++) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Entra al primer try");
            try {
                esperaProgresiva(driver(), 6, 5, descargarContrato);
                click(descargarContrato);
                UtilWeb.waitForSeconds(2);
                try {

                    waitUntilElementIsVisible(contratoUno, 40);
                    UtilWeb.waitForSeconds(3);
                    String nombreDelBoton = contratoUno.getText();
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "Se muestra el Boton contratoUno: " + nombreDelBoton);
                } catch (Exception e) {
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "El elemento contrato Uno ya no fue encontrado: ");
                }

                String rutabase = getAbsolutePathString( "target/contrato-pdf");
                File directorio = new File(rutabase);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "Directorio Creado: ");
                }
                UtilWeb.logger(this.getClass()).log(Level.INFO, "RUTA BASE: " + rutabase);
                WebElement pdfElement = driver().findElement(By.tagName("iframe"));

                esperaProgresiva(driver(), 3, 3, pdfElement);
                scenario.printFullView();
                String pdfUrl = pdfElement.getAttribute("src");
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Link PDF 1: " + pdfUrl);
                downloadPDF(pdfUrl, rutabase);
                scenario.printFullView();
                //click en el 2do boton
                if (contratoDos != null) {
                    String nombreDelBoton2 = contratoDos.getText();
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "Se muestra el Boton contratoDos: " + nombreDelBoton2);
                    click(contratoDos);
                    UtilWeb.waitForSeconds(3);
                    WebElement pdfElement2 = driver().findElement(By.tagName("iframe"));
                    esperaProgresiva(driver(), 3, 3, pdfElement2);
                    scenario.printFullView();
                    String pdfUrl2 = pdfElement2.getAttribute("src");
                    System.out.println("Link PDF 2: " + pdfUrl2);
                    downloadPDF(pdfUrl2, rutabase);
                    UtilWeb.waitForSeconds(3);
                    click(cerrarPopUpContratos);
                    break;
                } else {
                    UtilWeb.logger(this.getClass()).log(Level.INFO, "No hay un segundo contrato.");
                }
                scenario.printFullView();
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Error: " + e.getMessage());
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Sale del primer try");
            }

        }

        try {
            click(cerrarPopUpContratos);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "cerrarPopUpContratos cierre");
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.WARNING, "ERROR -" + e.getMessage());
        }
    }

    public String getSummary() {
        int contadorReintentos = 0;
        do {
            UtilWeb.waitForSeconds(5);
            CONTRACT = textoContratoCliente.getText().trim();

            if (!CONTRACT.isEmpty()) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Texto del contrato del cliente: " + CONTRACT);
                break;
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Texto del contrato del cliente está vacío. Reintentando...");
            }
            contadorReintentos++;
        } while (contadorReintentos < 4);

        if (contadorReintentos == 4) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Se alcanzó el número máximo de reintentos. No se pudo obtener un texto no vacío.");
        }

        return CONTRACT;
    }

    public List<String> getOrderCode() {
        List<String> listCodigosDeOrdenes = new ArrayList<>();
        listCodigoOrden.forEach((orden) -> {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Código de Orden: " + orden.getText() + "A");
            listCodigosDeOrdenes.add("Código de Orden: " + orden.getText() + "A");
        });
        return listCodigosDeOrdenes;
    }

    public String getSalesCode() {

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Method getSalesCode()");
        String salesCode;
        salesCode = getSalesCodeSessionStorage();

        if (salesCode == null) {
            salesCode = getSalesCodeContract(CONTRACT);

        }
        if (salesCode == null) {
            salesCode = getSalesCodeFinalSales();
        }

        salesCode = (salesCode == null) ? null : salesCode.trim();

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Sales Code: " + salesCode);

        return salesCode;

    }

    public String getSalesCodeSessionStorage() {
        String salesCode = null;

        try {
            salesCode = getValueItemSessionStorage(driver(), "saleObject", "salesId");
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Sales code of session storage: " + salesCode);

        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Error - Error - Get sales code of session storage " + e.getMessage());

        }

        return salesCode;
    }

    public String getSalesCodeContract(String contract) {
        try {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Get sales code of contract: " + contract);
            SALES_CODE = "FE-" + ((contract.split("FE-")[1]).split("\\.")[0]);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Sales code of text contract: " + SALES_CODE);
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Error - Get sales code of contract " + e.getMessage());
        }
        return SALES_CODE;
    }

    public String getSalesCodeFinalSales() {
        String salesCode = null;
        try {
            WebElement txtCodigoVenta = driver().findElement(By.xpath("//*[contains(@id,'salesID') or contains(text(),'FE-')]"));
            boolean elementoExistente = txtCodigoVenta.isDisplayed();
            if (elementoExistente) {
                salesCode = txtCodigoVenta.getText().trim();
                if (salesCode.length() > 13) {
                    salesCode = salesCode.split(": ")[1];
                }
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Get sales code of final sales: " + salesCode);
            }
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Error - Get sales code of final sales" + e.getMessage());
        }
        return salesCode;
    }

    public void ValidoQuePresenteDetallePedido(String service) {
        WebElement serviceText = find().getElementByXPath("//*[contains(text(),'" + service.trim() + "')]");
        js().scrollElementTop(serviceText);
        waitUntilElementIsVisible(serviceText, 5);
    }

    public void clickenVerDetalleDelPedido() {
        js().scrollElementTop(scrollorden);
        esperaProgresiva(driver(), 6, 6, btnDetallePedido);
        js().scrollElementTop(btnDetallePedido);
        waitUntilElementIsClickable(btnDetallePedido, 60).click();
    }

    public String getProductType() {
        return getValueItemSessionStorage(driver(), "saleObject", "productType");
    }

    public void validateTheBillingCycle() {
        esperaProgresiva(driver(), 3, 5, cicloFacturacion);
        waitUntilElementIsVisible(scrollorden, 70);
        esperaProgresivaLoading(driver(), 3, 5, "loadingCard");
        esperaProgresiva(driver(), 3, 5, cicloFacturacion);
        esperaProgresivaLoading(driver(), 3, 5, "loadingCard");
        js().scrollElementTop(cicloFacturacion);
    }

    public boolean validateRegistrationHasBeenSuccessful() {
        driver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        revisarModalError(driver());
        boolean existe;
        esperaProgresiva(driver(), 3, 5, msjExitoso);
        existe = waitUntilElementIsVisible(msjExitoso, 180).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Mensaje exitoso >>> {0}", msjExitoso.getText());
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        return existe;
    }

    public void validateTicket() {
        js().scrollElementTop(tittleTicket);
    }
}
