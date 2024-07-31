package com.tdp.ct.web.page.MovilFinanciado;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class AltaMovilControlFinancimientoPage extends WebBase {


    @FindBy(xpath = "//button[@class='btnCard' and contains(text(),'Línea nueva') or contains(text(),'Línea Nueva') or contains(text(),'Línea nueva') ]")
    protected WebElement btnLineaNueva;

    public void selectBtnLineaNueva() {
        esperaProgresiva(driver(), 3, 10, btnLineaNueva);
        click(btnLineaNueva);
    }

}
