package com.tdp.ct.web.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCBase {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /**
     * Metodo utilirio que imprime la query formada
     *
     * @param query
     */
    protected void queryLog(String query) {
        Logger.getLogger(JDBCBase.class.getName()).log(Level.INFO, "Query >>> {0}", query);
    }

}
