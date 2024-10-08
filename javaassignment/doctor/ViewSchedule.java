/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaassignment.doctor;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewSchedule extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Email", "Name", "Date", "Start Time", "End Time"};
    private int row = -1;
    
    public ViewSchedule()throws IOException{
        model.setColumnIdentifiers(columnName);
        try{
            FileReader fr = new FileReader("src\\textfiles\\schedule.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line = null;
            while((line = br.readLine()) != null){
                String values[] = line.split(", ");
                model.addRow(values);                
            }
        }
        catch (IOException e){
            
        }       
        
        initComponents();
    }
        public void clearTextField() {
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }
    
    private void savetoFile() {
        savetoFile("src\\textfiles\\schedule.txt");
    }

    private void savetoFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) bw.write(", ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing to schedule file.");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 92, -1, 288));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("VIEW SCHEDULE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 35, -1, -1));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 405, -1, -1));

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 434, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 463, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 100, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 464, 95, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 100, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 398, 95, -1));

        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 401, -1, -1));

        jLabel3.setText("Email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        jLabel4.setText("Time");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 438, -1, -1));

        jLabel5.setText("Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 504, 95, -1));

        jLabel6.setText("Start");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 467, -1, -1));

        jLabel7.setText("End");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 507, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 35, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/doctor-schedulebg.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        row = jTable1.getSelectedRow();

        if (row != -1) {
            DoctorSchedule doctorSchedule = new DoctorSchedule(
                String.valueOf(model.getValueAt(row, 0)),
                String.valueOf(model.getValueAt(row, 1)),
                String.valueOf(model.getValueAt(row, 2)),
                String.valueOf(model.getValueAt(row, 3)),
                String.valueOf(model.getValueAt(row, 4))
            );

            jTextField1.setText(doctorSchedule.getEmail());
            jTextField2.setText(doctorSchedule.getDoctorName());
            jTextField3.setText(doctorSchedule.getDate());
            jTextField4.setText(doctorSchedule.getStartTime());
            jTextField5.setText(doctorSchedule.getEndTime());
        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = jTextField1.getText();
        String doctorName = jTextField2.getText();
        String date = jTextField3.getText();
        String startTime = jTextField4.getText();
        String endTime = jTextField5.getText();

        // Check if any of the text fields are empty
        if (email.isEmpty() || doctorName.isEmpty() || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        } else {
            DoctorSchedule doctorSchedule = new DoctorSchedule(email, doctorName, date, startTime, endTime);

            String scheduleRow[] = {
                doctorSchedule.getEmail(),
                doctorSchedule.getDoctorName(),
                doctorSchedule.getDate(),
                doctorSchedule.getStartTime(),
                doctorSchedule.getEndTime()
            };

            model.addRow(scheduleRow);

            savetoFile();
            clearTextField();
            JOptionPane.showMessageDialog(this, "Schedule uploaded successfully!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DoctorMenu menu = new DoctorMenu();
        menu.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        row = jTable1.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to edit");
        } else {
            String email = jTextField1.getText();
            String doctorName = jTextField2.getText();
            String date = jTextField3.getText();
            String startTime = jTextField4.getText();
            String endTime = jTextField5.getText();

            // Check if any of the text fields are empty
            if (email.isEmpty() || doctorName.isEmpty() || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } else {
                DoctorSchedule doctorSchedule = new DoctorSchedule(email, doctorName, date, startTime, endTime);

                model.setValueAt(doctorSchedule.getEmail(), row, 0);
                model.setValueAt(doctorSchedule.getDoctorName(), row, 1);
                model.setValueAt(doctorSchedule.getDate(), row, 2);
                model.setValueAt(doctorSchedule.getStartTime(), row, 3);
                model.setValueAt(doctorSchedule.getEndTime(), row, 4);

                savetoFile();
                clearTextField();
                JOptionPane.showMessageDialog(this, "Schedule edited successfully!");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Please select a row to delete ");
        }
        else{
            int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm Deletion", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION){
            model.removeRow(row);
            row = -1;
            savetoFile();
            clearTextField();
             JOptionPane.showMessageDialog(this, "Schedule deleted successfully!");
            }
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewSchedule().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
