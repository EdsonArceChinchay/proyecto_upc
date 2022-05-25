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

public class AltaFijaTiendaPage extends WebBase {
    ArrayList<String> tabs;
    @FindBy(xpath = "(//div[@class='tdp-col-md-2'])")
    protected List<WebElement> listaPlanFija;

    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> listaBotones;
    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    protected WebElement buttonConfirmar;
    @FindBy(xpath = "(//button[contains(text(),'Confirmar')])[2]")
    protected WebElement buttonConfirmar2;
    @FindBy(xpath = "(//button[@class='buttonG'])[1]")
    protected WebElement btnDescargar;
    @FindBy(xpath = "(//button[@class='_close'])")
    protected WebElement btnClose;
    @FindBy(xpath = "//div[@class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;


    public void listaPlanFija(String planFija){
        UtilWeb.waitForSeconds(4);
        clickElementInAList(listaPlanFija,planFija);
        UtilWeb.waitForSeconds(1);
    }

    public void listaOfertas(String planOfertas){
        UtilWeb.waitForSeconds(1);
        for (WebElement element:listaOfertas){
            if(element.getText().contains(planOfertas)){
                click(element);
            }
        }
        UtilWeb.waitForSeconds(1);
    }


    public void listaBotones(){
        for(WebElement element:listaBotones){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+element.getText());
            if (element.getText().contains("nueva")){
                click(element);
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+element.getText());
            }
        }
    }

    public void datosAgendamiento(){
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
           List<WebElement> listaHorario= driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
           click(listaHorario.get(0));
            System.out.println("paso aqui 2" + listaHorario.get(0).getText());
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        js().scrollElementTop(buttonConfirmar);
        WebElement rootInput = find().getElementByXPath("(//div[@class='tdp-row']//tdp-st-input-text)[1]");
        SearchContext context = sh().getContext(rootInput);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys("956425985");
        UtilWeb.waitForSeconds(2);

    }

    public void botonConfirmarAgendamiento(){
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//div[@class='contHours']")).size() != 0;
        if (elementoExistente) {
            System.out.println("paso aqui 1");
            click(buttonConfirmar);
            UtilWeb.waitForSeconds(1);
            click(buttonConfirmar2);
            System.out.println("paso aqui 2");
        }else {
            click(buttonConfirmar);
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(5);
    }

    public void descargarContrato(){
        UtilWeb.waitForSeconds(2);
        JavascriptExecutor jse = (JavascriptExecutor)driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement boton= find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[1]/tdp-st-button");
        click(boton);
        UtilWeb.waitForSeconds(20);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-success > app-modal-pdf > tdp-st-modal')" +
                ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(1);

    }

    public void descargarPdf(){
        click(btnDescargar);
    }

    public void cambiarPestanaPrincipal(){
        UtilWeb.waitForSeconds(2);
        tabs=new ArrayList<String>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(0));
        UtilWeb.waitForSeconds(1);
    }

    public void cerrarPopUp(){
        UtilWeb.waitForSeconds(1);
        click(btnClose);
        UtilWeb.waitForSeconds(1);
    }

    public void registrarVenta(){
        JavascriptExecutor jse = (JavascriptExecutor)driver();
        jse.executeScript("window.scrollBy(0,250)");
        UtilWeb.waitForSeconds(1);
        WebElement boton= find().getElementByXPath("(//div[@class='tdp-col-sm-4 tdp-offset-4'])[2]/tdp-st-button");
        click(boton);
        UtilWeb.waitForSeconds(15);
    }

}
