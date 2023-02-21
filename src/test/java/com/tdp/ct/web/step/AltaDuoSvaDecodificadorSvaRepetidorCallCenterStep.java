package com.tdp.ct.web.step;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaDuoSvaDecodificadorSvaRepetidorCallCenterStep {

    @Autowired
    private StepPages pages;

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionar_deco(String string){
        UtilWeb.waitForSeconds(3);
        pages.AltaDuoSvaDecodificadorSvaRepetidorCallCenterPage().seleccionardecodificador(string);
    }
}
