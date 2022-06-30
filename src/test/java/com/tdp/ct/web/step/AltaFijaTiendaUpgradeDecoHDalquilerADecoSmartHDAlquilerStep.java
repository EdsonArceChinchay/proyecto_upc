package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerStep {

    @Autowired
    private StepPages page;



    public void selecciono_agregar_sva_fija() {
        page.altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage().selecciono_agregar_sva_fija();

    }

    public void scrollUp() {
        page.altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage().scrollUp();

    }

    public void seleccionamosGuardarCambios() {
        page.altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage().seleccionamosGuardarCambios();
    }
}
