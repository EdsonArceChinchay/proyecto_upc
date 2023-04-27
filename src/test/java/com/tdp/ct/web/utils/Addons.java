package com.tdp.ct.web.utils;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.base.methods.WebDriverDom;
import com.tdp.ct.web.service.util.UtilWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.sql.SQLOutput;
import java.util.List;
import java.util.logging.Level;

public class Addons {


public static void esperaProgresiva(int reintentosMax, int segundosEspera, WebElement elemento){
        int contador = 1;
        //int reintentos = 6;
        boolean bOK = false;
        //int wait = 5;
        do{
        System.out.println("Reintento # " + contador);
        UtilWeb.waitForSeconds(segundosEspera*contador);
        try{
        String s = elemento.getText();
        bOK = true;
        System.out.println(s);
        }catch(Exception e){
        System.out.println("error Message: " + e.getMessage());
        System.out.println("error StackTrace: " + e.getStackTrace());
        }
        contador++;
        }
        while(bOK == false && contador < reintentosMax);
}

    public static void reintentaModalError(WebDriver driver, int reintentos, int segEspera, WebElement elGatillo, WebBase webBase, String xpathElOk) {
        int count = 1;
        boolean flag = false;
        boolean flag2 = false;

        while (count<=reintentos) {
            UtilWeb.waitForSeconds(segEspera);
            System.out.println("--------------- ingreso al try -----------------");

            Boolean isVisible = false;
            try {
                boolean elementoExistente;
                elementoExistente = driver.findElements(By.xpath(xpathElOk)).size() != 0;
                if (elementoExistente) {
                    isVisible = true;
                    /*WebElement elOk = driver.findElement(By.xpath(xpathElOk));
                    isVisible = elOk.isDisplayed();*/
                }

            } catch (NoSuchElementException e) {
                System.out.println("error del elemento Ok exeption try catch: NoSuchElementException");
            }

            System.out.println("continua con el flujo");

            if (!isVisible) {
                System.out.println("elemento Ok no se muestra");

                try {
                    boolean elementoExistente;
                    String xpathReintentar = "//*[contains(text(),'Reintentar')]";
                    elementoExistente = driver.findElements(By.xpath(xpathReintentar)).size() != 0;

                    if (elementoExistente) {
                        int total = driver.findElements(By.xpath(xpathReintentar)).size();
                        WebElement el;

                        if (total>1) {
                            el = driver.findElement(By.xpath("(//*[contains(text(),'Reintentar')])["+(total)+"]"));
                            /*List<WebElement> lista = driver.findElements(By.xpath(xpathReintentar+"/.."));
                            System.out.println("-----------");
                            el = null;
                            for (WebElement l: lista) {
                                el = l;
                                el = l.findElement(By.xpath(xpathReintentar));
                                webBase.js().scrollElementTop(el);
                                System.out.println(l);
                            }
                            System.out.println("-----------");*/
                        } else {
                            el = driver.findElement(By.xpath(xpathReintentar));
                        }

                        System.out.println("modal error encontrado");
                        flag = el.isDisplayed();

                        if (flag) {
                            el.click();
                            flag = false;
                            System.out.println("click a reintentar");

                            if (elGatillo!=null)
                                webBase.waitUntilElementIsVisible(elGatillo, 10).click();

                        } else {
                            System.out.println("Reintentar no se muestra");
                        }
                    } else {
                        System.out.println("No se encontro el modal error");
                    }

                } catch (Exception e) {
                    System.out.println("error del elemento Reintentar exeption try catch: " + e.getMessage());
                }

                try {
                    boolean elementoExistente;
                    String xpathEntendido = "//*[contains(text(),'Entendido')]";
                    elementoExistente = driver.findElements(By.xpath(xpathEntendido)).size() != 0;

                    if (elementoExistente) {
                        int total = driver.findElements(By.xpath(xpathEntendido)).size();
                        WebElement el;

                        if (total>1) {
                            el = driver.findElement(By.xpath("(//*[contains(text(),'Entendido')])["+(total)+"]"));
                        } else {
                            el = driver.findElement(By.xpath(xpathEntendido));
                        }

                        System.out.println("modal entendido encontrado");
                        flag2 = el.isDisplayed();

                        if (flag2) {
                            el.click();
                            flag2 = false;
                            System.out.println("click a entendido");

                            if (elGatillo!=null){
                                webBase.waitUntilElementIsVisible(elGatillo, 10).click();
                                System.out.println("");
                            }

                        }
                    } else {
                        System.out.println("No se encontro el modal entendido");
                    }

                } catch (Exception e) {
                    System.out.println("error del elemento entendido exeption try catch: " + e.getMessage());
                }

            } else {
                System.out.println("elemento Ok es visible");
                //count = reintentos;
                break;
            }
            System.out.println("--------------- fin -----------------");
            count++;
        }
    }

    public static void btnCerrarModalError(WebDriver driver, int reintentos, int segEspera, WebElement elGatillo, WebBase webBase, String xpathElOk) {
        int count = 1;
        boolean flag = false;

        while (count<=reintentos) {
            UtilWeb.waitForSeconds(segEspera);
            System.out.println("--------------- ingreso al try -----------------");

            Boolean isVisible = false;
            try {
                boolean elementoExistente;
                elementoExistente = driver.findElements(By.xpath(xpathElOk)).size() != 0;
                if (elementoExistente) {
                    isVisible = true;
                }

            } catch (NoSuchElementException e) {
                System.out.println("error del elemento Ok exeption try catch: NoSuchElementException");
            }

            System.out.println("continua con el flujo");

            if (!isVisible) {
                System.out.println("elemento Ok no se muestra");

                try {
                    boolean elementoExistente;
                    String xpathCerrarModalVisita = "//mat-dialog-container//img[@alt='icon-close']";
                    elementoExistente = driver.findElements(By.xpath("//mat-dialog-container//*[contains(text(),'No se puede agendar la visita técnica, se deben modificar los datos de la venta')]")).size() != 0;

                    if (elementoExistente) {
                        int total = driver.findElements(By.xpath(xpathCerrarModalVisita)).size();
                        WebElement btnCerrar;

                        if (total>1) {
                            btnCerrar = driver.findElement(By.xpath("(//mat-dialog-container//img[@alt='icon-close'])["+(total)+"]"));
                        } else {
                            btnCerrar = driver.findElement(By.xpath(xpathCerrarModalVisita));
                        }

                        System.out.println("modal visita encontrado");
                        flag = btnCerrar.isDisplayed();

                        if (flag) {
                            btnCerrar.click();
                            System.out.println("click a cerrar modal");

                            if (elGatillo!=null) {
                                webBase.waitUntilElementIsVisible(elGatillo, 10).click();
                                System.out.println("click al gatillo");
                            }

                        }
                    } else {
                        System.out.println("No se encontro el modal visita");
                    }

                } catch (Exception e) {
                    System.out.println("error del elemento Reintentar exeption try catch: " + e.getMessage());
                }

            } else {
                System.out.println("elemento Ok es visible");
                //count = reintentos;
                break;
            }
            System.out.println("--------------- fin -----------------");
            count++;
        }
    }

}