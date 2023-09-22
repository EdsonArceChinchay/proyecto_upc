package com.tdp.ct.web.glue.migracion;

import com.tdp.ct.web.step.migracion.MigraTrioaMTcanalCallCenterStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class MigraTrioaMTcanalCallCenterStepDefinition {
    @Autowired
    private MigraTrioaMTcanalCallCenterStep migraTrioaMTcanalCallCenterStep;

    @Y("selecciono plan Movistar Total para ver las ofertas")
    public void seleccionoPlanMovistarTotalParaVerLasOfertas() {
        migraTrioaMTcanalCallCenterStep.scrollUp();
        migraTrioaMTcanalCallCenterStep.seleccionoPlanMovistarTotal();
    }


    @Y("selecciono un plan y doy click en el boton seleccionar oferta")
    public void seleccionoUnPlanYDoyClickEnElBotonSeleccionarOferta() {
        migraTrioaMTcanalCallCenterStep.seleccionoPlandeOferta();
        migraTrioaMTcanalCallCenterStep.clickBotonSeleccionarOferta();
    }

    @Y("luego doy click en la cartilla ir a Movistar Total")
    public void luegoDoyClickEnLaCartillaIrAMovistarTotal() {
        migraTrioaMTcanalCallCenterStep.clickBtnIrMovistarTotal();
    }

    @Y("doy click en Finalizar registro")
    public void doyClickEnFinalizarRegistro() {
        migraTrioaMTcanalCallCenterStep.clickFinalizarRegistro();
    }

}
