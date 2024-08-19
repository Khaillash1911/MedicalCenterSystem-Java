/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.admin;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DoctorManager {
    private DefaultTableModel model;
    private String[] columnName = {"Full Name", "Email", "Password", "Specialty"};
    
    public DoctorManager(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnName);
        loadFromFile();
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
    
    public void loadFromFile(){
        try{
            FileReader fr = new FileReader("src\\textfiles\\doctor.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(", ");
                model.addRow(values);
            }
            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void addDoctor(String doctorName, String doctorMail, String doctorPass, String doctorSpecialty ){
        boolean emailExists = false;

        
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).equals(doctorMail)) {
                emailExists = true;
                break;
            }
        }

        if (emailExists) {
            JOptionPane.showMessageDialog(null, "Doctor with this email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Proceed with adding the new doctor
            String[] doctorRow = {doctorName, doctorMail, doctorPass, doctorSpecialty};
            model.addRow(doctorRow);
            saveToFile();
        }
    }
    
    public void editDoctor(int row, String doctorName, String doctorMail, String doctorPass, String doctorSpecialty ){
        boolean emailExists = false;

        // Check if the email already exists in another row
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i != row && model.getValueAt(i, 1).equals(doctorMail)) {
                emailExists = true;
                break; // Exit the loop once a duplicate is found
            }
        }

        if (emailExists) {
            // Show error message if email already exists
            JOptionPane.showMessageDialog(null, "Doctor with this email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Proceed with updating the doctor details
            String[] doctorValues = {doctorName, doctorMail, doctorPass, doctorSpecialty};
            model.removeRow(row);
            model.insertRow(row, doctorValues);
            saveToFile();
        }   
    }
    
    public void deleteDoctor(int row){
        if(row != 1){
            model.removeRow(row);
            saveToFile();
        }
    }
    
    private void saveToFile() {
        try {
            FileWriter fw = new FileWriter("src\\textfiles\\doctor.txt");
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
        }
    }
}
