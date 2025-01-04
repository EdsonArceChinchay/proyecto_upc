package com.tdp.ct.web.step;

import com.tdp.ct.web.builder.AgentBuilder;
import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HomeStep {

    @Autowired
    protected StepPages page;

    @Autowired
    protected AgentBuilder agentBuilder;

    @ScreenShotAfter
    public void selectDocumentType(String type) {
        page.homePage().selectDocumentType(type);
    }

    @ScreenShotAfter
    public void typeDocumentNumber(String documentNumber) {
        page.homePage().typeDocumentNumber(documentNumber);
    }

    @ScreenShotBefore
    public void clickOnConsultButton() {
        page.homePage().clickOnConsultButton();
    }

    @ScreenShotAfter
    public void validateCustomerData(String nombre, String documentType, String nroDocumento) {
        page.homePage().validateCustomerData(nombre, documentType, nroDocumento);
    }

    @ScreenShotBefore
    public void selectCustomerId(String nro) {
        page.homePage().selectCustomerId(nro);
    }

    @ScreenShotBefore
    public void clickOnSaveButton() {
        page.homePage().clickOnSaveButton();
    }

    @ScreenShotAfter
    public void validoQueMeTraigaLosServiciosContratadosPorElCliente() {
        page.homePage().validoQueMeTraigaLosServiciosContratadosPorElCliente();
    }

    @ScreenShotAfter
    public void selectTheTypeOfDocumentOfTheLegalRepresentative(String documentType) {
        page.homePage().selectTheTypeOfDocumentOfTheLegalRepresentative(documentType);
    }

    @ScreenShotAfter
    public void typeTheDocumentNumberOfTheLegalRepresentative(String numDoc) {
        page.homePage().typeTheDocumentNumberOfTheLegalRepresentative(numDoc);
    }

    @ScreenShotAfter
    public void clickOnTheValidateLegalRepresentativeButton() {
        page.homePage().clickOnTheValidateLegalRepresentativeButton();
    }

    public void clickXPopUpCU() {
        page.homePage().clickXPopUpCU();
    }

    @ScreenShotAfter
    public void clickOnTheBackOfficeButton() {
        page.homePage().clickOnTheBackOfficeButton();
    }

    @ScreenShotAfter
    public void validateAgentData(Agent agent, String channelType) {
        Map<String, String> storeMap = new HashMap<>();
        storeMap.put("CC", "CC");
        storeMap.put("CALL CENTER", "CC");
        storeMap.put("ST", "ST");
        storeMap.put("TIENDA", "ST");
        storeMap.put("DLC", "DLC");
        storeMap.put("RETAIL", "DLC");
        String store = storeMap.getOrDefault(channelType.trim().toUpperCase(), null);
        page.homePage().validateAgentData(agent, store);
    }

    @ScreenShotAfter
    public void validateHomeMessage(String msg) {
        page.homePage().Zoom(65);
        page.homePage().validateHomeMessage(msg);
    }

    public void backToHomePage() {
        page.homePage().backToHomePage();
    }

    @ScreenShotAfter
    public void clickOnTheAdvisorIcon() {
        page.homePage().clickOnTheAdvisorIcon();
    }

    @ScreenShotAfter
    public void clickOnTheLogoutButton() {
        page.homePage().clickOnTheLogoutButton();
    }

    @ScreenShotAfter
    public void ClickOnBackButton() {
        page.homePage().ClickOnBackButton();
    }

    @ScreenShotAfter
    @ScreenShotBefore
    public void confirmSignOut() {
        page.homePage().clickOnTheLogoutButton();
    }

    public boolean isRetention() {
        return AgentBuilder.isRetention();
    }

    public void initializeAgent(Agent agent) {
        AgentBuilder.initializeAgent(agent);
        agentBuilder.modifyGroupAgent("B2C_FRONTEND_WEB_RETENCIONES", agent);
        agent.setRetention(AgentBuilder.isRetention());
    }

    public String getChannelType() {
        return page.homePage().getChannelType();
    }

}