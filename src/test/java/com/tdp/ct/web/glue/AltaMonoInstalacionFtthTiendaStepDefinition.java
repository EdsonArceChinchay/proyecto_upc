package com.tdp.ct.web.glue;

import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaMonoInstalacionFtthTiendaStep;
import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
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
    private AltaTrioMTconUpfrontTiendaStep altaTrioMTconUpfrontTiendaStep;

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

    @Y("selecciono la opcion Mono")
    public void seleccionoLaOpcionMono() {
        altaMonoHfcTiendaStep.clickBtnMono();
    }

    @Y("selecciono el tipo de plan mono {string} y presiono Seleccionar oferta")
    public void seleccionoElTipoDePlanMonoYPresionoSeleccionarOferta(String plan) {
        altaMonoHfcTiendaStep.seleccionarPlan(plan);
        altaMonoHfcTiendaStep.clickSeleccionarOferta();
    }

    @Y("presiono el boton Linea Nueva")
    public void presionoElBotonLineaNueva() {
        altaMonoHfcTiendaStep.esperarBtnLineaNueva();
        altaMonoHfcTiendaStep.clickBtnLineaNueva();
    }

    @Y("valido que se presente el detalle de el plan")
    public void validoQueSePresenteElDetalleDeElPlan() {
        altaMonoHfcTiendaStep.validarDetallePlan();
    }

    @Y("selecciono departamento {string} provincia {string} distrito {string} direccion {string} y referencia {string}")
    public void seleccionoDepartamentoProvinciaDistritoDireccionYReferencia(String depa, String prov, String distrito, String direc, String ref) {
        altaMonoHfcTiendaStep.writeDireccion(depa, prov, distrito, direc, ref);
    }

    @Y("ingreso la informacion del lugar para la instalacion")
    public void ingresoLaInformacionDelLugarParaLaInstalacion(DataTable dirInstalacion) {
        altaMonoHfcTiendaStep.scrollDirecCompleta();
        String manzana= UtilWeb.getValueFromDataTable(dirInstalacion,"mz");
        String lote= UtilWeb.getValueFromDataTable(dirInstalacion,"lote");
        String vivienda= UtilWeb.getValueFromDataTable(dirInstalacion,"vivienda");
        String nombreVivienda= UtilWeb.getValueFromDataTable(dirInstalacion,"nombreVivienda");
        String piso= UtilWeb.getValueFromDataTable(dirInstalacion,"piso");
        String interior= UtilWeb.getValueFromDataTable(dirInstalacion,"int");
        String tipoConjH= UtilWeb.getValueFromDataTable(dirInstalacion,"conjunto");
        String conjH= UtilWeb.getValueFromDataTable(dirInstalacion,"conjHabit");
        altaMonoHfcTiendaStep.writeDireccionInstalacion(manzana, lote, vivienda, nombreVivienda, piso, interior, tipoConjH, conjH);
    }

    @Y("presiono el boton Consultar Cobertura")
    public void presionoElBotonConsultarCobertura() {
        altaMonoHfcTiendaStep.clickBtnConsultarCobertura();
    }

    @Y("presiono el boton Consultar Ubicacion")
    public void presionoElBotonConsultarUbicacion() {
        altaMonoHfcTiendaStep.clickBtnConsultarUbicacion();
    }

    @Y("presiono el boton Iniciar Registro")
    public void presionoElBotonIniciarRegistro() {
        altaMonoHfcTiendaStep.moverToElementIniciarRegistro();
        altaTrioMTconUpfrontTiendaStep.clickBotonIniciarRegistro();
    }

    @Y("valido que se presente la pantalla agendamiento")
    public void validoQueSePresenteLaPantallaAgendamiento() {
        altaMonoHfcTiendaStep.scrollToViewAgendamiento();
        altaMonoHfcTiendaStep.validarPantallaAgendamiento();
    }

    @Y("ingreso telefono de contacto")
    public void ingresoTelefonoDeContacto() {
        altaMonoHfcTiendaStep.ingresarDatosAgendamiento();
    }

    @Y("presiono el boton Confirmar agendamiento")
    public void presionoElBotonConfirmarAgendamiento() {
        altaMonoHfcTiendaStep.clickBotonConfirmarAgendamiento();
    }

    @Y("ingreso email {string} y lo repito")
    public void ingresoEmailYLoRepito(String correo) {
        altaMonoHfcTiendaStep.writeEmail(correo);
    }

    @Y("presiono la opcion validar contrato")
    public void presionoLaOpcionValidarContrato() {
        altaFijaMovilRegistroStep.clicValidarContrato();
    }
}
