package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@ScreenShot
@Component
public class AltaFijaAltaMovilCallCenterStep {

    @Autowired
    private StepPages page;

    public void ingresarManzana(String manzana){
        page.altaFijaAltaMovilCallCenterPage().manzana(manzana);
    }
    public void ingresarLote(String lote){
        page.altaFijaAltaMovilCallCenterPage().lote(lote);
    }
    public void seleccionarTipoVivienda(String tipoVivienda){
        page.altaFijaAltaMovilCallCenterPage().tipoVivienda(tipoVivienda);
    }
    public void ingresarNombreVivienda(String nomVivienda){
        page.altaFijaAltaMovilCallCenterPage().nombreVivienda(nomVivienda);
    }
    public void ingresarPiso(String piso){
        page.altaFijaAltaMovilCallCenterPage().piso(piso);
    }
    public void ingresarInterior(String interior){
        page.altaFijaAltaMovilCallCenterPage().interior(interior);
    }
    public void seleccionarTipoConjuntoHabitacional(String data){
        page.altaFijaAltaMovilCallCenterPage().tipoConjuntoHabitacional(data);
    }
    public void ingresarConjuntoHabitacional(String data){
        page.altaFijaAltaMovilCallCenterPage().conjuntoHabitacional(data);
    }

   public void clickBtnConfirmarUbicacion(){
       page.altaFijaAltaMovilCallCenterPage().btnConfirmarUbicacion();
   }

   public void clickConsultarCobertura(){
        page.altaFijaAltaMovilCallCenterPage().btnConsultarCobertura();
   }

   public void seleccionarTipoEntrega(String tipEntrega){
       page.altaFijaAltaMovilCallCenterPage().tipoEntrega(tipEntrega);
   }

   public void ingresarTxtTelefono(String telefono){
       page.altaFijaAltaMovilCallCenterPage().txtTelefono(telefono);
   }

    public void ingresarTxtInstrucciones(String instrucciones){
        page.altaFijaAltaMovilCallCenterPage().txtInstrucciones(instrucciones);
    }

    public void clickBtnConfirmarDelivery(){
       page.altaFijaAltaMovilCallCenterPage().btnConfirmarDelivery();
    }

    public void seleccionarTipoPago(String tipoPago){
        page.altaFijaAltaMovilCallCenterPage().tipoPago(tipoPago);
    }
    public void ingresarCorreo(String correo){
        page.altaFijaAltaMovilCallCenterPage().correo(correo);
    }
    public void ingresarCorreoNuevamente(String correo){
        page.altaFijaAltaMovilCallCenterPage().confirmarCorreo(correo);
    }
    public void clickBtnConfirmar2(){
        page.altaFijaAltaMovilCallCenterPage().btnConfirmar2();
    }
    public void clickBtnFinalizarRegistro(){
        page.altaFijaAltaMovilCallCenterPage().btnFinalizarRegistro();
    }
    public void clickOferta(){
        page.altaFijaAltaMovilCallCenterPage().oferta();
    }

    }

