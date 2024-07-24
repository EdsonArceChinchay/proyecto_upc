package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AltaFijaMovilRegistroStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Customer customer;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotAfter
    public void validarPantallaRegistrarVenta() {
        Assert.assertTrue(page.altaFijaMovilRegistroPage().validarPantallaRegistrarVenta());
    }

    @ScreenShotAfter
    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue("La pantalla de ofertas sugeridas no cargo correctamente!!!",
                page.altaFijaMovilRegistroPage().validarQueExistanOfertasSugeridas());
    }

    @ScreenShotAfter
    public void seleccionarOferta(String oferta) {
        page.altaFijaMovilRegistroPage().seleccionarOferta(oferta);
    }

    @ScreenShotBefore
    public void clicValidarIdentidadTitular() {
        page.altaFijaMovilRegistroPage().clicValidarIdentidadTitular();
    }

    public void seleccionoTipoValidacion(String tipoValidacion) {
        page.altaFijaMovilRegistroPage().seleccionoTipoValidacion(tipoValidacion);
    }

    public void ingresarDatosSupervisor(DataTable datos) {

        String numdoc = UtilWeb.getValueFromDataTable(datos, "numdoc");
        String user = UtilWeb.getValueFromDataTable(datos, "user");
        String password = UtilWeb.getValueFromDataTable(datos, "password");

        page.altaFijaMovilRegistroPage().ingresarDNISupervisor(numdoc);
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
        page.altaFijaMovilRegistroPage().IngresarUsuarioSupervisor(user);
        page.altaFijaMovilRegistroPage().ingresarPasswordSupervisor(password);
    }

    @ScreenShotBefore
    public void clicConfirmarUsuarioSupervisor() {
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
    }

    public void validarIdentidadValidada() {
        page.altaFijaMovilRegistroPage().verificarIdentidadValidada();
    }

    @ScreenShotBefore
    public void clicValidarContrato() {
        page.altaFijaMovilRegistroPage().clicValidarContrato();
    }

    public void ingresarDatosValidacionSolicitada(DataTable datos, Integer i) {
        page.altaFijaMovilRegistroPage().ingresarDatosValidacionReniec(datos, i);
    }

    @ScreenShotBefore
    public void clicEnSiguiente() {
        page.altaFijaMovilRegistroPage().clicSiguiente();
    }

    @ScreenShotBefore
    public void clicEnConfirmar() {
        page.altaFijaMovilRegistroPage().clicEnConfirmar();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clicBotonContinuar() {
        page.altaFijaMovilRegistroPage().clicBotonContinuar();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void visualizarContratoEnPantalla() {
        page.altaFijaMovilRegistroPage().visualizarContratoEnPantalla();
    }

    @ScreenShotBefore
    public void clicSiAcepto() {
        page.altaFijaMovilRegistroPage().clicSiAcepto();
    }

    @ScreenShotAfter
    public void mostrarPantallaDescargarContrato() {
        Assert.assertTrue("No mostro pantalla para descargar contrato",
                page.altaFijaMovilRegistroPage().mostrarPantallaDescargarContrato());
    }

    @ScreenShotAfter
    public void clicDescargarContrato() {
        page.altaFijaMovilRegistroPage().clicDescargarContrato(scenario);
    }

    @ScreenShotAfter
    public void validarVentaGenerada() {
        Assert.assertTrue("No mostro pantalla de venta exitosa",
                page.altaFijaMovilRegistroPage().validarVentaGenerada());
        getOrderCode();
        getSalesCode();
    }

    public String getTextoSolicitud() {
        return page.altaFijaMovilRegistroPage().getTextoSolicitud();
    }

    public void getOrderCode() {
        List<String> orderCode = page.altaFijaMovilRegistroPage().getOrderCode();
        if (orderCode != null) {
            this.customer.setOrdersCode(orderCode);
        } else {
            System.out.println("ERROR - Codigo de Orden - Null");
        }
    }

    public String getSalesCode() {
        String salesCode = page.altaFijaMovilRegistroPage().getSalesCode();
        if (salesCode != null) {
            customer.setSalesCode(salesCode);
        } else {
            System.out.println("ERROR - Codigo de Venta - Null");
        }
        return salesCode == null ? " " : salesCode;
    }

}
