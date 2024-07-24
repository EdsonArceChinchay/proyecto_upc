package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaTrioConBloqueHdUpfrontCallCenterStep {

    @Autowired
    private StepPages page;

    public void clickSubDetalles(){
       page.altaTrioConBloqueHdUpfrontCallCenterPage().subDetalles();
    }

    public void validarlblAplicaUpFrom(){
        page.altaTrioConBloqueHdUpfrontCallCenterPage().lblAplicaUpFrom();
    }

    public void ingresarCallID(String data){
        page.altaTrioConBloqueHdUpfrontCallCenterPage().callID(data);
    }
}
