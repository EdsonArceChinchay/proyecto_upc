package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.ParkStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkStepDefinition {

    @Autowired
    private ParkStep parkStep;

    @Y("ingreso los datos del nuevo cliente")
    public void completoLosDatosDelClienteARegistrar(DataTable value) {
        parkStep.verificarClienteNuevo();
        parkStep.ingresarDatosClienteExtranjero(value);
        parkStep.clicEnCrearCliente();
    }

    @Y("selecciono el boton Linea Nueva Hogar")
    public void seleccionoElBotonLineaNuevaHogar() {
        parkStep.scrollToLabelSelectService();
        parkStep.btnHogar();
    }

    @Y("selecciono el boton Linea Nueva Movil")
    public void seleccionoElBotonLineaNuevaMovil() {
        parkStep.scrollToLabelSelectService();
        parkStep.btnMovil();
    }

    @Y("doy click en el boton Ver detalle del servicio {string}")
    public void seleccionoElBotonVerDetalleDelServicio(String nroServicio) {
        parkStep.scrollToLabelSelectService();
        parkStep.clickBtnVerDetalle(nroServicio);
    }

    @Y("selecciono el servicio mono {string} y  el servicio duo {string} a paquetizar")
    public void selecciono_el_mono_y_duo_a_paquetizar(String mono, String duo) {
        parkStep.scrollToLabelSelectService();
        parkStep.clickMonoYDuo(mono, duo);
    }

    @Y("selecciono la cartilla del plan activo")
    public void selecciono_la_cartilla_del_plan_Activo() {
        parkStep.scrollToLabelSelectService();
        parkStep.selecciono_la_cartilla_del_plan_Activo();
    }

    @Y("selecciono el boton de la Linea Hogar Existente {string}")
    public void seleccionoElBotonLineaHogarExistente(String numeroExistente) {
        parkStep.scrollToLabelSelectService();
        parkStep.btnLineaExistente(numeroExistente);
    }

    @Y("selecciona el boton del numero de celular existente {string}")
    public void seleccionaElBotonDelNumeroDeCelularExistente(String numeroExistente) {
        parkStep.scrollToLabelSelectService();
        parkStep.btnLineaCelularExistente(numeroExistente.trim());
    }

    @Y("selecciona el boton del numero del plan MT existente {string}")
    public void seleccionaElBotonDelNumeroDelPlanMtExistente(String numeroExistente) {
        parkStep.scrollToLabelSelectService();
        parkStep.btnPlanMtExistente(numeroExistente.trim());
    }

    @Y("selecciono el boton de la Linea Movil Existente")
    public void seleccionoElBotonLineaMovilExistente() {
        parkStep.scrollToLabelSelectService();
        parkStep.btnLineaMovilExistente();
    }

    @Y("cierro el popup de contraseña Única")
    public void closeModalUniquePassword() {
        parkStep.cerrarPopupCU();
    }

    @Y("cierro pop up de Cliente Exonerado")
    public void cierroPopUpDeClienteExonerado() {
        parkStep.cierroPopUpDeClienteExonerado();
    }

    @Y("cierro el popup de validación de estado de contraseña única")
    public void closeModalUniquePassword2() {
        parkStep.cerrarPopUpEstadoCU();
    }

    @Y("cierro popup de error")
    public void cierroPopupDeError() {
        parkStep.clickCierrePopup();
    }

    @Y("Selecciono la cartilla del plan Motvistar Total")
    public void seleccionoLaCartillaDelPlanMotvistarTotal() {
        parkStep.scrollToLabelSelectService();
        parkStep.seleccionoCartillaMovistarTotal();
    }

    @Y("selecciono la cartilla del plan MT")
    public void seleccionoLaCartillaDelPlanMT() {
        parkStep.scrollToLabelSelectService();
        parkStep.seleccionoCartillaPlanMT();
    }

    @Y("selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan")
    public void seleccionoElBtnVerDetalleDelPlanActualYPresionoElBtnRenovarPlan() {
        parkStep.scrollToLabelSelectService();
        //parkStep.esperarBtnCardPlanActual();
        parkStep.clickBtnCardPlanActual();
        parkStep.clickBtnRenovarPlan();
    }

    @Y("selecciono el boton Cambiar Chip")
    public void seleccionoelbotonCambiodeChip() {
        parkStep.seleccionoelbotonCambiodeChip();
    }

    @Y("selecciono el boton Ver detalle del plan actual y actualizar ruc")
    public void seleccionoElBotonVerDetalleDelPlanActualYActualizarRuc() {
        parkStep.seleccionoBotonVerDetalle();
        parkStep.clickBotonActualizarRuc();
    }

    @Y("ingreso el ruc {string} y actualizo")
    public void ingresoElRucYActualizo(String ruc) {
        parkStep.ingresoRuc(ruc);
        parkStep.clickOnButtonUpdate();
    }

    @Y("valido el mensaje de la actualizacion de ruc correcta")
    public void validoElMensajeDeLaActualizacionDeRucCorrecta() {
        parkStep.validoMensajeActualizacionCorrecta();
        parkStep.clickBotonEntendido();
    }

    @Y("ingreso el ruc {string}, digito verificador {string} y actualizo")
    public void ingresoElRucDigitoVerificadorYActualizo(String ruc, String digito) {
        parkStep.ingresoRuc17(ruc);
        parkStep.ingresoDigitoV(digito);
        parkStep.clickOnButtonUpdate();
    }

    @Y("selecciono el plan {string} que desea")
    public void seleccionoElPlanQueDesea(String planMovil) {
        parkStep.seleccionoElPlanQueDesea(planMovil);
    }

    @Y("doy click en el boton Siguiente")
    public void clickOnButtonNext() {
        parkStep.clickOnButtonNext();
    }

    @Y("verifico la direccion {string} actual del servicio")
    public void verificoLaDireccionActualDelServicio(String dir) {
        parkStep.verificoLaDireccionActualDelServicio(dir);
    }

    @Y("presiono el boton Confirmar direccion")
    public void presionoElBotonConfirmarDireccion() {
        parkStep.clickOnButtonConfirmAddress();
    }

    @Y("doy click en el boton continuar")
    public void clickOnButtonContinue() {
        parkStep.clickOnButtonContinue();
    }

    @Y("selecciono la orden")
    public void seleccionoLaOrden() {
        parkStep.selectOrder();
    }

    @E("ingreso el codigo de SIMCARD")
    public void ingresoElCodigoDeSIMCARD() {
        parkStep.typeSimCard();
    }

    @E("ingreso el codigo de IMEI de {string}")
    public void ingresoElCodigoDeIMEI(String device) {
        parkStep.typeIMEI(device);
    }

    @Y("doy click Validar Stock")
    public void doyClickValidarStock() {
        parkStep.clickOnButtonValidateStock();
    }

    @E("ingreso el numero de caja {string}")
    public void ingresoElNumeroDeCaja(String number) {
        parkStep.typeInBoxNumber(number);
    }

    @E("ingreso el numero de ticket {string}")
    public void ingresoElNumeroDeTicket(String number) {
        parkStep.typeInTicketNumber(number);
    }

    /**
     * FUNCION BOTON MOSTRAR OFERTA
     * */

    @Y("selecciono el boton Mostrar ofertas")
    public void seleccionoElBotonMostrarOfertas() {
        parkStep.scrollToLabelSelectService();
        parkStep.btnMostrar();
    }
    @Y("selecciono el boton Mostrar ofertas MT")
    public void seleccionoElBotonMostrarOfertasMT() {
        parkStep.scrollToLabelSelectService();
        parkStep.btnMostrarMT();
    }
    /**
     * FUNCION CLICK DETALLE PLAN
     * */

    @Y("selecciona el boton de detalle del numero de celular existente {string}")
    public void seleccionaElBotonDeDetalleDelNumeroDeCelularExistente(String numeroExistente) {
        parkStep.scrollToLabelSelectService();
        parkStep.btnDetalleLineaCelularExistente(numeroExistente.trim());
    }

    /**
     * FUNCION RENOVAR PLAN - POR DETALLE DE PLAN
     * */

    @Y("presiono el boton Renovar Plan")
    public void presionoElBtnRenovarPlan() {
        parkStep.clickBtnRenovarPlan();
    }

    /**
     * FUNCION SELECCIONAR LINEA
     * */

    @Y("selecciono la linea con numero {string}")
    public void seleccionoLaLineaConNumero(String number) {
        parkStep.scrollToLabelSelectService();
        parkStep.selectLineWithNumber(number);
    }


    @Y("cierro el popup de cliente con exoneracion")
    public void cierroElPopupDeClienteConExoneracion() {
        parkStep.cerrarPopUpClienteConExoneracion();
    }
}
