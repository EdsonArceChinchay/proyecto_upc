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


    @Entonces("me muestra la pantalla para ingresar la direccion")
    public void meMuestraLaPantallaParaIngresarLaDireccion() {
        altaFijaMovilRegistroStep.validarPantallaIngresarDireccion();
    }

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
        altaFijaMovilRegistroStep.clicBotonSeleccionarOferta();
        altaFijaMovilRegistroStep.clicIrAMovistarTotal();
    }

    @Y("valido el detalle de la seleccion")
    public void validoElDetalleDeLaSeleccion() {
        altaFijaMovilRegistroStep.validarDetalleSeleccion();
    }

    @Cuando("doy clic a iniciar registro")
    public void doyClicAIniciarRegistro() {
        altaFijaMovilRegistroStep.moverToElementIniciarRegistro();
        altaFijaMovilRegistroStep.clicIniciarRegistro();
    }

    @Y("valido que me encuentre en la pantalla agendamiento")
    public void validoQueMeEncuentreEnLaPantallaAgendamiento() {
        altaFijaMovilRegistroStep.validarPantallaAgendamiento();
    }

    @Y("ingreso datos del contacto en la pantalla agendamiento {string}")
    public void ingresoDatosDelContactoEnLaPantallaAgendamiento(String contacto) {
        altaFijaMovilRegistroStep.ingresarContacto(contacto);
    }

    @Y("doy clic en confirmar agendamiento")
    public void doyClicEnConfirmarAgendamiento() {
        altaFijaMovilRegistroStep.clicConfirmarAgendamiento();
    }
    @Entonces("me muestra el detalle de la instalacion")
    public void meMuestraElDetalleDeLaInstalacion() {
        altaFijaMovilRegistroStep.validarDetalleInstalacion();
    }

    @Y("doy clic en confirmar")
    public void doyClicEnConfirmar() {
        altaFijaMovilRegistroStep.clicConfirmarInstalacion();
    }

    @Y("completo los datos solicitados {string}")
    public void completoLosDatosSolicitados(String correo) {
        altaFijaMovilRegistroStep.completarCorreo(correo);
    }

    @Y("doy click en validar identidad del titular")
    public void doyClickEnValidarIdentidadDelTitular() {
        altaFijaMovilRegistroStep.clicValidarIdentidadTitular();
    }

    @Y("elijo el tipo de validacion a realizar {string}")
    public void elijoElTipoDeValidacionARealizar(String tipoValidacion) {
        altaFijaMovilRegistroStep.seleccionoTipoValidacion(tipoValidacion);
    }

    @Y("ingreso los datos del supervisor")
    public void ingresoLosDatosDelSupervisor(DataTable datos) {
        altaFijaMovilRegistroStep.ingresarDatosSupervisor(datos);
    }

    @Y("ingreso los datos solicitados para la validacion del cliente")
    public void ingresoLosDatosSolicitadosParaLaValidacionDelCliente(DataTable datos) {
        UtilWeb.waitForSeconds(3);
        for(int i=0;i<3;i++){
            altaFijaMovilRegistroStep.ingresarDatosValidacionSolicitada(datos);
            altaFijaMovilRegistroStep.clicEnSiguiente();
        }
            altaFijaMovilRegistroStep.clicEnConfirmar();
    }
    @Entonces("valido que me muestre el boton con el texto de identidad validada")
    public void validoQueMeMuestreElBotonConElTextoDeIdentidadValidada() {
        altaFijaMovilRegistroStep.validarIdentidadValidada();
    }

    @Y("doy clic para validar contrato Movil")
    public void doyClicParaValidarContratoMovil() {
        altaFijaMovilRegistroStep.clicValidarContrato();
    }
    @Y("doy clic en continuar")
    public void doyClicEnContinuar() {
        altaFijaMovilRegistroStep.clicBotonContinuar();
    }

    @Y("me muestra en pantalla el contrato solicitado")
    public void meMuestraEnPantallaElContratoSolicitado() {
        altaFijaMovilRegistroStep.visualizarContratoEnPantalla();
    }

    @Cuando("doy clic en si acepto")
    public void doyClicEnSiAcepto() {
        altaFijaMovilRegistroStep.clicSiAcepto();
    }

    @Entonces("visualizo en pantalla el mensaje de exito")
    public void visualizoEnPantallaElMensajeDeExito() {
        altaFijaMovilRegistroStep.validarMensajeExitoso();
    }


    @Y("doy click en validar huella")
    public void doyClickEnValidarHuella() {
        UtilWeb.waitForSeconds(3);
        altaFijaMovilRegistroStep.clicValidarHuella();
    }


    @Y("doy click en boton confirmar huella")
    public void doyClickEnBotonConfirmarHuella() {
        UtilWeb.waitForSeconds(3);
        altaFijaMovilRegistroStep.clicEnConfirmar();
    }
}
