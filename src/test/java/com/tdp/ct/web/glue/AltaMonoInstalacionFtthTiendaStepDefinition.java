package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaMonoInstalacionFtthTiendaStep;
import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
import com.tdp.ct.web.step.CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaMonoInstalacionFtthTiendaStepDefinition {

    @Autowired
    private AltaMonoInstalacionFtthTiendaStep altaMonoHfcTiendaStep;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Autowired
    private CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep caplConCaeqAlContadoCanalTiendaStep;

    @Y("ingreso los datos del cliente extranjero a registrar")
    public void ingresoNombreApellidoYGeneroDelClienteExtranjero(DataTable datos) {
        altaFijaMovilRegistroStep.ingresarDatosClienteExtranjero(datos);
        altaMonoHfcTiendaStep.scrollToBtnCrearCliente();
        altaMonoHfcTiendaStep.crearCliente();
    }

    @Entonces("valido que se presente la pantalla con el titulo {string}")
    public void validoSePresentePantallaConTitulo(String title) {
        altaMonoHfcTiendaStep.validarOfertasSugeridasView(title);
    }

    @Y("selecciono el boton de eleccion de planes Plan Nuevo")
    public void seleccionoElBotonDeEleccionDePlanesPlanNuevo() {
        altaMonoHfcTiendaStep.scrollToBtnPlanNuevo();
        altaMonoHfcTiendaStep.clickBtnPlanNuevo();
    }

    @Y("selecciono el tipo {string}")
    public void seleccionoElTipo(String tipoPlan) {
        altaMonoHfcTiendaStep.clickBtnTipoPlan(tipoPlan);
    }

    @Y("presiono el boton {string}")
    public void presionoElBotonLineaNueva(String btnName) {
        altaMonoHfcTiendaStep.esperarBtnLineaNueva();
        altaMonoHfcTiendaStep.clickBtnLineaNueva(btnName);
    }

    @Y("valido que se presente el detalle de el plan")
    public void validoQueSePresenteElDetalleDeElPlan() {
        altaMonoHfcTiendaStep.validarDetallePlan();
    }


    @Y("presiono la opcion validar contrato")
    public void presionoLaOpcionValidarContrato() {
        altaFijaMovilRegistroStep.clicValidarContrato();
    }

    @Y("ingreso email {string} y lo repito")
    public void ingresoEmailYLoRepito(String correo) {
        caplConCaeqAlContadoCanalTiendaStep.writeEmail(correo);
    }


}
