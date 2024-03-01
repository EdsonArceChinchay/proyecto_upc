package com.tdp.ct.web.glue;

import com.tdp.ct.web.CaptchaBase.Parameters;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaTiendaStepDefinition {

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;
    @Autowired
    private AltaFijaAltaMovilCallCenterStep altaFijaAltaMovilCallCenterStep;
    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;


    @Y("selecciono el tipo de plan fija {string}")
    public void selecciono_el_tipo_de_plan_fija(String planFija) {
        altaFijaTiendaStep.seleccionarListaPLanFija(planFija);
    }

    @Y("doy clic para validar contrato hogar")
    public void doy_clic_para_validar_contrato_hogar() {
        altaFijaMovilRegistroStep.clicValidarContrato();
    }

    @Y("selecciono el plan {string}")
    public void selecciono_el_plan(String nombrePlan) {
        altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
       // altaFijaAltaMovilCallCenterStep.clickSeleccionarOferta();
        //altaFijaTiendaStep.seleccionarListaOfertas(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
        altaFijaTiendaStep.clickListaBotones();

    }

    @Y("verifico si me encuentro en la pantalla de agendamiento")
    public void verifico_si_me_encuentro_en_la_pantalla_de_agendamiento() {
        altaFijaTiendaStep.verificarEstadoPantallaAgendamiento();
    }

    @Y("ingreso los datos de agendamiento")
    public void ingreso_los_datos_de_agendamiento() {
        altaFijaTiendaStep.ingresarDatosAgendamiento();
    }

    @Y("presiono el boton confirmar agendamiento")
    public void presiono_el_boton_confirmar_agendamiento() {
        altaFijaTiendaStep.clickBotonConfirmarAgendamiento();
    }

    @Y("presiono el boton descargar contrato")
    public void presiono_el_boton_descargar_contrato() {

        altaFijaTiendaStep.clickDescargarContrato();
        altaFijaTiendaStep.clickDescargarPdf();
        altaFijaTiendaStep.cambiarPestanaPrincipal();
        altaFijaTiendaStep.clickCerrarPopUp();
    }

    @Y("presiono el boton Registrar venta")
    public void presiono_el_boton_Registrar_venta() {
        if (Parameters.estadoFlujo){
            altaFijaTiendaStep.clickRegistrarVenta();
        }
    }


    @Y("doy click en añadir SVA")
    public void doyClickEnAñadirSVA() {
        altaFijaTiendaStep.doyClickEnAñadirSVA();
    }

    @Y("doy click en agregar Bloque {string}")
    public void doyClickEnAgregarBloque(String Bloque) {
        altaFijaTiendaStep.doyClickEnAgregarBloque(Bloque);

    }

    @Y("doy click en Guardar cambios")
    public void doyClickEnGuardarCambios() {
        altaFijaTiendaStep.doyClickEnGuardarCambios();
    }

    @Y("ingreso los datos de agendamiento para RUC")
    public void ingresoLosDatosDeAgendamientoParaRUC() {
        altaFijaTiendaStep.ingresarDatosAgendamientoParaRUC();
    }

    @Y("doy clic en el boton validar identidad representante legal")
    public void doyClicEnElBotonValidarIdentidadRepresentanteLegal() {
        altaFijaTiendaStep.clickBotonValidarRepreLegal();
    }

    @Y("presiono en el boton de Registrar Venta")
    public void presionoEnElBotonDeRegistrarVenta() {
        altaFijaTiendaStep.clickBotonRegistrarVenta();
    }

    @Y("selecciono el boton Linea Nueva")
    public void seleccionoElBotonLineaNueva() {
        altaFijaTiendaStep.clickListaBotones();
    }
}
