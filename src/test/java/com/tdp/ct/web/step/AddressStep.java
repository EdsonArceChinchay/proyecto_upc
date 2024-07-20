package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void seleccionoDireccionSugerida() {
        page.addressPage().seleccionoDireccionSugerida();
    }

    public void ingresarManzana(String manzana) {
        page.addressPage().manzana(manzana);
    }

    public void ingresarLote(String lote) {
        page.addressPage().lote(lote);
    }

    public void seleccionarTipoVivienda(String tipoVivienda) {
        page.addressPage().tipoVivienda(tipoVivienda);
    }

    public void ingresarNombreVivienda(String nomVivienda) {
        page.addressPage().nombreVivienda(nomVivienda);
    }

    public void ingresarPiso(String piso) {
        page.addressPage().piso(piso);
    }

    public void ingresarInterior(String interior) {
        page.addressPage().interior(interior);
    }

    public void ingresarBloque(String bloque) {
        page.addressPage().bloque(bloque);
    }

    public void ingresarManzanaDir(String manzana) {
        page.addressPage().manzanaDir(manzana);
    }

    public void seleccionarTipoConjuntoHabitacional(String data) {
        page.addressPage().tipoConjuntoHabitacional(data);
    }

    public void ingresarConjuntoHabitacional(String data) {
        page.addressPage().conjuntoHabitacional(data);
    }

    public void clickButtonConsultCoverage() {
        page.addressPage().clickButtonConsultCoverage();
    }

    @ScreenShotAfter
    public void seleccionarTipoDepa(String tipoDepa) {
        page.addressPage().seleccionarDepa(tipoDepa);
    }

    @ScreenShotAfter
    public void seleccionarTipoProv(String tipoProv) {
        page.addressPage().seleccionarProvincia(tipoProv);
    }

    @ScreenShotAfter
    public void seleccionarTipoDistrito(String tipoDis) {
        page.addressPage().seleccionarDistrito(tipoDis);
    }

    @ScreenShotAfter
    public void writeDirec(String data) {
        page.addressPage().writeDireccion(data);
    }

    @ScreenShotAfter
    public void writeReferencia(String data1) {
        page.addressPage().writeReferencia(data1);
    }

    @ScreenShotAfter
    public void clickButtonConsultLocation() {
        page.addressPage().clickButtonConsultLocation();
    }

    @ScreenShotAfter
    public void writeMz(String data2) {
        page.addressPage().writeManzana(data2);
    }

    @ScreenShotAfter
    public void writeLte(String data3) {
        page.addressPage().writeLote(data3);
    }

    @ScreenShotAfter
    public void writePiso(String data4) {
        page.addressPage().writePiso(data4);
    }

    @ScreenShotAfter
    public void writeInt(String data5) {
        page.addressPage().writeInterior(data5);
    }

    @ScreenShotAfter
    public void seleccionarConjunto(String habitacional) {
        page.addressPage().seleccionarConjuntoHabitacional(habitacional);
    }

    @ScreenShotAfter
    public void writeConjHab(String data6) {
        page.addressPage().writeConjHab(data6);
    }

    @ScreenShotAfter
    public void validarPantallaIngresarDireccion() {
        Assert.assertTrue(page.addressPage().validarPantallaIngresarDireccion());
    }

    @ScreenShotAfter
    public void validarPantallaIngresarDireccionEntrega() {
        Assert.assertTrue(page.addressPage().validarPantallaIngresarDireccionEntrega());
    }

    @ScreenShotAfter
    public void validarPantallaVerificarDireccion() {
        Assert.assertTrue(page.addressPage().validarPantallaVerificarDireccion());
    }

    public void writeDireccion(String depa, String prov, String distrito, String direccion, String ref) {
        page.addressPage().seleccionarDepa(depa);
        page.addressPage().seleccionarProvincia(prov);
        page.addressPage().seleccionarDistrito(distrito);
        page.addressPage().writeDireccion(direccion);
        page.addressPage().writeReferencia(ref);
    }

    public void writeDireccionInstalacion(String manzana, String lote, String tipoVivienda, String nomVivienda, String bloque, String piso, String interior, String tipoConjH, String conjH) {
        page.addressPage().manzana(manzana);
        page.addressPage().lote(lote);
        page.addressPage().tipoVivienda(tipoVivienda);
        page.addressPage().nombreVivienda(nomVivienda);
        page.addressPage().bloque(bloque);
        page.addressPage().piso(piso);
        page.addressPage().interior(interior);
        page.addressPage().tipoConjuntoHabitacional(tipoConjH);
        page.addressPage().conjuntoHabitacional(conjH);
    }

    public void scrollDirecCompleta() {
        page.addressPage().scrollDirecCompleta();
    }

    @ScreenShotAfter
    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        page.addressPage().ingresoLasCoordenadasDeLogitudyLatitud(x, y);
    }

    @ScreenShotAfter
    public void validoQueLaDireccionSea(String direccion) {
        page.addressPage().validoQueLaDireccionSea(direccion);
    }

    @ScreenShotAfter
    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        page.addressPage().validoQueQueMeMuestreElMensajdeDeError(msj);

    }

    @ScreenShotAfter
    public void doyClickAceptarEnElModalDeError() {
        page.addressPage().doyClickAceptarEnElModalDeError();

    }

}
