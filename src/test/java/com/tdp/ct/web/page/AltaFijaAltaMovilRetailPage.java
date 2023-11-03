package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.*;

public class AltaFijaAltaMovilRetailPage extends WebBase {

    @FindBy(xpath = "//div[@class=\"contenedor_park add_pointer\"]")
    protected WebElement btnHogar;
    @FindBy(css = ".tdp-col-sm-2:nth-child(2) .stl-movil")
    protected WebElement btnMovil;
    @FindBy(xpath = "(//*[contains(text(),'Mostrar Ofertas') or contains(text(),'Mostrar ofertas')])[1]")
    protected WebElement btnMostrar;

    @FindBy(xpath = "//div[1]/tdp-st-card[1]/div/div[2]/form/div[6]/div/button")
    protected WebElement btnConsulta;

    @FindBy(xpath = "/html/body/app-root/app-address-mt/div[2]/app-address-form/div[1]/tdp-st-card[2]/div/div[2]/form/div[8]/div/button")
    protected WebElement cobertura;
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Reintentar')]")
    protected WebElement btnReintentar;
    private String inputCorreo;
    @FindBy(xpath = "/html/body/app-root/app-alta-movil/app-oferta/div[4]/div[2]/div[2]/app-card-plan/div[1]/div/div[4]/div")
    protected WebElement AnadirEquipos;
    private String DEPARTAMENTO = "15";
    private String PROVINCIA = "1501";
    @FindBy(xpath = "//mat-dialog-actions//*[contains(text(),'Entendido')]")
    protected WebElement btnEntendido;

    public void altaHogar(){
        js().scrollElementTop(btnHogar);
        UtilWeb.waitForSeconds(15);
        //waitUntilElementIsClickable(btnHogar,30);
        //esperaProgresiva(driver(),5,5,btnHogar);
        click(btnHogar);
        //waitUntilElementIsVisible(btnMovil,5);
        UtilWeb.waitForSeconds(5);
    }

    public void altaMovil() {
        UtilWeb.waitForSeconds(2);
        js().scrollElementTop(btnMovil);
        //waitUntilElementIsClickable(btnMovil,15);//30
        esperaProgresiva(driver(),5,5,btnMovil);
        click(btnMovil);
        //UtilWeb.waitForSeconds(2);//1
    }

    public void mostrarOfertas(){

        esperaProgresiva(driver(),5,5,btnMostrar);

        //Espera que desaparesca el cargando del la Deuda
        By loaderCard = By.cssSelector("app-deuda img.stl_loader");
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(loaderCard, "hidden", "true"));

        click(btnMostrar);
        //
        //UtilWeb.waitForSeconds(2);
    }
    public void modalError(int timeOnSeconds, WebElement webElement, String message) {
        UtilWeb.waitForSeconds(timeOnSeconds);
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//*[contains(text(),'Reintentar')]")).size() !=0;
        if (elementoExistente) {
            webElement.click();
            if (message.isEmpty()) message = "Dio click al elemento";
            System.out.println(message);
        }
        else {
            System.out.println("No se encontro el modal error");
        }
    }

    public void seleccionarDepa(String tipoDepa){
        UtilWeb.waitForSeconds(4);//2
        WebElement depaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
        esperaProgresiva(driver(),3,5,depaList);

        boolean existeLista = depaList.isEnabled();
        System.out.println("Existe Lista de" + depaList.getText() + ": " + existeLista);
        if (!existeLista){
            driver().navigate().refresh();
            depaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1) > div > tdp-st-select");
            UtilWeb.waitForSeconds(4);
        }
        click(depaList);
        UtilWeb.waitForSeconds(2);
        By byItem = By.cssSelector("[data-value='"+tipoDepa+"']");
        SearchContext context=sh().getContext(depaList);
        esperaProgresiva(driver(),3,5,depaList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarProvincia(String tipoProvincia){
        WebElement provinciaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        esperaProgresiva(driver(),3,5,provinciaList);
        boolean existeLista = provinciaList.isEnabled();
        System.out.println("Existe Lista de" + provinciaList.getText() + ": " + existeLista);
        if (!existeLista){
            driver().navigate().refresh();
            seleccionarDepa(DEPARTAMENTO);
            provinciaList= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2) > div > tdp-st-select");
        }
        click(provinciaList);
        UtilWeb.waitForSeconds(10);
        SearchContext context=sh().getContext(provinciaList);
        By byItem = By.cssSelector("[data-value='"+tipoProvincia+"']");
        esperaProgresiva(driver(),3,5,provinciaList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionarDistrito(String tipoDistrito){
        WebElement distritoList= find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        esperaProgresiva(driver(),3,5,distritoList);
        boolean existeLista = distritoList.isEnabled();
        System.out.println("Existe Lista de" + distritoList.getText() + ": " + existeLista);
        if (!existeLista){
            driver().navigate().refresh();
            seleccionarDepa(DEPARTAMENTO);
            seleccionarProvincia(PROVINCIA);
            distritoList= find().getElementByCss(" tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(3) > div > tdp-st-select");
        }
        click(distritoList);
        UtilWeb.waitForSeconds(2);
        SearchContext context=sh().getContext(distritoList);
        By byItem = By.cssSelector("[data-value='"+tipoDistrito+"']");
        esperaProgresiva(driver(),3,5,distritoList, byItem, context);
        context.findElement(byItem).click();
        UtilWeb.waitForSeconds(1);
    }

    public void writeDireccion(String direc){
        WebElement Input= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(4) > div > tdp-st-input-text");
        click(Input);
        type(Input, direc);
    }

    public void writeReferencia(String referencia){
        WebElement Refer= find().getElementByCss("tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(5) > div > tdp-st-input-text");
        click(Refer);
        type(Refer, referencia);
    }

    public void btnConsultar(){
        //UtilWeb.waitForSeconds(5);
        //waitUntilElementIsVisible(btnConsulta,5);
        esperaProgresiva(driver(),5,5,btnConsulta);
        js().scrollElementTop(btnConsulta);
        click(btnConsulta);
        revisarModalError(driver());
        //revisarModalEntendido(driver());
        //reintarPopPup();
        //reintarPopPup();
    }

    public void writeManzana(String manzana){
        UtilWeb.waitForSeconds(1);
        WebElement Mz= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(1) > tdp-st-input-text");
        click(Mz);
        UtilWeb.waitForSeconds(1);
        type(Mz, manzana);
    }

    public void writeLote(String lote){
        WebElement Lte= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(4) > div:nth-child(2) > tdp-st-input-text");
        click(Lte);
        type(Lte, lote);
    }

    public void writePiso(String piso){
        WebElement Npiso= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(1) > tdp-st-input-text");
        click(Npiso);
        type(Npiso, piso);
    }

    public void writeInterior(String inte){
        WebElement NInterior= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(5) > div:nth-child(2) > tdp-st-input-text");
        click(NInterior);
        type(NInterior, inte);
    }

    public void seleccionarConjuntoHabitacional(String tipoConjunto){
        WebElement conjuntoList= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(6) > div > tdp-st-select");
        click(conjuntoList);
        SearchContext context=sh().getContext(conjuntoList);
        By byItem = By.cssSelector("[data-value='"+tipoConjunto+"']");
        esperaProgresiva(driver(),3,5,conjuntoList, byItem, context);
        context.findElement(byItem).click();
    }

    public void writeConjHab(String hab){
        WebElement ConjHab= find().getElementByCss("tdp-st-card:nth-child(2) > div > div._body > form > div:nth-child(7) > div > tdp-st-input-text");
        click(ConjHab);
        type(ConjHab, hab);
    }

    public void consultaCobertura(){
        click(cobertura);
        UtilWeb.waitForSeconds(3);
    }

    public void tipearCorreo(String correo){
        inputCorreo = correo;
        String getCorreo = "div form div:nth-child(4) tdp-st-input-text;input";
        UtilWeb.waitForSeconds(4);
        WebElement correoElement = js().getWebElement(getCorreo);
        click(correoElement);
        correoElement.sendKeys(inputCorreo);

        String inputCorreo2 = "div form div:nth-child(5) tdp-st-input-text;input";
        WebElement correoElement2 = js().getWebElement(inputCorreo2);
        click(correoElement2);
        type(correoElement2, correo);

        UtilWeb.waitForSeconds(3);
    }

    public void reintarPopPup(){
        boolean btnReintentarboolean;
        boolean modalExiste;
        btnReintentarboolean = driver().findElements(By.xpath("//*[contains(text(),'Reintentar') or contains(@class,'button-light-green ng-star-inserted')]")).size() != 0;
        modalExiste = driver().findElements(By.xpath("//mat-dialog-actions//*[contains(text(),'Entendido')]")).size() !=0;
        if (btnReintentarboolean) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Modal Reintentar");
            WebElement btnReintentar= find().getElementByXPath("//*[contains(text(),'Reintentar') or contains(@class,'button-light-green ng-star-inserted')]");
            js().scrollElementTop(btnReintentar);
            btnReintentar.click();
            UtilWeb.waitForSeconds(3);
        }
        if (modalExiste){
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al boton entendido");
            btnEntendido.click();
            UtilWeb.waitForSeconds(2);
        }
    }

}