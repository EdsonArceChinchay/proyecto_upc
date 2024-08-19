package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Update extends JDBCBase{

    /**
     * Actualiza una fila o registro de una tabla basado en una condicion
     * @param schemaAndTableName
     * @param valuesToUpdate
     * @param condition
     * @return
     */
    public boolean updateValue(String schemaAndTableName, String valuesToUpdate, String condition) {
        var query = "UPDATE " + schemaAndTableName + " SET " + valuesToUpdate + " " + condition;
        queryLog(query);
        return update(query);
    }

    private boolean update(String query) {
        int rows = jdbcTemplate.update(query);
        if (rows > 0) {
            Logger.getLogger(Update.class.getName()).log(Level.INFO,"Una fila fue actualizada.");
            return true;
        } else {
            Logger.getLogger(Update.class.getName()).log(Level.INFO,"Ocurrió un error al actualizar una fila.");
            return false;
        }
    }
}
