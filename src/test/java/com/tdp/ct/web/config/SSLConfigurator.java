package com.tdp.ct.web.config;

import com.tdp.ct.web.service.util.UtilWeb;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.logging.Level;

import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

@Component
public class SSLConfigurator {

    public void configureSSL() {
        String password = getValueConfig("config", "credential.certificate.password");
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("src/test/resources/certificado/apim-client-certificate.pfx"), password.toCharArray());
            SSLSocketFactory clientAuthFactory = new SSLSocketFactory(keyStore, password);
            RestAssured.config = RestAssured.config()
                    .sslConfig(new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames());
        } catch (Exception e) {
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error loading key store: " + e.getMessage());
        }
    }
}