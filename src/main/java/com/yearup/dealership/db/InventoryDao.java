package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory
        String query = "INSERT inventory VALUES (?, ?);";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, dealershipId);
            statement.setString(2, vin);

            int rows = statement.executeUpdate();
            System.out.println("\nInventory updated.");
            System.out.println("Rows updated: " + rows);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory
        String query = "DELETE FROM inventory WHERE VIN = ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, vin);

            int rows = statement.executeUpdate();
            System.out.println("\nVehicle removed from inventory.");
            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
