package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.AltaFijaMovilRegistroStep;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Level;

@SpringBootTest(classes = WebAutomationApplication.class)
public class BandejaBackOfficeStepDefinition {
    @Autowired
    private WebDriverManager manager;
    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;
    @Autowired
    private Customer customer;

    @Autowired
    private AltaFijaMovilRegistroStep altaFijaMovilRegistroStep;

    @Y("me dirijo a la bandeja de Back Office")
    public void meDirijoALaBandejaDeBackOffice() {
        bandejaBackOfficeStep.clickBackOffice();
    }

    @Y("busco por el documento {string}")
    public void buscoPorElDocumento(String documento) {
        bandejaBackOfficeStep.typeDocument(documento);
    }

    @Y("busco por el documento")
    public void buscoPorElDocumento() {
        bandejaBackOfficeStep.typeDocument(customer.getNumberDocument());
    }

    //    TODO: Buscar por tipo
    @Y("busco por {string}")
    public void buscoPorElTipoDocumento(String tipoDoc) {
        String typeDocument = (bandejaBackOfficeStep.isNumber(tipoDoc) || tipoDoc.contains("documento")) ? "documento" : "solicitud";

        switch (typeDocument) {
            case "documento":
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Search by document number");
                String numberCocument = (bandejaBackOfficeStep.isNumber(tipoDoc)) ? tipoDoc : customer.getNumberDocument();
                bandejaBackOfficeStep.typeDocument(numberCocument);
                break;
            case "solicitud":
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Search by request number");
                bandejaBackOfficeStep.typeDocument(customer.getSalesCode());
                break;
        }
    }

    @Y("cargo el audio en la web")
    public void cargoElAudioEnLaWeb() {
        bandejaBackOfficeStep.openPopUpUploadAudio();
        bandejaBackOfficeStep.uploadAudio();
    }

    @Y("selecciono la solicitud")
    public void selectRequest() {
        String salesCode = (this.customer.getSalesCode() == null) ? "FE-" : this.customer.getSalesCode();
        System.out.println("numberRequest: " + salesCode);
        bandejaBackOfficeStep.selectRequest(salesCode);
    }

    @Y("apruebo la solicitud")
    public void aprueboSolicitud() {
        bandejaBackOfficeStep.approveRequest();
    }

    @Y("busco por el codigo de expediente")
    public void buscoPorElCodigoDeExpediente() {

    }
}
