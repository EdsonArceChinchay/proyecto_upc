package com.tdp.ct.web.page.MovilFinanciado;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AltaMovilControlFinancimientoPage extends WebBase {


    @FindBy(xpath = "(//img[@class='margin-icon add_pointer'])[1]")
    protected WebElement planActual;
    //@FindBy(xpath = "(//img[@class='margin-icon add_pointer'])[3]")
    @FindBy(xpath = "//div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement planMovil;
    @FindBy(xpath ="(//div[@class='offert-card-body'])[1]")
    protected WebElement selectCampaniaOferta;
    @FindBy(xpath ="//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement btnSeleccionarOferta;
    @FindBy(xpath ="//button[@class='btnCard']")
    protected WebElement btnLineaNueva;
    @FindBy(xpath ="//div[3]/app-summary-section/div/div/div[1]/div/tdp-st-button")
    protected WebElement btnAgregarEquipo;
    @FindBy(xpath ="//div[6]/div[1]/div/div[2]/div[3]/tdp-st-button")
    protected WebElement btnSeleccionarEquipo;
    @FindBy(xpath ="//div[3]/div[2]/div/div/div/tdp-st-button")
    protected WebElement btnIniciarRegistro;
    //Validate
    @FindBy(xpath ="//div[2]/form/div[1]/h1")
    protected WebElement validarTituloCompletarDatos;

    @FindBy(xpath ="//div[1]/div/div[2]/div/h1")
    protected WebElement validarSeleccionarEquipo;

    @FindBy(xpath ="//div[2]/div[1]/button[1]")
    protected WebElement btnPostpago;
    @FindBy(xpath ="//div[2]/div[1]/button[2]")
    protected WebElement btnControl;

    @FindBy(xpath ="//*[@id=\"modal3\"]/div[2]/form/div/div[9]/button")
    protected WebElement btnConfirmar;

    @FindBy(xpath ="//*[contains(@label,'Siguiente')]")
    protected WebElement btnSiguiente;

    public void selectPlanActual() {
        click(planActual);
    }
    public void selectPlanMovil() {
        UtilWeb.waitForSeconds(8);
        js().scrollElementTop(planMovil);
        waitUntilElementIsVisible(planMovil, 20);
        click(planMovil);
    }

    public void selectCampania() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(selectCampaniaOferta, 5);
        click(selectCampaniaOferta);
    }

    public void selectBtnOferta() {
        js().scrollElementTop(btnSeleccionarOferta);
        UtilWeb.waitForSeconds(2);
        click(btnSeleccionarOferta);
    }
    public void selectBtnLineaNueva() {
        UtilWeb.waitForSeconds(2);
        click(btnLineaNueva);
        UtilWeb.waitForSeconds(2);
    }
    public void selectBtnAgregarEquipo() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(btnAgregarEquipo, 10);
        click(btnAgregarEquipo);
        UtilWeb.waitForSeconds(5);
    }
    public void selectBtnEquipo() {
        js().scrollElementTop(btnSeleccionarEquipo);
        UtilWeb.waitForSeconds(2);
        click(btnSeleccionarEquipo);
    }
    public void selectBtnIniciarRegistro() {
        UtilWeb.waitForSeconds(3);
        click(btnIniciarRegistro);
        UtilWeb.waitForSeconds(2);
    }

    public String validateTituloIniciarRegistro() {
        return getText(validarTituloCompletarDatos);
    }

    public void selectBtnPostpago() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(btnAgregarEquipo, 10);
        click(btnPostpago);
    }

    public void selectBtnControl() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsVisible(btnControl, 10);
        click(btnControl);
    }
    public void ingresarFechaNac(String fechaNac) {
        WebElement rootElement = find().getElementByXPath("//tdp-st-input-text[@formcontrolname='fechaNacimiento']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(fechaNac);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoNacionalidad() {
        WebElement nacList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        click(nacList);
        UtilWeb.waitForSeconds(2);
        String dataValue = "DEU";
        SearchContext context = sh().getContext(nacList);
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando nacionalidad");
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

    public void seleccionoDepartamento() {
        WebElement depList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='department']");
        click(depList);
        UtilWeb.waitForSeconds(2);
        String dataValue = "15";
        SearchContext context = sh().getContext(depList);
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando departamento");
    }

    public void seleccionoProvincia() {
        WebElement proList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='province']");
        click(proList);
        UtilWeb.waitForSeconds(2);
        String dataValue = "1501";
        SearchContext context = sh().getContext(proList);
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando provincia");
    }

    public void seleccionoDistrito() {
        WebElement distList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='district']");
        click(distList);
        UtilWeb.waitForSeconds(3);
        String dataValue = "150136";
        SearchContext context = sh().getContext(distList);
        context.findElement(By.cssSelector("[data-value='" + dataValue + "']")).click();
        System.out.println("seleccionando distrito");
    }
    public void ingresarDireccion(String direccion) {
        WebElement direc = find().getElementByXPath("//tdp-st-modal//tdp-st-textarea[@formcontrolname='direccion']");
        click(direc);
        type(direc, direccion);
        UtilWeb.waitForSeconds(2);
    }
    public void selectBtnConfirmar() {
        waitUntilElementIsVisible(btnConfirmar, 5);
        click(btnConfirmar);
        UtilWeb.waitForSeconds(12);
    }

    public String validateTituloSeleccionarEquipo() {
        UtilWeb.waitForSeconds(2);
        return getText(validarSeleccionarEquipo);
    }

    public void clickPlanMovil(String planMovil) {
        WebElement btnplanMovil = find().getElementByXPath("//*[@class='item']/span[contains(text(),'"+planMovil+"')]");
        waitUntilElementIsVisible(btnplanMovil, 5);
        click(btnplanMovil);
    }

    public void clickEnBotonSiguiente() {
        waitUntilElementIsVisible(btnSiguiente, 5);
        click(btnSiguiente);
    }
}
