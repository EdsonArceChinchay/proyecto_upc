package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaAltaMovilStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void btnHogar() {
        page.altaFijaAltaMovilRetailPage().altaHogar();
    }

    @ScreenShotAfter
    public void btnMovil() {
        page.altaFijaAltaMovilRetailPage().altaMovil();
    }

    @ScreenShotAfter
    public void btnMostrar() {
        page.altaFijaAltaMovilRetailPage().mostrarOfertas();
    }

    @ScreenShotAfter
    public void seleccionarTipoDepa(String tipoDepa) {
        page.altaFijaAltaMovilRetailPage().seleccionarDepa(tipoDepa);
    }

    @ScreenShotAfter
    public void seleccionarTipoProv(String tipoProv) {
        page.altaFijaAltaMovilRetailPage().seleccionarProvincia(tipoProv);
    }

    @ScreenShotAfter
    public void seleccionarTipoDistrito(String tipoDis) {
        page.altaFijaAltaMovilRetailPage().seleccionarDistrito(tipoDis);
    }

    @ScreenShotAfter
    public void writeDirec(String data) {
        page.altaFijaAltaMovilRetailPage().writeDireccion(data);
    }

    @ScreenShotAfter
    public void writeReferencia(String data1) {
        page.altaFijaAltaMovilRetailPage().writeReferencia(data1);
    }

    @ScreenShotAfter
    public void btnConsulta() {
        page.altaFijaAltaMovilRetailPage().btnConsultar();
    }

    @ScreenShotAfter
    public void writeMz(String data2) {
        page.altaFijaAltaMovilRetailPage().writeManzana(data2);
    }

    @ScreenShotAfter
    public void writeLte(String data3) {
        page.altaFijaAltaMovilRetailPage().writeLote(data3);
    }

    @ScreenShotAfter
    public void writePiso(String data4) {
        page.altaFijaAltaMovilRetailPage().writePiso(data4);
    }

    @ScreenShotAfter
    public void writeInt(String data5) {
        page.altaFijaAltaMovilRetailPage().writeInterior(data5);
    }


    @ScreenShotAfter
    public void seleccionarConjunto(String habitacional) {
        page.altaFijaAltaMovilRetailPage().seleccionarConjuntoHabitacional(habitacional);
    }

    @ScreenShotAfter
    public void writeConjHab(String data6) {
        page.altaFijaAltaMovilRetailPage().writeConjHab(data6);
    }

    @ScreenShotAfter
    public void btnCobertura(){
        page.altaFijaAltaMovilRetailPage().consultaCobertura();
    }

    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue(page.altaFijaAltaMovilRetailPage().validarQueExistanOfertasSugeridas());
    }

    public void seleccionarOferta(String oferta) {

        page.altaFijaAltaMovilRetailPage().seleccionarOferta(oferta);
    }

    public void seleccionarPlan(String plan) {
        page.altaFijaAltaMovilRetailPage().seleccionarPlan();
    }

    public void validarDetalleSeleccion() {
        page.altaFijaAltaMovilRetailPage().validarDetalleSeleccion();
    }

    public void clicIniciarRegistro() {
        page.altaFijaAltaMovilRetailPage().clicIniciarRegistro();
    }
}
