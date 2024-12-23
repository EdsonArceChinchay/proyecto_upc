package com.tdp.ct.web.repository;

import com.tdp.ct.web.model.Material;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialRowMapper implements RowMapper<Material> {

    @Override
    public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
        Material material = new Material();
        material.setIdMaterial(rs.getInt("idMaterial"));
        material.setNameMaterial(rs.getString("nameMaterial"));
        material.setSerialNumber(rs.getString("serialNumber"));
        material.setStatus(rs.getString("status").equals("1") ? "DISPONIBLE" : "ASIGNADO");
        material.setWarehouse(rs.getString("warehouse"));
        material.setEnvironment(rs.getString("environment"));
        material.setSapId(rs.getString("sapID"));
        return material;
    }
}