package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMonoInternetSvaRepetidorSvaInternetCallCenterStep {

    @Autowired
    private StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void agregarsva (){
        page.AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage().agregarsva();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void agregarsvainternet (String string){
        page.AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage().agregarsvainternet(string);
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void elegimossvarepetidor (String string){
        page.AltaMonoInternetSvaRepetidorSvaInternetCallCenterPage().elegimossvarepetidor(string);
    }

}
