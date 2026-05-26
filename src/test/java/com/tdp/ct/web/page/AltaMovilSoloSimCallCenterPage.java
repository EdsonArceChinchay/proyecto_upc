package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.utils.Addons.*;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.getVisibleAndClickableElement;

public class AltaMovilSoloSimCallCenterPage extends WebBase {

    @FindBy(xpath = "(//div[@class='button-filter-section'])/button")
    protected List<WebElement> listaTipoPlanMovil;
    @FindBy(xpath = "(//div[contains(@class,'offert-card-title')])/div[2]")
    protected List<WebElement> listaPlanMovil;
    @FindBy(xpath = "//tdp-st-button[@label='Seleccionar Oferta']")
    protected WebElement botonSeleccionarOferta;
    @FindBy(css = "img[alt='right-arrow']")
    protected WebElement btnRight;
    @FindBy(css = "img[alt='left-arrow']")
    protected WebElement btnLeft;
    @FindBy(xpath = "//h4[contains(text(), 'Desea un plan Prepago o Postpago')]")
    protected WebElement preguntaTipoPlan;
    @FindBy(xpath = "//div[contains(@class, 'card-option-ofert-content')]")
    protected List<WebElement> listaOfertas;
    @FindBy(xpath = "//h1[contains(text(),'Ofertas sugeridas')]")
    protected WebElement ofertasSugeridas;

    StepPages view = new StepPages();
    ManageScenario miScenario = new ManageScenario();

    public void listaTipoPlanMovil(String planMovil) {
        UtilWeb.waitForSeconds(2);
        revisarModalError(driver());
        esperaProgresivaLoading(driver(), 3, 5, "loading-offer");
        clickElementInAList(listaTipoPlanMovil, planMovil, 10);
    }


    public void listaPlanMovil(String planMovil) {
        revisarModalError(driver());
        miScenario.printFullView();
        UtilWeb.waitForSeconds(2);

        // Espera a que exista el buscador de ofertas (como tenías)
        WebElement inputElement = driver().findElement(
                By.cssSelector(".search-section tdp-st-input-text[formcontrolname='name']")
        );
        esperaProgresiva(driver(), 3, 5, inputElement);

        boolean elementoExistenteRight;
        boolean elementoExistenteleft;

        int contador = 0;
        int contadorMax = 12;

        // ====== 1) Ir a la derecha (tu lógica original, robustecida) ======
        elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
        while (elementoExistenteRight && contador < contadorMax) {

            try {
                if (btnRight != null && btnRight.isDisplayed()) {
                    // Mejor que esperarProgresiva + click directo
                    waitUntilElementIsClickable(btnRight, 8).click();
                    logInfo("dio click right while");
                } else {
                    logInfo("El elemento btnRight no existe, es nulo o no está visible.");
                    break;
                }
            } catch (Exception e) {
                logSevere("Fallo al hacer click en btnRight", e.getMessage());
                break;
            }

            // Recalcula existencia (ojo: puede existir pero estar oculto, pero respetamos tu lógica)
            elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            contador++;
        }

        UtilWeb.waitForSeconds(2);

        // ====== 2) Regresar a la izquierda (tu lógica original, robustecida) ======
        contador = 0;
        elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
        while (elementoExistenteleft && contador < contadorMax) {

            try {
                if (btnLeft != null && btnLeft.isDisplayed()) {
                    waitUntilElementIsClickable(btnLeft, 8).click();
                    logInfo("dio click left while");
                } else {
                    logInfo("El elemento btnLeft no existe, es nulo o no está visible.");
                    break;
                }
            } catch (Exception e) {
                logSevere("Fallo al hacer click en btnLeft", e.getMessage());
                break;
            }

            elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
            contador++;
        }

        // ====== 3) Buscar y seleccionar el plan (AQUÍ estaba el problema del cuadro azul) ======
        logInfo("Ofertas : " + listaPlanMovil.size());
        if (listaPlanMovil == null || listaPlanMovil.isEmpty()) {
            logSevere("listaPlanMovil está vacía", "No hay planes para seleccionar.");
            return;
        }

        int cont = listaPlanMovil.size() - 1;
        boolean encontroElemento = false;

        for (int i = 0; i < listaPlanMovil.size(); i++) {

            String titulo = "";
            try {
                titulo = listaPlanMovil.get(i).getText();
            } catch (Exception ignored) {}

            logInfo("Oferta: " + i + " " + titulo);

            // 3.1) Si coincide el título con el plan, selecciona el CARD (no solo el texto)
            if (!encontroElemento
                    && titulo != null
                    && titulo.trim().toUpperCase().contains(planMovil.trim().toUpperCase())) {

                try {
                    WebElement tituloEl = listaPlanMovil.get(i);

                    // Subimos al contenedor que realmente se selecciona (cuadro azul)
                    WebElement card = tituloEl.findElement(
                            By.xpath("./ancestor::div[contains(@class,'card-option-ofert-content')][1]")
                    );

                    js().scrollElementTop(card);
                    UtilWeb.waitForSeconds(1);

                    // Click robusto sobre el card
                    click(card); // usa tu helper click(...)
                    UtilWeb.waitForSeconds(1);

                    encontroElemento = true;
                    logInfo("✅ Seleccionó el plan por nombre (card): " + titulo);

                } catch (Exception e) {
                    logSevere("No se pudo seleccionar el card del plan", e.getMessage());
                }
            }

            // 3.2) Tu lógica de avance en ciertos índices (ARREGLADO: faltaban ||)
            if (i == 2  || i == 5  || i == 8  || i == 11 || i == 14 || i == 17 ||
                    i == 20 || i == 23 || i == 26 || i == 29 || i == 32 || i == 35 || i == 38) {

                miScenario.printFullView();
                js().scrollElementTop(botonSeleccionarOferta);
                miScenario.printFullView();

                WebElement buscarButton = driver().findElement(By.cssSelector(".search-section .search-button"));
                js().scrollElementTop(buscarButton);

                boolean existeRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (existeRight) {
                    try {
                        // Mejor con clickable
                        if (btnRight != null && btnRight.isDisplayed()) {
                            waitUntilElementIsClickable(btnRight, 8).click();
                            UtilWeb.waitForSeconds(1);
                        }
                    } catch (Exception e) {
                        logSevere("Fallo click adicional en btnRight dentro del for", e.getMessage());
                    }
                }
            }

            // 3.3) Si no encontró el plan y llega al final o el siguiente viene vacío (ARREGLADO: faltaba || + bounds)
            boolean siguienteVacio = (i + 1 < listaPlanMovil.size())
                    && (listaPlanMovil.get(i + 1).getText() == null
                    || listaPlanMovil.get(i + 1).getText().trim().isEmpty());

            if (!encontroElemento && (i == cont || siguienteVacio)) {
                logInfo("No encontró el plan en la lista, selecciona fallback (último visible).");
                UtilWeb.waitForSeconds(1);

                try {
                    WebElement tituloEl = listaPlanMovil.get(i);
                    WebElement card = tituloEl.findElement(
                            By.xpath("./ancestor::div[contains(@class,'card-option-ofert-content')][1]")
                    );
                    js().scrollElementTop(card);
                    click(card);
                } catch (Exception e) {
                    logSevere("Fallback no pudo seleccionar el card", e.getMessage());
                }
                break;
            }
        }

        UtilWeb.waitForSeconds(1);

    }

    public void seleccionarPlan(String tipoPlan) {
        UtilWeb.waitForSeconds(4);
        String ofertaEsperada = tipoPlan.trim().toUpperCase();
        logInfo("cantidad de la lista : " + listaOfertas.size());
        UtilWeb.waitForSeconds(5);

        for (int i = 0; i < 2; i++) {
            boolean elementoExistente;
            elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            if (elementoExistente) {
                logInfo("dio click");
                click(btnRight);
                UtilWeb.waitForSeconds(3);
            }
        }

        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        UtilWeb.waitForSeconds(3);
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {
            String ofertaObtenida = listaOfertas.get(i).getText().trim().toUpperCase();
            logInfo("Entro al for de las lista de ofertas");
            logInfo("Oferta " + i + 1 + ": " + ofertaObtenida + ", es igual al Plan a elegir: " + ofertaObtenida.contains(ofertaEsperada));
            if (ofertaObtenida.contains(ofertaEsperada)) {
                encontroElemento = true;
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
            if (i == 2 || i == 5 || i == 8) {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }
        }

        if (!encontroElemento && !listaOfertas.isEmpty()) {
            logInfo("No encontro elemento en la lista");
            UtilWeb.waitForSeconds(2);
            int cont = listaOfertas.size() - 1;
            click(listaOfertas.get(cont));
        }
        UtilWeb.waitForSeconds(1);
    }

    public void botonSeleccionarOfeta() {
        js().scrollElementTop(botonSeleccionarOferta);
        click(botonSeleccionarOferta, 10);
    }

    public void validarSeleccionaPostpagoPrepago() {
        esperaProgresiva(driver(), 3, 3, preguntaTipoPlan);
        boolean existe = waitUntilElementIsVisible(preguntaTipoPlan, 90).isDisplayed();
        UtilWeb.waitForSeconds(1);
        logInfo("Estas en la pagina preguntaTipoPlan >>> {0}", existe);
    }

    public void seleccionoElBotonAgregarSva() {
        revisarModalError(driver());
        List<WebElement> listbtnAddSVA = find().getElementsByXPath("(//app-modal-detail-landline//div[2]/tdp-st-button)[1] | (//app-modal-detail-mt//div[2]/tdp-st-button)[1] | //*[contains(@class,'buttonG') and contains(text(),'SVA')]");
        esperaProgresiva(driver(), 3, 5, listbtnAddSVA.get(0));
        WebElement btnAddSVA = getVisibleAndClickableElement(listbtnAddSVA);
        js().scrollElementTop(btnAddSVA);
        btnAddSVA.click();
        UtilWeb.waitForSeconds(5);
    }

    public void imprimoLaOfertaSeleccionada(ManageScenario scenario) {
        waitUntilElementIsVisible(ofertasSugeridas, 20);
        js().scrollElementTop(ofertasSugeridas);
        scenario.printFullView();
    }
}
