/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author TEOH YU XUAN
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class calcCompositeMark {
    private static String url = "jdbc:mysql://localhost:3307/nba";
    private static String username = "root";
    private static String password = "";

    public static void main(String[] args) {
        calculateMarks();
    }

    public static void calculateMarks() {
        String selectQuery = "SELECT Name, Position, Points, Rebounds, Steals, Assists, Blocks FROM assignment2";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement selectStmt = con.prepareStatement(selectQuery);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("Name");
                double points = rs.getDouble("Points");
                double rebounds = rs.getDouble("Rebounds");
                double steals = rs.getDouble("Steals");
                double assists = rs.getDouble("Assists");
                double blocks = rs.getDouble("Blocks");
                String position = rs.getString("Position");

                double compositeMark = calculateCompositeMark(points, rebounds, steals, assists, blocks, position);

                String updateQuery = "UPDATE assignment2 SET `Composite Mark` = ? WHERE Name = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setDouble(1, compositeMark);
                updateStmt.setString(2, name);
                updateStmt.executeUpdate();
            }

            System.out.println("Composite marks calculated and updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static double calculateCompositeMark(double points, double rebounds, double steals, double assists, double blocks, String position) {
        double pointsWeight = 0.4;
        double reboundsWeight = 0.2;
        double assistsWeight = 0.2;
        double stealsWeight = 0.1;
        double blocksWeight = 0.1;

        if (position.equalsIgnoreCase("Guard")) {
            pointsWeight = 0.1;
            reboundsWeight = 0.2;
            stealsWeight = 0.3;
            assistsWeight = 0.3;  
            blocksWeight = 0.1;
        } else if (position.equalsIgnoreCase("Forward")) {
            pointsWeight = 0.3;
            reboundsWeight = 0.2;
            stealsWeight = 0.2;
            assistsWeight = 0.2;
            blocksWeight = 0.1;
        } else if (position.equalsIgnoreCase("Center")) {
            pointsWeight = 0.2;
            reboundsWeight = 0.3;
            stealsWeight = 0.1;
            assistsWeight = 0.2;
            blocksWeight = 0.2;
        }

        return points * pointsWeight + rebounds * reboundsWeight + assists * assistsWeight + steals * stealsWeight + blocks * blocksWeight;
    }
}
