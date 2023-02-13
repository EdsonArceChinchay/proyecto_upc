package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class MigracionDuoATrioTiendaStep {

    @Autowired
    private StepPages page;


        public void selecciono_la_cartilla_del_plan_Activo(){
            page.migracionDuoATrioTiendaPage().selecciono_la_cartilla_del_plan_Activo();
        }


    public void seleccionPlanNuevoParaVerLasOfertas() {
        page.migracionDuoATrioTiendaPage().seleccionPlanNuevoParaVerLasOfertas();
    }

    public void seleccionoElTipoDePlanHogar(String planHogar) {
        page.migracionDuoATrioTiendaPage().seleccionoElTipoDePlanHogar(planHogar);
    }

    public void seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(String planTrio) {
        page.migracionDuoATrioTiendaPage().seleccionoElTipoDePlanTrioYPresionoSeleccionarOferta(planTrio);
    }

    public void luegoDoyClickEnLaCartillaCambiarPlanHogar() {
        page.migracionDuoATrioTiendaPage().luegoDoyClickEnLaCartillaCambiarPlanHogar();
    }

    public void scrollUp() {
        page.migracionDuoATrioTiendaPage().scrollUp();
    }


    public void verificoLaDireccionActualDelServicio(String dir) {
        page.migracionDuoATrioTiendaPage().verificoLaDireccionActualDelServicio(dir);
    }

    public void doyClickEnEnElBoton(String btn) {
        page.migracionDuoATrioTiendaPage().doyClickEnEnElBoton(btn);
    }

    public void agregoSVALinea(String svaLinea) {page.migracionDuoATrioTiendaPage().agregoSVALinea(svaLinea);

    }

}
