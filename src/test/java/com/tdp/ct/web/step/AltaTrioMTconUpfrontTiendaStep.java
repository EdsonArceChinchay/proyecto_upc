package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaTrioMTconUpfrontTiendaStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void clickBotonLineaNueva(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonLineaNueva();
    }
    @ScreenShotBefore
    public void clickBotonIrMovistarTotal(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonIrMovistarTotal();
    }
    @ScreenShotAfter
    public void ingresoTelefonoContacto(String numContacto){
        page.altaTrioMTconUpfrontTiendaPage().ingresoTelefonoContacto(numContacto);
    }
    @ScreenShotBefore
    public void clickBotonConfirmar(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonConfirmar();
    }

    @ScreenShotAfter
    public void ingresoCorreoElectronico(String correoElectronico){
        page.altaTrioMTconUpfrontTiendaPage().ingresoCorreoElectronico(correoElectronico);
    }
    @ScreenShotAfter
    public void vuelveIngresarCorreoElectronico(String vuelveIngresarCorreo){
        page.altaTrioMTconUpfrontTiendaPage().vuelveIngresarCorreoElectronico(vuelveIngresarCorreo);
    }
    @ScreenShotBefore
    public void clickBotonValidarIdentidad(){
        page.altaTrioMTconUpfrontTiendaPage().clickBotonValidarIdentidad();
    }
    @ScreenShotBefore
    public void clickDiscapacitadoHuellaDesgastado(){
        page.altaTrioMTconUpfrontTiendaPage().clickDiscapacitadoHuellaDesgastado();
    }
    @ScreenShotAfter
    public void seleccionoTipoDocumentoSupervisor(String tipoDoc){
        page.altaTrioMTconUpfrontTiendaPage().seleccionoTipoDocumentoSupervisor(tipoDoc);
    }
    @ScreenShotAfter
    public void ingresoNumeroDocumentoSuper(String documentoSuper){
        page.altaTrioMTconUpfrontTiendaPage().ingresoNumeroDocumentoSuper(documentoSuper);
    }

    @ScreenShotAfter
    public void ingresoUsuarioSupervisor(String user){
        page.altaTrioMTconUpfrontTiendaPage().ingresoUsuarioSupervisor(user);
    }
    @ScreenShotAfter
    public void ingresoContraseñaSupervisor(String passw){
        page.altaTrioMTconUpfrontTiendaPage().ingresoContraseñaSupervisor(passw);
    }

    public void seleccionoElNombreDePlanMovistarTotal() {
        page.altaTrioMTconUpfrontTiendaPage().seleccionoElNombreDePlanMovistarTotal();
    }

    @ScreenShotAfter
    public void scrollFinalPagina() {
        page.altaTrioMTconUpfrontTiendaPage().scrollFinalPagina();
    }
}
