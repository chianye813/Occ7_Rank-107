/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author chianye
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamValidator {
    private DatabaseConnection dbConnection;

    public TeamValidator(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String canAddPlayer(String position, double salary) throws SQLException {
        // Check if adding the player exceeds the maximum number of players
        if (!isPlayerCountValid()) {
            return "The team already has the maximum number of players (15).";
        }

        // Check if adding the player exceeds the salary cap
        if (!isSalaryCapValid(salary)) {
            return "Adding this player would exceed the salary cap($20,000).";
        }

        // Check if adding the player violates positional requirements
        String positionalRequirementMessage = getPositionalRequirementMessage(position);
        if (positionalRequirementMessage != null) {
            return positionalRequirementMessage;
        }

        // All checks passed, player can be added
        return "Player added successfully.";
    }
    
    public String canRemovePlayer(String name) throws SQLException {
        // Check if removing the player violates the minimum number of players
        if (!isPlayerCountAboveMinimum()) {
            return "The team must consist of a minimum of 10 players.";
        }

        // Check if removing the player violates positional requirements
        String positionalRequirementMessage = getPositionalRequirementMessageForRemoval(name);
        if (positionalRequirementMessage != null) {
            return positionalRequirementMessage;
        }

        // All checks passed, player can be removed
        return "Player removed successfully.";
    }
    
     private boolean isPlayerCountAboveMinimum() throws SQLException {
        String countQuery = "SELECT COUNT(*) AS playerCount FROM assignment2";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement countStmt = conn.prepareStatement(countQuery);
             ResultSet rs = countStmt.executeQuery()) {

            if (rs.next()) {
                int playerCount = rs.getInt("playerCount");
                return playerCount > 10;
            }
        }
        return false; // Default to false if count check fails
    }

    private boolean isSalaryCapValid(double newSalary) throws SQLException {
        String totalSalaryQuery = "SELECT SUM(Salary) AS TotalSalary FROM assignment2";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement salaryStmt = conn.prepareStatement(totalSalaryQuery);
             ResultSet rs = salaryStmt.executeQuery()) {

            if (rs.next()) {
                double totalSalary = rs.getDouble("TotalSalary");
                return totalSalary + newSalary <= 20000;
            }
        }
        return false; // Default to false if query fails
    }

    private String getPositionalRequirementMessage(String position) throws SQLException {
        String positionQuery = "SELECT " +
             "SUM(CASE WHEN LOWER(Position) = 'guard' THEN 1 ELSE 0 END) AS Guards, " +
             "SUM(CASE WHEN LOWER(Position) = 'forward' THEN 1 ELSE 0 END) AS Forwards, " +
             "SUM(CASE WHEN LOWER(Position) = 'center' THEN 1 ELSE 0 END) AS Centers " +
             "FROM assignment2";

        try (Connection conn = dbConnection.getConnection();
            PreparedStatement positionStmt = conn.prepareStatement(positionQuery);
            ResultSet rs = positionStmt.executeQuery()) {

            if (rs.next()) {
                int guards = rs.getInt("Guards");
                int forwards = rs.getInt("Forwards");
                int centers = rs.getInt("Centers");

                 if (guards <= 1 && position.equals("guard")) {
                    return "Reminder: Each team is required to have a minimum of 2 players as Guards. Consider adding more Guards.";
                }
                if (forwards <= 1 && position.equals("forward")) {
                    return "Reminder: Each team must have at least 2 players as Forwards. Consider adding more Forwards.";
                }
                if (centers <= 1 && position.equals("center")) {
                    return "Reminder: Each team is obligated to maintain a minimum of 2 players as Centers. Consider adding more Centers.";
                }
            }
        }
        return null; // Return null if no positional requirement violation
    }
    
    public String getPlayerPosition(String name) throws SQLException {
        String playerPositionQuery = "SELECT Position FROM assignment2 WHERE Name = ?";
        String playerPosition = null;

        try (Connection conn = dbConnection.getConnection();
            PreparedStatement playerStmt = conn.prepareStatement(playerPositionQuery)) {

            playerStmt.setString(1, name);
            try (ResultSet rs = playerStmt.executeQuery()) {
                if (rs.next()) {
                    playerPosition = rs.getString("Position");
                } else {
                    return null;
                }
            }
        }
        return playerPosition;
    }

    private String getPositionalRequirementMessageForRemoval(String name) throws SQLException {
        String playerPosition = getPlayerPosition(name);
        if (playerPosition == null) {
            return "Player not found.";
        }

        // Count current positions
       String positionQuery = "SELECT " +
             "SUM(CASE WHEN LOWER(Position) = 'guard' THEN 1 ELSE 0 END) AS Guards, " +
             "SUM(CASE WHEN LOWER(Position) = 'forward' THEN 1 ELSE 0 END) AS Forwards, " +
             "SUM(CASE WHEN LOWER(Position) = 'center' THEN 1 ELSE 0 END) AS Centers " +
             "FROM assignment2";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement positionStmt = conn.prepareStatement(positionQuery);
             ResultSet rs = positionStmt.executeQuery()) {

            if (rs.next()) {
                int guards = rs.getInt("Guards");
                int forwards = rs.getInt("Forwards");
                int centers = rs.getInt("Centers");

                // Check if removal violates the minimum positional requirements
                if (playerPosition.equals("guard") && guards <= 2) {
                    return "Each team is required to have a minimum of 2 players as Guards. Removing this player would violate this requirement.";
                }
                if (playerPosition.equals("forward") && forwards <= 2) {
                    return "Each team must have at least 2 players as Forwards. Removing this player would violate this requirement.";
                }
                if (playerPosition.equals("center") && centers <= 2) {
                    return "Each team is obligated to maintain a minimum of 2 players as Centers. Removing this player would violate this requirement.";
                }
            }
        }
        return null; // Return null if no positional requirement violation
    }

    private boolean isPlayerCountValid() throws SQLException {
        String countQuery = "SELECT COUNT(*) AS playerCount FROM assignment2";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement countStmt = conn.prepareStatement(countQuery);
             ResultSet rs = countStmt.executeQuery()) {

            if (rs.next()) {
                int playerCount = rs.getInt("playerCount");
                return playerCount <= 15;
            }
        }
        return false; // Default to false if count check fails
    }

}
    



