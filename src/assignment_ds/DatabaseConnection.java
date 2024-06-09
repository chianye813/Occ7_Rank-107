package assignment_ds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

 public ResultSet getPlayerData(int playerNumber) throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        conn = getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM assignment2 LIMIT " + (playerNumber - 1) + ", 1");
        return rs;
    } catch (SQLException e) {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
        throw e;
    }
}
 
 public ResultSet getPlayerSummary() throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT COUNT(*) AS TotalPlayers, " +
                                    "SUM(CASE WHEN Position='Guard' THEN 1 ELSE 0 END) AS Guards, " +
                                    "SUM(CASE WHEN Position='Forward' THEN 1 ELSE 0 END) AS Forwards, " +
                                    "SUM(CASE WHEN Position='Center' THEN 1 ELSE 0 END) AS Centers, " +
                                    "SUM(Salary) AS TotalSalary, " +
                                    "SUM(CASE WHEN Superstar='1' THEN 1 ELSE 0 END) AS TotalSuperstar " + 
                                "FROM assignment2");

        return rs;
    } catch (SQLException e) {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
        throw e;
    }
}

    }