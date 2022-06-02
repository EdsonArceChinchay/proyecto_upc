package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaTrioConBloqueHdUpfrontCallCenterStepDefinition {

  @Autowired
  private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;
  @Autowired
  private AltaFijaAltaMovilCallCenterStep altaFijaAltaMovilCallCenterStep;
  @Autowired
  private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

  @Cuando("cierro el popup de error")
  public void cierro_el_popup_de_error() {

  }

}
