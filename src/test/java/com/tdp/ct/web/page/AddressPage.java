package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Helper.*;

public class AddressPage extends WebBase {
    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[3]/div/div/div[3]")
    protected WebElement direccionSugerida;
    @FindBy(xpath = "//*[contains(@class,'ng-valid') and @formcontrolname='lot' or contains(@class,'ng-valid') and @name='lot']")
    protected WebElement inputLot;
    @FindBy(xpath = "//*[@formcontrolname='houseType']")
    protected WebElement inputHouseType;
    @FindBy(xpath = "//*[@formcontrolname='houseName' or @name='houseName']")
    protected WebElement inputHouseName;
    @FindBy(xpath = "//*[@formcontrolname='block' or @name='block']")
    protected WebElement inputBlock;
    @FindBy(xpath = "//*[ contains(@class,'ng-valid') and @formcontrolname='apple' or  contains(@class,'ng-valid') and @name='apple']")
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
    @FindBy(css = "form > div:nth-child(1) > div > tdp-st-select")
    protected WebElement cbxDepartamento;
    @FindBy(css = "form > div:nth-child(2) > div > tdp-st-select")
    protected WebElement cbxProvincia;
    @FindBy(css = "form > div:nth-child(3) > div > tdp-st-select")
    protected WebElement cbxDistrito;
    private static final String DEPARTAMENTO = "15";

    public void selectDepartment(String department) {
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
        By byItem = By.cssSelector("[data-value='" + department + "']");
        SearchContext context = sh().getContext(depaList);
        esperaProgresiva(driver(), 3, 5, depaList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void selectProvince(String tipoProvincia) {
        WebElement provinciaList = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        esperaProgresiva(driver(), 3, 5, provinciaList);
        boolean existeLista = provinciaList.isEnabled();
        System.out.println("Existe Lista de" + provinciaList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            selectDepartment(DEPARTAMENTO);
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
            selectDepartment(DEPARTAMENTO);
            selectProvince(PROVINCIA);
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

    public void typeAddress(String direc) {
        WebElement inputDireccion = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(4) > div > tdp-st-input-text");
        click(inputDireccion);
        type(inputDireccion, direc);
    }

    public void typeReference(String referencia) {
        WebElement Refer = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(5) > div > tdp-st-input-text");
        click(Refer);
        type(Refer, referencia);
    }

    public void clickButtonConsultLocation() {
        esperaProgresiva(driver(), 5, 5, btnConsultLocation);
        js().scrollElementTop(btnConsultLocation);
        click(btnConsultLocation);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Consult Location");
        revisarModalError(driver());
        UtilWeb.waitForSeconds(5);
    }

    public void typeApple(String manzana) {
        boolean existe = validateInputAndLocator(driver(), manzana, inputApple);
        if (existe) {
            waitUntilElementIsClickable(inputApple, 15).click();
            type(inputApple, manzana);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type apple: " + manzana);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No apple");
        }
    }

    public void typeBlock(String bloque) {
        boolean existe = validateInputAndLocator(driver(), bloque, inputBlock);
        if (existe) {
            waitUntilElementIsClickable(inputBlock, 15).click();
            inputBlock.sendKeys(Keys.CONTROL + "a");
            inputBlock.sendKeys(Keys.DELETE);
            type(inputBlock, bloque);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type block: " + bloque);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No block");
        }
    }

    public void typeLot(String lot) {
        boolean existe = validateInputAndLocator(driver(), lot, inputLot);
        if (existe) {
            esperaProgresiva(driver(), 3, 5, inputLot);
            inputLot.click();
            type(inputLot, lot);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type lot: " + lot);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No lot ");
        }
    }

    public void typeFloor(String piso) {
        if (piso != null) {
            WebElement Npiso = find().getElementByXPath("//*[@formcontrolname='floor' or @name='floor']");
            esperaProgresiva(driver(), 5, 6, Npiso);
            Npiso.click();
            Npiso.sendKeys(Keys.CONTROL + "a");
            Npiso.sendKeys(Keys.DELETE);
            type(Npiso, piso);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type floor: " + piso);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No floor: ");
        }
    }

    public void typeInside(String inte) {
        if (inte != null) {
            WebElement NInterior = find().getElementByXPath("//*[@formcontrolname='inside' or @name='inside']");
            esperaProgresiva(driver(), 3, 5, NInterior);
            NInterior.click();
            NInterior.sendKeys(Keys.CONTROL + "a");
            NInterior.sendKeys(Keys.DELETE);
            type(NInterior, inte);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type inside: " + inte);
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No inside");
        }
    }

    public void selectHousingComplexe(String tipoConjunto) {
        if (tipoConjunto != null) {
            WebElement conjuntoList = find().getElementByXPath("//*[@formcontrolname='housingComplexe']");
            js().scrollElementTop(conjuntoList);
            selectElementShadowRootCSS(tipoConjunto,conjuntoList,"div > ul > li");
           /* click(conjuntoList);
            UtilWeb.waitForSeconds(2);
            SearchContext context = sh().getContext(conjuntoList);
            By byItem = By.cssSelector("[data-value='" + tipoConjunto + "']");
            context.findElement(byItem).click();
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type housing complex: " + tipoConjunto);
            */

        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No housing complex");
        }
    }

    public void typeHousingComplexName(String hab) {
        if (hab != null) {
            WebElement ConjHab = find().getElementByXPath("//*[@formcontrolname='housingComplexName' or @name='housingComplexName']");
            js().scrollElementTop(ConjHab);
            click(ConjHab);
            ConjHab.sendKeys(Keys.CONTROL + "a");
            ConjHab.sendKeys(Keys.DELETE);
            type(ConjHab, hab);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type housing complex name: " + hab);

        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No housing complex name");
        }
    }

    public void seleccionoDireccionSugerida() {
        UtilWeb.waitForSeconds(3);
        click(direccionSugerida);
    }

    public void selectHouseType(String houseType) {
        boolean existe = validateInputAndLocator(driver(), houseType, inputHouseType);
        if (existe) {
            selectElementShadowRootCSS(houseType,inputHouseType,"div > ul > li");
           /* String[][] selectOptions = {{"BLK", "BLOCK"}, {"CC", "CENTRO COMERCIAL"}, {"CASA", "CASA"}, {"ED", "EDIFICIO"}, {"MCDO", "MERCADO"}};
            String sCodeTipoVivienda = buscarValorOpcion(houseType.toUpperCase().trim(), selectOptions);
            UtilWeb.waitForSeconds(2);
            seleccionarValueComboShadow(driver(), "houseType", sCodeTipoVivienda);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type house: " + houseType);*/

        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No house type");
        }
    }

    public void typeHouseName(String houseName) {
        boolean existe = validateInputAndLocator(driver(), houseName, inputHouseName);
        if (existe) {
            waitUntilElementIsClickable(inputHouseName, 15).click();
            type(inputHouseName, houseName);
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Type house name: " + houseName);

        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "No house name");
        }
    }

    public void clickButtonConsultCoverage() {
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        js().scrollElementTop(btnConsultCoverage);
        btnConsultCoverage.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Dio click al boton: Consultar Cobertura");
    }

    public void ingresoDepartamento(String departamento) {
        try {
            if (isVisible(driver(), cbxDepartamento)) {
                selectElementShadowRootCSS(departamento,cbxDepartamento,"div > ul > li");

            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoProvincia(String provincia) {
        try {
            if (isVisible(driver(), cbxProvincia)) {
                selectElementShadowRootCSS(provincia,cbxProvincia,"div > ul > li");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoDistrito(String distrito) {
        try {
            if (isVisible(driver(), cbxDistrito)) {
                selectElementShadowRootCSS(distrito,cbxDistrito,"div > ul > li");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
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
        waitUntilElementIsVisible(txtDireccion, 50);
        compareWebElementTextAndText(txtDireccion, direccion);
    }

    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        waitUntilElementIsVisible(txtMsjError, 100);
        compareWebElementTextAndText(txtMsjError, msj);
    }

    public void doyClickAceptarEnElModalDeError() {
        waitUntilElementIsClickable(btnerror, 25).click();
    }

    public void selectElementShadowRootCSS(String text, WebElement webElement, String shadowElement) {
        click(webElement, 10);
        UtilWeb.waitForSeconds(2);
        SearchContext contextPlan = sh().getContext(webElement);
        List<WebElement> elementsList = contextPlan.findElements(By.cssSelector(shadowElement));
        for (WebElement element : elementsList) {
            js().scrollElementTop(element);
            boolean isEquals = returnCompareWebElementTextAndText(element, text);
            if (isEquals) {
                js().scrollElementTop(element);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Select element: " + element.getText());
                click(element, 10);
                break;
            }
        }
    }


}

