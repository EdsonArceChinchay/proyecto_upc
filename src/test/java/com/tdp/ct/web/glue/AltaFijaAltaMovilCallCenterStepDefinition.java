package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;

import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaAltaMovilCallCenterStepDefinition {

    @Autowired
    private AltaFijaAltaMovilCallCenterStep altaFijaAltaMovilCallCenterStep;

    @Autowired
    private AltaFijaTiendaStep altaFijaTiendaStep;

    @Y("selecciono tipo de oferta")
    public void selecciono_tipo_de_oferta() {
        altaFijaAltaMovilCallCenterStep.scrollUp();
        altaFijaAltaMovilCallCenterStep.clickOferta();
    }

    @Y("selecciono el primer tipo de oferta")
    public void selecciono_el_primer_tipo_de_oferta() {
        altaFijaAltaMovilCallCenterStep.scrollUp();
        altaFijaAltaMovilCallCenterStep.clickPrimeraOferta();
    }

    @Y("selecciono un plan Movistar Total {string}")
    public void selecciono_un_plan_movistar_total(String nombrePlan) {
        altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
        altaFijaAltaMovilCallCenterStep.clickIrAMovistarTotal();
    }


    @Y("selecciono el metodo de pago {string}")
    public void selecciono_el_metodo_de_pago(String metodoPago) {
        altaFijaAltaMovilCallCenterStep.seleccionarTipoPago(metodoPago);
    }

    @Y("ingreso un correo electronico {string}")
    public void ingreso_un_correo_electronico(String correo) {
        altaFijaAltaMovilCallCenterStep.ingresarCorreo(correo);
    }

    @Y("ingreso nuevamente el correo electronico {string}")
    public void ingreso_nuevamente_el_correo_electronico(String correo) {
        altaFijaAltaMovilCallCenterStep.ingresarCorreoNuevamente(correo);
    }

    @Y("selecciono el plan {string} Movistar Total")
    public void seleccionoUnPlanMovistarTotal(String nombrePlan) {
        altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Entonces("valido en la etapa resumen el nombre del plan escogido {string}")
    public void validoEnLaEtapaResumenElNombreDelPlanEscogido(String nomPlan) {
        altaFijaTiendaStep.validarNomPlan(nomPlan);
    }

    @Y("valido la velocidad de internet {string}")
    public void validoLaVelocidadDeInternet(String mbpsBB) {
        altaFijaTiendaStep.validarVelocidadInternet(mbpsBB);
    }

    @Y("valido el precio de descuento del componente Internet {string}")
    public void validoElPrecioDeDescuentoDelComponenteInternet(String precDesc) {
        altaFijaTiendaStep.validarPrecioDescuento(precDesc);
    }

    @Y("valido el nombre del SVA de contenido externo {string}")
    public void validoElNombreDelSVADeContenidoExterno(String nomsvaTV) {
        altaFijaTiendaStep.validarnombreSVAcontenido(nomsvaTV);
    }

    @Y("valido el precio de descuento del componente TV {string}")
    public void validoElPrecioDeDescuentoDelComponenteTV(String pDescTV) {
        altaFijaTiendaStep.validarPrecioDescuentoTV(pDescTV);
    }

    @Y("selecciono la oferta {string}")
    public void seleccionoLaOferta(String oferta) {
        altaFijaTiendaStep.seleccionarListaOfertas(oferta);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }
}
