package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaMovilComboProactivoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaMovilComboProactivoStepDefinition {

  @Autowired
  private AltaMovilComboProactivoStep altaMovilComboProactivoStep;
  @Autowired
  private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

  @Y("selecciono completar los datos del cliente")
  public void  selecciono_completar_los_datos_del_cliente(DataTable datosCliente) {
     altaMovilComboProactivoStep.completoDatosCliente(datosCliente);
    // altaMovilComboProactivoStep.clicConfirmarCliente();
    //  altaFijaMovilRegistroStep.datosClienteValidado();
     // altaMovilComboProactivoStep.clicConsultar();

  }


    @Y("selecciono el boton agregar sva")
    public void seleccionoElBotonAgregarSva() {
        altaMovilComboProactivoStep.seleccionoElBotonAgregarSva();


    }
}
