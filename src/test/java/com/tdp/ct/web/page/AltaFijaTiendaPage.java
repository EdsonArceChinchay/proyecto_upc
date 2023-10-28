package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//div[contains(text(),'Nombre:')]")
    protected WebElement nombresCompletosCliente;

    @FindBy(xpath = "(//button[contains(text(),'Línea nueva móvil') or @class='btnCard' and contains(text(),'Línea nueva') or @class='btnCard' and contains(text(),'Línea Nueva')  or @class='btnCard' and contains(text(),'Cambiar plan hogar')  or @class='btnCard' and contains(text(),'Cambiar Plan')])[1]")
    protected WebElement btnLineaNueva;

    @FindBy(xpath = "//*[@class='buttonG' and contains(text(),'SVA')]")
    protected WebElement btnSVA;

    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;

    @FindBy(xpath = "//img[@src='assets/images/left-arrow.png']")
    protected WebElement btnLeft;

    //@FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")

    //*[contains(text(),'Reintentar') 

    @FindBy(xpath = "//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;

    @FindBy(xpath = "(//button[contains(text(),'Reintentar')])[1]")
    protected WebElement btnReintentarFinal;

    @FindBy(xpath = "(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button")
    protected WebElement btnRegistrarVenta;

    @FindBy(xpath = "//button/span[contains(text(), 'Validar identidad del Rep. Legal')]/..")
    protected WebElement btnValidaLegal;

    public String nombresCompletosCliente() {
        // waitUntilElementIsVisible(nombresCompletosCliente, 10);
        esperaProgresiva(driver(), 5, 5, nombresCompletosCliente);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        return getText(nombresCompletosCliente);
    }

    public void listaPlanFija(String planFija) {
        modalError(5, btnReintentar, "Click al elemento Reitentar");
        modalError(5, btnReintentar, "Click al elemento Reitentar");
        //modalError(5,btnReintentar,"Click al elemento Reitentar");
        waitUntilElementIsVisible(esperalistaPlanFija, 10);
        UtilWeb.waitForSeconds(5);
        clickElementInAList(listaPlanFija, planFija);
        UtilWeb.waitForSeconds(5);
    }

    public void listaPlanFijaMultiple(String planFija) {
        //modalError(5, btnReintentar, "Click al elemento Reitentar");
        modalErrorMultiple(5, btnReintentar, "Click al elemento Reitentar");
        //modalError(5,btnReintentar,"Click al elemento Reitentar");
        waitUntilElementIsVisible(esperalistaPlanFija, 1);
        clickElementInAList(listaPlanFija, planFija);
    }

    public void listaOfertas(String planOfertas) {
//        modalError(10,btnReintentar,"Click al elemento Reitentar");
//        modalError(10,btnReintentar,"Click al elemento Reitentar");

        //WebElement element = listaOfertas.get(0);
        //String elXpath = "(//div[@class='stl_negrita g-text--uppercase'])[1]";
        //Addons.reintentaModalError(driver(), 6, 5, null, this, elXpath);
        revisarModalError(driver());

        String ofertaEsperada = planOfertas.trim().toUpperCase();
        System.out.println("Ofertas : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);
        //driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                System.out.println("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }
        //driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            System.out.println("Entro al for de las lista de ofertas");
            System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }
        if (!encontroElemento && listaOfertas.size() > 0) {
            System.out.println("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
    }

    public void listaOfertasNuevo(String planOfertas) {
//        modalError(10,btnReintentar,"Click al elemento Reitentar");
//        modalError(10,btnReintentar,"Click al elemento Reitentar");

        //WebElement element = listaOfertas.get(0);
        //String elXpath = "(//div[@class='stl_negrita g-text--uppercase'])[1]";
        //Addons.reintentaModalError(driver(), 6, 5, null, this, elXpath);
        revisarModalError(driver());

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            UtilWeb.waitForSeconds(1);
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                System.out.println("dio click right");
                click(btnRight);
                UtilWeb.waitForSeconds(2);
            }
        }

        UtilWeb.waitForSeconds(2);
        boolean elementoExistenteRight;
        boolean elementoExistenteleft;
        elementoExistenteRight = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;

        int contador = 0;
        int contadorMax =4;
        while (elementoExistenteRight && contador<contadorMax)
        {
            if (btnRight != null) {
                click(btnRight);
                UtilWeb.waitForSeconds(2);
                System.out.println("dio click right while");
            } else {
                System.out.println("El elemento btnRight no existe o es nulo.");
            }

            UtilWeb.waitForSeconds(2);
            elementoExistenteRight = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            contador++;
        }
        UtilWeb.waitForSeconds(2);
        contador = 0;
        elementoExistenteleft = driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).size() != 0;
        while (elementoExistenteleft && contador<contadorMax)
        {

            if (btnLeft != null) {
                click(btnLeft);
                UtilWeb.waitForSeconds(2);
                System.out.println("dio click left while");
            } else {
                System.out.println("El elemento btnleft no existe o es nulo.");
            }

            UtilWeb.waitForSeconds(2);
            elementoExistenteleft = driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).size() != 0;
            contador++;
        }

        String ofertaEsperada = planOfertas.trim().toUpperCase();
        System.out.println("Ofertas : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);
        //driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        //driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            System.out.println("Entro al for de las lista de ofertas");
            System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }
        if (!encontroElemento && listaOfertas.size() > 0) {
            System.out.println("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
        Assert.assertTrue(encontroElemento);
    }

    public void listaOfertasMultiple(List<String> escenario, List<String> planes, List<String> precios, List<String> beneficiosPlan, List<String> descuentosPlan) {

        revisarModalError(driver());

        System.out.println("Ofertas : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);

        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;
        //-------------------------------------------------------//

        String escenarioNombre = escenario.get(0).trim().toUpperCase();

        for (int j = 0; j < planes.size(); j++) {
            String ofertaEsperada = planes.get(j).trim().toUpperCase();
            String precioEsperado = precios.get(j).trim().toUpperCase();
            String beneficioEsperado = beneficiosPlan.get(j).trim().toUpperCase();
            String descuentoEsperado = descuentosPlan.get(j).trim().toUpperCase();
            System.out.println("Busqueda del Plan: " + ofertaEsperada);
            boolean encontroPrecio = false;
            boolean encontroBeneficio = false;
            boolean encontroDescuentos = false;

            for (int i = 0; i < listaOfertas.size(); i++) {
                String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
                System.out.println("Entro al for de las lista de ofertas");
                System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
                if (ofertaObtenida.contains(ofertaEsperada)) {
                    encontroElemento = true;
                    UtilWeb.waitForSeconds(2);
                    click(listaOfertas.get(i));
                    scrollAndPerformAction(driver(),buttonSeleccionarOferta,ofertaEsperada,escenarioNombre);
                    UtilWeb.waitForSeconds(2);

                    WebElement container = driver().findElement(By.cssSelector("div.offert-card-container.select"));

                    // Encuentra todos los elementos <div> descendientes dentro del contenedor
                    List<WebElement> divElements = container.findElements(By.tagName("div"));
                    System.out.println("Textos: ");
                    for (WebElement divElement : divElements) {
                        // Imprime o almacena el contenido de cada elemento <div>

                        String textoCodigo = divElement.getText().trim().toUpperCase();
                        System.out.println(textoCodigo);

                        if (textoCodigo.contains(precioEsperado))
                        {
                            encontroPrecio = true;
                        }

                        if (textoCodigo.contains(beneficioEsperado))
                        {
                            encontroBeneficio = true;
                        }

                        if (textoCodigo.contains(descuentoEsperado))
                        {
                            encontroDescuentos = true;
                        }

                    }
                    break;
                }
                if (i == 2 || i == 5 || i == 8) {
                    boolean elementoExistente;
                    elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                    if (elementoExistente) {
                        btnRight.click();
                        UtilWeb.waitForSeconds(1);
                    }
                }
            }

            System.out.println("---------Inicia Validacion para el Plan: "+ ofertaEsperada +" ---------");

            if(encontroPrecio)
            {
                System.out.println("El Precio " + precioEsperado + " fue ENCONTRADO.");

            } else{

                System.out.println("El Precio " + precioEsperado + " NO FUE ENCONTRADO.");

            }

            if(encontroBeneficio)
            {
                System.out.println("El Beneficio " + beneficioEsperado + " fue ENCONTRADO.");

            } else{

                System.out.println("El Beneficio " + beneficioEsperado + " NO FUE ENCONTRADO.");

            }

            if(encontroDescuentos)
            {
                System.out.println("El Descuento " + descuentoEsperado + " fue ENCONTRADO.");

            } else{

                System.out.println("El Descuento " + descuentoEsperado + " NO FUE ENCONTRADO.");

            }

            System.out.println("---------Fin Validacion para el Plan: "+ ofertaEsperada +" ---------");


        }

        if (!encontroElemento && listaOfertas.size() > 0) {
            System.out.println("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }

    }

    public static void takeScreenshot(WebDriver driver, String screenshotName, String escenarioNombre) {
        try {
            // Tomar la captura de pantalla como un archivo
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            LocalDate fechaActual = LocalDate.now();

            // Crea un formateador para el formato "dd-MM-yy"
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yy");

            // Formatea la fecha en el formato deseado
            String fechaFormateada = fechaActual.format(formateador);

            // Carpeta para almacenar las capturas de pantalla
            String screenshotsDir = "screenshots" + "/" + fechaFormateada+ "/"+ escenarioNombre; // Carpeta "screenshots" en el directorio de trabajo
            String screenshotPath = screenshotsDir + "/" + screenshotName + ".png";

            // Verificar si la imagen ya existe en la ruta
            if (Files.exists(Paths.get(screenshotPath))) {
                // Eliminar la imagen existente
                Files.delete(Paths.get(screenshotPath));
            }

            // Copiar el archivo de la captura de pantalla a la ruta especificada
            FileUtils.copyFile(src, new File(screenshotPath));
            System.out.println("Screenshot guardado en: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Error al tomar el screenshot: " + e.getMessage());
        }
    }

    public static void scrollAndPerformAction(WebDriver driver, WebElement element, String screenshotName, String escenarioNombre) {
        // Captura la posición de desplazamiento inicial
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Captura una screenshot al inicio
        takeScreenshot(driver, "antes_" + screenshotName,escenarioNombre);

        // Realiza el desplazamiento para llevar el elemento al final  de la vista
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Captura una screenshot después de la acción
        takeScreenshot(driver, "despues_" + screenshotName,escenarioNombre);

        // Encontrar el elemento inicial
        WebElement button = driver.findElement(By.cssSelector("button.button-filter.btnActive"));

        // Desplazar hacia el elemento inicial

        js.executeScript("arguments[0].scrollIntoView(true);", button);

    }

    public void cerrarVentanaOfertas() {
        UtilWeb.waitForSeconds(1);
        List<WebElement> elementos = driver().findElements(By.xpath("//img[@src='assets/images/ico_cerrar.svg']"));
        System.out.println("Elementos " + elementos.size());
        if (elementos.size() >= 3) {
            WebElement segundoElemento = elementos.get(1); // El segundo elemento (0-indexed)
            segundoElemento.click();
        } else {
            System.out.println("No se encontraron suficientes elementos.");
        }
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarOferta() {
        /*modalError(3,btnReintentar,"Click al elemento Reitentar");
        modalError(5,btnReintentar,"Click al elemento Reitentar");
        modalError(3,btnReintentar,"Click al elemento Reitentar");*/

        revisarModalError(driver());

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > div.tdp-container.pt-16 > modal-plan-hogar > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(1);
        buttonSeleccionarOferta.click();
        UtilWeb.waitForSeconds(10);
        //UtilWeb.waitForSeconds(10);
        UtilWeb.waitForSeconds(3);
    }


    public void listaBotones() {
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsVisible(btnLineaNueva, 50);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(5);
    }

    public void datosAgendamiento() {
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
        //driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//         Calendario
        UtilWeb.waitForSeconds(2);
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
        //driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys("956425985");
        UtilWeb.waitForSeconds(8);

    }

    public void botonConfirmarAgendamiento() {
        /*modalError(8,btnReintentar,"Click al elemento Reitentar");
        modalError(8,btnReintentar,"Click al elemento Reitentar");
        modalError(8,btnReintentar,"Click al elemento Reitentar");
        modalError(8,btnReintentar,"Click al elemento Reitentar");*/
        //modalError(10,btnReintentar,"Click al elemento Reitentar");
        //modalError(10,btnReintentar,"Click al elemento Reitentar");

        //String elXpath = "//button[contains(text(),'Confirmar')]";
        //buttonConfirmar
        //Addons.reintentaModalError(driver(), 8, 4, null, this, elXpath);
        revisarModalError(driver());

        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
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
        driver().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(5);
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
        modalError(3, btnReintentar, "Click al elemento Reitentar");
        modalError(2, btnReintentar, "Click al elemento Reitentar");
        modalError(3, btnReintentar, "Click al elemento Reitentar");
        click(btnDescargar);
    }

    public void cambiarPestanaPrincipal() {
        modalError(2, btnReintentar, "Click al elemento Reitentar");
        modalError(1, btnReintentar, "Click al elemento Reitentar");
        modalError(3, btnReintentar, "Click al elemento Reitentar");
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

        //btnRegistrarVenta
        //Addons.reintentaModalError(driver(), 6, 5, null, this, elXpath);
        revisarModalError(driver());

        System.out.println("Entra al primer try");
        try {
            esperaProgresiva(driver(), 2, 5, btnRegistrarVenta);
            click(btnRegistrarVenta);
            System.out.println("Hace click en el boton Registrar Venta");
        } catch (Exception e) {
            System.out.println("Salió del primer try");
            System.out.println("Salta el registrar");
        }

    }

    public void doyClickEnAñadirSVA() {
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsVisible(btnSVA, 5);
        js().scrollElementTop(btnSVA);
        click(btnSVA, 10);
        UtilWeb.waitForSeconds(10);

    }

    public void doyClickEnAgregarBloque(String bloque) {
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
        UtilWeb.waitForSeconds(10);
        WebElement btnbloque = find().getElementByXPath("//*[@class='text' and contains(text(),'" + bloque + "')]//following::tdp-st-checkbox[1]");
        waitUntilElementIsVisible(btnbloque, 10);
        js().scrollElementTop(btnbloque);
        click(btnbloque, 10);
    }

    public void doyClickEnGuardarCambios() {
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
//        modalError(3,btnReintentar,"Click al elemento Reitentar");
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //jse.executeScript("window.scrollBy(0,400)");//250
        UtilWeb.waitForSeconds(1);
        WebElement btnGuardar = find().getElementByXPath("//*[@type='button' and contains(text(),'Guardar')]");
        btnGuardar.click();
        //waitUntilElementIsVisible(btnGuardar, 15);
        //click(btnGuardar);
    }

    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        } else {
            System.out.println("No se encontro el modal error");
        }
    }

    public void modalErrorMultiple(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Reintentar')]")).size() != 0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
            modalErrorMultiple(timeOnSeconds,webElement,message);
        } else {
            System.out.println("No se encontro el modal error");
        }
    }

    public void ingresarDatosAgendamientoParaRUC() {
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
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
        context3.findElement(By.cssSelector("div > div > div > input")).sendKeys("976709704");
        UtilWeb.waitForSeconds(2);

    }

    public void clickValidarRepreLegal() {
        js().scrollElementTop(btnValidaLegal);
        UtilWeb.waitForSeconds(5);
        waitUntilElementIsClickable(btnValidaLegal, 30);
        click(btnValidaLegal);
        UtilWeb.waitForSeconds(4);
    }

    public void clickBotonRegistrarVenta() {
//        UtilWeb.waitForSeconds(20);
        /*modalError(5, btnReintentar, "Click al elemento Reitentar");
        modalError(5, btnReintentar, "Click al elemento Reitentar");
        modalError(5, btnReintentar, "Click al elemento Reitentar");*/
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
                    modalError(15, btnReintentarFinal, "Click al elemento Reitentar");
                    contador++;
                    System.out.println(contador + " vez");
                }
            }
            System.out.println("Sale del while");
            //Thread.sleep(1500);
//            modalError(3, btnReintentar, "Click al elemento Reitentar");
//            modalError(2, btnReintentar, "Click al elemento Reitentar");
//            modalError(3, btnReintentar, "Click al elemento Reitentar");
            //UtilWeb.waitForSeconds(100);
//            modalError(3, btnReintentar, "Click al elemento Reitentar");
//            modalError(3, btnReintentar, "Click al elemento Reitentar");
//            WebElement boton = find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button");
//            waitUntilElementIsVisible(boton, 5000);
            click(btnRegistrarVenta);
            System.out.println("Hace click en el boton Registrar Venta");
//            UtilWeb.waitForSeconds(5);
        } catch (Exception e) {
            System.out.println("Salió del primer try");
            System.out.println("Salta el registrar");
        }


    }
}
