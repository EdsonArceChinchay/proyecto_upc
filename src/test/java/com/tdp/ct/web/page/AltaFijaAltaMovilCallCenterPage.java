package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.scrollUp;

public class AltaFijaAltaMovilCallCenterPage extends WebBase {

    @FindBy(xpath = "(//img[@src='assets/images/icon_glove.svg'])[2]")
    protected WebElement oferta;
    @FindBy(xpath = "(//img[@src='assets/images/icon_glove.svg'])[1]")
    protected WebElement ofertaUno;
    @FindBy(xpath = "//*[@class='stl_plan_valor' or @class='stl_negrita g-text--uppercase']")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//button[contains(text(),'Seleccionar Oferta')]")
    protected WebElement buttonSeleccionarOferta;
    @FindBy(xpath = "//div[@class='offer-option-title']/div[@class='general-title' and contains(text(), 'Seleccione un')]")
    protected WebElement elementoSeleccionar;
    @FindBy(xpath = "//button[@class='btnCard' and contains(text(),'Ir a movistar total')]")
    protected WebElement btnIrAMovistar;
    @FindBy(css = "img[alt='right-arrow']")
    protected WebElement btnRight;
    @FindBy(css = "img[alt='left-arrow']")
    protected WebElement btnLeft;
    @FindBy(xpath = "//app-card-plan/div[1]/div/div[1]/div[3]/img")
    protected WebElement BtnOpciones;
    @FindBy(xpath = "//button[@class='btnCard']")
    protected List<WebElement> botoneraIrA;
    @FindBy(xpath = "//button[@class='btnCard' and contains(text(),'Línea nueva') or contains(text(),'Línea Nueva') or contains(text(),'Línea nueva') ]")
    protected WebElement btnLineaNueva;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnConsultarCobertura;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void scrollUP() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(10);//10
        scrollUp();
    }

    public void oferta() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 7, 8, oferta);
        revisarModalError(driver());
        scrollUp();
        click(oferta);
        UtilWeb.waitForSeconds(2);
    }

    public void BtonOpciones() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 3, 5, BtnOpciones);
        revisarModalError(driver());
        js().scrollElementTop(BtnOpciones);
        logInfo("BtonOpciones clic");
        BtnOpciones.click();
    }

    public void ofertaUno() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 6, 4, ofertaUno);
        revisarModalError(driver());
        click(ofertaUno);
        UtilWeb.waitForSeconds(2);
    }
   /////////////////////BUSCAR Y LISTAR OFERTAS //////////

   public void listaOfertas(String nombrePlan, ManageScenario scenario) {
       String expected = nombrePlan
           .replaceAll("\\s+", " ")
           .trim()
           .toUpperCase();

       logInfo("PLAN BUSCADO (FEATURE): [" + expected + "]");

       int intentos = 0;

       while (intentos < 10) {

           logInfo("===== PESTAÑA #" + intentos + " =====");

           List<WebElement> planes = driver().findElements(By.cssSelector(".stl_plan_valor"));

           logInfo("Cantidad de planes visibles: " + planes.size());

           int index = 0;

           for (WebElement plan : planes) {

               String texto = "";

               try {
                   texto = plan.getText()
                           .replaceAll("\\s+", " ")
                           .trim()
                           .toUpperCase();
               } catch (Exception e) {
                   logInfo("❌ Error leyendo plan index: " + index);
                   continue;
               }

               logInfo("PLAN [" + index + "]: [" + texto + "]");

               if (texto.equals(expected)) {

                   logInfo("✅ MATCH ENCONTRADO EN INDEX: " + index);

                   try {

                       // 🔥 SCROLL AL TEXTO
                       ((JavascriptExecutor) driver())
                               .executeScript("arguments[0].scrollIntoView(true);", plan);

                       // 🔥 CLICK FUERTE (Angular-friendly)
                       ((JavascriptExecutor) driver()).executeScript(
                               "arguments[0].dispatchEvent(new MouseEvent('mousedown',{bubbles:true}));" +
                                       "arguments[0].dispatchEvent(new MouseEvent('mouseup',{bubbles:true}));" +
                                       "arguments[0].click();",
                               plan
                       );

                       logInfo("✅ PLAN SELECCIONADO CORRECTAMENTE");
                       return;

                   } catch (Exception e) {
                       logInfo("❌ ERROR HACIENDO CLICK: " + e.getMessage());
                   }
               }

               index++;
           }

           // 👉 mover carrusel
           try {
               js().scrollElementTop(btnRight);
               btnRight.click();
               UtilWeb.waitForSeconds(2);

           } catch (Exception e) {
               logInfo("❌ No hay más páginas");
               break;
           }

           intentos++;
       }

       throw new RuntimeException("❌ No se encontró el plan: " + expected);
   }





    ////////////////   ////////////////   ////////////////   ////////////////

    public void clickBotonIrMovistarTotal() {
        esperaProgresiva(driver(), 4, 5, botoneraIrA.get(1));
        revisarModalError(driver());
        click(botoneraIrA.get(1));
        UtilWeb.waitForSeconds(1);
    }

    public void selectBtnLineaNueva() {
        esperaProgresiva(driver(), 5, 5, btnLineaNueva);
        js().scrollElementTop(btnLineaNueva);
        click(btnLineaNueva);
    }

    public void btnConsultarCobertura() {
        esperaProgresiva(driver(), 5, 3, btnConsultarCobertura);
        js().scrollElementTop(btnConsultarCobertura);
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 5, btnConsultarCobertura);
        btnConsultarCobertura.click();
    }

    public void seleccionarOferta() {
        revisarModalError(driver());

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('body > app-root > app-offer-mt > app-mt-change-plan-modal > tdp-st-modal')" + ".shadowRoot.querySelector('div > div.mdc-dialog__container > div.mdc-dialog__surface > div.mdc-dialog__content').scrollTop=500");
        UtilWeb.waitForSeconds(3);
        buttonSeleccionarOferta.click();
    }

    public void irAMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 6, btnIrAMovistar);
        btnIrAMovistar.click();
        UtilWeb.waitForSeconds(5);
    }

    /**
     * FUNCION SELECCIONAR TIPO DE PLAN
     * Trío, Duo y Mono
     * */

    public void seleccionarTipoPlan(String tipoPlan) {
        logInfo("Ingreso a Seleccion el tipo de plan: " + tipoPlan);
        WebElement tipoDePlan;
        try {
            logInfo("Ingreso a Validar si el boton: " + tipoPlan + " - ya se encuentra seleccionado");
            tipoDePlan = find().getElementByXPath("//*[contains(normalize-space(text()), '"+ tipoPlan +"') and contains(@class, 'ctive')]");
            boolean activoBoton = tipoDePlan.isDisplayed();
            logInfo("Boton " + tipoPlan + " Activo" + " - Estado: " + activoBoton);
        } catch (Exception e) {
            logInfo("Ingreso a Validar si el boton: " + tipoPlan + " - no se encuentra seleccionado");
            tipoDePlan = find().getElementByXPath("//*[contains(normalize-space(text()), '"+ tipoPlan +"') and contains(@class, 'utton')]");
            click(tipoDePlan,5);
            logInfo("Se selecciono el boton: " + tipoPlan);
            view.temporalPage().barraCargando();
            miScenario.printFullView();
        }
    }
}
