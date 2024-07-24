package com.tdp.ct.web.glue;

import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.step.AltaTrioMTconUpfrontTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaTrioMTconUpfrontTiendaStepDefinition {

    @Autowired
    private AltaTrioMTconUpfrontTiendaStep altaTrioMTconUpfrontTiendaStep;

    @Autowired
    private Customer customer;

    @Y("doy click en el boton linea nueva")
    public void doyClickEnElBotonLineaNueva() {
        altaTrioMTconUpfrontTiendaStep.clickBotonLineaNueva();
    }

    @Y("doy click en el boton Ir a movistar total")
    public void doyClickEnElBotonIrAMovistarTotal() {
        altaTrioMTconUpfrontTiendaStep.clickBotonIrMovistarTotal();
    }


    @Y("voy hasta el final de la pagina")
    public void voyHastaElFinalDeLaPagina() {
        altaTrioMTconUpfrontTiendaStep.scrollFinalPagina();
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
