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

    @Y("escojo un turno de agendamiento")
    public void escojoUnTurnoDeAgendamiento() {
        altaFijaMovilRegistroStep.escogerTurnoAgendamiento();
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
        altaFijaMovilRegistroStep.clicConfirmarUsuarioSupervisor();
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
    /*
    @Entonces("visualizo en pantalla el mensaje de exito")
    public void visualizoEnPantallaElMensajeDeExito() {
        altaFijaMovilRegistroStep.validarMensajeExitoso();
    }
     */

    @Y("agrego el SVA para fija HBO")
    public void agregoElSVAParaFijaHBO() {
        altaFijaMovilRegistroStep.clicEnAgregarSVA();
        altaFijaMovilRegistroStep.clicSVAHBO();
        altaFijaMovilRegistroStep.clicGuardarCambios();
    }


//CAMBIOS PARA RETAIL
    @Y("ingreso los datos del cliente a registrar")
    public void completoLosDatosDelClienteARegistrar(DataTable datos) {
        altaFijaMovilRegistroStep.ingresarDatosClienteExtranjero(datos);
        altaFijaMovilRegistroStep.clicEnCrearCliente();
    }

    @Y("completo los datos del cliente")
    public void completoLosDatosDelCliente(DataTable datosCliente) {
        altaFijaMovilRegistroStep.completarDatosClienteExtranjero(datosCliente);
        altaFijaMovilRegistroStep.clicConfirmarCliente();
        altaFijaMovilRegistroStep.datosClienteValidado();
    }

    @Y("doy click en datos del cliente")
    public void doyClickEnDatosDelCliente() {
        altaFijaMovilRegistroStep.esperarBtnDatosCliente();
        altaFijaMovilRegistroStep.clicDatosDelCliente();
    }

    @Y("me muestra pantalla para Descargar contrato")
    public void meMuestraPantallaParaDescargarContrato() {
        altaFijaMovilRegistroStep.mostrarPantallaDescargarContrato();
    }

    @Y("doy clic para descargar el contrato")
    public void doyClicParaDescargarElContrato() {
        altaFijaMovilRegistroStep.clicDescargarContrato();
    }

    @Y("doy clic en Registrar venta")
    public void doyClicEnRegistrarVenta() {
        altaFijaMovilRegistroStep.clicRegistrarVenta();
    }

    @Entonces("visualizo en pantalla el mensaje de exito de la venta generada")
    public void visualizoEnPantallaElMensajeDeExitoDeLaVentaGenerada() {
        altaFijaMovilRegistroStep.validarVentaGenerada();
    }


    @Y("doy click en agregar {string}")
    public void doyClickEnAgregar(String String) {
        altaFijaMovilRegistroStep.clicEnAgregarSVA();
        altaFijaMovilRegistroStep.agregoSVAINTERNET(String);
        altaFijaMovilRegistroStep.clicGuardarCambios();
    }
}
