package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AddressStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressStepDefinition {

    @Autowired
    private AddressStep addressStep;

    @Y("selecciono una direccion sugerida")
    public void seleccionoUnaDireccionSugerida() {
        addressStep.seleccionoDireccionSugerida();
    }

    @Y("selecciono el departamento donde sera la entrega {string}")
    public void seleccionoElDepartamentoDondeSeraLaInstalacion(String dep) {
        addressStep.seleccionarTipoDepa(dep);
    }

    @Y("ingreso la direccion donde sera la entrega {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion(String data) {
        addressStep.writeDirec(data);
    }

    @Y("selecciono la provincia donde sera la entrega {string}")
    public void seleccionoLaProvinciaDondeSeraLaInstalacion(String provincia) {
        addressStep.seleccionarTipoProv(provincia);
    }

    @Y("ingreso la referencia de la direccion de entrega {string}")
    public void ingresoLaReferenciaDeLaDireccion(String referencia) {
        addressStep.writeReferencia(referencia);
    }

    @Y("selecciono el distrito donde sera la entrega {string}")
    public void seleccionoElDistritoDondeSeraLaInstalacion(String distri) {
        addressStep.seleccionarTipoDistrito(distri);
    }

    @Y("ingreso los datos del lugar de entrega")
    public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {
        String manzana = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lote = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String piso = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String interior = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String habitacion = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String conj = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        addressStep.writeMz(manzana);
        addressStep.writeLte(lote);
        addressStep.writePiso(piso);
        addressStep.writeInt(interior);
        addressStep.seleccionarConjunto(habitacion);
        addressStep.writeConjHab(conj);
    }

    @Y("ingreso la informacion del lugar de instalacion")
    public void iingreso_la_informacion_del_lugar_de_instalacion(DataTable dirInstalacion) {
/*
    Si se muestra ERROR realacionado con:
    - Caso 1: Dito solicita ingresar campo requerido, y la Automatización no lo registra
    - Caso 2: La automatización intenta completar un campo y no se encuentra habilitado/visible en Dito

    Se debe realizar lo siguiente, dentro del Feature:
    - Caso 1: Agregar en el dataTable el Campo y su respectivo valor
    - Caso 2: En el DataTable, dejar en blanco el valor, para que no sea considerado por la AUtomatización
*/
        UtilWeb.waitForSeconds(5);
        String manzana = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lote = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String tipoVivienda = UtilWeb.getValueFromDataTable(dirInstalacion, "tipoVivienda");
        String nombreVivienda = UtilWeb.getValueFromDataTable(dirInstalacion, "nombreVivienda");
        String piso = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String interior = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String habitacion = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String conj = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        String bloqueDir = UtilWeb.getValueFromDataTable(dirInstalacion, "bloque");
        addressStep.ingresarManzana(manzana);
        addressStep.ingresarLote(lote);
        addressStep.seleccionarTipoVivienda(tipoVivienda);
        addressStep.ingresarNombreVivienda(nombreVivienda);
        addressStep.ingresarPiso(piso);
        addressStep.ingresarInterior(interior);
        addressStep.ingresarBloque(bloqueDir);
        addressStep.ingresarManzanaDir(manzana);
        addressStep.seleccionarTipoConjuntoHabitacional(habitacion);
        addressStep.ingresarConjuntoHabitacional(conj);
    }

    @Y("ingresamos la Manzana o bloque {string}")
    public void ingresamosLaManzanaOBloque(String manzana) {
        addressStep.writeMz(manzana);
    }

    @Y("ingresamos el Lote {string}")
    public void ingresamosElLote(String lote) {
        addressStep.writeLte(lote);
    }

    @Y("ingresamos el Piso {string}")
    public void ingresamosElPiso(String piso) {
        addressStep.writePiso(piso);
    }

    @Y("ingresamos el interior {string}")
    public void ingresamosElInterior(String interior) {
        addressStep.writeInt(interior);
    }

    @Y("ingresamos el Tipo de conjunto habitacional {string}")
    public void ingresamosElTipoDeConjuntoHabitacional(String habitacion) {
        addressStep.seleccionarConjunto(habitacion);
    }

    @Y("ingresamos el Nombre del conjunto habitacional {string}")
    public void ingresamosElNombreDelConjuntoHabitacional(String conj) {
        addressStep.writeConjHab(conj);
    }

    @Entonces("me muestra la pantalla para ingresar la direccion")
    public void meMuestraLaPantallaParaIngresarLaDireccion() {
        addressStep.validarPantallaIngresarDireccion();
    }

    @Entonces("me muestra la pantalla para ingresar la direccion de entrega")
    public void meMuestraLaPantallaParaIngresarLaDireccionEntrega() {
        addressStep.validarPantallaIngresarDireccionEntrega();
    }

    @Entonces("me muestra la pantalla para verificar la direccion")
    public void meMuestraLaPantallaParaVerificarLaDireccion() {
        addressStep.validarPantallaVerificarDireccion();
    }

    @Y("completo los datos para consultar la cobertura")
    public void completoLosDatosParaConsultarLaCobertura(DataTable datos) {
        String departamento = UtilWeb.getValueFromDataTable(datos, "departamento");
        String provincia = UtilWeb.getValueFromDataTable(datos, "provincia");
        String distrito = UtilWeb.getValueFromDataTable(datos, "distrito");
        String direccion = UtilWeb.getValueFromDataTable(datos, "direccion");
        String referencia = UtilWeb.getValueFromDataTable(datos, "referencia");
        addressStep.writeDireccion(departamento, provincia, distrito, direccion, referencia);
    }

    @Y("ingreso la informacion del lugar para la instalacion")
    public void ingresoLaInformacionDelLugarParaLaInstalacion(DataTable dirInstalacion) {
        addressStep.scrollDirecCompleta();
        String manzana = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lote = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String tipoVivienda = UtilWeb.getValueFromDataTable(dirInstalacion, "tipoVivienda");
        String nombreVivienda = UtilWeb.getValueFromDataTable(dirInstalacion, "nombreVivienda");
        String bloque = UtilWeb.getValueFromDataTable(dirInstalacion, "bloque");
        String piso = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String interior = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String tipoConjH = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String conjH = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
        addressStep.writeDireccionInstalacion(manzana, lote, tipoVivienda, nombreVivienda, bloque, piso, interior, tipoConjH, conjH);
    }

    @Y("selecciono el departamento donde sera la instalacion {string}")
    public void seleccionoElDepartamentoDondeSeraLaInstalacion2(String dep) {
        addressStep.seleccionarTipoDepa(dep);
    }

    @Y("ingreso la direccion donde sera la instalacion {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion2(String data) {
        addressStep.writeDirec(data);
    }

    @Y("selecciono la provincia donde sera la instalacion {string}")
    public void seleccionoLaProvinciaDondeSeraLaInstalacion2(String provincia) {
        addressStep.seleccionarTipoProv(provincia);
    }

    @Y("ingreso la referencia de la direccion {string}")
    public void ingresoLaReferenciaDeLaDireccion2(String referencia) {
        addressStep.writeReferencia(referencia);
    }

    @Y("selecciono el distrito donde sera la instalacion {string}")
    public void seleccionoElDistritoDondeSeraLaInstalacion2(String distri) {
        addressStep.seleccionarTipoDistrito(distri);
    }

    @Y("presiono el boton Consultar ubicacion")
    public void presionoElBotonConsultarUbicacion() {
        addressStep.clickButtonConsultLocation();
    }

    @Y("presiono el boton Consultar cobertura")
    public void presionoElBotonConsultarCobertura() {
        addressStep.clickButtonConsultCoverage();
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

}
