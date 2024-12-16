package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void listaOfertas(String planOfertas, ManageScenario scenario) {

        String expectedOffer = planOfertas.trim().toUpperCase();
        esperaProgresiva(driver(), 5, 2, elementoSeleccionar);

        boolean elementoExistenteRight;
        boolean elementoExistenteleft;
        elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
        int contador = 0;
        int contadorMax = 12;
        while (elementoExistenteRight && contador < contadorMax) {
            if (btnRight != null) {
                esperaProgresiva(driver(), 4, 3, btnRight);
                btnRight.click();
                logInfo("dio click right while");
            } else {
                logInfo("El elemento btnRight no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnRight, 5);
                logInfo("Se muestra el btnRight");
            } catch (Exception e) {
                logInfo("El elemento btnRight ya no fue encontrado: ");
            }
            elementoExistenteRight = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
            contador++;
        }
        UtilWeb.waitForSeconds(2);
        contador = 0;
        elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
        while (elementoExistenteleft && contador < contadorMax) {
            if (btnLeft != null) {
                waitUntilElementIsClickable(btnLeft, 8).click();
                logInfo("dio click left while");
            } else {
                logInfo("El elemento btnleft no existe o es nulo.");
            }
            try {
                waitUntilElementIsVisible(btnLeft, 5);
                logInfo("Se muestra el btnLeft");
            } catch (Exception e) {
                logInfo("El elemento btnLeft ya no fue encontrado: ");
            }
            elementoExistenteleft = !driver().findElements(By.xpath("//img[@src='assets/images/left-arrow.png']")).isEmpty();
            contador++;
        }

        logInfo("Ofertas : " + listaOfertas.size());
        int cont = listaOfertas.size() - 1;
        boolean encontroElemento = false;

        for (int i = 0; i < listaOfertas.size(); i++) {

            String currentOffer = listaOfertas.get(i).getText().trim().toUpperCase();
            logInfo("Offer: " + i + " " + currentOffer);
            if (!encontroElemento && currentOffer.contains(expectedOffer)) {
                logInfo("Offer: " + i + " " + currentOffer);
                encontroElemento = true;
                UtilWeb.waitForSeconds(1);
                click(listaOfertas.get(i));
            }

            if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20 || i == 23 || i == 26 || i == 29 || i == 32 || i == 35 || i == 38) {
                logInfo("Offer: " + i + " " + currentOffer);

                scenario.printFullView();
                js().scrollElementTop(buttonSeleccionarOferta);
                scenario.printFullView();
                js().scrollElementTop(listaOfertas.get(i));
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//img[@src='assets/images/right-arrow.png']")).isEmpty();
                if (elementoExistente) {
                    btnRight.click();
                    UtilWeb.waitForSeconds(1);
                }
            }

            if (!encontroElemento && (i == cont || listaOfertas.get(i + 1).getText().trim().isEmpty())) {
                logInfo("No encontro elemento en la lista");
                UtilWeb.waitForSeconds(2);
                click(listaOfertas.get(i));
                break;
            }
        }

        UtilWeb.waitForSeconds(1);
    }

    public void irAMovistarTotal() {
        revisarModalError(driver());
        esperaProgresiva(driver(), 5, 6, btnIrAMovistar);
        btnIrAMovistar.click();
        UtilWeb.waitForSeconds(5);
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

}
