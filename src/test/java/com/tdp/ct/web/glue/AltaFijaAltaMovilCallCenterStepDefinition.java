package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

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

    @Y("selecciono la oferta {string}")
    public void seleccionoLaOferta(String offer) {
        altaFijaTiendaStep.seleccionarListaOfertas(offer);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Y("selecciono el boton Linea Nueva")
    public void seleccionoElBotonLineaNueva() {
        altaFijaAltaMovilCallCenterStep.clickListaBotones();
    }

    @Y("doy click en el boton Linea Nueva")
    public void selecciono_en_linea_nueva() {
        altaFijaAltaMovilCallCenterStep.seleccionarLineaNueva();
    }

    @Y("doy click en Cambiar plan hogar")
    public void doyClickEnCambiarPlanHogar() {
        altaFijaTiendaStep.seleccionarboton();
    }

    @Y("selecciono el tipo de plan {string}")
    public void selecciono_el_tipo_de_plan_fija(String planFija) {
        altaFijaTiendaStep.seleccionarListaPLanFija(planFija);
    }

    @Y("selecciono el plan {string}")
    public void selecciono_el_plan(String nombrePlan) {
        altaFijaTiendaStep.seleccionarListaOfertas(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
        altaFijaAltaMovilCallCenterStep.clickListaBotones();
    }

    @Y("doy click en añadir SVA")
    public void onAddSvaClick() {
        altaFijaTiendaStep.onAddSvaClick();
    }

    @Y("selecciono el boton de eleccion de planes")
    public void seleccionoElBotonDeEleccionDePlanes() {
        altaFijaAltaMovilCallCenterStep.BtonOpciones();
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

    @Y("selecciono el plan {string} Movistar Total")
    public void seleccionoUnPlanMovistarTotal(String nombrePlan) {
        altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Y("doy click en el boton Ir a movistar total")
    public void doyClickEnElBotonIrAMovistarTotal() {
        altaFijaAltaMovilCallCenterStep.clickBotonIrMovistarTotal();
    }

    @Y("selecciono el nombre de plan movistar total")
    public void seleccionoElNombreDePlanMovistarTotal() {
        altaFijaAltaMovilCallCenterStep.seleccionoElNombreDePlanMovistarTotal();
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

    @Y("valido si el cliente {string}, {string} con genero {string} ya esta registrado")
    public void validoSiElClienteConGeneroYaEstaRegistrado(String customerName, String customerLastName, String customerGenre) {
        altaFijaTiendaStep.validacionClienteNuevo(customerName, customerLastName, customerGenre);
    }

    @Y("Valido que el beneficio sea {string}")
    public void validacionBeneficioPlan(String beneficioPlan) {
        if (!Objects.equals(beneficioPlan, "null")) {
            altaFijaTiendaStep.validacionBeneficioPlan(beneficioPlan);
        }
    }

    @Y("Valido que el descuento aplicado sea {string}")
    public void valdiacionDescuento(String discount) {
        if (!Objects.equals(discount, "")) {
            altaFijaTiendaStep.validacionBeneficioPlan(discount);
        }
    }


    @Y("presiono el boton consultar cobertura")
    public void presiono_el_boton_Consultar_covertura() {
        altaFijaAltaMovilCallCenterStep.clickConsultarCobertura();
    }

    @Y("selecciono un plan {string} de Movistar Total")
    public void seleccionoUnPlanDeMovistarTotal(String nombrePlan) {
        //this.scenario.log(altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan));
        //altaFijaAltaMovilCallCenterStep.clickSeleccionarOferta();
        altaFijaAltaMovilCallCenterStep.seleccionarListaOferta(nombrePlan);
        altaFijaTiendaStep.clickSeleccionarOferta();
    }

    @Y("selecciono ir a Movistar Total")
    public void seleccionoIrAMovistarTotal() {
        altaFijaAltaMovilCallCenterStep.clickIrAMovistarTotal();
    }
}
