package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import java.util.logging.Level;

@SpringBootTest(classes = WebAutomationApplication.class)
public class BandejaBackOfficeStepDefinition {

    @Autowired
    private WebDriverManager manager;

    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;

    @Autowired
    private Customer customer;

    private boolean isRetention;

    @PostConstruct
    public void init() {
        this.isRetention = bandejaBackOfficeStep.isRetention();
    }

    private void executeIfNotRetention(Runnable action) {
        if (!isRetention) {
            action.run();
        }
    }

    @Y("busco por el documento {string}")
    public void buscoPorElDocumento(String documento) {
        executeIfNotRetention(() -> bandejaBackOfficeStep.typeDocument(documento));
    }

    @Y("busco por el documento")
    public void buscoPorElDocumento() {
        executeIfNotRetention(() -> bandejaBackOfficeStep.typeDocument(Customer.getNumberDocument()));
    }

    @Y("busco por {string}")
    public void buscoPorElTipoDocumento(String tipoDoc) {
        executeIfNotRetention(() -> {
            String typeDocument = (bandejaBackOfficeStep.isNumber(tipoDoc) || tipoDoc.contains("documento")) ? "documento" : "solicitud";
            String numberDocument = typeDocument.equals("documento") ? (bandejaBackOfficeStep.isNumber(tipoDoc) ? tipoDoc : Customer.getNumberDocument()) : customer.getSalesCode();
            logSearch(typeDocument);
            bandejaBackOfficeStep.typeDocument(numberDocument);
        });
    }

    private void logSearch(String typeDocument) {
        String message = typeDocument.equals("documento") ? "Search by document number" : "Search by request number";
        UtilWeb.logger(this.getClass()).log(Level.INFO, message);
    }

    @Y("cargo el audio en la web")
    public void cargoElAudioEnLaWeb() {
        executeIfNotRetention(() -> {
            bandejaBackOfficeStep.openPopUpUploadAudio();
            bandejaBackOfficeStep.uploadAudio();
        });
    }

    @Y("selecciono la solicitud")
    public void selectRequest() {
        executeIfNotRetention(() -> {
            String salesCode = (this.customer.getSalesCode() == null) ? "FE-" : this.customer.getSalesCode();
            System.out.println("numberRequest: " + salesCode);
            bandejaBackOfficeStep.selectRequest(salesCode);
        });
    }

    @Y("apruebo la solicitud")
    public void aprueboSolicitud() {
        executeIfNotRetention(bandejaBackOfficeStep::approveRequest);
    }
}