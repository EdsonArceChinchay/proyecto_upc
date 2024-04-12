package com.tdp.ct.web.step.Caeq;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.step.Portabilidad.ServiceTest;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaeqMasCaplMasCasiStep {
    @Autowired
    StepPages page;


    @Autowired
    private ServiceTest serviceTest;

    @ScreenShotBefore
    public void clickBotonCambiarPlan() {
        page.caeqMasCaplMasCasiPage().clickBotonCambiarPlan();
    }

    public Map<String,String> getSalesLead(String codigoVenta) throws JSONException {
        Map<String,String> valuesMovil;
        valuesMovil = serviceTest.getSalesLead(codigoVenta);
        return valuesMovil;
    }


    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI, Map<String, String> salesLead)  {
        page.caeqMasCaplMasCasiPage().validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ,valueCAPL,valueCASI,salesLead);
    }
}
