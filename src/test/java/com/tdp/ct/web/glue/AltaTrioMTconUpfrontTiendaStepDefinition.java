package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaTrioMTconUpfrontTiendaStepDefinition {

    @Autowired
    private AltaTrioMTconUpfrontTiendaStep altaTrioMTconUpfrontTiendaStep;


    @Y("doy click en el boton linea nueva")
    public void doyClickEnElBotonLineaNueva() {
        altaTrioMTconUpfrontTiendaStep.clickBotonLineaNueva();
    }


    @Y("doy click en el boton consultar cobertura")
    public void doyClickEnElBotonConsultarCobertura() {
        altaTrioMTconUpfrontTiendaStep.clickBotonConsultarCobertura();
    }

    @Y("doy click en el boton Ir a movistar total")
    public void doyClickEnElBotonIrAMovistarTotal() {
        altaTrioMTconUpfrontTiendaStep.clickBotonIrMovistarTotal();
    }

    @Y("presiono el boton iniciar registro")
    public void presionoElBotonIniciarRegistro() {
        altaTrioMTconUpfrontTiendaStep.clickBotonIniciarRegistro();
    }

    @Y("selecciono la fecha de instalacion")
    public void seleccionoLaFechaDeInstalacion() {
        
    }

    @Y("ingreso telefono del contacto {string}")
    public void ingresoTelefonoDelContacto(String numContacto) {
        altaTrioMTconUpfrontTiendaStep.ingresoTelefonoContacto(numContacto);
    }

    @Y("doy click en el boton confirmar")
    public void doyClickEnElBotonConfirmar() {
        altaTrioMTconUpfrontTiendaStep.clickBotonConfirmar();
    }

    @Y("valido detalles de instalacion")
    public void validoDetallesDeInstalacion() {
        altaTrioMTconUpfrontTiendaStep.validoDetalleDeInstalacion();
    }

    @Y("confirmo el registro de instalacion")
    public void confirmoElRegistroDeInstalacion() {
        altaTrioMTconUpfrontTiendaStep.clickBtnConfirmarElRegistro();
    }

    @Y("ingreso el correo electronico {string}")
    public void ingresoElCorreoElectronico(String correoElectronico) {
        altaTrioMTconUpfrontTiendaStep.ingresoCorreoElectronico(correoElectronico);
    }

    @Y("vuelvo ingresar el correo electronico {string}")
    public void vuelvoIngresarElCorreoElectronico(String vuelveIngresarCorreo) {
        altaTrioMTconUpfrontTiendaStep.vuelveIngresarCorreoElectronico(vuelveIngresarCorreo);
    }

    @Y("doy click en el boton validar identidad del titular")
    public void doyClickEnElBotonValidarIdentidadDelTitular() {
        altaTrioMTconUpfrontTiendaStep.clickBotonValidarIdentidad();
    }

    @Y("doy click en discapacitado o huella desgastado")
    public void doyClickEnDiscapacitadoOHuellaDesgastado() {
        altaTrioMTconUpfrontTiendaStep.clickDiscapacitadoHuellaDesgastado();
    }

    @Y("selecciono tipo de documento del supervisor {string}")
    public void seleccionoTipoDeDocumentoDelSupervisor(String tipoDoc) {
        altaTrioMTconUpfrontTiendaStep.seleccionoTipoDocumentoSupervisor(tipoDoc);
    }

    @Y("ingreso el numero de documento del supervisor {string}")
    public void ingresoElNumeroDeDocumentoDelSupervisor(String documentoSuperv) {
        altaTrioMTconUpfrontTiendaStep.ingresoNumeroDocumentoSuper(documentoSuperv);
    }

    @Y("presiono el boton confirmar")
    public void presionoElBotonConfirmar() {
        altaTrioMTconUpfrontTiendaStep.presionoBotonConfirmar();
    }

    @Y("ingreso usuario citrix de supervisor {string}")
    public void ingresoUsuarioCitrixDeSupervisor(String user) {
        altaTrioMTconUpfrontTiendaStep.ingresoUsuarioSupervisor(user);
    }

    @Y("ingreso contraseña de supervisor {string}")
    public void ingresoContraseñaDeSupervisor(String passw) {
        altaTrioMTconUpfrontTiendaStep.ingresoContraseñaSupervisor(passw);
    }

    @Y("selecciono el nombre de plan movistar total")
    public void seleccionoElNombreDePlanMovistarTotal() {
        altaTrioMTconUpfrontTiendaStep.seleccionoElNombreDePlanMovistarTotal();
    }
}
