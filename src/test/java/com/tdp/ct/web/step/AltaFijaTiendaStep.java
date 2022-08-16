package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
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

        Assert.assertTrue("No existe el nombre del cliente", page.altaFijaTiendaPage().nombresCompletosCliente()
                .contains(nombreCompleto));
    }

    @ScreenShotBefore
    public void seleccionarListaPLanFija(String planFija) {
        page.altaFijaTiendaPage().listaPlanFija(planFija);
    }

    @ScreenShotBefore
    public void seleccionarListaOfertas(String ofertas) {
        page.altaFijaTiendaPage().listaOfertas(ofertas);
    }

    @ScreenShotBefore
    public void clickSeleccionarOferta() {
        page.altaFijaTiendaPage().seleccionarOferta();
    }

    @ScreenShotBefore
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
}

