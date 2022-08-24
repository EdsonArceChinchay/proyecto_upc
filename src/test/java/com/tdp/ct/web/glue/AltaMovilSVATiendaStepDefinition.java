package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaMovilSVATiendaStep;
import com.tdp.ct.web.step.AltaMovilSoloSimCallCenterStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMovilSVATiendaStepDefinition {

  @Autowired
  private AltaMovilSVATiendaStep altaMovilSVATiendaStep;


    @Y("selecciono el plan_movil Prepago")
    public void seleccionoElPlanPrepago( ) {
        altaMovilSVATiendaStep.seleccionoElPlanPrepago();
    }


}
