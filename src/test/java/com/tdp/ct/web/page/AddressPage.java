package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.*;

public class AddressPage extends WebBase {

    private static final String DEPARTAMENTO = "LIMA";
    protected final String btnConsultCoverage = "//*[@type='submit' and contains(text(),'Consultar cobertura') or contains(@class,'button')  and contains(text(),'Consultar cobertura') ]";

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
    @FindBy(xpath = "//*[@type='submit' and contains(text(),'Consultar ubicación') or contains(@class,'button') and contains(text(),'Consultar ubicación')]")
    protected WebElement btnConsultLocation;
    @FindBy(xpath = "//div[@class='_title' and contains(text(), 'DE ENTREGA')]")
    protected WebElement titleLugarInstalacionEntrega;
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
    @FindBy(xpath = "//*[contains(text(),'Se actualizo')]")
    protected WebElement txtMensaje;
    @FindBy(xpath = "(//button[contains(text(),'Buscar')])[1]")
    protected WebElement btnSearch;

    // DIRECCION DE INSTALACION
    @FindBy(xpath = "//span[contains(text(),'Lugar de')]")
    protected WebElement titleLugarInstalacion;

    // INSERTAR DEPARTAMENTO
    @FindBy(css = "form > div:nth-child(1) > div > tdp-st-select")
    protected WebElement selectDepartment;

    // INSERTAR PROVINCIA
    @FindBy(css = "form > div:nth-child(2) > div > tdp-st-select")
    protected WebElement selectProvince;

    // INSERTAR DISTRITO
    @FindBy(css = "form > div:nth-child(3) > div > tdp-st-select")
    protected WebElement selectDistrict;

    // PANTALLA DE ACTUALIZAR DIRECCION
    @FindBy(xpath = "//h4[contains(text(), 'Verifica la')]")
    protected WebElement titleVerificarLugarInstalacion;
    @FindBy(xpath = "//*[contains(text(), 'Verifica la')]/preceding-sibling::*")
    protected WebElement cerrarPantallaVerificarLugarInstalacion;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

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

    public void ingresoDepartamento(String department) {
        try {
            if (isVisible(driver(), selectDepartment)) {
                selectElementCSSWithAndWithoutShadowRoot("department", selectDepartment, department);
            }
        } catch (NoSuchElementException e) {
            logSevere("No found element", e.getMessage());
        }
    }

    public void ingresoProvincia(String province) {
        try {
            if (isVisible(driver(), selectProvince)) {
                selectElementCSSWithAndWithoutShadowRoot("province", selectProvince, province);
            }
        } catch (NoSuchElementException e) {
            logSevere("No found element", e.getMessage());
        }
    }

    public void ingresoDistrito(String district) {
        try {
            if (isVisible(driver(), selectDistrict)) {
                selectElementCSSWithAndWithoutShadowRoot("district", selectDistrict, district);
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

    /**
     * FUNCION - PANTALLA INSERTAR DIRECCION
     * */

    public boolean validarPantallaIngresarDireccion() {
        logInfo("Ingreso a validar formulario de insersion de direccion del cliente");
        view.temporalPage().clickBtnReintentar();
        boolean isExisted = waitUntilElementIsVisible(titleLugarInstalacion, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina de Lugar de instalacion >>> {0}", isExisted);
        return isExisted;
    }

    public void ingresarTipoDireccion(String tipodireccion) {
        try {
            logInfo("Seleccionando tipo de direccion: " + tipodireccion);

            String xpath = String.format(
                    "//div[contains(@class,'options')]//div[@class='name' and normalize-space()='%s']/parent::div",
                    tipodireccion
            );

            WebElement opcion = explicitWaitXpath(driver(), 15, xpath);

            js().scrollElementTop(opcion);

            try {
                opcion.click(); // click real
            } catch (Exception e) {
                logInfo("Click normal falló, usando JS click");
                ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", opcion);
            }

        } catch (Exception e) {
            logSevere("Error al seleccionar tipo de direccion: " + tipodireccion + " - " + e.getMessage());
        }
    }

    public void ingresarDistritoProvinciaYDepartamento(String direccion) {
        try {
            logInfo("Ingresando ubicación: " + direccion);

            String[] partes = direccion.split(",");
            String distrito = partes[0].trim();

            WebElement inputBusqueda = find().getElementByCss(
                    "input[formcontrolname='direction']"
            );

            js().scrollElementTop(inputBusqueda);

            inputBusqueda.clear();
            inputBusqueda.sendKeys(distrito);

            // ✅ esperar a que aparezca la lista
            String xpathOpcion = String.format(
                    "//div[contains(@class,'search-list-match')]//*[contains(text(),'%s')]",
                    distrito.toUpperCase()
            );

            WebElement opcion = explicitWaitXpath(driver(), 15, xpathOpcion);

            opcion.click();

            logInfo("Se seleccionó correctamente el distrito: " + distrito);

        } catch (Exception e) {
            logSevere("Error al seleccionar ubicación: " + direccion + " - " + e.getMessage());
        }
    }

    public void ingresarTipoDeVida(String tipodevia) {
        try {
            logInfo("Seleccionando tipo de vía: " + tipodevia);

            WebElement selectTipoVia = find().getElementByCss(
                    "select[formcontrolname='roadType']"
            );

            js().scrollElementTop(selectTipoVia);

            Select select = new Select(selectTipoVia);

            // ✅ selecciona por texto visible
            select.selectByVisibleText(tipodevia.toUpperCase());

            logInfo("Se seleccionó correctamente el tipo de vía: " + tipodevia);

        } catch (Exception e) {
            logSevere("Error al seleccionar tipo de vía: " + tipodevia + " - " + e.getMessage());
        }
    }
    public void ingresarNombreVia(String nombrevia) {
        try {
            WebElement input = find().getElementByCss("#roadName");

            js().scrollElementTop(input);
            input.click();
            input.clear();
            input.sendKeys(nombrevia);
            input.sendKeys(Keys.TAB); // 🔥 fuerza evento Angular

            logInfo("Nombre de vía ingresado: " + nombrevia);

        } catch (Exception e) {
            logSevere("Error en nombre vía: " + e.getMessage());
        }
    }

    public void ingresarPuerta(String puerta) {
        try {
            WebElement input = find().getElementByCss("#doorNumber");

            js().scrollElementTop(input);
            input.click();
            input.clear();
            input.sendKeys(puerta);
            input.sendKeys(Keys.TAB); // 🔥 fuerza evento Angular

            logInfo("Nombre de puerta ingresado: " + puerta);

        } catch (Exception e) {
            logSevere("Error en puerta: " + e.getMessage());
        }
    }

    public void ingresarManzana(String manzana) {
        try {
            WebElement input = find().getElementByCss(
                    "input[formcontrolname='apple']"
            );

            js().scrollElementTop(input);
            input.click();
            input.clear();
            input.sendKeys(manzana);

        } catch (Exception e) {
            logSevere("Error en manzana: " + e.getMessage());
        }
    }

    public void ingresarLote(String lote) {
        try {
            WebElement input = find().getElementByCss(
                    "input[formcontrolname='lot']"
            );

            js().scrollElementTop(input);
            input.click();
            input.clear();
            input.sendKeys(lote);

        } catch (Exception e) {
            logSevere("Error en lote: " + e.getMessage());
        }
    }

    public void ingresarReferencia(String referencia) {
        try {
            WebElement input = find().getElementByCss(
                    "input[formcontrolname='reference']"
            );

            js().scrollElementTop(input);
            input.click();
            input.clear();
            input.sendKeys(referencia);

            logInfo("Referencia ingresada: " + referencia);

        } catch (Exception e) {
            logSevere("Error en referencia: " + e.getMessage());
        }
    }

    public void clickBtnConsultar() {
        try {
            logInfo("Click en botón Consultar");

            WebElement btnConsultar = explicitWaitXpath(
                    driver(),
                    15,
                    "//button[contains(@class,'submit_button') and contains(text(),'Consultar')]"
            );

            js().scrollElementTop(btnConsultar);

            try {
                btnConsultar.click(); // ✅ intento normal
            } catch (Exception e) {
                logInfo("Click normal falló, usando JS click");
                ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", btnConsultar);
            }

            logInfo("Se hizo click en Consultar correctamente");

        } catch (Exception e) {
            logSevere("Error al hacer click en Consultar: " + e.getMessage());
        }
    }

    public void clickBtnConsultarDireccion() {
        try {
            logInfo("Click en botón Confirmar dirección");

            WebElement btnConfirmar = explicitWaitXpath(
                    driver(),
                    15,
                    "//button[contains(@class,'filled_button') and contains(text(),'Confirmar')]"
            );

            js().scrollElementTop(btnConfirmar);

            try {
                btnConfirmar.click(); // ✅ click normal
            } catch (Exception e) {
                logInfo("Click normal falló, usando JS click");
                ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", btnConfirmar);
            }

            logInfo("Se hizo click en Confirmar dirección correctamente");

        } catch (Exception e) {
            logSevere("Error al hacer click en Confirmar dirección: " + e.getMessage());
        }
    }


     /**
     * FUNCION - SELECCIONAR DEPARTAMENTO
     * */

    public void selectDepartment(String department) {
        int cont = 0;
        boolean existeElement = false;
        while (cont < 3 && !existeElement) {
            cont++;
            try {
                logInfo("Ingreso a seleccionar Departamento - " + department);
                waitUntilElementIsVisible(selectDepartment,5);
                boolean existeLista = selectDepartment.isEnabled();
                logInfo("Existe Lista de - " + selectDepartment.getText() + ": " + existeLista);
                if (!existeLista) {
                    driver().navigate().refresh();
                    view.temporalPage().clickBtnReintentar();
                }
                js().scrollElementTop(selectDepartment);
                logInfo("Se procede a desplegar lista de Departamento");
                selectElementCSSWithAndWithoutShadowRoot("department", selectDepartment, department);
                UtilWeb.waitForSeconds(1);
                existeElement = true;
            } catch (Exception e) {
                logSevere("NO SE ENCONTRO EL ELEMENTO - " + e.getMessage());
                logInfo("Se procede a reintentar - N°" + cont);
                if (cont == 3) {
                    logInfo("NO SE ENCONTRO LA LISTA DE DEPARTAMENTOS - SE PROCEDE A CERRAR NAVEGADOR");

                }
            }
        }
    }

    /**
     * FUNCION - SELECCIONAR PROVINCIA
     * */

    public void selectProvince(String departamentoDireccion, String province) {
        int cont = 0;
        boolean existeElement = false;
        while (cont < 3 && !existeElement) {
            cont++;
            try {
                logInfo("Ingreso a seleccionar Provincia - " + province);
                waitUntilElementIsVisible(selectProvince,5);
                boolean existeLista = selectProvince.isEnabled();
                logInfo("Existe Lista de - " + selectProvince.getText() + ": " + existeLista);
                if (!existeLista) {
                    driver().navigate().refresh();
                    view.temporalPage().clickBtnReintentar();
                    selectDepartment(departamentoDireccion);
                }
                js().scrollElementTop(selectProvince);
                logInfo("Se procede a desplegar lista de Provincia");
                selectElementCSSWithAndWithoutShadowRoot("province", selectProvince, province);
                UtilWeb.waitForSeconds(1);
                existeElement = true;
            } catch (Exception e) {
                logSevere("NO SE ENCONTRO EL ELEMENTO - " + e.getMessage());
                logInfo("Se procede a reintentar - N°" + cont);
                if (cont == 3) {
                    logInfo("NO SE ENCONTRO LA LISTA DE PROVINCIAS - SE PROCEDE A CERRAR NAVEGADOR");

                }
            }
        }
    }

    /**
     * FUNCION - SELECCIONAR DISTRITO
     * */

    public void selectDistrict(String departamentoDireccion, String provinciaDireccion ,String district) {
        int cont = 0;
        boolean existeElement = false;
        while (cont < 3 && !existeElement) {
            cont++;
            try {
                logInfo("Ingreso a seleccionar Distrito - " + district);
                waitUntilElementIsVisible(selectDistrict,5);
                boolean existeLista = selectDistrict.isEnabled();
                logInfo("Existe Lista de - " + selectDistrict.getText() + ": " + existeLista);
                if (!existeLista) {
                    driver().navigate().refresh();
                    view.temporalPage().clickBtnReintentar();
                    selectDepartment(departamentoDireccion);
                    selectProvince(departamentoDireccion, provinciaDireccion);
                }
                js().scrollElementTop(selectDistrict);
                logInfo("Se procede a desplegar lista de Distrito");
                selectElementCSSWithAndWithoutShadowRoot("district", selectDistrict, district);
                UtilWeb.waitForSeconds(1);
                existeElement = true;
            } catch (Exception e) {
                logSevere("NO SE ENCONTRO EL ELEMENTO - " + e.getMessage());
                logInfo("Se procede a reintentar - N°" + cont);
                if (cont == 3) {
                    logInfo("NO SE ENCONTRO LA LISTA DE PROVINCIAS - SE PROCEDE A CERRAR NAVEGADOR");

                }
            }
        }
    }

    /**
     * FUNCION - INSERTAR DIRECCION
     * */

    public void typeAddress(String address) {
        logInfo("Ingreso a insertar la Direccion de Instalacion");
        WebElement inputAddress = find().getElementByCss("tdp-st-input-text[formcontrolname='direction']");
        validateAndTypeWithAndWithoutShadowRoot("address", inputAddress, address);
        logInfo("Se inserto la Direccion de Instalacion - Direccion: " + address);
    }

    /**
     * FUNCION - INSERTAR REFERENCIA
     * */

    public void typeReference(String reference) {
        logInfo("Ingreso a insertar la Referencia de la Direccion de Instalacion");
        WebElement inputReference = find().getElementByCss("tdp-st-input-text[formcontrolname='reference']");
        validateAndTypeWithAndWithoutShadowRoot("reference", inputReference, reference);
        logInfo("Se inserto la Referencia de la Direccion de Instalacion - Referencia: " + reference);
        miScenario.printFullView();
    }

    /**
     * FUNCION - CLICK BOTON CONSULTAR UBICACION
     * */

    public void clickButtonConsultLocation() {
        logInfo("Ingreso a visualizar el BOTON DE CONSULTAR LOCACION");
        waitUntilElementIsVisible(btnConsultLocation,10);
        js().scrollElementTop(btnConsultLocation);
        click(btnConsultLocation,5);
        logInfo("Click button Consult Location");
        view.temporalPage().clickBtnReintentar();
    }

    /**
     * FUNCION - CLICK BOTON CONSULTAR COBERTURA
     * */

    public void clickButtonConsultCoverage() {
        logInfo("Ingreso a realizar click al BOTON CONSULTAR COVERTURA");
        view.temporalPage().insertarBloquePisoEInterior();
        WebElement ButtonConsultCoverage = explicitWaitXpath(driver(), 20, btnConsultCoverage);
        miScenario.printFullView();
        js().scrollElementTop(ButtonConsultCoverage);
        logInfo(String.format("Click button %s", ButtonConsultCoverage.getText()));
        ButtonConsultCoverage.click();
        view.temporalPage().clickBtnReintentar();
    }

    /**
     * FUNCION - CUADRO ACTUALIZAR DIRECCION
     * */

    public boolean ventanaActualizarDireccion() {
        view.temporalPage().barraCargando();
        boolean existe = false;
        try {
            existe = waitUntilElementIsVisible(titleVerificarLugarInstalacion, 5).isDisplayed();
            UtilWeb.waitForSeconds(1);
            logInfo("Cuadro de Direccion es: " + existe);
        } catch (Exception e) {
            logInfo("No Existe Cuadro de Direccion");
            logInfo("Cuadro de Direccion en el catch es: " + existe);
        }
        return existe;
    }

    /**
     * FUNCION - CERRAR CUADRO ACTUALIZAR DIRECCION
     * */

    public void cerrarPantallaActualizarDireccion() {
        logInfo("Ingreso a cerrar pantalla de actualizar direccion");
        waitUntilElementIsVisible(cerrarPantallaVerificarLugarInstalacion,5);
        click(cerrarPantallaVerificarLugarInstalacion,5);
        logInfo("Cerro pantalla de actualizar direccion");
    }
}

