package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BandejaBackOfficeStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void typeDocument(String document) {
        page.bandejaBackOfficePage().typeDocument(document);
        page.bandejaBackOfficePage().clickButtonSearch();
    }

    @ScreenShotAfter
    public void selectRequest(String numberRequest) {
        page.bandejaBackOfficePage().selectRequest(numberRequest);
    }

    @ScreenShotAfter
    public void openPopUpUploadAudio() {
        page.bandejaBackOfficePage().openPopUpUploadAudio();
    }

    @ScreenShotAfter
    public void uploadAudio() {
        page.bandejaBackOfficePage().uploadAudio();
    }

    @ScreenShotAfter
    public void approveRequest() {
        page.bandejaBackOfficePage().approveRequest();
    }

}
