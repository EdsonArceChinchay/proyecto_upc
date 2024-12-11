package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;
import static com.tdp.ct.web.utils.WebUtils.validateAndTypeWithAndWithoutShadowRoot;

public class AppointmentPage extends WebBase {

    @FindBy(css = "button[class=\"btnStart\"]")
    protected WebElement btnStart;
    @FindBy(xpath = "//span[contains(text(),'Agendamiento')]")
    protected WebElement labelAppointment;
    @FindBy(css = "button[type=\"submit\"]")
    protected WebElement btnConfirm;
    @FindBy(css = "div[class='boxHour active']")
    protected WebElement buttonTurnoAgendamientoActivo;
    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnCerrar;
    @FindBy(css = "button[class=\"buttonG\"]")
    protected WebElement btnConfirm2;

    public void clicEnUnTurnoAgendamiento() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsClickable(buttonTurnoAgendamientoActivo, 10);
        click(buttonTurnoAgendamientoActivo);
        logInfo("Haciendo clic a en turno agendamiento");
        UtilWeb.waitForSeconds(4);
    }

    public boolean validarPantallaAgendamiento() {
        revisarModalError(driver());
        clickBtnCerrarModalError(btnStart);
        clickBtnCerrarModalError(btnStart);
        esperaProgresiva(driver(), 6, 8, labelAppointment);
        revisarModalError(driver());
        boolean existe = labelAppointment.isDisplayed();
        logInfo("Existe titulo >>> {0}", labelAppointment.getText());
        return existe;
    }

    public void ingresarContacto(String contact) {
        js().scrollElementTop(btnConfirm);
        WebElement rootInput = find().getElementByXPath("tdp-st-input-text[formcontrolname='contactNumber1']");
        validateAndTypeWithAndWithoutShadowRoot("contact", rootInput, contact);
        UtilWeb.waitForSeconds(2);
    }

    public void datosAgendamiento() {
        revisarModalError(driver());
//         Calendario
        boolean elementoExistenteDias;
        esperaProgresiva(driver(), 3, 5, btnConfirm);
        elementoExistenteDias = !driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']")).isEmpty();
        if (elementoExistenteDias) {
            logInfo("elementoExistenteDias: true");
            List<WebElement> listaDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']"));
            click(listaDias.get(0));
            logInfo("listaDias: " + listaDias.get(0).getText());
        }
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='contHours']")).isEmpty();
        if (elementoExistente) {
            logInfo("paso aqui 1");
            List<WebElement> listaHorario = driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
            click(listaHorario.get(0));
            logInfo("paso aqui 2 " + listaHorario.get(0).getText());
        }
        js().scrollElementTop(btnConfirm);
        WebElement contactNumber1 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        validateAndTypeWithAndWithoutShadowRoot("contact", contactNumber1, "956425985");
        UtilWeb.waitForSeconds(2);
    }

    public void botonConfirmarAgendamiento() {
        revisarModalError(driver());
        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='contHours']")).isEmpty();
        if (elementoExistente) {
            logInfo("paso aqui 1");
            click(btnConfirm);
            UtilWeb.waitForSeconds(1);
            click(btnConfirm2);
            logInfo("paso aqui 2");
        } else {
            click(btnConfirm);
            logInfo("paso aqui 3");
        }
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
    }

    public void ingresarDatosAgendamientoParaRUC() {
        driver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean elementoExistenteDias;
        elementoExistenteDias = !driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']")).isEmpty();
        if (elementoExistenteDias) {
            logInfo("paso aqui 1");
            List<WebElement> listaDias = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-today')]//following::div[@class='mat-calendar-body-cell-content']"));
            click(listaDias.get(0));
            logInfo("paso aqui 2 " + listaDias.get(0).getText());
        }

        boolean elementoExistente;
        elementoExistente = !driver().findElements(By.xpath("//div[@class='contHours']")).isEmpty();
        if (elementoExistente) {
            logInfo("paso aqui 1");
            List<WebElement> listaHorario = driver().findElements(By.xpath("(//div[@class='contHours'])/div"));
            click(listaHorario.get(0));
            logInfo("paso aqui 2 " + listaHorario.get(0).getText());
        }
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        js().scrollElementTop(btnConfirm);
        WebElement rootInput = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(1) > tdp-st-input-text");
        WebElement rootInput1 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(2) > tdp-st-input-text");
        WebElement rootInput2 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(3) > tdp-st-input-text");
        WebElement rootInput3 = find().getElementByCss("div.tdp-row.tdp-mb-3 > div:nth-child(5) > tdp-st-input-text");
        validateAndTypeWithAndWithoutShadowRoot("contact name", rootInput, "Edson");
        validateAndTypeWithAndWithoutShadowRoot("contact lastName", rootInput1, "Arce");
        validateAndTypeWithAndWithoutShadowRoot("contact number 1", rootInput2, "976709704");
        validateAndTypeWithAndWithoutShadowRoot("contact number 2", rootInput3, "906701238");
    }

    public void scrollToViewAgendamiento() {
        js().scrollElementTop(find().getElementByCss("div.return"));
    }

    public void clickBtnCerrarModalError(WebElement metodoRepedito) {
        int contador = 0, i = 0;
        int reintentosMax = 3;
        int segundosEspera = 5;
        boolean bOK = false;

        UtilWeb.waitForSeconds(1);
        do {
            UtilWeb.waitForSeconds(segundosEspera * contador);
            try {
                boolean elementoExistente;
                elementoExistente = !driver().findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")).isEmpty();
                if (elementoExistente) {
                    click(btnCerrar);
                    logInfo("Dio click en cerrar - modal error Timeslot " + i);
                    UtilWeb.waitForSeconds(5);
                    click(metodoRepedito);
                    bOK = true;
                } else {
                    logInfo("No se encontro el modal error Timeslot");
                }

            } catch (Exception e) {
                logSevere("ERROR", e.getMessage());
            }
            contador++;
        } while (!bOK && contador < reintentosMax);
    }

}
