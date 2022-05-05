package com.tdp.ct.web.page;

import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public LoginBerserkerPage loginBerserkerPage(){ return new LoginBerserkerPage(); }
    public HomePage homePage(){ return new HomePage();}
    public AltaFijaAltaMovilRetailPage altaFijaAltaMovilRetailPage(){ return new AltaFijaAltaMovilRetailPage();}
    public AltaFijaMovilRegistroPage altaFijaMovilRegistroPage(){ return new AltaFijaMovilRegistroPage();}

}
