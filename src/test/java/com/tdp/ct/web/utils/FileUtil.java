package com.tdp.ct.web.utils;

import com.tdp.ct.web.service.util.UtilWeb;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

@Component
public class FileUtil {

    public void createDirectory(String folderPath) {
        Path path = Paths.get(folderPath).toAbsolutePath(); // Obtener la ruta absoluta
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Directorio creado en: " + path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            UtilWeb.logger(this.getClass()).log(Level.INFO, "El directorio ya existe en: " + path.toString());

        }
    }

}
