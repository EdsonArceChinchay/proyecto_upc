package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaMovilRegistroStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Cliente cliente;

    @ScreenShotAfter
    public void validarPantallaIngresarDireccion() {
        Assert.assertTrue(page.altaFijaMovilRegistroPage().validarPantallaIngresarDireccion());
    }

    @ScreenShotAfter
    public void mostrarDetalleOfertasSugeridas() {
        Assert.assertTrue("La pantalla de ofertas sugeridas no cargo correctamente!!!",
                page.altaFijaMovilRegistroPage().validarQueExistanOfertasSugeridas());
    }
    @ScreenShotAfter
    public void seleccionarOferta(String oferta) {
        page.altaFijaMovilRegistroPage().seleccionarOferta(oferta);
    }

    @ScreenShotAfter
    public void seleccionarPlan(String plan) {
        page.altaFijaMovilRegistroPage().seleccionarPlan(plan);
    }

    @ScreenShotAfter
    public void clicBotonSeleccionarOferta() {
        page.altaFijaMovilRegistroPage().clicSeleccionarOferta();
    }

    public void clicIrAMovistarTotal() {
        page.altaFijaMovilRegistroPage().clicIrAMovistarTotal();
    }

    @ScreenShotAfter
    public void validarDetalleSeleccion() {
        page.altaFijaMovilRegistroPage().validarDetalleSeleccion();
    }


    @ScreenShotAfter
    public void clicIniciarRegistro() {
        page.altaFijaMovilRegistroPage().clicIniciarRegistro();
    }
    @ScreenShotAfter
    public void moverToElementIniciarRegistro() {
        page.altaFijaMovilRegistroPage().moverToElementIniciarRegistro();
    }
    @ScreenShotAfter
    public void validarPantallaAgendamiento() {
        Assert.assertTrue("No se mostro pantalla de agendamiento",
                page.altaFijaMovilRegistroPage().validarPantallaAgendamiento());

    }

    @ScreenShotAfter
    public void ingresarContacto(String contacto) {
        page.altaFijaMovilRegistroPage().ingresarContacto(contacto);
    }

    @ScreenShotAfter
    public void clicConfirmarAgendamiento() {
        page.altaFijaMovilRegistroPage().clicConfirmarAgendamiento();
    }

    @ScreenShotAfter
    public void validarDetalleInstalacion() {
        Assert.assertTrue("No se mostro modal de detalle de instalacion",
                page.altaFijaMovilRegistroPage().validarDetalleInstalacion());
    }
    @ScreenShotAfter
    public void clicConfirmarInstalacion() {
        page.altaFijaMovilRegistroPage().clicConfirmarInstalacion();
    }

    @ScreenShotAfter
    public void completarCorreo(String correo) {
        page.altaFijaMovilRegistroPage().completarCorreo( correo);
    }

    @ScreenShotBefore
    public void clicValidarIdentidadTitular() {
        page.altaFijaMovilRegistroPage().clicValidarIdentidadTitular();
    }

    public void seleccionoTipoValidacion(String tipoValidacion) {
        page.altaFijaMovilRegistroPage().seleccionoTipoValidacion( tipoValidacion);
    }

    public void ingresarDatosSupervisor(DataTable datos) {

        String numdoc= UtilWeb.getValueFromDataTable(datos,"numdoc");
        String user= UtilWeb.getValueFromDataTable(datos,"user");
        String password= UtilWeb.getValueFromDataTable(datos,"password");

        page.altaFijaMovilRegistroPage().ingresarDNISupervisor(numdoc);
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
        page.altaFijaMovilRegistroPage().IngresarUsuarioSupervisor(user);
        page.altaFijaMovilRegistroPage().ingresarPasswordSupervisor(password);
    }

    @ScreenShotBefore
    public void clicConfirmarUsuarioSupervisor(){
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
    }

    public void validarIdentidadValidada() {
        page.altaFijaMovilRegistroPage().verificarIdentidadValidada();
    }

    @ScreenShotBefore
    public void clicValidarContrato() {
        page.altaFijaMovilRegistroPage().clicValidarContrato();
    }

    public void ingresarDatosValidacionSolicitada(DataTable datos) {
        UtilWeb.waitForSeconds(5);
        page.altaFijaMovilRegistroPage().ingresarDatosValidacionReniec(datos);
    }

    @ScreenShotBefore
    public void clicEnSiguiente() {
        page.altaFijaMovilRegistroPage().clicSiguiente();
    }

    @ScreenShotBefore
    public void clicEnConfirmar() {
        page.altaFijaMovilRegistroPage().clicEnConfirmar();
    }

    @ScreenShotAfter
    public void moverseFinalDocumento() {
        page.altaFijaMovilRegistroPage().scrollByJavaScriptToFinal();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clicBotonContinuar() {
        page.altaFijaMovilRegistroPage().clicBotonContinuar();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void visualizarContratoEnPantalla() {
        page.altaFijaMovilRegistroPage().visualizarContratoEnPantalla();
    }

    @ScreenShotBefore
    public void clicSiAcepto() {
        page.altaFijaMovilRegistroPage().clicSiAcepto();
    }
    /*
    @ScreenShotAfter
    public void validarMensajeExitoso() {
        Assert.assertTrue("No se pudo validar registro exitoso!!!",
                page.altaFijaMovilRegistroPage().validarMensajeExitoso());
    }
     */

    @ScreenShotAfter
    public void clicEnAgregarSVA() {
        page.altaFijaMovilRegistroPage().clicEnAgregarSVA();
    }
    @ScreenShotAfter
    public void clicSVAHBO() {
        page.altaFijaMovilRegistroPage().clicSVAHBO();
    }
    @ScreenShotAfter
    public void clicGuardarCambios() {
        page.altaFijaMovilRegistroPage().clicGuardarCambios();
    }
    @ScreenShotAfter
    public void escogerTurnoAgendamiento() {
        page.altaFijaMovilRegistroPage().clicEnUnTurnoAgendamiento();
    }

    public void verificarClienteNuevo(){
        cliente.setClienteNuevo(page.altaFijaMovilRegistroPage().esNuevoCliente());
    }

    //CAMBIOS PARA RETAIL
    @ScreenShotAfter
    public void ingresarDatosClienteExtranjero(DataTable datos) {
        if(cliente.isClienteNuevo()){
            String nombre=UtilWeb.getValueFromDataTable(datos,"nombres");
            String apellidos=UtilWeb.getValueFromDataTable(datos,"apellidos");
            String genero=UtilWeb.getValueFromDataTable(datos,"genero");
            page.altaFijaMovilRegistroPage().ingresarNombreClienteExtranjero(nombre);
            page.altaFijaMovilRegistroPage().ingresarApellidoClienteExtranjero(apellidos);
            page.altaFijaMovilRegistroPage().seleccionarGeneroClienteExtranjero(genero);
        }else{
            System.out.println("Skip. Cliente Registrado en Dito");
        }

    }

    @ScreenShotAfter
    public void clicEnCrearCliente() {
        if(cliente.isClienteNuevo()){
            page.altaFijaMovilRegistroPage().crearCliente();
            //UtilWeb.waitForSeconds(30);//100
        }else{
            System.out.println("Skip. Cliente Registrado en Dito");
        }

    }
    @ScreenShotBefore
    @ScreenShotAfter
    public void completarDatosClienteExtranjero(DataTable datosCliente) {
        String fechaNac=UtilWeb.getValueFromDataTable(datosCliente,"fechaNac");
        String estadoCivil=UtilWeb.getValueFromDataTable(datosCliente,"estadoCivil");

        page.altaFijaMovilRegistroPage().ingresarFechaNac(fechaNac);
        page.altaFijaMovilRegistroPage().seleccionoNacionalidad();
        page.altaFijaMovilRegistroPage().seleccionarEstadoCivil(estadoCivil);

    }
    public void esperarBtnDatosCliente(){ page.altaFijaMovilRegistroPage().esperarBtnDatosCliente(); }
    @ScreenShotBefore
    public void clicDatosDelCliente() {
        page.altaFijaMovilRegistroPage().clicDatosDeCliente();
    }
    @ScreenShotBefore
    public void clicConfirmarCliente() {
        page.altaFijaMovilRegistroPage().clicConfirmarCliente();
    }

    public void datosClienteValidado() {
        page.altaFijaMovilRegistroPage().datosClienteValidado();
    }
    @ScreenShotAfter
    public void mostrarPantallaDescargarContrato() {
        Assert.assertTrue("No mostro pantalla para descargar contrato",
                page.altaFijaMovilRegistroPage().mostrarPantallaDescargarContrato());
    }

    @ScreenShotAfter
    public void clicDescargarContrato() throws InterruptedException {
        page.altaFijaMovilRegistroPage().clicDescargarContrato();
    }
    @ScreenShotAfter
    public void clicRegistrarVenta() {
        page.altaFijaMovilRegistroPage().clicRegistrarVenta();
    }
    @ScreenShotAfter
    public void validarVentaGenerada() {
        Assert.assertTrue("No mostro pantalla de venta exitosa",
                page.altaFijaMovilRegistroPage().validarVentaGenerada());
    }

    public void agregoSVAINTERNET(String svaInternet) {
        page.altaFijaMovilRegistroPage().agregoSVAINTERNET(svaInternet);
    }

    public void clicEnAgregarRepetidor() {
        page.altaFijaMovilRegistroPage().agregarRepetidor();
    }
    public void clicEnAgregarSVAMT() {
        page.altaFijaMovilRegistroPage().clicEnAgregarSVAMT();
    }
    public String guardoNumeroSolicitud() {
        //page.altaFijaMovilRegistroPage().guardoNumeroSolicitud();
         String numeroSolicitud =  page.altaFijaMovilRegistroPage().getNumeroSolicitud();
         if(numeroSolicitud!=null) {
             System.out.println("Numero Solicitud:" + numeroSolicitud);
             cliente.setNumeroSolicitud(numeroSolicitud);
         }else{
             System.out.println("ERROR - Numero Solicitud - Null");
         }
         return numeroSolicitud;
    }

    public String getTextoSolicitud(){
        return page.altaFijaMovilRegistroPage().getTextoSolicitud();
    }
}
