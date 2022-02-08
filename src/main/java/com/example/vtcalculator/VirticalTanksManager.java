package com.example.vtcalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VirticalTanksManager {

    private static Connection conn = ConnectionManager.getConnection();

    public static ObservableList<VirticalTanks> getDipVolume() throws SQLException {
        ObservableList<VirticalTanks> dipVolumeList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM chartdp";

        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VirticalTanks bean = new VirticalTanks();

//                bean.setEmployeeId(rs.getString("employeeId"));
                bean.setDip(rs.getString("dip"));
                bean.setLitres(rs.getString("litres"));

                dipVolumeList.add(bean);
            }

            return dipVolumeList;
        }
    }
}
