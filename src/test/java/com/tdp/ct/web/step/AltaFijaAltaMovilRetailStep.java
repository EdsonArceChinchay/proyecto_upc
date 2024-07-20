package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaFijaAltaMovilRetailStep {

    @Autowired
    private StepPages page;

    public void tipearCorreo(String correo){
        page.altaFijaAltaMovilRetailPage().tipearCorreo(correo);
    }


}
