package com.tdp.ct.web.page;

import com.tdp.ct.web.page.MovilFinanciado.AltaMovilControlFinancimientoPage;
import com.tdp.ct.web.page.Paquetizacion.PaquetizacionDuoMasMonoPorCallCenterPage;
import com.tdp.ct.web.page.migracion.MigraTrioaMTcanalCallCenterPage;
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
    public AltaFijaRetailPage altaFijaRetailPage(){return new AltaFijaRetailPage();}
    public AltaFijaTiendaPage altaFijaTiendaPage(){return new AltaFijaTiendaPage();}
    public AltaPuraMTcallCenterPage altaPuraMTcallCenterPage(){return  new AltaPuraMTcallCenterPage();}
    public AltaMonoInstalacionFtthTiendaPage altaMonoFtthTiendaPage(){ return new AltaMonoInstalacionFtthTiendaPage(); }
    public AltaTrioConBloqueHdUpfrontCallCenterPage altaTrioConBloqueHdUpfrontCallCenterPage(){return new AltaTrioConBloqueHdUpfrontCallCenterPage();}
    public AltaMovilSoloSimCallCenterPage altaMovilSoloSimCallCenterPage(){return new AltaMovilSoloSimCallCenterPage();}
    public MigracionDuoATrioTiendaPage migracionDuoATrioTiendaPage(){return new MigracionDuoATrioTiendaPage();}
    public AltaTrioDuoProactivoPage altaTrioDuoProactivoPage(){return new AltaTrioDuoProactivoPage();}
    public CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage caplConCaeqAlContadoCanalTiendaPage(){ return new CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage(); }
    public AltaMovilPrepagoSoloChipTiendaPage altaMovilPrepagoSoloChipTiendaPage(){ return new AltaMovilPrepagoSoloChipTiendaPage(); }
    public AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage altaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage(){return new AltaFijaTiendaUpgradeDecoHDalquilerADecoSmartHDAlquilerPage();}
    public MigraTrioaMTcanalCallCenterPage migraTrioaMTcanalCallCenterPage(){return new MigraTrioaMTcanalCallCenterPage();}
    public AltaMovilControlFinancimientoPage altaMovilControlFinancimientoPage(){return new AltaMovilControlFinancimientoPage();}
    public AltaMovilSVATiendaPage altaMovilSVATiendaPage(){return new AltaMovilSVATiendaPage();}
    public PaquetizacionDuoMasMonoPorCallCenterPage paquetizacionDuoMasMonoPorCallCenterPage() {return new PaquetizacionDuoMasMonoPorCallCenterPage();}
    public MigracionMonoADuoSVATiendaPage MigracionMonoADuoSVATiendaPage(){return new MigracionMonoADuoSVATiendaPage();}
}
