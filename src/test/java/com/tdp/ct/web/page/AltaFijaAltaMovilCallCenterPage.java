package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;

public class AltaFijaAltaMovilCallCenterPage extends WebBase {

    @FindBy(xpath = "//app-root/app-delivery/div[2]/app-steps/div[1]/tdp-st-card[2]/div/div[2]/form/div[12]/div/button")
    protected WebElement btnConfirmarUbicacion;
    @FindBy(xpath = "(//button[@class='button_step'])")
    protected WebElement btnConfirmarDelivery;
    @FindBy(xpath = "(//button[contains(text(),'Confirmar')])[2]")
    protected WebElement btnConfirmar2;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnConsultarCobertura;
    @FindBy(xpath = "//div[@class='contHours']/div/span")
    protected List<WebElement> btnHorario;
    @FindBy(xpath = "//app-register/body/div[2]/form/div[10]/button")
    protected WebElement btnFinalizarRegistro;
    @FindBy(xpath = "(//img[@src='assets/images/icon_glove.svg'])[2]")
    protected WebElement oferta;
    @FindBy(xpath = "//div[@class='stl_plan_valor']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//button[@class='btnCard' and contains(text(),'Ir a movistar total')]")
    protected WebElement btnIrAMovistar;

    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;
    @FindBy(xpath = "(//div[@class='title'])/span")
    protected WebElement paginaResumen;
    @FindBy(xpath = "//h1[contains(text(),'datos solicitados')]")
    protected WebElement completaDatosSolicitados;
    @FindBy(xpath = "//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;
    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;
    @FindBy(xpath = "//*[@formcontrolname='deliveryType']")
    protected WebElement deliveryType;
    @FindBy(xpath = "//*[@formcontrolname='medioPago']")
    protected WebElement pageType;

    public void manzana(String manzana) {
        if (manzana != null) {
            bloque(manzana);
/*            WebElement Mz = find().getElementByXPath("//*[@formcontrolname='block' or @name='block']");
            esperaProgresiva(driver(), 3, 5, Mz);
                click(Mz, 5);
                Mz.sendKeys(Keys.CONTROL + "a");
                Mz.sendKeys(Keys.DELETE);
                type(Mz, manzana);
            */

        }

    }

    public void lote(String lote) {
        if (lote != null) {
            /*UtilWeb.waitForSeconds(4);
            WebElement Lte = find().getElementByXPath("//*[@formcontrolname='lot' or @name='lot']");
            esperaProgresiva(driver(), 3, 5, Lte);
            click(Lte);
            Lte.sendKeys(Keys.CONTROL + "a");
            Lte.sendKeys(Keys.DELETE);
            type(Lte, lote);*/
        }
    }

    public void tipoVivienda(String tipoVivienda) {
        if (tipoVivienda != null) {
            UtilWeb.waitForSeconds(1);
            WebElement listElementPLan = find().getElementByXPath("//*[@formcontrolname='houseType']");
            esperaProgresiva(driver(), 3, 5, listElementPLan);
            waitUntilElementIsClickable(listElementPLan, 10).click();

            String[][] selectOptions = {
                    {"BLK", "BLOCK"},
                    {"CC", "CENTRO COMERCIAL"},
                    {"CASA", "CASA"},
                    {"ED", "EDIFICIO"},
                    {"MCDO", "MERCADO"}
            };
            String sCodeTipoVivienda = buscarValorOpcion(tipoVivienda.toUpperCase().trim(), selectOptions);
            UtilWeb.waitForSeconds(2);
            seleccionarValueComboShadow(driver(), "houseType", sCodeTipoVivienda);

        }
    }

    public void nombreVivienda(String nomVivienda) {
        if (nomVivienda != null) {
            WebElement Nvivienda = find().getElementByXPath("//*[@formcontrolname='houseName' or @name='houseName']");
            esperaProgresiva(driver(), 3, 5, Nvivienda);
            waitUntilElementIsClickable(Nvivienda, 15).click();
            type(Nvivienda, nomVivienda);
        }
    }

    public void bloque(String bloque) {
        if (bloque != null) {
            WebElement Nbloque = find().getElementByXPath("//*[@formcontrolname='block' or @name='block']");
            esperaProgresiva(driver(), 3, 5, Nbloque);
            waitUntilElementIsClickable(Nbloque, 15).click();
            type(Nbloque, bloque);

        }
    }

    public void piso(String piso) {
        if (piso != null) {
            WebElement Npiso = find().getElementByXPath("//*[@formcontrolname='floor' or @name='floor']");
            esperaProgresiva(driver(), 3, 5, Npiso);
            waitUntilElementIsClickable(Npiso, 15).click();
            Npiso.sendKeys(Keys.CONTROL + "a");
            Npiso.sendKeys(Keys.DELETE);
            type(Npiso, piso);
        }
    }

    public void interior(String inte) {
        if (inte != null) {
            WebElement NInterior = find().getElementByXPath("//*[@formcontrolname='inside' or @name='inside']");
            esperaProgresiva(driver(), 3, 5, NInterior);
            waitUntilElementIsClickable(NInterior, 15).click();
            type(NInterior, inte);
        }
    }

    public void tipoConjuntoHabitacional(String tipoConjunto) {
        if (tipoConjunto != null) {
            JavascriptExecutor jse = (JavascriptExecutor) driver();
            UtilWeb.waitForSeconds(1);
            WebElement listElementPLan = find().getElementByXPath("//*[@formcontrolname='housingComplexe']");
            esperaProgresiva(driver(), 3, 5, listElementPLan);
            waitUntilElementIsClickable(listElementPLan, 10).click();

            String[][] selectOptions = {
                    {"UR", "URBANIZACION RESIDENCIAL"},
                    {"UP", "URBANIZACION POPULAR"}
            };
            String sCodigo = buscarValorOpcion(tipoConjunto, selectOptions);
            seleccionarValueComboShadow(driver(), "housingComplexe", sCodigo);

        }
    }

    public void conjuntoHabitacional(String hab) {
        if (hab != null) {
            WebElement ConjHab = find().getElementByXPath("//*[@formcontrolname='housingComplexName' or @name='housingComplexName']");
            esperaProgresiva(driver(), 3, 5, ConjHab);
            js().scrollElementTop(ConjHab);
            click(ConjHab);
            ConjHab.sendKeys(Keys.CONTROL + "a");
            ConjHab.sendKeys(Keys.DELETE);
            type(ConjHab, hab);
        }
    }


    public void btnConsultarCobertura() {
        esperaProgresiva(driver(), 5, 3, btnConsultarCobertura);
        js().scrollElementTop(btnConsultarCobertura);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultarCobertura);
        btnConsultarCobertura.click();
    }

    public void btnConsultarCoberturaNueva() {
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(btnConsultarCobertura);
        btnConsultarCobertura.click();
    }

    public void btnConfirmarUbicacion() {
        esperaProgresiva(driver(), 5, 5, btnConfirmarUbicacion);
        btnConfirmarUbicacion.click();
    }

    public void tipoEntrega(String tipEntrega) {
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 3, 5, "loadingCard");
        esperaProgresiva(driver(), 3, 5, deliveryType);
        scrollDown();
        click(deliveryType);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan = sh().getContext(deliveryType);

        String[][] deliveryOptions = {
                {"Express", "Delivery Express"},
                {"R24h", "Delivery Regular 24 horas"},
                {"R48h", "Delivery Regular 48 horas"},
                {"R72h", "Delivery Regular 72 horas"}
        };
        String sCodigo = buscarValorOpcion(tipEntrega, deliveryOptions);
        seleccionarValueComboShadow(driver(), "deliveryType", sCodigo);

    }

    public void btnHorario(String horario) {
        clickElementInAList(btnHorario, horario);
        UtilWeb.waitForSeconds(5);
    }

    public void txtTelefono(String telefono) {
        WebElement txtTel = find().getElementByXPath("(//tdp-st-input-text)[1]");
        esperaProgresiva(driver(), 3, 5, txtTel);
        click(txtTel);
        type(txtTel, telefono);
    }

    public void txtInstrucciones(String instrucciones) {
        WebElement txtInstr = find().getElementByXPath("(//tdp-st-input-text)[2]");
        esperaProgresiva(driver(), 5, 5, txtInstr);
        click(txtInstr);
        type(txtInstr, instrucciones);
    }

    public void btnConfirmarDelivery() {
        esperaProgresiva(driver(), 3, 5, btnConfirmarDelivery);
        click(btnConfirmarDelivery, 5);
    }

    public void tipoPago(String tipoPago) {
//        WebElement listElementPLan = find().getElementByXPath("(//tdp-st-select)[3]");
        esperaProgresiva(driver(), 3, 5, pageType);
//        listElementPLan = find().getElementByXPath("(//tdp-st-select)[3]");
        click(pageType);
        String[][] selectOptions = {
                {"1", "Contra entrega"},
                {"2", "Pago Efectivo"}
        };
        String sCodigoValue = buscarValorOpcion(tipoPago, selectOptions);
        UtilWeb.waitForSeconds(2);
        seleccionarValueComboShadow(driver(), "medioPago", sCodigoValue);
    }

    @FindBy(xpath = "//body/div[2]/form/div[1]/h1")
    protected WebElement esperarCorreo;

    public void correo(String correo) {
        this.scrollDown();
        revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 3;
        while (!buttonFound && contador <= reintentoBucles) {
            System.out.println("Entra al while");
            try {
                System.out.println("Entra al try");
                waitUntilElementIsVisible(esperarCorreo, 2);
                buttonFound = true;
            } catch (Exception e) {
                System.out.println("Entra al catch");
                UtilWeb.waitForSeconds(6);
                contador++;
                System.out.println(contador + " vez");
            }
        }
        System.out.println("Sale del while");
        WebElement correoElectronico = find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[1]/tdp-st-input-text");
        waitUntilElementIsVisible(correoElectronico, 10);
        click(correoElectronico);
        correoElectronico.sendKeys(Keys.CONTROL + "a");
        correoElectronico.sendKeys(Keys.DELETE);
        type(correoElectronico, correo);
        System.out.println("Se escribió el correo");
        UtilWeb.waitForSeconds(1);

//        UtilWeb.waitForSeconds(30);//10
//        waitUntilElementIsVisible(esperarCorreo, 50);
//        UtilWeb.waitForSeconds(3);
//        WebElement correoElectronico = find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[1]/tdp-st-input-text");
//        click(correoElectronico);
//        correoElectronico.sendKeys(Keys.CONTROL + "a");
//        correoElectronico.sendKeys(Keys.DELETE);
//        type(correoElectronico, correo);
//        UtilWeb.waitForSeconds(1);
    }

    public void confirmarCorreo(String correo) {
        WebElement correoElectronico = find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[2]/tdp-st-input-text");
        esperaProgresiva(driver(), 3, 5, correoElectronico);
        click(correoElectronico);
        correoElectronico.sendKeys(Keys.CONTROL + "a");
        correoElectronico.sendKeys(Keys.DELETE);
        type(correoElectronico, correo);
        UtilWeb.waitForSeconds(1);
    }


    public void btnConfirmar2() {
        esperaProgresiva(driver(), 3, 5, btnConfirmar2);
        click(btnConfirmar2, 5);
        UtilWeb.waitForSeconds(4);
    }

    public void btnFinalizarRegistro() {
        revisarModalError(driver());
        waitUntilElementIsVisible(btnFinalizarRegistro, 30);
        UtilWeb.waitForSeconds(120);
        click(btnFinalizarRegistro, 10);
        UtilWeb.waitForSeconds(2);
    }

    public void scrollDown() {
        UtilWeb.waitForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void scrollUp() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(2);//10
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void oferta() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 10, oferta);
        click(oferta);
        UtilWeb.waitForSeconds(5);
    }

    public void listaOfertas(String planOfertas) {
        UtilWeb.waitForSeconds(4);
        String ofertaEsperada = planOfertas.trim().toUpperCase();
        System.out.println("cantidad de la lista : " + listaOfertas.size());
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        /*for (WebElement element : listaOfertas) {
            System.out.println("lista de ofertas" + element.getText());
            if (element.getText().contains(planOfertas)) {
                click(element);
            }
        }*/
        Addons.esperaProgresiva(driver(), 3, 3, listaOfertas.get(0));

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                System.out.println("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            if (i == 0) {
                boolean retrocede = true;
                do {
                    boolean elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).size() != 0;
                    if (elementoExistente) {
                        WebElement btnLeft = find().getElementByXPath("//img[@src='assets/images/left-arrow.png']");
                        btnLeft.click();
                        UtilWeb.waitForSeconds(2);
                    } else {
                        retrocede = false;
                    }
                } while (retrocede);
            }

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
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarOferta() {
        revisarModalError(driver());

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-offer-mt > app-mt-change-plan-modal > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(3);
        buttonSeleccionarOferta.click();
    }

    public void irAMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 10, btnIrAMovistar);
        btnIrAMovistar.click();
        UtilWeb.waitForSeconds(5);
    }


}
