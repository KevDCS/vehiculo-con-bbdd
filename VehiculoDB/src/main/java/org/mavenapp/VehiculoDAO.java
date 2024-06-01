package org.mavenapp;

import java.sql.*;

public class VehiculoDAO {

    // Ver detalles de la tabla de vehiculos
    public void printVehiculos() {
        String query = "SELECT * FROM vehiculos";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                String tipo = rs.getString("tipo_vehiculo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia");
                Date fechaCompra = rs.getDate("fecha_compra");
                System.out.println("ID Vehiculo: " + idVehiculo);
                System.out.println("Tipo de Vehiculo: " + tipo);
                System.out.println("Marca de Vehiculo: " + marca);
                System.out.println("Potencia de Vehiculo: " + potencia + " km/h");
                System.out.println("Fecha de compra del Vehiculo: " + fechaCompra);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar vehiculo en la tabla de vehiculos
    public void updateVehiculo(int id, String tipo) {
        String query = "UPDATE vehiculos SET tipo_vehiculo = ? WHERE  id_vehiculo = ?;";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tipo);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insertar vehiculo en la tabla de vehiculos
    public void insertVehiculo(String tipo, String marca, int potencia,Date fechaCompra) {
        String query = "INSERT INTO vehiculos (tipo_vehiculo, marca, potencia, fecha_compra) VALUES (?, ?, ?, ?);";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tipo);
            stmt.setString(2, marca);
            stmt.setInt(3, potencia);
            stmt.setDate(4, fechaCompra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar vehiculo en la tabla de vehiculos
    public void deleteVehiculo(int id) {
        String query = "DELETE FROM vehiculos WHERE id_vehiculo = ?;";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ver potencia media segun el tipo de vehiculo
    public double getPotenciaMedia() {
        String query = "SELECT tipo_vehiculo, ROUND(AVG(potencia)) as potencia FROM vehiculos group by tipo_vehiculo;";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String tipo = rs.getString("tipo_vehiculo");
                System.out.println("Tipo de Vehiculo: " + tipo);
                System.out.println("Potencia media: " + rs.getDouble("potencia"));
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Ver potencia maxima segun el tipo de vehiculo
    public double getPotenciaMaxima() {
        String query = "SELECT tipo_vehiculo, ROUND(MAX(potencia)) as potencia FROM vehiculos group by tipo_vehiculo;";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String tipo = rs.getString("tipo_vehiculo");
                System.out.println("Tipo de Vehiculo: " + tipo);
                System.out.println("Potencia media: " + rs.getDouble("potencia"));
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
