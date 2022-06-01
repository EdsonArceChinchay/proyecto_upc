package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMonoInstalacionHfcTiendaStep {

    @Autowired
    private StepPages page;

    public void scrollToBtnCrearCliente(){ page.altaMonoHfcTiendaPage().scrollToBtnCrearCliente(); }

    @ScreenShotBefore
    public void crearCliente() { page.altaMonoHfcTiendaPage().crearCliente(); }

    public void writeDireccion(String depa, String prov, String distrito, String direccion, String ref){
        page.altaFijaAltaMovilRetailPage().seleccionarDepa(depa);
        page.altaFijaAltaMovilRetailPage().seleccionarProvincia(prov);
        page.altaFijaAltaMovilRetailPage().seleccionarDistrito(distrito);
        page.altaFijaAltaMovilRetailPage().writeDireccion(direccion);
        page.altaFijaAltaMovilRetailPage().writeReferencia(ref);
    }

    @ScreenShotBefore
    public void clickBtnConsultarUbicacion(){
        page.altaFijaAltaMovilRetailPage().btnConsultar();
    }

    public void scrollDirecCompleta(){ page.altaMonoHfcTiendaPage().scrollDirecCompleta(); }

    public void writeDireccionInstalacion(String manzana, String lote, String tipoVivienda, String nomVivienda, String piso, String interior, String tipoConjH, String conjH){
        page.altaFijaAltaMovilCallCenterPage().manzana(manzana);
        page.altaFijaAltaMovilCallCenterPage().lote(lote);
        page.altaFijaAltaMovilCallCenterPage().tipoVivienda(tipoVivienda);
        page.altaFijaAltaMovilCallCenterPage().nombreVivienda(nomVivienda);
        page.altaFijaAltaMovilCallCenterPage().piso(piso);
        page.altaFijaAltaMovilCallCenterPage().interior(interior);
        page.altaFijaAltaMovilCallCenterPage().tipoConjuntoHabitacional(tipoConjH);
        page.altaFijaAltaMovilCallCenterPage().conjuntoHabitacional(conjH);
    }

    @ScreenShotBefore
    public void clickBtnConsultarCobertura(){ page.altaMonoHfcTiendaPage().clickBtnConsultarCobertura(); }

    @ScreenShotAfter
    public void validarOfertasSugeridasView(String title){ page.altaMonoHfcTiendaPage().validarOfertasSugeridasView(title); }

    public void scrollToBtnPlanNuevo(){ page.altaMonoHfcTiendaPage().scrollToBtnPlanNuevo(); }

    @ScreenShotBefore
    public void clickBtnPlanNuevo(){ page.altaMonoHfcTiendaPage().clickBtnPlanNuevo(); }

    @ScreenShotBefore
    public void clickBtnMono(){ page.altaMonoHfcTiendaPage().clickBtnMono(); }

    public void seleccionarPlan(String plan) { page.altaFijaMovilRegistroPage().seleccionarPlan(plan); }

    @ScreenShotBefore
    public void clickSeleccionarOferta() { page.altaFijaMovilRegistroPage().clicSeleccionarOferta(); }

    public void esperarBtnLineaNueva(){ page.altaMonoHfcTiendaPage().esperarBtnLineaNueva(); }

    @ScreenShotBefore
    public void clickBtnLineaNueva(){ page.altaMonoHfcTiendaPage().clickBtnLineaNueva(); }

    @ScreenShotAfter
    public void validarDetallePlan(){ page.altaMonoHfcTiendaPage().validarDetallePlan(); }

    public void moverToElementIniciarRegistro() { page.altaFijaMovilRegistroPage().moverToElementIniciarRegistro(); }

    public void scrollToViewAgendamiento(){ page.altaMonoHfcTiendaPage().scrollToViewAgendamiento(); }

    @ScreenShotAfter
    public void validarPantallaAgendamiento() {
        Assert.assertTrue("No se mostro pantalla de agendamiento", page.altaFijaMovilRegistroPage().validarPantallaAgendamiento());
    }

    public void ingresarDatosAgendamiento(){
        page.altaFijaTiendaPage().datosAgendamiento();
    }

    @ScreenShotBefore
    public void clickBotonConfirmarAgendamiento(){
        page.altaFijaTiendaPage().botonConfirmarAgendamiento();
    }

    @ScreenShotAfter
    public void writeEmail(String correo){
        page.altaFijaAltaMovilCallCenterPage().correo(correo);
        page.altaFijaAltaMovilCallCenterPage().confirmarCorreo(correo);
    }

}
