package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void seleccionoTipoDocumento(String tipoDocumento){
        page.homePage().seleccionoTipoDocumento(tipoDocumento);
    }

    @ScreenShotAfter
    public void ingresoDocumento(String documento){
        page.homePage().ingresoDocumento(documento);
    }
    @ScreenShotBefore
    public void clickBotonConsultar(){
        page.homePage().clickBotonConsultar();
    }
}
