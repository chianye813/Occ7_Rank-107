/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment_ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liksh
 */
public class ContractExtensionGUI extends javax.swing.JFrame {

    static PriorityQueue<PlayerContract> pqueue = new PriorityQueue<PlayerContract>(Collections.reverseOrder());
    private DatabaseConnection dbConnection;
    private static String playerName1;
    private static Double compositeMark1;
    private static Integer contractDuration1;
    public static DefaultTableModel model;

    /**
     * Creates new form ContractExtensionGUI
     */
    public ContractExtensionGUI() {
        initComponents();
        setLocationRelativeTo(null);
        ContractExtensionQueue.getColumnModel().getColumn(0).setPreferredWidth(200);
        loadDataToTable();

    }

    public void loadMainData() {
        String url = "jdbc:mysql://localhost:3307/nba";
        String username = "root";
        String password = "";
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            String sql = "select * from assignment2";
            ResultSet rs = st.executeQuery(sql);

            model = (DefaultTableModel) ContractExtensionQueue.getModel();
            //model.setRowCount(0); // Clear existing data
            //pqueue.clear();

            while (rs.next()) {
//                String player = rs.getString("Name");
//                String contractDuration = String.valueOf(rs.getString("Contract duration"));
//                String compositeMark = String.valueOf(rs.getString("Composite mark"));
//                if(!pqueue.contains(new PlayerContract(player, Integer.parseInt(contractDuration), Double.parseDouble(compositeMark)))){
//                    pqueue.add(new PlayerContract(player, Integer.parseInt(contractDuration), Double.parseDouble(compositeMark)));
//                }

                String player = rs.getString("Name");
                int contractDuration = rs.getInt("Contract duration");
                double compositeMark = rs.getDouble("Composite mark");
                PlayerContract newPlayerContract = new PlayerContract(player, contractDuration, compositeMark);

                if (!pqueue.contains(newPlayerContract)) {
                    pqueue.add(newPlayerContract);
                }
            }
            System.out.println("Updated: \n"+pqueue.toString());

            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void loadDataToTable() {
        String url = "jdbc:mysql://localhost:3307/nba";
        String username = "root";
        String password = "";

        model = (DefaultTableModel) ContractExtensionQueue.getModel();
        model.setRowCount(0);

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            String sql = "select * from assignment2";
            ResultSet rs = st.executeQuery(sql);

            model = (DefaultTableModel) ContractExtensionQueue.getModel();
            //peek first player to be settled
            playerName1 = pqueue.peek().getPlayerName();
            compositeMark1 = pqueue.peek().getCompositeMark();
            contractDuration1 = pqueue.peek().getContractDuration();

            PlayerName1.setText(playerName1);
            CompositeMark1.setText(compositeMark1 != null ? String.valueOf(compositeMark1) : "");
            ContractDuration1.setText(contractDuration1 != null ? String.valueOf(contractDuration1) : "");

            //update into the table
            PriorityQueue<PlayerContract> pqueueDuplicated = new PriorityQueue(pqueue);
            PlayerContract c = pqueueDuplicated.peek();
            if (c != null) {
                while ((c = pqueueDuplicated.poll()) != null) {
                    String player = c.getPlayerName();
                    Integer contractDuration = c.getContractDuration();
                    Double compositeMark = c.getCompositeMark();
                    // add string array data into table
                    model.addRow(new Object[]{player, contractDuration, compositeMark});
                }
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        MarkAsSettledButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PlayerName1 = new javax.swing.JTextField();
        CompositeMark1 = new javax.swing.JTextField();
        ContractDuration1 = new javax.swing.JTextField();
        ExtensionPeriodComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        years = new javax.swing.JLabel();
        years1 = new javax.swing.JLabel();
        AddPLayerToExtensionQueueButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ContractExtensionQueue = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        importAlll = new javax.swing.JButton();
        RefreshList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jPanel2.setBackground(new java.awt.Color(102, 153, 0));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        MarkAsSettledButton.setBackground(new java.awt.Color(153, 153, 0));
        MarkAsSettledButton.setForeground(new java.awt.Color(0, 0, 0));
        MarkAsSettledButton.setText("Mark As Settled");
        MarkAsSettledButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkAsSettledButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("To initiate negotiations first,");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Player Name:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Composite Mark:");

        PlayerName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerName1ActionPerformed(evt);
            }
        });

        CompositeMark1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompositeMark1ActionPerformed(evt);
            }
        });

        ContractDuration1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContractDuration1ActionPerformed(evt);
            }
        });

        ExtensionPeriodComboBox.setBackground(new java.awt.Color(153, 153, 0));
        ExtensionPeriodComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ExtensionPeriodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        ExtensionPeriodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtensionPeriodComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Extension Period: ");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Contract Duration:");

        years.setBackground(new java.awt.Color(255, 255, 255));
        years.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        years.setForeground(new java.awt.Color(255, 255, 255));
        years.setText("year(s)");

        years1.setBackground(new java.awt.Color(255, 255, 255));
        years1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        years1.setForeground(new java.awt.Color(255, 255, 255));
        years1.setText("year(s)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MarkAsSettledButton)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CompositeMark1)
                            .addComponent(PlayerName1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ContractDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(years, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExtensionPeriodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(years1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addGap(87, 87, 87))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CompositeMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContractDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExtensionPeriodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(years1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(MarkAsSettledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AddPLayerToExtensionQueueButton.setBackground(new java.awt.Color(0, 153, 204));
        AddPLayerToExtensionQueueButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AddPLayerToExtensionQueueButton.setForeground(new java.awt.Color(0, 0, 0));
        AddPLayerToExtensionQueueButton.setText("Add Player to Contract Extension Queue");
        AddPLayerToExtensionQueueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPLayerToExtensionQueueButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(204, 0, 0));
        BackButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Contract Extension Dashboard");

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));

        ContractExtensionQueue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ContractExtensionQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Contract duration", "Composite mark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ContractExtensionQueue.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ContractExtensionQueue.setRowHeight(30);
        ContractExtensionQueue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ContractExtensionQueue);
        if (ContractExtensionQueue.getColumnModel().getColumnCount() > 0) {
            ContractExtensionQueue.getColumnModel().getColumn(0).setResizable(false);
            ContractExtensionQueue.getColumnModel().getColumn(1).setResizable(false);
            ContractExtensionQueue.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contract Extension Queue");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        importAlll.setBackground(new java.awt.Color(0, 153, 204));
        importAlll.setForeground(new java.awt.Color(0, 0, 0));
        importAlll.setText("Import ALL");
        importAlll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importAlllActionPerformed(evt);
            }
        });

        RefreshList.setForeground(new java.awt.Color(0, 0, 0));
        RefreshList.setText("Refresh");
        RefreshList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddPLayerToExtensionQueueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(importAlll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshList)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(AddPLayerToExtensionQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(importAlll))
                            .addComponent(RefreshList, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddPLayerToExtensionQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPLayerToExtensionQueueButtonActionPerformed
        this.dispose();
        new AddContractExtensionGUI().setVisible(true);
    }//GEN-LAST:event_AddPLayerToExtensionQueueButtonActionPerformed

    private void PlayerName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayerName1ActionPerformed

    private void CompositeMark1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompositeMark1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompositeMark1ActionPerformed

    private void ContractDuration1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContractDuration1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContractDuration1ActionPerformed

    private void ExtensionPeriodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtensionPeriodComboBoxActionPerformed

    }//GEN-LAST:event_ExtensionPeriodComboBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
        Homepage gui = new Homepage();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void MarkAsSettledButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkAsSettledButtonActionPerformed
        // Check if playerName or injuryType is null or empty
        String playerName = PlayerName1.getText().trim();
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter player name", "Player Name is MISSING", JOptionPane.INFORMATION_MESSAGE);
            return;
    }
    //read entension period from combo box
        String extensionPeriod = (String) ExtensionPeriodComboBox.getSelectedItem();
        int extendedValue = contractDuration1 + Integer.parseInt(extensionPeriod);

        //increase the year value and store it back into the database
        String url = "jdbc:mysql://localhost:3307/nba";
        String username = "root";
        String password = "";

        String sql = "UPDATE assignment2 SET `Contract duration` = ? WHERE `Name` = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setInt(1, extendedValue); // Set the first parameter (Contract duration)
            pstmt.setString(2, playerName1); // Set the second parameter (Name)
            
            String addMesj;
            if(extendedValue==contractDuration1){
                addMesj = "Player: " + playerName1 + "\nStatus: No extension made";
            }else{
                addMesj = "Player: " + playerName1 + "\nStatus: Contract Renewed";
            }
                
            // Execute the update
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Display messages confirming addition
                
                JOptionPane.showMessageDialog(this, addMesj, "Removing Player from Contract Extension Queue", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Update successful. Rows affected: " + affectedRows);
            } else {
                System.out.println("No matching player found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //poll from queue
        System.out.println("Player removed from Contract Extension Queue: " + pqueue.poll());
        System.out.println("Updated: \n"+pqueue.toString());

        //sertext or cleartext & remove row from table
        //peek first player to be settled
        if (pqueue.peek() != null) {
            playerName1 = pqueue.peek().getPlayerName();
            compositeMark1 = pqueue.peek().getCompositeMark();
            contractDuration1 = pqueue.peek().getContractDuration();

            PlayerName1.setText(playerName1);
            CompositeMark1.setText(compositeMark1 != null ? String.valueOf(compositeMark1) : "");
            ContractDuration1.setText(contractDuration1 != null ? String.valueOf(contractDuration1) : "");
        } else {
            PlayerName1.setText("");
            CompositeMark1.setText("");
            ContractDuration1.setText("");
        }

        // Check if there are any rows to remove
        if (model.getRowCount() > 0) {
            // Remove the first row (index 0)
            model.removeRow(0);
        }

    }//GEN-LAST:event_MarkAsSettledButtonActionPerformed

    private void importAlllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importAlllActionPerformed
        loadMainData();
        loadDataToTable();
    }//GEN-LAST:event_importAlllActionPerformed

    private void RefreshListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshListActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loadDataToTable();
            }
        });
    }//GEN-LAST:event_RefreshListActionPerformed

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
            java.util.logging.Logger.getLogger(ContractExtensionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContractExtensionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContractExtensionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractExtensionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new ContractExtensionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPLayerToExtensionQueueButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField CompositeMark1;
    private javax.swing.JTextField ContractDuration1;
    private javax.swing.JTable ContractExtensionQueue;
    private javax.swing.JComboBox<String> ExtensionPeriodComboBox;
    private javax.swing.JButton MarkAsSettledButton;
    private javax.swing.JTextField PlayerName1;
    private javax.swing.JButton RefreshList;
    private javax.swing.JButton importAlll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel years;
    private javax.swing.JLabel years1;
    // End of variables declaration//GEN-END:variables
}
