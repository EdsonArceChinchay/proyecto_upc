package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.AltaFijaAltaMovilCallCenterStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.AltaFijaTiendaStep;
import com.tdp.ct.web.step.AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStepDefinition {


  @Autowired
  private AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep;

    @Y("selecciono agregar sva fija")
    public void selecciono_agregar_sva_fija(){
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.scrollUp();
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.selecciono_agregar_sva_fija();
    }


    @Y("seleccionamos guardar cambios")
    public void seleccionamosGuardarCambios() {
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.seleccionamosGuardarCambios();
    }

    @Y("seleccionamos agregar decodificador Smart HD")
    public void seleccionamosAgregarDecodificador() {
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.scrollTo();
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.seleccionamosAgregarDecodificador();
        altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep.scrollToUp();
    }}


