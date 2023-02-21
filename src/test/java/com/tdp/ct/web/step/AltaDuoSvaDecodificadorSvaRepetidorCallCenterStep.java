package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaDuoSvaDecodificadorSvaRepetidorCallCenterStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void seleccionardecodificador(String string){
        System.out.println("segundo paso");
        UtilWeb.waitForSeconds(3);
        page.AltaDuoSvaDecodificadorSvaRepetidorCallCenterPage().seleccionardecodificador(string);

    }
}
