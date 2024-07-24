package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
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
    private ManageScenario scenario;

    @ScreenShotBefore
    public void seleccionarTipoPago(String tipoPago) {
        page.registerPage().tipoPago(tipoPago);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoCorreo(String email) {
        page.registerPage().ingresoCorreo(email);
    }

    public void ingresarCorreoNuevamente(String correo) {
        page.registerPage().confirmarCorreo(correo);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void ingresoCallId(String callId) {
        page.registerPage().ingresoCallId(callId);
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

    public void esperarBtnDatosCliente() {
        page.registerPage().esperarBtnDatosCliente();
    }

    @ScreenShotBefore
    public void clicDatosDelCliente() {
        page.registerPage().clicDatosDeCliente();
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
    }

    @ScreenShotAfter
    public void selectNationality(String nationality) {
        page.registerPage().selectNationality(nationality);
    }

    @ScreenShotAfter
    public void selectDepartment(String department) {
        page.registerPage().seleccionarDepartamento(department);
    }

    @ScreenShotAfter
    public void selectProvince(String province) {
        page.registerPage().seleccionarProvincia(province);
    }

    @ScreenShotAfter
    public void selectDistrict(String district) {
        page.registerPage().seleccionarDistrito(district);
    }

    @ScreenShotAfter
    public void typeAddress(String address) {
        page.registerPage().typeAddress(address);
    }

}
