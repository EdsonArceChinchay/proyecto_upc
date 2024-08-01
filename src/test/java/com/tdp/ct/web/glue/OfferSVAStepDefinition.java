package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.OfferSVAStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class OfferSVAStepDefinition {

    @Autowired
    OfferSVAStep offerSVAStep;

    @Y("valido que me encuentre en la pantalla {string}")
    public void validoQueMeEncuentreEnLaPantalla(String name) {
        offerSVAStep.validateScreenName(name);
    }

    @Y("doy click en el boton Guardar cambios")
    public void doyClickEnElBotonGuardarCambios() {
        offerSVAStep.clickButtonSaveChanges();
    }

    @Y("doy click en Regresar a resumen")
    public void doyClickEnRegresarAResumen() {
        offerSVAStep.clickBackToSumary();
    }

    @Y("agrego SVA decodificador {string}")
    public void agregoSVADecodificador(String nameSVA) {
        offerSVAStep.addSVADecoder(nameSVA);
    }

    @Y("agrego SVA repetidor {string}")
    public void agregoSVARepetidor(String nameSVA) {
        offerSVAStep.addSVARepeater(nameSVA);
    }

    @Y("agrego SVA modem {string}")
    public void agregoSVAModem(String nameSVA) {
        offerSVAStep.addSVAModem(nameSVA);
    }

    @Y("agrego SVA bloque {string}")
    public void agregoSVABlocks(String nameSVA) {
        offerSVAStep.addSVABlocks(nameSVA);
    }

    @Y("agrego SVA internet {string}")
    public void agregoSVAInternet(String nameSVA) {
        offerSVAStep.addSVAInternet(nameSVA);
    }

    @Y("agrego SVA linea {string}")
    public void agregoSVALinea(String nameSVA) {
        offerSVAStep.addSVALinea(nameSVA);
    }

    @Y("agrego SVA Movistar Tv App Max")
    public void agregoSVATvApp() {
        offerSVAStep.addSVATvApp();
    }

}
