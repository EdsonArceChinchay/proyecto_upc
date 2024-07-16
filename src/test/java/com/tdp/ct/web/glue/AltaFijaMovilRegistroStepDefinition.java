package com.tdp.ct.web.glue;

import com.tdp.ct.web.CaptchaBase.Parameters;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaFijaMovilRegistroStepDefinition {

    @Autowired
    private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    private Customer customer;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Entonces("me muestra la pantalla para ingresar la direccion")
    public void meMuestraLaPantallaParaIngresarLaDireccion() {
        altaFijaMovilRegistroStep.validarPantallaIngresarDireccion();
    }

    @Entonces("me muestra la pantalla registrar venta")
    public void meMuestraLaPantallaParaRegistrarVenta() {
        altaFijaMovilRegistroStep.validarPantallaRegistrarVenta();
    }

    @Entonces("me muestra la pantalla para ingresar la direccion de entrega")
    public void meMuestraLaPantallaParaIngresarLaDireccionEntrega() {
        altaFijaMovilRegistroStep.validarPantallaIngresarDireccionEntrega();
    }

    @Entonces("me muestra la pantalla para verificar la direccion")
    public void meMuestraLaPantallaParaVerificarLaDireccion() {
        altaFijaMovilRegistroStep.validarPantallaVerificarDireccion();
    }

    @Y("ingreso los datos del lugar de instalacion")
    public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {

        String manzana = UtilWeb.getValueFromDataTable(dirInstalacion, "mz");
        String lote = UtilWeb.getValueFromDataTable(dirInstalacion, "lote");
        String piso = UtilWeb.getValueFromDataTable(dirInstalacion, "piso");
        String interior = UtilWeb.getValueFromDataTable(dirInstalacion, "int");
        String habitacion = UtilWeb.getValueFromDataTable(dirInstalacion, "conjunto");
        String conj = UtilWeb.getValueFromDataTable(dirInstalacion, "conjHabit");
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
    public void completoLosDatosSolicitados(String email) {
        altaFijaMovilRegistroStep.completarCorreo(email);
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
        for (int i = 0; i < 3; i++) {
            altaFijaMovilRegistroStep.ingresarDatosValidacionSolicitada(datos, i);
            System.out.println("-- click en siguiente --");
            altaFijaMovilRegistroStep.clicEnSiguiente();
        }
        System.out.println("----- termino preguntas ----------");
        UtilWeb.waitForSeconds(3);
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

    @Y("imprimo el texto del contrato solicitado")
    public void imprimoElTextoDelContratoSolicitado() {
        this.scenario.log(altaFijaMovilRegistroStep.getTextoSolicitud());
        this.scenario.log("[Código de Venta: " + altaFijaMovilRegistroStep.getSalesCode() + "]");
    }

    @Cuando("doy clic en si acepto")
    public void doyClicEnSiAcepto() {
        altaFijaMovilRegistroStep.clicSiAcepto();
    }

    //CAMBIOS PARA RETAIL
    @Y("ingreso los datos del cliente a registrar")
    public void completoLosDatosDelClienteARegistrar(DataTable value) throws JSONException {
        altaFijaMovilRegistroStep.verificarClienteNuevo();
        altaFijaMovilRegistroStep.ingresarDatosClienteExtranjero(value);
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
        if (customer.isNewCustomer()) {
            altaFijaMovilRegistroStep.esperarBtnDatosCliente();
            altaFijaMovilRegistroStep.clicDatosDelCliente();
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @Y("me muestra pantalla para Descargar contrato")
    public void meMuestraPantallaParaDescargarContrato() {
        altaFijaMovilRegistroStep.mostrarPantallaDescargarContrato();
    }

    @Y("doy clic para descargar el contrato")
    public void doyClicParaDescargarElContrato() throws InterruptedException {
        if (Parameters.estadoFlujo) {
            altaFijaMovilRegistroStep.clicDescargarContrato();
        }
    }

    @Y("doy clic en Registrar venta")
    public void doyClicEnRegistrarVenta() {
        altaFijaTiendaStep.clickRegistrarVenta();
    }

    @Entonces("visualizo en pantalla el mensaje de exito de la venta generada")
    public void visualizoEnPantallaElMensajeDeExitoDeLaVentaGenerada() throws JSONException {
        altaFijaMovilRegistroStep.validarVentaGenerada();
        this.scenario.log("[Código de Venta: " + altaFijaMovilRegistroStep.getSalesCode() + "]");
        this.scenario.log(this.customer.getOrdersCode().toString());
    }

    @Y("doy click en el boton confirmar validacion")
    public void doyClickEnElBotonConfirmarValidacion() {
        altaFijaMovilRegistroStep.clicConfirmarCliente();
    }
}
