package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaTrioConBloqueHdUpfrontCallCenterStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaTrioConBloqueHdUpfrontCallCenterStepDefinition {

  @Autowired
  private AltaTrioConBloqueHdUpfrontCallCenterStep altaTrioConBloqueHdUpfrontCallCenterStep;

  @Cuando("valido si el usuario aplica para upfront")
  public void valido_si_el_usuario_aplica_para_upfront() {
    altaTrioConBloqueHdUpfrontCallCenterStep.clickSubDetalles();
    altaTrioConBloqueHdUpfrontCallCenterStep.validarlblAplicaUpFrom();
  }

  @Y("ingreso el call id {string}")
  public void ingreso_el_call_id(String data){
    altaTrioConBloqueHdUpfrontCallCenterStep.ingresarCallID(data);
  }

}
