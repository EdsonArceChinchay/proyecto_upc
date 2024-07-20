package com.tdp.ct.web.page;

import com.tdp.ct.web.page.Caeq.CaeqPorRetailPage;
import com.tdp.ct.web.page.Caeq.CambioDeEquipoConCambioDeSimPage;
import com.tdp.ct.web.page.MovilFinanciado.AltaMovilControlFinancimientoPage;
import com.tdp.ct.web.page.migracion.*;
import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public AltaTrioMTconUpfrontTiendaPage altaTrioMTconUpfrontTiendaPage() {
        return new AltaTrioMTconUpfrontTiendaPage();
    }

    public AltaFijaAltaMovilRetailPage altaFijaAltaMovilRetailPage() {
        return new AltaFijaAltaMovilRetailPage();
    }

    public AltaFijaMovilRegistroPage altaFijaMovilRegistroPage() {
        return new AltaFijaMovilRegistroPage();
    }

    public AltaFijaAltaMovilCallCenterPage altaFijaAltaMovilCallCenterPage() {
        return new AltaFijaAltaMovilCallCenterPage();
    }

    public AltaMovilPostpagoCallCenterPage altaMovilPostpagoCallCenterPage() {
        return new AltaMovilPostpagoCallCenterPage();
    }

    public AltaMovilComboProactivoPage altaMovilComboProactivoPage() {
        return new AltaMovilComboProactivoPage();
    }

    public AltaFijaRetailPage altaFijaRetailPage() {
        return new AltaFijaRetailPage();
    }

    public AltaFijaTiendaPage altaFijaTiendaPage() {
        return new AltaFijaTiendaPage();
    }

    public AltaPuraMTcallCenterPage altaPuraMTcallCenterPage() {
        return new AltaPuraMTcallCenterPage();
    }

    public AltaMonoInstalacionFtthTiendaPage altaMonoFtthTiendaPage() {
        return new AltaMonoInstalacionFtthTiendaPage();
    }

    public AltaTrioConBloqueHdUpfrontCallCenterPage altaTrioConBloqueHdUpfrontCallCenterPage() {
        return new AltaTrioConBloqueHdUpfrontCallCenterPage();
    }

    public AltaMovilSoloSimCallCenterPage altaMovilSoloSimCallCenterPage() {
        return new AltaMovilSoloSimCallCenterPage();
    }

    public MigracionDuoATrioTiendaPage migracionDuoATrioTiendaPage() {
        return new MigracionDuoATrioTiendaPage();
    }

    public CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage caplConCaeqAlContadoCanalTiendaPage() {
        return new CaplConCaeqAlContadoCanalTiendaDeControlAPrepagoPage();
    }

    public AltaMovilPrepagoSoloChipTiendaPage altaMovilPrepagoSoloChipTiendaPage() {
        return new AltaMovilPrepagoSoloChipTiendaPage();
    }

    public MigraTrioaMTcanalCallCenterPage migraTrioaMTcanalCallCenterPage() {
        return new MigraTrioaMTcanalCallCenterPage();
    }

    public AltaMovilControlFinancimientoPage altaMovilControlFinancimientoPage() {
        return new AltaMovilControlFinancimientoPage();
    }

    public CaeqPorRetailPage caeqPorRetailPage() {
        return new CaeqPorRetailPage();
    }

    public CambioDeEquipoConCambioDeSimPage cambioDeEquipoConCambioDeSimPage() {
        return new CambioDeEquipoConCambioDeSimPage();
    }

    public MigraSalto0RetailPage migraSalto0RetailPage() {
        return new MigraSalto0RetailPage();
    }

    public MigraMTconCambioVelocidaCallCenterPage migraMTconCambioVelocidaCallCenterPage() {
        return new MigraMTconCambioVelocidaCallCenterPage();
    }

    public PortabilidadPage portabilidadPage() {
        return new PortabilidadPage();
    }

    public MigraDuoTrioActualizarDireccionTiendasPage migraDuoTrioActualizarDireccionTiendasPage() {
        return new MigraDuoTrioActualizarDireccionTiendasPage();
    }

    public AltaValidacionPrecioDescuentoPage altaValidacionPrecioDescuentoPage() {
        return new AltaValidacionPrecioDescuentoPage();
    }

    public LoginBerserkerPage loginBerserkerPage() {
        return new LoginBerserkerPage();
    }

    public CaptchaPage captchaPage() {
        return new CaptchaPage();
    }

    public HomePage homePage() {
        return new HomePage();
    }

    public ParkPage parkPage() {
        return new ParkPage();
    }

    public AddressPage addressPage() {
        return new AddressPage();
    }

    public DeliveryPage deliveryPage(){return new DeliveryPage();}

    public OfferSVAPage offerSVAPage() {
        return new OfferSVAPage();
    }

    public AppointmentPage appointmentPage() {
        return new AppointmentPage();
    }

    public BandejaBackOfficePage bandejaBackOfficePage() {
        return new BandejaBackOfficePage();
    }

}


