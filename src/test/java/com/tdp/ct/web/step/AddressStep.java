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

    //@ScreenShotAfter
    public void seleccionoDireccionSugerida() {
        page.addressPage().seleccionoDireccionSugerida();
    }

    //@ScreenShotAfter
    public void typeApple(String apple) {
        page.addressPage().typeApple(apple);
    }

    //@ScreenShotAfter
    public void typeBlock(String block) {
        page.addressPage().typeBlock(block);
    }

    @ScreenShotAfter
    public void selectHouseType(String tipoVivienda) {
        page.addressPage().selectHouseType(tipoVivienda);
    }

    @ScreenShotAfter
    public void typeHouseName(String nomVivienda) {
        page.addressPage().typeHouseName(nomVivienda);
    }

    //@ScreenShotAfter
    public void typeLot(String lot) {
        page.addressPage().typeLot(lot);
    }

    //@ScreenShotAfter
    public void typeFloor(String floor) {
        page.addressPage().typeFloor(floor);
    }

    //@ScreenShotAfter
    public void typeInside(String inside) {
        page.addressPage().typeInside(inside);
    }

    //@ScreenShotAfter
    public void selectHousingComplexe(String habitacional) {
        page.addressPage().selectHousingComplexe(habitacional);
    }

    //@ScreenShotAfter
    public void typeHousingComplexName(String housingComplexName) {
        page.addressPage().typeHousingComplexName(housingComplexName);
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
        page.addressPage().selectProvince(depa, prov);
        page.addressPage().selectDistrict(depa, prov, distrito);
        page.addressPage().typeAddress(direccion);
        page.addressPage().typeReference(ref);
    }

    public void scrollDirecCompleta() {
        page.addressPage().scrollDirecCompleta();
    }

    @ScreenShotAfter
    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        page.addressPage().ingresoLasCoordenadasDeLogitudyLatitud(x, y);
    }

    //@ScreenShotAfter
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

    @ScreenShotAfter
    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        page.addressPage().validoQueSePresenteElSiguienteMensaje(mensaje);
    }

    //@ScreenShotBefore
    //@ScreenShotAfter
    public void ingresoDepartamento(String departamento) {
        page.addressPage().ingresoDepartamento(departamento);
    }

    //@ScreenShotBefore
    //@ScreenShotAfter
    public void ingresoProvincia(String provincia) {
        page.addressPage().ingresoProvincia(provincia);
    }

    //@ScreenShotBefore
    //@ScreenShotAfter
    public void ingresoDistrito(String distrito) {
        page.addressPage().ingresoDistrito(distrito);
    }

    @ScreenShotAfter
    public void clickOnSearchButton() {
        page.addressPage().clickOnSearchButton();
    }

    /**
     * FUNCION - PANTALLA INSERTAR DIRECCION
     * */

    public void validarPantallaIngresarDireccion() {
        Assert.assertTrue(page.addressPage().validarPantallaIngresarDireccion());
    }

    /**
     * FUNCION - SELECCIONAR DEPARTAMENTO
     * */

    public void selectDepartment(String name) {
        page.addressPage().selectDepartment(name);
    }

    /**
     * FUNCION - SELECCIONAR PROVINCIA
     * */

    public void selectProvince(String departamentoDireccion, String tipoProv) {
        page.addressPage().selectProvince(departamentoDireccion, tipoProv);
    }

    /**
     * FUNCION - SELECCIONAR DISTRITO
     * */

    public void selectDistrict(String departamentoDireccion, String provinciaDireccion ,String district) {
        page.addressPage().selectDistrict(departamentoDireccion, provinciaDireccion, district);
    }

    /**
     * FUNCION - INSERTAR DIRECCION
     * */

    public void typeAddress(String address) {
        page.addressPage().typeAddress(address);
    }

    /**
     * FUNCION - INSERTAR REFERENCIA
     * */

    public void typeReference(String reference) {
        page.addressPage().typeReference(reference);
    }

    /**
     * FUNCION - CLICK BOTON CONSULTAR UBICACION
     * */

    public void clickButtonConsultLocation() {
        page.addressPage().clickButtonConsultLocation();
    }

    /**
     * FUNCION - CLICK BOTON CONSULTAR COBERTURA
     * */

    public void clickButtonConsultCoverage() {
        page.addressPage().clickButtonConsultCoverage();
    }

    @ScreenShotAfter
    public void ingresarTipoDireccion(String tipodireccion) {
        page.addressPage().ingresarTipoDireccion(tipodireccion);
    }

    @ScreenShotAfter
    public void ingresarDistritoProvinciaYDepartamento(String direccion) {
        page.addressPage().ingresarDistritoProvinciaYDepartamento(direccion);
    }
    @ScreenShotAfter
    public void ingresarTipoDeVida(String tipodevia) {
        page.addressPage().ingresarTipoDeVida(tipodevia);
    }

    @ScreenShotAfter
    public void ingresarNombreVia(String nombrevia) {
        page.addressPage().ingresarNombreVia(nombrevia);

    }
    @ScreenShotAfter
    public void ingresarPuerta(String puerta) {
        page.addressPage().ingresarPuerta(puerta);

    }
    @ScreenShotAfter
    public void ingresarManzana(String manzana) {
        page.addressPage().ingresarManzana(manzana);

    }

    @ScreenShotAfter
    public void ingresarLote(String lote) {
        page.addressPage().ingresarLote(lote);

    }

    @ScreenShotAfter
    public void ingresarReferencia(String referencia) {
        page.addressPage().ingresarReferencia(referencia);

    }
    @ScreenShotAfter
    public void clickBtnConsultar() {
        page.addressPage().clickBtnConsultar();

    }

    @ScreenShotAfter
    public void clickBtnConsultarDireccion() {
        page.addressPage().clickBtnConsultarDireccion();

    }


}
