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
    public void seleccionoTipoDocumento(String tipoDocumento) {
        page.homePage().seleccionoTipoDocumento(tipoDocumento);
    }

    @ScreenShotAfter
    public void ingresoDocumento(String documento) {
        page.homePage().ingresoDocumento(documento);
    }

    @ScreenShotBefore
    public void clickBotonConsultar() {
        UtilWeb.waitForSeconds(10);
        page.homePage().clickBotonConsultar();
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
    public void clickBtnConsultar() {
        page.homePage().clickBtnConsultar();
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
}
