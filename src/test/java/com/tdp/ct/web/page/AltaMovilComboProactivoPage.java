package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AltaMovilComboProactivoPage extends WebBase {

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Datos del Cliente')]")
    protected WebElement labelDatosDeCliente1;
    @FindBy(xpath = "//tdp-st-textarea[@formcontrolname='direccion']")
    protected WebElement lblDireccion;

    @FindBy(xpath = "//*[@id=\"modal3\"]/div[2]/form/div/div[9]/button")
    protected WebElement lblConsultar;




    public void clicConfirmarCliente() {
        UtilWeb.waitForSeconds(1);
        WebElement element = find().getElementByXPath("//button[contains(text(),'Confirmar')]");
        element.click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Click en confirmar");
        UtilWeb.waitForSeconds(2);
    }

    public void ingresarFechaNac(String fechaNac) {
        WebElement rootElement = find().getElementByXPath("//tdp-st-input-text[@formcontrolname='fechaNacimiento']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(fechaNac);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarEstadoCivil(String estadoCivil) {
        WebElement generoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']");
        click(generoList);
        String dataValue = "";
        UtilWeb.waitForSeconds(2);
        SearchContext context = sh().getContext(generoList);
        if (estadoCivil.equalsIgnoreCase("Soltero")) {
            dataValue = "single";
        } else {
            dataValue = "married";
        }
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando estado civil");
    }

    public void seleccionoNacionalidad(String nacionalidad) {
        WebElement listNacionalidad = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(listNacionalidad);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listNacionalidad);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(nacionalidad)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
    }



    public void seleccionarDepartamento(String departamento) {
        WebElement listDepartamento = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='department']");
        click(listDepartamento);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listDepartamento);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(departamento)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }

    }

    public void seleccionarProvincia(String provincia) {
        WebElement listProvincia = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        js().scrollElementTop(listProvincia);
        click(listProvincia);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listProvincia);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(provincia)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
    }

    public void seleccionarDistrito(String distrito) {
        WebElement listDistrito = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='district']");
        click(listDistrito);
        js().scrollElementTop(listDistrito);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listDistrito);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(distrito)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }

    }

    public void seleccionarDireccion(String direccion) {
        js().scrollElementTop(lblDireccion);
        System.out.println("direccion: "+direccion);
        waitUntilElementIsVisible(lblDireccion, 10);
        click(lblDireccion,10);
        type(lblDireccion, direccion);
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(lblConsultar);
        click(lblConsultar,10);
    }


    public void clicConsultar() {



    }

}

