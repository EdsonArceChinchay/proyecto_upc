package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class CheckoutPage extends WebBase {

    @FindBy(xpath= "//*[contains(text(),'Ver detalle del pedido') or contains(@class,'detalle_sub')]")
    protected WebElement btnDetallePedido;
    @FindBy(xpath = "//app-root/app-success/div[2]/div[3]")
    protected WebElement scrollorden;

    public void ValidoQuePresenteDetallePedido(String service) {
        WebElement serviceText = find().getElementByXPath("//*[contains(text(),'"+service.trim()+"')]");
        js().scrollElementTop(serviceText);
    }

    public void clickenVerDetalleDelPedido() {
        js().scrollElementTop(scrollorden);
        esperaProgresiva(driver(),3,5,btnDetallePedido);
        js().scrollElementTop(btnDetallePedido);
        click(btnDetallePedido);
    }
}
