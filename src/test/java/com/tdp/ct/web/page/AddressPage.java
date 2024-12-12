package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class AddressPage extends WebBase {
    private static final String DEPARTAMENTO = "LIMA";
    @FindBy(xpath = "//tdp-st-card[2]/div/div[2]/form/div[3]/div/div/div[3]")
    protected WebElement direccionSugerida;
    @FindBy(css = "tdp-st-input-text[formcontrolname='lot']")
    protected WebElement inputLot;
    @FindBy(css = "tdp-st-select[formcontrolname='houseType']")
    protected WebElement selectHouseType;
    @FindBy(css = "tdp-st-input-text[formcontrolname='houseName']")
    protected WebElement inputHouseName;
    @FindBy(css = "tdp-st-input-text[formcontrolname='block']")
    protected WebElement inputBlock;
    @FindBy(css = "tdp-st-input-text[formcontrolname='floor']")
    protected WebElement inputFloor;
    @FindBy(css = "tdp-st-input-text[formcontrolname='apple']")
    protected WebElement inputApple;
    @FindBy(css = "tdp-st-input-text[formcontrolname='inside']")
    protected WebElement inputInside;
    @FindBy(css = "tdp-st-select[formcontrolname='housingComplexe']")
    protected WebElement selectHousingComplexe;
    @FindBy(css = "tdp-st-input-text[formcontrolname='housingComplexName']")
    protected WebElement inputHousingComplexName;
    //@FindBy(xpath = "//*[@type='submit' and contains(text(),'Consultar cobertura') or contains(@class,'button')  and contains(text(),'Consultar cobertura') ]")
    protected String btnConsultCoverage =
            "//*[@type='submit' and contains(text(),'Consultar cobertura') or contains(@class,'button')  and contains(text(),'Consultar cobertura') ]";
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

    public void selectDepartment(String department) {
        WebElement depaList = explicitWaitCss(driver(), 6, "form > div:nth-child(1) > div > tdp-st-select");
        esperaProgresiva(driver(), 5, 5, depaList);

        boolean existeLista = depaList.isEnabled();
        logInfo("Existe Lista de" + depaList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            depaList = find().getElementByCss("form > div:nth-child(1) > div > tdp-st-select");
            UtilWeb.waitForSeconds(4);
        }
        selectElementCSSWithAndWithoutShadowRoot("department", depaList, department);
        UtilWeb.waitForSeconds(1);
    }

    public void selectProvince(String province) {
        WebElement provinciaList = find().getElementByCss("form > div:nth-child(2) > div > tdp-st-select");
        esperaProgresiva(driver(), 3, 5, provinciaList);
        boolean existeLista = provinciaList.isEnabled();
        logInfo("Existe Lista de" + provinciaList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            selectDepartment(DEPARTAMENTO);
            provinciaList = find().getElementByCss("form > div:nth-child(2) > div > tdp-st-select");
        }
        selectElementCSSWithAndWithoutShadowRoot("province", provinciaList, province);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarDistrito(String district) {
        String PROVINCIA = "LIMA";
        WebElement distritoList = find().getElementByCss("form > div:nth-child(3) > div > tdp-st-select");
        esperaProgresiva(driver(), 3, 5, distritoList);
        boolean existeLista = distritoList.isEnabled();
        logInfo("Existe Lista de" + distritoList.getText() + ": " + existeLista);
        if (!existeLista) {
            driver().navigate().refresh();
            selectDepartment(DEPARTAMENTO);
            selectProvince(PROVINCIA);
            distritoList = find().getElementByCss("form > div:nth-child(3) > div > tdp-st-select");
        }
        selectElementCSSWithAndWithoutShadowRoot("district", distritoList, district);
        UtilWeb.waitForSeconds(1);
    }

    public void typeAddress(String address) {
        WebElement inputAddress = find().getElementByCss("tdp-st-input-text[formcontrolname='direction']");
        validateAndTypeWithAndWithoutShadowRoot("address", inputAddress, address);
    }

    public void typeReference(String reference) {
        WebElement inputReference = find().getElementByCss("tdp-st-input-text[formcontrolname='reference']");
        validateAndTypeWithAndWithoutShadowRoot("reference", inputReference, reference);
    }

    public void clickButtonConsultLocation() {
        esperaProgresiva(driver(), 5, 5, btnConsultLocation);
        js().scrollElementTop(btnConsultLocation);
        click(btnConsultLocation);
        logInfo("Click button Consult Location");
        revisarModalError(driver());
    }

    public void typeApple(String apple) {
        validateAndTypeWithAndWithoutShadowRoot("apple", inputApple, apple);
    }

    public void typeLot(String lot) {
        validateAndTypeWithAndWithoutShadowRoot("lot", inputLot, lot);
    }

    public void selectHouseType(String houseType) {
        selectElementCSSWithAndWithoutShadowRoot("houseType", selectHouseType, houseType);
    }

    public void typeHouseName(String houseName) {
        validateAndTypeWithAndWithoutShadowRoot("houseName", inputHouseName, houseName);
    }

    public void typeBlock(String block) {
        validateAndTypeWithAndWithoutShadowRoot("block", inputBlock, block);
    }

    public void typeFloor(String floor) {
        validateAndTypeWithAndWithoutShadowRoot("floor", inputFloor, floor);
    }

    public void typeInside(String inside) {
        validateAndTypeWithAndWithoutShadowRoot("inside", inputInside, inside);
    }

    public void selectHousingComplexe(String housingComplexe) {
        selectElementCSSWithAndWithoutShadowRoot("housing complexe", selectHousingComplexe, housingComplexe);
    }

    public void typeHousingComplexName(String hab) {
        js().scrollElementTop(inputHousingComplexName);
        validateAndTypeWithAndWithoutShadowRoot("housing complex name", inputHousingComplexName, hab);
    }

    public void clickButtonConsultCoverage() {
        revisarModalError(driver());
        //esperaProgresiva(driver(), 5, 5, btnConsultCoverage);
        WebElement ButtonConsultCoverage = explicitWaitXpath(driver(), 20, btnConsultCoverage);
        js().scrollElementTop(ButtonConsultCoverage);
        logInfo(String.format("Click button %s", ButtonConsultCoverage.getText()));
        ButtonConsultCoverage.click();
    }

    public void ingresoDepartamento(String department) {
        try {
            if (isVisible(driver(), cbxDepartamento)) {
                selectElementCSSWithAndWithoutShadowRoot("department", cbxDepartamento, department);
            }
        } catch (NoSuchElementException e) {
            logSevere("No found element", e.getMessage());
        }
    }

    public void ingresoProvincia(String province) {
        try {
            if (isVisible(driver(), cbxProvincia)) {
                selectElementCSSWithAndWithoutShadowRoot("province", cbxProvincia, province);
            }
        } catch (NoSuchElementException e) {
            logSevere("No found element", e.getMessage());
        }
    }

    public void ingresoDistrito(String district) {
        try {
            if (isVisible(driver(), cbxDistrito)) {
                selectElementCSSWithAndWithoutShadowRoot("district", cbxDistrito, district);
            }
        } catch (NoSuchElementException e) {
            logSevere("No found element - " + e.getMessage());
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
        boolean isExisted = waitUntilElementIsVisible(titleLugarInstalacionEntrega, 30).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina de Lugar de instalacion >>> {0}", isExisted);
        return isExisted;
    }

    public boolean validarPantallaIngresarDireccion() {
        esperaProgresiva(driver(), 5, 5, titleLugarInstalacion);
        boolean isExisted = waitUntilElementIsVisible(titleLugarInstalacion, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina de Lugar de instalacion >>> {0}", isExisted);
        return isExisted;
    }

    public boolean validarPantallaVerificarDireccion() {
        esperaProgresiva(driver(), 6, 4, titleVerificarLugarInstalacion);
        boolean existe = waitUntilElementIsVisible(titleVerificarLugarInstalacion, 30).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina de Verificar Lugar de instalacion >>> {0}", existe);
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
        logInfo("Click button", btnSearch.getText());
        btnSearch.click();
    }
}

