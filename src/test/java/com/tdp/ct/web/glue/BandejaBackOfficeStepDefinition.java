package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebAutomationApplication.class)
public class BandejaBackOfficeStepDefinition {
    @Autowired
    private WebDriverManager manager;
    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;

    @Y("me dirijo a la bandeja de Back Office")
    public void meDirijoALaBandejaDeBackOffice() {
        bandejaBackOfficeStep.clickBackOffice();
    }
    @Y("busco por el documento {string}")
    public void buscoPorElDocumento(String documento) {
        bandejaBackOfficeStep.ingresoDocumento(documento);
    }

    @Y("cargo el audio en la web")
    public void cargoElAudioEnLaWeb() {
        bandejaBackOfficeStep.abrirPopUpCargaAudio();
        bandejaBackOfficeStep.cargarAudio();
    }

    @Y("selecciono la solicitud {string}")
    public void seleccionoLaSolicitud(String solicitud) {
        bandejaBackOfficeStep.seleccionoSolicitud(solicitud);
    }
}
