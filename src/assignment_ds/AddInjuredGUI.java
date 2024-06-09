/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment_ds;

import static assignment_ds.InjuryReserveGUI.injuryReserve;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author liksh
 */
public class AddInjuredGUI extends javax.swing.JFrame {

    InjuryReserveGUI injuryReserve = new InjuryReserveGUI();
    private DatabaseConnection dbConnection;
    private DefaultTableModel model;
    String url = "jdbc:mysql://localhost:3307/nba";
    String username = "root";
    String password = "";

    /**
     * Creates new form AddInjuredGUI
     */
    public AddInjuredGUI() {
        initComponents();
        setLocationRelativeTo(null);
        connectToDatabase();
    }

    private void connectToDatabase() {
        dbConnection = new DatabaseConnection("jdbc:mysql://localhost:3307/nba", "root", "");
    }

    private boolean checkPlayerInRoster(String playerName) {
        boolean playerFound = false;
        try {
            // Get the connection from the database connection object
            Connection conn = dbConnection.getConnection();

            // Create a query to check if the player name exists in the database
            String query = "SELECT * FROM assignment2 WHERE Name = ?";

            // Prepare the statement
            PreparedStatement statement = conn.prepareStatement(query);

            // Set the parameter (playerName) in the query
            statement.setString(1, playerName);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // If there is at least one row returned, the player is found in the roster
            if (resultSet.next()) {
                playerFound = true;
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        }
        return playerFound;
    }

    // Method to transfer player data from assignment2 to injuryreserve
    private boolean transferPlayerToInjuryReserve(String playerName, String injuryType) {
        String url = "jdbc:mysql://localhost:3307/nba"; // database URL
        String user = "root"; // database username
        String password = ""; // database password
        boolean success = true;

        String selectQuery = "SELECT * FROM assignment2 WHERE Name = ?";
        String insertQuery = "INSERT INTO injuryreserve (Name, Age, Position, Salary, Height, Weight, Points, Rebounds, Steals, Assists, Blocks, `Contract duration`, `Composite Mark`, Injury) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String deleteQuery = "DELETE FROM assignment2 WHERE Name = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, password); 
                PreparedStatement selectStmt = conn.prepareStatement(selectQuery); 
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {

            selectStmt.setString(1, playerName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                insertStmt.setString(1, rs.getString("Name"));
                insertStmt.setInt(2, rs.getInt("Age"));
                insertStmt.setString(3, rs.getString("Position"));
                insertStmt.setDouble(4, rs.getDouble("Salary"));
                insertStmt.setDouble(5, rs.getDouble("Height"));
                insertStmt.setDouble(6, rs.getDouble("Weight"));
                insertStmt.setDouble(7, rs.getDouble("Points"));
                insertStmt.setDouble(8, rs.getDouble("Rebounds"));
                insertStmt.setDouble(9, rs.getDouble("Steals"));
                insertStmt.setDouble(10, rs.getDouble("Assists"));
                insertStmt.setDouble(11, rs.getDouble("Blocks"));
                insertStmt.setInt(12, rs.getInt("Contract duration"));
                insertStmt.setDouble(13, rs.getDouble("Composite Mark"));
                insertStmt.setString(14, injuryType);

                insertStmt.executeUpdate();
                
                // Now delete the player from assignment2 table
                deleteStmt.setString(1, playerName);
                deleteStmt.executeUpdate();
                
            } else {
                JOptionPane.showMessageDialog(this, "Player data not found in assignment2 table.", "Error", JOptionPane.ERROR_MESSAGE);
                success=false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error transferring player data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            success=false;
        }
        
        return success;
    }
    
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AddInjuredButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        PlayerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TypeofInjury = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Injured Player");

        AddInjuredButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AddInjuredButton.setForeground(new java.awt.Color(0, 0, 0));
        AddInjuredButton.setText("ADD");
        AddInjuredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInjuredButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        BackButton.setBackground(new java.awt.Color(204, 0, 0));
        BackButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        PlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerNameActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player Name:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Type of Injury:");

        TypeofInjury.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeofInjuryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TypeofInjury, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                    .addComponent(PlayerName)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(AddInjuredButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BackButton)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TypeofInjury, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(AddInjuredButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddInjuredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInjuredButtonActionPerformed
        String playerName = PlayerName.getText().trim();
        String injuryType = TypeofInjury.getText().trim();
        
        // Check if playerName or injuryType is null or empty
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter player name", "Player Name is MISSING", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (injuryType == null || injuryType.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter injury type", "Injury Type is MISSING", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String addMesj = "Player: " + playerName + "\nInjury: " + injuryType + "\nStatus: Added to Injury Reserve";
        boolean playerExists = checkPlayerInRoster(playerName);
        if (playerExists) {
            //found - remove from roster - add list
            if (transferPlayerToInjuryReserve(playerName, injuryType)) {
                JOptionPane.showMessageDialog(this, "Player exists in the roster.", "Player Found", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, addMesj, "Adding Player to Injury Reserve", JOptionPane.INFORMATION_MESSAGE);
                InjuryReserveGUI.injuryReserve.addInjured(playerName);
                System.out.println("Updated: \n"+InjuryReserveGUI.injuryReserve.toString());
                PlayerName.setText("");
                TypeofInjury.setText("");
            } else {
                PlayerName.setText("");
                TypeofInjury.setText("");
                JOptionPane.showMessageDialog(this, "Error transferring player data to injury reserve.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
 
        } else {
            //not found
            PlayerName.setText("");
            TypeofInjury.setText("");
            JOptionPane.showMessageDialog(this, "Player does not exist in the roster.", "Player Not Found", JOptionPane.INFORMATION_MESSAGE);

        }
        
        injuryReserve.loadInjuryReserveData();
    }//GEN-LAST:event_AddInjuredButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
        InjuryReserveGUI gui = new InjuryReserveGUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void PlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerNameActionPerformed

    }//GEN-LAST:event_PlayerNameActionPerformed

    private void TypeofInjuryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeofInjuryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeofInjuryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddInjuredGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInjuredGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInjuredGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInjuredGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInjuredGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddInjuredButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField PlayerName;
    private javax.swing.JTextField TypeofInjury;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
