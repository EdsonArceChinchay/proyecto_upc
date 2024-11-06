package com.tdp.ct.web.db;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Update extends JDBCBase {

    private static final String UPDATE_FUNCTION = "SELECT %s('%s', %d, '%s', '%s', '%s')";

    public void updateMaterialBySerialNumber(String function, String serialNumber, int state, String group, String project, String tester) {
        String query = String.format(UPDATE_FUNCTION, function, serialNumber, state, group, project, tester);
        queryLog(query);
        update(query);
    }

    private void update(String query) {
        String result = jdbcTemplate.queryForList(query).toString();
        if (!result.isEmpty()) {
            Logger.getLogger(Update.class.getName()).log(Level.INFO, "One row was updated." + result);
        } else {
            Logger.getLogger(Update.class.getName()).log(Level.INFO, "An error occurred while updating a row.");
        }
    }
}
