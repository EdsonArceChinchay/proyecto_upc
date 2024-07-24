package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutStep {

    @Autowired
    private StepPages page;

    @ScreenShotAfter
    public void ValidoQuePresenteDetallePedido(String service) {
        page.checkoutPage().ValidoQuePresenteDetallePedido(service);
    }

    public void doyClickenVerDetalleDelPedido() {
        page.checkoutPage().clickenVerDetalleDelPedido();
    }
}
