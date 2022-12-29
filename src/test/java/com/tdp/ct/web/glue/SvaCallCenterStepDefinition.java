package com.tdp.ct.web.glue;
import com.tdp.ct.web.WebAutomationApplication;
import com.tdp.ct.web.step.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = WebAutomationApplication.class)
public class SvaCallCenterStepDefinition {

    @Autowired
    SvaCallCenterStep svaCallCenterStep;

    @Cuando("doy click en ver detalle")
    public void doy_click_en_ver_detalle() {
        svaCallCenterStep.click_en_ver_detalle();
    }

    @Cuando("doy click en el boton Agregar sva fija")
    public void doy_click_en_el_boton_agregar_sva_fija() {
        svaCallCenterStep.click_en_el_boton_agregar_sva_fija();
    }

    @Cuando("elegimos sva")
    public void elegimos_sva() {
        svaCallCenterStep.elegir_sva();
    }

}
