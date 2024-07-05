package com.tdp.ct.web.page.Caeq;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.model.Customer;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.step.Portabilidad.ServiceTest;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class CaeqMasCaplMasCasiPage extends WebBase {
    @Autowired
    private ServiceTest serviceTest;

    @Autowired
    private Customer customer;
    @FindBy(xpath = "(//button[@class=\"btnCard\"])[2]")
    WebElement BtnCambiarPlan;

    public void clickBotonCambiarPlan() {
        UtilWeb.waitForSeconds(10);
        click(BtnCambiarPlan);
    }


    public void validoQueCAEQCAPLYCASIEnElResponseDelSales(String valueCAEQ, String valueCAPL, String valueCASI, Map<String, String> valuesMovil) {
        String getValueCAEQ, getValueCAPL, getValueCASI;

        getValueCAEQ = valuesMovil.get("CAEQ").trim().toUpperCase();
        getValueCAPL = valuesMovil.get("CAPL").trim().toUpperCase();
        getValueCASI = valuesMovil.get("CASI").trim().toUpperCase();

        valueCAEQ = valueCAEQ.trim().toUpperCase();
        valueCAPL = valueCAPL.trim().toUpperCase();
        valueCASI = valueCASI.trim().toUpperCase();

        Assertions.assertEquals(valueCAEQ, getValueCAEQ, "El valor de CAEQ esperado: " + valueCAEQ + " es diferente al obtenido: " + getValueCAEQ);
        Assertions.assertEquals(valueCAPL, getValueCAPL, "El valor de CAPL esperado: " + valueCAPL + " es diferente al obtenido: " + getValueCAPL);
        Assertions.assertEquals(valueCASI, getValueCASI, "El valor de CASI esperado: " + valueCASI + " es diferente al obtenido: " + getValueCASI);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CAEQ esperado: " + valueCAEQ + " y el obtenido es:" + getValueCAEQ + ", los valores son iguales "+valueCAEQ.equals(getValueCAEQ));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CAPL esperado: " + valueCAPL + " y el obtenido es:" + getValueCAPL + ", los valores son iguales "+valueCAPL.equals(getValueCAPL));
        UtilWeb.logger(this.getClass()).log(Level.INFO, "El valor de CASI esperado: " + valueCASI + " y el obtenido es:" + getValueCASI + ", los valores son iguales "+valueCASI.equals(getValueCASI));

    }
}
