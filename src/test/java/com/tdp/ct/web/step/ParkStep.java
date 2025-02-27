package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.MaterialService;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkStep {

    private static String simCard = null;
    private static String imei = null;
    private final MaterialService materialService;

    @Autowired
    private StepPages page;
    @Autowired
    private Customer customer;

    @Autowired
    public ParkStep(MaterialService materialService) {
        this.materialService = materialService;
    }

    public void verificarClienteNuevo() {
        customer.setNewCustomer(page.parkPage().isNewCustomer());
    }

    @ScreenShotAfter
    public void ingresarDatosClienteExtranjero(DataTable datos) {
        if (customer.isNewCustomer()) {
            String customerName = UtilWeb.getValueFromDataTable(datos, "nombres");
            String customerLastName = UtilWeb.getValueFromDataTable(datos, "apellidos");
            String customerGender = UtilWeb.getValueFromDataTable(datos, "genero");
            page.parkPage().ingresarNombreClienteExtranjero(customerName);
            page.parkPage().ingresarApellidoClienteExtranjero(customerLastName);
            page.parkPage().seleccionarGeneroClienteExtranjero(customerGender);
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
    }

    @ScreenShotAfter
    public void clicEnCrearCliente() {
        if (customer.isNewCustomer()) {
            page.parkPage().createCustomer();
        } else {
            System.out.println("Skip. Cliente Registrado en Dito");
        }
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
    public void btnLineaMovilExistente() {
        page.parkPage().lineaMovilExistente();
    }

    @ScreenShotAfter
    public void btnMovil() {
        page.parkPage().altaMovil();
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
    public void clickOnButtonNext() {
        page.parkPage().clickOnButtonNext();
    }

    @ScreenShotAfter
    public void verificoLaDireccionActualDelServicio(String address) {
        page.parkPage().verificoLaDireccionActualDelServicio(address);
    }

    @ScreenShotAfter
    public void clickOnButtonConfirmAddress() {
        page.parkPage().btnConfirmAddress();
    }

    @ScreenShotAfter
    public void clickMonoYDuo(String mono, String duo) {
        page.parkPage().clickOnPark("Mono", mono);
        page.parkPage().clickOnPark("Duo", duo);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickOnButtonContinue() {
        page.parkPage().clickOnButtonContinue();
    }

    @ScreenShotBefore
    public void clickBtnVerDetalle(String numberService) {
        page.parkPage().clickBtnVerDetalle(numberService);
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

    @ScreenShotBefore
    public void typeSimCard() {
        simCard = materialService.getSimCard("5P36", "UAT4");
        page.parkPage().typeInput("inputSimCard", simCard == null ? page.parkPage().getSimCard() : simCard);
    }

    public void typeIMEI(String device) {
        imei = materialService.getIMEIByName(device, "5P36", "UAT4");
        page.parkPage().typeInput("inputImei", imei == null ? page.parkPage().getIMEI(device) : imei);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void clickOnButtonValidateStock() {
        page.parkPage().clickOnButtonValidateStock();
    }

    public void typeInBoxNumber(String number) {
        if (!(simCard == null)) {
            materialService.assignSimCard(simCard);
        }
        if (!(imei == null)) {
            materialService.assignIMEI(imei);
        }
        page.parkPage().typeInput("inputBoxNumber", number);
    }

    @ScreenShotAfter
    public void typeInTicketNumber(String number) {
        page.parkPage().typeInput("inputTicketNumber", number);
    }

    /**
     * FUNCION SCROLL SELECCIONAR SERVICIO
     * */

    public void scrollToLabelSelectService() {
        page.parkPage().scrollToLabelSelectService();
    }

    /**
     * FUNCION BOTON MOSTRAR OFERTA
     * */

    public void btnMostrar() {
        page.parkPage().mostrarOfertas();
    }

    /**
     * FUNCION CLICK DETALLE PLAN
     * */

    public void btnDetalleLineaCelularExistente(String numeroExistente) {
        page.parkPage().detalleLineaCelularExistente(numeroExistente);
    }

    /**
     * FUNCION RENOVAR PLAN - POR DETALLE DE PLAN
     * */

    public void clickBtnRenovarPlan() {
        page.parkPage().clickBtnRenovarPlan();
    }

    /**
     * FUNCION SELECCIONAR LINEA
     * */

    public void selectLineWithNumber(String number) {
        page.parkPage().selectLineWithNumber(number);
    }
}
