package com.tdp.ct.web.step;
import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SvaCallCenterStep {

    @Autowired
    StepPages page;

    @ScreenShotBefore
    @ScreenShotAfter
    public void click_en_ver_detalle(){
        page.svaCallCenterPage().ver_detalle();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void click_en_el_boton_agregar_sva_fija(){
        page.svaCallCenterPage().agregar_sva_fija();
    }

    @ScreenShotBefore
    @ScreenShotAfter
    public void elegir_sva(){
        page.svaCallCenterPage().elegir_sva();
    }
    @ScreenShotAfter
    public void clickSvaMovistarTvApp(String movistarTv) {
        page.svaCallCenterPage().clickSvaMovistarTvApp(movistarTv);
    }
}
