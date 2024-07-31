package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void selectDocumentType(String type) {
        page.homePage().selectDocumentType(type);
    }

    @ScreenShotAfter
    public void typeDocumentNumber(String document) {
        page.homePage().typeDocumentNumber(document);
    }

    @ScreenShotBefore
    public void clickOnConsultButton() {
        page.homePage().clickOnConsultButton();
    }

    @ScreenShotAfter
    public void validacionDeDatos(String nombre, String tipoDocumento, String nroDocumento) {
        page.homePage().validarDatosCliente(nombre, tipoDocumento, nroDocumento);
    }

    @ScreenShotAfter
    public void seleccionoElIDDeClienteNro(String nro) {
        page.homePage().seleccionoElIDDeClienteNro(nro);
    }

    @ScreenShotAfter
    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        page.homePage().validoQueMeTraigaLosServiciosContratadosPorElCliente();
    }

    @ScreenShotAfter
    public void seleccionoElTipoDeDocumentoDelRepresentanteLegal(String tipDoc) {
        page.homePage().seleccionoElTipoDeDocumentoDelRepresentanteLegal(tipDoc);
    }

    @ScreenShotAfter
    public void ingresoElNumeroDelDocumentoDelRepresentanteLegal(String numDoc) {
        page.homePage().ingresoElNumeroDelDocumentoDelRepresentanteLegal(numDoc);
    }

    @ScreenShotAfter
    public void doyClickEnValidarRepresentaLegal() {
        page.homePage().doyClickEnValidarRepresentaLegal();
    }

    public void clickXPopUpCU() {
        page.homePage().clickXPopUpCU();
    }

    @ScreenShotAfter
    public void clickOnTheBackOfficeButton() {
        page.homePage().clickOnTheBackOfficeButton();
    }

    @ScreenShotAfter
    public void validateHomeMessage(String msg) {
        page.homePage().validateHomeMessage(msg);
    }

    @ScreenShotAfter
    public void validateStoreType(String tienda) {
        page.homePage().validateStoreType(tienda);
    }

    public void regresarPaginaInicio() {
        page.homePage().regresarPaginaInicio();
    }

    @ScreenShotAfter
    public void clickOnTheAdvisorIcon() {
        page.homePage().clickOnTheAdvisorIcon();
    }

    @ScreenShotAfter
    public void doyClickEnCerrarSesion() {
        page.homePage().clickOnTheLogoutButton();
    }

    @ScreenShotAfter
    public void doyClickEnAtras() {
        page.homePage().clickBtnAtras();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void confirmoCerrarSesion() {
        page.homePage().clickOnTheLogoutButton();
    }

}
