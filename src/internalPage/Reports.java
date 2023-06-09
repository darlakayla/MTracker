/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPage;

import config.db_configuration;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SCC-COMLAB
 */
public class Reports extends javax.swing.JInternalFrame {

    /**
     * Creates new form inventory
     */
    public Reports() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    
    public void displayData(){
       
        try{
       
            db_configuration dbc = new db_configuration();
            ResultSet rs = dbc.getData("SELECT tbl_milktea.m_id,tbl_milktea.m_flavor,tbl_milktea.m_price,tbl_milktea.m_quan,tbl_cashier.c_id,tbl_cashier.c_firstname,tbl_cashier.c_lastname,tbl_cashier.c_transactdate FROM tbl_reports LEFT JOIN tbl_milktea ON tbl_reports.m_id = tbl_milktea.m_id LEFT JOIN tbl_cashier ON tbl_reports.c_id = tbl_cashier.c_id");
            reports.setModel(DbUtils.resultSetToTableModel(rs));
       
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reports = new javax.swing.JTable();
        display = new javax.swing.JButton();
        display1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REPORTS");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 20, 150, 40);

        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(reports);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 90, 710, 260);

        display.setBackground(new java.awt.Color(0, 204, 204));
        display.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        display.setText("PRINT REPORTS");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });
        jPanel1.add(display);
        display.setBounds(600, 370, 130, 40);

        display1.setBackground(new java.awt.Color(0, 204, 204));
        display1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        display1.setText("DISPLAY");
        display1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display1ActionPerformed(evt);
            }
        });
        jPanel1.add(display1);
        display1.setBounds(480, 370, 110, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        MessageFormat header = new MessageFormat("M AND M MILKTEA TRACKER");
        MessageFormat footer = new MessageFormat("MILKTEA SALES TRACKER REPORTS");
        try{
            reports.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(PrinterException e){
            JOptionPane.showMessageDialog(null, "Cannot be print!"+e.getMessage());
        }

    }//GEN-LAST:event_displayActionPerformed

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
        
    }//GEN-LAST:event_reportsMouseClicked

    private void display1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display1ActionPerformed
        displayData();
    }//GEN-LAST:event_display1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton display;
    private javax.swing.JButton display1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable reports;
    // End of variables declaration//GEN-END:variables
}
