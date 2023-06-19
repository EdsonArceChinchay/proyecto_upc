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
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;
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

    public void manzana(String manzana) {

        WebElement Mz = find().getElementByXPath("(//div[@class='_col'])[1]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,Mz);
        click(Mz, 5);
        UtilWeb.waitForSeconds(1);
        type(Mz, manzana);
    }

    public void lote(String lote) {
        UtilWeb.waitForSeconds(4);
        WebElement Lte = find().getElementByXPath("(//div[@class='_col'])[2]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,Lte);
        click(Lte);
        Lte.sendKeys(Keys.CONTROL + "a");
        Lte.sendKeys(Keys.DELETE);
        type(Lte, lote);
    }

    public void tipoVivienda(String tipoVivienda) {
        //UtilWeb.waitForSeconds(4);
        UtilWeb.waitForSeconds(1);
        WebElement listElementPLan = find().getElementByXPath("//*[@formcontrolname='houseType']");
        esperaProgresiva(driver(),3,5,listElementPLan);
        waitUntilElementIsClickable(listElementPLan, 10).click();

        String[][] selectOptions = {
                {"ED", "EDIFICIO"},
                {"CC", "CENTRO COMERCIAL"}
        };
        String sCodeTipoVivienda= buscarValorOpcion(tipoVivienda,selectOptions);
        UtilWeb.waitForSeconds(2);
        seleccionarValueComboShadow(driver(), "houseType",sCodeTipoVivienda);

    }

    public void nombreVivienda(String nomVivienda) {
        WebElement Nvivienda = find().getElementByXPath("(//div[@class='tdp-col-12'])[7]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,Nvivienda);
        waitUntilElementIsClickable(Nvivienda, 15).click();
        type(Nvivienda, nomVivienda);
    }

    public void piso(String piso) {
        WebElement Npiso = find().getElementByXPath("(//div[@class='_col'])[3]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,Npiso);
        waitUntilElementIsClickable(Npiso, 15).click();
        type(Npiso, piso);
    }

    public void interior(String inte) {
        WebElement NInterior = find().getElementByXPath("(//div[@class='_col'])[4]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,NInterior);
        waitUntilElementIsClickable(NInterior, 15).click();
        type(NInterior, inte);
    }

    public void tipoConjuntoHabitacional(String tipoConjunto) {
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        UtilWeb.waitForSeconds(1);
        WebElement listElementPLan = find().getElementByXPath("//*[@formcontrolname='housingComplexe']");
        esperaProgresiva(driver(),3,5,listElementPLan);
        waitUntilElementIsClickable(listElementPLan, 10).click();

        String[][] selectOptions = {
                {"UR", "URBANIZACION RESIDENCIAL"},
                {"UP", "URBANIZACION POPULAR"}
        };
        String sCodigo= buscarValorOpcion(tipoConjunto,selectOptions);
        seleccionarValueComboShadow(driver(),"housingComplexe",sCodigo );


    }

    public void conjuntoHabitacional(String hab) {
        //UtilWeb.waitForSeconds(2);
        WebElement ConjHab = find().getElementByXPath("(//div[@class='tdp-col-12'])[9]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,ConjHab);
        js().scrollElementTop(ConjHab);
        click(ConjHab);
//        clear(ConjHab);
        type(ConjHab, hab);
    }


    public void btnConsultarCobertura() {
       // UtilWeb.waitForSeconds(3);
        esperaProgresiva(driver(),5,3,btnConsultarCobertura);
        js().scrollElementTop(btnConsultarCobertura);
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        revisarModalError(driver());
        esperaProgresiva(driver(),5,5,btnConsultarCobertura);
        btnConsultarCobertura.click();
        //waitUntilElementIsVisible(btnConsultarCobertura, 100).click();//100
        //UtilWeb.waitForSeconds(20);
    }

    public void btnConfirmarUbicacion() {
        //UtilWeb.waitForSeconds(8);//5
        esperaProgresiva(driver(),5,5,btnConfirmarUbicacion);
        btnConfirmarUbicacion.click();
        //waitUntilElementIsVisible(btnConfirmarUbicacion, 150).click();
       // UtilWeb.waitForSeconds(15);
    }

    public void tipoEntrega(String tipEntrega) {
        scrollDown();
        revisarModalError(driver());
        WebElement listElementPLan = find().getElementByXPath("//*[@formcontrolname='deliveryType']"); //"(//tdp-st-select)[1]");
        esperaProgresiva(driver(),3,5,listElementPLan);
        esperaProgresivaLoading(driver(),3,5,"loadingCard");
        waitUntilElementIsClickable(listElementPLan, 5);
        listElementPLan = find().getElementByXPath("//*[@formcontrolname='deliveryType']"); //"(//tdp-st-select)[1]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan = sh().getContext(listElementPLan);

        String[][] deliveryOptions = {
                {"Express", "Delivery Express"},
                {"R24h", "Delivery Regular 24 horas"},
                {"R48h", "Delivery Regular 48 horas"},
                {"R72h", "Delivery Regular 72 horas"}
        };
        String sCodigo= buscarValorOpcion(tipEntrega,deliveryOptions);
        seleccionarValueComboShadow(driver(),"deliveryType",sCodigo );

    }

    public void btnHorario(String horario) {
        clickElementInAList(btnHorario, horario);
        UtilWeb.waitForSeconds(5);
    }

    public void txtTelefono(String telefono) {
        WebElement txtTel = find().getElementByXPath("(//tdp-st-input-text)[1]");
        esperaProgresiva(driver(),3,5,txtTel);
        click(txtTel);
        type(txtTel, telefono);
    }

    public void txtInstrucciones(String instrucciones) {
        WebElement txtInstr = find().getElementByXPath("(//tdp-st-input-text)[2]");
        esperaProgresiva(driver(),5,5,txtInstr);
        click(txtInstr);
        type(txtInstr, instrucciones);
    }

    public void btnConfirmarDelivery() {
        esperaProgresiva(driver(),3,5,btnConfirmarDelivery);
        click(btnConfirmarDelivery, 5);
        //UtilWeb.waitForSeconds(8);
    }

    public void tipoPago(String tipoPago) {
        //UtilWeb.waitForSeconds(4);//
        WebElement listElementPLan = find().getElementByXPath("(//tdp-st-select)[3]");
        esperaProgresiva(driver(),3,5,listElementPLan);
        listElementPLan = find().getElementByXPath("(//tdp-st-select)[3]");
        click(listElementPLan);

        //UtilWeb.waitForSeconds(300); //QUITAR
        String[][] selectOptions = {
                {"1", "Contra entrega"},
                {"2", "xxx2"}
        };
        String sCodigoValue= buscarValorOpcion(tipoPago,selectOptions);
        UtilWeb.waitForSeconds(2);
        seleccionarValueComboShadow(driver(), "medioPago",sCodigoValue);
    }

    @FindBy(xpath = "//body/div[2]/form/div[1]/h1")
    protected WebElement esperarCorreo;

    public void correo(String correo) {
        //modalError(5, btnReintentar, "Click al elemento Reitentar");
        //modalError(5, btnReintentar, "Click al elemento Reitentar");
        //modalError(5, btnReintentar, "Click al elemento Reitentar");
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
        //UtilWeb.waitForSeconds(4);//
        WebElement correoElectronico = find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[2]/tdp-st-input-text");
        esperaProgresiva(driver(),3,5,correoElectronico);
        click(correoElectronico);
        correoElectronico.sendKeys(Keys.CONTROL + "a");
        correoElectronico.sendKeys(Keys.DELETE);
        type(correoElectronico, correo);
        UtilWeb.waitForSeconds(1);
    }


    public void btnConfirmar2() {
        esperaProgresiva(driver(),3,5,btnConfirmar2);
        click(btnConfirmar2, 5);
        UtilWeb.waitForSeconds(4);
    }

    public void btnFinalizarRegistro() {
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        revisarModalError(driver());
        waitUntilElementIsVisible(btnFinalizarRegistro, 30);
        UtilWeb.waitForSeconds(120);
        click(btnFinalizarRegistro, 10);
        UtilWeb.waitForSeconds(2);
    }
    public void scrollDown(){
        UtilWeb.waitForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }
    public void scrollUp() {
        //modalError(8, btnReintentar, "Click al elemento Reintentar");
        //modalError(8, btnReintentar, "Click al elemento Reintentar");
        //modalError(8, btnReintentar, "Click al elemento Reintentar");
        //modalError(7, btnReintentar, "Click al elemento Reintentar");

        revisarModalError(driver());

        UtilWeb.waitForSeconds(2);//10
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,150)");
    }

    public void oferta() {
        revisarModalError(driver());
        //modalError(8,btnReintentar,"Click al elemento Reitentar");
        //modalError(8,btnReintentar,"Click al elemento Reitentar");
        esperaProgresiva(driver(),5, 10, oferta);
        click(oferta);
        //waitUntilElementIsClickable(oferta, 100).click();
        UtilWeb.waitForSeconds(5);//
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

        /*modalError(3,btnReintentar,"Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");*/
        revisarModalError(driver());

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-offer-mt > app-mt-change-plan-modal > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(3);
        buttonSeleccionarOferta.click();
    }

    public void irAMovistarTotal() {
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
        //modalError(3,btnReintentar,"Click al elemento Reitentar");
        //modalError(3, btnReintentar, "Click al elemento Reitentar");
        revisarModalError(driver());
        waitUntilElementIsVisible(botoneraIrA.get(1), 10).click();
        UtilWeb.waitForSeconds(3);
    }


}
