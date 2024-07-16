package com.tdp.ct.web.step;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import com.tdp.ct.web.page.StepPages;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilPostpagoCallCenterStep {

    @Autowired
    private  StepPages page;

    @ScreenShotBefore
    public void BtonOpciones() {
        page.altaMovilPostpagoCallCenterPage().BtonOpciones();
    }

    @ScreenShotBefore
    public  void seleccionarPlan(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionarPlan(tipoPlan);

    }

    @ScreenShotBefore
    public  void seleccionarEquipo() {
        page.altaMovilPostpagoCallCenterPage().seleccionarEquipo();
    }

    public  void selectPermanency(String timePermanecy) {
        page.altaMovilPostpagoCallCenterPage().selectPermanency(timePermanecy);
    }

    @ScreenShotAfter
    public  void BuscarEquipo(String buscarE) {
        page.altaMovilPostpagoCallCenterPage().BuscarEquipo(buscarE);
    }

    @ScreenShotBefore @ScreenShotAfter
    public  void seleccionoElPlanMovil(String tipoPlan) {
        page.altaMovilPostpagoCallCenterPage().seleccionoElPlanMovil(tipoPlan);
    }

    @ScreenShotBefore
    public void seleccionoLaCartillaLineaNueva() {
        page.altaMovilPostpagoCallCenterPage().seleccionoLaCartillaLineaNueva();
    }
    @ScreenShotBefore
    public void doyClickEnElBotonSeleccionarOferta() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnElBotonSeleccionarOferta();
    }
    @ScreenShotBefore
    public void doyClickEnElBotonSeleccionar() {
        page.altaMovilPostpagoCallCenterPage().doyClickEnElBotonSeleccionar();
    }
    @ScreenShotBefore
    @ScreenShotAfter
    public void doyClickEnIniciarRegistro(){
        page.altaMovilPostpagoCallCenterPage().doyClickEnIniciarRegistro();
    }

    @ScreenShotAfter
    public void meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        Assert.assertTrue(page.altaMovilPostpagoCallCenterPage().meMuestraLaPantallaDeDeliveryDeLineaNueva());
    }
    @ScreenShotBefore
    public void ingresoElTipoDePago(String pago) {
        page.altaMovilPostpagoCallCenterPage().selectTypeOfPayment(pago);
    }
    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        page.altaMovilPostpagoCallCenterPage().seleccionoElTipoDeEntregaDeDelivery(tipo);
    }

    @ScreenShotAfter
    public void ingresoLosDatosDelCliente(DataTable datosCliente) {
            String fechaNac= UtilWeb.getValueFromDataTable(datosCliente,"fechaNac");
            String estadoCivil=UtilWeb.getValueFromDataTable(datosCliente,"estadoCivil");
            String nacionalidad=UtilWeb.getValueFromDataTable(datosCliente,"nacionalidad");

            page.altaMovilPostpagoCallCenterPage().ingresarFechaNac(fechaNac);
            page.altaMovilPostpagoCallCenterPage().seleccionoNacionalidad(nacionalidad);
            page.altaMovilPostpagoCallCenterPage().seleccionarEstadoCivil(estadoCivil);
    }

    @ScreenShotAfter
    public void ValidoQuePresenteDetallePedido() {
        page.altaMovilPostpagoCallCenterPage().ValidoQuePresenteDetallePedido();
    }

    @ScreenShotAfter
    public void ValidoQuePresenteDetallePedido(String service) {
        page.altaMovilPostpagoCallCenterPage().ValidoQuePresenteDetallePedido(service);
    }

    public void doyClickenVerDetalleDelPedido() {
        page.altaMovilPostpagoCallCenterPage().clickenVerDetalleDelPedido();

    }
}

