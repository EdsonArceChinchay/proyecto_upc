package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void validarNombresCompletosCliente(String nombreCompleto) {
        //UtilWeb.waitForSeconds(20);
        Assert.assertTrue("No existe el nombre del cliente", page.altaFijaTiendaPage().nombresCompletosCliente()
                .contains(nombreCompleto));
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionarListaPLanFija(String planFija) {
        page.altaFijaTiendaPage().listaPlanFija(planFija);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionarListaPLanFijaMultiple(String planFija) {
        page.altaFijaTiendaPage().listaPlanFijaMultiple(planFija);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionarListaOfertas(String ofertas) {
        page.altaFijaTiendaPage().listaOfertas(ofertas);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionarListaOfertasNuevo(String ofertas) {
        page.altaFijaTiendaPage().listaOfertasNuevo(ofertas);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickSeleccionarOferta() {
        page.altaFijaTiendaPage().seleccionarOferta();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickListaBotones() {
        page.altaFijaTiendaPage().listaBotones();
    }

    @ScreenShotBefore
    public void ingresarDatosAgendamiento() {
        page.altaFijaTiendaPage().datosAgendamiento();
    }

    @ScreenShotBefore
    public void clickBotonConfirmarAgendamiento() {
        page.altaFijaTiendaPage().botonConfirmarAgendamiento();
    }

    @ScreenShotBefore
    public void clickDescargarContrato() {
        page.altaFijaTiendaPage().descargarContrato();
    }

    @ScreenShotBefore
    public void clickDescargarPdf() {
        page.altaFijaTiendaPage().descargarPdf();
    }

    public void cambiarPestanaPrincipal() {
        page.altaFijaTiendaPage().cambiarPestanaPrincipal();
    }

    public void clickCerrarPopUp() {
        page.altaFijaTiendaPage().cerrarPopUp();
    }

    @ScreenShotBefore
    public void clickRegistrarVenta() {
        page.altaFijaTiendaPage().registrarVenta();
    }

    @ScreenShotAfter
    public void doyClickEnAñadirSVA() {
        page.altaFijaTiendaPage().doyClickEnAñadirSVA();
    }

    @ScreenShotAfter
    public void doyClickEnAgregarBloque(String bloque) {
        page.altaFijaTiendaPage().doyClickEnAgregarBloque(bloque);


    }

    @ScreenShotAfter
    public void doyClickEnGuardarCambios() {
        page.altaFijaTiendaPage().doyClickEnGuardarCambios();

    }

    @ScreenShotAfter
    public void ingresarDatosAgendamientoParaRUC() {
        page.altaFijaTiendaPage().ingresarDatosAgendamientoParaRUC();
    }

    @ScreenShotBefore
    public void clickBotonValidarRepreLegal() {page.altaFijaTiendaPage().clickValidarRepreLegal();
    }
    @ScreenShotBefore
    public void clickBotonRegistrarVenta() {page.altaFijaTiendaPage().clickBotonRegistrarVenta();
    }
}

