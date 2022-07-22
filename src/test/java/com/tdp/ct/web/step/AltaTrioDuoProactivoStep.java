package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.util.UtilWeb;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaTrioDuoProactivoStep {

    @Autowired
    private StepPages page;

    public void seleccionoElNombreDelPlan(String nombrePlan) {
            page.altaTrioDuoProactivoPage().seleccionoElNombreDelPlan(nombrePlan);
        }

    public void doyClickEnElBotonSeleccionarLaOferta() {
        page.altaTrioDuoProactivoPage().doyClickEnElBotonSeleccionarLaOferta();
    }

    public void seleccionoEnIniciarRegistro() {
        page.altaTrioDuoProactivoPage().seleccionoEnIniciarRegistro();
    }

    public void scrollUp() {
        page.altaTrioDuoProactivoPage().scrollUp();
    }
}


