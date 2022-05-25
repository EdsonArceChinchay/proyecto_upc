package com.tdp.ct.web.step;

import com.tdp.ct.web.page.HomePage;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaFijaTiendaStep {

    @Autowired
    private StepPages page;

    public void seleccionarListaPLanFija(String planFija){
        page.altaFijaTiendaPage().listaPlanFija(planFija);
    }

    public void seleccionarListaOfertas(String ofertas){
        page.altaFijaTiendaPage().listaOfertas(ofertas);
    }

    public void clickListaBotones(){
        page.altaFijaTiendaPage().listaBotones();
    }

    public void ingresarDatosAgendamiento(){
        page.altaFijaTiendaPage().datosAgendamiento();
    }

    public void clickBotonConfirmarAgendamiento(){
        page.altaFijaTiendaPage().botonConfirmarAgendamiento();
    }

    public void clickDescargarContrato(){
        page.altaFijaTiendaPage().descargarContrato();
    }
    public void clickDescargarPdf(){
        page.altaFijaTiendaPage().descargarPdf();
    }

    public void cambiarPestanaPrincipal(){
        page.altaFijaTiendaPage().cambiarPestanaPrincipal();
    }

    public void clickCerrarPopUp(){
        page.altaFijaTiendaPage().cerrarPopUp();
    }

    public void clickRegistrarVenta(){
        page.altaFijaTiendaPage().registrarVenta();
    }
}
