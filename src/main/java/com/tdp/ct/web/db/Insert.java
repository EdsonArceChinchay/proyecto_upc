package com.tdp.ct.web.db;

import io.cucumber.datatable.DataTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Insert extends JDBCBase {


//    /**
//     * Inserta una nueva fila o registro en una tabla
//     * @param schemaTable
//     * @param insertColumns
//     * @param insertValues
//     * @return
//     */
//    public boolean insertNewRow(String schemaTable, List<String> insertColumns, List<Object> insertValues) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("INSERT INTO ").append(schemaTable).append(" (");
//        for (String column : insertColumns) {
//            stringBuilder.append(column).append(",");
//        }
//        stringBuilder.append(")").deleteCharAt(stringBuilder.length() - 2);
//
//        stringBuilder.append(" VALUES(");
//        for (Object objectValue : insertValues) {
//            if (objectValue.getClass().getTypeName().contains("String")) {
//                String value = (String) objectValue;
//                stringBuilder.append("'").append(value).append("'");
//            } else if (objectValue.getClass().getTypeName().contains("Integer")) {
//                int value = (Integer) objectValue;
//                stringBuilder.append(value);
//            }
//            stringBuilder.append(",");
//        }
//        String query = stringBuilder.append(");").deleteCharAt(stringBuilder.length() - 3).toString();
//        queryLog(query);
//        return update(query);
//    }

    /**
     * Inserta una nueva fila o registro en una tabla desde un Mapa de Listas
     *
     * @param schemaAndTableName
     * @param insertColumns
     * @param insertValues
     * @return
     */

    public boolean insertNewRow(String schemaAndTableName, String insertColumns, Map<Integer, List<Object>> insertValues) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(schemaAndTableName).append(" ").append(insertColumns);
        stringBuilder.append(" VALUES");
        for (int i = 0; i < insertValues.size(); i++) {
            if (i > 0)
                stringBuilder.append(",");
            stringBuilder.append("(");
            for (Object objectValue : insertValues.get(i)) {
                try {
                    if (objectValue.getClass().getTypeName().contains("String")) {
                        String value = (String) objectValue;
                        stringBuilder.append("'").append(value).append("'");
                    } else if (objectValue.getClass().getTypeName().contains("Integer")) {
                        int value = (Integer) objectValue;
                        stringBuilder.append(value);
                    }

                }catch(Exception e){
                    System.out.println("ERROR MSG: "  + e.getMessage());
                }
                stringBuilder.append(",");
            }
            stringBuilder.append(")").deleteCharAt(stringBuilder.length() - 2);
        }
        stringBuilder.append(";");
        String query = stringBuilder.toString();
        queryLog(query);
        return update(query);
    }

    public boolean insertNewRowNew(String schemaAndTableName, String insertColumns, List<List<Object>> rows) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(schemaAndTableName).append(" (").append(insertColumns).append(") ");
        stringBuilder.append(" VALUES ");

        for (List<Object> row: rows) {
            stringBuilder.append(" ( ");
            for (Object value: row) {
                try {
                    String _value = (String) value;
                    stringBuilder.append("'").append(_value).append("'");
                }catch(Exception e){
                    System.out.println("ERROR MSG: "  + e.getMessage());
                }
                stringBuilder.append(",");
            }
            stringBuilder.append(")").deleteCharAt(stringBuilder.length() - 2);
        }
        stringBuilder.append(";");
        String query = stringBuilder.toString();
        queryLog(query);
        return updateNew(query);
    }


    public Object UltimoElementoIdCreado(String dato,String tabla){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT " + "max("+dato + ") FROM " + tabla);
        String query = stringBuilder.toString();
        queryLog(query);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        Map<String, Object> nuevo = result.get(0);
        System.out.println("este es el Valor: " +nuevo.get("max"));
        return nuevo.get("max");

    }

    public boolean insertNewRowCambio(String schemaAndTableName, String schemaAndTableChange, String columchange, String columchange2, String insertColumns, Map<Integer, List<Object>> insertValues) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(schemaAndTableName).append(" ").append(insertColumns);
        stringBuilder.append(" SELECT " + columchange + " FROM " + schemaAndTableChange + " Where " + columchange2 + "=");
        for (int i = 0; i < insertValues.size(); i++) {
            if (i > 0)
                stringBuilder.append(",");

            for (Object objectValue : insertValues.get(i)) {
                if (objectValue.getClass().getTypeName().contains("String")) {
                    String value = (String) objectValue;
                    stringBuilder.append("'").append(value).append("'");
                } else if (objectValue.getClass().getTypeName().contains("Integer")) {
                    int value = (Integer) objectValue;
                    stringBuilder.append(value);
                }

            }

        }
        stringBuilder.append(";");
        String query = stringBuilder.toString();
        queryLog(query);
        return update(query);
    }

    public Object SelecionarCambio(String tablacambio, String campoCambio, String campoacambiar, String valor) {


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(" SELECT " + campoCambio + " FROM " + tablacambio + " Where " + campoacambiar + "='" + valor + "'");

        String query = stringBuilder.toString();
        queryLog(query);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);


        Map<String, Object> nuevo = result.get(0);

        System.out.println("este es el malor" + nuevo.get(campoCambio));


        return nuevo.get(campoCambio);
    }


    private boolean update(String query) {
        int rows = jdbcTemplate.update(query);
        if (rows > 0) {
            Logger.getLogger(Insert.class.getName()).log(Level.INFO,"Una nueva fila fue insertada.");
            return true;
        } else {
            Logger.getLogger(Insert.class.getName()).log(Level.INFO,"Ocurrió un error al insertar una nueva fila.");
            return false;
        }
    }

    private boolean updateNew(String query) {
        var jdbcTemplate= new JdbcTemplate();
        int rows = jdbcTemplate.update(query);
        if (rows > 0) {
            Logger.getLogger(Insert.class.getName()).log(Level.INFO,"Una nueva fila fue insertada.");
            return true;
        } else {
            Logger.getLogger(Insert.class.getName()).log(Level.INFO,"Ocurrió un error al insertar una nueva fila.");
            return false;
        }
    }


    public boolean updateRows(String tablaInicial, String identficadoraCambiar, String campoSelecionado, String tablaCambio, String campoCambio, String valorcambio, String idelemento) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE " + tablaInicial).append(" SET " + identficadoraCambiar).append("=(SELECT " + campoSelecionado + " FROM " + tablaCambio + " WHERE " + campoCambio + "='" + valorcambio + "')").append("WHERE " + idelemento + "=(SELECT max(" + idelemento + ") FROM " + tablaInicial + ")");
        String query = stringBuilder.toString();

        queryLog(query);
        return update(query);


    }
}
