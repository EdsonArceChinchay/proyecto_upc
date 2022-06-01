package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaAltaMovilRetailStep;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class AltaFijaAltaMovilRetailStepDefinition {

  @Autowired
  private AltaFijaAltaMovilRetailStep altaFijaAltaMovilRetailStep;
  @Autowired
  private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("selecciono el boton Linea Nueva Hogar")
    public void seleccionoElBotonLineaNuevaHogar() {
        altaFijaAltaMovilRetailStep.btnHogar();
    }

    @Y("selecciono el boton Linea Nueva Movil")
    public void seleccionoElBotonLineaNuevaMovil() {
        altaFijaAltaMovilRetailStep.btnMovil();
    }

    @Y("selecciono el boton Mostrar ofertas")
    public void seleccionoElBotonMostrarOfertas() {
      altaFijaAltaMovilRetailStep.btnMostrar();
    }

  @Y("selecciono el departamento donde sera la instalacion {string}")
  public void seleccionoElDepartamentoDondeSeraLaInstalacion(String dep) {
      altaFijaAltaMovilRetailStep.seleccionarTipoDepa(dep);
  }

  @Y("ingreso la direccion donde sera la instalacion {string}")
    public void ingresoLaDireccionDondeSeraLaInstalacion(String data) {
      altaFijaAltaMovilRetailStep.writeDirec(data);
    }

  @Y("selecciono la provincia donde sera la instalacion {string}")
  public void seleccionoLaProvinciaDondeSeraLaInstalacion(String provincia) {
      altaFijaAltaMovilRetailStep.seleccionarTipoProv(provincia);
  }

  @Y("ingreso la referencia de la direccion {string}")
  public void ingresoLaReferenciaDeLaDireccion(String referencia) {
      altaFijaAltaMovilRetailStep.writeReferencia(referencia);
  }

  @Y("selecciono el distrito donde sera la instalacion {string}")
  public void seleccionoElDistritoDondeSeraLaInstalacion(String distri) {
    altaFijaAltaMovilRetailStep.seleccionarTipoDistrito(distri);
  }

  @Y("presiono el boton Consultar ubicacion")
  public void presionoElBotonConsultarUbicacion() {
    altaFijaAltaMovilRetailStep.btnConsulta();
  }

  @Y("ingresamos la Manzana o bloque {string}")
  public void ingresamosLaManzanaOBloque(String manzana) {
    altaFijaAltaMovilRetailStep.writeMz(manzana);
  }

  @Y("ingresamos el Lote {string}")
  public void ingresamosElLote(String lote) {
      altaFijaAltaMovilRetailStep.writeLte(lote);
  }

  @Y("ingresamos el Piso {string}")
  public void ingresamosElPiso(String piso) {
      altaFijaAltaMovilRetailStep.writePiso(piso);
  }

  @Y("ingresamos el interior {string}")
  public void ingresamosElInterior(String interior) {
      altaFijaAltaMovilRetailStep.writeInt(interior);
  }

  @Y("ingresamos el Tipo de conjunto habitacional {string}")
  public void ingresamosElTipoDeConjuntoHabitacional(String habitacion) {
      altaFijaAltaMovilRetailStep.seleccionarConjunto(habitacion);
  }

  @Y("ingresamos el Nombre del conjunto habitacional {string}")
  public void ingresamosElNombreDelConjuntoHabitacional(String conj) {
      altaFijaAltaMovilRetailStep.writeConjHab(conj);
  }

  @Y("presionamos el boton Consultar Cobertura")
  public void presionamosElBotonConsultarCobertura() {
      altaFijaMovilRegistroStep.moverseFinalDocumento();
      altaFijaAltaMovilRetailStep.btnCobertura();
  }

    @Y("completo el correo {string}")
    public void completoElCorreo(String correo) {
      altaFijaAltaMovilRetailStep.tipearCorreo(correo);
    }
}
