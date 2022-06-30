package com.tdp.ct.web.page;

import com.tdp.ct.web.step.AltaFijaRetailStep;
import org.springframework.stereotype.Component;

@Component
public class StepPages{

    public LoginBerserkerPage loginBerserkerPage(){ return new LoginBerserkerPage(); }
    public HomePage homePage(){ return new HomePage();}
    public AltaTrioMTconUpfrontTiendaPage altaTrioMTconUpfrontTiendaPage(){ return new AltaTrioMTconUpfrontTiendaPage();}
    public AltaFijaAltaMovilRetailPage altaFijaAltaMovilRetailPage(){ return new AltaFijaAltaMovilRetailPage();}
    public AltaFijaMovilRegistroPage altaFijaMovilRegistroPage(){ return new AltaFijaMovilRegistroPage();}
    public AltaFijaAltaMovilCallCenterPage altaFijaAltaMovilCallCenterPage(){ return new AltaFijaAltaMovilCallCenterPage();}
    public AltaMovilPostpagoCallCenterPage altaMovilPostpagoCallCenterPage(){ return new AltaMovilPostpagoCallCenterPage();}
    public AltaMovilComboProactivoPage altaMovilComboProactivoPage(){ return new AltaMovilComboProactivoPage();}
    public AltaFijaTiendaPage altaFijaTiendaPage(){return new AltaFijaTiendaPage();}
    public AltaPuraMTcallCenterPage altaPuraMTcallCenterPage(){return  new AltaPuraMTcallCenterPage();}
    public AltaMovilPrepagoSoloChipTiendaPage altaMovilPrepagoSoloChipTiendaPage(){ return new AltaMovilPrepagoSoloChipTiendaPage();}
    public AltaFijaRetailPage altaFijaRetailPage(){ return new AltaFijaRetailPage(); }
    public AltaMonoInstalacionFtthTiendaPage altaMonoFtthTiendaPage(){ return new AltaMonoInstalacionFtthTiendaPage(); }
    public AltaTrioConBloqueHdUpfrontCallCenterPage altaTrioConBloqueHdUpfrontCallCenterPage(){return new AltaTrioConBloqueHdUpfrontCallCenterPage();}
    public AltaMovilSoloSimCallCenterPage altaMovilSoloSimCallCenterPage(){return new AltaMovilSoloSimCallCenterPage();}

}
