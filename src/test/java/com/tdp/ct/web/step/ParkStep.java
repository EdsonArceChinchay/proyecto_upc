package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkStep {
    @Autowired
    private StepPages page;

    @Autowired
    private Customer customer;

    public void verificarClienteNuevo() {
        customer.setNewCustomer(page.parkPage().isNewCustomer());
    }

    @ScreenShotAfter
    public void ingresarDatosClienteExtranjero(DataTable datos) {
        String nombre = UtilWeb.getValueFromDataTable(datos, "nombres");
        String apellidos = UtilWeb.getValueFromDataTable(datos, "apellidos");
        String genero = UtilWeb.getValueFromDataTable(datos, "genero");
        page.parkPage().ingresarNombreClienteExtranjero(nombre);
        page.parkPage().ingresarApellidoClienteExtranjero(apellidos);
        page.parkPage().seleccionarGeneroClienteExtranjero(genero);
    }

    @ScreenShotAfter
    public void clicEnCrearCliente() {
        page.parkPage().crearCliente();
    }

    public void selecciono_la_cartilla_del_plan_Activo() {
        page.parkPage().selecciono_la_cartilla_del_plan_Activo();
    }

    @ScreenShotAfter
    public void btnHogar() {
        page.parkPage().altaHogar();
    }

    @ScreenShotAfter
    public void btnLineaExistente(String numeroExistente) {
        page.parkPage().lineaExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnLineaCelularExistente(String numeroExistente) {
        page.parkPage().lineaCelularExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnPlanMtExistente(String numeroExistente) {
        page.parkPage().planMtExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnDetalleLineaCelularExistente(String numeroExistente) {
        page.parkPage().detalleLineaCelularExistente(numeroExistente);
    }

    @ScreenShotAfter
    public void btnLineaMovilExistente() {
        page.parkPage().lineaMovilExistente();
    }

    @ScreenShotAfter
    public void btnMovil() {
        page.parkPage().altaMovil();
    }

    @ScreenShotBefore
    public void btnMostrar() {
        page.parkPage().mostrarOfertas();
    }

    public void cerrarPopupCU() {
        page.parkPage().cerrarPopupCU();
    }

    public void seleccionoCartillaMovistarTotal() {
        page.parkPage().seleccionoCartillaMovistarTotal();
    }

    @ScreenShotBefore
    public void seleccionoCartillaPlanMT() {
        page.parkPage().seleccionoCartillaPlanMT();
    }

    public void esperarBtnCardPlanActual() {
        page.parkPage().esperarBtnCardPlanActual();
    }

    @ScreenShotBefore
    public void clickBtnCardPlanActual() {
        page.parkPage().clickBtnCardPlanActual();
    }

    @ScreenShotAfter
    public void clickBtnRenovarPlan() {
        page.parkPage().clickBtnRenovarPlan();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionoelbotonCambiodeChip() {
        page.parkPage().seleccionoelbotonCambiodeChip();
    }

    @ScreenShotBefore
    public void seleccionoBotonVerDetalle() {
        page.parkPage().seleccionoBotonVerDetalle();
    }

    @ScreenShotBefore
    public void clickBotonActualizarRuc() {
        page.parkPage().clickBotonActualizarRuc();
    }

    @ScreenShotAfter
    public void ingresoRuc(String ruc) {
        page.parkPage().ingresoRuc(ruc);
    }

    @ScreenShotBefore
    public void clickOnButtonUpdate() {
        page.parkPage().clickOnButtonUpdate();
    }

    @ScreenShotAfter
    public void validoMensajeActualizacionCorrecta() {
        page.parkPage().validoMesajeActualizacionCorrecta();
    }

    @ScreenShotBefore
    public void clickBotonEntendido() {
        page.parkPage().clickBotonEntendido();
    }

    @ScreenShotAfter
    public void ingresoRuc17(String ruc) {
        page.parkPage().ingresoRuc17(ruc);
    }

    public void ingresoDigitoV(String digito) {
        page.parkPage().ingresoDigitoV(digito);
    }

    @ScreenShotAfter
    public void seleccionoElPlanQueDesea(String planMovil) {
        page.parkPage().clickPlanMovil(planMovil);
    }

    @ScreenShotAfter
    public void doyClickEnBotonSiguiente() {
        page.parkPage().clickEnBotonSiguiente();
    }

    @ScreenShotAfter
    public void verificoLaDireccionActualDelServicio(String dir) {
        page.parkPage().verificoLaDireccionActualDelServicio(dir);
    }

    @ScreenShotAfter
    public void btnConfirmarDireccion() {
        page.parkPage().btnConfirmarDireccion();
    }

    @ScreenShotAfter
    public void clickMonoYDuo(String mono, String duo) {
        page.parkPage().clickOnPark("Mono", mono);
        page.parkPage().clickOnPark("Duo", duo);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void botonContinuar() {
        page.parkPage().clickBotonContinuar();
    }

    public void scrollToLabelSelectService() {
        page.parkPage().scrollToLabelSelectService();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle(String nroServicio) {
        page.parkPage().clickBtnVerDetalle(nroServicio);
    }

    @ScreenShotAfter
    public void selectLineWithNumber(String number) {
        page.parkPage().selectLineWithNumber(number);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void cierroPopUpDeClienteExonerado() {
        page.parkPage().cierroPopUpDeClienteExonerado();
    }

    public void cerrarPopUpEstadoCU() {
        page.parkPage().cerrarPopUpEstadoCU();
    }

    @ScreenShotBefore
    public void clickCierrePopup() {
        page.parkPage().clickCierrePopup();
    }

    @ScreenShotAfter
    public void selectOrder() {
        page.parkPage().selectOrder();
    }

    public void typeSimCard() {
        String simCard = page.parkPage().getSimCard();
        page.parkPage().typeInput("inputSimCard", simCard);
    }

    public void typeIMEI() {
        String imei = page.parkPage().getIMEI();
        page.parkPage().typeInput("inputImei", imei);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickOnButtonValidateStock() {
        page.parkPage().clickOnButtonValidateStock();
    }

    public void typeInBoxNumber(String number) {
        page.parkPage().typeInput("inputBoxNumber", number);
    }

    @ScreenShotAfter
    public void typeInTicketNumber(String number) {
        page.parkPage().typeInput("inputTicketNumber", number);
    }
}
