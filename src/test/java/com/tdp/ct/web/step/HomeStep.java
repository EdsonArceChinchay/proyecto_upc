package com.tdp.ct.web.step;

import com.tdp.ct.web.model.Agent;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;

@Component
public class HomeStep {

    @Autowired
    protected StepPages page;

    @ScreenShotAfter
    public void selectDocumentType(String type) {
        page.homePage().selectDocumentType(type);
    }

    @ScreenShotAfter
    public void typeDocumentNumber(String document) {
        page.homePage().typeDocumentNumber(document);
    }

    @ScreenShotBefore
    public void clickOnConsultButton() {
        page.homePage().clickOnConsultButton();
    }

    @ScreenShotAfter
    public void validateCustomerData(String nombre, String tipoDocumento, String nroDocumento) {
        page.homePage().validateCustomerData(nombre, tipoDocumento, nroDocumento);
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
    public String validateAgentData(String channelType) {
        Map<String, String> storeMap = new HashMap<>();
        storeMap.put("CC", "CC");
        storeMap.put("CALL CENTER", "CC");
        storeMap.put("ST", "ST");
        storeMap.put("TIENDA", "ST");
        storeMap.put("DLC", "DLC");
        storeMap.put("RETAIL", "DLC");
        String store = storeMap.getOrDefault(channelType.trim().toUpperCase(), null);
        return page.homePage().validateAgentData(store);
    }

    @ScreenShotAfter
    public void validateHomeMessage(String msg) {
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
    public void confirmoCerrarSesion() {
        page.homePage().clickOnTheLogoutButton();
    }

    public String getAgentName()
    {
        return page.homePage().getAgentName().trim();
    }

    public String getAgentLastName()
    {
        return page.homePage().getAgentLastName();
    }
    public String getChannelName()
    {
        return page.homePage().getChannelName();
    }
    public String getChannelType()
    {
        return page.homePage().getChannelType();
    }

    public String getDocumentNumber()
    {
        return page.homePage().getDocumentNumber();
    }

    public String getDocumentType()
    {
        return page.homePage().getDocumentType();
    }

    public boolean isRetention(){
       return page.homePage().isRetention();
    }

    public void initializeAgent(Agent agent) {
        agent.setFirstName(getAgentName());
        agent.setLastName(getAgentLastName());
        agent.setChannelName(getChannelName());
        agent.setChannelType(getChannelType());
        agent.setDocumentNumber(getDocumentNumber());
        agent.setDocumentType(getDocumentType());
        agent.setRetention(isRetention());
    }

}
