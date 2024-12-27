package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;
import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.WebUtils.validateAndTypeWithAndWithoutShadowRoot;
import static com.tdp.ct.web.utils.WebUtils.validateIsDisplayed;

public class AppointmentPage extends WebBase {

    @FindBy(css = "button[class=\"btnStart\"]")
    protected WebElement btnStart;
    @FindBy(css = "app-agenda-page .info-user, app-agenda-mt .info-user")
    protected WebElement labelAppointment;
    @FindBy(css = "button[type=\"submit\"]")
    protected WebElement btnConfirm;
    @FindBy(css = ".cont-hours div, .contHours div")
    protected WebElement btnActiveHours;
    @FindBy(xpath = "//mat-dialog-container//img[@alt='icon-close']")
    protected WebElement btnClose;
    @FindBy(css = "button[class=\"buttonG\"]")
    protected WebElement btnConfirm2;
    @FindBy(css = "tdp-st-input-text[formcontrolname='contactName']")
    protected WebElement inputName;
    @FindBy(css = "tdp-st-input-text[formcontrolname='contactLastName']")
    protected WebElement inputLastName;
    @FindBy(css = "tdp-st-input-text[formcontrolname='contactNumber1']")
    protected WebElement inputContactNumber;
    @FindBy(css = "tdp-st-input-text[formcontrolname='contactNumber2']")
    protected WebElement inputContactNumber2;
    @FindBy(xpath = "//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")
    protected WebElement modalError;

    public void clicEnUnTurnoAgendamiento() {
        UtilWeb.waitForSeconds(2);
        waitUntilElementIsClickable(btnActiveHours, 10);
        click(btnActiveHours);
        logInfo("Haciendo clic a en turno agendamiento");
        UtilWeb.waitForSeconds(4);
    }

    public boolean validarPantallaAgendamiento() {
        revisarModalError(driver());
        clickBtnCerrarModalError(btnStart);
        esperaProgresiva(driver(), 7, 8, labelAppointment);
        clickBtnCerrarModalError(btnStart);
        revisarModalError(driver());
        boolean existe = labelAppointment.isDisplayed();
        logInfo("Existe titulo >>> {0}", labelAppointment.getText());
        return existe;
    }

    public void typeContactNumber(String contact) {
        contact = (contact == null) ? "956425985" : contact;
        revisarModalError(driver());
        js().scrollElementTop(btnConfirm);
        validateCalendarAndSelectedDay();
        validateAndSelectedSchedule();
        validateAndTypeWithAndWithoutShadowRoot("contact number 1", inputContactNumber, contact);
        UtilWeb.waitForSeconds(2);
    }

    public void ingresarDatosAgendamientoParaRUC() {
        validateCalendarAndSelectedDay();
        validateAndSelectedSchedule();
        js().scrollElementTop(btnConfirm);
        validateAndTypeWithAndWithoutShadowRoot("contact name", inputName, "Edson");
        validateAndTypeWithAndWithoutShadowRoot("contact lastName", inputLastName, "Arce");
        validateAndTypeWithAndWithoutShadowRoot("contact number 1", inputContactNumber, "976709704");
        validateAndTypeWithAndWithoutShadowRoot("contact number 2", inputContactNumber2, "906701238");
    }

    public void botonConfirmarAgendamiento() {
        revisarModalError(driver());
        js().scrollElementTop(btnConfirm);
        boolean elementoExistente = !driver().findElements(By.cssSelector(".cont-hours, .contHours")).isEmpty();
        if (elementoExistente) {
            logInfo("Appointment with calendar and hours");
            click(btnConfirm);
            UtilWeb.waitForSeconds(1);
            click(btnConfirm2);
            logInfo("Second Confirm");
        } else {
            logInfo("Appointment SLA");
            click(btnConfirm);
        }
        UtilWeb.waitForSeconds(5);
        revisarModalError(driver());
    }

    public void scrollToViewAgendamiento() {
        js().scrollElementTop(find().getElementByCss("div.return"));
    }

    public void clickBtnCerrarModalError(WebElement repeatedMethod) {
        int contador = 0, i = 0;
        int retryMax = 3;
        int waitSeconds = 5;
        boolean bOK = false;

        UtilWeb.waitForSeconds(1);
        do {
            UtilWeb.waitForSeconds(waitSeconds * contador);
            if (validateIsDisplayed(modalError)) {
                click(btnClose);
                logInfo("Dio click en cerrar - modal error Timeslot " + i);
                UtilWeb.waitForSeconds(5);
                click(repeatedMethod);
                bOK = true;
            } else {
                logInfo("No se encontro el modal error Timeslot");
            }
            if (validateIsDisplayed(labelAppointment)) {
                logInfo("You are on appointment");
                break;
            }
            contador++;
        } while (!bOK && contador < retryMax);
    }

    @FindBy(xpath = "//*[@class='fontSize16 colorDefault' and contains(text(),'Fecha')]")
    protected WebElement instalationDate;

    public void validateCalendarAndSelectedDay() {
        boolean hasListDays;
        hasListDays = !driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-selected')]//following::button[@class='mat-calendar-body-cell']")).isEmpty();
        if (hasListDays) {
            logInfo("Yes, it has a calendar");
            List<WebElement> listDays = driver().findElements(By.xpath("//*[contains(@class,'mat-calendar-body-selected')]//following::button[@class='mat-calendar-body-cell']"));
            for (WebElement list : listDays) {
                if (!instalationDate.getText().contains(" de ")) {
                    click(list);
                    logInfo("Select first day " + list.getText());
                    break;
                }
            }
        }
    }

    public void validateAndSelectedSchedule() {
        boolean hasListHours = !driver().findElements(By.cssSelector(".cont-hours, .contHours")).isEmpty();
        if (hasListHours) {
            logInfo("Yes, it has a schedule");
            List<WebElement> listHours = driver().findElements(By.cssSelector(".cont-hours div, .contHours div"));
            click(listHours.get(0));
            logInfo("Select first schedule" + listHours.get(0).getText());
        }
    }

}
