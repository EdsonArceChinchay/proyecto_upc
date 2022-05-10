package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaMovilRegistroStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void validarPantallaIngresarDireccion() {
        Assert.assertTrue(page.altaFijaMovilRegistroPage().validarPantallaIngresarDireccion());
    }

    @ScreenShotAfter
    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue("La pantalla de ofertas sugeridas no cargo correctamente!!!", page.altaFijaMovilRegistroPage().validarQueExistanOfertasSugeridas());
    }
    @ScreenShotAfter
    public void seleccionarOferta(String oferta) {
        page.altaFijaMovilRegistroPage().seleccionarOferta(oferta);
    }

    @ScreenShotAfter
    public void seleccionarPlan(String plan) {
        page.altaFijaMovilRegistroPage().seleccionarPlan(plan);
    }

    @ScreenShotAfter
    public void clicBotonSeleccionarOferta() {
        page.altaFijaMovilRegistroPage().clicSeleccionarOferta();
    }

    public void clicIrAMovistarTotal() {
        page.altaFijaMovilRegistroPage().clicIrAMovistarTotal();
    }

    @ScreenShotAfter
    public void validarDetalleSeleccion() {
        page.altaFijaMovilRegistroPage().validarDetalleSeleccion();
    }


    @ScreenShotAfter
    public void clicIniciarRegistro() {
        page.altaFijaMovilRegistroPage().clicIniciarRegistro();
    }
    @ScreenShotAfter
    public void moverToElementIniciarRegistro() {
        page.altaFijaMovilRegistroPage().moverToElementIniciarRegistro();
    }
    @ScreenShotAfter
    public void validarPantallaAgendamiento() {
        Assert.assertTrue("No se mostro pantalla de agendamiento",
                page.altaFijaMovilRegistroPage().validarPantallaAgendamiento());
    }

    @ScreenShotAfter
    public void ingresarContacto(String contacto) {
        page.altaFijaMovilRegistroPage().ingresarContacto(contacto);
    }

    @ScreenShotAfter
    public void clicConfirmarAgendamiento() {
        page.altaFijaMovilRegistroPage().clicConfirmarAgendamiento();
    }

    @ScreenShotAfter
    public void validarDetalleInstalacion() {
        Assert.assertTrue("No se mostro modal de detalle de instalacion",
                page.altaFijaMovilRegistroPage().validarDetalleInstalacion());
    }
    @ScreenShotAfter
    public void clicConfirmarInstalacion() {
        page.altaFijaMovilRegistroPage().clicConfirmarInstalacion();
    }

    @ScreenShotAfter
    public void completarCorreo(String correo) {
        page.altaFijaMovilRegistroPage().completarCorreo( correo);
    }

    @ScreenShotAfter
    public void clicValidarIdentidadTitular() {
        page.altaFijaMovilRegistroPage().clicValidarIdentidadTitular();
    }

    @ScreenShotAfter
    public void seleccionoTipoValidacion(String tipoValidacion) {
        page.altaFijaMovilRegistroPage().seleccionoTipoValidacion( tipoValidacion);
    }

    @ScreenShotAfter
    public void ingresarDatosSupervisor(DataTable datos) {

        String numdoc= UtilWeb.getValueFromDataTable(datos,"numdoc");
        String user= UtilWeb.getValueFromDataTable(datos,"user");
        String password= UtilWeb.getValueFromDataTable(datos,"password");

        page.altaFijaMovilRegistroPage().ingresarDNISupervisor(numdoc);
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
        page.altaFijaMovilRegistroPage().IngresarUsuarioSupervisor(user);
        page.altaFijaMovilRegistroPage().ingresarPasswordSupervisor(password);
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
    }

    @ScreenShotAfter
    public void validarIdentidadValidada() {
        page.altaFijaMovilRegistroPage().verificarIdentidadValidada();
    }
    @ScreenShotAfter
    public void clicValidarContrato() {
        page.altaFijaMovilRegistroPage().clicValidarContrato();
    }
    @ScreenShotAfter
    public void ingresarDatosValidacionSolicitada(DataTable datos) {
        page.altaFijaMovilRegistroPage().ingresarDatosValidacionReniec(datos);
    }

    @ScreenShotAfter
    public void clicEnSiguiente() {
        page.altaFijaMovilRegistroPage().clicSiguiente();
    }

    @ScreenShotAfter
    public void clicEnConfirmar() {
        page.altaFijaMovilRegistroPage().clicEnConfirmar();
    }

    @ScreenShotAfter
    public void moverseFinalDocumento() {
        page.altaFijaMovilRegistroPage().scrollByJavaScriptToFinal();
    }

    @ScreenShotAfter
    public void clicBotonContinuar() {
        page.altaFijaMovilRegistroPage().clicBotonContinuar();
    }

    @ScreenShotAfter
    public void visualizarContratoEnPantalla() {
        page.altaFijaMovilRegistroPage().visualizarContratoEnPantalla();
    }

    @ScreenShotAfter
    public void clicSiAcepto() {
        page.altaFijaMovilRegistroPage().clicSiAcepto();
    }

    @ScreenShotAfter
    public void validarMensajeExitoso() {
        Assert.assertTrue("No se pudo validar registro exitoso!!!",page.altaFijaMovilRegistroPage().validarMensajeExitoso());
    }

}
