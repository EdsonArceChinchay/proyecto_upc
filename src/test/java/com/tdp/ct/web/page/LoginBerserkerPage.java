package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.Addons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.Addons.esperaProgresiva;

public class LoginBerserkerPage extends WebBase {

    //FindBy(css = ".welcome-container .content .title-desc button")
    @FindBy(xpath = "//button[text()='Iniciar sesion']")
    protected WebElement btnIniciarSesion;

    @FindBy(id = "procedencia_usuario")
    protected WebElement tipoUsuario;

    @FindBy(id = "signInName")
    protected WebElement inputNameUsuario;

    @FindBy(id = "password")
    protected WebElement inputPassword;

    @FindBy(id = "continue")
    protected WebElement btnContinuar;

    @FindBy(name = "btnpruebavalidate")
    protected WebElement btnContinuarProd;

    @FindBy(css = ".message-welcome span")
    protected WebElement msgHome;

    @FindBy(css = ".tienda-row span")
    protected WebElement tiendaLabel;

    @FindBy(css = ".error.itemLevel.show")
    protected WebElement msgError;

    public String getMsgError() {
        return msgError.getText().trim().toLowerCase();
    }

    @FindBy(id = "claimVerificationServerError")
    protected WebElement msgErrorCredential;

    @FindBy(xpath = "//img[@src='assets/images/login-icono.svg']")
    protected WebElement iconAsesor;

    @FindBy(xpath = "(//*[contains(text(),'Cerrar s')])[1]")
    protected WebElement btnCerrar;

    @FindBy(xpath = "//*[@class='atras']")
    protected WebElement btnAtras;

    @FindBy(css = ".title span")
    protected WebElement nombrePlan;

    @FindBy(xpath = "/html/body/app-root/app-alta-fija-page/app-resumen-page/div/div[4]/div/div[1]/app-summary-detail/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/span[2]")
    protected WebElement velocidadBB;

    @FindBy(xpath = "/html/body/app-root/app-alta-fija-page/app-resumen-page/div/div[5]/div[1]/div/div[1]/div[3]")
    protected WebElement precDescBB;

    @FindBy(css = "div.tdp-row.textBlue")
    protected WebElement svaTV;

    @FindBy(xpath = "/html/body/app-root/app-alta-fija-page/app-resumen-page/div/div[5]/div[1]/div/div[1]/div[3]")
    protected WebElement precDescTV;

    public String getMsgErrorCredential() {
        return msgErrorCredential.getText().trim().toLowerCase();
    }

    public void clickBtnIniciarSesion() {
        //waitUntilElementIsVisible(btnIniciarSesion, 10);
        Addons.esperaProgresiva(driver(),10,5,btnIniciarSesion);
        click(btnIniciarSesion);
        Addons.esperaProgresiva(driver(),10,5,tipoUsuario);
        //waitUntilElementIsVisible(tipoUsuario, 5);
    }

    public void selectTipoUsuario(String usuario) {
        esperaProgresiva(driver(),3,5,tipoUsuario);
        Select usuarioSelect = new Select(tipoUsuario);
        usuarioSelect.selectByVisibleText(usuario);
        UtilWeb.waitForSeconds(1);
    }

    public void writeUserName(String name) {
        type(inputNameUsuario, name);
        UtilWeb.waitForSeconds(1);
    }

    public void writePassword(String pass) {
        type(inputPassword, pass);
        UtilWeb.waitForSeconds(1);
    }

    public void clickBtnContinuarHaciaHome() {

        if(Addons.esEntornoProductivo()){
            esperaProgresiva(driver(), 3, 5, btnContinuarProd);
            click(btnContinuarProd);
        }else{
            esperaProgresiva(driver(), 3, 5, btnContinuar);
            click(btnContinuar);
        }
        UtilWeb.waitForSeconds(2);
        esperaProgresiva(driver(),3,6,msgHome);
    }

    public void clickBtnContinuar() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgError, 30);
    }

    public void clickBtnContinuarToLogin() {
        click(btnContinuar);
        waitUntilElementIsVisible(msgErrorCredential, 30);
    }

    public void validarMsgHome(String msg) {
        Addons.revisarModalError(driver());
        String expectedMsg = msg.trim().toLowerCase();
        String actualMsg = msgHome.getText().trim().toLowerCase();
        Assertions.assertTrue(actualMsg.contains(expectedMsg), "El mensaje obtenido: " + actualMsg + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarTiendaAsesor(String tienda) {
        String expectedTienda = tienda.trim().toLowerCase();
        String actualTienda = tiendaLabel.getText().trim().toLowerCase();
        Assertions.assertTrue(actualTienda.contains(expectedTienda), "La tienda obtenida: " + actualTienda + ", no coincide con lo esperado " + expectedTienda);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMensajeError(String msgError) {
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgError().contains(expectedMsg), "El mensaje obtenido: " + getMsgError() + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void validarMsgIncorrectCredential(String msgError) {
        String expectedMsg = msgError.trim().toLowerCase();
        Assertions.assertTrue(getMsgErrorCredential().contains(expectedMsg), "El mensaje obtenido: " + getMsgErrorCredential() + ", no coincide con lo esperado " + expectedMsg);
        UtilWeb.waitForSeconds(1);
    }

    public void clickIconoAsesor() {
        waitUntilElementIsVisible(iconAsesor, 10).click();

    }

    public void clickBtnCerrarSesion() {
        waitUntilElementIsVisible(btnCerrar, 10).click();
        UtilWeb.waitForSeconds(2);
    }

    public void clickBtnAtras() {
        waitUntilElementIsVisible(btnAtras, 10).click();
    }


    public void validarNomPlan(String nomPlan) {
        Addons.revisarModalError(driver());
        String expectedNomPlan = nomPlan.trim().toLowerCase();
        String actualNomPlan = nombrePlan.getText().trim().toLowerCase();
        Assertions.assertTrue(actualNomPlan.contains(expectedNomPlan), "El plan obtenido: " + actualNomPlan + ", no coincide con lo esperado " + expectedNomPlan);
        UtilWeb.waitForSeconds(1);


    }

    public void validarVelocidadInternet(String mbpsBB) {
        Addons.revisarModalError(driver());
        String expectedVelocInternet = mbpsBB.trim().toLowerCase();
        String actualVelocInternet = velocidadBB.getText().trim().toLowerCase();
        Assertions.assertTrue(actualVelocInternet.contains(expectedVelocInternet), "La velocidad de Internet obtenida: " + actualVelocInternet + ", no coincide con lo esperado " + expectedVelocInternet);
        UtilWeb.waitForSeconds(1);

    }

    public void validarPrecioDescuento(String precDesc) {
        Addons.revisarModalError(driver());
        String expectedPrecioDesc = precDesc.trim().toLowerCase();
        String actualPrecioDesc = precDescBB.getText().trim().toLowerCase();
        Assertions.assertTrue(actualPrecioDesc.contains(expectedPrecioDesc), "EL precio de descuento del componente Internet: " + actualPrecioDesc + ", no coincide con lo esperado " + expectedPrecioDesc);
        UtilWeb.waitForSeconds(1);

    }

    public void validarnombreSVAcontenido(String nomsvaTV) {
        Addons.revisarModalError(driver());
        String expectedNomSVAtv = nomsvaTV.trim().toLowerCase();
        String actualNomSVAtv = svaTV.getText().trim().toLowerCase();
        Assertions.assertTrue(actualNomSVAtv.contains(expectedNomSVAtv), "El SVA del BO obtenida: " + actualNomSVAtv + ", no coincide con lo esperado " + expectedNomSVAtv);

    }

    public void validarPrecioDescuentoTV(String pDescTV) {
        Addons.revisarModalError(driver());
        String expectedPrecioDescTV = pDescTV.trim().toLowerCase();
        String actualPrecioDescTV = precDescTV.getText().trim().toLowerCase();
        Assertions.assertTrue(actualPrecioDescTV.contains(expectedPrecioDescTV), "El precio de descuento del componente TV: " + actualPrecioDescTV + ", no coincide con lo esperado " + expectedPrecioDescTV);
        UtilWeb.waitForSeconds(1);
    }
}
