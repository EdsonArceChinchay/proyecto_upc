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

    public void listaOfertas(String nombrePlan, ManageScenario scenario) {

        logInfo("====================================");
        logInfo("INICIO listaOfertas DEBUG PRO FINAL");
        logInfo("Plan recibido: [" + nombrePlan + "]");

        String expectedOffer = nombrePlan.trim().toUpperCase();
        logInfo("Plan normalizado: [" + expectedOffer + "]");

        WebElement shadowHost;
        try {
            shadowHost = driver().findElement(By.cssSelector("tdp-st-modal"));
            logInfo("✅ Encontró shadowHost");
        } catch (Exception e) {
            logInfo("❌ NO encontró shadowHost: " + e.getMessage());
            throw e;
        }

        SearchContext shadow;
        try {
            shadow = shadowHost.getShadowRoot();
            logInfo("✅ Acceso a shadowRoot OK");
        } catch (Exception e) {
            logInfo("❌ ERROR accediendo a shadowRoot: " + e.getMessage());
            throw e;
        }

        int contador = 0;
        boolean encontrado = false;

        while (contador < 15) {

            logInfo("------------ ITERACIÓN: " + contador + " ------------");

            List<WebElement> cards;
            try {
                cards = shadow.findElements(By.cssSelector(".offer-card-container"));
                logInfo("Cards encontradas: " + cards.size());
            } catch (Exception e) {
                logInfo("❌ Error buscando cards: " + e.getMessage());
                break;
            }

            if (cards.isEmpty()) {
                logInfo("⚠️ No hay cards visibles en esta iteración");
            }

            int index = 0;
            for (WebElement card : cards) {

                String texto = "";
                try {
                    texto = card.getText();
                    logInfo("Card[" + index + "] RAW: [" + texto + "]");
                } catch (Exception e) {
                    logInfo("❌ Error texto card[" + index + "]");
                }

                String normalizado = texto.replaceAll("\\s+", " ").toUpperCase();
                logInfo("Card[" + index + "] NORMALIZADO: [" + normalizado + "]");

                if (normalizado.contains(expectedOffer)) {

                    logInfo("✅ MATCH ENCONTRADO EN CARD[" + index + "]");

                    try {
                        ((JavascriptExecutor) driver())
                                .executeScript("arguments[0].scrollIntoView(true);", card);

                        ((JavascriptExecutor) driver())
                                .executeScript("arguments[0].click();", card);

                        logInfo("✅ CLICK HECHO EN CARD");
                        encontrado = true;

                    } catch (Exception e) {
                        logInfo("❌ ERROR CLICK CARD: " + e.getMessage());
                    }

                    break;
                }

                index++;
            }

            if (encontrado) {
                logInfo("✅ SALIENDO → PLAN ENCONTRADO");
                break;
            }

            // ===== FLECHA CORREGIDA =====
            List<WebElement> flechas;
            try {
                flechas = shadow.findElements(By.cssSelector("div._right"));
                logInfo("Flechas encontradas: " + flechas.size());
            } catch (Exception e) {
                logInfo("❌ Error buscando flecha: " + e.getMessage());
                break;
            }

            if (flechas.isEmpty()) {
                logInfo("❌ NO SE ENCONTRÓ FLECHA → FIN");
                break;
            }

            try {
                WebElement flecha = flechas.get(0);

                logInfo("➡ Intentando click REAL Angular");

                ((JavascriptExecutor) driver()).executeScript(
                        "arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}));" +
                                "arguments[0].dispatchEvent(new MouseEvent('mouseup', {bubbles:true}));" +
                                "arguments[0].click();",
                        flecha
                );

                logInfo("✅ CLICK FLECHA EJECUTADO");

                UtilWeb.waitForSeconds(2);

                // 🔥 REFRESH DEL SHADOW (CLAVE)
                shadow = shadowHost.getShadowRoot();
                logInfo("🔄 ShadowRoot refrescado");

            } catch (Exception e) {
                logInfo("❌ ERROR CLICK FLECHA: " + e.getMessage());
                break;
            }

            contador++;
        }

        if (!encontrado) {
            logInfo("❌ RESULTADO FINAL: NO SE ENCONTRÓ PLAN");
            throw new RuntimeException("No se encontró el plan: " + expectedOffer);
        }

        logInfo("✅ RESULTADO FINAL: PLAN SELECCIONADO");
        logInfo("FIN listaOfertas DEBUG PRO FINAL");
        logInfo("====================================");
    }

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
