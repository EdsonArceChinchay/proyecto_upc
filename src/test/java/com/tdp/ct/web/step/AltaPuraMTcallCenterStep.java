package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaPuraMTcallCenterStep {

    @Autowired
    private StepPages page;

    public void clickConfirmoUbicacion(){
        UtilWeb.waitForSeconds(3);
        page.altaPuraMTcallCenterPage().btnConfirmarUbicacion();
    }

    public void selectTipoHorario(){
        UtilWeb.waitForSeconds(3);
        page.altaPuraMTcallCenterPage().selectTipoHorario();
    }

    public void completarIdCall(String idCall){
        page.altaPuraMTcallCenterPage().completarIdCall(idCall);
    }
}
