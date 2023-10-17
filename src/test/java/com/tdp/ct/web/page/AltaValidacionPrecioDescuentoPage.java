package com.tdp.ct.web.page;

import com.beust.ah.A;
import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AltaValidacionPrecioDescuentoPage extends WebBase {
    AltaFijaAltaMovilCallCenterPage altaFijaAltaMovilCallCenterPage = new AltaFijaAltaMovilCallCenterPage();
    AltaMovilPostpagoCallCenterPage altaMovilPostpagoCallCenterPage = new AltaMovilPostpagoCallCenterPage();
    AltaTrioMTconUpfrontTiendaPage altaTrioMTconUpfrontTiendaPage = new AltaTrioMTconUpfrontTiendaPage();

    WebDriverWait waitdefin = new WebDriverWait(driver(), Duration.ofSeconds(5));

    @FindBy(xpath = "//app-searchclient/div[@class='tdp-container clienteExtranjero']")
    protected WebElement regClienteNew;
    @FindBy(xpath = "//div/div/div[@class='text-info']")
    protected WebElement infCliente;
    @FindBy(xpath = "//div/tdp-st-input-text[@label='Nombres']")
    protected WebElement nombreRegis;
    @FindBy(xpath = "//div/tdp-st-input-text[@label='Apellidos']")
    protected WebElement apellidoRegis;
    @FindBy(xpath = "//tdp-st-select[@formcontrolname='genero']")
    protected WebElement generolist;
    @FindBy(xpath = "//button[contains(text(),'Crear cliente')]")
    protected WebElement btnCrearCliente;
    @FindBy(css = "form > div:nth-child(1) > div > tdp-st-select")
    protected WebElement cbxDepartamento;
    @FindBy(css = "form > div:nth-child(2) > div > tdp-st-select")
    protected WebElement cbxProvincia;
    @FindBy(css = "form > div:nth-child(3) > div > tdp-st-select")
    protected WebElement cbxDistrito;
    @FindBy(xpath = "//div[@class='plan2']")
    protected WebElement lblPrecio;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='mail']")
    protected WebElement ingresoCorreo;
    @FindBy(xpath = "//tdp-st-input-text[@formcontrolname='confirmEmail']")
    protected WebElement ingresoConfCorreo;
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

    public void validacionClienteNuevo(String nombre, String apellido, String genero) {
        if (isVisible(regClienteNew)) {
            click(nombreRegis);
            nombreRegis.sendKeys(nombre);
            click(apellidoRegis);
            apellidoRegis.sendKeys(apellido);

            click(generolist);
            SearchContext context = sh().getContext(generolist);
            String dataValue = "";
            if (genero.equalsIgnoreCase("femenino")) {
                dataValue = "F";
            } else {
                dataValue = "M";
            }
            context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
            UtilWeb.waitForSeconds(1);

            click(btnCrearCliente);

        } else {
            String nombreGet = infCliente.getText().replace("Nombre: ", "");
            if (nombreGet.equalsIgnoreCase("Nombre:")) {
                throw new RuntimeException("Falla en la carga del cliente o formulario");
            } else {
                String nombreCliente = nombre + " " + apellido;
                Assert.assertEquals(nombreCliente, nombreGet);
            }
        }
    }

    public void comprueboCliente(String nombre, String apellido) {
        String nombreGet = infCliente.getText().replace("Nombre: ", "");
        String nombreCliente = nombre + " " + apellido;
        Assert.assertEquals(nombreCliente, nombreGet);
    }

    public void ingresoDepartamento(String departamento) {
        try {
            altaFijaAltaMovilCallCenterPage.scrollDown();
            if (isVisible(cbxDepartamento)) {
                click(cbxDepartamento);
                SearchContext context = sh().getContext(cbxDepartamento);
                List<WebElement> lielement = context.findElements(By.cssSelector("div > ul > li"));
                for (int i = 0; i < lielement.size(); i++) {
                    waitUntilElementIsVisible(lielement.get(i), 5);
                    String elementoLista = lielement.get(i).getText();
                    if (elementoLista.equalsIgnoreCase(departamento)) {
                        lielement.get(i).click();
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoProvincia(String provincia) {
        try {
            if (isVisible(cbxProvincia)) {
                click(cbxProvincia);
                SearchContext context = sh().getContext(cbxProvincia);
                List<WebElement> lieelement = context.findElements(By.cssSelector("div > ul > li"));
                for (int i = 0; i < lieelement.size(); i++) {
                    waitUntilElementIsVisible(lieelement.get(i), 5);
                    String elementoLista = lieelement.get(i).getText();
                    if (elementoLista.equalsIgnoreCase(provincia)) {
                        lieelement.get(i).click();
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoDistrito(String distrito) {
        try {
            if (isVisible(cbxDistrito)) {
                click(cbxDistrito);
                SearchContext context = sh().getContext(cbxDistrito);
                List<WebElement> liElement = context.findElements(By.cssSelector("div > ul > li"));
                for (int i = 0; i < liElement.size(); i++) {
                    waitUntilElementIsVisible(liElement.get(i), 3);
                    String elementoLista = liElement.get(i).getText();
                    if (elementoLista.equalsIgnoreCase(distrito)) {
                        liElement.get(i).click();
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validacionBeneficioPlan(String beneficioPlan) {
        List<WebElement> listElement = find().getElementsByXPath("//app-item-card-plan/div/div/div/div/span");
        WebElement elementoEncontrado = null;
        for (int i = 0; i < listElement.size(); i++) {
            String beneficioLista = listElement.get(i).getText().replace("+", "").replace("\n", "").replace("(", "").replace(")", "");
            System.out.println(beneficioLista);
            if (beneficioLista.equals(beneficioPlan)) {
                elementoEncontrado = listElement.get(i);
                break;
            }
        }
        Assert.assertNotNull("No se encontro el elmento " + beneficioPlan, elementoEncontrado);
    }

    public void validacionPrecio(String precioPlan) {
        String precioCompare = lblPrecio.getText();
        Assert.assertEquals(precioPlan, precioCompare);
    }

    public void ingresoCorreo(String email) {
        try {
            if (isVisible(ingresoCorreo)) {
                click(ingresoCorreo);
                ingresoCorreo.sendKeys(email);
            }
        } catch (NoSuchElementException e) {
            System.out.print("No se encontro el elemento " + e.getMessage());
        }
        try {
            if (isVisible(ingresoConfCorreo)) {
                click(ingresoConfCorreo);
                ingresoConfCorreo.sendKeys(email);
            }
        } catch (NoSuchElementException e) {
            System.out.print("No se encontro el elemento " + e.getMessage());
        }
    }

    public void ingresoCallId(String callID) {
        try {
            if (isVisible(ingresoCall)) {
                click(ingresoCall);
                ingresoCall.sendKeys(callID);
            } else {
                System.out.print("No necesita el Call ID");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoDatosCliente(String fecha) {
        try {
            js().scrollElementTop(btnDatosCliente);
            if (isVisible(btnDatosCliente)) {
                click(btnDatosCliente);
                if (isVisible(ingresoFecha)) {
                    click(ingresoFecha);
                    ingresoFecha.sendKeys(fecha);
                }
            } else {
                System.out.print("Cliente ya esta registrado");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ingresoNacionalidad(String nacionalidad) {
        if (isVisible(cbxNacionalidad)) {
            altaMovilPostpagoCallCenterPage.seleccionoNacionalidad(nacionalidad);
        }
    }

    public void ingresoEstadoCivil(String estadoCivil) {
        if (isVisible(cbxEstadoCivil)) {
            altaMovilPostpagoCallCenterPage.seleccionarEstadoCivil(estadoCivil);
            altaTrioMTconUpfrontTiendaPage.clickBotonConfirmar();
        }
    }

    //Este metodo sirva para buscar elementos dentro de un shadowroot que los elementos sencuentren bajo el formato css "div > ul > li"
    public void busquedadShadowUlLi(WebElement element, String comparaText) {
        try {
            waitUntilElementIsClickable(element, 5).click();
            SearchContext context = sh().getContext(element);
            List<WebElement> list = context.findElements(By.cssSelector("div > ul > li"));
            for (WebElement webElement : list) {
                String elementListEsCi = webElement.getText();
                System.out.println(elementListEsCi);
                if (comparaText.equalsIgnoreCase(elementListEsCi)) {
                    js().scrollElementTop(webElement);
                    waitUntilElementIsClickable(webElement, 5).click();
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isVisible(WebElement element) {
        boolean present;
        UtilWeb.waitForSeconds(1);
        if (element.isDisplayed() && element.isEnabled() && element.getSize().getWidth() > 0 && element.getSize().getHeight() > 0) {
            waitdefin.until(ExpectedConditions.visibilityOf(element));
            waitdefin.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("si existe");
            present = true;
        } else {
            present = false;
        }
        return present;
    }
}
