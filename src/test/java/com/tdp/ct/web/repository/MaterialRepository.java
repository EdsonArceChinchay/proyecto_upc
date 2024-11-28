package com.tdp.ct.web.repository;

import com.tdp.ct.web.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MaterialRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Material> getSimCards(String warehouse, String environment) {
        String sql = "SELECT idmaterial AS idMaterial, nombrematerial AS nameMaterial, numeroserie AS serialNumber, estado AS status, almacen AS warehouse, ambiente AS environment, sap_id AS sapID " +
                "FROM public.material " +
                "WHERE estado=1 AND almacen=? AND ambiente=? AND simcard='S' LIMIT 10";
        return jdbcTemplate.query(sql, new Object[]{warehouse, environment}, new MaterialRowMapper());
    }

    public List<Material> getIMEIs(String warehouse, String environment, String name, String sapId) {
        String sql = "SELECT idmaterial AS idMaterial, nombrematerial AS nameMaterial, numeroserie AS serialNumber, estado AS status, almacen AS warehouse, ambiente AS environment, sap_id AS sapID " +
                "FROM public.material " +
                "WHERE nombrematerial LIKE ? AND sap_id LIKE ? AND estado=1 AND almacen=? AND ambiente=? AND imei='S' LIMIT 10";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%", "%" + sapId + "%", warehouse, environment}, new MaterialRowMapper());
    }

    public void assignMaterial(String serialNumber) {
        String sql = "UPDATE public.material SET grupo='MESAS', estado=1, proyecto='DITO', tester='AutomationTester', fechaasignacion=now() WHERE numeroserie=?";
        jdbcTemplate.update(sql, serialNumber);
    }

}