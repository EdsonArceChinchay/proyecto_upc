package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class Select extends JDBCBase {

    private static final String SELECT_FUNCTION_SIM_CARD = "SELECT %s(%d, '%s', '%s', null, 'N', 'S','Lógico')";
    private static final String SELECT_FUNCTION_IMEI = "SELECT %s(%d, '%s', '%s', '%s', 'S', 'N','Lógico')";

    /**
     * Selecciona una funcion y obtiene registros de la tabla filtrado por estado, ambiente y almacen
     *
     * @param function
     * @param state
     * @param environment
     * @param warehouse
     * @return
     */

    public List<String> listMaterialSimCardByState(String function, int state, String environment, String warehouse) {
        String query = String.format(SELECT_FUNCTION_SIM_CARD, function, state, environment, warehouse);
        queryLog(query);
        List<String> result = jdbcTemplate.queryForList(query)
                .stream()
                .flatMap(map -> map.values().stream())
                .map(Object::toString)
                .collect(Collectors.toList());
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Result >>> {0}", result);
        return result;
    }

    public List<String> listMaterialIMEIByState(String function, int state, String environment, String warehouse, String sapId) {
        String query = String.format(SELECT_FUNCTION_IMEI, function, state, environment, warehouse, sapId);
        queryLog(query);
        List<String> result = jdbcTemplate.queryForList(query)
                .stream()
                .flatMap(map -> map.values().stream())
                .map(Object::toString)
                .collect(Collectors.toList());
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Result >>> {0}", result);
        return result;
    }


}