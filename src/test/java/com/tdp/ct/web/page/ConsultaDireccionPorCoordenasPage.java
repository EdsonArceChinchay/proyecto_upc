package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultaDireccionPorCoordenasPage extends WebBase {

    @FindBy(xpath = "(//*[@formcontrolname='longitude'])[1]")
    protected WebElement txtX;

    @FindBy(xpath = "(//*[@formcontrolname='latitude'])[1]")
    protected WebElement txtY;

    @FindBy(xpath = "//*[@formcontrolname='direction' or contains(@class,'text-adress-info')]")
    protected WebElement txtDireccion;

    @FindBy(xpath = "//mat-dialog-content//p[contains(@class,'modal-description')]")
    protected WebElement txtMsjError;


    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        type(txtX, x.trim());
        UtilWeb.waitForSeconds(1);
        type(txtY, y.trim());
        UtilWeb.waitForSeconds(2);
    }

    public void validoQueLaDireccionSea(String direccion) {
        UtilWeb.waitForSeconds(30);
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
}
