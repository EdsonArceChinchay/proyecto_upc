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
    public void seleccionoTipoDocumento(String type) {
        page.homePage().selectDocumentType(type);
    }

    @ScreenShotAfter
    public void ingresoDocumento(String document) {
        page.homePage().ingresoDocumento(document);
    }

    @ScreenShotBefore
    public void clickButtonSearch() {
        page.homePage().clickButtonSearch();
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
    public void clickBackOffice() {
        page.homePage().clickBackOffice();
    }

    @ScreenShotAfter
    public void validarMsgHome(String msg) {
        page.homePage().validarMsgHome(msg);
    }

    @ScreenShotAfter
    public void validarTiendaAsesor(String tienda) {
        page.homePage().validarTiendaAsesor(tienda);
    }

    public void regresarPaginaInicio() {
        page.homePage().regresarPaginaInicio();
    }

    @ScreenShotAfter
    public void doyClickEnElIconoDeAsesor() {
        page.homePage().clickIconoAsesor();
    }

    @ScreenShotAfter
    public void doyClickEnCerrarSesion() {
        page.homePage().clickBtnCerrarSesion();
    }

    @ScreenShotAfter
    public void doyClickEnAtras() {
        page.homePage().clickBtnAtras();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void confirmoCerrarSesion() {
        page.homePage().clickBtnCerrarSesion();
    }

}
