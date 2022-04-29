package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebBase {

    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    protected WebElement btnconsultar;

    public void seleccionoTipoDocumento(String tipoDocumento){
        WebElement documentoList= find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
        click(documentoList);
        SearchContext context=sh().getContext(documentoList);
        context.findElement(By.cssSelector("[data-value='"+tipoDocumento+"']")).click();
    }

    public void ingresoDocumento(String documento){
        WebElement document= find().getElementByCss("#doc");
        click(document);
        type(document, documento);

    }
    public void clickBotonConsultar(){
        click(btnconsultar);
    }

}
