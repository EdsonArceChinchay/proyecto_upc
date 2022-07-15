package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaMovilSoloSimCallCenterStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaDuoTrioCallCenterStepDefinition {

  @Autowired
  private AltaMovilSoloSimCallCenterStep altaMovilSoloSimCallCenterStep;

  @Autowired
  private AltaFijaTiendaStep altaFijaTiendaStep;

  @Y("presiono el boton Mostrar ofertas")
  public void presiono_el_boton_Mostrar_ofertas(){
    altaMovilSoloSimCallCenterStep.clickBotonMostrarOfertasRapido();
  }


}
