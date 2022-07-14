package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaAltaMovilCallCenterStepDefinition {

  @Autowired
  private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;
  @Autowired
  private AltaFijaAltaMovilCallCenterStep altaFijaAltaMovilCallCenterStep;
  @Autowired
  private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

  @Y("ingreso la informacion del lugar de instalacion")
  public void iingreso_la_informacion_del_lugar_de_instalacion(DataTable dirInstalacion) {

    String manzana= UtilWeb.getValueFromDataTable(dirInstalacion,"mz");
    String lote= UtilWeb.getValueFromDataTable(dirInstalacion,"lote");
    String vivienda= UtilWeb.getValueFromDataTable(dirInstalacion,"vivienda");
    String nombreVivienda= UtilWeb.getValueFromDataTable(dirInstalacion,"nombreVivienda");
    String piso= UtilWeb.getValueFromDataTable(dirInstalacion,"piso");
    String interior= UtilWeb.getValueFromDataTable(dirInstalacion,"int");
    //String habitacion= UtilWeb.getValueFromDataTable(dirInstalacion,"conjunto");
    //String conj= UtilWeb.getValueFromDataTable(dirInstalacion,"conjHabit");
    altaFijaAltaMovilCallCenterStep.ingresarManzana(manzana);
    altaFijaAltaMovilCallCenterStep.ingresarLote(lote);
    altaFijaAltaMovilCallCenterStep.seleccionarTipoVivienda(vivienda);
    altaFijaAltaMovilCallCenterStep.ingresarNombreVivienda(nombreVivienda);
    altaFijaAltaMovilCallCenterStep.ingresarPiso(piso);
    altaFijaAltaMovilCallCenterStep.ingresarInterior(interior);
   // altaFijaAltaMovilCallCenterStep.seleccionarTipoConjuntoHabitacional(habitacion);
    //altaFijaAltaMovilCallCenterStep.ingresarConjuntoHabitacional(conj);

  }

  @Y("presiono el boton consultar cobertura")
  public void presiono_el_boton_Consultar_covertura() {
    altaFijaAltaMovilCallCenterStep.clickConsultarCobertura();
  }

  @Y("selecciono tipo de oferta")
  public void selecciono_tipo_de_oferta() {
    altaFijaAltaMovilCallCenterStep.scrollUp();
    altaFijaAltaMovilCallCenterStep.clickOferta();
  }

  @Y("selecciono un plan Movistar Total {string}")
  public void selecciono_un_plan_movistar_total(String nombrePlan) {
    altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
    altaFijaAltaMovilCallCenterStep.clickSeleccionarOferta();
    altaFijaAltaMovilCallCenterStep.clickIrAMovistarTotal();
  }


  @Y("doy clic nuevamente en confirmar")
  public void doy_clic_nuevamente_en_confirmar(){
    altaFijaAltaMovilCallCenterStep.clickBtnConfirmar2();
  }

  @Y("selecciono el departamento donde sera la entrega {string}")
  public void seleccionoElDepartamentoDondeSeraLaInstalacion(String dep) {
      altaFijaAltaMovilRetailStep.seleccionarTipoDepa(dep);
  }

  @Y("ingreso la direccion donde sera la entrega {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion(String data) {
      altaFijaAltaMovilRetailStep.writeDirec(data);
    }

  @Y("selecciono la provincia donde sera la entrega {string}")
  public void seleccionoLaProvinciaDondeSeraLaInstalacion(String provincia) {
      altaFijaAltaMovilRetailStep.seleccionarTipoProv(provincia);
  }

  @Y("ingreso la referencia de la direccion de entrega {string}")
  public void ingresoLaReferenciaDeLaDireccion(String referencia) {
      altaFijaAltaMovilRetailStep.writeReferencia(referencia);
  }

  @Y("selecciono el distrito donde sera la entrega {string}")
  public void seleccionoElDistritoDondeSeraLaInstalacion(String distri) {
    altaFijaAltaMovilRetailStep.seleccionarTipoDistrito(distri);
  }

  @Y("presiono Consultar ubicacion")
  public void presionoElBotonConsultarUbicacion() {
    altaFijaAltaMovilRetailStep.btnConsulta();
  }

  @Y("ingreso los datos del lugar de entrega")
  public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {

    String manzana= UtilWeb.getValueFromDataTable(dirInstalacion,"mz");
    String lote= UtilWeb.getValueFromDataTable(dirInstalacion,"lote");
    String piso= UtilWeb.getValueFromDataTable(dirInstalacion,"piso");
    String interior= UtilWeb.getValueFromDataTable(dirInstalacion,"int");
    String habitacion= UtilWeb.getValueFromDataTable(dirInstalacion,"conjunto");
    String conj= UtilWeb.getValueFromDataTable(dirInstalacion,"conjHabit");
    altaFijaAltaMovilRetailStep.writeMz(manzana);
    altaFijaAltaMovilRetailStep.writeLte(lote);
    altaFijaAltaMovilRetailStep.writePiso(piso);
    altaFijaAltaMovilRetailStep.writeInt(interior);
    altaFijaAltaMovilRetailStep.seleccionarConjunto(habitacion);
    altaFijaAltaMovilRetailStep.writeConjHab(conj);
  }

  @Y("presiono el boton confirmar ubicacion")
  public void presiono_el_boton_confirmar_ubicacion() {
    altaFijaAltaMovilCallCenterStep.clickBtnConfirmarUbicacion();
  }

  @Y("selecciono un tipo de entrega {string}")
  public void selecciono_un_tipo_de_entrega(String tipoEntrega) {
    altaFijaAltaMovilCallCenterStep.seleccionarTipoEntrega(tipoEntrega);
  }

  @Y("selecciono el horario de entrega {string}")
  public void selecciono_el_horario_de_entrega(String horarioEntrega) {
    altaFijaAltaMovilCallCenterStep.seleccionarBtnHorario(horarioEntrega);
  }

  @Y("ingreso el telefono de contacto {string}")
  public void ingreso_el_telefono_de_contacto(String telefono) {
    altaFijaAltaMovilCallCenterStep.ingresarTxtTelefono(telefono);
  }

  @Y("ingreso las instrucciones a considerar de la entrega {string}")
  public void ingreso_las_instrucciones_a_considerar_de_la_entrega(String instrucciones) {
    altaFijaAltaMovilCallCenterStep.ingresarTxtInstrucciones(instrucciones);
  }

  @Y("doy clic en confirmar delivery")
  public void doy_clic_en_confirmar_delivery() {
    altaFijaAltaMovilCallCenterStep.clickBtnConfirmarDelivery();
  }

  @Y("selecciono el metodo de pago {string}")
  public void selecciono_el_metodo_de_pago(String metodoPago){
    altaFijaAltaMovilCallCenterStep.seleccionarTipoPago(metodoPago);
  }

  @Y("ingreso un correo electronico {string}")
  public void ingreso_un_correo_electronico(String correo){
    altaFijaAltaMovilCallCenterStep.ingresarCorreo(correo);
  }

  @Y("ingreso nuevamente el correo electronico {string}")
  public void ingreso_nuevamente_el_correo_electronico(String correo){
    altaFijaAltaMovilCallCenterStep.ingresarCorreoNuevamente(correo);
  }

  @Y("doy clic en finalizar registro")
  public void doy_clic_en_finalizar_registro(){
    altaFijaAltaMovilCallCenterStep.clickBtnFinalizarRegistro();
  }

}
