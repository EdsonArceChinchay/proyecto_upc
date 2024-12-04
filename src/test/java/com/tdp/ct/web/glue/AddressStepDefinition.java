package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AddressStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

public class AddressStepDefinition {

    @Autowired
    private AddressStep addressStep;

    @Entonces("me muestra la pantalla para ingresar la direccion de entrega")
    public void meMuestraLaPantallaParaIngresarLaDireccionEntrega() {
        addressStep.validarPantallaIngresarDireccionEntrega();
    }

    @Entonces("me muestra la pantalla para ingresar la direccion")
    public void meMuestraLaPantallaParaIngresarLaDireccion() {
        addressStep.validarPantallaIngresarDireccion();
    }

    @Entonces("me muestra la pantalla para verificar la direccion")
    public void meMuestraLaPantallaParaVerificarLaDireccion() {
        addressStep.validarPantallaVerificarDireccion();
    }

    @Y("selecciono el departamento donde sera la instalacion {string}")
    public void seleccionoElDepartamentoDondeSeraLaInstalacion(String name) {
        addressStep.selectDepartment(name);
    }

    @Y("selecciono el departamento donde sera la entrega {string}")
    public void seleccionoElDepartamentoDondeSeraLaEntrega(String name) {
        addressStep.selectDepartment(name);
    }

    @Y("selecciono el departamento donde se instalara {string}")
    public void ingresoDepartamento(String department) {
        addressStep.ingresoDepartamento(department);
    }

    @Y("selecciono el distrito donde sera la instalacion {string}")
    public void seleccionoElDistritoDondeSeraLaInstalacion(String distri) {
        addressStep.selectDistrict(distri);
    }

    @Y("selecciono el distrito donde sera la entrega {string}")
    public void seleccionoElDistritoDondeSeraLaEntrega(String distri) {
        addressStep.selectDistrict(distri);
    }

    @Y("selecciono el distrito donde se instalara {string}")
    public void ingresoDistrito(String distrito) {
        addressStep.ingresoDistrito(distrito);
    }

    @Y("selecciono la provincia donde sera la entrega {string}")
    public void seleccionoLaProvinciaDondeSeraLaInstalacion(String provincia) {
        addressStep.selectProvince(provincia);
    }

    @Y("selecciono la provincia donde sera la instalacion {string}")
    public void seleccionoLaProvinciaDondeSeraLaInstalacion2(String provincia) {
        addressStep.selectProvince(provincia);
    }

    @Y("selecciono la provincia donde se instalara {string}")
    public void ingresoProvincia(String provincia) {
        addressStep.ingresoProvincia(provincia);
    }

    @Y("ingreso la direccion donde sera la entrega {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion(String data) {
        addressStep.typeAddress(data);
    }

    @Y("ingreso la direccion donde sera la instalacion {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion2(String data) {
        addressStep.typeAddress(data);
    }

    @Y("ingreso la referencia de la direccion de entrega {string}")
    public void ingresoLaReferenciaDeLaDireccionDeEntrega(String referencia) {
        addressStep.typeReference(referencia);
    }

    @Y("ingreso la referencia de la direccion {string}")
    public void ingresoLaReferenciaDeLaDireccion(String referencia) {
        addressStep.typeReference(referencia);
    }

    @Y("ingreso los datos del lugar de entrega")
    public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {
        String apple = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lot = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String floor = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String inside = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String housingComplexe = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String housingComplexName = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        validateInputsAddress(apple, lot, floor, inside, null, null, null, housingComplexe, housingComplexName);
    }

    @Y("ingreso la informacion del lugar de instalacion")
    public void iingreso_la_informacion_del_lugar_de_instalacion(DataTable dirInstalacion) {
        String apple = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lot = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String houseType = UtilWeb.getValueFromDataTable(dirInstalacion, "tipoVivienda");
        String houseName = UtilWeb.getValueFromDataTable(dirInstalacion, "nombreVivienda");
        String floor = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String inside = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String housingComplexe = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String housingComplexName = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        String block = UtilWeb.getValueFromDataTable(dirInstalacion, "bloque");
        validateInputsAddress(apple, lot, floor, inside, block, houseType, houseName, housingComplexe, housingComplexName);
    }

    @Y("ingresamos la Manzana o bloque {string}")
    public void ingresamosLaManzanaOBloque(String manzana) {
        addressStep.typeApple(manzana);
    }

    @Y("ingresamos el Lote {string}")
    public void ingresamosElLote(String lote) {
        addressStep.typeLot(lote);
    }

    @Y("ingresamos el Piso {string}")
    public void ingresamosElPiso(String piso) {
        addressStep.typeFloor(piso);
    }

    @Y("ingresamos el interior {string}")
    public void ingresamosElInterior(String interior) {
        addressStep.typeInside(interior);
    }

    @Y("ingresamos el Tipo de conjunto habitacional {string}")
    public void ingresamosElTipoDeConjuntoHabitacional(String habitacion) {
        addressStep.selectHousingComplexe(habitacion);
    }

    @Y("ingresamos el Nombre del conjunto habitacional {string}")
    public void ingresamosElNombreDelConjuntoHabitacional(String conj) {
        addressStep.typeHousingComplexName(conj);
    }

    @Y("completo los datos para consultar la cobertura")
    public void completoLosDatosParaConsultarLaCobertura(DataTable datos) {
        String departamento = UtilWeb.getValueFromDataTable(datos, "departamento");
        String provincia = UtilWeb.getValueFromDataTable(datos, "provincia");
        String distrito = UtilWeb.getValueFromDataTable(datos, "distrito");
        String direccion = UtilWeb.getValueFromDataTable(datos, "direccion");
        String referencia = UtilWeb.getValueFromDataTable(datos, "referencia");
        addressStep.typeAddressComplete(departamento, provincia, distrito, direccion, referencia);
    }

    @Y("ingreso la informacion del lugar para la instalacion")
    public void ingresoLaInformacionDelLugarParaLaInstalacion(DataTable dirInstalacion) {
        addressStep.scrollDirecCompleta();
        String apple = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lot = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String block = UtilWeb.getValueFromDataTable(dirInstalacion, "bloque");
        String floor = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String inside = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String houseType = UtilWeb.getValueFromDataTable(dirInstalacion, "tipoVivienda");
        String houseName = UtilWeb.getValueFromDataTable(dirInstalacion, "nombreVivienda");
        String housingComplexe = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String housingComplexName = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        validateInputsAddress(apple, lot, floor, inside, block, houseType, houseName, housingComplexe, housingComplexName);
    }

    @Y("presiono el boton Consultar ubicacion")
    public void presionoElBotonConsultarUbicacion() {
        addressStep.clickButtonConsultLocation();
    }

    @Y("presiono el boton Consultar cobertura")
    public void presionoElBotonConsultarCobertura() {
        addressStep.clickButtonConsultCoverage();
    }

    @Y("selecciono una direccion sugerida")
    public void seleccionoUnaDireccionSugerida() {
        addressStep.seleccionoDireccionSugerida();
    }

    @Y("ingreso las coordenadas de Longitud X: {string} y Latitud Y:{string}")
    public void ingresoLasCoordenadasDeLogitudyLatitud(String x, String y) {
        addressStep.ingresoLasCoordenadasDeLogitudyLatitud(x, y);
    }

    @Y("valido que la direccion sea {string}")
    public void validoQueLaDireccionSea(String direccion) {
        addressStep.validoQueLaDireccionSea(direccion);
    }

    @Y("valido que que me muestre el mensajde de error {string}")
    public void validoQueQueMeMuestreElMensajdeDeError(String msj) {
        addressStep.validoQueQueMeMuestreElMensajdeDeError(msj);
    }

    @Y("doy click Aceptar en el modal de error")
    public void doyClickAceptarEnElModalDeError() {
        addressStep.doyClickAceptarEnElModalDeError();
    }

    @Y("valido que se presente el siguiente mensaje {string}")
    public void validoQueSePresenteElSiguienteMensaje(String mensaje) {
        addressStep.validoQueSePresenteElSiguienteMensaje(mensaje);
    }

    public void validateInputsAddress(String apple, String lot, String floor, String inside, String block, String houseType, String houseName, String housingComplexe, String housingComplexName) {
        if (!(apple == null) && !(lot == null)) {
            addressStep.typeApple(apple);
            addressStep.typeLot(lot);
        }
        if (!(floor == null) && (inside == null) && (block == null)) {
            logInfo("Inside and block is null change value: NA");
            block = "NA";
            inside = "NA";
        } else if (!(inside == null) && (block == null)) {
            logInfo("Block is null change value: NA");
            block = "NA";
        } else if ((inside == null) && !(block == null)) {
            logInfo("Inside is null change value: 1");
            inside = "1";
        }
        addressStep.selectHouseType(houseType);
        addressStep.typeHouseName(houseName);
        addressStep.typeBlock(block);
        addressStep.typeFloor(floor);
        addressStep.typeInside(inside);
        addressStep.selectHousingComplexe(housingComplexe);
        addressStep.typeHousingComplexName(housingComplexName);
    }

    @Y("doy click en el boton Buscar")
    public void doyClickEnElBotonBuscar() {
        addressStep.clickOnSearchButton();
    }
}
