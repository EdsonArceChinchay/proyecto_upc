package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @FindBy(xpath = "(//img[@src='assets/images/icon_glove.svg'])[1]")
    protected WebElement ofertaUno;
    @FindBy(xpath = "//*[@class='stl_plan_valor' or @class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//div[@class='offer-option-title']/div[@class='general-title' and contains(text(), 'Seleccione un')]")
    protected WebElement elementoSeleccionar;
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

    @FindBy(xpath = "//img[@src='assets/images/left-arrow.png']")
    protected WebElement btnLeft;

    @FindBy(xpath = "//*[@formcontrolname='lot' or @name='lot']")
    protected WebElement inputLot;
    @FindBy(xpath = "//*[@formcontrolname='houseType']")
    protected WebElement inputHouseType;
    @FindBy(xpath = "//*[@formcontrolname='houseName' or @name='houseName']")
    protected WebElement inputHouseName;
    @FindBy(xpath = "//*[@formcontrolname='block' or @name='block']")
    protected WebElement inputBlock;

    @FindBy(xpath = "//*[@formcontrolname='apple' or @name='apple']")
    protected WebElement inputApple;


    public void manzana(String manzana) {
        if (manzana != null) {
            bloque(manzana);
        }
    }

    public void lote(String lote) {
        boolean existe = validateInputAndLocator(lote, inputLot);
        if (existe && inputLot.isSelected()) {
            esperaProgresiva(driver(), 3, 5, inputLot);
            click(inputLot);
            type(inputLot, lote);
        }
    }

    public void tipoVivienda(String tipoVivienda) {
        boolean existe = validateInputAndLocator(tipoVivienda, inputHouseType);
        if (existe) {
            waitUntilElementIsClickable(inputHouseType, 10).click();
            String[][] selectOptions = {{"BLK", "BLOCK"}, {"CC", "CENTRO COMERCIAL"}, {"CASA", "CASA"}, {"ED", "EDIFICIO"}, {"MCDO", "MERCADO"}};
            String sCodeTipoVivienda = buscarValorOpcion(tipoVivienda.toUpperCase().trim(), selectOptions);
            UtilWeb.waitForSeconds(2);
            seleccionarValueComboShadow(driver(), "houseType", sCodeTipoVivienda);
        }
    }

    public void nombreVivienda(String nomVivienda) {
        boolean existe = validateInputAndLocator(nomVivienda, inputHouseName);
        if (existe) {
            waitUntilElementIsClickable(inputHouseName, 15).click();
            type(inputHouseName, nomVivienda);
        }

    }

    public void bloque(String bloque) {
        boolean existe = validateInputAndLocator(bloque, inputBlock);
        if (existe) {
          //  js().scrollElementTop(inputBlock);
            System.out.println("Ingreso a bloque si");
            waitUntilElementIsClickable(inputBlock, 15).click();
            inputBlock.sendKeys(Keys.CONTROL + "a");
            inputBlock.sendKeys(Keys.DELETE);
            type(inputBlock, bloque);
        }
       /* (bloque != null) {
            WebElement NBloque = find().getElementByXPath("//*[@formcontrolname='block' or @name='block']");
            esperaProgresiva(driver(), 3, 5, NBloque);
            waitUntilElementIsClickable(NBloque, 15).click();
            NBloque.sendKeys(Keys.CONTROL + "a");
            NBloque.sendKeys(Keys.DELETE);
            type(NBloque, bloque);
        }*/


    }

    public void manzanaDir(String manzana) {
        boolean existe = validateInputAndLocator(manzana, inputApple);
        if (existe && inputApple.isSelected()) {
            waitUntilElementIsClickable(inputApple, 15).click();
            type(inputApple, manzana);
        }
    }

    public void piso(String piso) {
        if (piso != null) {
            WebElement Npiso = find().getElementByXPath("//*[@formcontrolname='floor' or @name='floor']");
            esperaProgresiva(driver(), 5, 6, Npiso);
            waitUntilElementIsClickable(Npiso, 30).click();
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
            NInterior.sendKeys(Keys.CONTROL + "a");
            NInterior.sendKeys(Keys.DELETE);
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

            String[][] selectOptions = {{"UR", "URBANIZACION RESIDENCIAL"}, {"UP", "URBANIZACION POPULAR"}};
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
        esperaProgresiva(driver(), 5, 5, btnConsultarCobertura);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultarCobertura);
        js().scrollElementTop(btnConsultarCobertura);
        btnConsultarCobertura.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Consultar Cobertura" );

    }

    public void btnConfirmarUbicacion() {
        esperaProgresiva(driver(), 5, 5, btnConfirmarUbicacion);
        btnConfirmarUbicacion.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Confirmar Ubicacion" );

    }

    public void tipoEntrega(String tipEntrega) {
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 4, 5, "loadingCard");
        esperaProgresiva(driver(), 4, 6, deliveryType);
        scrollDown();
        click(deliveryType);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan = sh().getContext(deliveryType);

        String[][] deliveryOptions = {{"Express", "Delivery Express"}, {"R24h", "Delivery Regular 24 horas"}, {"R48h", "Delivery Regular 48 horas"}, {"R72h", "Delivery Regular 72 horas"}};
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
        esperaProgresiva(driver(), 5, 6, pageType);
        UtilWeb.waitForSeconds(2);
        try {
            click(pageType);
            String[][] selectOptions = {{"1", "Contra entrega"}, {"2", "Pago Efectivo"}};
            String sCodigoValue = buscarValorOpcion(tipoPago, selectOptions);
            UtilWeb.waitForSeconds(2);
            seleccionarValueComboShadow(driver(), "medioPago", sCodigoValue);
        } catch (NoSuchElementException nsee) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El elemento pageType no fue encontrado: " + nsee.getMessage());
        }
    }

    @FindBy(xpath = "//body/div[2]/form/div[1]/h1")
    protected WebElement esperarCorreo;

    public void correo(String correo) {
        this.scrollDown();
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 3, 5, "loadingCard");
        revisarModalError(driver());
        boolean buttonFound = false;
        int contador = 0;
        int reintentoBucles = 3;
        while (!buttonFound && contador <= reintentoBucles) {
            System.out.println("Entra al while");
            try {
                System.out.println("Entra al try");
                revisarModalError(driver());
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
        UtilWeb.waitForSeconds(10);//10
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
        revisarModalError(driver());
    }

    public void oferta() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 5, oferta);
        revisarModalError(driver());
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
        click(oferta);
        UtilWeb.waitForSeconds(2);
    }

    public void ofertaUno() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 4, ofertaUno);
        revisarModalError(driver());
        click(ofertaUno);
        UtilWeb.waitForSeconds(2);
    }

    public void listaOfertas(String planOfertas, ManageScenario scenario) {

        String expectedOffer = planOfertas.trim().toUpperCase();
        esperaProgresiva(driver(), 5, 2, elementoSeleccionar);

        boolean elementoExistenteRight;
        boolean elementoExistenteleft;
        elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
        int contador = 0;
        int contadorMax = 12;
        while (elementoExistenteRight && contador < contadorMax) {
            if (btnRight != null) {
                esperaProgresiva(driver(), 4, 3, btnRight);
                btnRight.click();
                System.out.println("dio click right while");
            } else {
                System.out.println("El elemento btnRight no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnRight, 5);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Se muestra el btnRight");
            } catch (Exception e) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "El elemento btnRight ya no fue encontrado: ");
            }
            elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            contador++;
        }
        UtilWeb.waitForSeconds(2);
        contador = 0;
        elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
        while (elementoExistenteleft && contador < contadorMax) {
            if (btnLeft != null) {
                waitUntilElementIsClickable(btnLeft, 8).click();

                System.out.println("dio click left while");
            } else {
                System.out.println("El elemento btnleft no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnLeft, 5);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Se muestra el btnLeft");
            } catch (Exception e) {
                System.out.println("El elemento btnLeft ya no fue encontrado: ");
            }
            elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
            contador++;
        }

        System.out.println("Ofertas : " + listaOfertas.size());
        int cont = listaOfertas.size() - 1;
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {

            String currentOffer =listaOfertas.get(i).getText().trim().toUpperCase();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Offer: " + i + " " + currentOffer );
            if (!encontroElemento && currentOffer.contains(expectedOffer)) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Offer: " + i + " " + currentOffer );
                encontroElemento = true;
                UtilWeb.waitForSeconds(1);
                click(listaOfertas.get(i));
            }

            if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20 || i == 23 || i == 26 || i == 29 || i == 32 || i == 35 || i == 38) {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Offer: " + i + " " + currentOffer );

                scenario.printFullView();
                js().scrollElementTop(buttonSeleccionarOferta);
                scenario.printFullView();
                js().scrollElementTop(listaOfertas.get(i));
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }

            if (!encontroElemento && (i == cont || listaOfertas.get(i + 1).getText().trim().equals(""))) {
                System.out.println("No encontro elemento en la lista");
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
        }

        UtilWeb.waitForSeconds(1);
    }
    
    public void irAMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 10, btnIrAMovistar);
        btnIrAMovistar.click();
        UtilWeb.waitForSeconds(5);
    }

    public Boolean validateInputAndLocator(String input, WebElement element) {
        boolean existe = false;
        if (input != null) {
            try {
                existe = element.isDisplayed() && element.isEnabled();
            } catch (NoSuchElementException e) {
                e.getMessage();
            }
        }
        return existe;
    }

}
