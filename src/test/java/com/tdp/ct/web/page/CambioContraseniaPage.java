package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.stepdefinition.ManageScenario;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.tdp.ct.web.utils.Addons.revisarModalError;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

public class CambioContraseniaPage extends WebBase {
    @FindBy(xpath = "//button[contains(text(),'Cambio de contraseña')]")
    protected WebElement botonCambioDeContrasenia;

    @FindBy(xpath = "//button[contains(text(),'Cambiar contraseña')]")
    protected WebElement botonCambiarContrasenia;

    @FindBy(xpath = "//input[@placeholder='Ingrese contraseña actual']")
    protected WebElement inputContraseniaActual;

    @FindBy(xpath = "//input[@placeholder='Ingrese nueva contraseña']")
    protected WebElement inputContraseniaNueva;

    @FindBy(xpath = "//input[@placeholder='Confirmar contraseña nueva']")
    protected WebElement inputConfirmarContraseniaNueva;

    @FindBy(xpath = "//img[@src='assets/images/login-icono.svg']")
    protected WebElement labelCambioExitoso;

    @FindBy(xpath = "//button[contains(text(),'Entendido')]")
    protected WebElement botonEntendido;

    public void ingresarContraseniaActual(String clave) {
        String claveText = getValueConfig("config", "credential.user." + clave).trim();
        UtilWeb.waitForSeconds(5);
        type(inputContraseniaActual, claveText);
    }

    public void ingresarNuevaContrasenia(String clave) {
        type(inputContraseniaNueva, clave);
        UtilWeb.waitForSeconds(1);
    }

    public void confirmarNuevaCotrasenia(String clave) {
        type(inputConfirmarContraseniaNueva, clave);
        UtilWeb.waitForSeconds(1);
    }

    public void visualizarExitoEnCambioDeContrasenia() {
        waitUntilElementIsVisible(labelCambioExitoso, 120);
    }

    public void presionarBotonEntendido(ManageScenario manageScenario) {
        boolean estado;
        int contador = 0;
        do {
            try {
                waitUntilElementIsClickable(botonEntendido, 3);
                manageScenario.printFullView();
                click(botonEntendido);
                estado = false;
            } catch (TimeoutException e) {
                revisarModalError(driver());
                estado = true;
            }
            contador++;
        } while (estado && contador < 10);
        UtilWeb.waitForSeconds(2);
    }

    public void clickBotonCambioDeContrasenia() {
        waitUntilElementIsVisible(botonCambioDeContrasenia, 60);
        click(botonCambioDeContrasenia, 10);
    }

    public void clickBotonCambiarContrasenia() {
        click(botonCambiarContrasenia, 20);
    }

    public String readValues(String param) {
        String value = "";
        if (!param.isEmpty()) {
            File archiveCredentials = new File("src/test/resources/features/cross/login/credentials.txt");

            Map<String, String> parametros = new HashMap<>();
            try (Scanner scanner = new Scanner(archiveCredentials)) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] partes = linea.split("=");
                    if (partes.length == 2) {
                        String nombreParametro = partes[0].trim();
                        String valorParametro = partes[1].trim();
                        parametros.put(nombreParametro, valorParametro);
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
            value = (parametros.get(param) != null) ? parametros.get(param) : "";
        }
        return value;
    }
}
