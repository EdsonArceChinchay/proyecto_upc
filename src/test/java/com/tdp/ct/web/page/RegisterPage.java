package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tdp.ct.web.step.Comun.buscarValorOpcion;
import static com.tdp.ct.web.step.Comun.seleccionarValueComboShadow;
import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Helper.isVisible;
import static com.tdp.ct.web.utils.Helper.returnCompareWebElementTextAndText;

public class RegisterPage extends WebBase {

    @FindBy(xpath = "//*[@formcontrolname='medioPago']")
    protected WebElement pageType;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='mail'] ")
    protected WebElement inputMail;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='confirmEmail']")
    protected WebElement inputConfirmEmail;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='callID']")
    protected WebElement ingresoCall;
    @FindBy(xpath = "//button/span[contains(text(),'Datos del Cliente')]")
    protected WebElement btnDatosCliente;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='fechaNacimiento']")
    protected WebElement ingresoFecha;
    @FindBy(xpath = "//tdp-st-select[@formcontrolname='nacionalidad']")
    protected WebElement cbxNacionalidad;
    @FindBy(xpath = "//tdp-st-select[@formcontrolname='estadoCivil']")
    protected WebElement cbxEstadoCivil;
    @FindBy(xpath = "(//span[contains(text(),'Datos del Cliente')]/..)[2]")
    protected WebElement buttonDatosDeCliente;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Datos del Cliente')]")
    protected WebElement labelDatosDeCliente;
    @FindBy(xpath = "//button[@type='button']//*[contains(text(),'Validar contrato')]")
    protected WebElement buttonValidarContrato;
    @FindBy(xpath = "//tdp-st-textarea[@formcontrolname='direccion']")
    protected WebElement lblDireccion;
    @FindBy(xpath = "//*[contains(text(),'Confirmar')]")
    protected WebElement lblConsultar;
    @FindBy(xpath = "//*[contains(text(),'Confirmar') and @type='submit'] | //button[contains(text(),'Confirmar')]")
    protected WebElement btnConfirm;

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

    public void confirmarCorreo(String correo) {
        WebElement correoElectronico = find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[2]/tdp-st-input-text");
        esperaProgresiva(driver(), 3, 5, correoElectronico);
        click(correoElectronico);
        correoElectronico.sendKeys(Keys.CONTROL + "a");
        correoElectronico.sendKeys(Keys.DELETE);
        type(correoElectronico, correo);
        UtilWeb.waitForSeconds(1);
    }

    public void ingresoCorreo(String email) {
        try {
            if (isVisible(driver(),inputMail)) {
                click(inputMail);
                inputMail.sendKeys(Keys.CONTROL + "a");
                inputMail.sendKeys(Keys.DELETE);
                inputMail.sendKeys(email);
            }
        } catch (NoSuchElementException e) {
            System.out.print("No se encontro el elemento " + e.getMessage());
        }
        try {
            if (isVisible(driver(),inputConfirmEmail)) {
                click(inputConfirmEmail);
                inputConfirmEmail.sendKeys(Keys.CONTROL + "a");
                inputConfirmEmail.sendKeys(Keys.DELETE);
                inputConfirmEmail.sendKeys(email);
            }
        } catch (NoSuchElementException e) {
            System.out.print("No se encontro el elemento " + e.getMessage());
        }
    }

    public void ingresoCallId(String callID) {
        try {
            if (isVisible(driver(),ingresoCall)) {
                click(ingresoCall);
                ingresoCall.sendKeys(callID);
            } else {
                System.out.print("No necesita el Call ID");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void esperarBtnDatosCliente() {
        js().scrollElementTop(buttonDatosDeCliente);
        waitUntilElementIsVisible(buttonDatosDeCliente, 10);
    }

    public void clicDatosDeCliente() {
        UtilWeb.waitForSeconds(2);
        click(buttonDatosDeCliente);
        UtilWeb.waitForSeconds(8);
    }

    public void typeDateOfBirth(String fechaNac) {
        String fechNacimiento = "tdp-st-input-text;input";
        WebElement fechNacimElement = js().getWebElement(fechNacimiento);
        fechNacimElement.sendKeys(fechaNac);
        UtilWeb.waitForSeconds(2);
    }

    public void selectMaritalStatus(String estadoCivil) {
        WebElement estadoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']");
        UtilWeb.waitForSeconds(2);
        click(estadoList,5);
        UtilWeb.waitForSeconds(3);
        SearchContext contexPlan=sh().getContext(estadoList);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li")); //By.className("mdc-list-item")
        for(WebElement elements:lista){
            js().scrollElementTop(elements);
            boolean isEquals =returnCompareWebElementTextAndText(elements,estadoCivil);
            if(isEquals){
                 js().scrollElementTop(elements);
                click(elements,5);
                break;
            }
        }
    }

    public void selectNationality(String nacionalidad) {
        WebElement listNacionalidad = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(listNacionalidad,5);
        UtilWeb.waitForSeconds(3);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click nationality");
        SearchContext contexPlan = sh().getContext(listNacionalidad);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            js().scrollElementTop(elements);
            boolean isEquals =returnCompareWebElementTextAndText(elements,nacionalidad);
            if (isEquals) {
                click(elements, 30);
                break;
            }
        }
    }

    public void ingresarNacionalidad(String nacionalidad) {
        UtilWeb.waitForSeconds(2);
        WebElement nacList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(nacList);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click nationality");
        UtilWeb.waitForSeconds(2);
        SearchContext contextNacionalidad = sh().getContext(nacList).findElement(By.cssSelector("div > ul > li"));
        List<WebElement> lista = contextNacionalidad.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(element,nacionalidad);
            if (isEquals) {
                click(element, 10);
                break;
            }
        }
    }

    public void selecDepartamento(String departamento) {
        UtilWeb.waitForSeconds(2);
        WebElement departList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='department']");
        js().scrollElementTop(departList);
        click(departList);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click Department");
        UtilWeb.waitForSeconds(2);
        SearchContext contextDepart = sh().getContext(departList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextDepart.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(element,departamento);
            if (isEquals) {
                click(element,10);
                break;
            }
        }
    }


    public void clickButtonConfirm() {
        js().scrollElementTop(btnConfirm);
        UtilWeb.waitForSeconds(5);
        esperaProgresiva(driver(), 3,5,btnConfirm);
        waitUntilElementIsClickable(btnConfirm, 10);
        click(btnConfirm);
        esperaProgresiva(driver(),6,6,buttonValidarContrato);
    }

    public boolean esperarLoadingIsNotVisible(String xpath, int segundos) {
        boolean retorno;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver(), Duration.ofSeconds(segundos));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            System.out.println("No se espero a que se oculte el elemento");
        }
        return retorno;
    }

    public void seleccionarDepartamento(String departamento) {
        WebElement listDepartamento = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='department']");
        click(listDepartamento);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listDepartamento);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(elements,departamento);
            if (isEquals) {
                click(elements, 10);
                break;
            }
        }
    }

    public void seleccionarProvincia(String provincia) {
        WebElement listProvincia = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        click(listProvincia);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listProvincia);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(elements,provincia);
            if (isEquals) {
                click(elements, 10);
                break;
            }
        }
    }

    public void selecProvincia(String provincia) {
        UtilWeb.waitForSeconds(2);
        WebElement provinciaList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        click(provinciaList);
        UtilWeb.waitForSeconds(2);

        SearchContext contextProv = sh().getContext(provinciaList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextProv.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(element,provincia);
            if (isEquals) {
                click(element,5);
                UtilWeb.waitForSeconds(3);
                break;
            }
        }
    }

    public void seleccionarDistrito(String distrito) {
        WebElement listDistrito = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='district']");
        js().scrollElementTop(listDistrito);
        WebElement listProvincia = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        js().scrollElementTop(listProvincia);
        click(listDistrito);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan = sh().getContext(listDistrito);
        List<WebElement> lista = contexPlan.findElements(By.cssSelector("div > ul > li"));
        for (WebElement elements : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(elements,distrito);
            if (isEquals) {
                click(elements, 5);
                break;
            }
        }
    }

    public void selecDistrito(String distrito) {
        UtilWeb.waitForSeconds(2);
        WebElement distritoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='district']");
        click(distritoList);
        UtilWeb.waitForSeconds(2);

        SearchContext contextEstado = sh().getContext(distritoList).findElement(By.cssSelector("div > div:nth-child(2) > ul"));
        List<WebElement> lista = contextEstado.findElements(By.className("mdc-list-item"));
        for (WebElement element : lista) {
            boolean isEquals =returnCompareWebElementTextAndText(element,distrito);
            if (isEquals) {
                UtilWeb.waitForSeconds(1);
                click(element, 2);
            }
        }
    }

    public void typeAddress(String address) {
        UtilWeb.waitForSeconds(2);
        String ingresaDireccion = "tdp-st-textarea;textarea";
        WebElement direccionElement = js().getWebElement(ingresaDireccion);
        js().scrollElementTop(direccionElement);
        type(direccionElement, address);
        js().scrollElementTop(lblConsultar);
        click(lblConsultar, 10);
    }

}
