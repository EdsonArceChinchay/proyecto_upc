package com.tdp.ct.web.step.Paquetizacion;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaMovilSoloLineaRetailCeStep {
    @Autowired
    private StepPages stepPages;
    public void buscarOfertaRetail() {

     stepPages.altaMovilSoloLineaRetailPage().buscarOfertaRetail();
    }


}
