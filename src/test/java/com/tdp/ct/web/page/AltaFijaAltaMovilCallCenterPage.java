package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AltaFijaAltaMovilCallCenterPage extends WebBase {

    @FindBy(xpath = "(//div[@class='tdp-row'])[3]")
    protected WebElement btnConfirmarUbicacion;
    @FindBy(xpath = "(//button[@class='button_step'])")
    protected WebElement btnConfirmarDelivery;
    @FindBy(xpath = "(//button[contains(text(),'Confirmar')])[2]")
    protected WebElement btnConfirmar2;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnConsultarCobertura;
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    protected WebElement btnFinalizarRegistro;
    @FindBy(xpath = "(//img[@src='assets/images/icon_glove.svg'])[2]")
    protected WebElement oferta;


    public void manzana(String manzana){
        UtilWeb.waitForSeconds(3);
        WebElement Mz= find().getElementByXPath("(//div[@class='_col'])[1]/tdp-st-input-text");
        click(Mz);
        UtilWeb.waitForSeconds(3);
        type(Mz, manzana);

    }

    public void lote(String lote){
        UtilWeb.waitForSeconds(3);
        WebElement Lte= find().getElementByXPath("(//div[@class='_col'])[2]/tdp-st-input-text");
        click(Lte);
        type(Lte, lote);
    }

    public void tipoVivienda(String tipoVivienda){
        WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[2]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tipoVivienda)){
                UtilWeb.waitForSeconds(1);
                click(elements,30);
            }
        }
    }

    public void nombreVivienda(String nomVivienda){
        WebElement Nvivienda= find().getElementByXPath("(//div[@class='tdp-col-12'])[7]/tdp-st-input-text");
        click(Nvivienda);
        type(Nvivienda, nomVivienda);
    }

    public void piso(String piso){
        WebElement Npiso= find().getElementByXPath("(//div[@class='_col'])[3]/tdp-st-input-text");
        click(Npiso);
        type(Npiso, piso);
    }

    public void interior(String inte){
        WebElement NInterior= find().getElementByXPath("(//div[@class='_col'])[4]/tdp-st-input-text");
        click(NInterior);
        type(NInterior, inte);
    }

    public void tipoConjuntoHabitacional(String tipoConjunto){
        WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[3]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(2);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tipoConjunto)){
                UtilWeb.waitForSeconds(2);
                click(elements,30);
            }
        }
    }

    public void conjuntoHabitacional(String hab){
        WebElement ConjHab= find().getElementByXPath("(//div[@class='tdp-col-12'])[9]/tdp-st-input-text");
        click(ConjHab);
        type(ConjHab, hab);
    }
    public void btnConsultarCobertura(){
        UtilWeb.waitForSeconds(10);
        click(btnConsultarCobertura,10);
        UtilWeb.waitForSeconds(20);
    }

    public void btnConfirmarUbicacion(){
        click(btnConfirmarUbicacion,10);
        UtilWeb.waitForSeconds(5);
    }
    public void tipoEntrega(String tipEntrega){
        WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[1]");
        click(listElementPLan);
        UtilWeb.waitForSeconds(1);
        SearchContext contexPlan=sh().getContext(listElementPLan);
        List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
        for(WebElement elements:lista){
            System.out.println(elements.getText());
            if(elements.getText().equals(tipEntrega)){
                UtilWeb.waitForSeconds(1);
                click(elements,30);
            }
        }
        UtilWeb.waitForSeconds(1);
    }

    public void txtTelefono(String telefono){
        UtilWeb.waitForSeconds(10);
        WebElement txtTel= find().getElementByXPath("(//div[@class='tdp-col-12'])[2]/tdp-st-input-text");
        click(txtTel);
        type(txtTel, telefono);
    }

    public void txtInstrucciones(String instrucciones){
        UtilWeb.waitForSeconds(4);
        WebElement txtInstr= find().getElementByXPath("(//div[@class='tdp-col-12'])[3]/tdp-st-input-text");
        click(txtInstr);
        type(txtInstr, instrucciones);
    }

    public void btnConfirmarDelivery(){
        UtilWeb.waitForSeconds(4);
        click(btnConfirmarDelivery,5);
        UtilWeb.waitForSeconds(10);
    }

    public void tipoPago(String tipoPago){
            WebElement listElementPLan=find().getElementByXPath("(//tdp-st-select)[3]");
            click(listElementPLan);
            UtilWeb.waitForSeconds(1);
            SearchContext contexPlan=sh().getContext(listElementPLan);
            List<WebElement>lista= contexPlan.findElements(By.className("mdc-list-item"));
            for(WebElement elements:lista){
                System.out.println(elements.getText());
                if(elements.getText().equals(tipoPago)){
                    UtilWeb.waitForSeconds(1);
                    click(elements,30);
                }
            }
    }

    public void correo(String correo){

        UtilWeb.waitForSeconds(5);
        WebElement correoElectronico= find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[1]/tdp-st-input-text");
        js().scrollElementTop(correoElectronico);
        //correoElectronico.clear();
        click(correoElectronico);
        type(correoElectronico, correo);
        UtilWeb.waitForSeconds(1);
    }

    public void confirmarCorreo(String correo){
        UtilWeb.waitForSeconds(5);
        WebElement correoElectronico= find().getElementByXPath("(//div[@class='cont-input-icon mb-20 tdp-col-lg-7 tdp-col-12'])[2]/tdp-st-input-text");
        js().scrollElementTop(correoElectronico);
        //correoElectronico.clear();
        click(correoElectronico);
        type(correoElectronico, correo);
        UtilWeb.waitForSeconds(1);
    }


    public void btnConfirmar2(){
        click(btnConfirmar2,5);
        UtilWeb.waitForSeconds(4);
    }
    public void btnFinalizarRegistro(){
        click(btnFinalizarRegistro,5);
    }

    public void oferta(){
        click(oferta,30);
    }

}
