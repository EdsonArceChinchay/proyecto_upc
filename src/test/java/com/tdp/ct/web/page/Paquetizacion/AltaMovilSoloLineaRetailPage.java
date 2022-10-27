package com.tdp.ct.web.page.Paquetizacion;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AltaMovilSoloLineaRetailPage extends WebBase {

    @FindBy(xpath = "//div/button[@class='button-filter active ng-star-inserted']")
    private WebElement ofertaPost;

    public void     buscarOfertaRetail(){
        UtilWeb.waitForSeconds(15);
        click(ofertaPost);
        //String elemento ="//div/button[@class='"+oferta+"']";
    }

}
