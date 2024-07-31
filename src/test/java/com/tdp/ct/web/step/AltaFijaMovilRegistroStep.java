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
