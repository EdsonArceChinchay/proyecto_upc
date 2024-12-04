package com.tdp.ct.web.step;

import com.tdp.ct.web.page.StepPages;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotAfter;
import com.tdp.ct.web.service.aspect.evidence.ScreenShotBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.utils.LogUtils.logInfo;

@Component
public class OfferSVAStep {

    @Autowired
    StepPages page;

    @ScreenShotAfter
    public void validateScreenName(String name) {
        page.offerSVAPage().validateScreenName(name);
    }

    @ScreenShotBefore
    public void clickButtonSaveChanges() {
        page.offerSVAPage().clickButtonSaveChanges();
    }

    public void clickBackToSumary() {
        page.offerSVAPage().clickBackToSumary();
    }

    @ScreenShotAfter
    public void addSVADecoder(String sva) {

        String nameSVA = sva.trim().toUpperCase();

        page.offerSVAPage().scrollToTitle("DECODIFICADOR");

        switch (nameSVA) {
            case "PUNTO ADICIONAL SD":
            case "SD":
                page.offerSVAPage().addSVAIconButton("Punto Adicional SD");
                break;

            case "PUNTO ADICIONAL HD":
            case "HD":
                page.offerSVAPage().addSVAIconButton("Punto Adicional HD");
                break;

            case "PUNTO ADICIONAL HD DVR":
            case "HD DVR":
                page.offerSVAPage().addSVAIconButton("Punto Adicional HD DVR");
                break;

            case "PUNTO ADICIONAL ETHERNET UHD":
            case "UHD":
                page.offerSVAPage().addSVAIconButton("Punto Adicional ETHERNET UHD");
                break;

            default:
                logInfo("Decoder does not exist " + nameSVA);
                page.offerSVAPage().addSVAIconButton("Punto Adicional");

        }
    }

    @ScreenShotAfter
    public void addSVARepeater(String sva) {

        String nameSVA = sva.trim().toUpperCase();

        page.offerSVAPage().scrollToTitle("REPETIDOR");

        switch (nameSVA) {
            case "REPETIDOR WIFI PLUS VENTA":
            case "WIFI PLUS":
                page.offerSVAPage().addSVAIconButton("Repetidor WIFI PLUS Venta");
                break;

            case "REP. SMART WIFI VENTA":
            case "SMART WIFI":
                page.offerSVAPage().addSVAIconButton("REP. SMART WIFI Venta");
                break;

            default:
                logInfo("Repeater does not exist " + nameSVA);
                page.offerSVAPage().addSVAIconButton("WIFI");
        }

    }

    @ScreenShotAfter
    public void addSVABlocks(String sva) {

        String nameSVA = sva.trim().toUpperCase();

        page.offerSVAPage().scrollToTitle("BLOQUES");

        switch (nameSVA) {
            case "BLOQUE HOT PACK":
            case "HOT PACK":
                page.offerSVAPage().addSVACheckBox("Bloque Hot Pack");
                break;

            case "HBO":
                page.offerSVAPage().addSVACheckBox("HBO");
                break;

            case "BLOQUE ESTELAR":
            case "ESTELAR":
                page.offerSVAPage().addSVACheckBox("Bloque estelar");
                break;

            case "BLOQUE FULL HD":
            case "HD":
                page.offerSVAPage().addSVACheckBox("Bloque Full HD");
                break;

            default:
                logInfo("Blocks does not exist " + nameSVA);
                page.offerSVAPage().addSVACheckBox("Bloque");
        }
    }

    @ScreenShotAfter
    public void addSVAModem(String sva) {
        page.offerSVAPage().scrollToTitle("MÓDEM");
        page.offerSVAPage().addSVACheckBox("Mejora a Modem Premium MTA");

    }

    @ScreenShotAfter
    public void addSVAInternet(String nameSVA) {
        page.offerSVAPage().scrollToTitle("SVA INTERNET");
        page.offerSVAPage().addSVASelect("SVA INTERNET", nameSVA);
    }

    @ScreenShotAfter
    public void addSVALinea(String nameSVA) {
        page.offerSVAPage().scrollToTitle("SVA LÍNEA");
        page.offerSVAPage().addSVASelect("SVA LÍNEA", nameSVA);
    }

    @ScreenShotAfter
    public void addSVATvApp() {
        page.offerSVAPage().scrollToTitle("MOVISTAR TV APP");
        page.offerSVAPage().addSVACheckBox("Movistar Tv App Max");
    }
}
