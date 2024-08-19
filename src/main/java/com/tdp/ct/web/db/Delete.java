package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Delete extends JDBCBase {

    /**
     * Elimina todos las filas o registros de la tabla
     * @param schemaAndTableName
     * @return
     */
    public boolean deleteAllData(String schemaAndTableName) {
        var query = "DELETE FROM " + schemaAndTableName;
        queryLog(query);
        return update(query);
    }

    /**
     * Elimina las filas o registros de la tabla basado en una condicion
     * @param schemaAndTableName
     * @return
     */
    public boolean deleteRowData(String schemaAndTableName, String condition) {
        var query = "DELETE FROM " + schemaAndTableName + " " + condition;
        queryLog(query);
        return update(query);
    }

    private boolean update(String query) {
        int rows = jdbcTemplate.update(query);
        if (rows > 0) {
            Logger.getLogger(Delete.class.getName()).log(Level.INFO,"Una fila fue eliminada.");
            return true;
        } else {
            Logger.getLogger(Delete.class.getName()).log(Level.INFO,"Ocurrió un error al eliminar una fila.");
            return false;
        }
    }
}
