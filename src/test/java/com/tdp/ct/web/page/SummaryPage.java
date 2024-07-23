package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;

public class SummaryPage extends WebBase {

    @FindBy(xpath = "//*[contains(@label,'Iniciar Registro') or  @type='button' and @class='btnStart']")
    protected WebElement btnStartRegister;

    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnClose;

    @FindBy(xpath = "(//div[@class='title'])/span")
    protected WebElement paginaResumen;

    public void moverToElementIniciarRegistro() {
        esperaProgresiva(driver(), 3, 5, btnStartRegister);
        js().scrollElementTop(btnStartRegister);
    }

    public void clickButtonStartRegister(){
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
        int intentos = 4;
        for(int i=0;i<intentos;i++) {
            try {
                esperaProgresiva(driver(), 6, 6, btnStartRegister);
                JavascriptExecutor js = (JavascriptExecutor) driver();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                btnStartRegister.click();
                clickBtnCerrarModalError(btnStartRegister);
                return;
            } catch (NoSuchElementException e) {
                System.out.println("No se pudo cargar la página después de " + (i + 1) + " intentos. Error: " + e.getMessage());
            }
        }
    }

    public void clickBtnCerrarModalError(WebElement metodoRepedito) {
        boolean elementoExistente = !driver().findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")).isEmpty();
        if (elementoExistente) {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "Click al Cerrar");
            click(btnClose);
            UtilWeb.waitForSeconds(2);
            click(metodoRepedito);
        }
    }

    public void paginaResumen() {
        revisarModalError(driver());
        UtilWeb.waitForSeconds(7);
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        esperaProgresiva(driver(),3,5,paginaResumen);
        Assert.assertTrue("El elemento no existe", paginaResumen.isDisplayed());
    }

}
