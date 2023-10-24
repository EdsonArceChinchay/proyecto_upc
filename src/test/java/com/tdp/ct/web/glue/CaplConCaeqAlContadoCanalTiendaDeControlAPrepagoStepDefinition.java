package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaMonoInstalacionFtthTiendaStep;
import com.tdp.ct.web.step.CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStepDefinition {

    @Autowired
    private CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoStep caplConCaeqAlContadoCanalTiendaStep;

    @Autowired
    private AltaMonoInstalacionFtthTiendaStep altaMonoHfcTiendaStep;

    @Y("selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan")
    public void seleccionoElBtnVerDetalleDelPlanActualYPresionoElBtnRenovarPlan() {
        //caplConCaeqAlContadoCanalTiendaStep.esperarBtnCardPlanActual();
        caplConCaeqAlContadoCanalTiendaStep.clickBtnCardPlanActual();
        caplConCaeqAlContadoCanalTiendaStep.clickBtnRenovarPlan();
    }

    @Y("selecciono el plan {string} y presiono Seleccionar Oferta")
    public void seleccionoElPlanYPresionoSeleccionarOferta(String plan) {
        altaMonoHfcTiendaStep.seleccionarPlan(plan);
        caplConCaeqAlContadoCanalTiendaStep.clickSelectOferta();
    }

    @Y("valido que se haya seleccionado el plan {string} correctamente")
    public void validoQueSeHayaSeleccionadoElPlanCorrectamente(String plan) {
        caplConCaeqAlContadoCanalTiendaStep.validarPlanSelected(plan);
    }

    @Y("presiono la opcion Añadir equipo en el card del plan actual")
    public void presionoLaOpcionAñadirEquipoEnElCardDelPlanActual() {
        caplConCaeqAlContadoCanalTiendaStep.esperarBtnAddEquipoInCard();
        caplConCaeqAlContadoCanalTiendaStep.clickBtnAddEquipoInCard();
    }

    @E("ingreso permanencia, tipo de pago y equipo")
    public void ingresoPermanenciaTipoPagoYEquipo(DataTable datos) {
        String permanencia = UtilWeb.getValueFromDataTable(datos,"permanencia");
        String tipoPago =UtilWeb.getValueFromDataTable(datos,"tipoPago");
        String equipoName =UtilWeb.getValueFromDataTable(datos,"equipoName");
        caplConCaeqAlContadoCanalTiendaStep.selectPermanencia(permanencia);
        caplConCaeqAlContadoCanalTiendaStep.selectTipoPago(tipoPago);
        caplConCaeqAlContadoCanalTiendaStep.writeModeloEquipo(equipoName);
    }

    @Y("presiono el boton Ver detalle valido contenido y selecciono")
    public void presionoBotonVerDetalleValidoContenidoYSelecciono() {
        caplConCaeqAlContadoCanalTiendaStep.scrollToVerBtnDetalles();
        caplConCaeqAlContadoCanalTiendaStep.clickBtnVerDetalle();
        caplConCaeqAlContadoCanalTiendaStep.validarFeatures();
        caplConCaeqAlContadoCanalTiendaStep.clickBtnSelectEquipo();
    }

    @Y("presiono el boton con shadow Iniciar Registro")
    public void presionoElBotonConShadowIniciarRegistro() {
        caplConCaeqAlContadoCanalTiendaStep.clickBtnConShadowIniciarRegistro();
    }

    @Y("ingreso email {string} y lo confirmo")
    public void ingresoEmailYLoConfirmo(String email) {
        caplConCaeqAlContadoCanalTiendaStep.writeEmail(email);
    }

    @Y("selecciono el boton Ver detalle del servicio {string}")
    public void seleccionoElBotonVerDetalleDelServicio(String nroServicio) {
        caplConCaeqAlContadoCanalTiendaStep.clickBtnVerDetalle(nroServicio);
    }
}
