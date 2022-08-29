package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaMovilSVATiendaStep {

    @Autowired
    private StepPages page;


    public void seleccionoElPlanPrepago( ){
        page.altaMovilSVATiendaPage().seleccionoElPlanPrepago();
    }
    }


