package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaTiendaStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotBefore
    @ScreenShotAfter
    public void validarNombresCompletosCliente(String nombreCompleto) {
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
    public void seleccionarListaOfertas(String ofertas) {
        page.altaFijaTiendaPage().listaOfertas(ofertas, scenario);
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

    @ScreenShotAfter
    public void doyClickEnAñadirSVA() {
        page.altaFijaTiendaPage().doyClickEnAñadirSVA();
    }

    @ScreenShotBefore
    public void clickBotonValidarRepreLegal() {
        page.altaFijaTiendaPage().clickValidarRepreLegal();
    }
    @ScreenShotBefore
    public void clickBotonRegistrarVenta() {
        page.altaFijaTiendaPage().clickBotonRegistrarVenta();
    }

    public void validarNomPlan(String nomPlan) {
        page.altaFijaTiendaPage().validarNomPlan(nomPlan);
    }

    public void validarVelocidadInternet(String mbpsBB) {
        page.altaFijaTiendaPage().validarVelocidadInternet(mbpsBB);
    }

    public void validarPrecioDescuento(String precDesc) {
        page.altaFijaTiendaPage().validarPrecioDescuento(precDesc);
    }

    public void validarnombreSVAcontenido(String nomsvaTV) {
        page.altaFijaTiendaPage().validarnombreSVAcontenido(nomsvaTV);
    }

    public void validarPrecioDescuentoTV(String pDescTV) {
        page.altaFijaTiendaPage().validarPrecioDescuentoTV(pDescTV);
    }

}

