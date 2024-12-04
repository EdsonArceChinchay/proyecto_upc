package com.tdp.ct.web.repository;

import com.tdp.ct.web.model.Material;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.LogUtils.logSevere;

@Repository
public class MaterialRepository {

    private final DataSource dataSource;

    public MaterialRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private JdbcTemplate getJdbcTemplate() {
        checkConnection();
        return new JdbcTemplate(dataSource);
    }

    private void checkConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                logInfo("Conexión a la base de datos exitosa!");
            }
        } catch (SQLException e) {
            logSevere("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public List<Material> getSimCards(String warehouse, String environment) {
        String sql = "SELECT idmaterial AS idMaterial, nombrematerial AS nameMaterial, numeroserie AS serialNumber, estado AS status, almacen AS warehouse, ambiente AS environment, sap_id AS sapID " +
                "FROM public.material " +
                "WHERE estado=1 AND almacen=? AND ambiente=? AND simcard='S' LIMIT 10";
        logInfo("Query >>> {0}", sql);
        return getJdbcTemplate().query(sql, new Object[]{warehouse, environment}, new MaterialRowMapper());
    }

    public List<Material> getIMEIs(String warehouse, String environment, String name, String sapId) {
        String sql = "SELECT idmaterial AS idMaterial, nombrematerial AS nameMaterial, numeroserie AS serialNumber, estado AS status, almacen AS warehouse, ambiente AS environment, sap_id AS sapID " +
                "FROM public.material " +
                "WHERE nombrematerial LIKE ? AND sap_id LIKE ? AND estado=1 AND almacen=? AND ambiente=? AND imei='S' LIMIT 10";
        logInfo("Query >>> {0}", sql);
        return getJdbcTemplate().query(sql, new Object[]{"%" + name + "%", "%" + sapId + "%", warehouse, environment}, new MaterialRowMapper());
    }

    public void assignMaterial(String serialNumber) {
        String sql = "UPDATE public.material SET grupo='MESAS', estado=2, proyecto='DITO', tester='AutomationTester', fechaasignacion=now() WHERE numeroserie=?";
        logInfo("Query >>> {0}", sql);
        getJdbcTemplate().update(sql, serialNumber);
    }

}