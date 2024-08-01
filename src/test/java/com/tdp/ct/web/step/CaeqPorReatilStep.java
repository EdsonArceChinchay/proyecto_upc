package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaeqPorReatilStep {
    @Autowired
    private StepPages page;

    @Autowired
    private ServiceTest serviceTest;

    @ScreenShotBefore
    public void btnAnadirEquipo(int num) {
        page.caeqPorRetailPage().btnAnadirEquipo(num);
    }

    @ScreenShotBefore
    public void btnMantenerPlan() {
        page.caeqPorRetailPage().btnMantenerPlan();
    }

    @ScreenShotBefore
    public void clickBotonCambiarPlan() {
        page.caeqPorRetailPage().clickBotonCambiarPlan();
    }

    public Map<String, String> getSalesLead(String codigoVenta) throws JSONException {
        Map<String, String> movileValues;
        movileValues = serviceTest.getSalesLead(codigoVenta);
        return movileValues;
    }

    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI, Map<String, String> salesLead) {
        page.caeqPorRetailPage().validoQueCAEQCAPLYCASIEnElResponseDelSales(valueCAEQ, valueCAPL, valueCASI, salesLead);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void seleccionoelbotonCambiodeChip() {
        page.caeqPorRetailPage().seleccionoelbotonCambiodeChip();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void cierroPopUpDeClienteExonerado(){
        page.caeqPorRetailPage().cierroPopUpDeClienteExonerado();
    }
}
