package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaTrioDuoProactivoStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaTrioDuoProactivoStepDefinition {

  @Autowired
  private AltaTrioDuoProactivoStep altaTrioDuoProactivoStep;


    @Y("selecciono el nombre del plan {string}")
    public void seleccionoElNombreDelPlan(String nombrePlan) {
        altaTrioDuoProactivoStep.seleccionoElNombreDelPlan(nombrePlan);
    }

    @Y("doy click en el boton seleccionar la oferta")
    public void doyClickEnElBotonSeleccionarLaOferta() {
        altaTrioDuoProactivoStep.doyClickEnElBotonSeleccionarLaOferta();
    }

    @Y("selecciono en iniciar registro")
    public void seleccionoEnIniciarRegistro() {
        altaTrioDuoProactivoStep.scrollUp();
        altaTrioDuoProactivoStep.seleccionoEnIniciarRegistro();
    }
}






