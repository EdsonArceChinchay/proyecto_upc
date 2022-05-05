package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaMovilRegistroStepDefinition {

    @Autowired
    private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;
    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("ingreso los datos del lugar de instalacion")
    public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {
        String manzana= UtilWeb.getValueFromDataTable(dirInstalacion,"mz");
        String lote= UtilWeb.getValueFromDataTable(dirInstalacion,"lote");
        String piso= UtilWeb.getValueFromDataTable(dirInstalacion,"piso");
        String interior= UtilWeb.getValueFromDataTable(dirInstalacion,"int");
        String habitacion= UtilWeb.getValueFromDataTable(dirInstalacion,"conjunto");
        String conj= UtilWeb.getValueFromDataTable(dirInstalacion,"conjHabit");
        altaFijaAltaMovilRetailStep.writeMz(manzana);
        altaFijaAltaMovilRetailStep.writeLte(lote);
        altaFijaAltaMovilRetailStep.writePiso(piso);
        altaFijaAltaMovilRetailStep.writeInt(interior);
        altaFijaAltaMovilRetailStep.seleccionarConjunto(habitacion);
        altaFijaAltaMovilRetailStep.writeConjHab(conj);
    }


    @Entonces("me muestra la pantalla de ofertas sugeridos")
    public void meMuestraLaPantallaDeOfertasSugeridos() {
        altaFijaMovilRegistroStep.mostrarDetalleOfertasSugeridas();
    }

    @Y("selecciono el tipo de oferta {string}")
    public void seleccionoElTipoDeOferta(String oferta) {
        altaFijaMovilRegistroStep.seleccionarOferta(oferta);
    }

    @Y("selecciono el tipo de plan {string}")
    public void seleccionoElTipoDePlan(String plan) {
        altaFijaMovilRegistroStep.seleccionarPlan(plan);
    }

    @Y("valido el detalle de la seleccion")
    public void validoElDetalleDeLaSeleccion() {
        altaFijaMovilRegistroStep.validarDetalleSeleccion();
    }

    @Cuando("doy clic a iniciar registro")
    public void doyClicAIniciarRegistro() {
        altaFijaMovilRegistroStep.clicIniciarRegistro();
    }

    @Y("seleciono la fecha y hora del agendamiento")
    public void selecionoLaFechaYHoraDelAgendamiento() {

    }

    @Entonces("me muestra el detalle de la instalacion")
    public void meMuestraElDetalleDeLaInstalacion() {

    }

    @Y("doy clic en confirmar")
    public void doyClicEnConfirmar() {

    }

    @Y("completo los datos solicitados {string}")
    public void completoLosDatosSolicitados(String correo) {

    }

    @Y("doy click en validar identidad del titular")
    public void doyClickEnValidarIdentidadDelTitular() {

    }

    @Y("elijo el tipo de validacion a realizar {string}")
    public void elijoElTipoDeValidacionARealizar(String tipoValidacion) {

    }

    @Entonces("valido que me muestre el boton con el texto de identidad validada")
    public void validoQueMeMuestreElBotonConElTextoDeIdentidadValidada() {

    }

    @Y("ingreso los datos solicitados para la validacion del cliente")
    public void ingresoLosDatosSolicitadosParaLaValidacionDelCliente(DataTable datos) {

    }

    @Y("doy clic en continuar")
    public void doyClicEnContinuar() {

    }

    @Y("me muestra en pantalla el contrato solicitado")
    public void meMuestraEnPantallaElContratoSolicitado() {

    }

    @Cuando("doy clic en si acepto")
    public void doyClicEnSiAcepto() {

    }

    @Entonces("visualizo en pantalla el mensaje de exito")
    public void visualizoEnPantallaElMensajeDeExito() {

    }

    @Y("muestro en consola el numero de registro generado")
    public void muestroEnConsolaElNumeroDeRegistroGenerado() {

    }

    @Y("doy clic para ver el contrato PDF")
    public void doyClicParaVerElContratoPDF() {

    }

}
