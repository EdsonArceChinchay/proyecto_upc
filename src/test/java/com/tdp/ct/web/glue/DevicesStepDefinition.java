package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.DevicesStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class DevicesStepDefinition {

    @Autowired
    private DevicesStep devicesStep;

    @Y("ingreso el tiempo de permanencia{string}")
    public void ingresoElTiempoDePermanencia(String TiempoP) {
        devicesStep.selectTimeOfPermanency(TiempoP);
    }

    @Y("busco el equipo {string}")
    public void seleccionoElEquipo(String device) {
        devicesStep.typeDeviceAndSearch(device);
    }

    @Y("ingreso el tipo de pago {string}")
    public void ingresoElTipoDePago(String payment) {
        devicesStep.selectTypeOfPayment(payment);
    }

    @Y("doy click en el boton seleccionar")
    public void doyClickEnElBotonSeleccionar() {
        devicesStep.clickButtonSelect();
    }

    @E("ingreso permanencia, tipo de pago y equipo")
    public void ingresoPermanenciaTipoPagoYEquipo(DataTable datos) {
        String permanencia = UtilWeb.getValueFromDataTable(datos, "permanencia");
        String tipoPago = UtilWeb.getValueFromDataTable(datos, "tipoPago");
        String equipoName = UtilWeb.getValueFromDataTable(datos, "equipoName");
        devicesStep.typeDeviceAndSearch(equipoName);
        devicesStep.selectTimeOfPermanency(permanencia);
        devicesStep.selectTypeOfPayment(tipoPago);

    }

    @Y("valido que existan resultados busqueda de equipos")
    public void validoQueExistanResultadosBusquedaDeEquipos() {
        Assert.assertTrue("La cantidad de equipos es menor que 1", devicesStep.quantityOfDevicesOfTheSearchResult() >= 1);
    }

    @Y("presiono el boton Ver detalle valido contenido y selecciono")
    public void presionoBotonVerDetalleValidoContenidoYSelecciono() {
        devicesStep.scrollToButtonSeeDetail();
        devicesStep.clickButtonSeeDetail();
        devicesStep.validateFeatures();
        devicesStep.clickButtonSelectDevice();
    }

    @Y("visualizo la seleccion en la pantalla de ofertas")
    public void visualizoLaSeleccionEnLaPantallaDeOfertas() {
        devicesStep.scrollToOfertDetails();
    }

    @Y("presiono el boton Ver detalle valido contenido y selecciono el equipo elegido {string}")
    public void presionoBotonVerDetalleValidoContenidoYSeleccionoElEquipoElegido(String device) {
        devicesStep.scrollToDeviceList();
        devicesStep.clickBtnSeeDeviceDetails(device);
        devicesStep.validateFeatures();
        devicesStep.clickButtonSelectDevice();
    }

    /**
     * FUNCION VALIDAR STOCK EQUIPO
     * */

    @Y("valido el stock del equipo")
    public void validarStockDeEquipo() {
        devicesStep.validarStockDeEquipo();
    }
}
