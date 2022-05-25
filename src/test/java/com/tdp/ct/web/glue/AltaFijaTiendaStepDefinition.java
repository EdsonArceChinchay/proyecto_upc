package com.tdp.ct.web.glue;
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
  public void selecciono_el_tipo_de_plan_fija(String planFija){
    altaFijaTiendaStep.seleccionarListaPLanFija(planFija);
  }

  @Y("doy clic para validar contrato hogar")
  public void doy_clic_para_validar_contrato_hogar(){
    altaFijaMovilRegistroStep.clicValidarContrato();
  }

  @Y("selecciono el plan {string}")
  public void selecciono_el_plan(String nombrePlan){
    altaFijaTiendaStep.seleccionarListaOfertas(nombrePlan);
    altaFijaMovilRegistroStep.clicBotonSeleccionarOferta();
    altaFijaTiendaStep.clickListaBotones();

  }

  @Y("ingreso los datos de agendamiento")
    public void ingreso_los_datos_de_agendamiento(){
    altaFijaTiendaStep.ingresarDatosAgendamiento();
  }

  @Y("presiono el boton confirmar agendamiento")
  public void presiono_el_boton_confirmar_agendamiento(){
    altaFijaTiendaStep.clickBotonConfirmarAgendamiento();
  }

  @Y("presiono el boton descargar contrato")
  public void presiono_el_boton_descargar_contrato(){

    altaFijaTiendaStep.clickDescargarContrato();
    altaFijaTiendaStep.clickDescargarPdf();
    altaFijaTiendaStep.cambiarPestanaPrincipal();
    altaFijaTiendaStep.clickCerrarPopUp();
  }

  @Y("presiono el boton Registrar venta")
  public void presiono_el_boton_Registrar_venta(){
    altaFijaTiendaStep.clickRegistrarVenta();
  }





}
