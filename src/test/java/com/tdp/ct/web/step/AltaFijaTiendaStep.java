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

    @ScreenShotAfter
    public void doyClickEnAñadirSVA() {
        page.altaFijaTiendaPage().doyClickEnAñadirSVA();
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

    public void seleccionarboton() {
        page.migracionDuoATrioTiendaPage().seleccionarboton();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void validacionClienteNuevo(String nombre, String apellidos, String genero) {
        page.altaValidacionPrecioDescuentoPage().validacionClienteNuevo(nombre, apellidos, genero);
    }

    @ScreenShotAfter
    public void validacionBeneficioPlan(String beneficioPlan) {
        page.altaValidacionPrecioDescuentoPage().validacionBeneficioPlan(beneficioPlan);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void comprueboCliente(String nombre, String apellido) {
        page.altaValidacionPrecioDescuentoPage().comprueboCliente(nombre, apellido);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void escojoPlan(String plan) {
        page.altaFijaTiendaPage().listaOfertas(plan, scenario);
        page.altaFijaTiendaPage().seleccionarOferta();
    }
}

