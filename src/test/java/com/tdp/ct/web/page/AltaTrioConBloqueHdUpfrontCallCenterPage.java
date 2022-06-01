package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class AltaTrioConBloqueHdUpfrontCallCenterPage extends WebBase {

    @FindBy(xpath = "(//div[@class='tdp-row'])[3]")
    protected WebElement btnConfirmarUbicacion;

}
