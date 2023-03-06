package com.tdp.ct.web.page.migracion;

import com.tdp.ct.web.base.WebBase;
import org.jsoup.helper.W3CDom;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MigraDuoTrioActualizarDireccionTiendasPage extends WebBase {
    @FindBy(xpath = "//*[contains(text(),'Se actualizo')]")
    protected WebElement txtMensaje;
    public void doyClickEnElBoton(String button) {
    }

    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        String mensajeEsperado = mensaje.toUpperCase().trim();
        waitUntilElementIsVisible(txtMensaje, 5);
        js().scrollElementTop(txtMensaje);
        String mensajeRecibido = txtMensaje.getText().toUpperCase().trim();
        Assertions.assertTrue(mensajeRecibido.contains(mensajeEsperado), "el mensaje recibido: " + mensajeRecibido + " es distinta al mensaje esperado: " + mensajeEsperado);
    }
}
