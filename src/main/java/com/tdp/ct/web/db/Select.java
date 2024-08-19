package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Select extends JDBCBase {

    private static final String SELECT_QUERY = "SELECT %s FROM %s";
    private static final String SELECT_WITH_CONDITION_QUERY = "SELECT %s FROM %s %s";

    /**
     * Selecciona y obtiene uno o más registros de una tabla sin una condicion
     * @param columnsName
     * @param schemaAndTableName
     * @return
     */
    public List<Map<String, Object>> selectDataAsListMaps(String columnsName, String schemaAndTableName) {
        String query = String.format(SELECT_QUERY, columnsName, schemaAndTableName);
        queryLog(query);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Result >>> {0}", result);
        return result;
    }

    /**
     * Selecciona y obtiene uno o más registros de una tabla basado en un condicion
     * @param columnsName
     * @param schemaAndTableName
     * @param condition
     * @return
     */
    public List<Map<String, Object>> selectDataAsListMaps(String columnsName, String schemaAndTableName, String condition) {
        String query = String.format(SELECT_WITH_CONDITION_QUERY, columnsName, schemaAndTableName, condition);
        queryLog(query);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Result >>> {0}", result);
        return result;
    }

    /**
     * Obtiene un unico registro de una tabla basado en un condicion
     * @param columnsName
     * @param schemaAndTableName
     * @param condition
     * @return
     */
    public Map<String, Object> selectDataAsMap(String columnsName, String schemaAndTableName, String condition) {
        String query = String.format(SELECT_WITH_CONDITION_QUERY, columnsName, schemaAndTableName, condition);
        queryLog(query);
        Map<String, Object> result = jdbcTemplate.queryForMap(query);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Result >>> {0}", result);
        return result;
    }

//    public String selectDataAsString(String schemaTable, String columns, String condition) {
//        var query = SELECT + columns + FROM + schemaTable + " " + condition;
//        queryLog(query);
//        return jdbcTemplate.queryForObject(query, String.class);
//    }
//
//    public Integer selectDataAsInteger(String schemaTable, String columns, String condition) {
//        var query = SELECT + columns + FROM + schemaTable + " " + condition;
//        queryLog(query);
//        return jdbcTemplate.queryForObject(query, Integer.class);
//    }
//
//    public Boolean selectDataAsBoolean(String schemaTable, String columns, String condition) {
//        var query = SELECT + columns + FROM + schemaTable + " " + condition;
//        queryLog(query);
//        return jdbcTemplate.queryForObject(query, Boolean.class);
//    }
//
//    public Double selectDataAsDouble(String schemaTable, String columns, String condition) {
//        var query = SELECT + columns + FROM + schemaTable + " " + condition;
//        queryLog(query);
//        return jdbcTemplate.queryForObject(query, Double.class);
//    }
//
//    public Object selectDataAsObject(String schemaTable, String columns, String condition) {
//        var query = SELECT + columns + FROM + schemaTable + " " + condition;
//        queryLog(query);
//        return jdbcTemplate.queryForObject(query, Object.class);
//    }

}