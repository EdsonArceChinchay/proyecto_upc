package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Cliente;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class BandejaBackOfficeStepDefinition {
    @Autowired
    private WebDriverManager manager;
    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;
    @Autowired
    private Cliente cliente;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("me dirijo a la bandeja de Back Office")
    public void meDirijoALaBandejaDeBackOffice() {
        bandejaBackOfficeStep.clickBackOffice();
    }
    @Y("busco por el documento {string}")
    public void buscoPorElDocumento(String documento) {
        bandejaBackOfficeStep.ingresoDocumento(documento);
    }
    @Y("busco por el documento")
    public void buscoPorElDocumento() {
        bandejaBackOfficeStep.ingresoDocumento(cliente.getNumeroDocumento());
    }

//    TODO: Buscar por tipo
    @Y("busco por {string}")
    public void buscoPorElTipoDocumento(String tipoDoc) throws JSONException {
        switch (tipoDoc){
            case "documento":
                bandejaBackOfficeStep.ingresoDocumento(cliente.getNumeroDocumento());
                break;
            case "solicitud":
                bandejaBackOfficeStep.ingresoDocumento( altaFijaMovilRegistroStep.getCodigoVenta());
                break;
        }
    }

    @Y("cargo el audio en la web")
    public void cargoElAudioEnLaWeb() {
        bandejaBackOfficeStep.abrirPopUpCargaAudio();
        bandejaBackOfficeStep.cargarAudio();
    }

    @Y("selecciono la solicitud")
    public void seleccionoLaSolicitud() {
        String codigoVenta = (this.cliente.getNumeroSolicitud()== null) ?"FE-":this.cliente.getNumeroSolicitud();
        System.out.println("NumSolicitud: " + codigoVenta);
        bandejaBackOfficeStep.seleccionoSolicitud(codigoVenta);
    }
    @Y("apruebo la solicitud")
    public void aprueboSolicitud() throws InterruptedException {
        bandejaBackOfficeStep.aprueboSolicitud();
    }

    @Y("busco por el codigo de expediente")
    public void buscoPorElCodigoDeExpediente() {

    }
}
