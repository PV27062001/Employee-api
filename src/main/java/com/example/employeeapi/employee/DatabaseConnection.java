package com.example.employeeapi.employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/employeedb";
        String username = "Employees";
        String password = "12345678";

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database!");
                // Perform database operations here
                // ...
                // Don't forget to close the connection when done
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
