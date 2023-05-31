package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CambioDeEquipoConCambioDeSimPage extends WebBase {

    @FindBy(xpath = "//div/form/div[1]/div[3]/div/div[1]")
    protected WebElement btnAlContado;

    @FindBy (css = "div.actions-button > div:nth-child(2) > tdp-st-button")
    protected WebElement btnCambiarChip;

    @FindBy (xpath = "//button[contains(text(),'Cambio de chip')]")
    protected WebElement btnCambiodeChip;

    public void seleccionoTipoPagoAlContado() {
        waitUntilElementIsVisible(btnAlContado,20);
        click(btnAlContado);
    }

    public void SeleccionarBotonCambiarChip() {
        waitUntilElementIsVisible(btnCambiarChip,20);
        click(btnCambiarChip);
    }

    public void seleccionoelbotonCambiodeChip() {
        waitUntilElementIsVisible(btnCambiarChip,20);
        click(btnCambiodeChip);
    }

}
