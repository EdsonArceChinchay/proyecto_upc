package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaMonoInstalacionFtthTiendaStep;
import com.tdp.ct.web.step.Caeq.CAPLdePrepagoAPostpagoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CAPLdePrepagoAPostpagoStepDefinition {
    @Autowired
    private CAPLdePrepagoAPostpagoStep capLdePrepagoAPostpagoStep;

    @Autowired
    private AltaMonoInstalacionFtthTiendaStep altaMonoHfcTiendaStep;

    @Y("selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan")
    public void seleccionoElBtnVerDetalleDelPlanActualYPresionoElBtnRenovarPlan() {
        capLdePrepagoAPostpagoStep.esperarBtnCardPlanActual();
        capLdePrepagoAPostpagoStep.clickBtnCardPlanActual();
        capLdePrepagoAPostpagoStep.clickBtnRenovarPlan();
    }

    @Y("selecciono el plan {string} y presiono Seleccionar Oferta")
    public void seleccionoElPlanYPresionoSeleccionarOferta(String plan) {
        altaMonoHfcTiendaStep.seleccionarPlan(plan);
        capLdePrepagoAPostpagoStep.clickSelectOferta();
    }

    @Y("valido que se haya seleccionado el plan {string} correctamente")
    public void validoQueSeHayaSeleccionadoElPlanCorrectamente(String plan) {
        capLdePrepagoAPostpagoStep.validarPlanSelected(plan);
    }

    @Y("presiono la opcion Añadir equipo en el card del plan actual")
    public void presionoLaOpcionAñadirEquipoEnElCardDelPlanActual() {
        capLdePrepagoAPostpagoStep.esperarBtnAddEquipoInCard();
        capLdePrepagoAPostpagoStep.clickBtnAddEquipoInCard();
    }

    @E("ingreso permanencia, tipo de pago y equipo")
    public void ingresoPermanenciaTipoPagoYEquipo(DataTable datos) {
        String permanencia = UtilWeb.getValueFromDataTable(datos,"permanencia");
        String tipoPago =UtilWeb.getValueFromDataTable(datos,"tipoPago");
        String equipoName =UtilWeb.getValueFromDataTable(datos,"equipoName");
        capLdePrepagoAPostpagoStep.selectPermanencia(permanencia);
        capLdePrepagoAPostpagoStep.selectTipoPago(tipoPago);
        capLdePrepagoAPostpagoStep.writeModeloEquipo(equipoName);
    }

    @Y("presiono el boton Ver detalle valido contenido y selecciono")
    public void presionoBotonVerDetalleValidoContenidoYSelecciono() {
        capLdePrepagoAPostpagoStep.scrollToVerBtnDetalles();
        capLdePrepagoAPostpagoStep.clickBtnVerDetalle();
        capLdePrepagoAPostpagoStep.validarFeatures();
        capLdePrepagoAPostpagoStep.clickBtnSelectEquipo();
    }

    @Y("presiono el boton con shadow Iniciar Registro")
    public void presionoElBotonConShadowIniciarRegistro() {
        capLdePrepagoAPostpagoStep.clickBtnConShadowIniciarRegistro();
    }

    @Y("ingreso email {string} y lo confirmo")
    public void ingresoEmailYLoConfirmo(String email) {
        capLdePrepagoAPostpagoStep.writeEmail(email);
    }
}


