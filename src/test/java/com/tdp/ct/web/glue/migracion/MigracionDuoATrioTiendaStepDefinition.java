package com.tdp.ct.web.glue.migracion;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.MigracionDuoATrioTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class MigracionDuoATrioTiendaStepDefinition {

  @Autowired
  private MigracionDuoATrioTiendaStep migracionDuoATrioTiendaStep;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("selecciono la cartilla del plan activo")
    public void selecciono_la_cartilla_del_plan_Activo(){
        migracionDuoATrioTiendaStep.selecciono_la_cartilla_del_plan_Activo();
    }


    @Y("seleccion plan nuevo para ver las ofertas")
    public void seleccionPlanNuevoParaVerLasOfertas() {
        migracionDuoATrioTiendaStep.scrollUp();
        migracionDuoATrioTiendaStep.seleccionPlanNuevoParaVerLasOfertas();
    }

    @Y("selecciono el tipo de plan Hogar {string}")
    public void seleccionoElTipoDePlanHogar(String planHogar) {
        migracionDuoATrioTiendaStep.seleccionoElTipoDePlanHogar(planHogar);
    }

    @Y("selecciono el tipo de plan trio {string} y presiono Seleccionar oferta")
    public void seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(String planTrio) {
        migracionDuoATrioTiendaStep.seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(planTrio);
    }

    @Y("luego doy click en la cartilla cambiar plan hogar")
    public void luegoDoyClickEnLaCartillaCambiarPlanHogar() {
        migracionDuoATrioTiendaStep.luegoDoyClickEnLaCartillaCambiarPlanHogar();
    }


    @Y("verifico la direccion {string} actual del servicio")
    public void verificoLaDireccionActualDelServicio(String dir) {
        migracionDuoATrioTiendaStep.verificoLaDireccionActualDelServicio(dir);
    }

    @Y("doy click en el boton {string}")
    public void doyClickEnEnElBoton(String btn) {
        migracionDuoATrioTiendaStep.doyClickEnEnElBoton(btn);
    }

    @Y("doy click en agregar SVA Linea {string}")
    public void doyClickEnAgregarSVALinea(String SvaLinea) {
        altaFijaMovilRegistroStep.clicEnAgregarSVA();
        migracionDuoATrioTiendaStep.agregoSVALinea(SvaLinea);
        altaFijaMovilRegistroStep.clicGuardarCambios();

    }

    @Y("doy click en agregar Modem")
    public void doyClickEnAgregarModem() {
        altaFijaMovilRegistroStep.clicEnAgregarSVA();
        migracionDuoATrioTiendaStep.doyClickEnAgregarModem();
        altaFijaMovilRegistroStep.clicGuardarCambios();
    }

    @Y("cierro el popup de contraseña Única")
    public void cierroElPopupDeContraseñaÚnica() {
        migracionDuoATrioTiendaStep.cerrarPopupCU();
    }

    @Y("Selecciono la cartilla del plan Motvistar Total")
    public void seleccionoLaCartillaDelPlanMotvistarTotal() {migracionDuoATrioTiendaStep.seleccionoCartillaMovistarTotal();
    }
}
