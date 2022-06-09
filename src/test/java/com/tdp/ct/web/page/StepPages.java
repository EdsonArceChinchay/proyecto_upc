package com.tdp.ct.web.page;

import com.tdp.ct.web.step.AltaFijaRetailStep;
import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public LoginBerserkerPage loginBerserkerPage(){ return new LoginBerserkerPage(); }
    public HomePage homePage(){ return new HomePage();}
    public AltaTrioMTconUpfrontTiendaPage altaTrioMTconUpfrontTiendaPage(){ return new AltaTrioMTconUpfrontTiendaPage();}
    public AltaFijaAltaMovilRetailPage altaFijaAltaMovilRetailPage(){ return new AltaFijaAltaMovilRetailPage();}
    public AltaFijaMovilRegistroPage altaFijaMovilRegistroPage(){ return new AltaFijaMovilRegistroPage();}
    public AltaFijaAltaMovilCallCenterPage altaFijaAltaMovilCallCenterPage(){ return new AltaFijaAltaMovilCallCenterPage();}
    public AltaFijaTiendaPage altaFijaTiendaPage(){return new AltaFijaTiendaPage();}
    public AltaPuraMTcallCenterPage altaPuraMTcallCenterPage(){return  new AltaPuraMTcallCenterPage();}
    public AltaMonoInstalacionHfcTiendaPage altaMonoHfcTiendaPage(){ return new AltaMonoInstalacionHfcTiendaPage(); }
    public AltaMovilPrepagoSoloChipTiendaPage altaMovilPrepagoSoloChipTiendaPage(){ return new AltaMovilPrepagoSoloChipTiendaPage();}
    public AltaFijaRetailPage altaFijaRetailPage(){ return new AltaFijaRetailPage(); }
}
