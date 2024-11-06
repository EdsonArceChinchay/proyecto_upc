package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Utility extends JDBCBase {

    /**
     * Obtiene la cantidad total de filas regristradas en la tabla
     * @param schemaTable
     * @return
     */
    public Integer countRow(String schemaTable) {
        var query = "SELECT COUNT(*) FROM " + schemaTable;
        queryLog(query);
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    /**
     * Valida si una tabla existe
     * @param schemaPattern
     * @param table
     * @return
     */
    public boolean isTableExist(String schemaPattern, String table) {
        boolean existTable = false;
        try (ResultSet tables = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection()
                .getMetaData().getTables(null, schemaPattern, table, null);) {
            existTable = tables.next();
            Logger.getLogger(Utility.class.getName()).log(Level.INFO,String.format("Table exist %s",existTable));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existTable;
    }


}
