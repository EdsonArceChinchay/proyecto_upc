package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;

public class AddressPage extends WebBase {
    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[3]/div/div/div[3]")
    protected WebElement direccionSugerida;
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
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Consultar cobertura') or contains(@class,'button')  and contains(text(),'Consultar cobertura') ]")
    protected WebElement btnConsultCoverage;
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Consultar ubicación') or contains(@class,'button') and contains(text(),'Consultar ubicación')]")
    protected WebElement btnConsultLocation;
    @FindBy(xpath = "//span[contains(text(),'Lugar de')]")
    protected WebElement titleLugarInstalacion;
    @FindBy(xpath = "//div[@class='_title' and contains(text(), 'DE ENTREGA')]")
    protected WebElement titleLugarInstalacionEntrega;
    @FindBy(xpath = "//h4[contains(text(), 'Verifica la')]")
    protected WebElement titleVerificarLugarInstalacion;
    @FindBy(xpath = "(//*[@formcontrolname='longitude'])[1]")
    protected WebElement txtX;
    @FindBy(xpath = "(//*[@formcontrolname='latitude'])[1]")
    protected WebElement txtY;
    @FindBy(xpath = "//*[@formcontrolname='direction' or contains(@class,'text-adress-info')]")
    protected WebElement txtDireccion;
    @FindBy(xpath = "//mat-dialog-content//p[contains(@class,'modal-description')]")
    protected WebElement txtMsjError;
    @FindBy(xpath = "//button[contains(text(),'Aceptar')]")
    protected WebElement btnerror;
    private static final String DEPARTAMENTO = "15";

    public void seleccionarDepa(String tipoDepa) {
        UtilWeb.waitForSeconds(6);//2
        WebElement depaList = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
        esperaProgresiva(driver(), 5, 5, depaList);

        boolean existeLista = depaList.isEnabled();
        System.out.println("Existe Lista de" + depaList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            depaList = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
            UtilWeb.waitForSeconds(4);
        }
        click(depaList);
        UtilWeb.waitForSeconds(2);
        By byItem = By.cssSelector("[data-value='" + tipoDepa + "']");
        SearchContext context = sh().getContext(depaList);
        esperaProgresiva(driver(), 3, 5, depaList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarProvincia(String tipoProvincia) {
        WebElement provinciaList = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        esperaProgresiva(driver(), 3, 5, provinciaList);
        boolean existeLista = provinciaList.isEnabled();
        System.out.println("Existe Lista de" + provinciaList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            seleccionarDepa(DEPARTAMENTO);
            provinciaList = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        }
        click(provinciaList);
        UtilWeb.waitForSeconds(10);
        SearchContext context = sh().getContext(provinciaList);
        By byItem = By.cssSelector("[data-value='" + tipoProvincia + "']");
        esperaProgresiva(driver(), 3, 5, provinciaList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarDistrito(String tipoDistrito) {
        String PROVINCIA = "1501";
        WebElement distritoList = find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        esperaProgresiva(driver(), 3, 5, distritoList);
        boolean existeLista = distritoList.isEnabled();
        System.out.println("Existe Lista de" + distritoList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            seleccionarDepa(DEPARTAMENTO);
            seleccionarProvincia(PROVINCIA);
            distritoList = find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        }
        click(distritoList);
        UtilWeb.waitForSeconds(2);
        SearchContext context = sh().getContext(distritoList);
        By byItem = By.cssSelector("[data-value='" + tipoDistrito + "']");
        esperaProgresiva(driver(), 3, 5, distritoList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void writeDireccion(String direc) {
        WebElement inputDireccion = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(4) > div > tdp-st-input-text");
        click(inputDireccion);
        type(inputDireccion, direc);
    }

    public void writeReferencia(String referencia) {
        WebElement Refer = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(5) > div > tdp-st-input-text");
        click(Refer);
        type(Refer, referencia);
    }

    public void clickButtonConsultLocation() {
        esperaProgresiva(driver(), 5, 5, btnConsultLocation);
        js().scrollElementTop(btnConsultLocation);
        click(btnConsultLocation);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Consult Location" );
        revisarModalError(driver());
        UtilWeb.waitForSeconds(5);
    }

    public void writeManzana(String manzana) {
        UtilWeb.waitForSeconds(1);
        WebElement Mz = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(1) > tdp-st-input-text");
        click(Mz);
        UtilWeb.waitForSeconds(1);
        type(Mz, manzana);
    }

    public void manzana(String manzana) {
        if (manzana != null) {
            bloque(manzana);
        }
    }

    public void writeLote(String lote) {
        WebElement Lte = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(2) > tdp-st-input-text");
        click(Lte);
        type(Lte, lote);
    }

    public void lote(String lote) {
        boolean existe = validateInputAndLocator(lote, inputLot);
        if (existe && inputLot.isSelected()) {
            esperaProgresiva(driver(), 3, 5, inputLot);
            click(inputLot);
            type(inputLot, lote);
        }
    }

    public void writePiso(String piso) {
        WebElement Npiso = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(1) > tdp-st-input-text");
        click(Npiso);
        type(Npiso, piso);
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

    public void writeInterior(String inte) {
        WebElement NInterior = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(2) > tdp-st-input-text");
        click(NInterior);
        type(NInterior, inte);
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
    public void seleccionarConjuntoHabitacional(String tipoConjunto) {
        WebElement conjuntoList = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(6) > div > tdp-st-select");
        click(conjuntoList);
        SearchContext context = sh().getContext(conjuntoList);
        By byItem = By.cssSelector("[data-value='" + tipoConjunto + "']");
        esperaProgresiva(driver(), 3, 5, conjuntoList, byItem, context);
        context.findElement(byItem).click();
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

    public void writeConjHab(String hab) {
        WebElement ConjHab = find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(7) > div > tdp-st-input-text");
        click(ConjHab);
        type(ConjHab, hab);
    }

    public void seleccionoDireccionSugerida() {
        UtilWeb.waitForSeconds(3);
        click(direccionSugerida);
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

    public void clickButtonConsultCoverage() {
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        js().scrollElementTop(btnConsultCoverage);
        btnConsultCoverage.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Consultar Cobertura" );
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

    public boolean validarPantallaIngresarDireccionEntrega() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 4, titleLugarInstalacionEntrega);
        revisarModalError(driver());
        boolean existe = waitUntilElementIsVisible(titleLugarInstalacionEntrega, 30).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Lugar de instalacion >>> {0}", existe);
        return existe;
    }

    public boolean validarPantallaIngresarDireccion() {
        //esperaProgresiva(driver(),3,20,titleLugarInstalacion);
        boolean existe = waitUntilElementIsVisible(titleLugarInstalacion, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Lugar de instalacion >>> {0}", existe);
        return existe;
    }

    public boolean validarPantallaVerificarDireccion() {
        esperaProgresiva(driver(), 6, 4, titleVerificarLugarInstalacion);
        boolean existe = waitUntilElementIsVisible(titleVerificarLugarInstalacion, 30).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de Verificar Lugar de instalacion >>> {0}", existe);
        return existe;
    }

    public void scrollDirecCompleta() {
        js().scrollElementTop(find().getElementByCss("div.info-user"));
        UtilWeb.waitForSeconds(3);
    }

    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        type(txtX, x.trim());
        UtilWeb.waitForSeconds(1);
        type(txtY, y.trim());
        UtilWeb.waitForSeconds(5);
    }

    public void validoQueLaDireccionSea(String direccion) {
        waitUntilElementIsVisible(txtDireccion,50);
        String direccionObtenida = txtDireccion.getText().trim().toUpperCase();
        String direccionEsperada = direccion.trim().toUpperCase();
        Assertions.assertTrue(direccionObtenida.contains(direccionEsperada), "La direccion esperada: " + direccionEsperada + ", es diferente a la obtenida: " + direccionObtenida);

    }

    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        waitUntilElementIsVisible(txtMsjError, 100);
        String mensajeObtenido = txtMsjError.getText().trim().toUpperCase();
        String mensajeEsperado = msj.trim().toUpperCase();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado), "El mensaje esperado: " + mensajeEsperado + ", es diferente a la obtenido: " + mensajeObtenido);
        UtilWeb.waitForSeconds(1);
    }

    public void doyClickAceptarEnElModalDeError() {
        waitUntilElementIsClickable(btnerror, 25).click();
    }

}

