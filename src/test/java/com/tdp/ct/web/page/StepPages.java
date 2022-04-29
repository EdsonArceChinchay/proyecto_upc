package com.tdp.ct.web.page;

import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public LoginBerserkerPage loginBerserkerPage(){ return new LoginBerserkerPage(); }
    public HomePage homePage(){ return new HomePage();}

}
