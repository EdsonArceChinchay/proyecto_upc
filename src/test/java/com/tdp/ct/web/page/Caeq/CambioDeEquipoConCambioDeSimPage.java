package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CambioDeEquipoConCambioDeSimPage extends WebBase {

    @FindBy(xpath = "//div/form/div[1]/div[3]/div/div[1]")
    protected WebElement btnAlContado;

    @FindBy (css = "div.actions-button > div:nth-child(2) > tdp-st-button")
    protected WebElement btnCambiarChip;

    @FindBy (xpath = "//button[contains(text(),'Cambio de chip')]")
    protected WebElement btnCambiodeChip;

    @FindBy (xpath = "//*[contains(text(),'CONTINUAR')]")
    protected WebElement btnClienteExonerado;

    public void seleccionoTipoPagoAlContado() {
        Addons.esperaProgresiva(driver(), 3, 5, btnAlContado);
        Addons.revisarModalError(driver());
        //waitUntilElementIsVisible(btnAlContado,10);
        js().scrollElementTop(btnAlContado);
        click(btnAlContado);
    }

    public void SeleccionarBotonCambiarChip() {
        //waitUntilElementIsVisible(btnCambiarChip,10);
        Addons.esperaProgresiva(driver(), 3, 5, btnCambiarChip);
        js().scrollElementTop(btnCambiarChip);
        click(btnCambiarChip);
    }

    public void seleccionoelbotonCambiodeChip() {
        //waitUntilElementIsVisible(btnCambiodeChip,20);
        Addons.esperaProgresiva(driver(), 3, 5, btnCambiodeChip);
        js().scrollElementTop(btnCambiodeChip);
        click(btnCambiodeChip);
    }
    public void cierroPopUpDeClienteExonerado(){
        Addons.esperaProgresiva(driver(), 3, 5, btnClienteExonerado);
        try {
            if (btnClienteExonerado.isDisplayed()) {
                System.out.println("Cierre Nuevo Popup....");
                click(btnClienteExonerado);
            } else {
                System.out.println("No existe Popup....");
            }
        } catch (Exception e) {
            System.out.println("No hay ningún popup.....");
        }

    }

}
