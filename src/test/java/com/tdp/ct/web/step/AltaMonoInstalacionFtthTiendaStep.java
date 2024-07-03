package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMonoInstalacionFtthTiendaStep {

    @Autowired
    private StepPages page;

    public void scrollToBtnCrearCliente() {
        page.altaMonoFtthTiendaPage().scrollToBtnCrearCliente();
    }

    @ScreenShotBefore
    public void crearCliente() {
        page.altaMonoFtthTiendaPage().crearCliente();
    }

    public void writeDireccion(String depa, String prov, String distrito, String direccion, String ref) {
        page.altaFijaAltaMovilRetailPage().seleccionarDepa(depa);
        page.altaFijaAltaMovilRetailPage().seleccionarProvincia(prov);
        page.altaFijaAltaMovilRetailPage().seleccionarDistrito(distrito);
        page.altaFijaAltaMovilRetailPage().writeDireccion(direccion);
        page.altaFijaAltaMovilRetailPage().writeReferencia(ref);
    }

    @ScreenShotBefore
    public void clickBtnConsultarUbicacion() {
        page.altaFijaAltaMovilRetailPage().btnConsultar();
    }

    public void scrollDirecCompleta() {
        page.altaMonoFtthTiendaPage().scrollDirecCompleta();
    }

    public void writeDireccionInstalacion(String manzana, String lote, String tipoVivienda, String nomVivienda, String bloque, String piso, String interior, String tipoConjH, String conjH) {
        page.altaFijaAltaMovilCallCenterPage().manzana(manzana);
        page.altaFijaAltaMovilCallCenterPage().lote(lote);
        page.altaFijaAltaMovilCallCenterPage().tipoVivienda(tipoVivienda);
        page.altaFijaAltaMovilCallCenterPage().nombreVivienda(nomVivienda);
        page.altaFijaAltaMovilCallCenterPage().bloque(bloque);
        page.altaFijaAltaMovilCallCenterPage().piso(piso);
        page.altaFijaAltaMovilCallCenterPage().interior(interior);
        page.altaFijaAltaMovilCallCenterPage().tipoConjuntoHabitacional(tipoConjH);
        page.altaFijaAltaMovilCallCenterPage().conjuntoHabitacional(conjH);
    }

    @ScreenShotAfter
    public void clickBtnConsultarCobertura() {
        page.altaMonoFtthTiendaPage().clickBtnConsultarCobertura();
    }

    @ScreenShotAfter
    public void validarOfertasSugeridasView(String title) {
        page.altaMonoFtthTiendaPage().validarOfertasSugeridasView(title);
    }

    public void scrollToBtnPlanNuevo() {
        page.altaMonoFtthTiendaPage().scrollToBtnPlanNuevo();
    }

    @ScreenShotBefore
    public void clickBtnPlanNuevo() {
        page.altaMonoFtthTiendaPage().clickBtnPlanNuevo();
    }

    @ScreenShotBefore
    public void clickBtnTipoPlan(String plan) {
        page.altaMonoFtthTiendaPage().clickBtnTipoPlan(plan);
    }

    @ScreenShotBefore
    public void seleccionarPlan(String plan) {
        page.altaFijaMovilRegistroPage().seleccionarPlan(plan);
    }

    @ScreenShotBefore
    public void clickSelectOferta() {
        page.altaFijaMovilRegistroPage().clicSeleccionarOferta();
    }

    public void esperarBtnLineaNueva() {
        page.altaMonoFtthTiendaPage().esperarBtnLineaNueva();
    }

    @ScreenShotBefore
    public void clickBtnLineaNueva(String btnName) {
        page.altaMonoFtthTiendaPage().clickBtnLinea(btnName);
    }

    @ScreenShotBefore
    public void validarDetallePlan() {
        page.altaMonoFtthTiendaPage().validarDetallePlan();
    }

    public void moverToElementIniciarRegistro() {
        page.altaFijaMovilRegistroPage().moverToElementIniciarRegistro();
    }

    public void scrollToViewAgendamiento() {
        page.altaMonoFtthTiendaPage().scrollToViewAgendamiento();
    }

    @ScreenShotAfter
    public void validarPantallaAgendamiento() {
        Assert.assertTrue("No se mostro pantalla de agendamiento", page.altaFijaMovilRegistroPage().validarPantallaAgendamiento());
    }

    public void ingresarDatosAgendamiento() {
        page.altaFijaTiendaPage().datosAgendamiento();
    }

    @ScreenShotBefore
    public void clickBotonConfirmarAgendamiento() {
        page.altaFijaTiendaPage().botonConfirmarAgendamiento();
    }

}
