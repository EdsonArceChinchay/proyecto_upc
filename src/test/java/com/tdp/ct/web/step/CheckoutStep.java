package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

@Component
public class CheckoutStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @Autowired
    private Customer customer;

    @ScreenShotAfter
    public void validarPantallaRegistrarVenta() {
        Assert.assertTrue(page.checkoutPage().validarPantallaRegistrarVenta());
    }

    @ScreenShotAfter
    public void mostrarPantallaDescargarContrato() {
        Assert.assertTrue("No mostro pantalla para descargar contrato",
                page.checkoutPage().mostrarPantallaDescargarContrato());
    }

    @ScreenShotAfter
    public void clicDescargarContrato() {
        page.checkoutPage().clicDescargarContrato(scenario);
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
    @ScreenShotAfter
    public void clickRegistrarVenta() {
        page.altaFijaTiendaPage().registrarVenta();
    }

    @ScreenShotBefore
    public void clickBotonRegistrarVenta() {
        page.altaFijaTiendaPage().clickBotonRegistrarVenta();
    }

    public String getProductType() {
        return page.checkoutPage().getProductType();
    }

    public void validateTheBillingCycle() {
        page.checkoutPage().validateTheBillingCycle();
    }

    @ScreenShotAfter
    public void validateRegistrationHasBeenSuccessful() {
        Assert.assertTrue("No mostro pantalla de venta exitosa",
                page.checkoutPage().validateRegistrationHasBeenSuccessful());
    }

    @ScreenShotAfter
    public void validateTicket() {
        page.checkoutPage().validateTicket();
    }

    public String getOrderCode() {
        List<String> orderCode = page.checkoutPage().getOrderCode();
        if (orderCode != null) {
            customer.setOrdersCode(orderCode);
        } else {
            logInfo("ERROR - Codigo de Orden - Null");
        }
        return orderCode == null ? " " : orderCode.toString();
    }

    public String getSalesCode() {
        String salesCode = page.checkoutPage().getSalesCode();
        if (salesCode != null) {
            customer.setSalesCode(salesCode);
        } else {
            logInfo("ERROR - Codigo de Venta - Null");
        }
        logInfo("Se finalizo recorrido para SALES CODE");
        logInfo("Sales code obtenido es: " + salesCode);
        return salesCode == null ? " " : salesCode;
    }

    public void doyClickenVerDetalleDelPedido() {
        page.checkoutPage().clickenVerDetalleDelPedido();
    }

    @ScreenShotAfter
    public void ValidoQuePresenteDetallePedido(String service) {
        page.checkoutPage().ValidoQuePresenteDetallePedido(service);
    }
}
