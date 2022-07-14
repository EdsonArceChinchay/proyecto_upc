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
}
