package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AltaPuraMTcallCenterPage extends WebBase {

    @FindBy(xpath = "//button[@class = 'button_step']")
    protected WebElement btnConfirmaUbicacion;

    @FindBy(xpath = "//span[text()='2pm-7pm']/..")
    protected  WebElement elegirHorario;

    public void btnConfirmarUbicacion(){
        click(btnConfirmaUbicacion,10);
        UtilWeb.waitForSeconds(5);
    }

    public void selectTipoHorario(){
        click(elegirHorario);
    }

    public void completarIdCall(String idCall){

        WebElement rootInputConfirmarCorreo = find().getElementByXPath("(//div[contains(@class,'tdp-row')]//tdp-st-input-text)[2]");
        SearchContext context3 = sh().getContext(rootInputConfirmarCorreo);
        context3.findElement(By.cssSelector("div > div > div > input")).sendKeys(idCall);

        UtilWeb.waitForSeconds(1);

    }
}
