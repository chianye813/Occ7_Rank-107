/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3307/nba";
        String username = "root";
        String password = "";
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Check if connection is successful
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to the database!");
                System.out.println("\n---------Example---------");
                System.out.println("Retrieve data from first row:");
                // Create a statement object
                Statement stmt = conn.createStatement();

                // Execute query to retrieve first row
                ResultSet rs = stmt.executeQuery("SELECT * FROM assignment2 LIMIT 1");

                // Process the result set
                if (rs.next()) {
                    String name = rs.getString("Name");
                    String position = rs.getString("Position");
                    double salary = rs.getDouble("Salary");
                    System.out.println("Name: " + name + ", Position: " + position + ", Salary: " + salary);
                } else {
                    System.out.println("No data found in the table.");
                }

                // Close the resources
                rs.close();
                stmt.close();
                conn.close(); // Close the connection
            } else {
                System.out.println("Failed to connect to the database!");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: Unable to connect to the database!");
            e.printStackTrace();
        }
    }
}

