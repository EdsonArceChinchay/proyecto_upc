package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.service.util.UtilWeb.getValueFromDataTable;

@Component
public class RegisterStep {

    @Autowired
    private StepPages page;

    @Autowired
    private Customer customer;

    public void validarCompletaDatosSolicitados() {
        page.registerPage().completaDatosSolicitados();
    }

    @ScreenShotAfter
    public void selectMethodPayment(String tipoPago) {
        page.registerPage().selectMethodPayment(tipoPago);
    }

    @ScreenShotAfter
    public void typeEmail(String email) {
        page.registerPage().typeEmail(email);
    }

    @ScreenShotAfter
    public void typeConfirmEmail(String correo) {
        page.registerPage().typeConfirmEmail(correo);
    }

    @ScreenShotAfter
    public void typeIdCall(String idCall) {
        page.registerPage().typeIdCall(idCall);
    }

    @ScreenShotAfter
    public void ingresarDatosCliente(DataTable dataTable) {
        var fechNacimiento = getValueFromDataTable(dataTable, "fechaNac");
        var nacionalidad = getValueFromDataTable(dataTable, "nacionalidad");
        var estadoCivil = getValueFromDataTable(dataTable, "estadoCivil");
        typeDateOfBirth(fechNacimiento);
        selectNationality(nacionalidad);
        selectMaritalStatus(estadoCivil);
        UtilWeb.waitForSeconds(2);
    }

    public void waitButtonCustomerData() {
        page.registerPage().waitButtonCustomerData();
    }

    @ScreenShotBefore
    public void clickButtonCustomerData() {
        page.registerPage().clickButtonCustomerData();
    }

    @ScreenShotBefore
    public void clickBotonConfirmar() {
        page.registerPage().clickButtonConfirm();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void completoDatosCliente(DataTable datosCliente) {
        String fechaNac = UtilWeb.getValueFromDataTable(datosCliente, "fechaNac");
        String nacionalidad = UtilWeb.getValueFromDataTable(datosCliente, "nacionalidad");
        String estadoCivil = UtilWeb.getValueFromDataTable(datosCliente, "estadoCivil");
        String departamento = UtilWeb.getValueFromDataTable(datosCliente, "departamento");
        String provincia = UtilWeb.getValueFromDataTable(datosCliente, "provincia");
        String distrito = UtilWeb.getValueFromDataTable(datosCliente, "distrito");
        String direccion = UtilWeb.getValueFromDataTable(datosCliente, "direccion");
        typeDateOfBirth(fechaNac);
        selectNationality(nacionalidad);
        selectMaritalStatus(estadoCivil);
        selectDepartment(departamento);
        selectProvince(provincia);
        selectDistrict(distrito);
        typeAddress(direccion);
    }

    @ScreenShotAfter
    public void typeDateOfBirth(String dateOfBirth) {
        page.registerPage().typeDateOfBirth(dateOfBirth);
    }

    @ScreenShotAfter
    public void selectMaritalStatus(String maritalStatus) {
        page.registerPage().selectMaritalStatus(maritalStatus);
        page.registerPage().validateMaterialStatus(maritalStatus);
    }

    @ScreenShotAfter
    public void selectNationality(String nationality) {
        page.registerPage().selectNationality(nationality);
    }

    @ScreenShotAfter
    public void selectDepartment(String department) {
        page.registerPage().selectDepartment(department);
    }

    @ScreenShotAfter
    public void selectProvince(String province) {
        page.registerPage().selectProvince(province);
    }

    @ScreenShotAfter
    public void selectDistrict(String district) {
        page.registerPage().selectDistrict(district);
    }

    @ScreenShotAfter
    public void typeAddress(String address) {
        page.registerPage().typeAddress(address);
    }

    @ScreenShotAfter
    public void selectTipoDePago(String tipo) {
        page.registerPage().selectTipoDePago(tipo);
    }

    @ScreenShotBefore
    public void clickButtonContinue() {
        UtilWeb.waitForSeconds(10);
        page.registerPage().clickButtonContinue();
        UtilWeb.waitForSeconds(10);
    }

    @ScreenShotBefore
    public void clicValidarContrato() {
        page.altaFijaMovilRegistroPage().clicValidarContrato();
    }

    @ScreenShotAfter
    public void visualizarContratoEnPantalla() {
        page.altaFijaMovilRegistroPage().visualizarContratoEnPantalla();
    }

    public String getSummary() {
        return page.checkoutPage().getSummary();
    }

    public String getSalesCode() {
        String salesCode = page.checkoutPage().getSalesCode();
        if (salesCode != null) {
            customer.setSalesCode(salesCode);
        } else {
            System.out.println("ERROR - Codigo de Venta - Null");
        }
        return salesCode == null ? " " : salesCode;
    }

    @ScreenShotBefore
    public void clicSiAcepto() {
        page.altaFijaMovilRegistroPage().clicSiAcepto();
    }

    @ScreenShotAfter
    public void clickOnTheValidateHolderIdentityButton() {
        page.altaFijaMovilRegistroPage().clickOnTheValidateHolderIdentityButton();
    }

    public void seleccionoTipoValidacion(String tipoValidacion) {
        page.altaFijaMovilRegistroPage().seleccionoTipoValidacion(tipoValidacion);
    }

    public void ingresarDatosSupervisor(DataTable datos) {
        String numdoc = UtilWeb.getValueFromDataTable(datos, "numdoc");
        String user = UtilWeb.getValueFromDataTable(datos, "user");
        String password = UtilWeb.getValueFromDataTable(datos, "password");

        page.altaFijaMovilRegistroPage().ingresarDNISupervisor(numdoc);
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
        page.altaFijaMovilRegistroPage().IngresarUsuarioSupervisor(user);
        page.altaFijaMovilRegistroPage().ingresarPasswordSupervisor(password);
    }

    @ScreenShotBefore
    public void clicConfirmarUsuarioSupervisor() {
        page.altaFijaMovilRegistroPage().clicConfirmarUsuarioSupervisor();
    }

    public void validarIdentidadValidada() {
        page.altaFijaMovilRegistroPage().verificarIdentidadValidada();
    }

    public void ingresarDatosValidacionSolicitada(DataTable datos, Integer i) {
        page.altaFijaMovilRegistroPage().ingresarDatosValidacionReniec(datos, i);
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
    public void clicBotonContinuar() {
        page.altaFijaMovilRegistroPage().clicBotonContinuar();
    }

    @ScreenShotBefore
    public void clickDiscapacitadoHuellaDesgastado() {
        page.altaTrioMTconUpfrontTiendaPage().clickDiscapacitadoHuellaDesgastado();
    }

    @ScreenShotAfter
    public void selectSupervisorDocumentType(String tipoDoc) {
        page.altaTrioMTconUpfrontTiendaPage().selectSupervisorDocumentType(tipoDoc);
    }

    @ScreenShotAfter
    public void typeSupervisorDocumentNumber(String documentoSuper) {
        page.altaTrioMTconUpfrontTiendaPage().typeSupervisorDocumentNumber(documentoSuper);
    }

    @ScreenShotAfter
    public void typeSupervisorUser(String user) {
        page.altaTrioMTconUpfrontTiendaPage().typeSupervisorUser(user);
    }

    @ScreenShotAfter
    public void typeSupervisorPassword(String passw) {
        page.altaTrioMTconUpfrontTiendaPage().typeSupervisorPassword(passw);
    }

    @ScreenShotBefore
    public void clickBotonValidarRepreLegal() {
        page.altaFijaTiendaPage().clickValidarRepreLegal();
    }

    public boolean hasIdentityValidationError() {
        return page.registerPage().hasIdentityValidationError();
    }

    @ScreenShotBefore
    public void clickOnButtonConfirm() {
        page.registerPage().clickOnButtonConfirm();
    }

    @ScreenShotBefore
    public void clickOnTheFinishRegistrationButton() {
        page.registerPage().clickOnTheFinishRegistrationButton();
    }
}
