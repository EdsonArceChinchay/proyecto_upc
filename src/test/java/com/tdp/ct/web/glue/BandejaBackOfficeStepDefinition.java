package com.tdp.ct.web.glue;

import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.lib.WebDriverManager;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.RetentionService;
import com.tdp.ct.web.step.BandejaBackOfficeStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.isNumber;

@SpringBootTest(classes = WebAutomationApplication.class)
public class BandejaBackOfficeStepDefinition {

    @Autowired
    private WebDriverManager manager;

    @Autowired
    private BandejaBackOfficeStep bandejaBackOfficeStep;

    @Autowired
    private Customer customer;

    @Autowired
    private RetentionService retentionService;

    private Scenario scenario;

    @Before(order = 0)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    private void executeIfNotRetention(Runnable action) {
        if (retentionService.isRetention()) {
            scenario.log("This step is skipped - Is retention");
            return;
        }
        action.run();
    }

    @Y("busco por el documento {string}")
    public void buscoPorElDocumento(String documento) {
        executeIfNotRetention(() -> bandejaBackOfficeStep.typeDocument(documento));
    }

    @Y("busco por el documento")
    public void buscoPorElDocumento() {
        executeIfNotRetention(() -> bandejaBackOfficeStep.typeDocument(customer.getDocumentNumber()));
    }

    @Y("busco por {string}")
    public void buscoPorElTipoDocumento(String tipoDoc) {
       /* executeIfNotRetention(() -> {
            String typeDocument = (isNumber(tipoDoc) || tipoDoc.contains("documento")) ? "documento" : "solicitud";
            String numberDocument = typeDocument.equals("documento")
                    ? (isNumber(tipoDoc) ? tipoDoc : customer.getDocumentNumber())
                    : customer.getSalesCode();
            logSearch(typeDocument);
            bandejaBackOfficeStep.typeDocument(numberDocument);
        });*/

        switch (tipoDoc){
            case "documento":
                bandejaBackOfficeStep.typeDocument((String) getScenarioContext().get("nroDocumento"));
                break;
            case "solicitud":
               // bandejaBackOfficeStep.typeDocument(cliente.getNumeroSolicitud());
                break;
        }


    }

    private void logSearch(String typeDocument) {
        String message = typeDocument.equals("documento") ? "Search by document number" : "Search by request number";
        logInfo(message);
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
            String salesCode = (customer.getSalesCode() == null) ? "FE-" : customer.getSalesCode();
            logInfo("numberRequest: " + salesCode);
            getScenarioContext().put("numeroSolicitud", salesCode);
            bandejaBackOfficeStep.selectRequest(salesCode);
        });
    }

    @Y("apruebo la solicitud")
    public void aprueboSolicitud() {
        executeIfNotRetention(bandejaBackOfficeStep::approveRequest);
    }
}
