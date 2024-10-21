package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Helper.*;

public class AddressPage extends WebBase {
    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[3]/div/div/div[3]")
    protected WebElement direccionSugerida;
    @FindBy(xpath = "//*[contains(@class,'ng-valid') and @formcontrolname='lot' or contains(@class,'ng-valid') and @name='lot']")
    protected WebElement inputLot;
    @FindBy(xpath = "//*[@formcontrolname='houseType' or @name='houseType']")
    protected WebElement selectHouseType;
    @FindBy(xpath = "//*[@formcontrolname='houseName' or @name='houseName']")
    protected WebElement inputHouseName;
    @FindBy(xpath = "//*[@formcontrolname='block' or @name='block']")
    protected WebElement inputBlock;
    @FindBy(xpath = "//*[@formcontrolname='floor' or @name='floor']")
    protected WebElement inputFloor;
    @FindBy(xpath = "//*[ contains(@class,'ng-valid') and @formcontrolname='apple' or  contains(@class,'ng-valid') and @name='apple']")
    protected WebElement inputApple;
    @FindBy(xpath = "//*[@formcontrolname='inside' or @name='inside']")
    protected WebElement inputInside;
    @FindBy(xpath = "//*[@formcontrolname='housingComplexe']")
    protected WebElement selectHousingComplexe;
    @FindBy(xpath = "//*[@formcontrolname='housingComplexName' or @name='housingComplexName']")
    protected WebElement inputHousingComplexName;
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
    @FindBy(xpath = "//*[contains(text(),'Se actualizo')]")
    protected WebElement txtMensaje;
    @FindBy(xpath = "(//button[contains(text(),'Buscar')])[1]")
    protected WebElement btnSearch;
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

    public void typeAddress(String address) {
        WebElement inputAdress = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(4) > div > tdp-st-input-text");
        inputAdress.click();
        inputAdress.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, address);
    }

    public void typeReference(String referencia) {
        WebElement inputReference = find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(5) > div > tdp-st-input-text");
        inputReference.click();
        inputReference.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, referencia);
    }

    public void clickButtonConsultLocation() {
        esperaProgresiva(driver(), 5, 5, btnConsultLocation);
        js().scrollElementTop(btnConsultLocation);
        click(btnConsultLocation);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button Consult Location");
        revisarModalError(driver());
        UtilWeb.waitForSeconds(5);
    }

    public void typeApple(String apple) {
        validateInput(driver(), "apple", apple, inputApple);
    }

    public void typeLot(String lot) {
        validateInput(driver(), "lot", lot, inputLot);
    }

    public void selectHouseType(String houseType) {
        validateSelectShadow(driver(), "houseType", houseType, selectHouseType, "div > ul > li");
    }

    public void typeHouseName(String houseName) {
        validateInput(driver(), "houseName", houseName, inputHouseName);
    }

    public void typeBlock(String block) {
        validateInput(driver(), "block", block, inputBlock);
    }

    public void typeFloor(String floor) {
        validateInput(driver(), "floor", floor, inputFloor);
    }

    public void typeInside(String inside) {
        validateInput(driver(), "inside", inside, inputInside);
    }

    public void selectHousingComplexe(String housingComplexe) {
        validateSelectShadow(driver(), "housingComplexe", housingComplexe, selectHousingComplexe, "div > ul > li");
    }

    public void typeHousingComplexName(String hab) {
        js().scrollElementTop(inputHousingComplexName);
        validateInput(driver(), "housing complex name", hab, inputHousingComplexName);
    }

    public void clickButtonConsultCoverage() {
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        js().scrollElementTop(btnConsultCoverage);
        UtilWeb.logger(this.getClass()).log(Level.INFO, String.format("Click button %s", btnConsultCoverage.getText()));
        btnConsultCoverage.click();
    }

    public void ingresoDepartamento(String departamento) {
        try {
            if (isVisible(driver(), cbxDepartamento)) {
                selectElementShadowRootCSS(departamento, cbxDepartamento, "div > ul > li");
            }
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No found element - " + e.getMessage());
        }
    }

    public void ingresoProvincia(String provincia) {
        try {
            if (isVisible(driver(), cbxProvincia)) {
                selectElementShadowRootCSS(provincia, cbxProvincia, "div > ul > li");
            }
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No found element - " + e.getMessage());
        }
    }

    public void ingresoDistrito(String distrito) {
        try {
            if (isVisible(driver(), cbxDistrito)) {
                selectElementShadowRootCSS(distrito, cbxDistrito, "div > ul > li");
            }
        } catch (NoSuchElementException e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "No found element - " + e.getMessage());
        }
    }

    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        waitUntilElementIsVisible(txtMensaje, 10);
        js().scrollElementTop(txtMensaje);
        compareWebElementTextAndString(txtMensaje, mensaje);
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
        esperaProgresiva(driver(), 5, 5, titleLugarInstalacion);
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

    public void seleccionoDireccionSugerida() {
        UtilWeb.waitForSeconds(3);
        click(direccionSugerida);
    }

    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        type(txtX, x.trim());
        UtilWeb.waitForSeconds(1);
        type(txtY, y.trim());
        UtilWeb.waitForSeconds(5);
    }

    public void validoQueLaDireccionSea(String direccion) {
        UtilWeb.waitForSeconds(5);
        esperaProgresiva(driver(), 5, 5, txtDireccion);
        compareWebElementTextAndString(txtDireccion, direccion);
    }

    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        esperaProgresiva(driver(), 5, 5, txtMsjError);
        compareWebElementTextAndString(txtMsjError, msj);
    }

    public void doyClickAceptarEnElModalDeError() {
        waitUntilElementIsClickable(btnerror, 25).click();
    }

    public void clickOnSearchButton() {
        esperaProgresiva(driver(), 5, 5, btnSearch);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click button "+ btnSearch.getText());
        btnSearch.click();
    }
}

