package com.tdp.ct.web.step.Caeq;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaeqPorReatilStep {
    @Autowired
    private StepPages page;
    @ScreenShotBefore
    public void btnAnadirEquipo(int num) {
        page.caeqPorRetailPage().btnAnadirEquipo(num);
    }
    @ScreenShotBefore
    public void btnSeleccionar() {
        page.caeqPorRetailPage().btnSeleecionar();
    }
    @ScreenShotBefore
    public void btnMantenerPlan() {
        page.caeqPorRetailPage().btnMantenerPlan();
    }
    @ScreenShotBefore
    public void btnConsultarClienteNuevo() {page.caeqPorRetailPage().btnConsultarClienteNuevo();
    }
}
