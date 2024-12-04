package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.isVisible;

public class AltaValidacionPrecioDescuentoPage extends WebBase {
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

    @FindBy(xpath = "//div[@class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;

    public void validacionClienteNuevo(String nombre, String apellido, String genero) {
        UtilWeb.waitForSeconds(55);
        if (isVisible(driver(), regClienteNew)) {
            click(nombreRegis);
            nombreRegis.sendKeys(nombre);
            click(apellidoRegis);
            apellidoRegis.sendKeys(apellido);

            click(generolist);
            SearchContext context = sh().getContext(generolist);
            String dataValue;
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
                waitUntilElementIsClickable(infCliente, 3);
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

    public void validacionBeneficioPlan(String beneficioPlan) {
        List<WebElement> listElement = find().getElementsByXPath("//app-item-card-plan/div/div/div/div");
        WebElement elementoEncontrado = null;
        for (WebElement element : listElement) {
            String beneficioLista = element.getText().replace("+", "").replace("\n", "").replace("(", "").replace(")", "");
            logInfo(beneficioLista);
            if (beneficioLista.equals(beneficioPlan)) {
                elementoEncontrado = element;
                break;
            }
        }
        Assert.assertNotNull("No se encontro el elmento " + beneficioPlan, elementoEncontrado);
    }

    public void beneficioCompare(String beneficio, String xpathContenedor) {
        List<WebElement> listelementos = find().getElementsByXPath("." + xpathContenedor);
        WebElement elementEncontrado = null;
        for (WebElement listelemento : listelementos) {
            String beneficioLista = listelemento.getText().replace("+", "").replace("\n", "").replace("(", "").replace(")", "");
            logInfo(beneficioLista);
            if (beneficioLista.equals(beneficio)) {
                elementEncontrado = listelemento;
                break;
            }
        }
        Assert.assertNotNull("No se encontro el elmento " + beneficio, elementEncontrado);
    }

    public void validacionBeneficioDescuentoPLan(String planOfertas, String beneficio, String descuento) {
        revisarModalError(driver());

        String ofertaEsperada = planOfertas.trim().toUpperCase();
        logInfo("Ofertas : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);
        //driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            if (elementoExistente) {
                logInfo("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }
        //driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;
        //-------------------------------------------------------//
        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            logInfo("Entro al for de las lista de ofertas");
            logInfo("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                if (beneficio != null) {
                    String beneficioInternet = "//span[@class='speedboostLbl']";
                    beneficioCompare(beneficio, beneficioInternet);
                }
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }
        if (!encontroElemento && !listaOfertas.isEmpty()) {
            logInfo("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
    }

}
