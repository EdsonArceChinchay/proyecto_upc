package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;


public class AltaMovilPostpagoCallCenterPage extends WebBase {

    @FindBy(xpath = "/html/body/app-root/app-success/div[2]/div[3]")
    protected WebElement scrollorden;
    @FindBy(xpath = "//app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement BtnOpciones;

    @FindBy(xpath = "(//*[contains(@class,'add_Product') or contains(text(),'Añadir equipo') or  contains(text(),'Agregar Equipo')])[1]")
    protected WebElement LblEquipos;

    @FindBy(xpath = "//div[@class='cont-button']")
    protected WebElement btnBuscar;

    @FindBy(xpath = "//button[contains(text(),'Línea nueva') or contains(text(),'Línea Nueva')]")
    protected WebElement lblLineaNueva;

    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement lblSeleccionarOferta;

    @FindBy(xpath = "(//tdp-st-button[@class='tdp-st-button-l hydrated' and @label='Seleccionar'])[1]")
    protected WebElement btnSeleccionar;

    @FindBy(xpath = "//div[@class='button-filter-section']//button")
    protected List<WebElement> listPlan;

    //@FindBy(xpath = "//div[@class='card-option-ofert-content']")
    @FindBy(xpath = "//div[contains(@class, 'card-option-ofert-content')]")
    protected List<WebElement> listaOfertas;

/*    @FindBy(css= "//tdp-st-input-text[@iconright=\"search\"]")
    protected WebElement inputText;*/

    @FindBy(xpath = "//*[@label='Iniciar Registro' or  @type='button' and @class='btnStart']")
    protected WebElement btnIniciar;

    @FindBy(css= "body > app-root > app-delivery > div.info-user span")
    protected WebElement titleDelivery;

    @FindBy(xpath = "//div[@class='option-boxes']//div")
    protected List<WebElement> listPago;

    @FindBy(css = "div.cont-autocomplete")
    protected WebElement lblItem;

    @FindBy(xpath= "//*[@id=\"modal3\"]/div[2]/form/div/div[5]/button")
    protected WebElement btnConfirmar;

    @FindBy(xpath= "/html/body/app-root/app-success/app-order-detail-fe/div/div[1]")
    protected WebElement btnDetallePedido;

    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnCerrar;

    @FindBy(xpath = "//img[@src='assets/images/right-arrow.png']")
    protected WebElement btnRight;

    public void BtonOpciones() {
        revisarModalError(driver());
        esperaProgresiva(driver(),3,5,BtnOpciones);
        revisarModalError(driver());
        //waitUntilElementIsVisible(BtnOpciones, 10);
        js().scrollElementTop(BtnOpciones);
       // waitUntilElementIsVisible(BtnOpciones, 10);
        System.out.println("BtonOpciones clic");
        BtnOpciones.click();
        //click(BtnOpciones, 30);
        //UtilWeb.waitForSeconds(30);//10
    }

    public void seleccionoElPlanMovil(String tipoPlan) {
        System.out.println("cantidad: " + listPlan.size());
        for (WebElement elements : listPlan) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().equals(tipoPlan))
                click(elements, 30);
        }
    }

    public void seleccionarEquipo() {
        UtilWeb.waitForSeconds(10);
        js().scrollElementTop(LblEquipos);
        waitUntilElementIsVisible(LblEquipos, 10);
        click(LblEquipos, 30);
        UtilWeb.waitForSeconds(20);
    }

    public void seleccionarTiempo(String tiempoP) {
        UtilWeb.waitForSeconds(10);
        revisarModalError(driver());
        js().scrollElementTop(find().getElementByCss("a.back-ofer"));
        WebElement listElementPLan=find().getElementByCss(".comboPermanecia tdp-st-select");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tiempoP)){
                UtilWeb.waitForSeconds(2);
                click(elements,3);
            }
        }
    }

    public void BuscarEquipo(String buscarE) {
        WebElement Input= find().getElementByXPath("//tdp-st-input-text[@iconright='search']");
        click(Input);
        type(Input, buscarE);
        UtilWeb.waitForSeconds(10);
        Input.sendKeys(Keys.ENTER);
        //click(lblItem);
    }

    public void seleccionoLaCartillaLineaNueva() {
        UtilWeb.waitForSeconds(5);
        click(lblLineaNueva, 10);
        UtilWeb.waitForSeconds(10);
    }

    public void doyClickEnElBotonSeleccionarOferta() {
        js().scrollElementTop(lblSeleccionarOferta);
        waitUntilElementIsVisible(lblSeleccionarOferta, 40);//10
        click(lblSeleccionarOferta, 10);
    }

    //RV Plan Ilimitado Mi Movistar S/149.9
    public void seleccionarPlan(String tipoPlan) {
        /*System.out.println("cantidad de la lista : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);
        String elemento = "//div[contains(text(),'" + tipoPlan + "')]/../../../div";
        WebElement elementPlan = find().getElementByXPath(elemento);
        waitUntilElementIsVisible(elementPlan, 20).click();
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Seleccionando el plan >>> {0}", tipoPlan);*/
        UtilWeb.waitForSeconds(4);
        String ofertaEsperada = tipoPlan.trim().toUpperCase();
        System.out.println("cantidad de la lista : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
            if (elementoExistente) {
                System.out.println("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }

        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            System.out.println("Entro al for de las lista de ofertas");
            System.out.println("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).size() != 0;
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }

        if(!encontroElemento && listaOfertas.size()>0){
            System.out.println("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
        UtilWeb.waitForSeconds(1);
    }

    public void doyClickEnElBotonSeleccionar() {
        esperaProgresiva(driver(),5,3,btnSeleccionar);
        js().scrollElementTop(btnSeleccionar);
        click(btnSeleccionar);
    }

    public void doyClickEnIniciarRegistro() {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresiva(driver(),5,3,btnIniciar);
        JavascriptExecutor js = (JavascriptExecutor)driver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //js().scrollElementTop(btnIniciar);
        btnIniciar.click();
       // waitUntilElementIsClickable(btnIniciar,150).click();
       // System.out.println("paso por aqui" + btnIniciar.getText());
        clickBtnCerrarModalError(btnIniciar);
    }

    public boolean meMuestraLaPantallaDeDeliveryDeLineaNueva() {
        boolean existe = waitUntilElementIsVisible(titleDelivery, 60).isDisplayed();
        UtilWeb.waitForSeconds(1);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Estas en la pagina de delivery de la linea nueva", existe);
        return existe;
    }

    public void ingresoElTipoDePago(String pago) {
        System.out.println("cantidad: " + listPago.size());
        for (WebElement elements : listPago) {
            System.out.println("Producto: " + elements.getText());
            if (elements.getText().equals(pago))
                waitUntilElementIsClickable(elements,30).click();
                //click(elements, 3);
                break;
        }
        UtilWeb.waitForSeconds(20);
    }

    public void seleccionoElTipoDeEntregaDeDelivery(String tipo) {
        WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[1]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tipo)){
                UtilWeb.waitForSeconds(1);
                waitUntilElementIsClickable(elements,30).click();
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionamosElHorarioDeEntrega(String horario) {
//        WebElement listElementHorario=find().getElementByCss("tdp-st-card:nth-child(3) > div > div._body > form > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1)");
//        click(listElementHorario);
//        UtilWeb.waitForSeconds(2);
//        SearchContext contexPlan=sh().getContext(listElementHorario);
//        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li"));
//        for(WebElement elements:lista){
//            System.out.println(elements.getText());
//            if(elements.getText().equals(horario)){
//                UtilWeb.waitForSeconds(2);
//                click(elements,30);
//            }
//        }
    }

    public void ingresarFechaNac(String fechaNac) {
        WebElement rootElement = find().getElementByXPath("//tdp-st-input-text[@formcontrolname='fechaNacimiento']");
        SearchContext context = sh().getContext(rootElement);
        context.findElement(By.cssSelector("div > div > div > input")).sendKeys(fechaNac);
        UtilWeb.waitForSeconds(1);
    }

    public void seleccionoNacionalidad(String nacionalidad) {
        WebElement listNacionalidad = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='nacionalidad']");
        UtilWeb.waitForSeconds(2);
        click(listNacionalidad,5);
        UtilWeb.waitForSeconds(3);//2
        SearchContext contexPlan=sh().getContext(listNacionalidad);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li")); //By.className("mdc-list-item")
        for(WebElement elements:lista){
            System.out.println(elements.getText().trim() +" = "+nacionalidad.trim()+" es "+elements.getText().trim().equals(nacionalidad.trim()));
            if(elements.getText().trim().equals(nacionalidad.trim())){
                js().scrollElementTop(elements);
                waitUntilElementIsClickable(elements,30).click();
                break;
            }
        }
    }

    public void seleccionarEstadoCivil(String estadoCivil) {
        WebElement estadoList = find().getElementByXPath("//tdp-st-modal//tdp-st-select[@formcontrolname='estadoCivil']");
        UtilWeb.waitForSeconds(2);
        click(estadoList,5);
        System.out.println("Dio click en lista de estado");
        UtilWeb.waitForSeconds(3);
        SearchContext contexPlan=sh().getContext(estadoList);
        List<WebElement>lista= contexPlan.findElements(By.cssSelector("div > ul > li")); //By.className("mdc-list-item")
        for(WebElement elements:lista){
            System.out.println(elements.getText().trim() +" = "+estadoCivil.trim()+" es "+elements.getText().trim().equals(estadoCivil.trim()));
            if(elements.getText().trim().equals(estadoCivil.trim())){
                click(elements,30);
                break;
            }
        }
    }

    public void ValidoQuePresenteDetallePedido() {
        js().scrollElementTop(scrollorden);
        esperaProgresiva(driver(),3,5,btnDetallePedido);
        click(btnDetallePedido);

    }

    public void clickBtnCerrarModalError( WebElement metodoRepedito){
        //No deberia usarse este metodo. Deberia usarse revisarmodalerror()
        boolean elementoExistente;
        elementoExistente = driver().findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica')]")).size() != 0;
        if (elementoExistente) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al Cerrar");
            System.out.println("Entro al metodo de Cerrar");
            click(btnCerrar);
            UtilWeb.waitForSeconds(2);
            click(metodoRepedito);
        }
    }

}