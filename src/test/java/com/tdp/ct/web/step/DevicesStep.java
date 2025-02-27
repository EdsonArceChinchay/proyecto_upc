package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DevicesStep {

    @Autowired
    private StepPages page;

    @Autowired
    private ManageScenario scenario;

    @ScreenShotAfter
    public void selectTimeOfPermanency(String timePermanency) {
        page.devicesPage().selectTimeOfPermanency(timePermanency);
    }

    @ScreenShotAfter
    public void selectTypeOfPayment(String typePayment) {
        page.devicesPage().selectTypeOfPayment(typePayment);
    }

    @ScreenShotAfter
    public void typeDeviceAndSearch(String device) {
        page.devicesPage().typeDeviceAndSearch(device);
    }

    @ScreenShotBefore
    public void clickButtonSelect() {
        page.devicesPage().clickButtonSelect();
    }

    @ScreenShotAfter
    public int quantityOfDevicesOfTheSearchResult() {
        return page.devicesPage().quantityOfDevicesOfTheSearchResult();
    }

    public void scrollToButtonSeeDetail() {
        page.devicesPage().scrollToButtonSeeDetail();
    }

    @ScreenShotBefore
    public void clickButtonSeeDetail() {
        page.devicesPage().clickButtonSeeDetail();
    }

    public void validateFeatures() {
        page.devicesPage().validateFeatures();
    }

    @ScreenShotBefore
    public void clickButtonSelectDevice() {
        page.devicesPage().clickButtonSelectDevice();
    }

    public void scrollToOfertDetails() {
        page.devicesPage().scrollToOfertDetails(scenario);
    }

    public void scrollToDeviceList() {
        page.devicesPage().scrollToDeviceList();
    }

    @ScreenShotBefore
    public void clickBtnSeeDeviceDetails(String equipo) {
        page.devicesPage().clickBtnSeeDeviceDetails(equipo);
    }

    /**
     * FUNCION VALIDAR STOCK EQUIPO
     * */

    public void validarStockDeEquipo(){
        page.devicesPage().clickBtnSeeDeviceDetails();
    }
}
