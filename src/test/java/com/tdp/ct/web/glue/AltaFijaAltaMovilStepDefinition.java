package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaAltaMovilStepDefinition {

  @Autowired
  private AltaFijaAltaMovilStep altaFijaAltaMovilStep;

    @Y("selecciono el boton Linea Nueva Hogar")
    public void seleccionoElBotonLineaNuevaHogar() {
        altaFijaAltaMovilStep.btnHogar();
    }

    @Y("selecciono el boton Linea Nueva Movil")
    public void seleccionoElBotonLineaNuevaMovil() {
        altaFijaAltaMovilStep.btnMovil();
    }

    @Y("selecciono el boton Mostrar ofertas")
    public void seleccionoElBotonMostrarOfertas() {
      altaFijaAltaMovilStep.btnMostrar();
    }

  @Y("selecciono el departamento donde sera la instalacion {string}")
  public void seleccionoElDepartamentoDondeSeraLaInstalacion(String dep) {
      altaFijaAltaMovilStep.seleccionarTipoDepa(dep);
  }

  @Y("ingreso la direccion donde sera la instalacion {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion(String data) {
      altaFijaAltaMovilStep.writeDirec(data);
    }

  @Y("selecciono la provincia donde sera la instalacion {string}")
  public void seleccionoLaProvinciaDondeSeraLaInstalacion(String provincia) {
      altaFijaAltaMovilStep.seleccionarTipoProv(provincia);
  }

  @Y("ingreso la referencia de la direccion {string}")
  public void ingresoLaReferenciaDeLaDireccion(String referencia) {
      altaFijaAltaMovilStep.writeReferencia(referencia);
  }

  @Y("selecciono el distrito donde sera la instalacion {string}")
  public void seleccionoElDistritoDondeSeraLaInstalacion(String distri) {
    altaFijaAltaMovilStep.seleccionarTipoDistrito(distri);
  }

  @Y("presiono el boton Consultar ubicacion")
  public void presionoElBotonConsultarUbicacion() {
    altaFijaAltaMovilStep.btnConsulta();
  }

  @Y("ingresamos la Manzana o bloque {string}")
  public void ingresamosLaManzanaOBloque(String manzana) {
    altaFijaAltaMovilStep.writeMz(manzana);
  }

  @Y("ingresamos el Lote {string}")
  public void ingresamosElLote(String lote) {
      altaFijaAltaMovilStep.writeLte(lote);
  }

  @Y("ingresamos el Piso {string}")
  public void ingresamosElPiso(String piso) {
      altaFijaAltaMovilStep.writePiso(piso);
  }

  @Y("ingresamos el interior {string}")
  public void ingresamosElInterior(String interior) {
      altaFijaAltaMovilStep.writeInt(interior);
  }

  @Y("ingresamos el Tipo de conjunto habitacional {string}")
  public void ingresamosElTipoDeConjuntoHabitacional(String habitacion) {
      altaFijaAltaMovilStep.seleccionarConjunto(habitacion);
  }

  @Y("ingresamos el Nombre del conjunto habitacional {string}")
  public void ingresamosElNombreDelConjuntoHabitacional(String conj) {
      altaFijaAltaMovilStep.writeConjHab(conj);
  }

  @Y("presionamos el boton Consultar Cobertura")
  public void presionamosElBotonConsultarCobertura() {
      altaFijaAltaMovilStep.btnCobertura();
  }

    @Y("ingreso los datos del lugar de instalacion")
    public void ingresoLosDatosDelLugarDeInstalacion(DataTable dirInstalacion) {
      String manzana= UtilWeb.getValueFromDataTable(dirInstalacion,"mz");
      String lote= UtilWeb.getValueFromDataTable(dirInstalacion,"lote");
      String piso= UtilWeb.getValueFromDataTable(dirInstalacion,"piso");
      String interior= UtilWeb.getValueFromDataTable(dirInstalacion,"int");
      String habitacion= UtilWeb.getValueFromDataTable(dirInstalacion,"conjunto");
      String conj= UtilWeb.getValueFromDataTable(dirInstalacion,"conjHabit");
      altaFijaAltaMovilStep.writeMz(manzana);
      altaFijaAltaMovilStep.writeLte(lote);
      altaFijaAltaMovilStep.writePiso(piso);
      altaFijaAltaMovilStep.writeInt(interior);
      altaFijaAltaMovilStep.seleccionarConjunto(habitacion);
      altaFijaAltaMovilStep.writeConjHab(conj);
    }


  @Entonces("me muestra la pantalla de ofertas sugeridos")
  public void meMuestraLaPantallaDeOfertasSugeridos() {
    altaFijaAltaMovilStep.mostrarDetalleOfertasSugeridas();
  }

  @Y("selecciono el tipo de oferta {string}")
  public void seleccionoElTipoDeOferta(String oferta) {
    altaFijaAltaMovilStep.seleccionarOferta(oferta);
  }

  @Y("selecciono el tipo de plan {string}")
  public void seleccionoElTipoDePlan(String plan) {
    altaFijaAltaMovilStep.seleccionarPlan(plan);
  }

  @Y("valido el detalle de la seleccion")
  public void validoElDetalleDeLaSeleccion() {
    altaFijaAltaMovilStep.validarDetalleSeleccion();
  }

  @Cuando("doy clic a iniciar registro")
  public void doyClicAIniciarRegistro() {
    altaFijaAltaMovilStep.clicIniciarRegistro();
  }

  @Y("seleciono la fecha y hora del agendamiento")
  public void selecionoLaFechaYHoraDelAgendamiento() {

  }

  @Entonces("me muestra el detalle de la instalacion")
  public void meMuestraElDetalleDeLaInstalacion() {

  }

  @Y("doy clic en confirmar")
  public void doyClicEnConfirmar() {

  }

  @Y("completo los datos solicitados {string}")
  public void completoLosDatosSolicitados(String correo) {

  }

  @Y("doy click en validar identidad del titular")
  public void doyClickEnValidarIdentidadDelTitular() {

  }

  @Y("elijo el tipo de validacion a realizar {string}")
  public void elijoElTipoDeValidacionARealizar(String tipoValidacion) {

  }

  @Entonces("valido que me muestre el boton con el texto de identidad validada")
  public void validoQueMeMuestreElBotonConElTextoDeIdentidadValidada() {

  }

  @Y("ingreso los datos solicitados para la validacion del cliente")
  public void ingresoLosDatosSolicitadosParaLaValidacionDelCliente(DataTable datos) {

  }

  @Y("doy clic en continuar")
  public void doyClicEnContinuar() {

  }

  @Y("me muestra en pantalla el contrato solicitado")
  public void meMuestraEnPantallaElContratoSolicitado() {

  }

  @Cuando("doy clic en si acepto")
  public void doyClicEnSiAcepto() {

  }

  @Entonces("visualizo en pantalla el mensaje de exito")
  public void visualizoEnPantallaElMensajeDeExito() {

  }

  @Y("muestro en consola el numero de registro generado")
  public void muestroEnConsolaElNumeroDeRegistroGenerado() {

  }

  @Y("doy clic para ver el contrato PDF")
  public void doyClicParaVerElContratoPDF() {

  }

}
