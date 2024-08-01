package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
public class AddressStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void seleccionoDireccionSugerida() {
        page.addressPage().seleccionoDireccionSugerida();
    }

    public void ingresarManzana(String manzana) {
        page.addressPage().typeApple(manzana);
    }

    public void seleccionarTipoVivienda(String tipoVivienda) {
        page.addressPage().selectHouseType(tipoVivienda);
    }

    public void ingresarNombreVivienda(String nomVivienda) {
        page.addressPage().typeHouseName(nomVivienda);
    }

    public void ingresarBloque(String bloque) {
        page.addressPage().typeBlock(bloque);
    }

    public void clickButtonConsultCoverage() {
        page.addressPage().clickButtonConsultCoverage();
    }

    @ScreenShotAfter
    public void selectDepartment(String name) {
        page.addressPage().selectDepartment(name);
    }

    @ScreenShotAfter
    public void selectProvince(String tipoProv) {
        page.addressPage().selectProvince(tipoProv);
    }

    @ScreenShotAfter
    public void selectDistrict(String district) {
        page.addressPage().seleccionarDistrito(district);
    }

    @ScreenShotAfter
    public void typeAddress(String data) {
        page.addressPage().typeAddress(data);
    }

    @ScreenShotAfter
    public void typeReference(String reference) {
        page.addressPage().typeReference(reference);
    }

    @ScreenShotAfter
    public void clickButtonConsultLocation() {
        page.addressPage().clickButtonConsultLocation();
    }

    @ScreenShotAfter
    public void typeApple(String apple) {
        page.addressPage().typeApple(apple);
    }

    @ScreenShotAfter
    public void typeLot(String lot) {
        page.addressPage().typeLot(lot);
    }

    @ScreenShotAfter
    public void typeFloor(String floor) {
        page.addressPage().typeFloor(floor);
    }

    @ScreenShotAfter
    public void typeInside(String inside) {
        page.addressPage().typeInside(inside);
    }

    @ScreenShotAfter
    public void selectHousingComplexe(String habitacional) {
        page.addressPage().selectHousingComplexe(habitacional);
    }

    @ScreenShotAfter
    public void typeHousingComplexName(String housingComplexName) {
        page.addressPage().typeHousingComplexName(housingComplexName);
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

    public void typeAddressComplete(String depa, String prov, String distrito, String direccion, String ref) {
        page.addressPage().selectDepartment(depa);
        page.addressPage().selectProvince(prov);
        page.addressPage().seleccionarDistrito(distrito);
        page.addressPage().typeAddress(direccion);
        page.addressPage().typeReference(ref);
    }

    public void typeAddressInstalacion(String apple, String lot, String tipoVivienda, String nomVivienda, String block, String floor, String inside, String tipoConjH, String conjH) {
        if (!(apple==null) && !(lot==null)) {
            page.addressPage().typeApple(apple);
            page.addressPage().typeLot(lot);
        }
        else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Apple and lot is null" );
        }
        if (!(floor==null) && (inside==null) && (block==null) ) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Inside and block is null change value: NA" );
            block = "NA";
            inside ="NA";
        }

        else if (!(inside==null) && (block==null)) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Block is null change value: NA" );
            block = "NA";
        }

        else if((inside==null) && !(block==null)){
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Inside is null change value: 1" );
            inside ="1";
        }
        page.addressPage().typeBlock(block);
        page.addressPage().typeFloor(floor);
        page.addressPage().typeInside(inside);

        page.addressPage().selectHouseType(tipoVivienda);
        page.addressPage().typeHouseName(nomVivienda);
        page.addressPage().selectHousingComplexe(tipoConjH);
        page.addressPage().typeHousingComplexName(conjH);
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

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoDepartamento(String departamento) {
        page.addressPage().ingresoDepartamento(departamento);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoProvincia(String provincia) {
        page.addressPage().ingresoProvincia(provincia);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoDistrito(String distrito) {
        page.addressPage().ingresoDistrito(distrito);
    }
}
