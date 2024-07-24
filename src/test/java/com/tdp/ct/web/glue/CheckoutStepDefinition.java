package com.tdp.ct.web.glue;

import com.tdp.ct.web.step.CheckoutStep;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutStepDefinition {

    @Autowired
    private CheckoutStep checkoutStep;

    @Y("doy click en ver detalle del pedido")
    public void doyClickenVerDetalleDelPedido() {
        checkoutStep.doyClickenVerDetalleDelPedido();
    }

    @Y("valido que se muestre el detalle del pedido de {string}")
    public void validoQueSeMuestreElDetalleDelPedido(String service) {
        checkoutStep.ValidoQuePresenteDetallePedido(service);
    }
}
