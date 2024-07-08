package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MigracionMonoADuoSVATiendaPage extends WebBase {

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;

    public void seleccionarboton(){
        System.out.println(1);
        UtilWeb.waitForSeconds(4);
        System.out.println(1);
        for(WebElement element:listaBotones){
            if (element.getText().contains("Cambiar plan hogar")){
                //UtilWeb.waitForSeconds(5);
                click(element,40);
            }
        }
        UtilWeb.waitForSeconds(4);
    }


}
