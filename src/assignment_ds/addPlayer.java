/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment_ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chianye
 */
public class addPlayer extends javax.swing.JFrame {
private DatabaseConnection dbConnection;
private TeamValidator teamValidator;
    /**
     * Creates new form addPlayer
     */
    public addPlayer() {
        initComponents();
        setLocationRelativeTo(null);
        dbConnection = new DatabaseConnection("jdbc:mysql://localhost:3307/nba", "root", "");
        teamValidator = new TeamValidator(dbConnection);
    }
    
    String url = "jdbc:mysql://localhost:3307/nba";
    String username = "root";
    String password = "";


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        height = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        addPlayer = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        points = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        assists = new javax.swing.JTextField();
        rebounds = new javax.swing.JTextField();
        steals = new javax.swing.JTextField();
        blocks = new javax.swing.JTextField();
        addPlayer1 = new javax.swing.JButton();
        Position = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 214, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel1.setText("Age: ");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setText("Name: ");

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setText("Position:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel4.setText("Salary($):");

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel5.setText("Height(m):");

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel6.setText("Weight(kg):");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });

        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });

        height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightActionPerformed(evt);
            }
        });

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        addPlayer.setBackground(new java.awt.Color(87, 120, 255));
        addPlayer.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        addPlayer.setForeground(new java.awt.Color(255, 255, 255));
        addPlayer.setText("Add");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(200, 61, 77));
        back.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\23004\\OneDrive\\Pictures\\basketball_jersey_80px.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\23004\\OneDrive\\Pictures\\basketball_jersey1_80px.png")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel9.setText("Points:");

        points.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointsActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel10.setText("Rebounds:");

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel11.setText("Assists:");

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel12.setText("Steals:");

        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel13.setText("Blocks:");

        assists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assistsActionPerformed(evt);
            }
        });

        rebounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reboundsActionPerformed(evt);
            }
        });

        steals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealsActionPerformed(evt);
            }
        });

        blocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocksActionPerformed(evt);
            }
        });

        addPlayer1.setBackground(new java.awt.Color(97, 76, 200));
        addPlayer1.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        addPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        addPlayer1.setText("Update");
        addPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayer1ActionPerformed(evt);
            }
        });

        Position.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        Position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Forward", "Center", "Guard" }));
        Position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(addPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(addPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(assists, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(rebounds, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(steals, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blocks, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(back))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rebounds, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(assists, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(steals, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(salary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(blocks, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void PositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed

    private void heightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed
 // Retrieve all fields
    String n = name.getText();
    String a = age.getText();
    String po = (String) Position.getSelectedItem();
    String sa = salary.getText();
    String h = height.getText();
    String w = weight.getText();
    String pts = points.getText(); 
    String re = rebounds.getText();
    String ass = assists.getText();
    String st = steals.getText();
    String bl = blocks.getText();

    // Check if any other field is empty
    if (n.isEmpty() || a.isEmpty() || po == null || po.equals("None")|| h.isEmpty() || w.isEmpty() || pts.isEmpty() || re.isEmpty() ||
        ass.isEmpty() || st.isEmpty() || bl.isEmpty() ) {
        JOptionPane.showMessageDialog(this, "Please fill in all the required fields.", "Input Required", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        double salary = Double.parseDouble(sa); // Parse salary correctly before validation
        String validationMessage = teamValidator.canAddPlayer(po, salary);

        if (validationMessage.startsWith("Reminder")) {
            JOptionPane.showMessageDialog(this, validationMessage, "Team Validation", JOptionPane.WARNING_MESSAGE);
        } else if (validationMessage.equals("Player added successfully.")) {
            JOptionPane.showMessageDialog(this, validationMessage, "Team Validation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, validationMessage, "Team Validation", JOptionPane.ERROR_MESSAGE);
            return; // Do not proceed if there is an error
        }

        try (Connection conn = dbConnection.getConnection()) {
            // Check if player already exists
            String checkQuery = "SELECT COUNT(*) FROM assignment2 WHERE Name = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, n);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Player already exists.", "Duplicate Player", JOptionPane.ERROR_MESSAGE);
                    return; // Exit method if player exists
                }
            }

            String insertQuery = "INSERT INTO assignment2 (Name, Age, Position, Salary, Height, Weight, Points, Rebounds, Steals, Assists, Blocks)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, n);
                int ageValue = Integer.parseInt(a);
                insertStmt.setInt(2, ageValue);
                insertStmt.setString(3, po);
                insertStmt.setDouble(4, salary);
                insertStmt.setDouble(5, Double.parseDouble(h));
                insertStmt.setDouble(6, Double.parseDouble(w));
                insertStmt.setDouble(7, Double.parseDouble(pts));
                insertStmt.setDouble(8, Double.parseDouble(re));
                insertStmt.setDouble(9, Double.parseDouble(ass));
                insertStmt.setDouble(10, Double.parseDouble(st));
                insertStmt.setDouble(11, Double.parseDouble(bl));

                insertStmt.executeUpdate();
                this.dispose(); // Close current frame
                TeamRoaster rosterFrame = new TeamRoaster(dbConnection); // Open roster frame
                rosterFrame.setVisible(true);
            }
        }
    } catch (SQLException e) {
        System.err.println("SQL error occurred.");
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while adding the player.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numerical values for age, salary, height, weight, points, rebounds, assists, steals, and blocks.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    calcCompositeMark.calculateMarks();
    
    }//GEN-LAST:event_addPlayerActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Homepage().setVisible(true);

    }//GEN-LAST:event_backActionPerformed

    private void pointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsActionPerformed

    private void assistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assistsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assistsActionPerformed

    private void reboundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reboundsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reboundsActionPerformed

    private void stealsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stealsActionPerformed

    private void blocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blocksActionPerformed

    private void addPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayer1ActionPerformed
        String n = name.getText();
        String a = age.getText();
        String po = (String)Position.getSelectedItem();
        String sa = salary.getText();
        String h = height.getText();
        String w = weight.getText();
        String pts = points.getText(); 
        String re = rebounds.getText();
        String ass = assists.getText();
        String st = steals.getText();
        String bl = blocks.getText();
        if (po.equals("None")) {
            po = ""; 
        }
        if (!n.isEmpty()) {
            // Update the database with the provided values
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String updateQuery = "UPDATE assignment2 SET "
                        + "Age = COALESCE(NULLIF(?, ''), Age), "
                        + "Position = COALESCE(NULLIF(?, ''), Position), "
                        + "Salary = COALESCE(NULLIF(?, ''), Salary), "
                        + "Height = COALESCE(NULLIF(?, ''), Height), "
                        + "Weight = COALESCE(NULLIF(?, ''), Weight), "
                        + "Points = COALESCE(NULLIF(?, ''), Points), "
                        + "Rebounds = COALESCE(NULLIF(?, ''), Rebounds), "
                        + "Steals = COALESCE(NULLIF(?, ''), Steals), "
                        + "Assists = COALESCE(NULLIF(?, ''), Assists), "
                        + "Blocks = COALESCE(NULLIF(?, ''), Blocks) "
                        + "WHERE Name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, a.isEmpty() ? null : a);
                    preparedStatement.setString(2, po.isEmpty() ? null : po);
                    preparedStatement.setString(3, sa.isEmpty() ? null : sa);
                    preparedStatement.setString(4, h.isEmpty() ? null : h);
                    preparedStatement.setString(5, w.isEmpty() ? null : w);
                    preparedStatement.setString(6, pts.isEmpty() ? null : pts);
                    preparedStatement.setString(7, re.isEmpty() ? null : re);
                    preparedStatement.setString(8, st.isEmpty() ? null : st);
                    preparedStatement.setString(9, ass.isEmpty() ? null : ass);
                    preparedStatement.setString(10, bl.isEmpty() ? null : bl);
                    preparedStatement.setString(11, n);

                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(this,"Player data updated successfully.");
                        this.dispose();
                        TeamRoaster rosterFrame = new TeamRoaster(dbConnection);
                        rosterFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,"Player not found.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this,"Name field is empty. No updates made.");
        }
        calcCompositeMark.calculateMarks();
        // TODO add your handling code here:
    }//GEN-LAST:event_addPlayer1ActionPerformed

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
            java.util.logging.Logger.getLogger(addPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Position;
    private javax.swing.JButton addPlayer;
    private javax.swing.JButton addPlayer1;
    private javax.swing.JTextField age;
    private javax.swing.JTextField assists;
    private javax.swing.JButton back;
    private javax.swing.JTextField blocks;
    private javax.swing.JTextField height;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField points;
    private javax.swing.JTextField rebounds;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField steals;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}